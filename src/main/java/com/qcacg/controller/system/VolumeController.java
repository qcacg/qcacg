package com.qcacg.controller.system;

import com.qcacg.controller.BaseController;
import com.qcacg.entity.VolumeEntity;
import com.qcacg.service.system.BookService;
import com.qcacg.service.system.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/7/10.
 */
@Controller
@RequestMapping("/volume/")
public class VolumeController extends BaseController {

    @Autowired
    VolumeService volumeService;
    @Autowired
    public BookService bookService;

    @RequestMapping("saveVolume")
    @ResponseBody
    public String saveVolume(VolumeEntity form)
    {
        return this.volumeService.saveOrUpdate(form);
    }

    @RequestMapping("findVolumeByBook")
    @ResponseBody
    public List<VolumeEntity> findVolumeByBook(Long bookId)
    {
        return this.volumeService.findVolumeByBookId(bookId);
    }
}
