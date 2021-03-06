package com.page.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/htmlController")
public class HtmlController {

    private static String PREFIX = "pages/html";

    /**
     * 分页
     *
     * @return
     */
    @RequestMapping(value = "/paging", method = RequestMethod.GET)
    public String paging() {
        return PREFIX + "/paging";
    }

    /**
     * 轮播图
     *
     * @return
     */
    @RequestMapping(value = "/rotationChart", method = RequestMethod.GET)
    public String rotationChart() {
        return PREFIX + "/rotation_chart";
    }

    /**
     * 轮播图
     *
     * @return
     */
    @RequestMapping(value = "/rotationChart2", method = RequestMethod.GET)
    public String rotationChart2() {
        return PREFIX + "/rotation_chart2";
    }

    /***
     * @Author dai jiawei
     * @Description 滑动
     * @Date 2020/9/1 19:14
     * @param
     * @Return java.lang.String
     **/
    @RequestMapping(value = "/slide", method = RequestMethod.GET)
    public String slide() {
        return PREFIX + "/slide";
    }

    /**
     * @param
     * @Author dai jiawei
     * @Description 颜色
     * @Date 2020/9/10 10:59
     * @Return java.lang.String
     **/
    @RequestMapping(value = "/color", method = RequestMethod.GET)
    public String color() {
        return PREFIX + "/color";
    }

    /**
     * @param
     * @Author dai jiawei
     * @Description 菜单
     * @Date 2020/9/17 15:45
     * @Return java.lang.String
     **/
    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String menu() {
        return PREFIX + "/menu";
    }

    /**
     * 菜单2
     *
     * @return
     */
    @RequestMapping(value = "/menu2", method = RequestMethod.GET)
    public String menu2() {
        return PREFIX + "/menu2";
    }

    /**
     * 提示
     *
     * @return
     */
    @RequestMapping(value = "/tip", method = RequestMethod.GET)
    public String tip() {
        return PREFIX + "/tip";
    }

    /**
     * 文件上传
     *
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload() {
        return PREFIX + "/upload";
    }

    /**
     * tab页
     *
     * @return
     */
    @RequestMapping(value = "/tab", method = RequestMethod.GET)
    public String tab() {
        return PREFIX + "/tab";
    }

    /**
     * css样式
     *
     * @return
     */
    @RequestMapping(value = "/css", method = RequestMethod.GET)
    public String css() {
        return PREFIX + "/css";
    }

    /**
     * 遮盖
     *
     * @return
     */
    @RequestMapping(value = "/modal", method = RequestMethod.GET)
    public String modal() {
        return PREFIX + "/modal";
    }

    /**
     * 密码校验
     *
     * @return
     */
    @RequestMapping(value = "/passwordValidate", method = RequestMethod.GET)
    public String passwordValidate() {
        return PREFIX + "/passwordValidate";
    }

    /**
     * 电子签章（圆形）
     *
     * @return
     */
    @RequestMapping(value = "/electronicSignatureCircular", method = RequestMethod.GET)
    public String electronicSignatureCircular() {
        return PREFIX + "/electronicSignatureCircular";
    }

    /**
     * 电子签章（椭圆形）
     *
     * @return
     */
    @RequestMapping(value = "/electronicSignatureEllipse", method = RequestMethod.GET)
    public String electronicSignatureEllipse() {
        return PREFIX + "/electronicSignatureEllipse";
    }

    /**
     * 屏幕截图
     *
     * @return
     */
    @RequestMapping(value = "/screenShot", method = RequestMethod.GET)
    public String screenShot() {
        return PREFIX + "/screenShot";
    }

    /**
     * 屏幕截图展示
     *
     * @return
     */
    @RequestMapping(value = "/screenShotShow", method = RequestMethod.GET)
    public String screenShotShow() {
        return PREFIX + "/screenShotShow";
    }

    /**
     * @param page
     * @param limit
     * @Author dai jiawei
     * @Description 查询分页数据
     * @Date 2020/9/1 8:44
     * @Return com.alibaba.fastjson.JSONObject
     **/
    @RequestMapping(value = "/queryPageData", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject queryPageData(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                                    @RequestParam(name = "id", required = false, defaultValue = "10") Integer limit) {
        JSONObject resultJson = new JSONObject();
        JSONArray dataArray = new JSONArray();
        if (page <= 5) {
            for (int i = 0; i < limit; i++) {
                JSONObject json = new JSONObject();
                json.put(i + "", page);
                dataArray.add(json);
            }
        }
        resultJson.put("data", dataArray);
        resultJson.put("totalSize", 100000);
        return resultJson;
    }
}
