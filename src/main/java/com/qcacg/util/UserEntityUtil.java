package com.qcacg.util;

import com.qcacg.entity.UserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserEntityUtil
{
	/**
	 * 用户信息key
	 */
	public static final String USER_SESSION_KEY = "USER_SESSION_KEY";
	public static final String USER_SESSION_LOGOUT_LOGOUT_KEY = "USER_SESSION_LOGOUT_LOGOUT_KEY";

	/**
	 * 从session中获取当前登录的用户信息
	 * 
	 * @return[参数、异常说明] @return UserForm [返回类型说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static UserEntity getUserFromSession()
	{
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("15067171806", "123456");
		subject.login(token);

		//获取验证后的subject实例
		Session session = SecurityUtils.getSubject().getSession();
		UserEntity userEntity = (UserEntity) session.getAttribute(UserEntityUtil.USER_SESSION_KEY);
		return (UserEntity) session.getAttribute(UserEntityUtil.USER_SESSION_KEY);
	}

	public static String convertDateToString(Date date, String format)
	{
		return new SimpleDateFormat(format).format(date);
	}

	

}
