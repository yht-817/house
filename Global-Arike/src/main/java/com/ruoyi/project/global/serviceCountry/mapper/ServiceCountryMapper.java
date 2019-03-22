package com.ruoyi.project.global.serviceCountry.mapper;

import com.ruoyi.project.global.serviceCountry.domain.ServiceCountry;
import java.util.List;	

/**
 * 国家管理 数据层
 * 
 * @author ruoyi
 * @date 2019-02-13
 */
public interface ServiceCountryMapper 
{
	/**
     * 查询国家管理信息
     * 
     * @param scopeOneNo 国家管理ID
     * @return 国家管理信息
     */
	public ServiceCountry selectServiceCountryById(String scopeOneNo);
	
	/**
     * 查询国家管理列表
     * 
     * @param serviceCountry 国家管理信息
     * @return 国家管理集合
     */
	public List<ServiceCountry> selectServiceCountryList(ServiceCountry serviceCountry);
	
	/**
     * 新增国家管理
     * 
     * @param serviceCountry 国家管理信息
     * @return 结果
     */
	public int insertServiceCountry(ServiceCountry serviceCountry);
	
	/**
     * 修改国家管理
     * 
     * @param serviceCountry 国家管理信息
     * @return 结果
     */
	public int updateServiceCountry(ServiceCountry serviceCountry);
	
	/**
     * 删除国家管理
     * 
     * @param scopeOneNo 国家管理ID
     * @return 结果
     */
	public int deleteServiceCountryById(String scopeOneNo);
	
	/**
     * 批量删除国家管理
     * 
     * @param scopeOneNos 需要删除的数据ID
     * @return 结果
     */
	public int deleteServiceCountryByIds(String[] scopeOneNos);
	
}