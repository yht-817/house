package com.ruoyi.project.tool.conf;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


/**
 * 类说明:数据请求实体
 *
 * @author ideacoding
 * @create 2018-01-18 11:33
 * @Email ：ideacoding@163.com
 **/
@ApiModel(value = "RequestData", description = "数据请求实体")
public class RequestData<T> {

    @ApiModelProperty(dataType = "T", name = "data", value = "变化参数")
    @Valid
    @NotNull(message = "业务参数不能为空")
    private T data;

    @ApiModelProperty(dataType = "String", name = "userNo", value = "用户编码")
    private String userNo;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
}
