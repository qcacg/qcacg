package com.qcacg.controller.system;

import com.qcacg.controller.BaseController;
import com.qcacg.entity.BookAndBookTypeEntity;
import com.qcacg.entity.BookEntity;
import com.qcacg.service.system.BookAndBookTypeService;
import com.qcacg.service.system.BookService;
import com.qcacg.util.UserEntityUtil;
import com.qcacg.util.upload.FileRepository;
import com.qcacg.util.upload.UploadUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.*;

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
    @Autowired
    BookAndBookTypeService bookAndBookTypeService;
    @RequestMapping("list")
    public String list(Model model)
    {
        model.addAttribute("res", findResByUser());
        return "/system/book/list";
    }

    /*
    按时间获取作品列表
     */
    @RequestMapping("findBookByBookUpDate")
    @ResponseBody
    public List<BookEntity> findBookByBookUpDate()
    {
        return this.bookService.findBookByBookUpDate();
    }



    /*
    获取用户作品列表
     */

    @RequestMapping("findBookByUser")
    @ResponseBody
    public List<BookEntity> findBookByUser()
    {
        Long userId = UserEntityUtil.getUserFromSession().getUserId();
        return this.bookService.findBookByUserId(userId);
    }


    /*
    获取作品信息
     */
    @RequestMapping("findByPrimaryBookId/{bookId}")
    @ResponseBody
    public BookEntity findByPrimaryBookId(@PathVariable("bookId")Long bookId)
    {

        return this.bookService.findByPrimaryKey(bookId);
    }
    /*
    保存作品（信息）
     */
    @RequestMapping(value = "saveOrUpdateBook", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveOrUpdateBook(BookEntity bookEntity,@RequestBody BookEntity bookEntityForm)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Long userId = UserEntityUtil.getUserFromSession().getUserId();
            bookEntity.setBookId(bookEntityForm.getBookId());
            bookEntity.setUserId(userId);
            bookEntity.setBookName(bookEntityForm.getBookName());
            bookEntity.setBookIntroduction(bookEntityForm.getBookIntroduction());
            bookEntity.setBookCoverImage(bookEntityForm.getBookCoverImage());
            bookEntity.setSort(bookEntityForm.getSort());
            this.bookService.saveOrUpdateBook(bookEntity);
            map.put("bookEntity", "success");
            Long bookId = bookEntity.getBookId();
            List<Long> bookTypeList = bookEntityForm.getBookTypeList();
            List<BookAndBookTypeEntity> bookAndBookTypeEntityList = new ArrayList<BookAndBookTypeEntity>();
            for (int i = 0; i < bookTypeList.size(); i++) {
                BookAndBookTypeEntity bookAndBookTypeEntity = new BookAndBookTypeEntity();
                bookAndBookTypeEntity.setBookId(bookId);
                bookAndBookTypeEntity.setBookTypeId(bookTypeList.get(i));
                bookAndBookTypeEntityList.add(bookAndBookTypeEntity);
                map.put("bookAndBookTypeEntity"," success");
            }
            this.bookAndBookTypeService.saveOrUpdateBookType(bookAndBookTypeEntityList, bookId);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","error");
        }
        return map;
    }
    /*
    添加作品封面
    */
    @RequestMapping(value = "upload")
    @ResponseBody
    public Map<String,Object> upload(MultipartHttpServletRequest request, HttpServletResponse response) {

        Map<String,Object> result = new HashMap<String, Object>();
        MultipartFile file = request.getFile("Image");
        if (file == null || file.isEmpty()) {
            result.put("success",false);
            result.put("msg", "文件太小！");
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
                String path = "/upload/image/bookCoverImage" + filename;
                destFile = fileRepository.storeByFilename(path, file);
                result.put("success",true);
                result.put("msg", path);
            } catch (Exception e) {
                result.put("success",false);
                result.put("msg", "上传失败！");
                e.printStackTrace();
                if (destFile != null && destFile.exists()) {
                    destFile.delete();
                }
            }
        }
        return result;
    }

    /*
    作者提交审核
     */
    @RequestMapping("userUpdateBookStatus/{bookId}")
    @ResponseBody
    public Map<String,Object> userUpdateBookStatus(@PathVariable("bookId")Long bookId)
    {
        Map<String,Object> result = new HashMap<String, Object>();
        try{
            this.bookService.userUpdateBookStatus(bookId);
            result.put("success",true);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            result.put("success",false);
            return result;
        }
    }

    /*
    编辑审核审核
     */
    @RequestMapping("adminUpdateBookStatus")
    @ResponseBody
    public Map<String,Object> adminUpdateBookStatus(@RequestParam("bookId")Long bookId)
    {
        Map<String,Object> result = new HashMap<String, Object>();
        try{
            this.bookService.adminUpdateBookStatus(bookId);
            result.put("success",true);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            result.put("success",false);
            return result;
        }
    }
    /*
    展示提交审核的小说
     */
    @RequestMapping("queryBookForCheck")
    @ResponseBody
    public List<BookEntity> queryBookForCheck()
    {
        return this.bookService.queryBookForCheck();

    }



}
