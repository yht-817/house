package com.ruoyi.project.globalapp.main.controller;


import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.globalapp.main.domain.ImgBanners;
import com.ruoyi.project.globalapp.main.domain.PioneerList;
import com.ruoyi.project.globalapp.main.domain.PioneerListMain;
import com.ruoyi.project.globalapp.main.domain.TodayHouseInfo;
import com.ruoyi.project.globalapp.main.service.IHomeService;
import com.ruoyi.project.globalapp.main.service.IMainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/v1/main")
@Api(tags = "主页的接口", description = "MainController")
public class MainController extends BaseController {
    @Autowired
    private IMainService iMainService;

    @Autowired
    private IHomeService iHomeService;

    /**
     * 首页数组展示
     */
    @PostMapping("/mainData")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiOperation(value = "首页数据列表", httpMethod = "POST")
    public AjaxResult mainData() {
        Map<String, Object> map = new HashMap<>();
        // 轮播图片
        List<ImgBanners> imgBanners = iHomeService.findHomeBanner();
        // 今日上市的楼盘
        List<TodayHouseInfo> todayhouseinfo = iMainService.queryTodayHouseInfo();
        // 房产经纪人的列表
        List<PioneerListMain> pioneerLists = iMainService.queryPioneerList();
        map.put("imgBanners", imgBanners);
        map.put("todayhouseinfo", todayhouseinfo);
        map.put("pioneerLists", pioneerLists);
        return success("成功", 200, map);
    }
}
