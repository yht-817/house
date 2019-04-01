package com.ruoyi.project.globalapp.main.mapper;

import com.ruoyi.project.globalapp.main.domain.PioneerListMain;

import java.util.List;
import java.util.Map;

public interface MainMapper {
    List<Map<String, Object>> queryTodayHouseInfo();

    List<PioneerListMain> queryPioneerList();
}
