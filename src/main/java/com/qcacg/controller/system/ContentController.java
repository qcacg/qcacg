package com.qcacg.controller.system;

import com.qcacg.constant.CodeConstant;
import com.qcacg.controller.BaseController;
import com.qcacg.entity.ContentEntity;
import com.qcacg.service.system.ContentService;
import com.qcacg.util.upload.UploadUtils;
import org.apache.commons.lang3.StringUtils;
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


    @RequestMapping("findContentByVolumeId/{volumeId}")
    @ResponseBody
    public ContentEntity findContentByVolumeId(@PathVariable("volumeId")Long volumeId){
        return this.contentService.findContentByVolumeId(volumeId);
    }

    /*
    保存或修改作品（文本）
    */
    @RequestMapping("saveOrUpdateContent")
    @ResponseBody
    public Map<String,Object> saveOrUpdateContent(HttpServletRequest request, HttpServletResponse response, ContentEntity contentEntity,
                                                  @RequestParam("contentId")Long contentId,
                                                  @RequestParam("html")String html,
                                                  @RequestParam("contentTitle")String contentTitle,
                                                  @RequestParam("formatText")String formatText,
                                                  @RequestParam("volumeId")Long volumeId) {
        //contentId为空就是保存操作
        Map<String,Object> result = new HashMap<String, Object>();
        if("null".equals(contentTitle)
                || "undefined".equals(contentTitle)
                || StringUtils.isBlank(contentTitle)) {
            response.setStatus(CodeConstant.ERROR_CODE);
            result.put("code", CodeConstant.PARAMETER_CODE);
            result.put("msg", CodeConstant.TITLE_IS_NULL);
            return result;
        }
        if("null".equals(formatText)
                || "undefined".equals(formatText)
                || StringUtils.isBlank(formatText)) {
            response.setStatus(CodeConstant.ERROR_CODE);
            result.put("code", CodeConstant.PARAMETER_CODE);
            result.put("msg", CodeConstant.TEXT_IS_NULL);
            return result;
        }
        try{
            String filename = UploadUtils.generateFilename("html");
            String path = "/upload/file/content" + filename;
            File file = new File(path);
            FileOutputStream fileOutputStream = new FileOutputStream(file.getName());
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(contentTitle);
            bufferedWriter.newLine();
            bufferedWriter.write(html);
            bufferedWriter.flush();
            bufferedWriter.close();
            contentEntity.setContentId(contentId);
            contentEntity.setVolumeId(volumeId);
            contentEntity.setContentTitle(contentTitle);
            contentEntity.setContent(html);
            contentEntity.setContentUrl(path);
            contentEntity.setContentWordCount((long)formatText.trim().length());
            this.contentService.saveOrUpdate(contentEntity);
            result.put("msg", CodeConstant.SUCCESS_COMMIT);
        }catch (IOException e){
            response.setStatus(CodeConstant.ERROR_CODE);
            result.put("code", CodeConstant.SYS_CODE);
            result.put("msg", CodeConstant.IO_CODE_MSG);
            result.put("error", e.getMessage());
            e.printStackTrace();
            return result;
        }
        return result;
    }
    /*
    读者读取作品正文（或者作者获取草稿）
    */
    @RequestMapping("findContent")
    @ResponseBody
    public ContentEntity findContent(@RequestParam("contentId")Long contentId){
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
    public Map<String,Object> nextContent (@RequestParam("contentId")Long contentId,
                                           @RequestParam("bookId")Long bookId,
                                           HttpServletResponse response){
        Map<String,Object> result = new HashMap<String, Object>();
        List<String> contentIdList = this.contentIdList(bookId);
        Integer contendIdIndex = contentIdList.indexOf(String.valueOf(contentId));

        if(contendIdIndex < contentIdList.size()-1){
            Long id = Long.valueOf(contentIdList.get(contendIdIndex+1));
            ContentEntity contentEntity = this.contentService.findContentByContentId(id);
            result.put("msg",contentEntity);
            return result;
        }else {
            response.setStatus(CodeConstant.ERROR_CODE);
            result.put("code",CodeConstant.PARAMETER_CODE);
            result.put("msg", CodeConstant.THE_LAST_CONTENT);
            return result;
        }
    }
    /*
    上一章
     */
    @RequestMapping("previousContent")
    @ResponseBody
    public Map<String,Object> previousContent (@RequestParam("contentId")Long contentId,
                                               @RequestParam("bookId")Long bookId,
                                               HttpServletResponse response){
        Map<String,Object> result = new HashMap<String, Object>();
        List<String> contentIdList = this.contentIdList(bookId);
        Integer contendIdIndex = contentIdList.indexOf(String.valueOf(contentId));

        if(contendIdIndex > 0){
            Long id = Long.valueOf(contentIdList.get(contendIdIndex-1));
            ContentEntity contentEntity = this.contentService.findContentByContentId(id);
            result.put("msg",contentEntity);
            return result;
        }else {
            response.setStatus(CodeConstant.ERROR_CODE);
            result.put("code", CodeConstant.PARAMETER_CODE);
            result.put("msg",CodeConstant.THE_FIRST_CONTENT);
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
        return "http://www.qcacg.com/"+request.getContextPath()+"/upload/image/content/"+newFileName;
    }

    /*
   设置文本展示状态
   */
    @RequestMapping("updateContentStatus")
    @ResponseBody
    public Map<String,Object> updateContentStatus(HttpServletResponse response,
                                                  @RequestParam("contentId")Long contentId){
        Map<String,Object> result = new HashMap<String, Object>();
        try{
            this.contentService.updateContentStatus(contentId);
            result.put("msg", CodeConstant.SUCCESS_SET);
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
    /*
   删除内容
   */
    @RequestMapping("deleteContent")
    @ResponseBody
    public Map<String,Object> deleteContent(@RequestParam("contentId")Long contentId,
                                            HttpServletResponse response){
        Map<String,Object> result = new HashMap<String, Object>();
        try{
            this.contentService.delete(contentId);
            result.put("msg", CodeConstant.SUCCESS_DELETE);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(CodeConstant.ERROR_CODE);
            result.put("code", CodeConstant.SYS_CODE);
            result.put("msg", CodeConstant.SQL_CODE_MSG);
            result.put("error", e.getMessage());
            result.put("success",false);
            return result;
        }
    }

}
