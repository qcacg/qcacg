package com.qcacg.controller.system;

import com.qcacg.controller.BaseController;
import com.qcacg.entity.BookCollectEntity;
import com.qcacg.entity.BookEntity;
import com.qcacg.service.system.BookCollectService;
import com.qcacg.util.UserEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/7/13.
 */
@Controller
@RequestMapping("/bookCollect/")
public class BookCollectController extends BaseController {

    @Autowired
    BookCollectService bookCollectService;


    /*
    获取用户收藏记录
     */
    @RequestMapping("findBookCollectByUser")
    @ResponseBody
    public List<BookEntity> findBookByUser()
    {
        Long userId = UserEntityUtil.getUserFromSession().getUserId();
        return this.bookCollectService.findBookCollectByUserId(userId);
    }

    /*
    添加或删除收藏
     */
    @RequestMapping("saveOrDeleteBookCollect/{bookId}")
    @ResponseBody
    public String saveOrDeleteBookCollect(BookCollectEntity bookCollectEntity, @PathVariable("bookId")Long bookId)
    {
        Long userId = UserEntityUtil.getUserFromSession().getUserId();
        bookCollectEntity.setBookId(bookId);
        bookCollectEntity.setUserId(userId);
        return this.bookCollectService.saveOrDeleteBookCollect(bookCollectEntity);
    }
}
