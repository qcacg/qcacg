package com.qcacg.util.geetest;


import com.qcacg.util.MyJedis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 使用Get的方式返回challenge和capthca_id,此方式以实现前后端完全分离的开发模式
 *
 */
@Controller

public class StartCaptchaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@RequestMapping("/StartCaptchaServlet")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		if(request.getSession().getAttribute("telephone") !=null) {
//
//		}else{
			GeetestLib gtSdk = new GeetestLib(GeetestConfig.getCaptcha_id(), GeetestConfig.getPrivate_key());

			String resStr = "{}";

			//自定义userid
//		Long userId = UserEntityUtil.getUserFromSession().getUserId();

			//进行验证预处理
			int gtServerStatus = gtSdk.preProcess();

			//将服务器状态设置到session中
<<<<<<< HEAD
		MyJedis jedis = new MyJedis();
		jedis.set(gtSdk.gtServerStatusSessionKey, String.valueOf(gtServerStatus));
		jedis.expire(gtSdk.gtServerStatusSessionKey, 60);
=======
			request.getSession().setAttribute(gtSdk.gtServerStatusSessionKey, gtServerStatus);
>>>>>>> 0aa25e77c367abfa3e9bf53151a7fad4b044f553
			//将userid设置到session中
//		request.getSession().setAttribute("userId", userId);

			resStr = gtSdk.getResponseStr();

			PrintWriter out = response.getWriter();
			out.println(resStr);
//		}
	}
}