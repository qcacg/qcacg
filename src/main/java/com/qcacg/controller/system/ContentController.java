package com.qcacg.controller.system;

import com.qcacg.controller.BaseController;
import com.qcacg.entity.ContentEntity;
import com.qcacg.service.system.ContentService;
import com.qcacg.util.http.ResponseUtils;
import com.qcacg.util.upload.UploadUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * Created by Administrator on 2016/7/4.
 */
@Controller
@RequestMapping("/content/")
public class ContentController extends BaseController {

    @Autowired
    ContentService contentService;

    /*
    获取草稿
    */
    @RequestMapping("findContentByVolumeId/{volumeId}")
    @ResponseBody
    public ContentEntity findContentByVolumeId(@PathVariable("volumeId")Long volumeId){
        return this.contentService.findContentByVolumeId(volumeId);
    }

    /*
    保存作品（文本）
    */
    @RequestMapping("saveOrUpdateContent/{volumeId}")
    public void saveOrUpdateContent(HttpServletRequest request, HttpServletResponse response, ContentEntity contentEntity,
                            @RequestParam("html")String html,  @RequestParam("contentTitle")String contentTitle,  @PathVariable("volumeId")Long volumeId) {
        String message = "";
        String error = "";
        String path = "";
        try{
            String filename = UploadUtils.generateFilename("html");
            path = "/upload/file/content" + filename;
            message = path;
            File file = new File(path);
            FileOutputStream fileOutputStream = new FileOutputStream(file.getName());
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(contentTitle);
            bufferedWriter.newLine();
            bufferedWriter.write(html);
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        contentEntity.setVolumeId(volumeId);
        contentEntity.setContentTitle(contentTitle);
        contentEntity.setContent(html);
        contentEntity.setContentUrl(path);
        this.contentService.saveOrUpdate(contentEntity);

        JSONObject obj = new JSONObject();
        obj.put("err", error);
        obj.put("msg", message);
        ResponseUtils.renderText(response, obj.toString());
    }
    /*
    读者读取作品正文（或者作者获取草稿）
    */
    @RequestMapping("findContent/{contentId}")
    @ResponseBody
    public ContentEntity findContent(@PathVariable("contentId")Long contentId){
        return this.contentService.findContentByContentId(contentId);
    }

    public List<String> contentIdList(Long bookId){
        List<ContentEntity> contentEntityList = this.contentService.findContentByBookId(bookId);
        List<String> contentIdList = new ArrayList<String>();
        for(ContentEntity contentEntity : contentEntityList){
            contentIdList.add(String.valueOf(contentEntity.getContentId()));
        }
        return contentIdList;
    }
    /*
    下一章
     */
    @RequestMapping("nextContent")
    @ResponseBody
    public Map<String,Object> nextContent (@RequestParam("contentId")Long contentId,@RequestParam("bookId")Long bookId){
        Map<String,Object> result = new HashMap<String, Object>();
        if(this.contentIdList(bookId).contains(String.valueOf(contentId+1))){
            ContentEntity contentEntity = this.contentService.findContentByContentId(contentId+1);
            result.put("success",true);
            result.put("contentEntity",contentEntity);
            return result;
        }else {
            result.put("success",false);
            result.put("msg","已经是最后一章了。");
            return result;
        }
    }
    /*
    上一章
     */
    @RequestMapping("previousContent")
    @ResponseBody
    public Map<String,Object> previousContent (@RequestParam("contentId")Long contentId,@RequestParam("bookId")Long bookId){
        Map<String,Object> result = new HashMap<String, Object>();
        if(this.contentIdList(bookId).contains(String.valueOf(contentId-1))){
            ContentEntity contentEntity = this.contentService.findContentByContentId(contentId-1);
            result.put("success",true);
            result.put("contentEntity",contentEntity);
            return result;
        }else {
            result.put("success",false);
            result.put("msg","已经到最前一章了。");
            return result;
        }
    }


    /*
    上传图片
    */
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
