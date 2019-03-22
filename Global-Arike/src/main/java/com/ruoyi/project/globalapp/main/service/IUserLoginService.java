package com.ruoyi.project.globalapp.main.service;

import com.ruoyi.project.global.userAuths.domain.UserInfoGet;
import com.ruoyi.project.globalapp.main.domain.UserLogin;

public interface IUserLoginService {
    /**
     * 用户的注册登陆
     */
    UserInfoGet addUserInfo(UserLogin userLogin);

    boolean boundPhone(String phoneNo, String phoneCode, String userNo);
}
