package com.ruoyi.project.globalapp.main.controller;

import cn.hutool.log.StaticLog;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.globalapp.main.domain.*;
import com.ruoyi.project.globalapp.main.service.IHouseService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 房子的接口
 */
@Controller
@RequestMapping("/v1/house")
@Api(tags = "房子的业务接口", description = "HouseController")
public class HouseController extends BaseController {

    @Autowired
    private IHouseService iHouseService;


    /**
     * 房屋类型
     */
    @GetMapping("/queryHomeType")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiOperation(value = "房屋类型条件筛选的时候房屋类型", httpMethod = "GET")
    public AjaxResult queryHomeType() {
        List<HomeType> datalist = new ArrayList<>();
        List<Map<String, Object>> data = iHouseService.queryHomeType();
        HomeType homeType = null;
        for (int i = 0; i < data.size(); i++) {
            homeType = new HomeType();
            homeType.setTypeNo((Integer) data.get(i).get("type_no"));
            homeType.setType(data.get(i).get("housing_type") + " " + data.get(i).get("housing_type_e"));
            datalist.add(homeType);
        }
        return success("获取成功", 200, datalist);
    }

    /**
     * 新房列表展示
     */
    @PostMapping("/queryHomeList")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "开始页（0开始）", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "分页大小", paramType = "query"),
            @ApiImplicitParam(name = "rank", value = "排序条件：0-价格从低到高，1-价格从高到低，2-最新上架", paramType = "query"),
            @ApiImplicitParam(name = "priceScope", value = "价格范围（用“-”链接）", paramType = "query"),
            @ApiImplicitParam(name = "houseArea", value = "房屋面积（用“-”链接）", paramType = "query"),
            @ApiImplicitParam(name = "houseType", value = "房屋类型（传类型编码）", paramType = "query"),
            @ApiImplicitParam(name = "bedroom", value = "卧室数量", paramType = "query"),
            @ApiImplicitParam(name = "bathroom", value = "卫浴数量", paramType = "query"),
    })
    @ApiOperation(value = "新房列表展示", httpMethod = "POST")
    public AjaxResult queryHomeList(int pageSize, int pageNo, String rank, String priceScope, String houseArea, String houseType, String bedroom, String bathroom) {
        pageNo = pageNo * pageSize;
        int startPrice = 0;
        int endPrice = 0;
        int startArea = 0;
        int endArea = 0;
        if (priceScope != null && priceScope != "") {
            boolean flag = priceScope.contains("-");
            if (flag) {
                // 有“-”字符
                String[] strs = priceScope.split("-");
                startPrice = Integer.valueOf(strs[0]);
                endPrice = Integer.valueOf(strs[1]);
                StaticLog.info("开始价格{}", startPrice);
                StaticLog.info("结束价格{}", endPrice);
            } else {
                startPrice = Integer.valueOf(priceScope);
                endPrice = 50000000;
            }
        }
        if (houseArea != null && houseArea != "") {
            boolean flag = houseArea.contains("-");
            if (flag) {
                String[] strs = houseArea.split("-");
                startArea = Integer.valueOf(strs[0]);
                endArea = Integer.valueOf(strs[1]);
                StaticLog.info("开始面积{}", startArea);
                StaticLog.info("结束面积{}", endArea);
            } else {
                startArea = Integer.valueOf(houseArea);
                endArea = 50000000;
            }
        }
        int bedrooms = 0;
        int bathrooms = 0;
        if (bedroom != null) {
            bedrooms = Integer.valueOf(bedroom);
        }
        if (bathroom != null) {
            bathrooms = Integer.valueOf(bathroom);
        }
        List<BridalchamberList> data = iHouseService.queryScreening(startPrice, endPrice, startArea, endArea, houseType, bedrooms, bathrooms, pageNo, pageSize, rank);
        return success("成功", 200, data);
    }


    /**
     * 根据房屋编码获取房子的详细信息
     */
    @PostMapping("/homeDetails")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "homeCode", value = "房屋编码", paramType = "query"),
            @ApiImplicitParam(name = "userNo", value = "登陆的用户编码", paramType = "query"),
    })
    @ApiOperation(value = "根据房屋编码获取房子的详细信息", httpMethod = "POST")
    public AjaxResult homeDetails(String homeCode, String userNo) {
        if (homeCode != "" && homeCode != null) {
            HomeDetails homeDetails = new HomeDetails();
            // 先查询当前基本信息
            Map<String, Object> houseInfo = iHouseService.quereyhouseInfo(homeCode);
            if (houseInfo.size() > 0) {
                // 查询数组图片
                List<String> imgs = iHouseService.quereyImgs(homeCode);
                homeDetails.setImgs(imgs);
                // 封装基础信息
                homeDetails.setHouses((String) houseInfo.get("houses_name"));
                homeDetails.setHouseType((String) houseInfo.get("housing_type"));
                homeDetails.setPrice(houseInfo.get("houses_price_type") + "" + houseInfo.get("houses_price"));
                homeDetails.setAddress(houseInfo.get("country") + "" + houseInfo.get("city") + houseInfo.get("houses_address"));
                homeDetails.setHousesCode((String) houseInfo.get("houses_code"));
                homeDetails.setDatePayment((String) houseInfo.get("houses_delivery"));
                homeDetails.setOwnership((String) houseInfo.get("houses_equity"));
                homeDetails.setDescribe((String) houseInfo.get("houses_describe"));
                // 查询户型介绍
                List<Doormodel> doormodelList = new ArrayList<>();
                Doormodel doormodel = null;
                List<Map<String, Object>> doormodeldata = iHouseService.queryDoormodel(homeCode);
                for (int i = 0; i < doormodeldata.size(); i++) {
                    doormodel = new Doormodel();
                    doormodel.setImg((String) doormodeldata.get(i).get("houses_drawing_url"));
                    doormodel.setName((String) doormodeldata.get(i).get("houses_drawing_name"));
                    doormodel.setPrice(houseInfo.get("houses_price_type") + "" + doormodeldata.get(i).get("houses_unit_price") + "/套");
                    doormodel.setSpecification(doormodeldata.get(i).get("houses_area") + "㎡" + doormodeldata.get(i).get("houses_bedroom_no") + "卧室" + doormodeldata.get(i).get("houses_bathroom_no") + "卫浴");
                    doormodelList.add(doormodel);
                }
                homeDetails.setDoorModel(doormodelList);
                // 查询开发商的信息
                Developers developers = iHouseService.quereyDevelopers((String) houseInfo.get("house_developers_no"));
                homeDetails.setDevelopers(developers);
                // 查询当前用户是否关注了这套房子
                boolean focus = iHouseService.quereyFocusRelation(userNo, homeCode);
                homeDetails.setFocus(focus);
                return success("查询成功", 200, homeDetails);
            }
            return error(500, "服务器繁忙，请稍后再试");
        }
        return error(500, "服务器繁忙，请稍后再试(空)");
    }


    /**
     * 关注新房源
     */
    @PostMapping("/attentionHouse")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiOperation(value = "关注新房源", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "collectionType", value = "收藏房屋类型（0新房1二手房2商业地产3租房）", paramType = "query"),
    })
    public AjaxResult attentionHouse(String homeCode, String userNo, String collectionType) {
        // 查询当前用户是否关注了此房源
        boolean focus = iHouseService.quereyFocusRelation(userNo, homeCode);
        if (focus) {
            boolean data = iHouseService.deleteCollection(homeCode, userNo);
            if (data) {
                return success(200, "取消关注成功");
            }
            return error(500, "系统繁忙呀");
        } else {
            boolean data = iHouseService.addCollection(homeCode, userNo, collectionType);
            if (data) {
                return success(200, "关注成功");
            }
            return error(500, "关注失败了呀");
        }
    }

    /**
     * 关注的新房源列表
     */
    @PostMapping("/attentionHouseList")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiOperation(value = "关注的新房源列表", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "collectionType", value = "收藏房屋类型（0新房1二手房2商业地产3租房）", paramType = "query"),
    })
    public AjaxResult attentionHouseList(String userNo, String collectionType) {
        List<BridalchamberList> data = iHouseService.quereyFocus(userNo, collectionType);
        return success("成功", 200, data);
    }


    /**
     * 查看我的房产经纪人的房屋（按照时间降序排列）
     */
    @PostMapping("/queryAgentHouse")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiOperation(value = "查看我的房产经纪人的房屋", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "focusUserNo", value = "房产经纪编码", paramType = "query", dataType = "String"),
    })
    public AjaxResult queryAgentHouse(String focusUserNo) {
        List<BridalchamberList> data = iHouseService.queryAgentHouse(focusUserNo);
        return success("成功", 200, data);
    }


}
