package com.ruoyi.project.globalapp.main.service;

import com.ruoyi.project.globalapp.main.domain.BridalchamberList;
import com.ruoyi.project.globalapp.main.domain.Developers;
import com.ruoyi.project.globalapp.main.mapper.HouseMapper;
import com.ruoyi.project.tool.build.DataBaseTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class HouseServiceImpl implements IHouseService {
    @Autowired
    private HouseMapper houseMapper;


    /**
     * 房屋类型的列表
     *
     * @return
     */
    public List<Map<String, Object>> queryHomeType() {
        return houseMapper.queryHomeType();
    }


    /**
     * 排序查询
     *
     * @param pageNo
     * @param pageSize
     * @param rank
     * @return
     */
    public List<Map<String, Object>> queryHouseInfo(int pageNo, int pageSize, String rank) {
        return houseMapper.queryHouseInfo(pageNo, pageSize, rank);
    }

    /**
     * 查询房屋的基本信息
     */
    public Map<String, Object> quereyhouseInfo(String homeCode) {
        return houseMapper.quereyhouseInfo(homeCode);
    }

    /**
     * 查询数组图片
     */
    public List<String> quereyImgs(String homeCode) {
        return houseMapper.quereyImgs(homeCode);
    }

    /**
     * 户型介绍
     */
    public List<Map<String, Object>> queryDoormodel(String homeCode) {
        return houseMapper.queryDoormodel(homeCode);
    }

    /**
     * 查询开发商资料
     */
    public Developers quereyDevelopers(String house_developers_no) {
        return houseMapper.quereyDevelopers(house_developers_no);
    }

    /**
     * 关注房子
     *
     * @param homeCode
     * @param userNo
     * @param collectionType
     */
    public boolean addCollection(String homeCode, String userNo, String collectionType) {
        if (homeCode.equals("") && userNo.equals("") && collectionType.equals("")) {
            return false;
        }
        String id = DataBaseTool.createNo("HO");
        Date date = DataBaseTool.createDate();
        int data = houseMapper.addCollection(id, userNo, homeCode, collectionType, date);
        if (data > 0) {
            return true;
        }
        return false;
    }

    /**
     * 关注房子的列表
     */
    public List<BridalchamberList> quereyFocus(String userNo, String collectionType) {
        List<Map<String, Object>> datamap = houseMapper.quereyFocus(userNo, collectionType);
        List<BridalchamberList> data = new ArrayList<>();
        BridalchamberList bridalchamberList = null;
        for (int i = 0; i < datamap.size(); i++) {
            bridalchamberList = new BridalchamberList();
            bridalchamberList.setHousesCode((String) datamap.get(i).get("houses_code"));
            bridalchamberList.setPrice(datamap.get(i).get("houses_price_type") + "/" + datamap.get(i).get("houses_price") + "起");
            bridalchamberList.setHouses((String) datamap.get(i).get("houses_name"));
            bridalchamberList.setImg((String) datamap.get(i).get("houses_cover_img"));
            bridalchamberList.setHousesType((String) datamap.get(i).get("housing_type"));
            bridalchamberList.setAddress(datamap.get(i).get("country") + "" + datamap.get(i).get("city") + datamap.get(i).get("houses_address"));
            data.add(bridalchamberList);
        }
        return data;
    }

    /**
     * 查询当前用户是否是关注关系
     *
     * @param userNo
     * @param homeCode
     * @return
     */
    public boolean quereyFocusRelation(String userNo, String homeCode) {
        int data = houseMapper.quereyFocusRelation(userNo, homeCode);
        if (data > 0) {
            return true;
        }
        return false;
    }

    /**
     * 取消关注房子
     *
     * @param homeCode
     * @param userNo
     * @return
     */
    public boolean deleteCollection(String homeCode, String userNo) {
        int data = houseMapper.deleteCollection(homeCode, userNo);
        if (data > 0) {
            return true;
        }
        return false;
    }

    /**
     * 新房列表进行筛选查询
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
    public List<BridalchamberList> queryScreening(int startPrice, int endPrice, int startArea, int endArea, String houseType, int bedroom, int bathroom, int pageNo, int pageSize, String rank) {
        List<BridalchamberList> data = new ArrayList<>();
        BridalchamberList bridalchamberList = null;
        List<Map<String, Object>> datamap = houseMapper.queryScreening(startPrice, endPrice, startArea, endArea, houseType, bedroom, bathroom, pageNo, pageSize, rank);
        for (int i = 0; i < datamap.size(); i++) {
            bridalchamberList = new BridalchamberList();
            bridalchamberList.setHousesCode((String) datamap.get(i).get("houses_code"));
            bridalchamberList.setPrice(datamap.get(i).get("houses_price_type") + "/" + datamap.get(i).get("houses_price") + "起");
            bridalchamberList.setHouses((String) datamap.get(i).get("houses_name"));
            bridalchamberList.setImg((String) datamap.get(i).get("houses_cover_img"));
            bridalchamberList.setHousesType((String) datamap.get(i).get("housing_type"));
            bridalchamberList.setAddress(datamap.get(i).get("country") + "" + datamap.get(i).get("city") + datamap.get(i).get("houses_address"));
            data.add(bridalchamberList);
        }
        return data;
    }

    /**
     * 查看房产经纪人上传的房子信息
     *
     * @param focusUserNo
     */
    public List<BridalchamberList> queryAgentHouse(String focusUserNo) {
        List<BridalchamberList> data = new ArrayList<>();
        BridalchamberList bridalchamberList = null;
        List<Map<String, Object>> datamap = houseMapper.queryAgentHouse(focusUserNo);
        for (int i = 0; i < datamap.size(); i++) {
            bridalchamberList = new BridalchamberList();
            bridalchamberList.setHousesCode((String) datamap.get(i).get("houses_code"));
            bridalchamberList.setPrice(datamap.get(i).get("houses_price_type") + "/" + datamap.get(i).get("houses_price") + "起");
            bridalchamberList.setHouses((String) datamap.get(i).get("houses_name"));
            bridalchamberList.setImg((String) datamap.get(i).get("houses_cover_img"));
            bridalchamberList.setHousesType((String) datamap.get(i).get("housing_type"));
            bridalchamberList.setAddress(datamap.get(i).get("country") + "" + datamap.get(i).get("city") + datamap.get(i).get("houses_address"));
            data.add(bridalchamberList);
        }
        return data;
    }


}
