package com.ruoyi.project.globalapp.main.service;

import com.ruoyi.project.globalapp.main.domain.PioneerListMain;
import com.ruoyi.project.globalapp.main.domain.TodayHouseInfo;

import java.util.List;

public interface IMainService {
    List<TodayHouseInfo> queryTodayHouseInfo();

    List<PioneerListMain> queryPioneerList();
}
