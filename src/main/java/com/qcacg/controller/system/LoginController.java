package com.qcacg.controller.system;

<<<<<<< HEAD
import com.qcacg.constant.CodeConstant;
=======
>>>>>>> 0aa25e77c367abfa3e9bf53151a7fad4b044f553
import com.qcacg.constant.LoginConstant;
import com.qcacg.entity.ResourcesEntity;
import com.qcacg.entity.UserEntity;
import com.qcacg.service.system.ResourcesService;
import com.qcacg.service.system.RoleService;
import com.qcacg.service.system.UserService;
<<<<<<< HEAD
import com.qcacg.util.*;
=======
import com.qcacg.util.JsonResult;
import com.qcacg.util.PasswordHelper;
import com.qcacg.util.TreeUtil;
import com.qcacg.util.UserEntityUtil;
>>>>>>> 0aa25e77c367abfa3e9bf53151a7fad4b044f553
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
<<<<<<< HEAD
import org.apache.shiro.session.mgt.SessionContext;
=======
>>>>>>> 0aa25e77c367abfa3e9bf53151a7fad4b044f553
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
<<<<<<< HEAD
import redis.clients.jedis.Jedis;
=======
>>>>>>> 0aa25e77c367abfa3e9bf53151a7fad4b044f553

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

	@RequestMapping("login")
	@ResponseBody
<<<<<<< HEAD
	public Map login(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String tel = request.getParameter("telephone");
		String pwd = request.getParameter("passWord");
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(tel, pwd);
		try{
			subject.login(token);
			//登录成功后,获取redis对象。自定义的redis对象。
			MyJedis jedis = new MyJedis();
			UserEntity user = UserEntityUtil.getUserFromSession();
			//用密码生成一个不可逆的key
			String now = String.valueOf(System.currentTimeMillis());
			String jsessionId = (new PasswordHelper()).encryptToken(now, user.getPassWord());
			//将用户手机号存入redis缓存中用来验证是否为同一用户和用户是否登录
			jedis.set(jsessionId, user.getTelephone() + "|" + now);
			//将数据绑定在response中返回给前台
			map.put("msg", jsessionId);
		} catch(LockedAccountException lae) {
			token.clear();
			//用户被锁定
			response.setStatus(500);
			map.put("code", LoginConstant.LOGIN_ERROR_CODE_100002);
			map.put("msg",LoginConstant.LOGIN_ERROR_MESSAGE_SYSTEMERROR);
			return map;
		} catch (ExcessiveAttemptsException e) {
			token.clear();
			//登录失败次数过多
			response.setStatus(500);
			map.put("code", LoginConstant.LOGIN_ERROR_CODE_100003);
			map.put("msg",LoginConstant.LOGIN_ERROR_MESSAGE_MAXERROR);
			return map;
		} catch (AuthenticationException e) {
			token.clear();
			//账号或密码错误
			response.setStatus(500);
			map.put("code", LoginConstant.LOGIN_ERROR_CODE_100001);
			map.put("msg",LoginConstant.LOGIN_ERROR_MESSAGE_USERERROR);
			return map;
		} catch (Exception e) {
			token.clear();
			response.setStatus(500);
			map.put("code", CodeConstant.SYS_CODE);
			map.put("msg",CodeConstant.SYS_CODE_MSG);
			map.put("error", e.getMessage());
			return map;
		}
		return map;
=======
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
>>>>>>> 0aa25e77c367abfa3e9bf53151a7fad4b044f553
	}


}
