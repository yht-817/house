package com.ruoyi.project.global.information.service;

import com.ruoyi.project.global.information.domain.Information;
import java.util.List;

/**
 * 资讯 服务层
 * 
 * @author ruoyi
 * @date 2019-02-28
 */
public interface IInformationService 
{
	/**
     * 查询资讯信息
     * 
     * @param informationNo 资讯ID
     * @return 资讯信息
     */
	public Information selectInformationById(String informationNo);
	
	/**
     * 查询资讯列表
     * 
     * @param information 资讯信息
     * @return 资讯集合
     */
	public List<Information> selectInformationList(Information information);
	
	/**
     * 新增资讯
     * 
     * @param information 资讯信息
     * @return 结果
     */
	public int insertInformation(Information information);
	
	/**
     * 修改资讯
     * 
     * @param information 资讯信息
     * @return 结果
     */
	public int updateInformation(Information information);
		
	/**
     * 删除资讯信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteInformationByIds(String ids);
	
}
