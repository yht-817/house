package com.ruoyi.project.globalapp.main.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 预约表 global_subscribe_info
 *
 * @author ruoyi
 * @date 2019-02-20
 */
public class SubscribeInfos {
    private static final long serialVersionUID = 1L;

    /**
     * 房屋编码
     */
    private String housesCode;

    /**
     * 用户编码
     */
    private String userNo;

    /**
     * 用户姓名
     */
    private String name;
    /**
     * 用户性别
     */
    private String sex;
    /**
     * 电话号码
     */
    private String phoneNo;
    /**
     * 微信号
     */
    private String wxNo;
    /**
     * 邮箱
     */
    private String emailNo;
    /**
     * 备注
     */
    private String note;

    public String getHousesCode() {
        return housesCode;
    }

    public void setHousesCode(String housesCode) {
        this.housesCode = housesCode;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getWxNo() {
        return wxNo;
    }

    public void setWxNo(String wxNo) {
        this.wxNo = wxNo;
    }

    public String getEmailNo() {
        return emailNo;
    }

    public void setEmailNo(String emailNo) {
        this.emailNo = emailNo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "SubscribeInfos{" +
                "housesCode='" + housesCode + '\'' +
                ", userNo='" + userNo + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", wxNo='" + wxNo + '\'' +
                ", emailNo='" + emailNo + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
