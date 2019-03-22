package com.ruoyi.project.globalapp.main.domain;

/**
 * 新房列表
 */
public class BridalchamberList {

    // 编码
    private String housesCode;
    // 价格
    private String price;
    // 楼盘
    private String houses;
    // 宣传图
    private String img;
    // 房屋类型
    private String housesType;
    // 地址
    private String address;

    public String getHousesCode() {
        return housesCode;
    }

    public void setHousesCode(String housesCode) {
        this.housesCode = housesCode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getHouses() {
        return houses;
    }

    public void setHouses(String houses) {
        this.houses = houses;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getHousesType() {
        return housesType;
    }

    public void setHousesType(String housesType) {
        this.housesType = housesType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "BridalchamberList{" +
                "housesCode='" + housesCode + '\'' +
                ", price='" + price + '\'' +
                ", houses='" + houses + '\'' +
                ", img='" + img + '\'' +
                ", housesType='" + housesType + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
