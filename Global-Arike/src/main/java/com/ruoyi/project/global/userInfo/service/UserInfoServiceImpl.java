package com.ruoyi.project.global.userInfo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.global.userInfo.mapper.UserInfoMapper;
import com.ruoyi.project.global.userInfo.domain.UserInfo;
import com.ruoyi.project.global.userInfo.service.IUserInfoService;
import com.ruoyi.common.support.Convert;

/**
 * 用户基础 服务层实现
 * 
 * @author ruoyi
 * @date 2019-02-12
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService 
{
	@Autowired
	private UserInfoMapper userInfoMapper;

	/**
     * 查询用户基础信息
     * 
     * @param userNo 用户基础ID
     * @return 用户基础信息
     */
    @Override
	public UserInfo selectUserInfoById(String userNo)
	{
	    return userInfoMapper.selectUserInfoById(userNo);
	}
	
	/**
     * 查询用户基础列表
     * 
     * @param userInfo 用户基础信息
     * @return 用户基础集合
     */
	@Override
	public List<UserInfo> selectUserInfoList(UserInfo userInfo)
	{
	    return userInfoMapper.selectUserInfoList(userInfo);
	}
	
    /**
     * 新增用户基础
     * 
     * @param userInfo 用户基础信息
     * @return 结果
     */
	@Override
	public int insertUserInfo(UserInfo userInfo)
	{
	    return userInfoMapper.insertUserInfo(userInfo);
	}
	
	/**
     * 修改用户基础
     * 
     * @param userInfo 用户基础信息
     * @return 结果
     */
	@Override
	public int updateUserInfo(UserInfo userInfo)
	{
	    return userInfoMapper.updateUserInfo(userInfo);
	}

	/**
     * 删除用户基础对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteUserInfoByIds(String ids)
	{
		return userInfoMapper.deleteUserInfoByIds(Convert.toStrArray(ids));
	}
	
}
