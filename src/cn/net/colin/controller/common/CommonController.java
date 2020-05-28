package cn.net.colin.controller.common;

import cn.net.colin.entity.exception.ApiResult;
import cn.net.colin.entity.exception.ResultCode;
import cn.net.colin.service.common.ICommonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 公共调用controller
 */
@Controller
@RequestMapping("/common")
public class CommonController {

    @Resource
    private ICommonService iCommonService;

    /**
     * 录入页面数据不重复校验
     * @param request id:区分新增和更新,val:校验值, code:校验字段, tableName:校验数据库表名
     * @return
     */
    @RequestMapping("fromVerifyCode")
    @ResponseBody
    public Object fromVerifyCode(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        map.put("id",request.getParameter("id"));
        map.put("tableColumn",request.getParameter("tableColumn"));
        map.put("val",request.getParameter("val"));
        map.put("code",request.getParameter("code"));
        map.put("tableName",request.getParameter("tableName"));
        boolean flag = iCommonService.fromVerifyByCode(map);
        if(flag){
            return ApiResult.of(ResultCode.SUCCESS);
        }
        return ApiResult.of(ResultCode.FAILED);
    }

}
