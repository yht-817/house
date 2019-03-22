package com.ruoyi.project.global.comments.mapper;

import com.ruoyi.project.global.comments.domain.Comments;
import java.util.List;	

/**
 * 资讯评论 数据层
 * 
 * @author ruoyi
 * @date 2019-03-05
 */
public interface CommentsMapper 
{
	/**
     * 查询资讯评论信息
     * 
     * @param commentNo 资讯评论ID
     * @return 资讯评论信息
     */
	public Comments selectCommentsById(String commentNo);
	
	/**
     * 查询资讯评论列表
     * 
     * @param comments 资讯评论信息
     * @return 资讯评论集合
     */
	public List<Comments> selectCommentsList(Comments comments);
	
	/**
     * 新增资讯评论
     * 
     * @param comments 资讯评论信息
     * @return 结果
     */
	public int insertComments(Comments comments);
	
	/**
     * 修改资讯评论
     * 
     * @param comments 资讯评论信息
     * @return 结果
     */
	public int updateComments(Comments comments);
	
	/**
     * 删除资讯评论
     * 
     * @param commentNo 资讯评论ID
     * @return 结果
     */
	public int deleteCommentsById(String commentNo);
	
	/**
     * 批量删除资讯评论
     * 
     * @param commentNos 需要删除的数据ID
     * @return 结果
     */
	public int deleteCommentsByIds(String[] commentNos);
	
}