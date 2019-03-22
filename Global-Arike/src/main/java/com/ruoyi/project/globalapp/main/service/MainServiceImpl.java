package com.ruoyi.project.globalapp.main.service;

import com.ruoyi.project.globalapp.main.domain.TodayHouseInfo;
import com.ruoyi.project.globalapp.main.mapper.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainServiceImpl implements IMainService {
    @Autowired
    private MainMapper mainMapper;

    /**
     * 查询今日上新数据
     */
    public List<TodayHouseInfo> queryTodayHouseInfo() {
        // 按照时间降序排列
        return null;
    }
}
