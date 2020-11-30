package com.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/jqueryController")
public class JQueryController {

    private static String PREFIX = "pages/jquery";

    /**
     * 滑动
     * @return
     */
    @RequestMapping(value = "/slide" , method = RequestMethod.GET)
    public String slide() {
        return PREFIX+"/slide";
    }

    /**
     * 移动端日期控件
     * @return
     */
    @RequestMapping(value = "/mobiscroll" , method = RequestMethod.GET)
    public String mobiscroll() {
        return PREFIX+"/mobiscroll";
    }
}
