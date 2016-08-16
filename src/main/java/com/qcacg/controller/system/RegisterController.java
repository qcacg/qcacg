package com.qcacg.controller.system;

import com.qcacg.entity.user.UserCustom;
import com.qcacg.entity.user.UserQauryVo;
import com.qcacg.service.system.UserService;
import com.qcacg.util.Result;
import com.qcacg.util.Sendsms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2016/6/16.
 */
@RestController
public class RegisterController {
    @Autowired
    private UserService userService;

    Result result = new Result();


    @RequestMapping(value ="/register", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public Result register(Model model, @Validated UserCustom userCustom, BindingResult bindingResult, HttpServletResponse response) throws Exception{



        if(bindingResult.hasErrors()){

            String telephoneError = null;
            String passWordError = null;
            String userNameError = null;

            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for(ObjectError error : allErrors){
                String errorType = error.getCodes()[1];
                System.out.println(errorType);

                if(errorType.equals("NotEmpty.telephone")){
                    telephoneError = "手机不能为空";
                    result.setMsg(telephoneError);
                    result.setSuccess(false);
                    return result;
                }
                else if(errorType.equals("Size.passWord")){
                    passWordError = "密码长度为6到16个数字或字符";
                    result.setMsg(passWordError);
                    result.setSuccess(false);
                    return result;
                }
                else if(userNameError.equals("NotEmpty.userName")){
                    userNameError = "昵称不能为空";
                    result.setMsg(userNameError);
                    result.setSuccess(false);
                    return result;
                }
            }

//            model.addAttribute("telephoneError", telephoneError);
//            model.addAttribute("passWordError", passWordError);
//            return "register";


        }
        else if (userCustom.getPassWord().equals(userCustom.getPassWordConfirm()) == false){
            //两次输入的密码不一致
            String passWordConfirmError = "两次输入的密码必须一致";
//            model.addAttribute("passWordConfirmError", passWordConfirmError);
//            return "register";
            result.setMsg(passWordConfirmError);
            result.setSuccess(false);
            return result;
        }

        else{
            String sameTelephone = null;
            String sameUserName = null;
            //查询信息重复条件类
            UserQauryVo userQauryVo = new UserQauryVo();
            userQauryVo.setUserCustom(userCustom);
            if(userService.findByLoginName(userQauryVo.getUserCustom().getUserName()) != null){
                sameUserName = "昵称已经被使用过了！";
                result.setMsg(sameUserName);
                return result;
            }
            if(userService.findByLoginName(userQauryVo.getUserCustom().getTelephone()) != null){
                //用户名重复

                sameTelephone = "该手机号码已经注册过了！";
//                model.addAttribute("sameTelephone", sameTelephone);
//                return "register";
                result.setMsg(sameTelephone);
                result.setSuccess(false);
                return result;

            }
            else if(checksms(userCustom) == false){
                String telephoneCodeError = "验证码不正确";
//                model.addAttribute("telephoneCodeError", telephoneCodeError);
//                return "register";
                result.setMsg(telephoneCodeError);
                result.setSuccess(false);
                return result;

            }
        }
        userService.register(userCustom);

        result.setSuccess(true);
        return result;

    }

    public boolean checksms(UserCustom userCustom){

        Sendsms sendsms = new Sendsms();
        sendsms.sendTelepheoneCode(userCustom);
        if(sendsms.telephoneCode.equals(userCustom.getTelephoneCode())){
            return true;
        }
        return false;
    }



}
