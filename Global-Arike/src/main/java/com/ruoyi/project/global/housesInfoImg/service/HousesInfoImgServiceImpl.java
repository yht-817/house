package com.ruoyi.project.global.housesInfoImg.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.global.housesInfoImg.mapper.HousesInfoImgMapper;
import com.ruoyi.project.global.housesInfoImg.domain.HousesInfoImg;
import com.ruoyi.project.global.housesInfoImg.service.IHousesInfoImgService;
import com.ruoyi.common.support.Convert;

/**
 * 楼盘相册 服务层实现
 * 
 * @author ruoyi
 * @date 2019-02-20
 */
@Service
public class HousesInfoImgServiceImpl implements IHousesInfoImgService 
{
	@Autowired
	private HousesInfoImgMapper housesInfoImgMapper;

	/**
     * 查询楼盘相册信息
     * 
     * @param id 楼盘相册ID
     * @return 楼盘相册信息
     */
    @Override
	public HousesInfoImg selectHousesInfoImgById(Integer id)
	{
	    return housesInfoImgMapper.selectHousesInfoImgById(id);
	}
	
	/**
     * 查询楼盘相册列表
     * 
     * @param housesInfoImg 楼盘相册信息
     * @return 楼盘相册集合
     */
	@Override
	public List<HousesInfoImg> selectHousesInfoImgList(HousesInfoImg housesInfoImg)
	{
	    return housesInfoImgMapper.selectHousesInfoImgList(housesInfoImg);
	}
	
    /**
     * 新增楼盘相册
     * 
     * @param housesInfoImg 楼盘相册信息
     * @return 结果
     */
	@Override
	public int insertHousesInfoImg(HousesInfoImg housesInfoImg)
	{
	    return housesInfoImgMapper.insertHousesInfoImg(housesInfoImg);
	}
	
	/**
     * 修改楼盘相册
     * 
     * @param housesInfoImg 楼盘相册信息
     * @return 结果
     */
	@Override
	public int updateHousesInfoImg(HousesInfoImg housesInfoImg)
	{
	    return housesInfoImgMapper.updateHousesInfoImg(housesInfoImg);
	}

	/**
     * 删除楼盘相册对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHousesInfoImgByIds(String ids)
	{
		return housesInfoImgMapper.deleteHousesInfoImgByIds(Convert.toStrArray(ids));
	}
	
}
