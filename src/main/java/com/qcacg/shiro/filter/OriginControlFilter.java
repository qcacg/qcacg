package com.qcacg.shiro.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 解决跨域访问问题
 * Created by CaiYuanYu on 2016/10/19.
 */
public class OriginControlFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        res.setHeader("Access-Control-Allow-Origin", "*");
        //String url = req.getRequestURL().toString();
        //System.out.println(url);
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}
