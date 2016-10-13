package com.qcacg.controller.system;

import com.qcacg.entity.UserEntity;
import com.qcacg.entity.user.UserCustom;
import com.qcacg.entity.user.UserQauryVo;
import com.qcacg.service.system.UserService;
import com.qcacg.util.Sms;
import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Administrator on 2016/6/16.
 */
@Controller
public class RegisterController {

    private static final String VALIDATE_TELEPHONE_CODE = "VALIDATE_TELEPHONE_CODE";
    private static final String VALIDATE_TELEPHONE = "VALIDATE_TELEPHONE";
    private static final String SEND_CODE_TIME = "SEND_CODE_TIME";

    @Autowired
    private UserService userService;

    @RequestMapping("toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    public String register(HttpServletRequest request, Model model, UserCustom userCustom) throws Exception{

        UserQauryVo userQauryVo = new UserQauryVo();
        userQauryVo.setUserCustom(userCustom);
        if(userService.findByLoginName(userQauryVo.getUserCustom().getTelephone()) != null){
            //用户名重复
            String sameTelephone = "该手机号码已经注册过了";
            model.addAttribute("sameTelephone", sameTelephone);
            model.addAttribute("userCustom", userCustom);
            return "register";
        }
    HttpSession session = request.getSession();
    String telephoneCode = (String) session.getAttribute(VALIDATE_TELEPHONE_CODE);
    String inputTelephoneCode = request.getParameter("telephoneCode");
    if(!inputTelephoneCode.equals(telephoneCode)){
        String telephoneCodeError = "验证码不正确";
        model.addAttribute("telephoneCodeError", telephoneCodeError);
        model.addAttribute("userCustom", userCustom);
        return "register";
    }
    if (!userCustom.getPassWord().equals(userCustom.getPassWordConfirm())){
        String passWordConfirmError = "两次输入的密码必须一致";
        model.addAttribute("passWordConfirmError", passWordConfirmError);
        model.addAttribute("userCustom", userCustom);
        return "register";
    }

    userService.register(userCustom);
    return "redirect:/login.shtml";
}

    public void sendTelephoneCode(String telephone, HttpServletRequest request){
        StringBuilder telephoneCode = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            telephoneCode.append(String.valueOf(random.nextInt(10)));
        }
        HttpSession session = request.getSession();
        session.setAttribute(VALIDATE_TELEPHONE,telephone);
        session.setAttribute(VALIDATE_TELEPHONE_CODE,telephoneCode.toString());
        session.setAttribute(SEND_CODE_TIME, new Date().getTime());
        try {
            Sms.sendMessage(telephone, telephoneCode);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("registerTelephoneCode")
    @ResponseBody
    public Map<String,Object> registerTelephoneCode(String telephone, HttpServletRequest request) throws ApiException {

        Map<String,Object> result = new HashMap<String, Object>();
        if(this.userService.findByLoginName(telephone) != null){
            result.put("success",false);
            result.put("msg","该手机号码已经注册过了");

        }else{
            this.sendTelephoneCode(telephone,request);
            result.put("success",true);
        }
        return result;
    }


    @RequestMapping(value ="toUpdatePassword")
    public String toUpdatePassword(){
        return "updatePassword";
    }

    @RequestMapping("updatePassword")
    public String updatePassWord(HttpServletRequest request,Model model, UserCustom userCustom,@RequestParam(value = "passWord") String passWord){


        HttpSession session = request.getSession();
        String telephoneCode = (String) session.getAttribute(VALIDATE_TELEPHONE_CODE);
        String inputTelephoneCode = request.getParameter("telephoneCode");
        if(!telephoneCode.equals(inputTelephoneCode)){
            String telephoneCodeError = "验证码不正确";
            model.addAttribute("telephoneCodeError", telephoneCodeError);
            model.addAttribute("userCustom", userCustom);
            return "updatePassword";
        }
        if (!userCustom.getPassWord().equals(userCustom.getPassWordConfirm())){
            String passWordConfirmError = "两次输入的密码必须一致";
            model.addAttribute("passWordConfirmError", passWordConfirmError);
            model.addAttribute("userCustom", userCustom);
            return "updatePassword";
        }
        UserEntity userEntity = this.userService.findByLoginName(userCustom.getTelephone());
        userService.updatePassWord(userEntity,passWord);
        return "redirect:/login.shtml";

    }

    @RequestMapping("updatePasswordTelephoneCode")
    @ResponseBody
    public Map<String,Object> updatePasswordTelephoneCode(String telephone, HttpServletRequest request) throws ApiException {

        Map<String,Object> result = new HashMap<String, Object>();
        if(this.userService.findByLoginName(telephone) == null){
            result.put("success",false);
            result.put("msg","该手机号码还未注册过");

        }else{
            this.sendTelephoneCode(telephone,request);
            result.put("success",true);
        }
        return result;
    }

}
