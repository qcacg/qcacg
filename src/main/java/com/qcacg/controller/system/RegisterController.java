package com.qcacg.controller.system;

import com.qcacg.entity.UserEntity;
import com.qcacg.entity.user.UserCustom;
import com.qcacg.entity.user.UserQauryVo;
import com.qcacg.service.system.UserService;
import com.qcacg.util.Sms;
import com.taobao.api.ApiException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
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
    if(!telephoneCode.equals(inputTelephoneCode)){
        String telephoneCodeError = "验证码不正确";
        model.addAttribute("telephoneCodeError", telephoneCodeError);
        model.addAttribute("userCustom", userCustom);
        return "register";
    }
    if (!userCustom.getPassWord().equals(userCustom.getPassWordConfirm())){
        //两次输入的密码不一致
        String passWordConfirmError = "两次输入的密码必须一致";
        model.addAttribute("passWordConfirmError", passWordConfirmError);
        model.addAttribute("userCustom", userCustom);
        return "register";
    }
    userService.register(userCustom);
    return "redirect:/login.shtml";
}
    @RequestMapping("sendTelephoneCode")
    @ResponseBody
    public void checkTelephoneCode(String telephone, HttpServletRequest request) throws ApiException {
        StringBuilder telephoneCode = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            telephoneCode.append(String.valueOf(random.nextInt(10)));
        }
        HttpSession session = request.getSession();
        session.setAttribute(VALIDATE_TELEPHONE,telephone);
        session.setAttribute(VALIDATE_TELEPHONE_CODE,telephoneCode.toString());
        session.setAttribute(SEND_CODE_TIME, new Date().getTime());
        Sms.sendMessage(telephone, telephoneCode);
    }


    @RequestMapping(value ="toUpdatePassword")
    public String toUpdatePassword(){
        return "updatePassword";
    }

    @RequestMapping("updatePassword")
    public String updatePassWord(Model model, @RequestParam(value = "telephone") String telephone,
                                 @RequestParam(value = "oldPassWord") String oldPassWord,
                                 @RequestParam(value = "newPassWord") String newPassword,
                                 @RequestParam(value = "passWordConfirm") String passWordConfirm){


        UserEntity userEntity = this.userService.findByLoginName(telephone);
        String inputPassWord = new SimpleHash("md5", oldPassWord, ByteSource.Util.bytes(telephone+userEntity.getCredentialsSalt()), 2).toHex();
        if(!inputPassWord.equals(userEntity.getPassWord())) {
            String passWordError = "原密码错误";
            model.addAttribute("passWordError", passWordError);
            model.addAttribute("newPassword", telephone);
            model.addAttribute("newPassword", newPassword);
            model.addAttribute("oldPassWord", oldPassWord);
            model.addAttribute("oldPassWord", passWordConfirm);
            return "updatePassword";
        }
        if(newPassword.equals(oldPassWord)){
            String samePassWord = "新旧密码不能相同";
            model.addAttribute("samePassWord", samePassWord);
            model.addAttribute("newPassword", telephone);
            model.addAttribute("newPassword", newPassword);
            model.addAttribute("oldPassWord", oldPassWord);
            model.addAttribute("oldPassWord", passWordConfirm);
            return "updatePassword";
        }
        if (!newPassword.equals(passWordConfirm)){
            String passWordConfirmError = "确认密码和新密码必须一致";
            model.addAttribute("passWordConfirmError", passWordConfirmError);
            model.addAttribute("newPassword", telephone);
            model.addAttribute("newPassword", newPassword);
            model.addAttribute("oldPassWord", oldPassWord);
            model.addAttribute("oldPassWord", passWordConfirm);
            return "updatePassword";
        }

        userService.updatePassWord(telephone, newPassword);
        return "redirect:/login.shtml";

    }


}
