package com.qcacg.controller.system;

import com.qcacg.constant.CodeConstant;
import com.qcacg.controller.BaseController;
import com.qcacg.entity.VolumeEntity;
import com.qcacg.entity.volume.VolumeCustom;
import com.qcacg.service.system.BookService;
import com.qcacg.service.system.VolumeCustomService;
import com.qcacg.service.system.VolumeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
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
    public Map<String, Object> saveOrUpdateVolume(@RequestParam("volumeName")String volumeName,
                                                  @RequestParam("volumeId")Long volumeId,
                                                  @RequestParam("bookId")Long bookId,
                                                  HttpServletResponse response)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        if("null".equals(volumeName)
                || "undefined".equals(volumeName)
                || StringUtils.isBlank(volumeName)) {
            response.setStatus(CodeConstant.ERROR_CODE);
            map.put("code", CodeConstant.PARAMETER_CODE);
            map.put("msg", CodeConstant.VOLUMENAME_IS_NULL);
            return map;
        }
        if(volumeName.trim().length() > 15) {
            response.setStatus(CodeConstant.ERROR_CODE);
            map.put("code", CodeConstant.PARAMETER_CODE);
            map.put("msg", CodeConstant.VOLUMENAME_TOO_LONG);
            return map;
        }
        VolumeEntity volumeEntity = new VolumeEntity();
        volumeEntity.setVolumeId(volumeId);
        volumeEntity.setBookId(bookId);
        volumeEntity.setVolumeName(volumeName);
        this.volumeService.saveOrUpdate(volumeEntity);
        map.put("msg",volumeEntity);
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
   删除卷
   */
    @RequestMapping("deleteVolume")
    @ResponseBody
    public Map<String,Object> deleteContent(@RequestParam("volumeId")Long volumeId,
                                            HttpServletResponse response){
        Map<String,Object> result = new HashMap<String, Object>();
        try{
            this.volumeService.delete(volumeId);
            result.put("msg", CodeConstant.SUCCESS_DELETE);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(CodeConstant.ERROR_CODE);
            result.put("code", CodeConstant.SYS_CODE);
            result.put("msg", CodeConstant.SQL_CODE_MSG);
            result.put("error", e.getMessage());
            return result;
        }
    }
}
