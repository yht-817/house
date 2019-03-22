package com.ruoyi.project.global.serviceCity.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.global.serviceCity.mapper.ServiceCityMapper;
import com.ruoyi.project.global.serviceCity.domain.ServiceCity;
import com.ruoyi.project.global.serviceCity.service.IServiceCityService;
import com.ruoyi.common.support.Convert;

/**
 * 服务城市 服务层实现
 * 
 * @author ruoyi
 * @date 2019-02-14
 */
@Service
public class ServiceCityServiceImpl implements IServiceCityService 
{
	@Autowired
	private ServiceCityMapper serviceCityMapper;

	/**
     * 查询服务城市信息
     * 
     * @param scopeTwoNo 服务城市ID
     * @return 服务城市信息
     */
    @Override
	public ServiceCity selectServiceCityById(String scopeTwoNo)
	{
	    return serviceCityMapper.selectServiceCityById(scopeTwoNo);
	}
	
	/**
     * 查询服务城市列表
     * 
     * @param serviceCity 服务城市信息
     * @return 服务城市集合
     */
	@Override
	public List<ServiceCity> selectServiceCityList(ServiceCity serviceCity)
	{
	    return serviceCityMapper.selectServiceCityList(serviceCity);
	}
	
    /**
     * 新增服务城市
     * 
     * @param serviceCity 服务城市信息
     * @return 结果
     */
	@Override
	public int insertServiceCity(ServiceCity serviceCity)
	{
	    return serviceCityMapper.insertServiceCity(serviceCity);
	}
	
	/**
     * 修改服务城市
     * 
     * @param serviceCity 服务城市信息
     * @return 结果
     */
	@Override
	public int updateServiceCity(ServiceCity serviceCity)
	{
	    return serviceCityMapper.updateServiceCity(serviceCity);
	}

	/**
     * 删除服务城市对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteServiceCityByIds(String ids)
	{
		return serviceCityMapper.deleteServiceCityByIds(Convert.toStrArray(ids));
	}
	
}
