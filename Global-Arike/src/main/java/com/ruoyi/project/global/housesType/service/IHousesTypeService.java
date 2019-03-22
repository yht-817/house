package com.ruoyi.project.global.housesType.service;

import com.ruoyi.project.global.housesType.domain.HousesType;
import java.util.List;

/**
 * 房屋类型 服务层
 * 
 * @author ruoyi
 * @date 2019-02-19
 */
public interface IHousesTypeService 
{
	/**
     * 查询房屋类型信息
     * 
     * @param id 房屋类型ID
     * @return 房屋类型信息
     */
	public HousesType selectHousesTypeById(Integer id);
	
	/**
     * 查询房屋类型列表
     * 
     * @param housesType 房屋类型信息
     * @return 房屋类型集合
     */
	public List<HousesType> selectHousesTypeList(HousesType housesType);
	
	/**
     * 新增房屋类型
     * 
     * @param housesType 房屋类型信息
     * @return 结果
     */
	public int insertHousesType(HousesType housesType);
	
	/**
     * 修改房屋类型
     * 
     * @param housesType 房屋类型信息
     * @return 结果
     */
	public int updateHousesType(HousesType housesType);
		
	/**
     * 删除房屋类型信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHousesTypeByIds(String ids);
	
}
