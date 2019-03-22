package com.ruoyi.project.global.drawingInfo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.global.drawingInfo.mapper.DrawingInfoMapper;
import com.ruoyi.project.global.drawingInfo.domain.DrawingInfo;
import com.ruoyi.project.global.drawingInfo.service.IDrawingInfoService;
import com.ruoyi.common.support.Convert;

/**
 * 房屋介绍 服务层实现
 * 
 * @author ruoyi
 * @date 2019-02-20
 */
@Service
public class DrawingInfoServiceImpl implements IDrawingInfoService 
{
	@Autowired
	private DrawingInfoMapper drawingInfoMapper;

	/**
     * 查询房屋介绍信息
     * 
     * @param id 房屋介绍ID
     * @return 房屋介绍信息
     */
    @Override
	public DrawingInfo selectDrawingInfoById(String id)
	{
	    return drawingInfoMapper.selectDrawingInfoById(id);
	}
	
	/**
     * 查询房屋介绍列表
     * 
     * @param drawingInfo 房屋介绍信息
     * @return 房屋介绍集合
     */
	@Override
	public List<DrawingInfo> selectDrawingInfoList(DrawingInfo drawingInfo)
	{
	    return drawingInfoMapper.selectDrawingInfoList(drawingInfo);
	}
	
    /**
     * 新增房屋介绍
     * 
     * @param drawingInfo 房屋介绍信息
     * @return 结果
     */
	@Override
	public int insertDrawingInfo(DrawingInfo drawingInfo)
	{
	    return drawingInfoMapper.insertDrawingInfo(drawingInfo);
	}
	
	/**
     * 修改房屋介绍
     * 
     * @param drawingInfo 房屋介绍信息
     * @return 结果
     */
	@Override
	public int updateDrawingInfo(DrawingInfo drawingInfo)
	{
	    return drawingInfoMapper.updateDrawingInfo(drawingInfo);
	}

	/**
     * 删除房屋介绍对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteDrawingInfoByIds(String ids)
	{
		return drawingInfoMapper.deleteDrawingInfoByIds(Convert.toStrArray(ids));
	}
	
}
