package com.ruoyi.project.global.subscribeInfo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.global.subscribeInfo.mapper.SubscribeInfoMapper;
import com.ruoyi.project.global.subscribeInfo.domain.SubscribeInfo;
import com.ruoyi.project.global.subscribeInfo.service.ISubscribeInfoService;
import com.ruoyi.common.support.Convert;

/**
 * 预约 服务层实现
 * 
 * @author ruoyi
 * @date 2019-02-20
 */
@Service
public class SubscribeInfoServiceImpl implements ISubscribeInfoService 
{
	@Autowired
	private SubscribeInfoMapper subscribeInfoMapper;

	/**
     * 查询预约信息
     * 
     * @param id 预约ID
     * @return 预约信息
     */
    @Override
	public SubscribeInfo selectSubscribeInfoById(Integer id)
	{
	    return subscribeInfoMapper.selectSubscribeInfoById(id);
	}
	
	/**
     * 查询预约列表
     * 
     * @param subscribeInfo 预约信息
     * @return 预约集合
     */
	@Override
	public List<SubscribeInfo> selectSubscribeInfoList(SubscribeInfo subscribeInfo)
	{
	    return subscribeInfoMapper.selectSubscribeInfoList(subscribeInfo);
	}
	
    /**
     * 新增预约
     * 
     * @param subscribeInfo 预约信息
     * @return 结果
     */
	@Override
	public int insertSubscribeInfo(SubscribeInfo subscribeInfo)
	{
	    return subscribeInfoMapper.insertSubscribeInfo(subscribeInfo);
	}
	
	/**
     * 修改预约
     * 
     * @param subscribeInfo 预约信息
     * @return 结果
     */
	@Override
	public int updateSubscribeInfo(SubscribeInfo subscribeInfo)
	{
	    return subscribeInfoMapper.updateSubscribeInfo(subscribeInfo);
	}

	/**
     * 删除预约对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSubscribeInfoByIds(String ids)
	{
		return subscribeInfoMapper.deleteSubscribeInfoByIds(Convert.toStrArray(ids));
	}
	
}
