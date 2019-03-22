package com.ruoyi.project.global.subscribeInfo.service;

import com.ruoyi.project.global.subscribeInfo.domain.SubscribeInfo;
import java.util.List;

/**
 * 预约 服务层
 * 
 * @author ruoyi
 * @date 2019-02-20
 */
public interface ISubscribeInfoService 
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
     * 删除预约信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSubscribeInfoByIds(String ids);
	
}
