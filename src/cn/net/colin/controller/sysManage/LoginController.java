package cn.net.colin.controller.sysManage;

import cn.net.colin.entity.exception.ApiResult;
import cn.net.colin.entity.exception.ResultCode;
import cn.net.colin.entity.sysManage.AdministratorInfo;
import cn.net.colin.entity.sysManage.AdministratorInfoCriteria;
import cn.net.colin.entity.sysManage.UserInfo;
import cn.net.colin.entity.sysManage.UserInfoCriteria;
import cn.net.colin.service.sysManage.AdministratorInfoService;
import cn.net.colin.service.sysManage.UserInfoService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class LoginController {

	private static final Logger logger= LogManager.getLogger(LoginController.class);

	@Autowired
	private AdministratorInfoService administratorInfoService;


	@RequestMapping("/tologin")
	public String goLogin(HttpServletRequest request) {
		return "/login/login";	
	}
	
	@RequestMapping(value="/login")
	public String doLogin(HttpServletRequest request) {
	    String targetPage = "/login/login";
		logger.info("LoginContrller,doLogin,into doLogin Menthod");
		String  loginId= request.getParameter("userName");
		String  loginPwd= request.getParameter("userPsw");
		ApiResult result = new ApiResult();
		if(loginId.isEmpty()) {
			//用户名不能为空！
            request.setAttribute("msg",ResultCode.USERNAME_EMPTY.getMsg());
		}
		if(!loginPwd.isEmpty()) {
			AdministratorInfoCriteria administratorInfoCriteria = new AdministratorInfoCriteria();
			AdministratorInfoCriteria.Criteria criteria = administratorInfoCriteria.createCriteria();
			criteria.andAdminIdEqualTo(loginId);
			criteria.andAdminPswEqualTo(loginPwd);
			List<AdministratorInfo> administratorInfoList = administratorInfoService.selectByExample(administratorInfoCriteria);
			if(administratorInfoList != null && administratorInfoList.size() > 0){
				//将用户存入SEESION
				HttpSession session = request.getSession();
				session.setAttribute("user", administratorInfoList.get(0));
                targetPage = "redirect:/user/main";
			}else{
				request.setAttribute("msg",ResultCode.LOGIN_ERROR.getMsg());
			}
		}else{
			//密码不能为空
            request.setAttribute("msg",ResultCode.PASSWORD_EMPTY.getMsg());
		}
		logger.info("LoginContrller,doLogin,out doLogin Menthod");
		return targetPage;
	}

	/***
	 * 进入主页面
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/main")
	public Object main(HttpServletRequest request, Model model) {
		logger.info("ReceiveController, main,into main Menthod");
		try {
			String identifier = UUID.randomUUID().toString().replace("-", "");
			model.addAttribute("identifier",identifier);
		} catch (Exception e) {
			logger.error("ReceiveController, main, error:"+e.getMessage());
			return ResultCode.UNKNOWN_ERROR.getMsg();
		}
		return "main";
	}

	@RequestMapping(value="/loginOut")
	public String loginOUt(HttpServletRequest request) {
		logger.info("UserContrller,loginOut,into loginOut Menthod");
		/*HttpSession session = request.getSession();
		session.removeAttribute("user");*/
		return "login/login";
	}

}
