package com.ruoyi.project.global.serviceCountry.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.global.serviceCountry.mapper.ServiceCountryMapper;
import com.ruoyi.project.global.serviceCountry.domain.ServiceCountry;
import com.ruoyi.project.global.serviceCountry.service.IServiceCountryService;
import com.ruoyi.common.support.Convert;

/**
 * 国家管理 服务层实现
 * 
 * @author ruoyi
 * @date 2019-02-13
 */
@Service
public class ServiceCountryServiceImpl implements IServiceCountryService 
{
	@Autowired
	private ServiceCountryMapper serviceCountryMapper;

	/**
     * 查询国家管理信息
     * 
     * @param scopeOneNo 国家管理ID
     * @return 国家管理信息
     */
    @Override
	public ServiceCountry selectServiceCountryById(String scopeOneNo)
	{
	    return serviceCountryMapper.selectServiceCountryById(scopeOneNo);
	}
	
	/**
     * 查询国家管理列表
     * 
     * @param serviceCountry 国家管理信息
     * @return 国家管理集合
     */
	@Override
	public List<ServiceCountry> selectServiceCountryList(ServiceCountry serviceCountry)
	{
	    return serviceCountryMapper.selectServiceCountryList(serviceCountry);
	}
	
    /**
     * 新增国家管理
     * 
     * @param serviceCountry 国家管理信息
     * @return 结果
     */
	@Override
	public int insertServiceCountry(ServiceCountry serviceCountry)
	{
	    return serviceCountryMapper.insertServiceCountry(serviceCountry);
	}
	
	/**
     * 修改国家管理
     * 
     * @param serviceCountry 国家管理信息
     * @return 结果
     */
	@Override
	public int updateServiceCountry(ServiceCountry serviceCountry)
	{
	    return serviceCountryMapper.updateServiceCountry(serviceCountry);
	}

	/**
     * 删除国家管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteServiceCountryByIds(String ids)
	{
		return serviceCountryMapper.deleteServiceCountryByIds(Convert.toStrArray(ids));
	}
	
}
