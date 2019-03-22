package com.ruoyi.project.global.userAuths.domain;

/**
 * 用户登陆成功后返回的登陆参数
 */
public class UserInfoGet {
    /**
     * 用户编码
     */
    private String userNo;
    /**
     * 应用Key
     */
    private String thirdKey;
    /**
     * 头像
     */
    private String userHead;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 用户性别
     */
    private String sexNo;
    /**
     * 用户签名
     */
    private String userSign;

    /**
     * 手机号码绑定
     */
    private boolean bind;

    /**
     * 经纪人绑定
     */
    private boolean bindAgent;

    private String currentCity;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getThirdKey() {
        return thirdKey;
    }

    public void setThirdKey(String thirdKey) {
        this.thirdKey = thirdKey;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSexNo() {
        return sexNo;
    }

    public void setSexNo(String sexNo) {
        this.sexNo = sexNo;
    }

    public String getUserSign() {
        return userSign;
    }

    public void setUserSign(String userSign) {
        this.userSign = userSign;
    }

    public boolean isBind() {
        return bind;
    }

    public void setBind(boolean bind) {
        this.bind = bind;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public boolean isBindAgent() {
        return bindAgent;
    }

    public void setBindAgent(boolean bindAgent) {
        this.bindAgent = bindAgent;
    }
}
