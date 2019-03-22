package com.ruoyi.project.global.collection.controller;

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
import com.ruoyi.project.global.collection.domain.Collections;
import com.ruoyi.project.global.collection.service.ICollectionService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 收藏列 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-03-06
 */
@Controller
@RequestMapping("/global/collection")
public class CollectionController extends BaseController
{
    private String prefix = "global/collection";
	
	@Autowired
	private ICollectionService collectionService;
	
	@RequiresPermissions("global:collection:view")
	@GetMapping()
	public String collection()
	{
	    return prefix + "/collection";
	}
	
	/**
	 * 查询收藏列列表
	 */
	@RequiresPermissions("global:collection:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Collections collection)
	{
		startPage();
        List<Collections> list = collectionService.selectCollectionList(collection);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出收藏列列表
	 */
	@RequiresPermissions("global:collection:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Collections collection)
    {
    	List<Collections> list = collectionService.selectCollectionList(collection);
        ExcelUtil<Collections> util = new ExcelUtil<Collections>(Collections.class);
        return util.exportExcel(list, "collection");
    }
	
	/**
	 * 新增收藏列
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存收藏列
	 */
	@RequiresPermissions("global:collection:add")
	@Log(title = "收藏列", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Collections collection)
	{		
		return toAjax(collectionService.insertCollection(collection));
	}

	/**
	 * 修改收藏列
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		Collections collection = collectionService.selectCollectionById(id);
		mmap.put("collection", collection);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存收藏列
	 */
	@RequiresPermissions("global:collection:edit")
	@Log(title = "收藏列", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Collections collection)
	{		
		return toAjax(collectionService.updateCollection(collection));
	}
	
	/**
	 * 删除收藏列
	 */
	@RequiresPermissions("global:collection:remove")
	@Log(title = "收藏列", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(collectionService.deleteCollectionByIds(ids));
	}
	
}
