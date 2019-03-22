package com.ruoyi.project.global.collection.mapper;

import com.ruoyi.project.global.collection.domain.Collections;
import java.util.List;	

/**
 * 收藏列 数据层
 * 
 * @author ruoyi
 * @date 2019-03-06
 */
public interface CollectionMapper 
{
	/**
     * 查询收藏列信息
     * 
     * @param id 收藏列ID
     * @return 收藏列信息
     */
	public Collections selectCollectionById(String id);
	
	/**
     * 查询收藏列列表
     * 
     * @param collection 收藏列信息
     * @return 收藏列集合
     */
	public List<Collections> selectCollectionList(Collections collection);
	
	/**
     * 新增收藏列
     * 
     * @param collection 收藏列信息
     * @return 结果
     */
	public int insertCollection(Collections collection);
	
	/**
     * 修改收藏列
     * 
     * @param collection 收藏列信息
     * @return 结果
     */
	public int updateCollection(Collections collection);
	
	/**
     * 删除收藏列
     * 
     * @param id 收藏列ID
     * @return 结果
     */
	public int deleteCollectionById(String id);
	
	/**
     * 批量删除收藏列
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCollectionByIds(String[] ids);
	
}