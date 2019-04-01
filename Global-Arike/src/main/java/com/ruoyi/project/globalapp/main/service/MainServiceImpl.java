package com.ruoyi.project.globalapp.main.service;

import com.ruoyi.project.globalapp.main.domain.PioneerListMain;
import com.ruoyi.project.globalapp.main.domain.TodayHouseInfo;
import com.ruoyi.project.globalapp.main.mapper.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MainServiceImpl implements IMainService {
    @Autowired
    private MainMapper mainMapper;

    /**
     * 查询今日上新数据
     */
    public List<TodayHouseInfo> queryTodayHouseInfo() {
        List<TodayHouseInfo> data = new ArrayList<>();
        TodayHouseInfo todayHouseInfo = null;
        // 按照时间降序排列
        List<Map<String, Object>> datamap = mainMapper.queryTodayHouseInfo();
        for (int i = 0; i < datamap.size(); i++) {
            todayHouseInfo = new TodayHouseInfo();
            todayHouseInfo.setHousesCode((String) datamap.get(i).get("houses_code"));
            todayHouseInfo.setPrice(datamap.get(i).get("houses_price_type") + "/" + datamap.get(i).get("houses_unit_price") + "万");
            todayHouseInfo.setHouses((String) datamap.get(i).get("houses_name"));
            todayHouseInfo.setImg((String) datamap.get(i).get("houses_drawing_url"));
            todayHouseInfo.setHousesType((String) datamap.get(i).get("housing_type"));
            todayHouseInfo.setPattern(datamap.get(i).get("houses_bedroom_no") + "室" + datamap.get(i).get("houses_bathroom_no") + "卫");
            todayHouseInfo.setAddress(datamap.get(i).get("country") + "" + datamap.get(i).get("city") + datamap.get(i).get("houses_address"));
            data.add(todayHouseInfo);
        }
        return data;
    }

    /**
     * 首页房产经纪人列表
     *
     * @return
     */
    public List<PioneerListMain> queryPioneerList() {
        return mainMapper.queryPioneerList();
    }
}
