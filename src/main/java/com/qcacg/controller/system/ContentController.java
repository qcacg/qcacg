package com.qcacg.controller.system;

import com.baidu.ueditor.ActionEnter;
import com.qcacg.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/7/4.
 */
@Controller
@RequestMapping("/Content/")
public class ContentController extends BaseController {

    @RequestMapping("ueditor")
    public void ueditor(HttpServletRequest request, HttpServletResponse response, String action) {
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");

        try {
            String exec = new ActionEnter(request, rootPath).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
