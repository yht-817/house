package com.ruoyi.project.global.imgBanner.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.global.imgBanner.mapper.ImgBannerMapper;
import com.ruoyi.project.global.imgBanner.domain.ImgBanner;
import com.ruoyi.project.global.imgBanner.service.IImgBannerService;
import com.ruoyi.common.support.Convert;

/**
 * Banner管理 服务层实现
 * 
 * @author ruoyi
 * @date 2019-02-13
 */
@Service
public class ImgBannerServiceImpl implements IImgBannerService 
{
	@Autowired
	private ImgBannerMapper imgBannerMapper;

	/**
     * 查询Banner管理信息
     * 
     * @param id Banner管理ID
     * @return Banner管理信息
     */
    @Override
	public ImgBanner selectImgBannerById(String id)
	{
	    return imgBannerMapper.selectImgBannerById(id);
	}
	
	/**
     * 查询Banner管理列表
     * 
     * @param imgBanner Banner管理信息
     * @return Banner管理集合
     */
	@Override
	public List<ImgBanner> selectImgBannerList(ImgBanner imgBanner)
	{
	    return imgBannerMapper.selectImgBannerList(imgBanner);
	}
	
    /**
     * 新增Banner管理
     * 
     * @param imgBanner Banner管理信息
     * @return 结果
     */
	@Override
	public int insertImgBanner(ImgBanner imgBanner)
	{
	    return imgBannerMapper.insertImgBanner(imgBanner);
	}
	
	/**
     * 修改Banner管理
     * 
     * @param imgBanner Banner管理信息
     * @return 结果
     */
	@Override
	public int updateImgBanner(ImgBanner imgBanner)
	{
	    return imgBannerMapper.updateImgBanner(imgBanner);
	}

	/**
     * 删除Banner管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteImgBannerByIds(String ids)
	{
		return imgBannerMapper.deleteImgBannerByIds(Convert.toStrArray(ids));
	}
	
}
