package com.qcacg.controller.system;

import com.qcacg.controller.BaseController;
import com.qcacg.entity.BookEntity;
import com.qcacg.entity.BookHitEntity;
import com.qcacg.service.system.BookHitService;
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
    public List<BookEntity> findBookByUser(HttpServletRequest request)
    {
        //Long userId = UserEntityUtil.getUserFromSession().getUserId();
        String jsessionId = request.getParameter("JSESSIONID");
        Long userId = UserEntityUtil.getUserId(jsessionId);
        return this.bookHitService.findBookHitByUserId(userId);
    }

    /*
    添加浏览记录
     */
    @RequestMapping("saveBookHit")
    @ResponseBody
    public String saveBookHit(HttpServletRequest request,
            BookHitEntity bookHitEntity,
                              @RequestParam("bookId")Long bookId)
    {
        //Long userId = UserEntityUtil.getUserFromSession().getUserId();
        String jsessionId = request.getParameter("JSESSIONID");
        Long userId = UserEntityUtil.getUserId(jsessionId);
        if(userId != null){
            bookHitEntity.setBookId(bookId);
            bookHitEntity.setUserId(userId);
            return this.bookHitService.saveBookHit(bookHitEntity);
        }else{
            return  null;
        }

    }
}
