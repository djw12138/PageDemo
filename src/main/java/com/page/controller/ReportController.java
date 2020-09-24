package com.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: dai jiawei
 * @Date: 2020/8/21 9:23
 */

@Controller
@RequestMapping("/reportController")
public class ReportController {

    private static String PREFIX = "pages/report";

    /**
     * @param
     * @Author dai jiawei
     * @Description 中远大屏页面
     * @Date 2020/8/21 9:29
     * @Return java.lang.String
     **/
    @RequestMapping(value = "/zydwReport", method = RequestMethod.GET)
    public String zydwReport() {
        return PREFIX + "/zydw_view";
    }
}
