package com.ruoyi.project.globalapp.main.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * 户型介绍
 */
public class Doormodel {

    @ApiModelProperty(value = "图片")
    private String img;

    @ApiModelProperty(value = "楼盘总价")
    private String price;

    @ApiModelProperty(value = "规格：面积，几室，几卫")
    private String specification;

    @ApiModelProperty(value = "名字")
    private String name;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Doormodel{" +
                "img='" + img + '\'' +
                ", price='" + price + '\'' +
                ", specification='" + specification + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
