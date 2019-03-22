package com.ruoyi.project.global.serviceCountry.controller;

import java.util.List;

import com.ruoyi.project.tool.build.DataBaseTool;
import com.ruoyi.project.tool.ftp.FtpULinkTool;
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
import com.ruoyi.project.global.serviceCountry.domain.ServiceCountry;
import com.ruoyi.project.global.serviceCountry.service.IServiceCountryService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 国家管理 信息操作处理
 *
 * @author ruoyi
 * @date 2019-02-13
 */
@Controller
@RequestMapping("/global/serviceCountry")
public class ServiceCountryController extends BaseController {
    private String prefix = "global/serviceCountry";

    @Autowired
    private IServiceCountryService serviceCountryService;

    @RequiresPermissions("global:serviceCountry:view")
    @GetMapping()
    public String serviceCountry() {
        return prefix + "/serviceCountry";
    }

    /**
     * 查询国家管理列表
     */
    @RequiresPermissions("global:serviceCountry:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ServiceCountry serviceCountry) {
        startPage();
        List<ServiceCountry> list = serviceCountryService.selectServiceCountryList(serviceCountry);
        return getDataTable(list);
    }


    @GetMapping("/lists")
    @ResponseBody
    public TableDataInfo lists(ServiceCountry serviceCountry) {
        List<ServiceCountry> list = serviceCountryService.selectServiceCountryList(serviceCountry);
        return getDataTable(list);
    }

    /**
     * 导出国家管理列表
     */
    @RequiresPermissions("global:serviceCountry:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ServiceCountry serviceCountry) {
        List<ServiceCountry> list = serviceCountryService.selectServiceCountryList(serviceCountry);
        ExcelUtil<ServiceCountry> util = new ExcelUtil<ServiceCountry>(ServiceCountry.class);
        return util.exportExcel(list, "serviceCountry");
    }

    /**
     * 新增国家管理
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存国家管理
     */
    @RequiresPermissions("global:serviceCountry:add")
    @Log(title = "国家管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ServiceCountry serviceCountry) {
        // 生成国家编码
        serviceCountry.setScopeOneNo(DataBaseTool.generateShortUuid());
        return toAjax(serviceCountryService.insertServiceCountry(serviceCountry));
    }

    /**
     * 修改国家管理
     */
    @GetMapping("/edit/{scopeOneNo}")
    public String edit(@PathVariable("scopeOneNo") String scopeOneNo, ModelMap mmap) {
        ServiceCountry serviceCountry = serviceCountryService.selectServiceCountryById(scopeOneNo);
        mmap.put("serviceCountry", serviceCountry);
        return prefix + "/edit";
    }

    /**
     * 修改保存国家管理
     */
    @RequiresPermissions("global:serviceCountry:edit")
    @Log(title = "国家管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ServiceCountry serviceCountry) {
        return toAjax(serviceCountryService.updateServiceCountry(serviceCountry));
    }

    /**
     * 删除国家管理
     */
    @RequiresPermissions("global:serviceCountry:remove")
    @Log(title = "国家管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(serviceCountryService.deleteServiceCountryByIds(ids));
    }

}
