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
    @RequestMapping(value = "" , method = RequestMethod.GET)
    public String layuiAdmin() {
        return PREFIX+"/layuiAdmin";
    }

    /**
     * @Author dai jiawei
     * @Description 模块展示
     * @Date 2020/9/11 14:28
     * @param
     * @Return java.lang.String
     **/
    @RequestMapping(value = "/modular" , method = RequestMethod.GET)
    public String modular() {
        return PREFIX+"/modular";
    }

    /**
     * 弹出框
     * @return
     */
    @RequestMapping(value = "/layer" , method = RequestMethod.GET)
    public String layer() {
        return PREFIX+"/layer";
    }

    /**
     * 基础功能
     * @return
     */
    @RequestMapping(value = "/layui" , method = RequestMethod.GET)
    public String layui() {
        return PREFIX+"/layui";
    }
}
