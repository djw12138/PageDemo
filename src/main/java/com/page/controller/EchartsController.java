package com.page.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/echartsController")
public class EchartsController {

    private static String PREFIX = "pages/echarts";

    /**
     * 测试一(柱状图)
     * @return
     */
    @RequestMapping(value = "/demo1" , method = RequestMethod.GET)
    public String demo1() {
        return PREFIX+"/demo1";
    }

    /**
     * 测试二(饼图)
     * @return
     */
    @RequestMapping(value = "/demo2" , method = RequestMethod.GET)
    public String demo2() {
        return PREFIX+"/demo2";
    }

    /**
     * 测试三(地图)
     * @return
     */
    @RequestMapping(value = "/demo3" , method = RequestMethod.GET)
    public String demo3() {
        return PREFIX+"/demo3";
    }

    /**
     * 测试四(地图)
     * @return
     */
    @RequestMapping(value = "/demo4" , method = RequestMethod.GET)
    public String demo4() {
        return PREFIX+"/demo4";
    }

    /**
     * 测试五(主题)
     * @return
     */
    @RequestMapping(value = "/demo5" , method = RequestMethod.GET)
    public String demo5() {
        return PREFIX+"/demo5";
    }
}
