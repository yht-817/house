package com.ruoyi.project.global.subscribeInfo.controller;

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
import com.ruoyi.project.global.subscribeInfo.domain.SubscribeInfo;
import com.ruoyi.project.global.subscribeInfo.service.ISubscribeInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 预约 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-02-20
 */
@Controller
@RequestMapping("/global/subscribeInfo")
public class SubscribeInfoController extends BaseController
{
    private String prefix = "global/subscribeInfo";
	
	@Autowired
	private ISubscribeInfoService subscribeInfoService;
	
	@RequiresPermissions("global:subscribeInfo:view")
	@GetMapping()
	public String subscribeInfo()
	{
	    return prefix + "/subscribeInfo";
	}
	
	/**
	 * 查询预约列表
	 */
	@RequiresPermissions("global:subscribeInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SubscribeInfo subscribeInfo)
	{
		startPage();
        List<SubscribeInfo> list = subscribeInfoService.selectSubscribeInfoList(subscribeInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出预约列表
	 */
	@RequiresPermissions("global:subscribeInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SubscribeInfo subscribeInfo)
    {
    	List<SubscribeInfo> list = subscribeInfoService.selectSubscribeInfoList(subscribeInfo);
        ExcelUtil<SubscribeInfo> util = new ExcelUtil<SubscribeInfo>(SubscribeInfo.class);
        return util.exportExcel(list, "subscribeInfo");
    }
	
	/**
	 * 新增预约
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存预约
	 */
	@RequiresPermissions("global:subscribeInfo:add")
	@Log(title = "预约", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SubscribeInfo subscribeInfo)
	{		
		return toAjax(subscribeInfoService.insertSubscribeInfo(subscribeInfo));
	}

	/**
	 * 修改预约
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		SubscribeInfo subscribeInfo = subscribeInfoService.selectSubscribeInfoById(id);
		mmap.put("subscribeInfo", subscribeInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存预约
	 */
	@RequiresPermissions("global:subscribeInfo:edit")
	@Log(title = "预约", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SubscribeInfo subscribeInfo)
	{		
		return toAjax(subscribeInfoService.updateSubscribeInfo(subscribeInfo));
	}
	
	/**
	 * 删除预约
	 */
	@RequiresPermissions("global:subscribeInfo:remove")
	@Log(title = "预约", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(subscribeInfoService.deleteSubscribeInfoByIds(ids));
	}
	
}
