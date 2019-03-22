package com.ruoyi.project.global.serviceCity.mapper;

import com.ruoyi.project.global.serviceCity.domain.ServiceCity;
import java.util.List;	

/**
 * 服务城市 数据层
 * 
 * @author ruoyi
 * @date 2019-02-14
 */
public interface ServiceCityMapper 
{
	/**
     * 查询服务城市信息
     * 
     * @param scopeTwoNo 服务城市ID
     * @return 服务城市信息
     */
	public ServiceCity selectServiceCityById(String scopeTwoNo);
	
	/**
     * 查询服务城市列表
     * 
     * @param serviceCity 服务城市信息
     * @return 服务城市集合
     */
	public List<ServiceCity> selectServiceCityList(ServiceCity serviceCity);
	
	/**
     * 新增服务城市
     * 
     * @param serviceCity 服务城市信息
     * @return 结果
     */
	public int insertServiceCity(ServiceCity serviceCity);
	
	/**
     * 修改服务城市
     * 
     * @param serviceCity 服务城市信息
     * @return 结果
     */
	public int updateServiceCity(ServiceCity serviceCity);
	
	/**
     * 删除服务城市
     * 
     * @param scopeTwoNo 服务城市ID
     * @return 结果
     */
	public int deleteServiceCityById(String scopeTwoNo);
	
	/**
     * 批量删除服务城市
     * 
     * @param scopeTwoNos 需要删除的数据ID
     * @return 结果
     */
	public int deleteServiceCityByIds(String[] scopeTwoNos);
	
}