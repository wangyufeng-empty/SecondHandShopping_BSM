package cn.net.colin.controller.sysManage;

import cn.net.colin.entity.exception.ApiResult;
import cn.net.colin.entity.exception.ResultCode;
import cn.net.colin.entity.sysManage.*;
import cn.net.colin.service.sysManage.HistoryorderInfoService;
import cn.net.colin.service.sysManage.OrderInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/orderInfo")
public class OrderInfoController {
    private static final Logger logger= LogManager.getLogger(OrderInfoController.class);

    @Autowired
    private OrderInfoService orderInfoService;

    @Autowired
    private HistoryorderInfoService historyorderInfoService;

    @GetMapping("/orderInfoList")
    public String orderInfoList(){
        return "sysManage/orderInfo/orderInfoList";
    }

    /**
     * 返回公告信息列表
     * @param paramMap
     *      userId 学号
     *      orderId 订单号
     *      consignee 收货人姓名
     *      telNum 收货人电话
     *
     * @return ResultInfo 自定义结果返回实体类
     * @throws IOException
     */
    @GetMapping("/orderInfoListDataList")
    @ResponseBody
    public ApiResult orderInfoListDataList(@RequestParam Map<String,Object> paramMap) throws IOException {
        int pageNum = paramMap.get("page") == null ? 1 : Integer.parseInt(paramMap.get("page").toString());
        int pageSize = paramMap.get("limit") == null ? 10 : Integer.parseInt(paramMap.get("limit").toString());
        OrderInfoCriteria orderInfoCriteria = new OrderInfoCriteria();
        orderInfoCriteria.setOrderByClause("order_time desc");
        OrderInfoCriteria.Criteria criteria = orderInfoCriteria.createCriteria();
        if(paramMap.get("userId") != null){
            criteria.andUserIdEqualTo(paramMap.get("userId").toString().trim());
        }
        if(paramMap.get("orderId") != null){
            criteria.andOrderIdEqualTo(paramMap.get("orderId").toString().trim());
        }
        if(paramMap.get("consignee") != null){
            criteria.andConsigneeLike("%" + paramMap.get("consignee").toString().trim() + "%");
        }
        if(paramMap.get("telNum") != null){
            criteria.andTelNumEqualTo(paramMap.get("telNum").toString().trim());
        }
        PageHelper.startPage(pageNum,pageSize);
        List<OrderInfo> orderInfoList = orderInfoService.selectByExample(orderInfoCriteria);
        PageInfo pageInfo = new PageInfo(orderInfoList);
        return ApiResult.ofDataAndTotal(ResultCode.SUCCESS,orderInfoList,pageInfo.getTotal());
    }

    /**
     * 跳转到订单详情页面
     * @return
     */
    @GetMapping("/orderInfoDetai/{userId}/{orderId}")
    public String orderInfoDetai(@PathVariable("userId") String userId,@PathVariable("orderId") String orderId, Map<String,Object> modelMap){
        OrderInfoKey orderInfoKey = new OrderInfoKey();
        orderInfoKey.setUserId(userId);
        orderInfoKey.setOrderId(orderId);
        OrderInfo orderInfo = orderInfoService.selectByPrimaryKey(orderInfoKey);
        HistoryorderInfoCriteria historyorderInfoCriteria = new HistoryorderInfoCriteria();
        historyorderInfoCriteria.setOrderByClause("`id-auto` desc");
        HistoryorderInfoCriteria.Criteria criteria = historyorderInfoCriteria.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        List<HistoryorderInfo> historyorderInfoList = historyorderInfoService.selectByExample(historyorderInfoCriteria);
        orderInfo.setHistoryorderInfoList(historyorderInfoList);
        modelMap.put("orderInfo",orderInfo);
        return "sysManage/orderInfo/orderInfoDetail";
    }
}
