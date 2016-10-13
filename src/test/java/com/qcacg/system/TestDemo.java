package com.qcacg.system;

import com.alibaba.fastjson.JSON;
import com.qcacg.controller.system.RoleController;
import com.qcacg.entity.*;
import com.qcacg.entity.book.BookCustom;
import com.qcacg.entity.user.UserCustom;
import com.qcacg.entity.volume.VolumeCustom;
import com.qcacg.service.system.*;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
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
//    @Autowired
//    RoleMapper roleMapper;
    @Autowired
    ResourcesService resourcesService;
//    @Autowired
//    ResourcesMapper resourcesMapper;
    @Autowired
    BookService bookService;
    @Autowired
    VolumeService volumeService;
    @Autowired
    ContentService contentService;
    @Autowired
    VolumeCustomService volumeCustomService;
    @Autowired
    BookAndBookTypeService bookAndBookTypeService;
    @Autowired
    BookCollectService bookCollectService;
    @Autowired
    BookHitService bookHitService;
    @Autowired
    BookCustomService bookCustomService;


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

//    @Test
//    public void TestBook(){
//        List<BookEntity> list = this.bookService.findBookByUserId(1l);
//        List<VolumeEntity> list = this.volumeService.findVolumeByBookId(1l);
//        List<ChapterEntity> list = this.chapterService.findChapterByVolumeId(1l);
//        System.out.println(list.get(1).getChapterName());
//    }

    @Test
    public void TestVolume(){

        VolumeEntity volumeEntity = new VolumeEntity();
        volumeEntity.setBookId(1l);
        volumeEntity.setVolumeId(3l);
        volumeEntity.setVolumeName("第一卷");
        this.volumeService.saveOrUpdate(volumeEntity);
        logger.info(volumeEntity);

    }

    @Test
    public void TestContent(){

        ContentEntity contentEntity = new ContentEntity();
        contentEntity.setContentId(9l);
        contentEntity.setVolumeId(3l);
        contentEntity.setContentTitle("<p>哈哈哈美好的一天啊啊啊<p>");
        this.contentService.saveOrUpdate(contentEntity);
        logger.info(contentEntity);

    }

    @Test
    public void TestBookCollect(){

        List<BookEntity> bookEntityList=this.bookCollectService.findBookCollectByUserId(1l);
        logger.info(JSON.toJSONString(bookEntityList));
    }
@Test
public void TestFindContent() {

    ContentEntity contentEntity = this.contentService.findContentByContentId(6l);

    logger.info(JSON.toJSONString(contentEntity));
}
    @Test
    public void TestFindBook() {

        List<VolumeCustom> volumeCustomList = this.volumeCustomService.findVolumeAndContentByBookId(1l);

        logger.info(JSON.toJSONString(volumeCustomList));
    }
    @Test
    public void TestBookAndBookType(){
        Long bookId = 1l;
        List<BookAndBookTypeEntity> bookAndBookTypeEntityList = new ArrayList<BookAndBookTypeEntity>();
        for(int i = 0;i < 5;i++){
            BookAndBookTypeEntity bookAndBookTypeEntity = new BookAndBookTypeEntity();

            bookAndBookTypeEntity.setBookId(bookId);
            bookAndBookTypeEntity.setBookTypeId((long) (RandomUtils.nextInt(17)+1));
            bookAndBookTypeEntityList.add(bookAndBookTypeEntity);
        }
        this.bookAndBookTypeService.saveOrUpdateBookType(bookAndBookTypeEntityList,bookId);
        logger.info(JSON.toJSONString(bookAndBookTypeEntityList));


    }

    @Test
    public void TestSaveBook(){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookId(8l);
        bookEntity.setUserId(1l);
        bookEntity.setBookName("了不起的盖茨比");
        bookEntity.setSort("少年");
        bookEntity.setBookIntroduction("与人斗其乐无穷");
        this.bookService.insertBook(bookEntity);
        System.out.println(bookEntity.getBookId());
    }
    @Test
    public void TestBookHit(){
        BookHitEntity bookHitEntity = new BookHitEntity();
        bookHitEntity.setBookId(6l);
        bookHitEntity.setUserId(1l);
        this.bookHitService.saveBookHit(bookHitEntity);
    }
    @Test
    public void TestQueryBook(){
        BookCustom bookCustom = this.bookCustomService.queryBook(1l);
        logger.info(JSON.toJSONString(bookCustom));
    }
}
