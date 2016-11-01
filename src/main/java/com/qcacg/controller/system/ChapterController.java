package com.qcacg.controller.system;

import com.qcacg.constant.CodeConstant;
import com.qcacg.controller.BaseController;
import com.qcacg.entity.ChapterEntity;
import com.qcacg.service.system.ChapterService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 章节
 * Created by Administrator on 2016/7/10.
 */
@Controller
@RequestMapping("/chapter/")
public class ChapterController extends BaseController {
    @Autowired
    ChapterService chapterService;


    @RequestMapping("saveChapter")
    @ResponseBody
    public Map<String, String> saveChapter(ChapterEntity chapterEntity, HttpServletResponse response,
                              @RequestParam("chapterName")String chapterName,
                              @RequestParam("volumeId")Long volumeId)
    {
        Map<String, String> map = new HashMap<String, String>();
        if("null".equals(chapterName)
                || "undefined".equals(chapterName)
                || StringUtils.isBlank(chapterName)) {
            response.setStatus(CodeConstant.ERROR_CODE);
            map.put("code", CodeConstant.PARAMETER_CODE);
            map.put("msg", CodeConstant.CHAPTER_NAME_ERROR);
            return map;
        }
        if(chapterName.trim().length() > 15) {
            response.setStatus(CodeConstant.ERROR_CODE);
            map.put("code", CodeConstant.PARAMETER_CODE);
            map.put("msg", CodeConstant.CHAPTERNAME_TOO_LONG);
            return map;
        }
        chapterEntity.setVolumeId(volumeId);
        chapterEntity.setChapterName(chapterName);
        this.chapterService.saveOrUpdate(chapterEntity);
        map.put("msg", CodeConstant.SUCCESS_SAVE);
        return map;
    }

    @RequestMapping("findChapterByVolume")
    @ResponseBody
    public List<ChapterEntity> findChapterByVolume(Long VolumeId)
    {
        return this.chapterService.findChapterByVolumeId(VolumeId);
    }
}
