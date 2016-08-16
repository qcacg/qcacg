package com.qcacg.controller.system;

import com.qcacg.controller.BaseController;
import com.qcacg.entity.ChapterEntity;
import com.qcacg.service.system.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/7/10.
 */
@Controller
@RequestMapping("/chapter/")
public class ChapterController extends BaseController {
    @Autowired
    ChapterService chapterService;
    @RequestMapping("saveChapter")
    @ResponseBody
    public String saveChapter(ChapterEntity form)
    {
        return this.chapterService.saveOrUpdate(form);
    }

    @RequestMapping("findChapterByVolume")
    @ResponseBody
    public List<ChapterEntity> findChapterByVolume(Long VolumeId)
    {
        return this.chapterService.findChapterByVolumeId(VolumeId);
    }
}
