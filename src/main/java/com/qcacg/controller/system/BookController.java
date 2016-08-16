package com.qcacg.controller.system;

import com.qcacg.controller.BaseController;
import com.qcacg.entity.BookEntity;
import com.qcacg.entity.UserEntity;
import com.qcacg.service.system.BookService;
import com.qcacg.util.Result;
import com.qcacg.util.UserEntityUtil;
import com.qcacg.util.http.ResponseUtils;
import com.qcacg.util.upload.FileRepository;
import com.qcacg.util.upload.UploadUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/4.
 */
@Controller
@RequestMapping("/book/")
public class BookController extends BaseController {

    @Autowired
    public BookService bookService;
    @Autowired
    private FileRepository fileRepository;

    @RequestMapping(value = "upload")
    public void upload(MultipartHttpServletRequest request,
                       @RequestParam(value = "__source", required = false) MultipartFile file3, HttpServletResponse response,
                       ModelMap model) throws IOException
    {
        Result result = new Result();
        MultipartFile file = null;
        Map<String, MultipartFile> file2 = request.getFileMap();
        String path = "";
        for (Map.Entry<String, MultipartFile> entry : file2.entrySet())
        {
            file = entry.getValue();
        }
        if (file == null || file.isEmpty())
        {
            result.setMsg("文件太小");
        } else
        {
            result.avatarUrls = new ArrayList<String>();
            result.setSuccess(false);
            result.setMsg("上传失败!");
            boolean isSourcePic = file.getName().equals("__source");
            String fieldName = file.getName();//file对象有问题

            if (file3 != null)
            {
                isSourcePic = true;
                fieldName = file3.getOriginalFilename();
                file = file3;
            }
            if (fieldName.equals("__initParams"))
            {

            }
            // 如果是原始图片 file
            // 域的名称或者以默认的头像域名称的部分“__avatar”打头(默认的头像域名称：__avatar1,2,3...，可在插件配置参数中自定义，参数名：avatar_field_names)
            else if (isSourcePic || fieldName.startsWith("__avatar"))
            {

                // String virtualPath = "/upload/jsp_avatar" + avatarNumber +
                // "_" + fileName + ".jpg";
                // 原始图片（默认的 file 域的名称是__source，可在插件配置参数中自定义。参数名：src_field_name）。
                if (isSourcePic)
                {
                    // 文件名，如果是本地或网络图片为原始文件名、如果是摄像头拍照则为 *FromWebcam.jpg
                    String sourceFileName = fieldName;
                    // 原始文件的扩展名(不包含“.”)
                    String sourceExtendName = sourceFileName.substring(sourceFileName.lastIndexOf('.') + 1);
                    String filename = UploadUtils.generateFilename(sourceExtendName);
                    path = "upload/files" + filename;
                    result.sourceUrl = path;
                }
                // 头像图片（默认的 file
                // 域的名称：__avatar1,2,3...，可在插件配置参数中自定义，参数名：avatar_field_names）。
                else
                {
                    String filename = UploadUtils.generateFilename("jpg");
                    path = "upload/files/bookCoverImage" + filename;
                    result.avatarUrls.add(request.getContextPath() + path);
                    //result.sourceUrl = path;
                }
                fileRepository.storeByFilename(path, file);
            }
        }
        if (result.sourceUrl != null)
        {

        }
        result.sourceUrl = request.getContextPath() + result.sourceUrl;
        result.setSuccess(true);
        result.setMsg("上传成功!");

        UserEntity userEntity = UserEntityUtil.getUserFromSession();

        BookEntity bookEntity = this.bookService.findByUserId(userEntity.getUserId());
        bookEntity.setBookCoverImage(path);
        this.bookService.update(bookEntity);
        ResponseUtils.renderText(response, JSONObject.fromObject(result).toString());
    }

}
