package com.qcacg.util;

import com.qcacg.entity.user.UserCustom;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;

public class SendTelephoneCode {

	public static Logger logger = Logger.getLogger(SendTelephoneCode.class);

	/**
	 * @param args
	 */
	public static void sendMessage(String telephone, StringBuilder telephoneCode) {

		try {
			HttpClient client = new HttpClient();
			client.getParams().setParameter(
					HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");

			PostMethod method = new PostMethod(
					"http://202.91.244.252/qd/SMSSendYD"); // 测试环境

			method.addRequestHeader("Connection", "close");
			method.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded;charset=GBK");


			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String usr = "7732";
			String pwd = "qykj@7732hz";
			String mobile = telephone;
			String sms = "【二次元轻小说】您的验证码是：" + telephoneCode + "。请不要把验证码泄露给其他人。" ;
			String extdsrcid = "";

			 NameValuePair[] param = { new NameValuePair("usr", usr),
			 new NameValuePair("pwd", pwd),
			 new NameValuePair("mobile", mobile),
			 new NameValuePair("sms", sms),
			 new NameValuePair("extdsrcid", extdsrcid)};

			// 将表单的值放入postMethod中
			method.setRequestBody(param);

			// 执行postMethod
			int statusCode = 0;
			try {
				statusCode = client.executeMethod(method);
			} catch (HttpException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// HttpClient对于要求接受后继服务的请求，像POST和PUT等不能自动处理转发
			if (statusCode != HttpStatus.SC_OK) {
				logger.info("Tianjin,Method failed:" + method.getStatusLine());
			}

			// 读取内容
			InputStream resInputStream = null;
			try {
				resInputStream = method.getResponseBodyAsStream();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 处理内容
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					resInputStream));
			String tempBf = null;
			StringBuffer html = new StringBuffer();
			while ((tempBf = reader.readLine()) != null) {
				html.append(tempBf);
			}
			logger.info("result:" + html.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String SMS(String postData, String postUrl) {
		try {
			//发送POST请求
			URL url = new URL(postUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setUseCaches(false);
			conn.setDoOutput(true);

			conn.setRequestProperty("Content-Length", "" + postData.length());
			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			out.write(postData);
			out.flush();
			out.close();

			//获取响应状态
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				System.out.println("connect failed!");
				return "";
			}
			//获取响应内容体
			String line, result = "";
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			while ((line = in.readLine()) != null) {
				result += line + "\n";
			}
			in.close();
			return result;
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
		return "";
	}

}
