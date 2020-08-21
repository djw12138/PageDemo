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

        String[] keys = new String[]{"中尉","少校","上将","下士","首领"};
        Long[] values = new Long[]{23L,56L,444L,22L,55L};

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
     **//*
    @RequestMapping(value = "/queryTwo", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject queryTwo() {
        JSONObject resultJson = new JSONObject();
        LayuiPageInfo pageInfo = this.railIoRecordService.findErrorPageAll(new RailIoRecordParam());
        resultJson.put("data", pageInfo.getData());
        resultJson.put("isDisplay", 0);
        return resultJson;
    }*/

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
        String[] keys = new String[]{"中尉","少校","上将","下士","首领"};
        Long[] values = new Long[]{23L,56L,444L,22L,55L};

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

    /* *//***
     * @Author dai jiawei
     * @Description 第四个图表数据查询
     * @Date 2020/8/19 15:44
     * @param
     * @Return com.alibaba.fastjson.JSONObject
     **//*
    @RequestMapping(value = "/queryFour", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject queryFour() {
        JSONObject resultJson = new JSONObject();
        List<Map<String, Object>> railIoRecordVos = cardBatteryRecordService.getLowPowerAlarmList();
        resultJson.put("data", railIoRecordVos);
        resultJson.put("isDisplay", 0);
        return resultJson;
    }

    *//**
     * @param
     * @Author dai jiawei
     * @Description 第五个图表数据查询
     * @Date 2020/8/19 11:09
     * @Return com.alibaba.fastjson.JSONObject
     **//*
    @RequestMapping(value = "/queryFive", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject queryFive() {
        JSONObject resultJson = new JSONObject();

        String[] legends = new String[]{"在场", "在岗"};

        Date date = new Date();
        String startDate = DateUtil.formatDate(DateUtil.offsetDay(date, -24));
        String endDate = DateUtil.formatDate(date);
        List<String> dateList = CommonUtil.getDateListBetween(startDate, endDate);

        String[] categorys = dateList.toArray(new String[dateList.size()]);

        JSONArray dataArray = new JSONArray();

        JSONObject json = new JSONObject();
        json.put("name", legends[0]);
        json.put("type", "line");
        json.put("stack", "总量");

        *//*JSONObject lineStyleJson = new JSONObject();
        lineStyleJson.put("color","#FF0000");

        json.put("lineStyle", lineStyleJson);*//*
        float[] datas = new float[categorys.length];

        for (int j = 0; j < categorys.length; j++) {
            //根据时间获取该天的在场时间
            List<Map<String, Object>> workHourList = attendanceDetailService.getWorkHourListByCondition(categorys[j]);
            for (Map<String, Object> map : workHourList) {
                datas[j] = Float.parseFloat(map.get("presentTime").toString());
            }
        }
        json.put("data", datas);
        dataArray.add(json);

        json = new JSONObject();
        json.put("name", legends[1]);
        json.put("type", "line");
        json.put("stack", "总量");

        *//*lineStyleJson = new JSONObject();
        lineStyleJson.put("color","#00BFFF");

        json.put("lineStyle", lineStyleJson);*//*

        datas = new float[categorys.length];

        for (int j = 0; j < categorys.length; j++) {
            //根据时间获取该天的在场时间
            List<Map<String, Object>> workHourList = attendanceDetailService.getWorkHourListByCondition(categorys[j]);
            for (Map<String, Object> map : workHourList) {
                datas[j] = Float.parseFloat(map.get("actualTime").toString());
            }
        }
        json.put("data", datas);
        dataArray.add(json);

        resultJson.put("legend", legends);
        resultJson.put("category", categorys);
        resultJson.put("data", dataArray);
        resultJson.put("isDisplay", 0);
        return resultJson;
    }

    *//***
     * @Author dai jiawei
     * @Description 第六个图表数据查询
     * @Date 2020/8/19 15:44
     * @param
     * @Return com.alibaba.fastjson.JSONObject
     **//*
    @RequestMapping(value = "/querySix", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject querySix() {
        //获取出入围栏实时记录数据
        JSONObject resultJson = new JSONObject();
        List<RailIoRecordVo> railIoRecordVos = railIoRecordService.getRealRailIoRecords();
        resultJson.put("data", railIoRecordVos);
        resultJson.put("isDisplay", 0);
        return resultJson;
    }

    *//**
     * @param
     * @Author dai jiawei
     * @Description 查询中间图表数据
     * @Date 2020/8/20 13:41
     * @Return com.alibaba.fastjson.JSONObject
     **//*
    @RequestMapping(value = "/queryMiddle", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject queryMiddle() {
        JSONObject resultJson = new JSONObject();

        //获取当日报警数
        String nowDate = DateUtil.formatDate(new Date());
        Long presentAlarmCount = alarmRecordService.getPresentAlarmCount(nowDate);

        //获取人员围栏数
        Long personRailCount = railService.getPersonRailCount();

        //获取当日在岗总人数
        Date lowTimeLimit = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000L);
        List<String> personIds = attendanceStatusService.getPresentPersonCount(lowTimeLimit);
        //TODO 判断这些人员当天进出记录中当前最后一条记录是进还是出
        Date beginOfDay = DateUtil.beginOfDay(new Date());
        Date endOfDay = DateUtil.endOfDay(new Date());
        Long presentOnJobCount = 0L;
        for (String personId : personIds) {
            List<RailIoRecord> railIoRecordList = railIoRecordService.getRecordList(Long.valueOf(personId), beginOfDay, endOfDay);
            if (railIoRecordList.size() > 0) {
                if (railIoRecordList.get(railIoRecordList.size() - 1).getStatus().equals(Const.RAIL_IO_STATUS_IN)) {
                    presentOnJobCount = presentOnJobCount + 1;
                }
            }
        }

        //获取当日在场数
        List<String> presentPersonCount = attendanceStatusService.getPresentPersonCount(lowTimeLimit);

        resultJson.put("seven", presentPersonCount.size());
        resultJson.put("eight", presentOnJobCount);
        resultJson.put("nine", presentAlarmCount);
        resultJson.put("ten", personRailCount);
        resultJson.put("isDisplay", 0);
        return resultJson;
    }*/
}
