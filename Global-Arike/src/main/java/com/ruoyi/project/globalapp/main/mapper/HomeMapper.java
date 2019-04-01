package com.ruoyi.project.globalapp.main.mapper;

import com.ruoyi.project.global.pioneer.domain.Pioneer;
import com.ruoyi.project.globalapp.main.domain.*;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface HomeMapper {
    /**
     * 获取Banner图片
     */
    List<ImgBanners> findHomeBanner();

    /**
     * 获取国家城市的结构
     */
    List<Country> findCity();

    /**
     * 插入当前预约数据
     *
     * @param subscribeInfos
     */
    int addSubscribeInfo(SubscribeInfos subscribeInfos);

    /**
     * 获取手机号码号号端位置
     */
    List<CountryMobilePrefixOutput> findPhoneCode();

    @Select("SELECT * FROM global_subscribe_info WHERE houses_code = #{housesCode} AND user_no = #{userNo}")
    SubscribeInfos findSubscribeInfoInfo(@Param("housesCode") String housesCode, @Param("userNo") String userNo);

    /**
     * 获取地产先锋的列表
     */
    List<PioneerList> queryPioneerList(@Param("pageSize") int pageSize, @Param("pageNo") int pageNo, @Param("city") String city);

    /**
     * 获取资讯列表
     */
    List<InformationList> queryInformationList(@Param("pageSize") int pageSize, @Param("pageNo") int pageNo);

    /**
     * 添加资讯的评论数
     */
    @Update("UPDATE global_information SET discuss_number = discuss_number + 1 WHERE information_no = #{informationNo}")
    void addGiveNo(@Param("informationNo") String informationNo);

    @Update("UPDATE global_information SET give_number = give_number + 1 WHERE information_no = #{informationNo}")
    void addLook(@Param("informationNo") String informationNo);

    /**
     * 获取资讯评论列表
     */
    List<GlobalComments> queryCommentsList(@Param("informationNo") String informationNo, @Param("pageSize") int pageSize, @Param("pageNo") int pageNo);

    @Select("SELECT COUNT(id) FROM global_collection WHERE user_no = #{userNo} AND business_no = #{informationNo} AND business_type = #{businessType}")
    int queryWhetherCollect(@Param("userNo") String userNo, @Param("informationNo") String informationNo, @Param("businessType") String businessType);

    @Delete("DELETE FROM global_collection WHERE business_no = #{businessNo}")
    int deleteCollect(@Param("businessNo") String businessNo);

    @Select("SELECT COUNT(id) FROM global_pioneer WHERE user_no = #{userNo}")
    int findPioneer(@Param("userNo") String userNo);

    int updatePioneer(Pioneer pioneer);

    @Select("SELECT COUNT(id) FROM global_pioneer_focus WHERE user_no = #{userNo} AND focus_user_no = #{focusUserNo}")
    int queryFocus(@Param("userNo") String userNo, @Param("focusUserNo") String focusUserNo);

    @Insert("INSERT INTO global_pioneer_focus VALUES (#{id}, #{userNo}, #{focusUserNo}, #{date})")
    int addFocusPioneer(@Param("id") String id, @Param("userNo") String userNo, @Param("focusUserNo") String focusUserNo, @Param("date") Date date);

    @Delete("DELETE FROM global_pioneer_focus WHERE user_no = #{userNo} AND focus_user_no = #{focusUserNo}")
    int deleteFocusPioneer(@Param("userNo") String userNo, @Param("focusUserNo") String focusUserNo);

    List<PioneerList> myFocusPioneer(@Param("userNo") String userNo);

    List<InformationList> queryCollectionInformationList(@Param("pageSize") int pageSize, @Param("pageNo") int pageNo, @Param("userNo") String userNo);

    @Select("SELECT concat(phone_code,phone_no) FROM global_user_info where user_no = #{userNo}")
    String queryPhone(@Param("userNo") String userNo);
}
