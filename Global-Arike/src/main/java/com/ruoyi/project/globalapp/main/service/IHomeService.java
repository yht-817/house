package com.ruoyi.project.globalapp.main.service;


import com.ruoyi.project.global.collection.domain.Collections;
import com.ruoyi.project.global.comments.domain.Comments;
import com.ruoyi.project.global.information.domain.Information;
import com.ruoyi.project.global.pioneer.domain.Pioneer;
import com.ruoyi.project.globalapp.main.domain.*;

import java.util.List;

public interface IHomeService {
    List<ImgBanners> findHomeBanner();

    List<Country> findCity();

    boolean addSubscribeInfo(SubscribeInfos subscribeInfos);

    List<CountryMobilePrefixOutput> findPhoneCode();

    SubscribeInfos findSubscribeInfoInfo(String housesCode, String userNo);

    List<PioneerList> queryPioneerList(int pageSize, int pageNo, String city);

    List<InformationList> queryInformationList(int pageSize, int pageNo);

    Information informationDetails(String informationNo);

    boolean addComments(Comments comments);

    void addGiveNo(String informationNo);

    void addLook(String informationNo);

    List<GlobalComments> queryCommentsList(String informationNo, int pageSize, int pageNo);

    boolean addBusiness(Collections collection);

    boolean queryWhetherCollect(String userNo, String informationNo, String businessType);

    boolean deleteCollect(String businessNo);

    boolean findPioneer(String userNo);

    int updatePioneer(Pioneer pioneer);

    boolean queryFocus(String userNo, String focusUserNo);

    boolean addFocusPioneer(String userNo, String focusUserNo);

    boolean deleteFocusPioneer(String userNo, String focusUserNo);

    List<PioneerList> myFocusPioneer(String userNo);
}
