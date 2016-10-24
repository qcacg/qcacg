package com.qcacg.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by CaiYuanYu on 2016/10/19.
 */

@Controller
public class TestController {

    @RequestMapping("/getTest")
    public String getTest() {
        return "test";
    }
}
