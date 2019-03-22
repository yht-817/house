package com.ruoyi.project.global.userInfo.service;

import com.ruoyi.project.global.userInfo.domain.UserInfo;
import java.util.List;

/**
 * 用户基础 服务层
 * 
 * @author ruoyi
 * @date 2019-02-12
 */
public interface IUserInfoService 
{
	/**
     * 查询用户基础信息
     * 
     * @param userNo 用户基础ID
     * @return 用户基础信息
     */
	public UserInfo selectUserInfoById(String userNo);
	
	/**
     * 查询用户基础列表
     * 
     * @param userInfo 用户基础信息
     * @return 用户基础集合
     */
	public List<UserInfo> selectUserInfoList(UserInfo userInfo);
	
	/**
     * 新增用户基础
     * 
     * @param userInfo 用户基础信息
     * @return 结果
     */
	public int insertUserInfo(UserInfo userInfo);
	
	/**
     * 修改用户基础
     * 
     * @param userInfo 用户基础信息
     * @return 结果
     */
	public int updateUserInfo(UserInfo userInfo);
		
	/**
     * 删除用户基础信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteUserInfoByIds(String ids);
	
}
