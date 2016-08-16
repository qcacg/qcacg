//package com.qcacg.controller.system;
//
//import com.qcacg.entity.UserEntity;
//import com.qcacg.service.system.UserService;
//import com.qcacg.util.Md5Util;
//import com.qcacg.util.Result;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpSession;
//import java.util.Map;
//
///**
// * Created by Administrator on 2016/6/25.
// */
//@RestController
//public class LoginAndRegisterController {
//    @Resource
//    private UserService userService;
//
//    @RequestMapping("/register")
//    public Result register(UserEntity userEntity){
//        boolean b = userService.createUserEntity(userEntity);
//        return new Result(b);
//    }
//
//
//    @RequestMapping("/login")
//    public Result login(@RequestParam(value = "telephone", required = true) String telephone,
//                        @RequestParam(value = "password", required = true) String passWord, HttpSession session){
//        Map<String, Object> data = userService.checkUserEntity(telephone, passWord);
//        if("0".equals(data.get("flag").toString())){
//            UserEntity userEntity = userService.findByLoginName(telephone);
//            data.put("userEntity", userEntity);
//            session.setAttribute("userEntity", userEntity);
//        }
//        return new Result();
//    }
//
//    @RequestMapping("/logout")
//    public Result logout(HttpSession httpSession){
//        httpSession.invalidate();
//        return new Result();
//    }
//
//    @RequestMapping("/changePassWord")
//    public Result changePassWord(String lastPassWord, String newPassWord, HttpSession httpSession){
//        UserEntity userEntity = (UserEntity) httpSession.getAttribute("userEntity");
//        if(userEntity.getPassWord().equals(Md5Util.md5(lastPassWord))){
//            userEntity.setPassWord(Md5Util.md5(newPassWord));
//            userService.update(userEntity);
//            return  new Result("修改成功");
//        }else {
//            return  new Result("原密码错误");
//        }
//    }
//}
