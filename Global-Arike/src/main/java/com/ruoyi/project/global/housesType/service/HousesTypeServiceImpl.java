package com.ruoyi.project.global.housesType.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.global.housesType.mapper.HousesTypeMapper;
import com.ruoyi.project.global.housesType.domain.HousesType;
import com.ruoyi.project.global.housesType.service.IHousesTypeService;
import com.ruoyi.common.support.Convert;

/**
 * 房屋类型 服务层实现
 * 
 * @author ruoyi
 * @date 2019-02-19
 */
@Service
public class HousesTypeServiceImpl implements IHousesTypeService 
{
	@Autowired
	private HousesTypeMapper housesTypeMapper;

	/**
     * 查询房屋类型信息
     * 
     * @param id 房屋类型ID
     * @return 房屋类型信息
     */
    @Override
	public HousesType selectHousesTypeById(Integer id)
	{
	    return housesTypeMapper.selectHousesTypeById(id);
	}
	
	/**
     * 查询房屋类型列表
     * 
     * @param housesType 房屋类型信息
     * @return 房屋类型集合
     */
	@Override
	public List<HousesType> selectHousesTypeList(HousesType housesType)
	{
	    return housesTypeMapper.selectHousesTypeList(housesType);
	}
	
    /**
     * 新增房屋类型
     * 
     * @param housesType 房屋类型信息
     * @return 结果
     */
	@Override
	public int insertHousesType(HousesType housesType)
	{
	    return housesTypeMapper.insertHousesType(housesType);
	}
	
	/**
     * 修改房屋类型
     * 
     * @param housesType 房屋类型信息
     * @return 结果
     */
	@Override
	public int updateHousesType(HousesType housesType)
	{
	    return housesTypeMapper.updateHousesType(housesType);
	}

	/**
     * 删除房屋类型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHousesTypeByIds(String ids)
	{
		return housesTypeMapper.deleteHousesTypeByIds(Convert.toStrArray(ids));
	}
	
}
