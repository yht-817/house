package com.ruoyi.project.global.userAuths.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.global.userAuths.mapper.UserAuthsMapper;
import com.ruoyi.project.global.userAuths.domain.UserAuths;
import com.ruoyi.project.global.userAuths.service.IUserAuthsService;
import com.ruoyi.common.support.Convert;

/**
 * 用户认证 服务层实现
 * 
 * @author ruoyi
 * @date 2019-02-12
 */
@Service
public class UserAuthsServiceImpl implements IUserAuthsService 
{
	@Autowired
	private UserAuthsMapper userAuthsMapper;

	/**
     * 查询用户认证信息
     * 
     * @param userNo 用户认证ID
     * @return 用户认证信息
     */
    @Override
	public UserAuths selectUserAuthsById(String userNo)
	{
	    return userAuthsMapper.selectUserAuthsById(userNo);
	}
	
	/**
     * 查询用户认证列表
     * 
     * @param userAuths 用户认证信息
     * @return 用户认证集合
     */
	@Override
	public List<UserAuths> selectUserAuthsList(UserAuths userAuths)
	{
	    return userAuthsMapper.selectUserAuthsList(userAuths);
	}
	
    /**
     * 新增用户认证
     * 
     * @param userAuths 用户认证信息
     * @return 结果
     */
	@Override
	public int insertUserAuths(UserAuths userAuths)
	{
	    return userAuthsMapper.insertUserAuths(userAuths);
	}
	
	/**
     * 修改用户认证
     * 
     * @param userAuths 用户认证信息
     * @return 结果
     */
	@Override
	public int updateUserAuths(UserAuths userAuths)
	{
	    return userAuthsMapper.updateUserAuths(userAuths);
	}

	/**
     * 删除用户认证对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteUserAuthsByIds(String ids)
	{
		return userAuthsMapper.deleteUserAuthsByIds(Convert.toStrArray(ids));
	}
	
}
