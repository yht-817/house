package com.ruoyi.project.globalapp.main.mapper;

import com.ruoyi.project.globalapp.main.domain.Developers;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface HouseMapper {
    /**
     * 进行排序查询
     *
     * @param pageNo
     * @param pageSize
     * @param rank
     * @return
     */
    List<Map<String, Object>> queryHouseInfo(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize, @Param("rank") String rank);

    /**
     * 查询房屋类型
     *
     * @return
     */
    List<Map<String, Object>> queryHomeType();

    /**
     * 查询房屋的基本信息
     */
    Map<String, Object> quereyhouseInfo(@Param("homeCode") String homeCode);

    /**
     * 查询数组图片
     */
    List<String> quereyImgs(@Param("homeCode") String homeCode);

    /**
     * 户型介绍
     */
    List<Map<String, Object>> queryDoormodel(@Param("homeCode") String homeCode);

    /**
     * 查询开发商的资料
     */
    Developers quereyDevelopers(@Param("house_developers_no") String house_developers_no);

    /**
     * 关注房子
     *
     * @param id
     * @param userNo
     * @param homeCode
     * @param collectionType
     * @param date
     */
    @Insert("INSERT INTO global_collection_house VALUES (#{id},#{userNo},#{homeCode},#{collectionType},#{date})")
    int addCollection(@Param("id") String id, @Param("userNo") String userNo, @Param("homeCode") String homeCode, @Param("collectionType") String collectionType, @Param("date") Date date);

    /**
     * 查看关注房子的列表
     *
     * @param userNo
     * @param collectionType
     * @return
     */
    List<Map<String, Object>> quereyFocus(@Param("userNo") String userNo, @Param("collectionType") String collectionType);

    /**
     * 查询当前用户是否关注了
     *
     * @param userNo
     * @param homeCode
     * @return
     */
    @Select("SELECT COUNT(id) FROM global_collection_house WHERE user_no = #{userNo} AND collection_no = #{homeCode}")
    int quereyFocusRelation(@Param("userNo") String userNo, @Param("homeCode") String homeCode);

    /**
     * 取消当前用户关注房子
     *
     * @param homeCode
     * @param userNo
     * @return
     */
    @Delete("DELETE FROM global_collection_house WHERE user_no = #{userNo} AND collection_no = #{homeCode}")
    int deleteCollection(@Param("homeCode") String homeCode, @Param("userNo") String userNo);

    /**
     * 进行新房条件筛选查询
     *
     * @param startPrice
     * @param endPrice
     * @param startArea
     * @param endArea
     * @param houseType
     * @param bedroom
     * @param bathroom
     * @param pageNo
     * @param pageSize
     * @param rank
     * @return
     */
    List<Map<String, Object>> queryScreening(@Param("startPrice") int startPrice, @Param("endPrice") int endPrice, @Param("startArea") int startArea,
                                             @Param("endArea") int endArea, @Param("houseType") String houseType, @Param("bedroom") int bedroom, @Param("bathroom") int bathroom, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize, @Param("rank") String rank);

    /**
     * 查询当前房产经纪人的房屋信息
     *
     * @param focusUserNo
     * @return
     */
    List<Map<String, Object>> queryAgentHouse(@Param("focusUserNo") String focusUserNo);
}
