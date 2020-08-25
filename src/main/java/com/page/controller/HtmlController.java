package com.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/htmlController")
public class HtmlController {

    private static String PREFIX = "pages/html";

    /**
     * 分页
     * @return
     */
    @RequestMapping(value = "/paging" , method = RequestMethod.GET)
    public String paging() {
        return PREFIX+"/paging";
    }

}
