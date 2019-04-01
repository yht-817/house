package com.ruoyi.project.globalapp.main.domain;

/**
 * 地产先锋表 global_pioneer
 *
 * @author ruoyi
 * @date 2019-02-21
 */
public class PioneerListMain {
    /**
     * 用户编码
     */
    private String userNo;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 头像
     */
    private String userHead;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
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

    @Override
    public String toString() {
        return "PioneerListMain{" +
                "userNo='" + userNo + '\'' +
                ", userName='" + userName + '\'' +
                ", userHead='" + userHead + '\'' +
                '}';
    }
}
