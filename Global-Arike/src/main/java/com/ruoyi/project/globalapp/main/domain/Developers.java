package com.ruoyi.project.globalapp.main.domain;

import io.swagger.annotations.ApiModelProperty;

public class Developers {

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private String id;
    /**
     * 开发商编码
     */
    @ApiModelProperty(value = "开发商编码")
    private String houseDevelopersNo;
    /**
     * 开发商名字
     */
    @ApiModelProperty(value = "开发商名字")
    private String houseDevelopersName;
    /**
     * 公司logo
     */
    @ApiModelProperty(value = "公司logo")
    private String houseDevelopersLogo;
    /**
     * 开发商介绍
     */
    @ApiModelProperty(value = "开发商介绍")
    private String houseDevelopersIntroduce;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHouseDevelopersNo() {
        return houseDevelopersNo;
    }

    public void setHouseDevelopersNo(String houseDevelopersNo) {
        this.houseDevelopersNo = houseDevelopersNo;
    }

    public String getHouseDevelopersName() {
        return houseDevelopersName;
    }

    public void setHouseDevelopersName(String houseDevelopersName) {
        this.houseDevelopersName = houseDevelopersName;
    }

    public String getHouseDevelopersLogo() {
        return houseDevelopersLogo;
    }

    public void setHouseDevelopersLogo(String houseDevelopersLogo) {
        this.houseDevelopersLogo = houseDevelopersLogo;
    }

    public String getHouseDevelopersIntroduce() {
        return houseDevelopersIntroduce;
    }

    public void setHouseDevelopersIntroduce(String houseDevelopersIntroduce) {
        this.houseDevelopersIntroduce = houseDevelopersIntroduce;
    }

    @Override
    public String toString() {
        return "Developers{" +
                "id='" + id + '\'' +
                ", houseDevelopersNo='" + houseDevelopersNo + '\'' +
                ", houseDevelopersName='" + houseDevelopersName + '\'' +
                ", houseDevelopersLogo='" + houseDevelopersLogo + '\'' +
                ", houseDevelopersIntroduce='" + houseDevelopersIntroduce + '\'' +
                '}';
    }
}
