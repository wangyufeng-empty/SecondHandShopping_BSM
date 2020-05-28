package cn.net.colin.controller.sysManage;

import cn.net.colin.common.utils.BeanAndMapUtils;
import cn.net.colin.common.utils.ExcelExportSXXSSF;
import cn.net.colin.entity.exception.ApiResult;
import cn.net.colin.entity.exception.ResultCode;
import cn.net.colin.entity.sysManage.RealName;
import cn.net.colin.entity.sysManage.RealNameCriteria;
import cn.net.colin.entity.sysManage.UserInfo;
import cn.net.colin.entity.sysManage.UserInfoCriteria;
import cn.net.colin.service.sysManage.RealNameService;
import cn.net.colin.service.sysManage.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
@RequestMapping("/userInfo")
public class UserManageController {
	private static final Logger logger= LogManager.getLogger(UserManageController.class);

	@Autowired
	private UserInfoService userInfoService;

    @Autowired
	private RealNameService realNameService;

	@GetMapping("/userInfoList")
	public String userInfoList(){
		return "sysManage/userInfo/userInfoList";
	}

	/**
	 * 返回用户信息列表
	 * @param paramMap
	 *      userName 用户名字（模糊查询）
     *      userSex 性别
     *      userGrade 年级
     *      userTel 电话号码
	 * @return ResultInfo 自定义结果返回实体类
	 * @throws IOException
	 */
	@GetMapping("/userInfoDataList")
	@ResponseBody
	public ApiResult userList(@RequestParam Map<String,Object> paramMap) throws IOException {
		int pageNum = paramMap.get("page") == null ? 1 : Integer.parseInt(paramMap.get("page").toString());
		int pageSize = paramMap.get("limit") == null ? 10 : Integer.parseInt(paramMap.get("limit").toString());
		UserInfoCriteria userInfoCriteria = new UserInfoCriteria();
		userInfoCriteria.setOrderByClause("user_grade desc,user_id desc");
		UserInfoCriteria.Criteria criteria = userInfoCriteria.createCriteria();
		if(paramMap.get("userName") != null){
			criteria.andUserNameLike("%" + paramMap.get("userName").toString().trim() + "%");
		}
        if(paramMap.get("userSex") != null){
            criteria.andUserSexEqualTo(paramMap.get("userSex").toString().trim());
        }
        if(paramMap.get("userGrade") != null){
            criteria.andUserGradeEqualTo(paramMap.get("userGrade").toString().trim());
        }
        if(paramMap.get("userTel") != null){
            criteria.andUserTelEqualTo(paramMap.get("userTel").toString().trim());
        }
		PageHelper.startPage(pageNum,pageSize);
		List<UserInfo> userList = userInfoService.selectByExample(userInfoCriteria);
		PageInfo pageInfo = new PageInfo(userList);
		return ApiResult.ofDataAndTotal(ResultCode.SUCCESS,userList,pageInfo.getTotal());
	}

    /**
     * 跳转到用户添加页面
     * @return
     */
    @GetMapping("/user")
    public String user(){
        return "sysManage/userInfo/userSaveOrUpdate";
    }

    /**
     * 添加用户
     * @param userInfo
     * @return
     */
    @PostMapping("/user")
    @ResponseBody
    public ApiResult saveUser(UserInfo userInfo){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime nowTime = LocalDateTime.now();
        userInfo.setRegisterTime(nowTime.format(formatter));
        int num = userInfoService.insertSelective(userInfo);
        ApiResult resultInfo = ApiResult.of(ResultCode.UNKNOWN_ERROR);
        if(num > 0){
            resultInfo = ApiResult.of(ResultCode.SUCCESS);
        }
        return resultInfo;
    }

    /**
     * 跳转到用户编辑页面
     * @return
     */
    @GetMapping("/user/{userId}")
    public String user(@PathVariable("userId") String userId, Map<String,Object> modelMap){
        UserInfo userInfo = userInfoService.selectByPrimaryKey(userId);
        modelMap.put("userInfo",userInfo);
        return "sysManage/userInfo/userSaveOrUpdate";
    }

    /**
     * 更新用户信息
     * @param userInfo
     * @return
     */
    @PutMapping("/user")
    @ResponseBody
    public ApiResult updateUser(UserInfo userInfo){
        int num = userInfoService.updateByPrimaryKey(userInfo);
        ApiResult resultInfo = ApiResult.of(ResultCode.UNKNOWN_ERROR);
        if(num > 0){
            resultInfo = ApiResult.of(ResultCode.SUCCESS);
        }
        return resultInfo;
    }

    /**
     * 根据id集合，删除用户
     * @return
     */
    @DeleteMapping("/user/{userIds}")
    @ResponseBody
    public ApiResult deleteUser(@PathVariable("userIds") String [] userIds){
        UserInfoCriteria userInfoCriteria = new UserInfoCriteria();
        UserInfoCriteria.Criteria criteria = userInfoCriteria.createCriteria();
        criteria.andUserIdIn(Arrays.asList(userIds));
        int num = userInfoService.deleteByExample(userInfoCriteria);
        ApiResult resultInfo = ApiResult.of(ResultCode.UNKNOWN_ERROR);
        if(num > 0){
            resultInfo = ApiResult.of(ResultCode.SUCCESS);
        }
        return resultInfo;
    }

    /**
     * 用户信息导出Excel
     * @param map
     *      userName 用户名字（模糊查询）
     *      userSex 性别
     *      userGrade 年级
     *      userTel 电话号码
     * @param request
     * @param response
     */
    @RequestMapping("/exportExcel")
    public void exportExcel(@RequestParam Map<String,Object> map, HttpServletRequest request, HttpServletResponse response){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        try {
            logger.info("UserManageContrller, exportExcel,into exportExcel Menthod");
            UserInfoCriteria userInfoCriteria = new UserInfoCriteria();
            userInfoCriteria.setOrderByClause("user_grade desc,user_id desc");
            UserInfoCriteria.Criteria criteria = userInfoCriteria.createCriteria();
            String userName = map.get("userName") == null ? null : URLDecoder.decode(map.get("userName").toString().trim(),"UTF-8");
            String userSex = map.get("userSex") == null ? null : URLDecoder.decode(map.get("userSex").toString().trim(),"UTF-8");
            String userGrade = map.get("userGrade") == null ? null : URLDecoder.decode(map.get("userGrade").toString().trim(),"UTF-8");
            String userTel = map.get("userTel") == null ? null : map.get("userTel").toString().trim();
            if(userName != null){
                criteria.andUserNameLike("%" + userName + "%");
            }
            if(userSex != null){
                criteria.andUserSexEqualTo(userSex);
            }
            if(userGrade != null){
                criteria.andUserGradeEqualTo(userGrade);
            }
            if(userTel != null){
                criteria.andUserTelEqualTo(userTel);
            }
            List<UserInfo> userList = userInfoService.selectByExample(userInfoCriteria);
            List<Map<String,Object>> dataList = BeanAndMapUtils.objectsToMaps(userList);

            List<String> fieldCodes = listFieldCodesWithUserInfo();
            List<String> fieldNames = listFieldNamesWithUserInfo();
            String filePrefix = "UserInfo";
            // 开始导出，执行一些workbook及sheet等对象的初始创建
            ExcelExportSXXSSF excelExportSXXSSF = ExcelExportSXXSSF.start(
                    "", filePrefix, fieldNames, fieldCodes, 100, dataList, 50000);
            LocalDateTime currentTime = LocalDateTime.now();
            // 设置文件名
            String filename = "用户信息"+currentTime.format(formatter)+".xlsx";
            filename = new String(filename.getBytes("gbk"), "iso-8859-1");
            response.reset();
            // 设置头信息
            // response.setContentType("application/vnd.ms-excel");//导出excel2003
            response.setContentType("application/x-xlsx");// 导出excel2007
            response.setHeader("Content-disposition", "attachement;filename="
                    + filename);
            response.setBufferSize(1024);
            excelExportSXXSSF.exportFile(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("UserManageContrller, exportExcel, error", e);
        }
    }


    /**
     * excel导出类数据list中Map的key
     * @return
     */
    public List<String> listFieldCodesWithUserInfo(){
        List<String> fieldCodes = new ArrayList<String>();
        fieldCodes.add("userId");
        fieldCodes.add("userName");
        fieldCodes.add("userSex");
        fieldCodes.add("userGrade");
        fieldCodes.add("userTel");
        fieldCodes.add("userEmail");
        return fieldCodes;
    }

    /**
     * excel导出数据的title
     * @return
     */
    public List<String> listFieldNamesWithUserInfo(){
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("学号");
        fieldNames.add("姓名");
        fieldNames.add("性别");
        fieldNames.add("年级");
        fieldNames.add("电话号码");
        fieldNames.add("邮箱");
        return fieldNames;
    }


    /**
     * 跳转到实名库列表页面
     * @return
     */
    @GetMapping("/realNameList")
    public String realNameList(){
        return "sysManage/userInfo/realNameList";
    }

    /**
     * 返回实名库列表
     * @param paramMap
     *      studentName 姓名（模糊查询）
     *      studentId 学号
     * @return ResultInfo 自定义结果返回实体类
     * @throws IOException
     */
    @GetMapping("/realNameDataList")
    @ResponseBody
    public ApiResult realNameDataList(@RequestParam Map<String,Object> paramMap) throws IOException {
        int pageNum = paramMap.get("page") == null ? 1 : Integer.parseInt(paramMap.get("page").toString());
        int pageSize = paramMap.get("limit") == null ? 10 : Integer.parseInt(paramMap.get("limit").toString());
        RealNameCriteria realNameCriteria = new RealNameCriteria();
        realNameCriteria.setOrderByClause("student_id desc");
        RealNameCriteria.Criteria criteria = realNameCriteria.createCriteria();
        if(paramMap.get("studentName") != null){
            criteria.andStudentNameLike("%" + paramMap.get("studentName").toString().trim() + "%");
        }
        if(paramMap.get("studentId") != null){
            criteria.andStudentIdEqualTo(paramMap.get("studentId").toString().trim());
        }
        PageHelper.startPage(pageNum,pageSize);
        List<RealName> userList = realNameService.selectByExample(realNameCriteria);
        PageInfo pageInfo = new PageInfo(userList);
        return ApiResult.ofDataAndTotal(ResultCode.SUCCESS,userList,pageInfo.getTotal());
    }

    /**
     * 跳转到用户添加页面
     * @return
     */
    @GetMapping("/realName")
    public String realName(){
        return "sysManage/userInfo/realNameSaveOrUpdate";
    }

    /**
     * 添加用户
     * @param realName
     * @return
     */
    @PostMapping("/realName")
    @ResponseBody
    public ApiResult saveRealName(RealName realName){
        int num = realNameService.insertSelective(realName);
        ApiResult resultInfo = ApiResult.of(ResultCode.UNKNOWN_ERROR);
        if(num > 0){
            resultInfo = ApiResult.of(ResultCode.SUCCESS);
        }
        return resultInfo;
    }

    /**
     * 跳转到用户编辑页面
     * @return
     */
    @GetMapping("/realName/{studentId}")
    public String realName(@PathVariable("studentId") String studentId, Map<String,Object> modelMap){
        RealName realName = realNameService.selectByPrimaryKey(studentId);
        modelMap.put("realName",realName);
        return "sysManage/userInfo/realNameSaveOrUpdate";
    }
    /**
     * 更新用户信息
     * @param realName
     * @return
     */
    @PutMapping("/realName")
    @ResponseBody
    public ApiResult updateRealName(RealName realName){
        int num = realNameService.updateByPrimaryKeySelective(realName);
        ApiResult resultInfo = ApiResult.of(ResultCode.UNKNOWN_ERROR);
        if(num > 0){
            resultInfo = ApiResult.of(ResultCode.SUCCESS);
        }
        return resultInfo;
    }

    /**
     * 根据id集合，删除实名记录
     * @return
     */
    @DeleteMapping("/realName/{studentIds}")
    @ResponseBody
    public ApiResult deleteRealName(@PathVariable("studentIds") String [] studentIds){
        RealNameCriteria realNameCriteria = new RealNameCriteria();
        RealNameCriteria.Criteria criteria = realNameCriteria.createCriteria();
        criteria.andStudentIdIn(Arrays.asList(studentIds));
        int num = realNameService.deleteByExample(realNameCriteria);
        ApiResult resultInfo = ApiResult.of(ResultCode.UNKNOWN_ERROR);
        if(num > 0){
            resultInfo = ApiResult.of(ResultCode.SUCCESS);
        }
        return resultInfo;
    }

    /**
     * 实名库导出Excel
     * @param map
     *      studentName 姓名（模糊查询）
     *      studentId 学号
     * @param request
     * @param response
     */
    @RequestMapping("/exportRealNameExcel")
    public void exportRealNameExcel(@RequestParam Map<String,Object> map, HttpServletRequest request, HttpServletResponse response){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        try {
            logger.info("UserManageContrller, exportRealNameExcel,into exportRealNameExcel Menthod");
            RealNameCriteria realNameCriteria = new RealNameCriteria();
            realNameCriteria.setOrderByClause("student_id desc");
            RealNameCriteria.Criteria criteria = realNameCriteria.createCriteria();
            String studentName = map.get("studentName") == null ? null : URLDecoder.decode(map.get("studentName").toString().trim(),"UTF-8");
            String studentId = map.get("studentId") == null ? null : map.get("studentId").toString().trim();
            if(studentName != null){
                criteria.andStudentNameLike("%" + studentName + "%");
            }
            if(studentId != null){
                criteria.andStudentIdEqualTo(studentId);
            }
            List<RealName> userList = realNameService.selectByExample(realNameCriteria);
            List<Map<String,Object>> dataList = BeanAndMapUtils.objectsToMaps(userList);

            List<String> fieldCodes = listFieldCodesWithRealName();
            List<String> fieldNames = listFieldNamesWithRealName();
            String filePrefix = "RealNameInfo";
            // 开始导出，执行一些workbook及sheet等对象的初始创建
            ExcelExportSXXSSF excelExportSXXSSF = ExcelExportSXXSSF.start(
                    "", filePrefix, fieldNames, fieldCodes, 100, dataList, 50000);
            LocalDateTime currentTime = LocalDateTime.now();
            // 设置文件名
            String filename = "实名库信息"+currentTime.format(formatter)+".xlsx";
            filename = new String(filename.getBytes("gbk"), "iso-8859-1");
            response.reset();
            // 设置头信息
            // response.setContentType("application/vnd.ms-excel");//导出excel2003
            response.setContentType("application/x-xlsx");// 导出excel2007
            response.setHeader("Content-disposition", "attachement;filename="
                    + filename);
            response.setBufferSize(1024);
            excelExportSXXSSF.exportFile(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("UserManageContrller, exportRealNameExcel, error", e);
        }
    }
    /**
     * excel导出类数据list中Map的key
     * @return
     */
    public List<String> listFieldCodesWithRealName(){
        List<String> fieldCodes = new ArrayList<String>();
        fieldCodes.add("studentId");
        fieldCodes.add("studentName");
        return fieldCodes;
    }

    /**
     * excel导出数据的title
     * @return
     */
    public List<String> listFieldNamesWithRealName(){
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("学号");
        fieldNames.add("姓名");
        return fieldNames;
    }

    /**
     * Excel导入实名库
     * 传入文件
     * @param file
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/importRealName")
    @ResponseBody
    public ApiResult importRealName(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception{
        ApiResult resultInfo = ApiResult.of(ResultCode.UNKNOWN_ERROR);
        try {
            logger.info("UserManageContrller, importRealName, into importRealName Menthod");
            if(file == null){
                System.out.println("文件为空!");
                return  ApiResult.of(ResultCode.UNKNOWN_ERROR);
            }
            Map<String,Object> resultMap = realNameService.importRealName(file,request);
            if(resultMap != null && resultMap.get("saveNum") != null){
                resultInfo = ApiResult.of(ResultCode.SUCCESS);
            }
        } catch (Exception e) {
            logger.error("UserManageContrller, importRealName, error", e);
            return ApiResult.of(ResultCode.UNKNOWN_ERROR);
        }
        return  resultInfo;
    }
}
