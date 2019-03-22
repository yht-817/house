package com.ruoyi.project.global.housesInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.global.housesInfo.mapper.HousesInfoMapper;
import com.ruoyi.project.global.housesInfo.domain.HousesInfo;
import com.ruoyi.project.global.housesInfo.service.IHousesInfoService;
import com.ruoyi.common.support.Convert;

/**
 * 房屋 服务层实现
 *
 * @author ruoyi
 * @date 2019-02-19
 */
@Service
public class HousesInfoServiceImpl implements IHousesInfoService {
    @Autowired
    private HousesInfoMapper housesInfoMapper;

    /**
     * 查询房屋信息
     *
     * @param id 房屋ID
     * @return 房屋信息
     */
    @Override
    public HousesInfo selectHousesInfoById(String id) {
        return housesInfoMapper.selectHousesInfoById(id);
    }

    /**
     * 查询房屋列表
     *
     * @param housesInfo 房屋信息
     * @return 房屋集合
     */
    @Override
    public List<HousesInfo> selectHousesInfoList(HousesInfo housesInfo) {
        return housesInfoMapper.selectHousesInfoList(housesInfo);
    }

    /**
     * 新增房屋
     *
     * @param housesInfo 房屋信息
     * @return 结果
     */
    @Override
    public int insertHousesInfo(HousesInfo housesInfo) {
        return housesInfoMapper.insertHousesInfo(housesInfo);
    }

    /**
     * 修改房屋
     *
     * @param housesInfo 房屋信息
     * @return 结果
     */
    @Override
    public int updateHousesInfo(HousesInfo housesInfo) {
        return housesInfoMapper.updateHousesInfo(housesInfo);
    }

    /**
     * 删除房屋对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHousesInfoByIds(String ids) {
        return housesInfoMapper.deleteHousesInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 查询国家对应的币种
     *
     * @param country
     * @return
     */
    public String queryCurrency(String country) {
        return housesInfoMapper.queryCurrency(country);
    }

}
