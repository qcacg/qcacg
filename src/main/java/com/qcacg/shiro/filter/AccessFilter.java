package com.qcacg.shiro.filter;

<<<<<<< HEAD
import com.qcacg.constant.CodeConstant;
import com.qcacg.util.MyJedis;
import com.qcacg.util.UserEntityUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;

=======
>>>>>>> 0aa25e77c367abfa3e9bf53151a7fad4b044f553
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
<<<<<<< HEAD
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 该拦截器只拦截*.shtml请求，对于静态页面和一些资源请求不限制。
=======
import java.util.ArrayList;
import java.util.List;

/**
>>>>>>> 0aa25e77c367abfa3e9bf53151a7fad4b044f553
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
<<<<<<< HEAD

        boolean flag = isOut(req, res);

        if(flag) {
            return;
        }

        //获取访问路径信息
        String url = req.getRequestURL().toString();
        //已经将不需要拦截的请求存入集合中，每次请求辨别该请求是否是开放的。
        List<String> list = getList();
        for (String str : list) {
            if(url.indexOf(str) > 0) {
                chain.doFilter(req, res);
                return;
            }
        }
        //对于需要登录才能访问的请求，会验证用户是否登录。
        redirectController(req, res, chain);
        return;

    }

    private boolean isOut(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String jsessionId = req.getParameter("jsessionId");
        MyJedis jedis = new MyJedis();
        if (StringUtils.isNotBlank(jsessionId)){
            String token = jedis.getValue(jsessionId);
            long loginTime = Long.valueOf(jedis.getTime(jsessionId));
            long now = System.currentTimeMillis();
            //如果登录时间超过30分钟，则会被系统提出
            if (now - loginTime > 1800000) {
                Map<String, String> map = new HashMap<String, String>();
                res.setCharacterEncoding("UTF-8");
                res.setContentType("application/json; charset=utf-8");
                res.setStatus(500);
                map.put("code", CodeConstant.OUT_OF_TIME_CODE);
                map.put("msg", CodeConstant.OUT_OF_TIME_MSG);
                res.getWriter().append(JSONObject.fromObject(map).toString()).close();
                jedis.remove(jsessionId);
                return true;
            } else {
                //更新在线时间
                jedis.updateLoginTime(jsessionId, System.currentTimeMillis());
            }
        }
        return false;
    }


    private void redirectController(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
        // TODO Auto-generated method stub
        //获取sessionId
        Map<String, String> map = new HashMap<String, String>();
        JSONObject json = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        String jsessionId = request.getParameter("JSESSIONID");
        //如果sessionId为空表明未登录
        if(StringUtils.isBlank(jsessionId)) {
            try {
                response.setStatus(500);
                map.put("code", CodeConstant.TO_LOGIN_CODE + 2);
                map.put("msg", CodeConstant.RELOGIN_MSG);
                out = response.getWriter();
                json = JSONObject.fromObject(map);
                out.append(json.toString());
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //从sessionId中获取用户名
        MyJedis jedis = new MyJedis();
        String value = jedis.getTel(jsessionId);
        //如果value不为null并且排除当前会话还有其它用户;防止出现jsessionId一致的情况
        if(value != null) {
=======
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
>>>>>>> 0aa25e77c367abfa3e9bf53151a7fad4b044f553
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
<<<<<<< HEAD
        try {
            //重定向到登录界面
            response.setStatus(500);
            map.put("code", CodeConstant.TO_LOGIN_CODE + 3);
            map.put("msg", CodeConstant.RELOGIN_MSG);
            out = response.getWriter();
            json = JSONObject.fromObject(map);
            out.append(json.toString());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
=======
>>>>>>> 0aa25e77c367abfa3e9bf53151a7fad4b044f553
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
<<<<<<< HEAD
        return list;
=======
         return list;
>>>>>>> 0aa25e77c367abfa3e9bf53151a7fad4b044f553
    }

    @Override
    public void destroy() {

    }
}
