package com.ruoyi.project.global.information.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 资讯表 global_information
 *
 * @author ruoyi
 * @date 2019-02-28
 */
public class Information extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 资讯编码
     */
    private String informationNo;
    /**
     * 用户编码
     */
    private String userNo;
    /**
     * 资讯模式（转载/原创）
     */
    private String informationMode;
    /**
     * 资讯显示类型
     */
    private String informationType;
    /**
     * 资讯标题
     */
    private String informationTitle;
    /**
     * 资讯标题图片
     */
    private String informationBanner;
    /**
     * 资讯内容
     */
    private String informationContent;
    /**
     * 评论数
     */
    private Integer discussNumber;
    /**
     * 点赞数量
     */
    private Integer giveNumber;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 判断当前的用户是否收藏过
     */
    private boolean whetherCollect;

    public void setInformationNo(String informationNo) {
        this.informationNo = informationNo;
    }

    public String getInformationNo() {
        return informationNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setInformationMode(String informationMode) {
        this.informationMode = informationMode;
    }

    public String getInformationMode() {
        return informationMode;
    }

    public void setInformationType(String informationType) {
        this.informationType = informationType;
    }

    public String getInformationType() {
        return informationType;
    }

    public void setInformationTitle(String informationTitle) {
        this.informationTitle = informationTitle;
    }

    public String getInformationTitle() {
        return informationTitle;
    }

    public void setInformationBanner(String informationBanner) {
        this.informationBanner = informationBanner;
    }

    public String getInformationBanner() {
        return informationBanner;
    }

    public void setInformationContent(String informationContent) {
        this.informationContent = informationContent;
    }

    public String getInformationContent() {
        return informationContent;
    }

    public void setDiscussNumber(Integer discussNumber) {
        this.discussNumber = discussNumber;
    }

    public Integer getDiscussNumber() {
        return discussNumber;
    }

    public void setGiveNumber(Integer giveNumber) {
        this.giveNumber = giveNumber;
    }

    public Integer getGiveNumber() {
        return giveNumber;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public boolean isWhetherCollect() {
        return whetherCollect;
    }

    public void setWhetherCollect(boolean whetherCollect) {
        this.whetherCollect = whetherCollect;
    }

    @Override
    public String toString() {
        return "Information{" +
                "informationNo='" + informationNo + '\'' +
                ", userNo='" + userNo + '\'' +
                ", informationMode='" + informationMode + '\'' +
                ", informationType='" + informationType + '\'' +
                ", informationTitle='" + informationTitle + '\'' +
                ", informationBanner='" + informationBanner + '\'' +
                ", informationContent='" + informationContent + '\'' +
                ", discussNumber=" + discussNumber +
                ", giveNumber=" + giveNumber +
                ", createTime=" + createTime +
                ", whetherCollect=" + whetherCollect +
                '}';
    }
}
