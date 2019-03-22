package com.ruoyi.project.globalapp.main.mapper;

import com.ruoyi.project.global.userAuths.domain.UserAuths;
import org.apache.ibatis.annotations.Param;

public interface UserLoginMapper {
    UserAuths findQueryUserInfo(@Param("thirdKey") String thirdKey);
}
