package com.ruoyi.project.global.userInfo.controller;

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
import com.ruoyi.project.global.userInfo.domain.UserInfo;
import com.ruoyi.project.global.userInfo.service.IUserInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 用户基础 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-02-12
 */
@Controller
@RequestMapping("/global/userInfo")
public class UserInfoController extends BaseController
{
    private String prefix = "global/userInfo";
	
	@Autowired
	private IUserInfoService userInfoService;
	
	@RequiresPermissions("global:userInfo:view")
	@GetMapping()
	public String userInfo()
	{
	    return prefix + "/userInfo";
	}
	
	/**
	 * 查询用户基础列表
	 */
	@RequiresPermissions("global:userInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(UserInfo userInfo)
	{
		startPage();
        List<UserInfo> list = userInfoService.selectUserInfoList(userInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出用户基础列表
	 */
	@RequiresPermissions("global:userInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserInfo userInfo)
    {
    	List<UserInfo> list = userInfoService.selectUserInfoList(userInfo);
        ExcelUtil<UserInfo> util = new ExcelUtil<UserInfo>(UserInfo.class);
        return util.exportExcel(list, "userInfo");
    }
	
	/**
	 * 新增用户基础
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户基础
	 */
	@RequiresPermissions("global:userInfo:add")
	@Log(title = "用户基础", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(UserInfo userInfo)
	{		
		return toAjax(userInfoService.insertUserInfo(userInfo));
	}

	/**
	 * 修改用户基础
	 */
	@GetMapping("/edit/{userNo}")
	public String edit(@PathVariable("userNo") String userNo, ModelMap mmap)
	{
		UserInfo userInfo = userInfoService.selectUserInfoById(userNo);
		mmap.put("userInfo", userInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户基础
	 */
	@RequiresPermissions("global:userInfo:edit")
	@Log(title = "用户基础", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(UserInfo userInfo)
	{		
		return toAjax(userInfoService.updateUserInfo(userInfo));
	}
	
	/**
	 * 删除用户基础
	 */
	@RequiresPermissions("global:userInfo:remove")
	@Log(title = "用户基础", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(userInfoService.deleteUserInfoByIds(ids));
	}
	
}
