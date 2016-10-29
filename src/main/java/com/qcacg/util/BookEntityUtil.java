package com.qcacg.util;

import com.qcacg.entity.BookEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取BookEntity对象
 * Created by CaiYuanYu on 2016/10/23.
 */

public class BookEntityUtil {
    public static BookEntity getBookEntity(HttpServletRequest req) {
        Long userId = UserEntityUtil.getUserFromSession().getUserId();
        BookEntity bookEntity = new BookEntity();
        bookEntity.setUserId(userId);
        JSONObject json = JSONObject.fromObject(req.getParameter("bookEntity"));
        if (json.getString("bookId") != null && StringUtils.isNotBlank(json.getString("bookId"))){
            bookEntity.setBookId(json.getLong("bookId"));
        }
        if (json.get("bookCoverImage") != null && !json.getString("bookCoverImage").trim().isEmpty())
            bookEntity.setBookCoverImage(json.getString("bookCoverImage"));
        if (json.get("bookIntroduction") != null && !json.getString("bookIntroduction").trim().isEmpty())
            bookEntity.setBookIntroduction(json.getString("bookIntroduction"));
        if (json.get("bookName") != null && !json.getString("bookName").trim().isEmpty())
            bookEntity.setBookName(json.getString("bookName"));
        if (json.get("sort") != null && !json.getString("sort").trim().isEmpty())
            bookEntity.setSort(json.getString("sort"));
        if (json.get("bookTypeList") != null
                && json.get("bookTypeList") != ""
                && ((JSONArray)json.get("bookTypeList")).size() > 0
                && !"null".equals(json.get("bookTypeList"))) {
            JSONArray array = (JSONArray) json.get("bookTypeList");
            List<Long> bookTypeList = new ArrayList();
            for(int i = 0; i < array.size(); i++) {
                Long l = new Long(array.get(i) + "");
                bookTypeList.add(l);
            }
            bookEntity.setBookTypeList(bookTypeList);
        }
        return bookEntity;
    }
}
