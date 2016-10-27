package com.qcacg.controller.system;

import com.qcacg.entity.BookAndBookTypeEntity;
import com.qcacg.service.system.BookAndBookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/9/22.
 */
@Controller
@RequestMapping("/bookAndBookType/")
public class BookAndBookTypeController {

    @Autowired
    BookAndBookTypeService bookAndBookTypeService;

    /*
    获取作品分类
     */
    @RequestMapping("findBookTypeByBookId")
    @ResponseBody
    public List<BookAndBookTypeEntity> findBookTypeByBookId(Long bookId){

        return this.bookAndBookTypeService.findBookTypeByBookId(bookId);

    }


}
