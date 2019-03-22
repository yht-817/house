package com.ruoyi.project.global.information.controller;

import java.util.Date;
import java.util.List;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
import com.ruoyi.project.global.information.domain.Information;
import com.ruoyi.project.global.information.service.IInformationService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 资讯 信息操作处理
 *
 * @author ruoyi
 * @date 2019-02-28
 */
@Controller
@RequestMapping("/global/information")
public class InformationController extends BaseController {
    private String prefix = "global/information";

    @Autowired
    private IInformationService informationService;

    @RequiresPermissions("global:information:view")
    @GetMapping()
    public String information() {
        return prefix + "/information";
    }

    /**
     * 查询资讯列表
     */
    @RequiresPermissions("global:information:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Information information) {
        startPage();
        List<Information> list = informationService.selectInformationList(information);
        return getDataTable(list);
    }


    /**
     * 导出资讯列表
     */
    @RequiresPermissions("global:information:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Information information) {
        List<Information> list = informationService.selectInformationList(information);
        ExcelUtil<Information> util = new ExcelUtil<Information>(Information.class);
        return util.exportExcel(list, "information");
    }

    /**
     * 新增资讯
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存资讯
     */
    @RequiresPermissions("global:information:add")
    @Log(title = "资讯", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Information information) {
        System.out.println(information.toString() + "---------");
        // 创建资讯编码
        information.setInformationNo(DataBaseTool.createNo("zx"));
        User shiroUser = (User) SecurityUtils.getSubject().getPrincipal();
        // 获取用户编码
        information.setUserNo(shiroUser.getUserName());
        // 获取第一张图片当作标题
        JSONArray obj = JSONObject.parseArray(information.getInformationContent());
        for (int i = 0; i < obj.size(); i++) {
            JSONObject jsonObject = (JSONObject) obj.get(i);
            if (!jsonObject.get("img").toString().equals("")) {
                information.setInformationBanner((String) jsonObject.get("img"));
                break;
            }
        }
        information.setCreateTime(new Date());
        return toAjax(informationService.insertInformation(information));
    }

    /**
     * 修改资讯
     */
    @GetMapping("/edit/{informationNo}")
    public String edit(@PathVariable("informationNo") String informationNo, ModelMap mmap) {
        Information information = informationService.selectInformationById(informationNo);
        mmap.put("information", information);
        return prefix + "/edit";
    }

    /**
     * 修改保存资讯
     */
    @RequiresPermissions("global:information:edit")
    @Log(title = "资讯", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Information information) {
        return toAjax(informationService.updateInformation(information));
    }

    /**
     * 删除资讯
     */
    @RequiresPermissions("global:information:remove")
    @Log(title = "资讯", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(informationService.deleteInformationByIds(ids));
    }

}
