package com.ruoyi.project.globalapp.main.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 绑定手机号码
 */
public class PhoneInfo {

    @ApiModelProperty(dataType = "String", name = "thirdKey", value = "手机号码")
    @NotNull(message = "手机号码不能为空")
    private String phoneNo;
    @ApiModelProperty(dataType = "String", name = "thirdHead", value = "手机号段")
    private String phoneCode;
    @ApiModelProperty(dataType = "String", name = "thirdSex", value = "用户编码")
    @NotNull(message = "用户编码不能为空")
    private String userNo;
    @ApiModelProperty(dataType = "String", name = "thirdName", value = "验证码")
    private String code;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "PhoneInfo{" +
                "phoneNo='" + phoneNo + '\'' +
                ", phoneCode='" + phoneCode + '\'' +
                ", userNo='" + userNo + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
