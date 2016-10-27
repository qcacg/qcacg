package com.qcacg.controller.system;

import com.qcacg.controller.BaseController;
import com.qcacg.entity.BookTypeEntity;
import com.qcacg.service.system.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/9/21.
 */
@Controller
@RequestMapping("/bookType/")
public class BookTypeContrloller extends BaseController {
    @Autowired
    public BookTypeService bookTypeService;

    /*
    获取分类
     */
    @RequestMapping("queryBookType")
    @ResponseBody
    public List<BookTypeEntity> queryBookType(){
        return this.bookTypeService.queryBookType();
    }
}
