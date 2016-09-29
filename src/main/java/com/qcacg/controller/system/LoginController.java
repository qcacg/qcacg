package com.qcacg.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qcacg.constant.LoginConstant;
import com.qcacg.entity.UserEntity;
import com.qcacg.service.system.ResourcesService;
import com.qcacg.service.system.RoleService;
import com.qcacg.service.system.UserService;

@Controller
public class LoginController {
	@Autowired
	ResourcesService resourcesService;
	@Autowired
	RoleService roleService;
	@Autowired
	UserService userService;

	@RequestMapping(value = "login", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	public String login(HttpServletRequest request)
	{
		if(request.getParameter("forceLogout") != null)
		{
		    request.setAttribute("LOGIN_ERROR_CODE", LoginConstant.LOGIN_ERROR_CODE_100004);
		    request.setAttribute("LOGIN_ERROR_MESSAGE", LoginConstant.LOGIN_ERROR_MESSAGE_FORCELOGOUT);
		}
		return "login";
	}

	@RequestMapping("user-info")
	public String userInfo() {
		return "user-info";
	}


	@RequestMapping(value = "login", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String login(HttpServletRequest request, HttpServletResponse response, UserEntity userEntity,Model model) {
		// 想要得到 SecurityUtils.getSubject() 的对象．．访问地址必须跟shiro的拦截地址内．不然后会报空指针
		Subject sub = SecurityUtils.getSubject();
		// 用户输入的账号和密码,,存到UsernamePasswordToken对象中..然后由shiro内部认证对比,
		// 认证执行者交由ShiroDbRealm中doGetAuthenticationInfo处理
		// 当以上认证成功后会向下执行,认证失败会抛出异常
		UsernamePasswordToken token = new UsernamePasswordToken(userEntity.getTelephone(), userEntity.getPassWord());
		try {
			sub.login(token);
		} catch (LockedAccountException lae) {
			token.clear();
			model.addAttribute("userEntity", userEntity);
			request.setAttribute("LOGIN_ERROR_CODE", LoginConstant.LOGIN_ERROR_CODE_100002);
			request.setAttribute("LOGIN_ERROR_MESSAGE", LoginConstant.LOGIN_ERROR_MESSAGE_SYSTEMERROR);
			return "login";
		} catch (ExcessiveAttemptsException e) {
			token.clear();
			model.addAttribute("userEntity", userEntity);
			request.setAttribute("LOGIN_ERROR_CODE", LoginConstant.LOGIN_ERROR_CODE_100003);
			request.setAttribute("LOGIN_ERROR_MESSAGE","账号：" + userEntity.getUserName() + LoginConstant.LOGIN_ERROR_MESSAGE_MAXERROR);
			return "login";
		} catch (AuthenticationException e) {
			token.clear();
			model.addAttribute("userEntity", userEntity);
			request.setAttribute("LOGIN_ERROR_CODE", LoginConstant.LOGIN_ERROR_CODE_100001);
			request.setAttribute("LOGIN_ERROR_MESSAGE", LoginConstant.LOGIN_ERROR_MESSAGE_USERERROR);
			return "login";
		}

		return "redirect:/user-info.shtml";

	}
	@RequestMapping("index")
	public String index() {
		return "index";
	}

	@RequestMapping("type")
	public String type() {
		return "type";
	}

	@RequestMapping("catalog")
	public String catalog() {
		return "catalog";
	}

	@RequestMapping("ranking")
	public String ranking() {
		return "ranking";
	}
//	@RequestMapping("public-header")
//	public String header() {
//		return "public-header";
//	}
//
//	@RequestMapping("public-footer")
//	public String footer() {
//		return "public-footer";
//	}

	@RequestMapping("toLogin")
	public String toLogin(){
		return "login";
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
	public String logout() {
		SecurityUtils.getSubject().logout();
		return "redirect:/login.shtml";
	}
	@RequestMapping("denied")
	public String denied()
	{
		return "denied";
	}




}
