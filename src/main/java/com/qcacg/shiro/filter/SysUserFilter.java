package com.qcacg.shiro.filter;

import com.qcacg.service.system.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//请求路径匹配功能及拦截器参数解析
public class SysUserFilter extends PathMatchingFilter
{

	@Autowired
	private UserService userService;

	@Override
	protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception
	{
		//获取用户信息
		 String telephone = (String)SecurityUtils.getSubject().getPrincipal();
		//判断是否为空，不为空返回true
		 if(StringUtils.isNoneEmpty(telephone))
		 {
			request.setAttribute("user", userService.findByLoginName(telephone));
		 }
		 //继续执行
		 return true;
	}
}