package com.qcacg.system;

//import com.qcacg.controller.system.LoginAndRegisterController;
import com.qcacg.controller.system.RegisterController;
import com.qcacg.controller.system.UserController;
import com.qcacg.entity.ResourcesEntity;
import com.qcacg.entity.RoleEntity;
import com.qcacg.entity.user.UserCustom;
import com.qcacg.mapper.ResourcesMapper;
import com.qcacg.mapper.RoleMapper;
import com.qcacg.service.system.ResourcesService;
import com.qcacg.service.system.RoleService;
import com.qcacg.service.system.UserService;
import com.qcacg.util.Sendsms;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

//import com.qcacg.controller.system.RegisterController;

/**
 * Created by Administrator on 2016/6/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-application.xml" })
public class TestDemo {

    private Logger logger = Logger.getLogger(TestDemo.class);
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    ResourcesService resourcesService;
    @Autowired
    ResourcesMapper resourcesMapper;




    @Test
    public void TestResources(){
        ResourcesEntity resourcesEntity = new ResourcesEntity();
        resourcesEntity.setResourcesId(1l);
        resourcesEntity.setResourcesName("系统管理");
        resourcesEntity.setResourcesDescription("系统管理");
        resourcesEntity.setParentResourcesId(0l);
        resourcesEntity.setResourcesLevel("1");
        resourcesEntity.setResourcesType("0");
        resourcesEntity.setResourcesSort(",1,");
        resourcesEntity.setResourcesView("fa fa-home");
        resourcesEntity.setResourcesOrder("1");
        resourcesService.save(resourcesEntity);
//        resourcesMapper.insert(resourcesEntity);
        logger.info(resourcesEntity);
        System.out.println(resourcesEntity.getResourcesView());
    }

    @Test
    public void TestRole(){
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleId(1l);
        roleEntity.setRoleName("超级管理员");
        roleEntity.setRoleDescription("超级管理员权限");
        roleEntity.setRoleStatus("true");
//        roleMapper.insert(roleEntity);
        roleService.saveOrUpdate(roleEntity);
        logger.info(roleEntity);
        System.out.println(roleEntity.getRoleStatus());

    }
    @Test
    public void TestRegister(){
        UserCustom userCustom = new UserCustom();

        userCustom.setTelephone("12345");
        userCustom.setPassWord("123456");
        userCustom.setUserName("admin");
        userService.register(userCustom);
        logger.info(userCustom);
        System.out.println(userCustom.getCredentialsSalt());
    }

    @Test
    public void TestTelephoneCode(){

        UserCustom userCustom = new UserCustom();
        Sendsms sendsms = new Sendsms();
        RegisterController registerController = new RegisterController();
        userCustom.setTelephone("15067171806");
        userCustom.setTelephoneCode(sendsms.telephoneCode);
        logger.info(userCustom);
        System.out.println(registerController.checksms(userCustom));
    }

    @Test
    public void testUpload() throws Exception{
        UserController userController = new UserController();
        

    }

}
