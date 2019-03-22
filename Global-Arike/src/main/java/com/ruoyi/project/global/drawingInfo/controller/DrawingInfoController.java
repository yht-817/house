package com.ruoyi.project.global.drawingInfo.controller;

import java.util.List;

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
import com.ruoyi.project.global.drawingInfo.domain.DrawingInfo;
import com.ruoyi.project.global.drawingInfo.service.IDrawingInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 房屋介绍 信息操作处理
 *
 * @author ruoyi
 * @date 2019-02-20
 */
@Controller
@RequestMapping("/global/drawingInfo")
public class DrawingInfoController extends BaseController {
    private String prefix = "global/drawingInfo";

    @Autowired
    private IDrawingInfoService drawingInfoService;

    @RequiresPermissions("global:drawingInfo:view")
    @GetMapping()
    public String drawingInfo() {
        return prefix + "/drawingInfo";
    }

    /**
     * 查询房屋介绍列表
     */
    @RequiresPermissions("global:drawingInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DrawingInfo drawingInfo) {
        startPage();
        List<DrawingInfo> list = drawingInfoService.selectDrawingInfoList(drawingInfo);
        return getDataTable(list);
    }


    /**
     * 导出房屋介绍列表
     */
    @RequiresPermissions("global:drawingInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DrawingInfo drawingInfo) {
        List<DrawingInfo> list = drawingInfoService.selectDrawingInfoList(drawingInfo);
        ExcelUtil<DrawingInfo> util = new ExcelUtil<DrawingInfo>(DrawingInfo.class);
        return util.exportExcel(list, "drawingInfo");
    }

    /**
     * 新增房屋介绍
     */
    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") String id, ModelMap mmap) {
        System.out.println("-----------------" + id);
        mmap.put("housesCode", id);
        return prefix + "/add";
    }

    /**
     * 新增保存房屋介绍
     */
    @RequiresPermissions("global:drawingInfo:add")
    @Log(title = "房屋介绍", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DrawingInfo drawingInfo) {
        return toAjax(drawingInfoService.insertDrawingInfo(drawingInfo));
    }

    /**
     * 修改房屋介绍
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        DrawingInfo drawingInfo = drawingInfoService.selectDrawingInfoById(id);
        mmap.put("drawingInfo", drawingInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存房屋介绍
     */
    @RequiresPermissions("global:drawingInfo:edit")
    @Log(title = "房屋介绍", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DrawingInfo drawingInfo) {
        return toAjax(drawingInfoService.updateDrawingInfo(drawingInfo));
    }

    /**
     * 删除房屋介绍
     */
    @RequiresPermissions("global:drawingInfo:remove")
    @Log(title = "房屋介绍", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(drawingInfoService.deleteDrawingInfoByIds(ids));
    }

}
