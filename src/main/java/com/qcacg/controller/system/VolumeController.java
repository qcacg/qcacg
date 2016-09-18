package com.qcacg.controller.system;

import com.qcacg.controller.BaseController;
import com.qcacg.entity.VolumeEntity;
import com.qcacg.entity.volume.VolumeCustom;
import com.qcacg.service.system.BookService;
import com.qcacg.service.system.VolumeCustomService;
import com.qcacg.service.system.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/7/10.
 */
@Controller
@RequestMapping("/volume/")
public class VolumeController extends BaseController {
    @Autowired
    VolumeCustomService volumeCustomService;
    @Autowired
    VolumeService volumeService;
    @Autowired
    public BookService bookService;

    @RequestMapping("saveVolume")
    @ResponseBody
    public String saveVolume(VolumeEntity volumeEntity, @RequestParam("volumeName")String volumeName, @RequestParam("bookId")Long bookId)
    {
        volumeEntity.setBookId(bookId);
        volumeEntity.setVolumeName(volumeName);
        return this.volumeService.saveOrUpdate(volumeEntity);
    }

    @RequestMapping("findVolumeByBook")
    @ResponseBody
    public List<VolumeEntity> findVolumeByBook(@RequestParam("bookId")Long bookId)
    {
        return this.volumeService.findVolumeByBookId(bookId);
    }

    @RequestMapping("findVolumeAndContentByBookId")
    @ResponseBody
    public List<VolumeCustom> findVolumeAndContentByBookId(@RequestParam("bookId")Long bookId)
    {
        return this.volumeCustomService.findVolumeAndContentByBookId(bookId);
    }
}
