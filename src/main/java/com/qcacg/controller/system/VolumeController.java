package com.qcacg.controller.system;

import com.qcacg.controller.BaseController;
import com.qcacg.entity.VolumeEntity;
import com.qcacg.entity.volume.VolumeCustom;
import com.qcacg.service.system.BookService;
import com.qcacg.service.system.VolumeCustomService;
import com.qcacg.service.system.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    /*
    新增卷或修改卷名
    */
    @RequestMapping("saveOrUpdateVolume/{bookId}")
    @ResponseBody
    public String saveOrUpdateVolume(VolumeEntity volumeEntity, @RequestParam("volumeName")String volumeName, @PathVariable("bookId")Long bookId)
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
    /*
    获取作品卷章详情
     */
    @RequestMapping("findVolumeAndContentByBookId/{bookId}")
    @ResponseBody
    public List<VolumeCustom> findVolumeAndContentByBookId(@PathVariable("bookId")Long bookId)
    {
        return this.volumeCustomService.findVolumeAndContentByBookId(bookId);
    }
}
