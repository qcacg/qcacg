package com.qcacg.util.geetest;

import com.qcacg.constant.CodeConstant;
import com.qcacg.util.MyJedis;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 使用post方式，返回验证结果, request表单中必须包含challenge, validate, seccode
 */
@Controller
public class VerifyLoginServlet extends HttpServlet {


	private static final long serialVersionUID = 5691814559693335335L;
	@RequestMapping("/VerifyLoginServlet")
	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response) throws ServletException, IOException {

		System.out.println("the requestMapping StartCaptchaServlet in  1");
		GeetestLib gtSdk = new GeetestLib(GeetestConfig.getCaptcha_id(), GeetestConfig.getPrivate_key());
			
		String challenge = request.getParameter(GeetestLib.fn_geetest_challenge);
		String validate = request.getParameter(GeetestLib.fn_geetest_validate);
		String seccode = request.getParameter(GeetestLib.fn_geetest_seccode);
		
		//从redis中获取gt-server状态
		MyJedis jedis = new MyJedis();
		String gt_server_status = jedis.getValue(gtSdk.gtServerStatusSessionKey);
		System.out.println(gt_server_status);
		System.out.println(gtSdk.gtServerStatusSessionKey);
		System.out.println("the StartCaptchaServlet is running here");
		if(StringUtils.isBlank(gt_server_status)) {
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json; charset=utf-8");
			response.setStatus(500);
			JSONObject data = new JSONObject();
			try {
				data.put("code", CodeConstant.OUT_OF_TIME_CODE);
				data.put("msg", CodeConstant.CODE_TIME_OUT_MSG);
				response.getWriter().append(data.toString()).close();
				return;
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		int gt_server_status_code = Integer.valueOf(gt_server_status);
		
		//从session中获取userid
//		Long userId = UserEntityUtil.getUserFromSession().getUserId();
		
		int gtResult = 0;

		if (gt_server_status_code == 1) {
			//gt-server正常，向gt-server进行二次验证
				
			gtResult = gtSdk.enhencedValidateRequest(challenge, validate, seccode);
			System.out.println(gtResult);
		} else {
			// gt-server非正常情况下，进行failback模式验证
				
			System.out.println("failback:use your own server captcha validate");
			gtResult = gtSdk.failbackValidateRequest(challenge, validate, seccode);
			System.out.println(gtResult);
		}


		if (gtResult == 1) {
			// 验证成功
			PrintWriter out = response.getWriter();
			JSONObject data = new JSONObject();
			try {
				data.put("status", "success");
				data.put("version", gtSdk.getVersionInfo());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			out.println(data.toString());
		}
		else {
			// 验证失败
			JSONObject data = new JSONObject();
			try {
				data.put("status", "fail");
				data.put("version", gtSdk.getVersionInfo());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			PrintWriter out = response.getWriter();
			out.println(data.toString());
		}

	}
}
