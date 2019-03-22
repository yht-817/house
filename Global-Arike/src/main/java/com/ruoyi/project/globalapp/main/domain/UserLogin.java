package com.ruoyi.project.globalapp.main.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class UserLogin {
    @ApiModelProperty(dataType = "String", name = "thirdKey", value = "微信的openId")
    @NotNull(message = "微信唯一标识不能为空")
    private String thirdKey;
    @ApiModelProperty(dataType = "String", name = "thirdHead", value = "头像")
    private String thirdHead;
    @ApiModelProperty(dataType = "String", name = "thirdName", value = "昵称")
    private String thirdName;
    @ApiModelProperty(dataType = "String", name = "thirdSex", value = "性别(男:10010001 女:10010002)")
    private String thirdSex;
    @ApiModelProperty(dataType = "String", name = "log", value = "经度")
    private String lng;
    @ApiModelProperty(dataType = "String", name = "lat", value = "纬度")
    private String lat;

    public String getThirdKey() {
        return thirdKey;
    }

    public void setThirdKey(String thirdKey) {
        this.thirdKey = thirdKey;
    }

    public String getThirdHead() {
        return thirdHead;
    }

    public void setThirdHead(String thirdHead) {
        this.thirdHead = thirdHead;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getThirdSex() {
        return thirdSex;
    }

    public void setThirdSex(String thirdSex) {
        this.thirdSex = thirdSex;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "thirdKey='" + thirdKey + '\'' +
                ", thirdHead='" + thirdHead + '\'' +
                ", thirdName='" + thirdName + '\'' +
                ", thirdSex='" + thirdSex + '\'' +
                '}';
    }
}
