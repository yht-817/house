package com.ruoyi.project.global.drawingInfo.service;

import com.ruoyi.project.global.drawingInfo.domain.DrawingInfo;
import java.util.List;

/**
 * 房屋介绍 服务层
 * 
 * @author ruoyi
 * @date 2019-02-20
 */
public interface IDrawingInfoService 
{
	/**
     * 查询房屋介绍信息
     * 
     * @param id 房屋介绍ID
     * @return 房屋介绍信息
     */
	public DrawingInfo selectDrawingInfoById(String id);
	
	/**
     * 查询房屋介绍列表
     * 
     * @param drawingInfo 房屋介绍信息
     * @return 房屋介绍集合
     */
	public List<DrawingInfo> selectDrawingInfoList(DrawingInfo drawingInfo);
	
	/**
     * 新增房屋介绍
     * 
     * @param drawingInfo 房屋介绍信息
     * @return 结果
     */
	public int insertDrawingInfo(DrawingInfo drawingInfo);
	
	/**
     * 修改房屋介绍
     * 
     * @param drawingInfo 房屋介绍信息
     * @return 结果
     */
	public int updateDrawingInfo(DrawingInfo drawingInfo);
		
	/**
     * 删除房屋介绍信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteDrawingInfoByIds(String ids);
	
}
