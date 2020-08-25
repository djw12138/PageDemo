package com.page.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @Author: dai jiawei
 * @Date: 2020/8/21 10:00
 */
@Controller
@RequestMapping("/zydwReportController")
public class ZydwReportController {

    /***
     * @Author dai jiawei
     * @Description 第一个图表数据查询
     * @Date 2020/8/19 10:18
     * @param
     * @Return com.alibaba.fastjson.JSONObject
     **/
    @RequestMapping(value = "/queryOne", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject queryOne() {
        JSONObject resultJson = new JSONObject();

        String[] keys = new String[]{"中尉", "少校", "上将", "下士", "首领"};
        Long[] values = new Long[]{23L, 56L, 444L, 22L, 55L};

        resultJson.put("key", keys);
        resultJson.put("value", values);
        resultJson.put("isDisplay", 0);
        return resultJson;
    }

    /**
     * @Author dai jiawei
     * @Description 第二个图表数据查询
     * @Date 2020/8/19 15:44
     * @param
     * @Return com.alibaba.fastjson.JSONObject
     **/
    @RequestMapping(value = "/queryTwo", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject queryTwo() {
        JSONObject resultJson = new JSONObject();
        JSONArray dataArray= new JSONArray();

        for (int i = 0; i <20 ; i++) {
            JSONObject json = new JSONObject();
            json.put("cardMac",i);
            json.put("personName",i*5);
            json.put("hours",i*10);
            dataArray.add(json);
        }
        resultJson.put("data", dataArray);
        resultJson.put("isDisplay", 0);
        return resultJson;
    }

    /***
     * @Author dai jiawei
     * @Description 第三个图表数据查询
     * @Date 2020/8/19 10:49
     * @param
     * @Return com.alibaba.fastjson.JSONObject
     **/
    @RequestMapping(value = "/queryThree", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject queryThree() {
        JSONObject resultJson = new JSONObject();

        JSONArray dataArray = new JSONArray();
        String[] keys = new String[]{"中尉", "少校", "上将", "下士", "首领"};
        Long[] values = new Long[]{23L, 56L, 444L, 22L, 55L};

        for (int i = 0; i < keys.length; i++) {
            JSONObject json = new JSONObject();
            json.put("name", keys[i]);
            json.put("value", values[i]);
            dataArray.add(json);
        }
        resultJson.put("legend", keys);
        resultJson.put("data", dataArray);
        resultJson.put("isDisplay", 0);
        return resultJson;
    }

    /***
     * @Author dai jiawei
     * @Description 第四个图表数据查询
     * @Date 2020/8/19 15:44
     * @param
     * @Return com.alibaba.fastjson.JSONObject
     **/
    @RequestMapping(value = "/queryFour", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject queryFour() {
        JSONObject resultJson = new JSONObject();
        JSONArray dataArray= new JSONArray();

        for (int i = 0; i <20 ; i++) {
            JSONObject json = new JSONObject();
            json.put("time",new Date());
            json.put("from",i);
            json.put("name",i);
            dataArray.add(json);
        }
        resultJson.put("data", dataArray);
        resultJson.put("isDisplay", 0);
        return resultJson;
    }

    /**
     * @param
     * @Author dai jiawei
     * @Description 第五个图表数据查询
     * @Date 2020/8/19 11:09
     * @Return com.alibaba.fastjson.JSONObject
     **/
    @RequestMapping(value = "/queryFive", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject queryFive() {
        JSONObject resultJson = new JSONObject();
        JSONArray dataArray = new JSONArray();

        String[] legends = new String[]{"枪支数量", "弹药储备", "作战单位"};
        String[] categorys = new String[20];

        for (int i = 0; i < 20; i++) {
            categorys[i] = "2020-8-" + i;
        }

        for (String legend : legends) {

            JSONObject json = new JSONObject();
            json.put("name", legend);
            json.put("type", "line");
            //json.put("stack", "总量");
            json.put("smooth",true);

            double[] datas = new double[categorys.length];

            for (int j = 0; j < categorys.length; j++) {
                datas[j] = Math.random() * 100;
            }

            json.put("data",datas);
            dataArray.add(json);
        }

        resultJson.put("legend", legends);
        resultJson.put("category", categorys);
        resultJson.put("data", dataArray);
        resultJson.put("isDisplay", 0);
        return resultJson;
    }

    /***
     * @Author dai jiawei
     * @Description 第六个图表数据查询
     * @Date 2020/8/19 15:44
     * @param
     * @Return com.alibaba.fastjson.JSONObject
     **/
    @RequestMapping(value = "/querySix", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject querySix() {
        //获取出入围栏实时记录数据
        JSONObject resultJson = new JSONObject();
        JSONArray dataArray= new JSONArray();

        for (int i = 0; i <20 ; i++) {
            JSONObject json = new JSONObject();
            json.put("time",new Date());
            json.put("from",i);
            json.put("name",i);
            dataArray.add(json);
        }
        resultJson.put("data", dataArray);
        resultJson.put("isDisplay", 0);
        return resultJson;
    }

    /**
     * @param
     * @Author dai jiawei
     * @Description 查询中间图表数据
     * @Date 2020/8/20 13:41
     * @Return com.alibaba.fastjson.JSONObject
     **/
    @RequestMapping(value = "/queryMiddle", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject queryMiddle() {
        JSONObject resultJson = new JSONObject();

        resultJson.put("seven", 490);
        resultJson.put("eight", 79809);
        resultJson.put("nine", 1231);
        resultJson.put("ten", 5234);
        resultJson.put("isDisplay", 0);
        return resultJson;
    }
}
