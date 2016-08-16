package com.qcacg.controller.system;

import com.fasterxml.jackson.annotation.JsonView;
import com.qcacg.constant.LoginConstant;
import com.qcacg.entity.ResourcesEntity;
import com.qcacg.entity.UserEntity;
import com.qcacg.service.system.ResourcesService;
import com.qcacg.service.system.RoleService;
import com.qcacg.service.system.UserService;
import com.qcacg.util.Result;
import com.qcacg.util.TreeUtil;
import com.qcacg.util.UserEntityUtil;
import com.qcacg.util.Views;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LoginController {
	@Autowired
	ResourcesService resourcesService;
	@Autowired
	RoleService roleService;
	@Autowired
	UserService userService;

	Result result = new Result();
	@JsonView(Views.Public.class)
	@RequestMapping(value = "login")
	public Result login(HttpServletRequest request) {

		if(request.getParameter("forceLogout") != null)
		{
//		    request.setAttribute("LOGIN_ERROR_CODE", LoginConstant.LOGIN_ERROR_CODE_100004);
//		    request.setAttribute("LOGIN_ERROR_MESSAGE", LoginConstant.LOGIN_ERROR_MESSAGE_FORCELOGOUT);
			result.setSuccess(false);
			result.setCode(LoginConstant.LOGIN_ERROR_CODE_100004);
			result.setMsg(LoginConstant.LOGIN_ERROR_MESSAGE_FORCELOGOUT);
		}


		return result;

	}
	@JsonView(Views.Public.class)
	@RequestMapping("main")
	public Result main() {
//		return "main";
		result.setSuccess(true);
		return result;
	}

	@RequestMapping("index")
	public Result index(Model model) {
		UserEntity infoForm = UserEntityUtil.getUserFromSession();
		String userId = String.valueOf(infoForm.getUserId());
		if (StringUtils.isNotBlank(userId)) {
			Map<String, String> queryMap = new HashMap<String, String>();
			queryMap.put("userId", userId);
			List<ResourcesEntity> resourceForms = resourcesService.findResourcessByMap(queryMap);
			List<ResourcesEntity> ns = TreeUtil.getChildResourceForms(resourceForms, 0);
			model.addAttribute("list", ns);
		}
		// 登陆的信息回传页面
//		return "index";
		result.setSuccess(true);
		return result;
	}
	@JsonView(Views.Public.class)
	@RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Result login( UserEntity user) {


		// 想要得到 SecurityUtils.getSubject() 的对象．．访问地址必须跟shiro的拦截地址内．不然后会报空指针
		Subject sub = SecurityUtils.getSubject();
		// 用户输入的账号和密码,,存到UsernamePasswordToken对象中..然后由shiro内部认证对比,
		// 认证执行者交由ShiroDbRealm中doGetAuthenticationInfo处理
		// 当以上认证成功后会向下执行,认证失败会抛出异常
		UsernamePasswordToken token = new UsernamePasswordToken(user.getTelephone(), user.getPassWord());
		try {
			sub.login(token);
		} catch (LockedAccountException lae) {
			token.clear();
//			request.setAttribute("LOGIN_ERROR_CODE", LoginConstant.LOGIN_ERROR_CODE_100002);
//			request.setAttribute("LOGIN_ERROR_MESSAGE", LoginConstant.LOGIN_ERROR_MESSAGE_SYSTEMERROR);
//			return "login";
			result.setCode(LoginConstant.LOGIN_ERROR_CODE_100002);
			result.setMsg(LoginConstant.LOGIN_ERROR_MESSAGE_SYSTEMERROR);
			result.setSuccess(false);
			return result;
		} catch (ExcessiveAttemptsException e) {
			token.clear();
//			request.setAttribute("LOGIN_ERROR_CODE", LoginConstant.LOGIN_ERROR_CODE_100003);
//			request.setAttribute("LOGIN_ERROR_MESSAGE","账号：" + user.getUserName() + LoginConstant.LOGIN_ERROR_MESSAGE_MAXERROR);
//			return "login";
			result.setCode(LoginConstant.LOGIN_ERROR_CODE_100003);
			result.setMsg("账号：" + user.getUserName() + LoginConstant.LOGIN_ERROR_MESSAGE_MAXERROR);
			result.setSuccess(false);
			return result;
		} catch (AuthenticationException e) {
			token.clear();
//			request.setAttribute("LOGIN_ERROR_CODE", LoginConstant.LOGIN_ERROR_CODE_100001);
//			request.setAttribute("LOGIN_ERROR_MESSAGE", LoginConstant.LOGIN_ERROR_MESSAGE_USERERROR);
//			return "login";
			result.setCode(LoginConstant.LOGIN_ERROR_CODE_100001);
			result.setMsg(LoginConstant.LOGIN_ERROR_MESSAGE_USERERROR);
			result.setSuccess(false);
			return result;
		}
//		return "redirect:/index.shtml";

		result.setSuccess(true);
		return result;


	}

	/**
	 * 登出系统
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @param user
	 * @param result
	 * @return
	 */
	@RequestMapping("logout")
	public Result logout()  {
		SecurityUtils.getSubject().logout();
//		return "redirect:/login.shtml";
		result.setSuccess(true);
		return result;
	}
	@RequestMapping("denied")
	public Result denied()  {
//		return "denied";
		result.setSuccess(true);
		return result;
	}




}
