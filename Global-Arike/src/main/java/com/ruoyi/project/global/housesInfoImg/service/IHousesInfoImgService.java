package com.ruoyi.project.global.housesInfoImg.service;

import com.ruoyi.project.global.housesInfoImg.domain.HousesInfoImg;
import java.util.List;

/**
 * 楼盘相册 服务层
 * 
 * @author ruoyi
 * @date 2019-02-20
 */
public interface IHousesInfoImgService 
{
	/**
     * 查询楼盘相册信息
     * 
     * @param id 楼盘相册ID
     * @return 楼盘相册信息
     */
	public HousesInfoImg selectHousesInfoImgById(Integer id);
	
	/**
     * 查询楼盘相册列表
     * 
     * @param housesInfoImg 楼盘相册信息
     * @return 楼盘相册集合
     */
	public List<HousesInfoImg> selectHousesInfoImgList(HousesInfoImg housesInfoImg);
	
	/**
     * 新增楼盘相册
     * 
     * @param housesInfoImg 楼盘相册信息
     * @return 结果
     */
	public int insertHousesInfoImg(HousesInfoImg housesInfoImg);
	
	/**
     * 修改楼盘相册
     * 
     * @param housesInfoImg 楼盘相册信息
     * @return 结果
     */
	public int updateHousesInfoImg(HousesInfoImg housesInfoImg);
		
	/**
     * 删除楼盘相册信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHousesInfoImgByIds(String ids);
	
}
