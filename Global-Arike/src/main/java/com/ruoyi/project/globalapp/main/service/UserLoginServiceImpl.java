package com.ruoyi.project.globalapp.main.service;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.project.global.userAuths.domain.UserAuths;
import com.ruoyi.project.global.userAuths.domain.UserInfoGet;
import com.ruoyi.project.global.userAuths.service.IUserAuthsService;
import com.ruoyi.project.global.userInfo.domain.UserInfo;
import com.ruoyi.project.global.userInfo.service.IUserInfoService;
import com.ruoyi.project.globalapp.main.domain.UserLogin;
import com.ruoyi.project.globalapp.main.mapper.UserLoginMapper;
import com.ruoyi.project.tool.build.DataBaseTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;

import java.util.Date;
import java.util.HashMap;

@Service
public class UserLoginServiceImpl implements IUserLoginService {
    @Autowired
    private UserLoginMapper userLoginMapper;
    
    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private IUserAuthsService userAuthsService;

    @Autowired
    private IHomeService iHomeService;


    /**
     * 用户的注册或登陆
     *
     * @param userLogin
     * @return
     */
    public UserInfoGet addUserInfo(UserLogin userLogin) {
        UserInfoGet userInfoGet = new UserInfoGet();
        if (userLogin.getLat() != "" && userLogin.getLng() != "") {
            String city = getCity(userLogin.getLng(), userLogin.getLat());
            userInfoGet.setCurrentCity(city);
        }
        // 1.0 查询当前用户是否登陆过
        UserAuths userAuths = userLoginMapper.findQueryUserInfo(userLogin.getThirdKey());
        if (userAuths != null) {
            UserInfo userInfo = userInfoService.selectUserInfoById(userAuths.getUserNo());
            // 说明当前用户已经注册过了，返回用户的基本信息
            userInfoGet.setUserNo(userAuths.getUserNo());
            userInfoGet.setThirdKey(userAuths.getThirdKey());
            userInfoGet.setUserHead(userInfo.getUserHead());
            userInfoGet.setNickName(userInfo.getNickName());
            userInfoGet.setSexNo(userInfo.getSexNo());
            userInfoGet.setUserSign(userInfo.getUserSign());

            if (userInfo.getPhoneNo() != null) {
                userInfoGet.setBind(true);
            } else {
                userInfoGet.setBind(false);
            }
            // 查询当前用户是否是经纪人
            boolean exist = iHomeService.findPioneer(userInfo.getUserNo());
            userInfoGet.setBindAgent(exist);
            return userInfoGet;
        }
        // 没有注册过的用户,生成用户编码
        userAuths = new UserAuths();
        String userNo = DataBaseTool.createNo("yh");
        userAuths.setUserNo(userNo);
        userAuths.setThirdKey(userLogin.getThirdKey());
        userAuths.setThirdType(null);
        userAuths.setThirdDate(new Date());
        int adduserAuths = userAuthsService.insertUserAuths(userAuths);
        if (adduserAuths > 0) {
            // 插入当前用户的基本信息
            UserInfo userInfo = new UserInfo();
            userInfo.setUserNo(userNo);
            userInfo.setUserHead(userLogin.getThirdHead());
            userInfo.setNickName(userLogin.getThirdName());
            userInfo.setSexNo(userLogin.getThirdSex());
            userInfo.setRegionDate(new Date());
            userInfo.setLastLoginDate(new Date());
            // 当前用户的状态0为正常用户，1为异常用户
            userInfo.setUserState("0");
            int addUserInfo = userInfoService.insertUserInfo(userInfo);
            if (addUserInfo > 0) {
                userInfoGet.setUserNo(userAuths.getUserNo());
                userInfoGet.setThirdKey(userAuths.getThirdKey());
                userInfoGet.setUserHead(userInfo.getUserHead());
                userInfoGet.setNickName(userInfo.getNickName());
                userInfoGet.setSexNo(userInfo.getSexNo());
                userInfoGet.setUserSign(userInfo.getUserSign());
                userInfoGet.setBind(false);
                userInfoGet.setBindAgent(false);
                return userInfoGet;
            }
        }
        return null;
    }

    /**
     * 进行手机号码的绑定
     */
    public boolean boundPhone(String phoneNo, String phoneCode, String userNo) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserNo(userNo);
        userInfo.setPhoneNo(phoneNo);
        userInfo.setPhoneCode(phoneCode);
        int i = userInfoService.updateUserInfo(userInfo);
        if (i > 0) {
            return true;
        }
        return false;
    }

    /**
     * 根据经纬度获取当前城市
     */
    public static String getCity(String lng, String lat) {
        String location = lat + "," + lng;
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("location", location);
        paramMap.put("get_poi", "1");
        paramMap.put("key", "ZJVBZ-6ARL6-5BCSC-MDP4T-V3BFJ-DYFIP");
        String result = HttpUtil.post("https://apis.map.qq.com/ws/geocoder/v1/?", paramMap);
        JSONObject jsonObject = (JSONObject) JSONObject.parse(result);
        String data = jsonObject.getString("result");
        System.out.println(data + "----------");
        JSONObject address_component_json = (JSONObject) JSONObject.parse(data);
        String address_component_data = address_component_json.getString("address_component");
        JSONObject province_json = (JSONObject) JSONObject.parse(address_component_data);
        String province_data = province_json.getString("city");
        return province_data;
    }
}
