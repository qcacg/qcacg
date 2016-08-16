package com.qcacg.system;

import com.qcacg.controller.system.RegisterController;
import com.qcacg.controller.system.RoleController;
import com.qcacg.entity.*;
import com.qcacg.entity.user.UserCustom;
import com.qcacg.mapper.ResourcesMapper;
import com.qcacg.mapper.RoleMapper;
import com.qcacg.service.system.*;
import com.qcacg.util.SendTelephoneCode;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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
    @Autowired
    BookService bookService;
    @Autowired
    VolumeService volumeService;
    @Autowired
    ChapterService chapterService;
    @Autowired
    BookCollectService bookCollectService;








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
        RoleController roleController = new RoleController();
        logger.info(roleEntity);
        System.out.println(roleController.queryRoleForList());

    }
    @Test
    public void TestRegister(){
        UserCustom userCustom = new UserCustom();
        userCustom.setUserId(1l);
        userCustom.setTelephone("15067171806");
        userCustom.setPassWord("123456");
        userCustom.setUserName("admin");
        userService.register(userCustom);
        logger.info(userCustom);
        System.out.println(userCustom.getCredentialsSalt());
    }

//    @Test
//    public void TestTelephoneCode(){
//
//        UserCustom userCustom = new UserCustom();
//        SendTelephoneCode sendTelephoneCode = new SendTelephoneCode();
//        RegisterController registerController = new RegisterController();
//        userCustom.setTelephone("15067171806");
//        userCustom.setTelephoneCode(sendTelephoneCode.telephoneCode);
//        logger.info(userCustom);
//        System.out.println(registerController.checkTelephoneCode(userCustom));
//    }

    @Test
    public void TestBook(){
//        List<BookEntity> list = this.bookService.findBookByUserId(1l);
//        List<VolumeEntity> list = this.volumeService.findVolumeByBookId(1l);
        List<ChapterEntity> list = this.chapterService.findChapterByVolumeId(1l);
        System.out.println(list.get(1).getChapterName());
    }

    @Test
    public void TestVolume(){

        VolumeEntity volumeEntity = new VolumeEntity();
        volumeEntity.setBookId(1l);
        volumeEntity.setVolumeName("第一卷");
        this.volumeService.saveOrUpdate(volumeEntity);
        logger.info(volumeEntity);
        System.out.println(volumeEntity.getVolumeName());
    }

    @Test
    public void TestChapter(){

        ChapterEntity chapterEntity = new ChapterEntity();
        chapterEntity.setVolumeId(1l);
        chapterEntity.setChapterName("心中的困惑");
        this.chapterService.saveOrUpdate(chapterEntity);
        logger.info(chapterEntity);
        System.out.println(chapterEntity.getChapterName());
    }

    @Test
    public void TestBookCollect(){

        BookCollectEntity bookCollectEntity = new BookCollectEntity();
//        bookCollectEntity.setBookCollectId(4l);
        bookCollectEntity.setBookId(2l);
        bookCollectEntity.setUserId(1l);
        this.bookCollectService.saveOrDelete(bookCollectEntity);
        logger.info(bookCollectEntity);
        System.out.println(bookCollectEntity.getBookCollectDate());
    }
}
