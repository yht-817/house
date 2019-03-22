package com.ruoyi.project.global.information.mapper;

import com.ruoyi.project.global.information.domain.Information;
import java.util.List;	

/**
 * 资讯 数据层
 * 
 * @author ruoyi
 * @date 2019-02-28
 */
public interface InformationMapper 
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
     * 删除资讯
     * 
     * @param informationNo 资讯ID
     * @return 结果
     */
	public int deleteInformationById(String informationNo);
	
	/**
     * 批量删除资讯
     * 
     * @param informationNos 需要删除的数据ID
     * @return 结果
     */
	public int deleteInformationByIds(String[] informationNos);
	
}