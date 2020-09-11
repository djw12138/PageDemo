package com.page.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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

    /**
     * 测试六(横向柱形图)
     * @return
     */
    @RequestMapping(value = "/demo6" , method = RequestMethod.GET)
    public String demo6() {
        return PREFIX+"/demo6";
    }

    /**
     * 测试七(折线图)
     * @return
     */
    @RequestMapping(value = "/demo7" , method = RequestMethod.GET)
    public String demo7() {
        return PREFIX+"/demo7";
    }

    /**
     * 后端查询(Jquery)
     * @return
     */
    @RequestMapping(value = "/queryDemo" , method = RequestMethod.GET)
    public String queryDemo() {
        return PREFIX+"/queryDemo";
    }

    /**
     * 后端查询(Jquery)
     * @return
     */
    @RequestMapping(value = "/loadingDemo" , method = RequestMethod.GET)
    public String loadingDemo() {
        return PREFIX+"/loadingDemo";
    }

    /**
     * 后端查询(Jquery)的数据
     * @return
     */
    @RequestMapping(value = "/queryDemoData" , method = RequestMethod.GET)
    @ResponseBody
    public JSONObject queryDemoData() {
        JSONObject resultJson = new JSONObject();
        JSONArray dataArray = new JSONArray();

        String data="[{value: 335, name: '直接访问'},{value: 310, name: '邮件营销'}, {value: 274, name: '联盟广告'},{value: 235, name: '视频广告'},{value: 400, name: '搜索引擎'}]";
        dataArray=JSONArray.parseArray(data);

        resultJson.put("data",dataArray);
        return resultJson;
    }

    /***
     * @Author dai jiawei
     * @Description
     * @Date 2020/9/5 8:50
     * @param
     * @Return com.alibaba.fastjson.JSONObject
     **/
    @RequestMapping(value = "/loadingData" , method = RequestMethod.GET)
    @ResponseBody
    public JSONObject loadingData() {
        JSONObject resultJson = new JSONObject();
        JSONArray dataArray = new JSONArray();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(System.currentTimeMillis()%2==0) {
            String data = "[{value: 335, name: '直接访问'},{value: 310, name: '邮件营销'}, {value: 274, name: '联盟广告'},{value: 235, name: '视频广告'},{value: 400, name: '搜索引擎'}]";
            dataArray = JSONArray.parseArray(data);
        }
        resultJson.put("data",dataArray);
        return resultJson;
    }
}
