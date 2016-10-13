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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @RequestMapping("saveOrUpdateVolume")
    @ResponseBody
    public Map<String, Object> saveOrUpdateVolume(@RequestParam("volumeName")String volumeName, @RequestParam("volumeId")Long volumeId, @RequestParam("bookId")Long bookId)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        VolumeEntity volumeEntity = new VolumeEntity();
        volumeEntity.setVolumeId(volumeId);
        volumeEntity.setBookId(bookId);
        volumeEntity.setVolumeName(volumeName);
        this.volumeService.saveOrUpdate(volumeEntity);
        map.put("volumeEntity",volumeEntity);
        map.put("success",true);
        return map;
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
    /*
   删除章节
   */
    @RequestMapping("deleteVolume")
    @ResponseBody
    public Map<String,Object> deleteContent(@RequestParam("volumeId")Long volumeId){
        Map<String,Object> result = new HashMap<String, Object>();
        try{
            this.volumeService.delete(volumeId);
            result.put("success",true);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            result.put("success",false);
            return result;
        }
    }
}
