package com.qcacg.controller.system;

import com.qcacg.controller.BaseController;
import com.qcacg.entity.BookAndBookTypeEntity;
import com.qcacg.entity.BookEntity;
import com.qcacg.entity.book.BookCustom;
import com.qcacg.service.system.BookAndBookTypeService;
import com.qcacg.service.system.BookCustomService;
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
    @Autowired
    BookCustomService bookCustomService;
    @RequestMapping("list")
    public String list(Model model)
    {
        model.addAttribute("res", findResByUser());
        return "/system/book/list";
    }

    /*
    按时间获取小说列表
     */
    @RequestMapping("findBookByBookUpDate")
    @ResponseBody
    public List<BookEntity> findBookByBookUpDate()
    {
        return this.bookService.findBookByBookUpDate();
    }
    /*
        按好人币获取小说列表（总榜）
         */
    @RequestMapping("findBookByBookCopperCoins")
    @ResponseBody
    public List<BookEntity> findBookByBookCopperCoins()
    {
        return this.bookService.findBookByBookCopperCoins();
    }
    /*
        按点击数获取小说列表（总榜）
         */
    @RequestMapping("findBookByBookHit")
    @ResponseBody
    public List<BookEntity> findBookByBookHit()
    {
        return this.bookService.findBookByBookHit();
    }
    /*
        按字数获取小说列表（总榜）
         */
    @RequestMapping("findBookByBookWordCount")
    @ResponseBody
    public List<BookEntity> findBookByBookWordCount()
    {
        return this.bookService.findBookByBookWordCount();
    }

    /*
        按好人币获取小说列表（周榜）
         */
    @RequestMapping("WeekBookByBookCopperCoins")
    @ResponseBody
    public List<BookEntity> WeekBookByBookCopperCoins()
    {
        return this.bookService.WeekBookByBookCopperCoins();
    }
    /*
        按点击数获取小说列表（周榜）
         */
    @RequestMapping("WeekBookByBookHit")
    @ResponseBody
    public List<BookEntity> WeekBookByBookHit()
    {
        return this.bookService.WeekBookByBookHit();
    }
    /*
        按字数获取小说列表（周榜）
         */
    @RequestMapping("WeekBookByBookWordCount")
    @ResponseBody
    public List<BookEntity> WeekBookByBookWordCount()
    {
        return this.bookService.WeekBookByBookWordCount();
    }

    /*
        按好人币获取小说列表（月榜）
         */
    @RequestMapping("MonthBookByBookCopperCoins")
    @ResponseBody
    public List<BookEntity> MonthBookByBookCopperCoins()
    {
        return this.bookService.MonthBookByBookCopperCoins();
    }
    /*
        按点击数获取小说列表（月榜）
         */
    @RequestMapping("MonthBookByBookHit")
    @ResponseBody
    public List<BookEntity> MonthBookByBookHit()
    {
        return this.bookService.MonthBookByBookHit();
    }
    /*
        按字数获取小说列表（月榜）
         */
    @RequestMapping("MonthBookByBookWordCount")
    @ResponseBody
    public List<BookEntity> MonthBookByBookWordCount()
    {
        return this.bookService.MonthBookByBookWordCount();
    }
    /*
    获取用户小说列表
     */

    @RequestMapping("findBookByUser")
    @ResponseBody
    public List<BookEntity> findBookByUser()
    {
        Long userId = UserEntityUtil.getUserFromSession().getUserId();
        return this.bookService.findBookByUserId(userId);
    }


    /*
    获取小说信息
     */
    @RequestMapping("queryBook")
    @ResponseBody
    public BookCustom queryBook(@RequestParam("bookId")Long bookId)
    {

        return this.bookCustomService.queryBook(bookId);
    }
    /*
    保存小说（信息）
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
            map.put("bookEntity", bookEntity);
            Long bookId = bookEntity.getBookId();
            List<Long> bookTypeList = bookEntityForm.getBookTypeList();
            List<BookAndBookTypeEntity> bookAndBookTypeEntityList = new ArrayList<BookAndBookTypeEntity>();
            for (int i = 0; i < bookTypeList.size(); i++) {
                BookAndBookTypeEntity bookAndBookTypeEntity = new BookAndBookTypeEntity();
                bookAndBookTypeEntity.setBookId(bookId);
                bookAndBookTypeEntity.setBookTypeId(bookTypeList.get(i));
                bookAndBookTypeEntityList.add(bookAndBookTypeEntity);
                map.put("bookAndBookTypeEntity",bookAndBookTypeEntity);
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
    添加小说封面
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
    @RequestMapping("userUpdateBookStatus")
    @ResponseBody
    public Map<String,Object> userUpdateBookStatus(@RequestParam("bookId")Long bookId)
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
