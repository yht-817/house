package com.ruoyi.project.global.housesInfo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.project.global.drawingInfo.domain.DrawingInfo;
import com.ruoyi.project.global.drawingInfo.service.IDrawingInfoService;
import com.ruoyi.project.system.dict.service.IDictTypeService;
import com.ruoyi.project.system.user.domain.User;
import com.ruoyi.project.tool.build.DataBaseTool;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.global.housesInfo.domain.HousesInfo;
import com.ruoyi.project.global.housesInfo.service.IHousesInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 房屋 信息操作处理
 *
 * @author ruoyi
 * @date 2019-02-19
 */
@Controller
@RequestMapping("/global/housesInfo")
public class HousesInfoController extends BaseController {
    private String prefix = "global/housesInfo";

    @Autowired
    private IHousesInfoService housesInfoService;


    @RequiresPermissions("global:housesInfo:view")
    @GetMapping()
    public String housesInfo() {
        return prefix + "/housesInfo";
    }

    /**
     * 查询房屋列表
     */
    @RequiresPermissions("global:housesInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HousesInfo housesInfo) {
        User shiroUser = (User) SecurityUtils.getSubject().getPrincipal();
        housesInfo.setUserNo(shiroUser.getUserName());
        startPage();
        List<HousesInfo> list = housesInfoService.selectHousesInfoList(housesInfo);
        return getDataTable(list);
    }


    /**
     * 导出房屋列表
     */
    @RequiresPermissions("global:housesInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HousesInfo housesInfo) {
        List<HousesInfo> list = housesInfoService.selectHousesInfoList(housesInfo);
        ExcelUtil<HousesInfo> util = new ExcelUtil<HousesInfo>(HousesInfo.class);
        return util.exportExcel(list, "housesInfo");
    }

    /**
     * 新增房屋
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存房屋
     */
    @RequiresPermissions("global:housesInfo:add")
    @Log(title = "房屋", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HousesInfo housesInfo) {
        User shiroUser = (User) SecurityUtils.getSubject().getPrincipal();
        housesInfo.setUserNo(shiroUser.getUserName());
        housesInfo.setId(DataBaseTool.createNo("HS"));
        housesInfo.setHousesCode(DataBaseTool.generateShortUuid());
        //查询国家对应的币种
        String currency = housesInfoService.queryCurrency(housesInfo.getCountry());
        housesInfo.setHousesPriceType(currency);
        return toAjax(housesInfoService.insertHousesInfo(housesInfo));
    }

    /**
     * 修改房屋
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        HousesInfo housesInfo = housesInfoService.selectHousesInfoById(id);
        mmap.put("housesInfo", housesInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存房屋
     */
    @RequiresPermissions("global:housesInfo:edit")
    @Log(title = "房屋", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HousesInfo housesInfo) {
        return toAjax(housesInfoService.updateHousesInfo(housesInfo));
    }

    /**
     * 删除房屋
     */
    @RequiresPermissions("global:housesInfo:remove")
    @Log(title = "房屋", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(housesInfoService.deleteHousesInfoByIds(ids));
    }

    /**
     * 添加户型介绍
     */
    @GetMapping("/detail/{dictId}")
    public String detail(@PathVariable("dictId") String dictId, ModelMap mmap) {
        mmap.put("housesCode", dictId);
        return "global/drawingInfo/drawingInfo";
    }

    /**
     * 添加楼盘相册
     */
    @GetMapping("/detailImg/{dictId}")
    public String detailImg(@PathVariable("dictId") String dictId, ModelMap mmap) {
        mmap.put("housesCode", dictId);
        return "global/housesInfoImg/housesInfoImg";
    }

}
