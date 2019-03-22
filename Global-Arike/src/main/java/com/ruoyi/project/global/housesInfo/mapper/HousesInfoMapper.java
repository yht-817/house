package com.ruoyi.project.global.housesInfo.mapper;

import com.ruoyi.project.global.housesInfo.domain.HousesInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 房屋 数据层
 *
 * @author ruoyi
 * @date 2019-02-19
 */
public interface HousesInfoMapper {
    /**
     * 查询房屋信息
     *
     * @param id 房屋ID
     * @return 房屋信息
     */
    public HousesInfo selectHousesInfoById(String id);

    /**
     * 查询房屋列表
     *
     * @param housesInfo 房屋信息
     * @return 房屋集合
     */
    public List<HousesInfo> selectHousesInfoList(HousesInfo housesInfo);

    /**
     * 新增房屋
     *
     * @param housesInfo 房屋信息
     * @return 结果
     */
    public int insertHousesInfo(HousesInfo housesInfo);

    /**
     * 修改房屋
     *
     * @param housesInfo 房屋信息
     * @return 结果
     */
    public int updateHousesInfo(HousesInfo housesInfo);

    /**
     * 删除房屋
     *
     * @param id 房屋ID
     * @return 结果
     */
    public int deleteHousesInfoById(String id);

    /**
     * 批量删除房屋
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHousesInfoByIds(String[] ids);

    @Select("SELECT currency FROM global_service_country WHERE scope_one_name = #{country}")
    String queryCurrency(@Param("country") String country);
}