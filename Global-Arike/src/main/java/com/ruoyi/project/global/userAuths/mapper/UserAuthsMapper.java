package com.ruoyi.project.global.userAuths.mapper;

import com.ruoyi.project.global.userAuths.domain.UserAuths;
import java.util.List;	

/**
 * 用户认证 数据层
 * 
 * @author ruoyi
 * @date 2019-02-12
 */
public interface UserAuthsMapper 
{
	/**
     * 查询用户认证信息
     * 
     * @param userNo 用户认证ID
     * @return 用户认证信息
     */
	public UserAuths selectUserAuthsById(String userNo);
	
	/**
     * 查询用户认证列表
     * 
     * @param userAuths 用户认证信息
     * @return 用户认证集合
     */
	public List<UserAuths> selectUserAuthsList(UserAuths userAuths);
	
	/**
     * 新增用户认证
     * 
     * @param userAuths 用户认证信息
     * @return 结果
     */
	public int insertUserAuths(UserAuths userAuths);
	
	/**
     * 修改用户认证
     * 
     * @param userAuths 用户认证信息
     * @return 结果
     */
	public int updateUserAuths(UserAuths userAuths);
	
	/**
     * 删除用户认证
     * 
     * @param userNo 用户认证ID
     * @return 结果
     */
	public int deleteUserAuthsById(String userNo);
	
	/**
     * 批量删除用户认证
     * 
     * @param userNos 需要删除的数据ID
     * @return 结果
     */
	public int deleteUserAuthsByIds(String[] userNos);
	
}