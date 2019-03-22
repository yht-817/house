package com.ruoyi.project.global.housesInfoImg.controller;

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
import com.ruoyi.project.global.housesInfoImg.domain.HousesInfoImg;
import com.ruoyi.project.global.housesInfoImg.service.IHousesInfoImgService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 楼盘相册 信息操作处理
 *
 * @author ruoyi
 * @date 2019-02-20
 */
@Controller
@RequestMapping("/global/housesInfoImg")
public class HousesInfoImgController extends BaseController {
    private String prefix = "global/housesInfoImg";

    @Autowired
    private IHousesInfoImgService housesInfoImgService;

    @RequiresPermissions("global:housesInfoImg:view")
    @GetMapping()
    public String housesInfoImg() {
        return prefix + "/housesInfoImg";
    }

    /**
     * 查询楼盘相册列表
     */
    @RequiresPermissions("global:housesInfoImg:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HousesInfoImg housesInfoImg) {
        startPage();
        List<HousesInfoImg> list = housesInfoImgService.selectHousesInfoImgList(housesInfoImg);
        return getDataTable(list);
    }


    /**
     * 导出楼盘相册列表
     */
    @RequiresPermissions("global:housesInfoImg:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HousesInfoImg housesInfoImg) {
        List<HousesInfoImg> list = housesInfoImgService.selectHousesInfoImgList(housesInfoImg);
        ExcelUtil<HousesInfoImg> util = new ExcelUtil<HousesInfoImg>(HousesInfoImg.class);
        return util.exportExcel(list, "housesInfoImg");
    }

    /**
     * 新增楼盘相册
     */
    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") String id, ModelMap mmap) {
        mmap.put("housesCode", id);
        return prefix + "/add";
    }

    /**
     * 新增保存楼盘相册
     */
    @RequiresPermissions("global:housesInfoImg:add")
    @Log(title = "楼盘相册", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HousesInfoImg housesInfoImg) {
        return toAjax(housesInfoImgService.insertHousesInfoImg(housesInfoImg));
    }

    /**
     * 修改楼盘相册
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        HousesInfoImg housesInfoImg = housesInfoImgService.selectHousesInfoImgById(id);
        mmap.put("housesInfoImg", housesInfoImg);
        return prefix + "/edit";
    }

    /**
     * 修改保存楼盘相册
     */
    @RequiresPermissions("global:housesInfoImg:edit")
    @Log(title = "楼盘相册", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HousesInfoImg housesInfoImg) {
        return toAjax(housesInfoImgService.updateHousesInfoImg(housesInfoImg));
    }

    /**
     * 删除楼盘相册
     */
    @RequiresPermissions("global:housesInfoImg:remove")
    @Log(title = "楼盘相册", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(housesInfoImgService.deleteHousesInfoImgByIds(ids));
    }

}
