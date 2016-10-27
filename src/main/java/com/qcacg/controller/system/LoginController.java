package com.qcacg.controller.system;

import com.qcacg.constant.LoginConstant;
import com.qcacg.entity.ResourcesEntity;
import com.qcacg.entity.UserEntity;
import com.qcacg.service.system.ResourcesService;
import com.qcacg.service.system.RoleService;
import com.qcacg.service.system.UserService;
import com.qcacg.util.JsonResult;
import com.qcacg.util.PasswordHelper;
import com.qcacg.util.TreeUtil;
import com.qcacg.util.UserEntityUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class LoginController {
	@Autowired
	ResourcesService resourcesService;
	@Autowired
	RoleService roleService;
	@Autowired
	UserService userService;


	
	@RequestMapping(value = "login", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	@ResponseBody
	public Map<String, String> login(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		if(request.getParameter("forceLogout") != null)
		{
			//错误信息100004
			map.put("LOGIN_ERROR_CODE", LoginConstant.LOGIN_ERROR_CODE_100004);
			//您已经被管理员强制退出，请重新登录
			map.put("LOGIN_ERROR_MESSAGE", LoginConstant.LOGIN_ERROR_MESSAGE_FORCELOGOUT);
			return map;
		}
		//错误信息100005
		map.put("LOGIN_ERROR_CODE", LoginConstant.LOGIN_ERROR_CODE_100005);
		//用户不存在
		map.put("LOGIN_ERROR_MESSAGE", LoginConstant.LOGIN_ERROR_MESSAGE_USERNOTEXIST);
		return map;
	}
	

	

	public JsonResult<List<ResourcesEntity>> userInfo() {
		UserEntity infoForm = UserEntityUtil.getUserFromSession();
		String userId = String.valueOf(infoForm.getUserId());
		//判断某字符串是否不为空且长度不为0且不由空白符(whitespace)构成
		if (StringUtils.isNotBlank(userId)) {
			Map<String, String> queryMap = new HashMap<String, String>();
			queryMap.put("userId", userId);
			List<ResourcesEntity> resourceForms = resourcesService.findResourcessByMap(queryMap);
			List<ResourcesEntity> ns = TreeUtil.getChildResourceForms(resourceForms, 0);
			//绑定数据；内部调用put（string1, string2),调用之前会判断是否为null（报错）。
			//String uuid = UUID.randomUUID().toString();
			//model.addAttribute("UUID", uuid);
			return new JsonResult<List<ResourcesEntity>>(ns);
		}
		return new JsonResult<List<ResourcesEntity>>("用户信息异常");
	}

	@RequestMapping("login")
	@ResponseBody
	public JsonResult login(HttpServletRequest request,@RequestBody UserEntity userEntity) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(userEntity.getTelephone(), userEntity.getPassWord());
		try{
			subject.login(token);
			HttpSession session = request.getSession();
			String now = System.currentTimeMillis() + "";
			String userAgent = request.getHeader("User-Agent");
			String action = now + "|" + (new PasswordHelper()).encryptToken(now, userAgent);
			session.setAttribute("token", action);
		} catch(LockedAccountException lae) {
			token.clear();
			//用户被锁定
			return new JsonResult<UserEntity>(LoginConstant.LOGIN_ERROR_CODE_100002,
					LoginConstant.LOGIN_ERROR_MESSAGE_SYSTEMERROR, userEntity);
		} catch (ExcessiveAttemptsException e) {
			token.clear();
			//登录失败次数过多
			return new JsonResult<UserEntity>(LoginConstant.LOGIN_ERROR_CODE_100003,
					"账号" + userEntity.getUserName() + LoginConstant.LOGIN_ERROR_MESSAGE_MAXERROR, userEntity);
		} catch (AuthenticationException e) {
			token.clear();
			//账号或密码错误
			return new JsonResult<UserEntity>(LoginConstant.LOGIN_ERROR_CODE_100001,
					LoginConstant.LOGIN_ERROR_MESSAGE_USERERROR, userEntity);
		} catch (Exception e) {
			token.clear();
			return new JsonResult<UserEntity>(LoginConstant.LOGIN_ERROR_MESSAGE_USERERROR, userEntity);
		}
		JsonResult<List<ResourcesEntity>> json = userInfo();
		return json;
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
	@RequestMapping("book-check")
	public String bookCheck() {
		return "book-check";
	}


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
