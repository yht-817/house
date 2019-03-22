package com.ruoyi.project.global.houseDevelopersInfo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.global.houseDevelopersInfo.mapper.HouseDevelopersInfoMapper;
import com.ruoyi.project.global.houseDevelopersInfo.domain.HouseDevelopersInfo;
import com.ruoyi.project.global.houseDevelopersInfo.service.IHouseDevelopersInfoService;
import com.ruoyi.common.support.Convert;

/**
 * 开发商介绍 服务层实现
 * 
 * @author ruoyi
 * @date 2019-02-15
 */
@Service
public class HouseDevelopersInfoServiceImpl implements IHouseDevelopersInfoService 
{
	@Autowired
	private HouseDevelopersInfoMapper houseDevelopersInfoMapper;

	/**
     * 查询开发商介绍信息
     * 
     * @param id 开发商介绍ID
     * @return 开发商介绍信息
     */
    @Override
	public HouseDevelopersInfo selectHouseDevelopersInfoById(String id)
	{
	    return houseDevelopersInfoMapper.selectHouseDevelopersInfoById(id);
	}
	
	/**
     * 查询开发商介绍列表
     * 
     * @param houseDevelopersInfo 开发商介绍信息
     * @return 开发商介绍集合
     */
	@Override
	public List<HouseDevelopersInfo> selectHouseDevelopersInfoList(HouseDevelopersInfo houseDevelopersInfo)
	{
	    return houseDevelopersInfoMapper.selectHouseDevelopersInfoList(houseDevelopersInfo);
	}
	
    /**
     * 新增开发商介绍
     * 
     * @param houseDevelopersInfo 开发商介绍信息
     * @return 结果
     */
	@Override
	public int insertHouseDevelopersInfo(HouseDevelopersInfo houseDevelopersInfo)
	{
	    return houseDevelopersInfoMapper.insertHouseDevelopersInfo(houseDevelopersInfo);
	}
	
	/**
     * 修改开发商介绍
     * 
     * @param houseDevelopersInfo 开发商介绍信息
     * @return 结果
     */
	@Override
	public int updateHouseDevelopersInfo(HouseDevelopersInfo houseDevelopersInfo)
	{
	    return houseDevelopersInfoMapper.updateHouseDevelopersInfo(houseDevelopersInfo);
	}

	/**
     * 删除开发商介绍对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHouseDevelopersInfoByIds(String ids)
	{
		return houseDevelopersInfoMapper.deleteHouseDevelopersInfoByIds(Convert.toStrArray(ids));
	}
	
}
