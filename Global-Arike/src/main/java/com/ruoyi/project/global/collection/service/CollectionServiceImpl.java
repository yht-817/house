package com.ruoyi.project.global.collection.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.global.collection.mapper.CollectionMapper;
import com.ruoyi.project.global.collection.domain.Collections;
import com.ruoyi.common.support.Convert;

/**
 * 收藏列 服务层实现
 * 
 * @author ruoyi
 * @date 2019-03-06
 */
@Service
public class CollectionServiceImpl implements ICollectionService 
{
	@Autowired
	private CollectionMapper collectionMapper;

	/**
     * 查询收藏列信息
     * 
     * @param id 收藏列ID
     * @return 收藏列信息
     */
    @Override
	public Collections selectCollectionById(String id)
	{
	    return collectionMapper.selectCollectionById(id);
	}
	
	/**
     * 查询收藏列列表
     * 
     * @param collection 收藏列信息
     * @return 收藏列集合
     */
	@Override
	public List<Collections> selectCollectionList(Collections collection)
	{
	    return collectionMapper.selectCollectionList(collection);
	}
	
    /**
     * 新增收藏列
     * 
     * @param collection 收藏列信息
     * @return 结果
     */
	@Override
	public int insertCollection(Collections collection)
	{
	    return collectionMapper.insertCollection(collection);
	}
	
	/**
     * 修改收藏列
     * 
     * @param collection 收藏列信息
     * @return 结果
     */
	@Override
	public int updateCollection(Collections collection)
	{
	    return collectionMapper.updateCollection(collection);
	}

	/**
     * 删除收藏列对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCollectionByIds(String ids)
	{
		return collectionMapper.deleteCollectionByIds(Convert.toStrArray(ids));
	}
	
}
