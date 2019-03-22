package com.ruoyi.project.globalapp.main.service;

import com.ruoyi.project.global.collection.domain.Collections;
import com.ruoyi.project.global.collection.mapper.CollectionMapper;
import com.ruoyi.project.global.comments.domain.Comments;
import com.ruoyi.project.global.comments.mapper.CommentsMapper;
import com.ruoyi.project.global.information.domain.Information;
import com.ruoyi.project.global.information.mapper.InformationMapper;
import com.ruoyi.project.global.pioneer.domain.Pioneer;
import com.ruoyi.project.globalapp.main.domain.*;
import com.ruoyi.project.globalapp.main.mapper.HomeMapper;
import com.ruoyi.project.tool.build.DataBaseTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HomeServiceImpl implements IHomeService {
    @Autowired
    private HomeMapper homeMapper;

    @Autowired
    private InformationMapper informationMapper;

    @Autowired
    private CommentsMapper commentsMapper;

    @Autowired
    private CollectionMapper collectionMapper;

    /**
     * 获取Banner广告图片
     *
     * @return
     */
    public List<ImgBanners> findHomeBanner() {
        List<ImgBanners> imgBanners = homeMapper.findHomeBanner();
        if (imgBanners.size() > 0) {
            return imgBanners;
        }
        return null;
    }

    /**
     * 获取国家对应城市的关系结构
     *
     * @return
     */
    public List<Country> findCity() {
        List<Country> country = homeMapper.findCity();
        if (country.size() > 0) {
            return country;
        }
        return null;
    }

    public boolean addSubscribeInfo(SubscribeInfos subscribeInfos) {
        int add = homeMapper.addSubscribeInfo(subscribeInfos);
        if (add > 0) {
            return true;
        }
        return false;
    }

    /**
     * 获取手机号码号段
     *
     * @return
     */
    public List<CountryMobilePrefixOutput> findPhoneCode() {
        return homeMapper.findPhoneCode();
    }

    /**
     * 查询当前是否预约信息
     *
     * @param housesCode
     * @param userNo
     * @return
     */
    public SubscribeInfos findSubscribeInfoInfo(String housesCode, String userNo) {
        return homeMapper.findSubscribeInfoInfo(housesCode, userNo);
    }

    /**
     * 查看地产先锋列表
     *
     * @param pageSize
     * @param pageNo
     * @param city
     * @return
     */
    public List<PioneerList> queryPioneerList(int pageSize, int pageNo, String city) {
        return homeMapper.queryPioneerList(pageSize, pageNo, city);
    }

    /**
     * 获取资讯的列表
     *
     * @param pageSize
     * @param pageNo
     * @return
     */
    public List<InformationList> queryInformationList(int pageSize, int pageNo) {
        return homeMapper.queryInformationList(pageSize, pageNo);
    }

    /**
     * 查看资讯详情
     */
    public Information informationDetails(String informationNo) {
        // 获取资讯详情
        return informationMapper.selectInformationById(informationNo);
    }

    /**
     * 添加资讯的评论
     */
    public boolean addComments(Comments comments) {
        int i = commentsMapper.insertComments(comments);
        if (i > 0) {
            return true;
        }
        return false;
    }

    /**
     * 增加评论数
     */
    public void addGiveNo(String informationNo) {
        homeMapper.addGiveNo(informationNo);
    }

    /**
     * 增加查看数量
     */
    public void addLook(String informationNo) {
        homeMapper.addLook(informationNo);
    }

    /**
     * 获取评论列表
     */
    public List<GlobalComments> queryCommentsList(String informationNo, int pageSize, int pageNo) {
        return homeMapper.queryCommentsList(informationNo, pageSize, pageNo);
    }

    /**
     * 收藏
     */
    public boolean addBusiness(Collections collection) {
        int i = collectionMapper.insertCollection(collection);
        if (i > 0) {
            return true;
        }
        return false;
    }

    /**
     * 查询当前用户是否收藏过
     */
    public boolean queryWhetherCollect(String userNo, String informationNo, String businessType) {
        int data = homeMapper.queryWhetherCollect(userNo, informationNo, businessType);
        if (data > 0) {
            return true;
        }
        return false;
    }

    /**
     * 删除当前的收藏
     */
    public boolean deleteCollect(String businessNo) {
        int data = homeMapper.deleteCollect(businessNo);
        if (data > 0) {
            return true;
        }
        return false;
    }

    /**
     * 查询是否是牛人
     */
    public boolean findPioneer(String userNo) {
        int existdata = homeMapper.findPioneer(userNo);
        if (existdata > 0) {
            return true;
        }
        return false;
    }

    /**
     * 修改房产经纪的信息
     */
    public int updatePioneer(Pioneer pioneer) {
        return homeMapper.updatePioneer(pioneer);
    }

    /**
     * 查询当前是否是关注关系
     *
     * @param userNo
     * @param focusUserNo
     */
    public boolean queryFocus(String userNo, String focusUserNo) {
        int data = homeMapper.queryFocus(userNo, focusUserNo);
        if (data > 0) {
            return true;
        }
        return false;
    }

    /**
     * 进行关注房产经纪人
     *
     * @param userNo
     * @param focusUserNo
     * @return
     */
    public boolean addFocusPioneer(String userNo, String focusUserNo) {
        String id = DataBaseTool.createNo("FU");
        Date date = DataBaseTool.createDate();
        int data = homeMapper.addFocusPioneer(id, userNo, focusUserNo, date);
        if (data > 0) {
            return true;
        }
        return false;
    }

    /**
     * 取消关注
     *
     * @param userNo
     * @param focusUserNo
     * @return
     */
    public boolean deleteFocusPioneer(String userNo, String focusUserNo) {
        int data = homeMapper.deleteFocusPioneer(userNo, focusUserNo);
        if (data > 0) {
            return true;
        }
        return false;
    }

    /**
     * 我关注的房产经纪人
     *
     * @param userNo
     * @return
     */
    public List<PioneerList> myFocusPioneer(String userNo) {
        List<PioneerList> data = homeMapper.myFocusPioneer(userNo);
        return data;
    }
}
