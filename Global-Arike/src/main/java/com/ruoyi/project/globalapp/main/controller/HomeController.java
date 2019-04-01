package com.ruoyi.project.globalapp.main.controller;

import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.global.collection.domain.Collections;
import com.ruoyi.project.global.comments.domain.Comments;
import com.ruoyi.project.global.information.domain.Information;
import com.ruoyi.project.global.pioneer.domain.Pioneer;
import com.ruoyi.project.global.pioneer.service.IPioneerService;
import com.ruoyi.project.global.userInfo.domain.UserInfo;
import com.ruoyi.project.global.userInfo.service.IUserInfoService;
import com.ruoyi.project.globalapp.main.domain.*;
import com.ruoyi.project.globalapp.main.service.IHomeService;
import com.ruoyi.project.tool.build.DataBaseTool;
import com.ruoyi.project.tool.build.RelativeDateFormat;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 主页的接口
 */

@Controller
@RequestMapping("/v1/home")
@Api(tags = "业务接口", description = "HomeController")
public class HomeController extends BaseController {
    @Autowired
    private IHomeService iHomeService;

    @Autowired
    private IPioneerService pioneerService;

    @Autowired
    private IUserInfoService userInfoService;

    /**
     * 获取首页的Banner图片
     */
    @GetMapping("/findHomeBanner")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiOperation(value = "获取首页的Banner图片", httpMethod = "GET")
    public AjaxResult findHomeBanner() {
        List<ImgBanners> imgBanners = iHomeService.findHomeBanner();
        if (imgBanners != null) {
            return success("操作成功", 200, imgBanners);
        }
        return error(500, "服务忙请稍后重试");
    }


    /**
     * 国家城市对应关系
     */
    @GetMapping("/findCity")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiOperation(value = "城市选择", httpMethod = "GET")
    public AjaxResult findCity() {
        List<Country> city = iHomeService.findCity();
        if (city != null) {
            return success("操作成功", 200, city);
        }
        return error(500, "服务忙请稍后重试");
    }


    /**
     * 用户添加预约顾问
     */
    @PostMapping("/addSubscribeInfo")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiOperation(value = "用户添加预约顾问", httpMethod = "POST")
    public AjaxResult addSubscribeInfo(SubscribeInfos subscribeInfos) {
        // 先查询当前用户是否预约了当前房子的
        // SubscribeInfos data = iHomeService.findSubscribeInfoInfo(subscribeInfos.getHousesCode(),subscribeInfos.getUserNo());
        boolean add_success = iHomeService.addSubscribeInfo(subscribeInfos);
        if (add_success) {
            return success("操作成功", 200, add_success);
        }
        return error(500, "服务忙请稍后重试");
    }


    /**
     * 查询当前是否申请了预约顾问
     */
    @PostMapping("/whetherSubscribeInfo")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiOperation(value = "查询当前是否申请了预约顾问", httpMethod = "POST")
    public AjaxResult whetherSubscribeInfo(String housesCode, String userNo) {
        // 先查询当前用户是否预约了当前房子的
        SubscribeInfos data = iHomeService.findSubscribeInfoInfo(housesCode, userNo);
        if (data != null) {
            return success("操作成功", 200, true);
        } else {
            return success("操作成功", 200, false);
        }
    }


    /**
     * 获取电话号码号段
     */
    @GetMapping("/findPhoneCode")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiOperation(value = "电话号码号段选择", httpMethod = "GET")
    public AjaxResult findPhoneCode() {
        List<CountryMobilePrefixOutput> data = iHomeService.findPhoneCode();
        if (data.size() > 0) {
            return success("操作成功", 200, data);
        }
        return error(500, "服务忙请稍后重试");
    }

    /**
     * 地产先锋列表
     */
    @PostMapping("/queryPioneerList")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiOperation(value = "地产先锋列表", httpMethod = "POST")
    public AjaxResult queryPioneerList(int pageSize, int pageNo, String city, String userNo) {
        pageNo = pageNo * pageSize;
        List<PioneerList> data = iHomeService.queryPioneerList(pageSize, pageNo, city);
        Map<String, Object> map = new HashMap<>();
        map.put("data", data);
        boolean exist = iHomeService.findPioneer(userNo);
        map.put("exist", exist);
        return success("操作成功", 200, map);
    }

    /**
     * 查看地产先锋的详情
     */
    @PostMapping("/queryPioneerInfo")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiOperation(value = "查看地产先锋的详情", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "userNo", value = "用户编码（当前登陆用户）", paramType = "query", dataType = "String"),
            @ApiImplicitParam(required = true, name = "focusUserNo", value = "房产经纪编码", paramType = "query", dataType = "String"),
    })
    public AjaxResult queryPioneerInfo(String userNo, String focusUserNo) {
        Pioneer pioneer = new Pioneer();
        pioneer.setUserNo(focusUserNo);
        List<Pioneer> data = pioneerService.selectPioneerList(pioneer);
        // 查询当前用户编码是否被关注
        boolean focus = iHomeService.queryFocus(userNo, focusUserNo);
        data.get(0).setRelation(focus);
        return success("操作成功", 200, data.get(0));
    }

    /**
     * 申请添加成为地产先锋
     */
    @PostMapping("/addPioneer")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiOperation(value = "申请添加成为地产先锋", httpMethod = "POST")
    public AjaxResult addPioneer(PioneerList pioneerList) {
        // 查询用户的基本情况
        UserInfo userInfo = userInfoService.selectUserInfoById(pioneerList.getUserNo());
        Pioneer pioneer = new Pioneer();
        pioneer.setUserNo(pioneerList.getUserNo());
        pioneer.setEmailNo(null);
        pioneer.setPhoneNo(userInfo.getPhoneNo());
        pioneer.setLive(pioneerList.getLive());
        pioneer.setUserHead(pioneerList.getUserHead());
        pioneer.setUserName(pioneerList.getUserName());
        pioneer.setIntroduce(pioneerList.getIntroduce());
        pioneer.setTime(new Date());
        // 查询当前用户是否是地产先锋
        boolean exist = iHomeService.findPioneer(pioneerList.getUserNo());
        if (exist) {
            // 进行修改
            int data = iHomeService.updatePioneer(pioneer);
            if (data > 0) {
                return success(200, "修改成功");
            }
            return error(500, "修改失败");
        }
        int data = pioneerService.insertPioneer(pioneer);
        if (data > 0) {
            return success(200, "添加成功");
        }
        return error(500, "添加失败");
    }

    /**
     * 关注/取消当前房产经纪人
     */
    @PostMapping("/addFocusPioneer")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiOperation(value = "关注/取消当前房产经纪人", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "userNo", value = "用户编码（当前登陆用户）", paramType = "query", dataType = "String"),
            @ApiImplicitParam(required = true, name = "focusUserNo", value = "房产经纪编码", paramType = "query", dataType = "String"),
    })
    public AjaxResult addFocusPioneer(String userNo, String focusUserNo) {
        boolean focus = iHomeService.queryFocus(userNo, focusUserNo);
        if (focus) {
            // 取消关注
            boolean data = iHomeService.deleteFocusPioneer(userNo, focusUserNo);
            if (data) {
                return success(200, "取消关注成功");
            }
            return error(500, "系统忙稍后再试");
        } else {
            // 关注
            boolean data = iHomeService.addFocusPioneer(userNo, focusUserNo);
            if (data) {
                return success(200, "关注成功");
            }
            return error(500, "系统忙稍后再试");
        }
    }

    /**
     * 我关注的房产经纪人
     */
    @PostMapping("/myFocusPioneer")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiOperation(value = "我关注的房产经纪人", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "userNo", value = "用户编码（当前登陆用户）", paramType = "query", dataType = "String"),
    })
    public AjaxResult myFocusPioneer(String userNo) {
        List<PioneerList> data = iHomeService.myFocusPioneer(userNo);
        return success("成功", 200, data);
    }


    /**
     * 资讯列表展示
     */
    @PostMapping("/informationlist")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiOperation(value = "资讯列表展示", httpMethod = "POST")
    public AjaxResult queryInformationList(int pageSize, int pageNo) throws ParseException {
        pageNo = pageNo * pageSize;
        //分页获取当前资讯的数据（按照时间降序排列）
        List<InformationList> data = iHomeService.queryInformationList(pageSize, pageNo);
        // 把时间换算成几个小时以前
        for (int i = 0; i < data.size(); i++) {
            data.get(i).setCreateTime(RelativeDateFormat.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(data.get(i).getCreateTime())));
        }
        return success("成功", 200, data);
    }


    /**
     * 查看当前资讯的详情
     */
    @PostMapping("/informationdetails")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiOperation(value = "获取资讯的详情", httpMethod = "POST")
    public AjaxResult informationDetails(String informationNo, String userNo) {
        // 浏览量
        iHomeService.addLook(informationNo);
        // 获取详情
        Information data = iHomeService.informationDetails(informationNo);
        if (ObjectUtil.isNotNull(data)) {
            // 判断当前用户是否收藏了当前资讯（1002）
            String businessType = "1002";
            boolean whetherCollect = iHomeService.queryWhetherCollect(userNo, informationNo, businessType);
            data.setWhetherCollect(whetherCollect);
            return success("成功", 200, data);
        }
        return error(500, "服务正忙，请稍等重试");
    }


    /**
     * 进行资讯评论
     */
    @PostMapping("/informationComments")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiOperation(value = "进行资讯评论", httpMethod = "POST")
    public AjaxResult informationComments(String informationNo, String content, String userNo) {
        if (ObjectUtil.isNotNull(informationNo) && ObjectUtil.isNotNull(content) && ObjectUtil.isNotNull(userNo)) {
            //2.0 插入评论结果
            String comNo = DataBaseTool.createNo("PL");
            Comments comments = new Comments();
            comments.setCommentNo(comNo);
            comments.setCommentTime(new Date());
            comments.setUserNo(userNo);
            comments.setContent(content);
            comments.setInformationNo(informationNo);
            boolean data = iHomeService.addComments(comments);
            if (data) {
                //1.0 评论成功把评论数加一
                iHomeService.addGiveNo(informationNo);
                return success(200, "评论成功");
            }
        }
        return error(500, "评论的内容不能空");
    }

    /**
     * 进行房产资讯点击记录
     */
    @PostMapping("/informationLook")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiOperation(value = "进行房产资讯点击记录", httpMethod = "POST")
    public AjaxResult informationLook(String informationNo) {
        iHomeService.addLook(informationNo);
        return success(200, "成功");
    }

    /**
     * 获取资讯评论列表
     */
    @PostMapping("/commentslist")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiOperation(value = "获取资讯评论列表", httpMethod = "POST")
    public AjaxResult informationCommentsList(String informationNo, int pageSize, int pageNo) throws ParseException {
        pageNo = pageNo * pageSize;
        if (ObjectUtil.isNotNull(informationNo)) {
            List<GlobalComments> data = iHomeService.queryCommentsList(informationNo, pageSize, pageNo);
            for (int i = 0; i < data.size(); i++) {
                data.get(i).setCommentTime(RelativeDateFormat.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(data.get(i).getCommentTime())));
            }
            return success("获取成功", 200, data);
        }
        return error(200, "服务器繁忙，稍后再试");
    }

    /**
     * 点击进行收藏
     */
    @PostMapping("/addbusiness")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "businessType", value = "收藏类型（房屋1001），（资讯1002））", paramType = "query", dataType = "String"),
            @ApiImplicitParam(required = true, name = "businessNo", value = "收藏编码", paramType = "query", dataType = "String"),
            @ApiImplicitParam(required = true, name = "userNo", value = "用户编码", paramType = "query", dataType = "String"),
    })
    @ApiOperation(value = "点击进行收藏", httpMethod = "POST")
    public AjaxResult addBusiness(String userNo, String businessNo, String businessType) {
        // 先查询一次是否收藏，有：取消收藏，没有：进行收藏
        boolean collect = iHomeService.queryWhetherCollect(userNo, businessNo, businessType);
        if (collect) {
            // 删除当前收藏
            boolean delete = iHomeService.deleteCollect(businessNo);
            if (delete) {
                return success(200, "取消收藏");
            }
        } else {
            Collections collection = new Collections();
            collection.setId(DataBaseTool.createNo("SC"));
            collection.setUserNo(userNo);
            collection.setBusinessNo(businessNo);
            collection.setBusinessType(businessType);
            collection.setCollectionTime(new Date());
            boolean data = iHomeService.addBusiness(collection);
            if (data) {
                return success(200, "收藏成功");
            }
        }
        return error(500, "服务正忙");
    }

    /**
     * 获取收藏的资讯
     */
    @PostMapping("/collectioninformationlist")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiOperation(value = "获取收藏资讯列表展示", httpMethod = "POST")
    public AjaxResult queryCollectionInformationList(int pageSize, int pageNo, String userNo) throws ParseException {
        pageNo = pageNo * pageSize;
        //分页获取当前资讯的数据（按照时间降序排列）
        List<InformationList> data = iHomeService.queryCollectionInformationList(pageSize, pageNo, userNo);
        // 把时间换算成几个小时以前
        for (int i = 0; i < data.size(); i++) {
            data.get(i).setCreateTime(RelativeDateFormat.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(data.get(i).getCreateTime())));
        }
        return success("成功", 200, data);
    }
}
