package com.ruoyi.project.global.pioneer.controller;

import java.util.Date;
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
import com.ruoyi.project.global.pioneer.domain.Pioneer;
import com.ruoyi.project.global.pioneer.service.IPioneerService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 地产先锋 信息操作处理
 *
 * @author ruoyi
 * @date 2019-02-21
 */
@Controller
@RequestMapping("/global/pioneer")
public class PioneerController extends BaseController {
    private String prefix = "global/pioneer";

    @Autowired
    private IPioneerService pioneerService;

    @RequiresPermissions("global:pioneer:view")
    @GetMapping()
    public String pioneer() {
        return prefix + "/pioneer";
    }

    /**
     * 查询地产先锋列表
     */
    @RequiresPermissions("global:pioneer:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Pioneer pioneer) {
        startPage();
        List<Pioneer> list = pioneerService.selectPioneerList(pioneer);
        return getDataTable(list);
    }


    /**
     * 导出地产先锋列表
     */
    @RequiresPermissions("global:pioneer:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Pioneer pioneer) {
        List<Pioneer> list = pioneerService.selectPioneerList(pioneer);
        ExcelUtil<Pioneer> util = new ExcelUtil<Pioneer>(Pioneer.class);
        return util.exportExcel(list, "pioneer");
    }

    /**
     * 新增地产先锋
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存地产先锋
     */
    @RequiresPermissions("global:pioneer:add")
    @Log(title = "地产先锋", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Pioneer pioneer) {
        pioneer.setTime(new Date());
        pioneer.setHide(0);
        return toAjax(pioneerService.insertPioneer(pioneer));
    }

    /**
     * 修改地产先锋
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        Pioneer pioneer = pioneerService.selectPioneerById(id);
        mmap.put("pioneer", pioneer);
        return prefix + "/edit";
    }

    /**
     * 修改保存地产先锋
     */
    @RequiresPermissions("global:pioneer:edit")
    @Log(title = "地产先锋", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Pioneer pioneer) {
        return toAjax(pioneerService.updatePioneer(pioneer));
    }

    /**
     * 删除地产先锋
     */
    @RequiresPermissions("global:pioneer:remove")
    @Log(title = "地产先锋", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(pioneerService.deletePioneerByIds(ids));
    }

}
