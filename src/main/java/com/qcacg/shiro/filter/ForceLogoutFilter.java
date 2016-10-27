package com.qcacg.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.session.Session;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import com.qcacg.util.UserEntityUtil;

/**
 * <p>
 * User: Zhang Kaitao
 * <p>
 * Date: 14-3-16
 * <p>
 * Version: 1.0
 */
//AccessControlFilter 访问控制
public class ForceLogoutFilter extends AccessControlFilter
{

	//表示是否允许访问；mappedValue就是[urls]配置中拦截器参数部分，如果允许访问返回true，否则false；
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception
	{
		Session session = getSubject(request, response).getSession(false);
		if (session == null)
		{
			return true;
		}
		return session.getAttribute(UserEntityUtil.USER_SESSION_LOGOUT_LOGOUT_KEY) == null;
	}

	//表示当访问拒绝时是否已经处理了；如果返回true表示需要继续处理；
	// 如果返回false表示该拦截器实例已经处理了，将直接返回即可。
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception
	{
		try
		{
			getSubject(request, response).logout();// 强制退出
		} catch (Exception e)
		{
			
		}
		String loginUrl = getLoginUrl() + (getLoginUrl().contains("?") ? "&" : "?") + "forceLogout=1";  
		WebUtils.issueRedirect(request, response, loginUrl);
		return false;
	}
}