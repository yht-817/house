package com.ruoyi.project.globalapp.main.domain;

/**
 * 地产先锋表 global_pioneer
 *
 * @author ruoyi
 * @date 2019-02-21
 */
public class PioneerList {
    private static final long serialVersionUID = 1L;

    /**
     * 用户编码
     */
    private String userNo;
    /**
     * 电话号
     */
    private String phoneNo;
    /**
     * 姓名
     */
    private String userName;
    /**
     * 头像
     */
    private String userHead;
    /**
     * 居住地点
     */
    private String live;
    /**
     * 自我介绍
     */
    private String introduce;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public String getLive() {
        return live;
    }

    public void setLive(String live) {
        this.live = live;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "PioneerList{" +
                "userNo='" + userNo + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", userName='" + userName + '\'' +
                ", userHead='" + userHead + '\'' +
                ", live='" + live + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}
