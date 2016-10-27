package com.qcacg.shiro.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CaiYuanYu on 2016/10/24.
 */
public class AccessFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String url = req.getRequestURL().toString();
        //筛选jsp页面和*.shtml请求
        //System.out.println(url);
        if(url.endsWith(".jsp") || url.indexOf(".shtml") > 0) {
            //放过登录页面请求
            List<String> list = getList();
            for (String str : list) {
                if(url.indexOf(str) > 0) {
                    chain.doFilter(req, res);
                    return;
                }
            }
            redirectController(req, res, chain);
            return;
        }
        //对于一些配置文件
        chain.doFilter(request, response);
    }

    private void redirectController(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
        // TODO Auto-generated method stub
       HttpSession session = request.getSession(false);
        String path = request.getContextPath();
        String url = path + "/toLogin.shtml";
        if(session == null) {
            try {
                response.sendRedirect(url);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return;
        }
        String value = session.getAttribute("action").toString();
        String[] data =value.split("\\|");
        String now = data[0];
        String action = data[1];
        String userAgent = request.getHeader("User-Agent");
        if(action.equals(userAgent)) {
            try {
                chain.doFilter(request, response);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ServletException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return;
        }
    }

    private List<String> getList() {
        List<String> list = new ArrayList<String>();
        //不需要登录检查的页面
//        /index.jsp  /index.shtml  /common/**  /lib/** /module/**
//        /treegrid/**  /denied.shtml   /login.shtml /toLogin.shtml
//         /register.shtml  /toRegister.shtml  /type.shtml  /book/queryBook/**.shtml
//         /ranking.shtml  /catalog.shtml = anon /updatePasswordTelephoneCode.shtml
//         /registerTelephoneCode.shtml  /toUpdatePassword.shtml  /updatePassword.shtml
//         /404.jsp  /error.jsp = anon  /book/findBookByBookUpDate.shtml
        list.add("/index.jsp");list.add("/index.shtml");list.add("/common/");
        list.add("/lib/");list.add("/module/");list.add("/treegrid/");list.add("/denied.shtml");
        list.add("/login.shtml");list.add("/toLogin.shtml");list.add("/register.shtml");
        list.add("/toRegister.shtml");list.add("/type.shtml");list.add("/book/queryBook/");
        list.add("/ranking.shtml");list.add("/catalog.shtml");list.add("/updatePasswordTelephoneCode.shtml");
        list.add("/registerTelephoneCode.shtml");list.add("/toUpdatePassword.shtml");list.add("/updatePassword.shtml");
        list.add("/404.jsp");list.add("/error.jsp");list.add("/book/findBookByBookUpDate.shtml");
         return list;
    }

    @Override
    public void destroy() {

    }
}
