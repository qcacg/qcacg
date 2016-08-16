package com.qcacg.controller.system;

import com.qcacg.controller.BaseController;
import com.qcacg.entity.ContentEntity;
import com.qcacg.service.system.ContentService;
import com.qcacg.util.http.ResponseUtils;
import com.qcacg.util.upload.FileRepository;
import com.qcacg.util.upload.UploadUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Administrator on 2016/7/4.
 */
@Controller
@RequestMapping("/content/")
public class ContentController extends BaseController {
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    ContentService contentService;

    @RequestMapping("findContentByChapter")
    @ResponseBody
    public ContentEntity findContentByChapter(Long chapterId)
    {
        return this.contentService.findContentByChapterId(chapterId);
    }


    @RequestMapping("saveForm")
    @ResponseBody
    public String saveContent(ContentEntity form)
    {
        return this.contentService.saveOrUpdate(form);
    }

    @RequestMapping("saveContent")
    public void saveContent(MultipartHttpServletRequest request, HttpServletResponse response,
                       ModelMap model, Long id) {
        String message = "";
        String error = "";
        MultipartFile file = request.getFile("text");
        String path = "";
        if (file == null || file.isEmpty()) {
            error = "文件太小！";
        } else {

            File destFile = null;
            try {
                String filename = UploadUtils.generateFilename("txt");
                path = "/upload/file/content" + filename;
                destFile = fileRepository.storeByFilename(path, file);
                message = path;
            } catch (Exception e) {
                error = "上传失败！";
                e.printStackTrace();
                if (destFile != null && destFile.exists()) {
                    destFile.delete();
                }
            }
        }
        JSONObject obj = new JSONObject();
        obj.put("err", error);
        obj.put("msg", message);
        ResponseUtils.renderText(response, obj.toString());
    }

    @RequestMapping("save")
    public void save(){

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
