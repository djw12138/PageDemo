package com.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/layuiController")
public class LayuiController {

    private static String PREFIX = "pages/layui";

    /**
     * 主页
     * @return
     */
    @RequestMapping(value = "/layuiAdmin" , method = RequestMethod.GET)
    public String layuiAdmin() {
        return PREFIX+"/layuiAdmin";
    }

}
