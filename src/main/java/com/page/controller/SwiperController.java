package com.page.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/swiperController")
public class SwiperController {

    private static String PREFIX = "pages/swiper";

    /**
     * 测试一
     *
     * @return
     */
    @RequestMapping(value = "/swiper1", method = RequestMethod.GET)
    public String swiper1() {
        return PREFIX + "/swiper1";
    }
}
