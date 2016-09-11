package com.qcacg.controller.system;

import com.baidu.ueditor.ActionEnter;
import com.qcacg.controller.BaseController;
import com.qcacg.entity.ChapterEntity;
import com.qcacg.entity.ContentEntity;
import com.qcacg.service.system.ChapterService;
import com.qcacg.service.system.ContentService;
import com.qcacg.util.http.ResponseUtils;
import com.qcacg.util.upload.UploadUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * Created by Administrator on 2016/7/4.
 */
@Controller
@RequestMapping("/content/")
public class ContentController extends BaseController {

    @Autowired
    ContentService contentService;
    @Autowired
    ChapterService chapterService;

    @RequestMapping("findContentByChapter")
    @ResponseBody
    public ContentEntity findContentByChapter(Long chapterId)
    {
        return this.contentService.findContentByChapterId(chapterId);
    }




    @RequestMapping("save")
    public void saveContent(HttpServletRequest request, HttpServletResponse response, ContentEntity contentEntity, ChapterEntity chapterEntity,
                            @RequestParam("html")String content,  @RequestParam("chapterName")String chapterName,  @RequestParam("volumeId")Long volumeId) {
        String message = "";
        String error = "";
        String path = "";
        try{
            String filename = UploadUtils.generateFilename("html");
            path = "/upload/file/content" + filename;
            message = path;
            File file =new File(path);
            FileWriter fileWriter = new FileWriter(file.getName());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content);
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        chapterEntity.setChapterName(chapterName);
        chapterEntity.setVolumeId(volumeId);
        this.chapterService.saveOrUpdate(chapterEntity);
        contentEntity.setChapterId(chapterEntity.getChapterId());
        contentEntity.setContent(content);
        contentEntity.setContentUrl(path);
        this.contentService.saveOrUpdate(contentEntity);

        JSONObject obj = new JSONObject();
        obj.put("err", error);
        obj.put("msg", message);
        ResponseUtils.renderText(response, obj.toString());
    }


    @RequestMapping("saveContent")
    @ResponseBody
    public void save(HttpServletRequest request, HttpServletResponse response, ContentEntity contentEntity, ChapterEntity chapterEntity){

        String path = request.getSession().getServletContext().getRealPath("/upload/file/content");

        try {
            String exec = new ActionEnter(request, path).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
            chapterEntity.setChapterName("");
            contentEntity.setContentUrl(path);
            contentEntity.setContent(exec);
            this.contentService.saveOrUpdate(contentEntity);
            this.chapterService.saveOrUpdate(chapterEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @RequestMapping(value = "upload")
    @ResponseBody
    public String upload(@RequestParam(value = "wangEditorH5File", required = false)MultipartFile file, HttpServletRequest request) throws IOException{

        String path = request.getSession().getServletContext().getRealPath("/upload/image/content");
        String fileName = file.getOriginalFilename();
        String newFileName = UUID.randomUUID().toString().replace("-", "") + fileName.substring(fileName.lastIndexOf("."),fileName.length());
        File newFile = new File(path,newFileName);
        if (!newFile.exists())
            newFile.mkdirs();
        file.transferTo(newFile);
        return "http://127.0.0.1:8080"+request.getContextPath()+"/upload/image/content/"+newFileName;
    }


}
