package com.ruoyi.project.global.pioneer.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 地产先锋表 global_pioneer
 *
 * @author ruoyi
 * @date 2019-02-21
 */
public class Pioneer {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Integer id;
    /**
     * 用户编码
     */
    private String userNo;
    /**
     * 电话号
     */
    private String phoneNo;
    /**
     * 邮箱
     */
    private String emailNo;
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
    /**
     * 状态
     */
    private Integer hide;
    /**
     * 时间
     */
    private Date time;

    private boolean relation;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setEmailNo(String emailNo) {
        this.emailNo = emailNo;
    }

    public String getEmailNo() {
        return emailNo;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setLive(String live) {
        this.live = live;
    }

    public String getLive() {
        return live;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setHide(Integer hide) {
        this.hide = hide;
    }

    public Integer getHide() {
        return hide;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public boolean isRelation() {
        return relation;
    }

    public void setRelation(boolean relation) {
        this.relation = relation;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userNo", getUserNo())
                .append("phoneNo", getPhoneNo())
                .append("emailNo", getEmailNo())
                .append("userName", getUserName())
                .append("userHead", getUserHead())
                .append("live", getLive())
                .append("introduce", getIntroduce())
                .append("hide", getHide())
                .append("time", getTime())
                .toString();
    }
}
