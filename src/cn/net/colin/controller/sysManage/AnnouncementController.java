package cn.net.colin.controller.sysManage;

import cn.net.colin.common.utils.SnowflakeIdWorker;
import cn.net.colin.entity.exception.ApiResult;
import cn.net.colin.entity.exception.ResultCode;
import cn.net.colin.entity.sysManage.*;
import cn.net.colin.service.sysManage.AnnouncementInfoService;
import cn.net.colin.ws.BWS;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping("/announcement")
public class AnnouncementController {
    private static final Logger logger= LogManager.getLogger(AnnouncementController.class);

    @Autowired
    private AnnouncementInfoService announcementInfoService;

    @GetMapping("/announcementInfoList")
    public String announcementInfoList(){
        return "sysManage/announcementInfo/announcementInfoList";
    }

    /**
     * 返回公告信息列表
     * @param paramMap
     *      announcementContent 公告内容（模糊查询）
     * @return ResultInfo 自定义结果返回实体类
     * @throws IOException
     */
    @GetMapping("/announcementInfoDataList")
    @ResponseBody
    public ApiResult announcementInfoList(@RequestParam Map<String,Object> paramMap) throws IOException {
        int pageNum = paramMap.get("page") == null ? 1 : Integer.parseInt(paramMap.get("page").toString());
        int pageSize = paramMap.get("limit") == null ? 10 : Integer.parseInt(paramMap.get("limit").toString());
        AnnouncementInfoCriteria announcementInfoCriteria = new AnnouncementInfoCriteria();
        announcementInfoCriteria.setOrderByClause("announcement_date desc");
        AnnouncementInfoCriteria.Criteria criteria = announcementInfoCriteria.createCriteria();
        if(paramMap.get("announcementContent") != null){
            criteria.andAnnouncementContentLike("%" + paramMap.get("announcementContent").toString().trim() + "%");
        }
        PageHelper.startPage(pageNum,pageSize);
        List<AnnouncementInfo> announcementList = announcementInfoService.selectByExample(announcementInfoCriteria);
        PageInfo pageInfo = new PageInfo(announcementList);
        return ApiResult.ofDataAndTotal(ResultCode.SUCCESS,announcementList,pageInfo.getTotal());
    }

    /**
     * 跳转到公告添加页面
     * @return
     */
    @GetMapping("/announcement")
    public String announcement(){
        return "sysManage/announcementInfo/announcementSaveOrUpdate";
    }

    /**
     * 添加公告
     * @param announcementInfo
     * @return
     */
    @PostMapping("/announcement")
    @ResponseBody
    public ApiResult saveAnnouncement(AnnouncementInfo announcementInfo, HttpServletRequest request){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime nowTime = LocalDateTime.now();
        announcementInfo.setAnnouncementId(String.valueOf(SnowflakeIdWorker.generateId()));
        announcementInfo.setAnnouncementDate(nowTime.format(formatter));
        if(request.getSession().getAttribute("user") != null){
            AdministratorInfo administratorInfo  = (AdministratorInfo) request.getSession().getAttribute("user");
            announcementInfo.setPublisherId(administratorInfo.getAdminId());
        }
        int num = announcementInfoService.insertSelective(announcementInfo);
        ApiResult resultInfo = ApiResult.of(ResultCode.UNKNOWN_ERROR);
        if(num > 0){
            ConcurrentHashMap<String, Session> sessionMap =  BWS.mapUS;
            for (Session session : sessionMap.values()) {
                session.getAsyncRemote().sendText(announcementInfo.getAnnouncementContent());
            }
            resultInfo = ApiResult.of(ResultCode.SUCCESS);
        }
        return resultInfo;
    }

    /**
     * 跳转到公告编辑页面
     * @return
     */
    @GetMapping("/announcement/{announcementId}")
    public String realName(@PathVariable("announcementId") String announcementId, Map<String,Object> modelMap){
        AnnouncementInfo announcementInfo = announcementInfoService.selectByPrimaryKey(announcementId);
        modelMap.put("announcementInfo",announcementInfo);
        return "sysManage/announcementInfo/announcementSaveOrUpdate";
    }
    /**
     * 更新公告信息
     * @param announcementInfo
     * @return
     */
    @PutMapping("/announcement")
    @ResponseBody
    public ApiResult updateRealName(AnnouncementInfo announcementInfo){
        int num = announcementInfoService.updateByPrimaryKeySelective(announcementInfo);
        ApiResult resultInfo = ApiResult.of(ResultCode.UNKNOWN_ERROR);
        if(num > 0){
            ConcurrentHashMap<String, Session> sessionMap =  BWS.mapUS;
            for (Session session : sessionMap.values()) {
                session.getAsyncRemote().sendText(announcementInfo.getAnnouncementContent());
            }
            resultInfo = ApiResult.of(ResultCode.SUCCESS);
        }
        return resultInfo;
    }

    /**
     * 根据id集合，删除公告
     * @return
     */
    @DeleteMapping("/announcement/{announcementIds}")
    @ResponseBody
    public ApiResult deleteRealName(@PathVariable("announcementIds") String [] announcementIds){
        AnnouncementInfoCriteria announcementInfoCriteria = new AnnouncementInfoCriteria();
        AnnouncementInfoCriteria.Criteria criteria = announcementInfoCriteria.createCriteria();
        criteria.andAnnouncementIdIn(Arrays.asList(announcementIds));
        int num = announcementInfoService.deleteByExample(announcementInfoCriteria);
        ApiResult resultInfo = ApiResult.of(ResultCode.UNKNOWN_ERROR);
        if(num > 0){
            resultInfo = ApiResult.of(ResultCode.SUCCESS);
        }
        return resultInfo;
    }
}
