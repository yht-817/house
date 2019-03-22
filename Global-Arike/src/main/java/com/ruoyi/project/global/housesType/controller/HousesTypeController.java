package com.ruoyi.project.global.housesType.controller;

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
import com.ruoyi.project.global.housesType.domain.HousesType;
import com.ruoyi.project.global.housesType.service.IHousesTypeService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 房屋类型 信息操作处理
 *
 * @author ruoyi
 * @date 2019-02-19
 */
@Controller
@RequestMapping("/global/housesType")
public class HousesTypeController extends BaseController {
    private String prefix = "global/housesType";

    @Autowired
    private IHousesTypeService housesTypeService;

    @RequiresPermissions("global:housesType:view")
    @GetMapping()
    public String housesType() {
        return prefix + "/housesType";
    }

    /**
     * 查询房屋类型列表
     */
    @RequiresPermissions("global:housesType:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HousesType housesType) {
        startPage();
        List<HousesType> list = housesTypeService.selectHousesTypeList(housesType);
        return getDataTable(list);
    }


    /**
     * 查询房屋类型列表
     */
    @GetMapping("/lists")
    @ResponseBody
    public TableDataInfo lists(HousesType housesType) {
        List<HousesType> list = housesTypeService.selectHousesTypeList(housesType);
        return getDataTable(list);
    }


    /**
     * 导出房屋类型列表
     */
    @RequiresPermissions("global:housesType:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HousesType housesType) {
        List<HousesType> list = housesTypeService.selectHousesTypeList(housesType);
        ExcelUtil<HousesType> util = new ExcelUtil<HousesType>(HousesType.class);
        return util.exportExcel(list, "housesType");
    }

    /**
     * 新增房屋类型
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存房屋类型
     */
    @RequiresPermissions("global:housesType:add")
    @Log(title = "房屋类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HousesType housesType) {
        housesType.setTypeNo((int) System.currentTimeMillis());
        return toAjax(housesTypeService.insertHousesType(housesType));
    }

    /**
     * 修改房屋类型
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        HousesType housesType = housesTypeService.selectHousesTypeById(id);
        mmap.put("housesType", housesType);
        return prefix + "/edit";
    }

    /**
     * 修改保存房屋类型
     */
    @RequiresPermissions("global:housesType:edit")
    @Log(title = "房屋类型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HousesType housesType) {
        return toAjax(housesTypeService.updateHousesType(housesType));
    }

    /**
     * 删除房屋类型
     */
    @RequiresPermissions("global:housesType:remove")
    @Log(title = "房屋类型", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(housesTypeService.deleteHousesTypeByIds(ids));
    }

}
