package com.qcacg.controller.system;

import com.qcacg.controller.BaseController;
import com.qcacg.entity.BookCollectEntity;
import com.qcacg.service.system.BookCollectService;
import com.qcacg.util.UserEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping("saveOrDelete")
    @ResponseBody
    public String saveOrDelete(BookCollectEntity form)
    {
        return this.bookCollectService.saveOrDelete(form);
    }

    @RequestMapping("findBookCollectByUser")
    @ResponseBody
    public List<BookCollectEntity> findBookByUser()
    {
        Long userId = UserEntityUtil.getUserFromSession().getUserId();
        return this.bookCollectService.findBookCollectByUserId(userId);
    }
}
