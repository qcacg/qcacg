package com.qcacg.controller.system;

<<<<<<< HEAD
import com.qcacg.constant.CodeConstant;
=======
>>>>>>> 0aa25e77c367abfa3e9bf53151a7fad4b044f553
import com.qcacg.controller.BaseController;
import com.qcacg.entity.BookAndBookTypeEntity;
import com.qcacg.entity.BookEntity;
import com.qcacg.entity.book.BookCustom;
import com.qcacg.service.system.BookAndBookTypeService;
import com.qcacg.service.system.BookCustomService;
import com.qcacg.service.system.BookService;
import com.qcacg.util.BookEntityUtil;
import com.qcacg.util.MyJedis;
import com.qcacg.util.UserEntityUtil;
import com.qcacg.util.upload.FileRepository;
import com.qcacg.util.upload.UploadUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.formula.functions.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
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
    public List<BookEntity> findBookByUser(HttpServletRequest request)
    {
        String jsessionId = request.getParameter("JSESSIONID");
        Long userId = UserEntityUtil.getUserId(jsessionId);
        System.out.println(userId);
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
<<<<<<< HEAD
    public Map<String, Object> saveOrUpdateBook(BookEntity bookEntity,
                                                HttpServletRequest request,
                                                HttpServletResponse response) throws Exception {
=======
    public Map<String, Object> saveOrUpdateBook(BookEntity bookEntity, HttpServletRequest request)
    {
>>>>>>> 0aa25e77c367abfa3e9bf53151a7fad4b044f553
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            bookEntity = BookEntityUtil.getBookEntity(request);
            if(bookEntity.getBookName() == null) {
<<<<<<< HEAD
                response.setStatus(response.SC_NOT_FOUND);
                map.put("code", CodeConstant.PARAMETER_CODE);
                map.put("msg", CodeConstant.BOOKNAME_IS_NULL);
                return map;
            }
            if(this.bookService.findBookByBookName(bookEntity.getBookName(), bookEntity.getBookId())) {
                map.put("code", CodeConstant.PARAMETER_CODE);
                map.put("msg", CodeConstant.BOOKNAME_IS_EXIST);
=======
                map.put("msg", "书名不能为空");
                return map;
            }
            if(this.bookService.findBookByBookName(bookEntity.getBookName(), bookEntity.getBookId())) {
                map.put("msg", "书名已存在");
>>>>>>> 0aa25e77c367abfa3e9bf53151a7fad4b044f553
                return map;
            }
            this.bookService.saveOrUpdateBook(bookEntity);
            map.put("bookEntity", bookEntity);
            Long bookId = bookEntity.getBookId();
            List<Long> bookTypeList = bookEntity.getBookTypeList();
            List<BookAndBookTypeEntity> bookAndBookTypeEntityList = new ArrayList<BookAndBookTypeEntity>();
            if(bookTypeList != null) {
                for (int i = 0; i < bookTypeList.size(); i++) {
                    BookAndBookTypeEntity bookAndBookTypeEntity = new BookAndBookTypeEntity();
                    bookAndBookTypeEntity.setBookId(bookId);
                    bookAndBookTypeEntity.setBookTypeId(bookTypeList.get(i));
                    bookAndBookTypeEntityList.add(bookAndBookTypeEntity);
                    map.put("bookAndBookTypeEntity" + i,bookAndBookTypeEntity);
                }
            }
            this.bookAndBookTypeService.saveOrUpdateBookType(bookAndBookTypeEntityList, bookId);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
<<<<<<< HEAD
            // response.sendError(500, e.getMessage());
            response.setStatus(500);
            map.put("msg", CodeConstant.SYS_CODE_MSG);
            map.put("code", CodeConstant.SYS_CODE);
            map.put("error",e.getMessage());
            return map;
        }
        return map;
    }

=======
//            map.put("success",false);
//            map.put("msg","error");
            throw new NullPointerException("未找到");
        }
        return map;
    }
    /*
    public Map<String, Object> saveOrUpdateBook(BookEntity bookEntity, @RequestBody BookEntity bookEntityForm)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Long userId = UserEntityUtil.getUserFormSessionFromSession().getUserId();
            bookEntity.setBookId(bookEntityForm.getBookId());
            bookEntity.setUserId(userId);
            bookEntity.setBookName(bookEntityForm.getBookName());
            bookEntity.setBookIntroduction(bookEntityForm.getBookIntroduction());
            bookEntity.setBookCoverImage(bookEntityForm.getBookCoverImage());
            bookEntity.setSort(bookEntityForm.getSort());
            System.out.println(bookEntity);
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
    */
>>>>>>> 0aa25e77c367abfa3e9bf53151a7fad4b044f553
    /*
    添加小说封面
    */
    @RequestMapping(value = "upload")
    @ResponseBody
    public Map<String,Object> upload(MultipartHttpServletRequest request, HttpServletResponse response) {

        Map<String,Object> result = new HashMap<String, Object>();
        MultipartFile file = request.getFile("Image");
        if (file == null || file.isEmpty()) {
            response.setStatus(CodeConstant.ERROR_CODE);
            result.put("code",CodeConstant.PARAMETER_CODE);
            result.put("msg", CodeConstant.FILE_TOO_SMALL);
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
                result.put("success", CodeConstant.SUCCESS_SAVE);
                result.put("msg", "文件存储在" + path);
            } catch (Exception e) {
                response.setStatus(CodeConstant.ERROR_CODE);
                result.put("code", CodeConstant.SYS_CODE);
                result.put("msg", CodeConstant.SQL_CODE_MSG);
                result.put("error", e.getMessage());
                e.printStackTrace();
                if (destFile != null && destFile.exists()) {
                    destFile.delete();
                }
                return result;
            }
        }
        return result;
    }

    /*
    作者提交审核
     */
    @RequestMapping("userUpdateBookStatus")
    @ResponseBody
    public Map<String,Object> userUpdateBookStatus(HttpServletResponse response, @RequestParam("bookId")Long bookId)
    {
        Map<String,Object> result = new HashMap<String, Object>();
        try{
            this.bookService.userUpdateBookStatus(bookId);
            result.put("msg", CodeConstant.SUCCESS_COMMIT);
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
    编辑审核审核
     */
    @RequestMapping("adminUpdateBookStatus")
    @ResponseBody
    public Map<String,Object> adminUpdateBookStatus(HttpServletResponse response, @RequestParam("bookId")Long bookId)
    {
        Map<String,Object> result = new HashMap<String, Object>();
        try{
            this.bookService.adminUpdateBookStatus(bookId);
            result.put("msg", CodeConstant.SUCCESS_COMMIT);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(CodeConstant.ERROR_CODE);
            result.put("code", CodeConstant.SYS_CODE);
            result.put("msg", CodeConstant.SQL_CODE_MSG);
            result.put("error",e.getMessage());
            return result;
        }
    }
<<<<<<< HEAD

    @RequestMapping("bookFromSale")
    @ResponseBody
    public Map<String, Object> bookFromSale(HttpServletRequest request,
                                            HttpServletResponse response,
                                            @RequestParam("bookIds") List<Long> list) {
        Map<String, Object> map = this.bookService.bookFromSale(list);
        if(map.get("code") != null) {

        }
        return null;
    }

=======
>>>>>>> 0aa25e77c367abfa3e9bf53151a7fad4b044f553
    /*
    展示提交审核的小说
     */
    @RequestMapping("queryBookForCheck")
    @ResponseBody
    public List<BookEntity> queryBookForCheck()
    {
        return this.bookService.queryBookForCheck();

    }
<<<<<<< HEAD
=======



>>>>>>> 0aa25e77c367abfa3e9bf53151a7fad4b044f553
}
