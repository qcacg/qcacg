package com.qcacg.controller.system;

import com.qcacg.constant.CodeConstant;
import com.qcacg.entity.UserEntity;
import com.qcacg.entity.user.UserCustom;
import com.qcacg.entity.user.UserQauryVo;
import com.qcacg.service.system.UserService;
import com.qcacg.util.MyJedis;
import com.qcacg.util.Sms;
import com.taobao.api.ApiException;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.formula.functions.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by CaiYuanYu on 2016/10/26
 */

@Controller
public class RegisterController {
	private static final String VALIDATE_TELEPHONE_CODE = "VALIDATE_TELEPHONE_CODE";
	private static final String VALIDATE_TELEPHONE = "VALIDATE_TELEPHONE";
	private static final String SEND_CODE_TIME = "SEND_CODE_TIME";

	@Autowired
	private UserService userService;

	@RequestMapping(value = "register", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> register(HttpServletRequest request, HttpServletResponse response,UserCustom userCustom) throws Exception {

		UserQauryVo userQauryVo = new UserQauryVo();
		userQauryVo.setUserCustom(userCustom);
		Map<String, Object> map = new HashMap<String, Object>();

		MyJedis jedis = new MyJedis();
		String inputTelephoneCode = request.getParameter("telephoneCode");
		String uuid = request.getParameter("registCodeId");
		String telephoneCode = jedis.getValue(uuid);
		//HttpSession session = request.getSession();
		//String telephoneCode = (String) session.getAttribute(VALIDATE_TELEPHONE_CODE);

		//判断用户是否有输入验证码
		if(StringUtils.isBlank(inputTelephoneCode)) {
			response.setStatus(500);
			map.put("code", CodeConstant.NOT_NULL_CODE);
			map.put("msg", CodeConstant.VALUE_NO_INPUT);
			return map;
		}

		//判断验证码是否过期
		if(StringUtils.isBlank(telephoneCode)) {
			response.setStatus(CodeConstant.ERROR_CODE);
			map.put("code", CodeConstant.OUT_OF_TIME_CODE);
			map.put("msg", CodeConstant.OUT_OF_TIME_MSG);
			return map;
		}

		if(!inputTelephoneCode.equals(telephoneCode)) {
			response.setStatus(500);
			map.put("code", CodeConstant.IDENTIFYING_CODE);
			map.put("msg", CodeConstant.IDENTIFYING_ERROR);
			return map;
		}

		if(userQauryVo.getUserCustom().getTelephone() == null) {
			response.setStatus(500);
			map.put("code", CodeConstant.NOT_NULL_CODE);
			map.put("msg", CodeConstant.TELEPHONE_IS_NULL);
			return map;
		}
		//验证用户手机号是否能正常使用
		if(!isMobile(userQauryVo.getUserCustom().getTelephone())) {
			response.setStatus(500);
			map.put("code", CodeConstant.NOT_EXIST_CODE);
			map.put("msg", CodeConstant.TELEPHONE_NOT_EXIST);
			return map;
		}
		//验证注册用户是否注册
		if(this.userService.findByLoginName(userQauryVo.getUserCustom().getTelephone()) != null) {
			response.setStatus(CodeConstant.ERROR_CODE);
			map.put("code", CodeConstant.IS_EXIST_CODE);
			map.put("msg", CodeConstant.TELEPHONE_IS_EXIST);
			return map;
		}
		//判断两次密码是否一致
		if(!userCustom.getPassWordConfirm().equals(userCustom.getPassWord())) {
			response.setStatus(CodeConstant.ERROR_CODE);
			map.put("code", CodeConstant.REGISTER_CODE);
			map.put("msg", CodeConstant.REGISTER_MSG);
			return map;
		}

		userService.register(userCustom);
		map.put("msg", "注册成功");
		return map;
	}

	@RequestMapping("registerTelephoneCode")
	@ResponseBody
	public Map<String,Object> registerTelephoneCode(String telephone, HttpServletRequest request, HttpServletResponse response) throws ApiException {

        Map<String,Object> result = new HashMap<String, Object>();

        if(telephone == null || StringUtils.isBlank(telephone)) {
			response.setStatus(500);
			result.put("code", CodeConstant.NOT_NULL_CODE);
			result.put("msg", CodeConstant.TELEPHONE_IS_NULL);
			return result;
		}

        if(!isMobile(telephone)) {
			response.setStatus(500);
			result.put("code", CodeConstant.NOT_EXIST_CODE);
			result.put("msg", CodeConstant.TELEPHONE_NOT_EXIST);
			return result;
		}

        if(this.userService.findByLoginName(telephone) != null){
            response.setStatus(500);
			result.put("code", CodeConstant.IS_EXIST_CODE);
			result.put("msg",CodeConstant.TELEPHONE_IS_EXIST);
			return result;

        }else{
        	//生成一个唯一的识别码，作为验证码的id
        	String uuid = UUID.randomUUID().toString();
			this.sendTelephoneCode(telephone, request, uuid);
            result.put("verificationId",uuid);
            result.put("msg", CodeConstant.SUCCESS_SEND);
        }
        return result;
    }

    @RequestMapping("updatePassword")
    @ResponseBody
    public Map<String, Object> updatePassWord(HttpServletRequest request,HttpServletResponse response, UserCustom userCustom,@RequestParam(value = "passWord") String passWord){

        UserQauryVo userQauryVo = new UserQauryVo();
        userQauryVo.setUserCustom(userCustom);
        Map<String, Object> map = new HashMap<String, Object>();

		MyJedis jedis = new MyJedis();
		String inputTelephoneCode = request.getParameter("telephoneCode");
		String uuid = request.getParameter("updateCodeId");
		String telephoneCode = jedis.getValue(uuid);
		//HttpSession session = request.getSession();
		//String telephoneCode = (String) session.getAttribute(VALIDATE_TELEPHONE_CODE);
		//判断用户是否有输入验证码
		if(StringUtils.isBlank(inputTelephoneCode)) {
			response.setStatus(500);
			map.put("code", CodeConstant.NOT_NULL_CODE);
			map.put("msg", CodeConstant.VALUE_NO_INPUT);
			return map;
		}

		//判断验证码是否过期
		if(StringUtils.isBlank(telephoneCode)) {
			response.setStatus(CodeConstant.ERROR_CODE);
			map.put("code", CodeConstant.OUT_OF_TIME_CODE);
			map.put("msg", CodeConstant.CODE_TIME_OUT_MSG);
			return map;
		}
		//验证验证码是否输入正确
		if(!inputTelephoneCode.equals(telephoneCode)) {
			response.setStatus(500);
			map.put("code", CodeConstant.IDENTIFYING_CODE);
			map.put("msg", CodeConstant.IDENTIFYING_ERROR);
			return map;
		}
		//需要更新的手机号是否为空
		if(userQauryVo.getUserCustom().getTelephone() == null) {
			response.setStatus(500);
			map.put("code", CodeConstant.NOT_NULL_CODE);
			map.put("msg", CodeConstant.TELEPHONE_IS_NULL);
			return map;
		}
		//查看手机号是否有效
		if(!isMobile(userQauryVo.getUserCustom().getTelephone())) {
			response.setStatus(500);
			map.put("code", CodeConstant.NOT_EXIST_CODE);
			map.put("msg", CodeConstant.TELEPHONE_NOT_EXIST);
			return map;
		}
		//查看该手机号是否注册
        if(userService.findByLoginName(userQauryVo.getUserCustom().getTelephone()) == null){
            response.setStatus(500);
            map.put("code", CodeConstant.NOT_EXIST_CODE);
            map.put("msg", CodeConstant.TELEPHONE_NOT_REGIST);
            return map;
        }
        //查看两次密码是否一致
		if(!userCustom.getPassWordConfirm().equals(userCustom.getPassWord())) {
			response.setStatus(CodeConstant.ERROR_CODE);
			map.put("code", CodeConstant.REGISTER_CODE);
			map.put("msg", CodeConstant.REGISTER_MSG);
			return map;
		}
//        HttpSession session = request.getSession();
//        String telephoneCode = (String) session.getAttribute(VALIDATE_TELEPHONE_CODE);
//        String inputTelephoneCode = request.getParameter("telephoneCode");

        UserEntity userEntity = this.userService.findByLoginName(userCustom.getTelephone());
        userService.updatePassWord(userEntity,passWord);
        map.put("msg", "密码修改成功，请重新登录。");
        return map;
    }

	@RequestMapping("updatePasswordTelephoneCode")
	@ResponseBody
	public Map<String,Object> updatePasswordTelephoneCode(String telephone, HttpServletRequest request) throws ApiException {

		Map<String,Object> result = new HashMap<String, Object>();
		if(this.userService.findByLoginName(telephone) == null){
			result.put("success",false);
			result.put("msg","该手机号码还未注册过");

		}else{
			String uuid = UUID.randomUUID().toString();
			this.sendTelephoneCode(telephone,request, uuid);
			result.put("updateVariId", uuid);
			result.put("msg", CodeConstant.SUCCESS_SEND);
		}
		return result;
	}

	public void sendTelephoneCode(String telephone, HttpServletRequest request, String uuid) {
		StringBuilder telephoneCode = new StringBuilder();
		Random random = new Random();
		for(int i = 0; i < 6; i++) {
			telephoneCode.append(String.valueOf(random.nextInt(10)));	
		}
		MyJedis jedis = new MyJedis();
		//将验证码存入redis缓存中，并设置过期时间为5分钟。
		jedis.setTimeOut(uuid, telephoneCode.toString());
        try {
        	Sms.sendMessage(telephone, telephoneCode);
        } catch (ApiException e) {
        	e.printStackTrace();
        }
	}

	private boolean isMobile(String mobile) {
		if(mobile == null || mobile.length() == 0) {
			return false;
		} else {
			return Pattern.matches("^((13[0-9])|(14[5,7,9])|(15[^4,\\D])|(17[0,1,3,5-8])|(18[0-9]))\\d{8}$", mobile);
		}
	}
}