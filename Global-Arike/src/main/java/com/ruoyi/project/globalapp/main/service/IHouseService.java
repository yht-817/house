package com.ruoyi.project.globalapp.main.service;

import com.ruoyi.project.globalapp.main.domain.BridalchamberList;
import com.ruoyi.project.globalapp.main.domain.Developers;

import java.util.List;
import java.util.Map;

public interface IHouseService {
    List<Map<String, Object>> queryHouseInfo(int pageNo, int pageSize, String rank);

    List<Map<String, Object>> queryHomeType();

    Map<String, Object> quereyhouseInfo(String homeCode);

    List<String> quereyImgs(String homeCode);

    List<Map<String, Object>> queryDoormodel(String homeCode);

    Developers quereyDevelopers(String house_developers_no);

    boolean addCollection(String homeCode, String userNo, String collectionType);

    List<BridalchamberList> quereyFocus(String userNo, String collectionType);

    boolean quereyFocusRelation(String userNo, String homeCode);

    boolean deleteCollection(String homeCode, String userNo);

    List<BridalchamberList> queryScreening(int startPrice, int endPrice, int startArea, int endArea, String houseType, int bedroom, int bathroom, int pageNo, int pageSize, String rank);

    List<BridalchamberList> queryAgentHouse(String focusUserNo);
}
