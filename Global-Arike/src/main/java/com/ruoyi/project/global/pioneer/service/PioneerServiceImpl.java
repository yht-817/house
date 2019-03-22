package com.ruoyi.project.global.pioneer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.global.pioneer.mapper.PioneerMapper;
import com.ruoyi.project.global.pioneer.domain.Pioneer;
import com.ruoyi.project.global.pioneer.service.IPioneerService;
import com.ruoyi.common.support.Convert;

/**
 * 地产先锋 服务层实现
 *
 * @author ruoyi
 * @date 2019-02-21
 */
@Service
public class PioneerServiceImpl implements IPioneerService {
    @Autowired
    private PioneerMapper pioneerMapper;

    /**
     * 查询地产先锋信息
     *
     * @param id 地产先锋ID
     * @return 地产先锋信息
     */
    @Override
    public Pioneer selectPioneerById(Integer id) {
        return pioneerMapper.selectPioneerById(id);
    }

    /**
     * 查询地产先锋列表
     *
     * @param pioneer 地产先锋信息
     * @return 地产先锋集合
     */
    @Override
    public List<Pioneer> selectPioneerList(Pioneer pioneer) {
        return pioneerMapper.selectPioneerList(pioneer);
    }

    /**
     * 新增地产先锋
     *
     * @param pioneer 地产先锋信息
     * @return 结果
     */
    @Override
    public int insertPioneer(Pioneer pioneer) {
        return pioneerMapper.insertPioneer(pioneer);
    }

    /**
     * 修改地产先锋
     *
     * @param pioneer 地产先锋信息
     * @return 结果
     */
    @Override
    public int updatePioneer(Pioneer pioneer) {
        return pioneerMapper.updatePioneer(pioneer);
    }

    /**
     * 删除地产先锋对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePioneerByIds(String ids) {
        return pioneerMapper.deletePioneerByIds(Convert.toStrArray(ids));
    }
}
