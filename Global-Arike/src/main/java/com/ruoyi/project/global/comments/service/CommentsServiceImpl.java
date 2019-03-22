package com.ruoyi.project.global.comments.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.global.comments.mapper.CommentsMapper;
import com.ruoyi.project.global.comments.domain.Comments;
import com.ruoyi.project.global.comments.service.ICommentsService;
import com.ruoyi.common.support.Convert;

/**
 * 资讯评论 服务层实现
 * 
 * @author ruoyi
 * @date 2019-03-05
 */
@Service
public class CommentsServiceImpl implements ICommentsService 
{
	@Autowired
	private CommentsMapper commentsMapper;

	/**
     * 查询资讯评论信息
     * 
     * @param commentNo 资讯评论ID
     * @return 资讯评论信息
     */
    @Override
	public Comments selectCommentsById(String commentNo)
	{
	    return commentsMapper.selectCommentsById(commentNo);
	}
	
	/**
     * 查询资讯评论列表
     * 
     * @param comments 资讯评论信息
     * @return 资讯评论集合
     */
	@Override
	public List<Comments> selectCommentsList(Comments comments)
	{
	    return commentsMapper.selectCommentsList(comments);
	}
	
    /**
     * 新增资讯评论
     * 
     * @param comments 资讯评论信息
     * @return 结果
     */
	@Override
	public int insertComments(Comments comments)
	{
	    return commentsMapper.insertComments(comments);
	}
	
	/**
     * 修改资讯评论
     * 
     * @param comments 资讯评论信息
     * @return 结果
     */
	@Override
	public int updateComments(Comments comments)
	{
	    return commentsMapper.updateComments(comments);
	}

	/**
     * 删除资讯评论对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCommentsByIds(String ids)
	{
		return commentsMapper.deleteCommentsByIds(Convert.toStrArray(ids));
	}
	
}
