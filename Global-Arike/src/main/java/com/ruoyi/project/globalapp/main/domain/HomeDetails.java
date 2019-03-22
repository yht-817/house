package com.ruoyi.project.globalapp.main.domain;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 房子的详细信息
 */
public class HomeDetails {

    @ApiModelProperty(value = "图片数组")
    private List<String> imgs;

    @ApiModelProperty(value = "楼盘名称")
    private String houses;

    @ApiModelProperty(value = "楼盘类型")
    private String houseType;

    @ApiModelProperty(value = "楼盘单价")
    private String price;

    @ApiModelProperty(value = "楼盘地址")
    private String address;

    @ApiModelProperty(value = "楼盘编码")
    private String housesCode;

    @ApiModelProperty(value = "交房日期")
    private String datePayment;

    @ApiModelProperty(value = "房屋产权")
    private String ownership;

    @ApiModelProperty(value = "房屋描述")
    private String describe;

    @ApiModelProperty(value = "户型介绍")
    private List<Doormodel> doorModel;

    @ApiModelProperty(value = "开发商介绍")
    private Developers developers;

    @ApiModelProperty(value = "是否关注")
    private boolean focus;

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }

    public String getHouses() {
        return houses;
    }

    public void setHouses(String houses) {
        this.houses = houses;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHousesCode() {
        return housesCode;
    }

    public void setHousesCode(String housesCode) {
        this.housesCode = housesCode;
    }

    public String getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(String datePayment) {
        this.datePayment = datePayment;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public List<Doormodel> getDoorModel() {
        return doorModel;
    }

    public void setDoorModel(List<Doormodel> doorModel) {
        this.doorModel = doorModel;
    }

    public Developers getDevelopers() {
        return developers;
    }

    public void setDevelopers(Developers developers) {
        this.developers = developers;
    }

    public boolean isFocus() {
        return focus;
    }

    public void setFocus(boolean focus) {
        this.focus = focus;
    }

    @Override
    public String toString() {
        return "HomeDetails{" +
                "imgs=" + imgs +
                ", houses='" + houses + '\'' +
                ", houseType='" + houseType + '\'' +
                ", price='" + price + '\'' +
                ", address='" + address + '\'' +
                ", housesCode='" + housesCode + '\'' +
                ", datePayment='" + datePayment + '\'' +
                ", ownership='" + ownership + '\'' +
                ", describe='" + describe + '\'' +
                ", doorModel=" + doorModel +
                ", developers=" + developers +
                '}';
    }
}
