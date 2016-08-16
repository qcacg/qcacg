package com.qcacg.shiro.filter;

import com.qcacg.service.system.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SysUserFilter extends PathMatchingFilter
{

	@Autowired
	private UserService userService;

	@Override
	protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception
	{
		 String telephone = (String)SecurityUtils.getSubject().getPrincipal();
		 if(StringUtils.isNoneEmpty(telephone))
		 {
			request.setAttribute("user", userService.findByLoginName(telephone));
		 }
		 return true;
	}
}