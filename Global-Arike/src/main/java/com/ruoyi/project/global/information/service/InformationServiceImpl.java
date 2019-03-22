package com.ruoyi.project.global.information.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.global.information.mapper.InformationMapper;
import com.ruoyi.project.global.information.domain.Information;
import com.ruoyi.project.global.information.service.IInformationService;
import com.ruoyi.common.support.Convert;

/**
 * 资讯 服务层实现
 * 
 * @author ruoyi
 * @date 2019-02-28
 */
@Service
public class InformationServiceImpl implements IInformationService 
{
	@Autowired
	private InformationMapper informationMapper;

	/**
     * 查询资讯信息
     * 
     * @param informationNo 资讯ID
     * @return 资讯信息
     */
    @Override
	public Information selectInformationById(String informationNo)
	{
	    return informationMapper.selectInformationById(informationNo);
	}
	
	/**
     * 查询资讯列表
     * 
     * @param information 资讯信息
     * @return 资讯集合
     */
	@Override
	public List<Information> selectInformationList(Information information)
	{
	    return informationMapper.selectInformationList(information);
	}
	
    /**
     * 新增资讯
     * 
     * @param information 资讯信息
     * @return 结果
     */
	@Override
	public int insertInformation(Information information)
	{
	    return informationMapper.insertInformation(information);
	}
	
	/**
     * 修改资讯
     * 
     * @param information 资讯信息
     * @return 结果
     */
	@Override
	public int updateInformation(Information information)
	{
	    return informationMapper.updateInformation(information);
	}

	/**
     * 删除资讯对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteInformationByIds(String ids)
	{
		return informationMapper.deleteInformationByIds(Convert.toStrArray(ids));
	}
	
}
