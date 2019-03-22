package com.ruoyi.project.global.imgBanner.controller;

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
import com.ruoyi.project.global.imgBanner.domain.ImgBanner;
import com.ruoyi.project.global.imgBanner.service.IImgBannerService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * Banner管理 信息操作处理
 *
 * @author ruoyi
 * @date 2019-02-13
 */
@Controller
@RequestMapping("/global/imgBanner")
public class ImgBannerController extends BaseController {
    private String prefix = "global/imgBanner";

    @Autowired
    private IImgBannerService imgBannerService;

    @RequiresPermissions("global:imgBanner:view")
    @GetMapping()
    public String imgBanner() {
        return prefix + "/imgBanner";
    }

    /**
     * 查询Banner管理列表
     */
    @RequiresPermissions("global:imgBanner:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ImgBanner imgBanner) {
        startPage();
        List<ImgBanner> list = imgBannerService.selectImgBannerList(imgBanner);
        return getDataTable(list);
    }


    /**
     * 导出Banner管理列表
     */
    @RequiresPermissions("global:imgBanner:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ImgBanner imgBanner) {
        List<ImgBanner> list = imgBannerService.selectImgBannerList(imgBanner);
        ExcelUtil<ImgBanner> util = new ExcelUtil<ImgBanner>(ImgBanner.class);
        return util.exportExcel(list, "imgBanner");
    }

    /**
     * 新增Banner管理
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存Banner管理
     */
    @RequiresPermissions("global:imgBanner:add")
    @Log(title = "Banner管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ImgBanner imgBanner) {
        imgBanner.setId(DataBaseTool.createNo("BN"));
        return toAjax(imgBannerService.insertImgBanner(imgBanner));
    }

    /**
     * 修改Banner管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        ImgBanner imgBanner = imgBannerService.selectImgBannerById(id);
        mmap.put("imgBanner", imgBanner);
        return prefix + "/edit";
    }

    /**
     * 修改保存Banner管理
     */
    @RequiresPermissions("global:imgBanner:edit")
    @Log(title = "Banner管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ImgBanner imgBanner) {
        return toAjax(imgBannerService.updateImgBanner(imgBanner));
    }

    /**
     * 删除Banner管理
     */
    @RequiresPermissions("global:imgBanner:remove")
    @Log(title = "Banner管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(imgBannerService.deleteImgBannerByIds(ids));
    }

}
