package com.ruoyi.project.global.subscribeInfo.mapper;

import com.ruoyi.project.global.subscribeInfo.domain.SubscribeInfo;
import java.util.List;	

/**
 * 预约 数据层
 * 
 * @author ruoyi
 * @date 2019-02-20
 */
public interface SubscribeInfoMapper 
{
	/**
     * 查询预约信息
     * 
     * @param id 预约ID
     * @return 预约信息
     */
	public SubscribeInfo selectSubscribeInfoById(Integer id);
	
	/**
     * 查询预约列表
     * 
     * @param subscribeInfo 预约信息
     * @return 预约集合
     */
	public List<SubscribeInfo> selectSubscribeInfoList(SubscribeInfo subscribeInfo);
	
	/**
     * 新增预约
     * 
     * @param subscribeInfo 预约信息
     * @return 结果
     */
	public int insertSubscribeInfo(SubscribeInfo subscribeInfo);
	
	/**
     * 修改预约
     * 
     * @param subscribeInfo 预约信息
     * @return 结果
     */
	public int updateSubscribeInfo(SubscribeInfo subscribeInfo);
	
	/**
     * 删除预约
     * 
     * @param id 预约ID
     * @return 结果
     */
	public int deleteSubscribeInfoById(Integer id);
	
	/**
     * 批量删除预约
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSubscribeInfoByIds(String[] ids);
	
}