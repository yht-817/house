package com.ruoyi.project.global.userAuths.controller;

import java.util.List;

import com.ruoyi.project.global.userAuths.domain.UserInfoGet;
import com.ruoyi.project.global.userInfo.domain.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
import com.ruoyi.project.global.userAuths.domain.UserAuths;
import com.ruoyi.project.global.userAuths.service.IUserAuthsService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 用户认证 信息操作处理
 *
 * @author ruoyi
 * @date 2019-02-12
 */
@Controller
@RequestMapping("/global/userAuths")
public class UserAuthsController extends BaseController {
    private String prefix = "global/userAuths";

    @Autowired
    private IUserAuthsService userAuthsService;

    @RequiresPermissions("global:userAuths:view")
    @GetMapping()
    public String userAuths() {
        return prefix + "/userAuths";
    }

    /**
     * 查询用户认证列表
     */
    @RequiresPermissions("global:userAuths:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserAuths userAuths) {
        startPage();
        List<UserAuths> list = userAuthsService.selectUserAuthsList(userAuths);
        return getDataTable(list);
    }


    /**
     * 导出用户认证列表
     */
    @RequiresPermissions("global:userAuths:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserAuths userAuths) {
        List<UserAuths> list = userAuthsService.selectUserAuthsList(userAuths);
        ExcelUtil<UserAuths> util = new ExcelUtil<UserAuths>(UserAuths.class);
        return util.exportExcel(list, "userAuths");
    }

    /**
     * 新增用户认证
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存用户认证
     */
    @RequiresPermissions("global:userAuths:add")
    @Log(title = "用户认证", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UserAuths userAuths) {
        return toAjax(userAuthsService.insertUserAuths(userAuths));
    }

    /**
     * 修改用户认证
     */
    @GetMapping("/edit/{userNo}")
    public String edit(@PathVariable("userNo") String userNo, ModelMap mmap) {
        UserAuths userAuths = userAuthsService.selectUserAuthsById(userNo);
        mmap.put("userAuths", userAuths);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户认证
     */
    @RequiresPermissions("global:userAuths:edit")
    @Log(title = "用户认证", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserAuths userAuths) {
        return toAjax(userAuthsService.updateUserAuths(userAuths));
    }

    /**
     * 删除用户认证
     */
    @RequiresPermissions("global:userAuths:remove")
    @Log(title = "用户认证", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(userAuthsService.deleteUserAuthsByIds(ids));
    }

}
