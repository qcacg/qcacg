package com.qcacg.controller.system;

import com.qcacg.controller.BaseController;
import com.qcacg.entity.BookEntity;
import com.qcacg.entity.BookHitEntity;
import com.qcacg.service.system.BookHitService;
import com.qcacg.util.UserEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27.
 */
@Controller
@RequestMapping("/bookHit/")
public class BookHitController extends BaseController {

    @Autowired
    BookHitService bookHitService;

    /*
    获取用户浏览记录
     */
    @RequestMapping("findBookHitByUser")
    @ResponseBody
    public List<BookEntity> findBookByUser()
    {
        Long userId = UserEntityUtil.getUserFromSession().getUserId();
        return this.bookHitService.findBookHitByUserId(userId);
    }

    /*
    添加浏览记录
     */
    @RequestMapping("saveOrDeleteBookHit")
    @ResponseBody
    public String saveOrDeleteBookCollect(BookHitEntity bookHitEntity, @RequestParam("bookId")Long bookId)
    {
        Long userId = UserEntityUtil.getUserFromSession().getUserId();
        bookHitEntity.setBookId(bookId);
        bookHitEntity.setUserId(userId);
        return this.bookHitService.saveBookHit(bookHitEntity);
    }
}
