package com.qcacg.util.geetest;

/**
 * GeetestWeb配置文件
 * 
 *
 */
public class GeetestConfig {

	// 填入自己的captcha_id和private_key
	private static final String captcha_id = "efd6f79d5086feab9ae259d88a5e30d0";
	private static final String private_key = "c2a803c718ae7655d8826ecca673d4d4";

	public static final String getCaptcha_id() {
		return captcha_id;
	}

	public static final String getPrivate_key() {
		return private_key;
	}

}
