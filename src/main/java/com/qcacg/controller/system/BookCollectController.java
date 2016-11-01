package com.qcacg.controller.system;

import com.qcacg.controller.BaseController;
import com.qcacg.entity.BookCollectEntity;
import com.qcacg.entity.BookEntity;
import com.qcacg.service.system.BookCollectService;
import com.qcacg.util.MyJedis;
import com.qcacg.util.UserEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
    public List<BookEntity> findBookByUser(HttpServletRequest request)
    {
        //Long userId = UserEntityUtil.getUserFromSession().getUserId();
        String jsessionId = request.getParameter("JSESSIONID");
        Long userId = UserEntityUtil.getUserId(jsessionId);
        return this.bookCollectService.findBookCollectByUserId(userId);
    }

    /*
    添加或删除收藏
     */
    @RequestMapping("saveOrDeleteBookCollect")
    @ResponseBody
    public String saveOrDeleteBookCollect(HttpServletRequest request,
                                          BookCollectEntity bookCollectEntity,
                                          @RequestParam("bookId")Long bookId)
    {
        //Long userId = UserEntityUtil.getUserFromSession().getUserId();
        String jsessionId = request.getParameter("JSESSIONID");
        Long userId = UserEntityUtil.getUserId(jsessionId);
        bookCollectEntity.setBookId(bookId);
        bookCollectEntity.setUserId(userId);
        return this.bookCollectService.saveOrDeleteBookCollect(bookCollectEntity);
    }
}
