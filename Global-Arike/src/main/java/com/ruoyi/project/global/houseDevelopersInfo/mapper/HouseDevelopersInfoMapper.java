package com.ruoyi.project.global.houseDevelopersInfo.mapper;

import com.ruoyi.project.global.houseDevelopersInfo.domain.HouseDevelopersInfo;
import java.util.List;	

/**
 * 开发商介绍 数据层
 * 
 * @author ruoyi
 * @date 2019-02-15
 */
public interface HouseDevelopersInfoMapper 
{
	/**
     * 查询开发商介绍信息
     * 
     * @param id 开发商介绍ID
     * @return 开发商介绍信息
     */
	public HouseDevelopersInfo selectHouseDevelopersInfoById(String id);
	
	/**
     * 查询开发商介绍列表
     * 
     * @param houseDevelopersInfo 开发商介绍信息
     * @return 开发商介绍集合
     */
	public List<HouseDevelopersInfo> selectHouseDevelopersInfoList(HouseDevelopersInfo houseDevelopersInfo);
	
	/**
     * 新增开发商介绍
     * 
     * @param houseDevelopersInfo 开发商介绍信息
     * @return 结果
     */
	public int insertHouseDevelopersInfo(HouseDevelopersInfo houseDevelopersInfo);
	
	/**
     * 修改开发商介绍
     * 
     * @param houseDevelopersInfo 开发商介绍信息
     * @return 结果
     */
	public int updateHouseDevelopersInfo(HouseDevelopersInfo houseDevelopersInfo);
	
	/**
     * 删除开发商介绍
     * 
     * @param id 开发商介绍ID
     * @return 结果
     */
	public int deleteHouseDevelopersInfoById(String id);
	
	/**
     * 批量删除开发商介绍
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHouseDevelopersInfoByIds(String[] ids);
	
}