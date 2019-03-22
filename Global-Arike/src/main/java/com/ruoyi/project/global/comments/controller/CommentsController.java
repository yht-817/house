package com.ruoyi.project.global.comments.controller;

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
import com.ruoyi.project.global.comments.domain.Comments;
import com.ruoyi.project.global.comments.service.ICommentsService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 资讯评论 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-03-05
 */
@Controller
@RequestMapping("/global/comments")
public class CommentsController extends BaseController
{
    private String prefix = "global/comments";
	
	@Autowired
	private ICommentsService commentsService;
	
	@RequiresPermissions("global:comments:view")
	@GetMapping()
	public String comments()
	{
	    return prefix + "/comments";
	}
	
	/**
	 * 查询资讯评论列表
	 */
	@RequiresPermissions("global:comments:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Comments comments)
	{
		startPage();
        List<Comments> list = commentsService.selectCommentsList(comments);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出资讯评论列表
	 */
	@RequiresPermissions("global:comments:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Comments comments)
    {
    	List<Comments> list = commentsService.selectCommentsList(comments);
        ExcelUtil<Comments> util = new ExcelUtil<Comments>(Comments.class);
        return util.exportExcel(list, "comments");
    }
	
	/**
	 * 新增资讯评论
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存资讯评论
	 */
	@RequiresPermissions("global:comments:add")
	@Log(title = "资讯评论", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Comments comments)
	{		
		return toAjax(commentsService.insertComments(comments));
	}

	/**
	 * 修改资讯评论
	 */
	@GetMapping("/edit/{commentNo}")
	public String edit(@PathVariable("commentNo") String commentNo, ModelMap mmap)
	{
		Comments comments = commentsService.selectCommentsById(commentNo);
		mmap.put("comments", comments);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存资讯评论
	 */
	@RequiresPermissions("global:comments:edit")
	@Log(title = "资讯评论", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Comments comments)
	{		
		return toAjax(commentsService.updateComments(comments));
	}
	
	/**
	 * 删除资讯评论
	 */
	@RequiresPermissions("global:comments:remove")
	@Log(title = "资讯评论", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(commentsService.deleteCommentsByIds(ids));
	}
	
}
