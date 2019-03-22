package com.ruoyi.project.globalapp.main.domain;

import io.swagger.annotations.Api;

import java.util.Date;

@Api(tags = "资讯列表展示", description = "InformationList")
public class InformationList {
    // 资讯编码
    private String informationNo;
    // 用户编码
    private String userNo;
    // 用户昵称
    private String nickName;
    // 用户头像
    private String userHead;
    // 资讯标题
    private String informationTitle;
    // 资讯标题图片
    private String informationBanner;
    // 评论数
    private Integer discussNumber;
    // 点赞数量
    private Integer giveNumber;
    // 创建时间
    private String createTime;

    public String getInformationNo() {
        return informationNo;
    }

    public void setInformationNo(String informationNo) {
        this.informationNo = informationNo;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public String getInformationTitle() {
        return informationTitle;
    }

    public void setInformationTitle(String informationTitle) {
        this.informationTitle = informationTitle;
    }

    public String getInformationBanner() {
        return informationBanner;
    }

    public void setInformationBanner(String informationBanner) {
        this.informationBanner = informationBanner;
    }

    public Integer getDiscussNumber() {
        return discussNumber;
    }

    public void setDiscussNumber(Integer discussNumber) {
        this.discussNumber = discussNumber;
    }

    public Integer getGiveNumber() {
        return giveNumber;
    }

    public void setGiveNumber(Integer giveNumber) {
        this.giveNumber = giveNumber;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "InformationList{" +
                "informationNo='" + informationNo + '\'' +
                ", userNo='" + userNo + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userHead='" + userHead + '\'' +
                ", informationTitle='" + informationTitle + '\'' +
                ", informationBanner='" + informationBanner + '\'' +
                ", discussNumber=" + discussNumber +
                ", giveNumber=" + giveNumber +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
