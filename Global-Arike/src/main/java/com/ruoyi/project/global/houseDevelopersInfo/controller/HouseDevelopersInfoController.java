package com.ruoyi.project.global.houseDevelopersInfo.controller;

import java.util.List;

import com.ruoyi.project.tool.build.DataBaseTool;
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
import com.ruoyi.project.global.houseDevelopersInfo.domain.HouseDevelopersInfo;
import com.ruoyi.project.global.houseDevelopersInfo.service.IHouseDevelopersInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 开发商介绍 信息操作处理
 *
 * @author ruoyi
 * @date 2019-02-15
 */
@Controller
@RequestMapping("/global/houseDevelopersInfo")
public class HouseDevelopersInfoController extends BaseController {
    private String prefix = "global/houseDevelopersInfo";

    @Autowired
    private IHouseDevelopersInfoService houseDevelopersInfoService;

    @RequiresPermissions("global:houseDevelopersInfo:view")
    @GetMapping()
    public String houseDevelopersInfo() {
        return prefix + "/houseDevelopersInfo";
    }

    /**
     * 查询开发商介绍列表
     */
    @RequiresPermissions("global:houseDevelopersInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HouseDevelopersInfo houseDevelopersInfo) {
        startPage();
        List<HouseDevelopersInfo> list = houseDevelopersInfoService.selectHouseDevelopersInfoList(houseDevelopersInfo);
        return getDataTable(list);
    }

    @GetMapping("/lists")
    @ResponseBody
    public TableDataInfo lists(HouseDevelopersInfo houseDevelopersInfo) {
        List<HouseDevelopersInfo> list = houseDevelopersInfoService.selectHouseDevelopersInfoList(houseDevelopersInfo);
        return getDataTable(list);
    }

    /**
     * 导出开发商介绍列表
     */
    @RequiresPermissions("global:houseDevelopersInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HouseDevelopersInfo houseDevelopersInfo) {
        List<HouseDevelopersInfo> list = houseDevelopersInfoService.selectHouseDevelopersInfoList(houseDevelopersInfo);
        ExcelUtil<HouseDevelopersInfo> util = new ExcelUtil<HouseDevelopersInfo>(HouseDevelopersInfo.class);
        return util.exportExcel(list, "houseDevelopersInfo");
    }

    /**
     * 新增开发商介绍
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存开发商介绍
     */
    @RequiresPermissions("global:houseDevelopersInfo:add")
    @Log(title = "开发商介绍", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HouseDevelopersInfo houseDevelopersInfo) {
        houseDevelopersInfo.setId(DataBaseTool.createNo("KF"));
        houseDevelopersInfo.setHouseDevelopersNo(DataBaseTool.generateShortUuid());
        return toAjax(houseDevelopersInfoService.insertHouseDevelopersInfo(houseDevelopersInfo));
    }

    /**
     * 修改开发商介绍
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        HouseDevelopersInfo houseDevelopersInfo = houseDevelopersInfoService.selectHouseDevelopersInfoById(id);
        mmap.put("houseDevelopersInfo", houseDevelopersInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存开发商介绍
     */
    @RequiresPermissions("global:houseDevelopersInfo:edit")
    @Log(title = "开发商介绍", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HouseDevelopersInfo houseDevelopersInfo) {
        return toAjax(houseDevelopersInfoService.updateHouseDevelopersInfo(houseDevelopersInfo));
    }

    /**
     * 删除开发商介绍
     */
    @RequiresPermissions("global:houseDevelopersInfo:remove")
    @Log(title = "开发商介绍", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(houseDevelopersInfoService.deleteHouseDevelopersInfoByIds(ids));
    }

}
