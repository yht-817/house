package com.ruoyi.project.global.pioneer.mapper;

import com.ruoyi.project.global.pioneer.domain.Pioneer;
import java.util.List;	

/**
 * 地产先锋 数据层
 * 
 * @author ruoyi
 * @date 2019-02-21
 */
public interface PioneerMapper 
{
	/**
     * 查询地产先锋信息
     * 
     * @param id 地产先锋ID
     * @return 地产先锋信息
     */
	public Pioneer selectPioneerById(Integer id);
	
	/**
     * 查询地产先锋列表
     * 
     * @param pioneer 地产先锋信息
     * @return 地产先锋集合
     */
	public List<Pioneer> selectPioneerList(Pioneer pioneer);
	
	/**
     * 新增地产先锋
     * 
     * @param pioneer 地产先锋信息
     * @return 结果
     */
	public int insertPioneer(Pioneer pioneer);
	
	/**
     * 修改地产先锋
     * 
     * @param pioneer 地产先锋信息
     * @return 结果
     */
	public int updatePioneer(Pioneer pioneer);
	
	/**
     * 删除地产先锋
     * 
     * @param id 地产先锋ID
     * @return 结果
     */
	public int deletePioneerById(Integer id);
	
	/**
     * 批量删除地产先锋
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePioneerByIds(String[] ids);
	
}