package com.qcacg.controller.system;

import com.qcacg.controller.BaseController;
import com.qcacg.entity.BookEntity;
import com.qcacg.entity.VolumeEntity;
import com.qcacg.service.system.BookService;
import com.qcacg.util.UserEntityUtil;
import com.qcacg.util.http.ResponseUtils;
import com.qcacg.util.upload.FileRepository;
import com.qcacg.util.upload.UploadUtils;
import net.sf.json.JSONObject;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.Locale;

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

    @RequestMapping("list")
    public String list(Model model)
    {
        model.addAttribute("res", findResByUser());
        return "/system/book/list";
    }



    /*
    获取作品列表
     */
    @RequestMapping("findBookByUser")
    @ResponseBody
    public List<BookEntity> findBookByUser()
    {
        Long userId = UserEntityUtil.getUserFromSession().getUserId();
        return this.bookService.findBookByUserId(userId);
    }

    /*
    获取作品详情
     */
    @RequestMapping("findByPrimaryBookId/{bookId}")
    @ResponseBody
    public BookEntity findByPrimaryBookId(@PathVariable("bookId")Long bookId)
    {
        return this.bookService.findByPrimaryKey(bookId);
    }

    @RequestMapping("saveOrUpdateBook")
    public void saveBook(BookEntity bookEntity, @RequestParam("bookName")String bookName,
                         @RequestParam("bookIntroduction")String bookIntroduction,
                         @RequestParam("bookCoverImage")String bookCoverImage )
    {
        try{
            Long userId = UserEntityUtil.getUserFromSession().getUserId();
            bookEntity.setUserId(userId);
            bookEntity.setBookName(bookName);
            bookEntity.setBookIntroduction(bookIntroduction);
            bookEntity.setBookCoverImage(bookCoverImage);
            this.bookService.saveOrUpdate(bookEntity);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "upload")
    public void upload(MultipartHttpServletRequest request, HttpServletResponse response) {
        String message = "";
        String error = "";
        MultipartFile file = request.getFile("Image");
        String path = "";
        if (file == null || file.isEmpty()) {
            error = "文件太小！";
        } else {
            String origName = file.getOriginalFilename();
            int index = origName.lastIndexOf(".");
            String title = index < 0 ? origName : origName.substring(0,
                    index);
            String ext = FilenameUtils.getExtension(origName).toLowerCase(
                    Locale.ENGLISH);
            File destFile = null;
            try {
                String filename = UploadUtils.generateFilename("jpg");
                path = "/upload/image/bookCoverImage" + filename;
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



}
