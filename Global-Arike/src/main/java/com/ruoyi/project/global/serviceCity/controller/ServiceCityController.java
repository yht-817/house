package com.ruoyi.project.global.serviceCity.controller;

import java.util.List;
import java.util.UUID;

import cn.hutool.core.util.RandomUtil;
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
import com.ruoyi.project.global.serviceCity.domain.ServiceCity;
import com.ruoyi.project.global.serviceCity.service.IServiceCityService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 服务城市 信息操作处理
 *
 * @author ruoyi
 * @date 2019-02-14
 */
@Controller
@RequestMapping("/global/serviceCity")
public class ServiceCityController extends BaseController {
    private String prefix = "global/serviceCity";

    @Autowired
    private IServiceCityService serviceCityService;

    @RequiresPermissions("global:serviceCity:view")
    @GetMapping()
    public String serviceCity() {
        return prefix + "/serviceCity";
    }

    /**
     * 查询服务城市列表
     */
    @RequiresPermissions("global:serviceCity:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ServiceCity serviceCity) {
        startPage();
        List<ServiceCity> list = serviceCityService.selectServiceCityList(serviceCity);
        return getDataTable(list);
    }


    /**
     * 导出服务城市列表
     */
    @RequiresPermissions("global:serviceCity:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ServiceCity serviceCity) {
        List<ServiceCity> list = serviceCityService.selectServiceCityList(serviceCity);
        ExcelUtil<ServiceCity> util = new ExcelUtil<ServiceCity>(ServiceCity.class);
        return util.exportExcel(list, "serviceCity");
    }

    /**
     * 新增服务城市
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存服务城市
     */
    @RequiresPermissions("global:serviceCity:add")
    @Log(title = "服务城市", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ServiceCity serviceCity) {
        serviceCity.setScopeTwoNo(DataBaseTool.generateShortUuid());
        return toAjax(serviceCityService.insertServiceCity(serviceCity));
    }

    /**
     * 修改服务城市
     */
    @GetMapping("/edit/{scopeTwoNo}")
    public String edit(@PathVariable("scopeTwoNo") String scopeTwoNo, ModelMap mmap) {
        ServiceCity serviceCity = serviceCityService.selectServiceCityById(scopeTwoNo);
        mmap.put("serviceCity", serviceCity);
        return prefix + "/edit";
    }

    /**
     * 修改保存服务城市
     */
    @RequiresPermissions("global:serviceCity:edit")
    @Log(title = "服务城市", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ServiceCity serviceCity) {
        return toAjax(serviceCityService.updateServiceCity(serviceCity));
    }

    /**
     * 删除服务城市
     */
    @RequiresPermissions("global:serviceCity:remove")
    @Log(title = "服务城市", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(serviceCityService.deleteServiceCityByIds(ids));
    }

}
