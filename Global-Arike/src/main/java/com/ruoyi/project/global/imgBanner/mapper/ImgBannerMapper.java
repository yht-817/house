package com.ruoyi.project.global.imgBanner.mapper;

import com.ruoyi.project.global.imgBanner.domain.ImgBanner;
import java.util.List;	

/**
 * Banner管理 数据层
 * 
 * @author ruoyi
 * @date 2019-02-13
 */
public interface ImgBannerMapper 
{
	/**
     * 查询Banner管理信息
     * 
     * @param id Banner管理ID
     * @return Banner管理信息
     */
	public ImgBanner selectImgBannerById(String id);
	
	/**
     * 查询Banner管理列表
     * 
     * @param imgBanner Banner管理信息
     * @return Banner管理集合
     */
	public List<ImgBanner> selectImgBannerList(ImgBanner imgBanner);
	
	/**
     * 新增Banner管理
     * 
     * @param imgBanner Banner管理信息
     * @return 结果
     */
	public int insertImgBanner(ImgBanner imgBanner);
	
	/**
     * 修改Banner管理
     * 
     * @param imgBanner Banner管理信息
     * @return 结果
     */
	public int updateImgBanner(ImgBanner imgBanner);
	
	/**
     * 删除Banner管理
     * 
     * @param id Banner管理ID
     * @return 结果
     */
	public int deleteImgBannerById(String id);
	
	/**
     * 批量删除Banner管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteImgBannerByIds(String[] ids);
	
}