package com.qcacg.constant;

public interface LoginConstant
{
	String LOGIN_ERROR_CODE_100001 = "100001";
	String LOGIN_ERROR_MESSAGE_USERERROR = "账号或密码错误，请重新输入！";
	
	String LOGIN_ERROR_CODE_100002 = "100002";
	String LOGIN_ERROR_MESSAGE_SYSTEMERROR = "用户已经被锁定不能登录，请与管理员联系！";
	
	String LOGIN_ERROR_CODE_100003 = "100003";
	String LOGIN_ERROR_MESSAGE_MAXERROR = "登录失败次数过多,锁定10分钟！";
	
	String LOGIN_ERROR_CODE_100004 = "100004";
	String LOGIN_ERROR_MESSAGE_FORCELOGOUT = "您已经被管理员强制退出，请重新登录";

	String LOGIN_ERROR_CODE_100005 = "100005";
	String LOGIN_ERROR_MESSAGE_USERNOTEXIST = "您还未登录，请登录！！！";
	
	
	
	
}
