package com.ruoyi.project.global.drawingInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 房屋介绍表 global_drawing_info
 *
 * @author ruoyi
 * @date 2019-02-20
 */
public class DrawingInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**  */
    private String id;
    /**
     * 房屋编码
     */
    private String housesCode;
    /**
     * 房屋图纸
     */
    private String housesDrawingUrl;
    /**
     * 图纸名字
     */
    private String housesDrawingName;
    /**
     * 房屋面积
     */
    private BigDecimal housesArea;
    /**
     * 卧室数量
     */
    private BigDecimal housesBedroomNo;
    /**
     * 卫浴数量
     */
    private BigDecimal housesBathroomNo;
    /**
     * 单价
     */
    private BigDecimal housesUnitPrice;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setHousesCode(String housesCode) {
        this.housesCode = housesCode;
    }

    public String getHousesCode() {
        return housesCode;
    }

    public void setHousesDrawingUrl(String housesDrawingUrl) {
        this.housesDrawingUrl = housesDrawingUrl;
    }

    public String getHousesDrawingUrl() {
        return housesDrawingUrl;
    }

    public void setHousesDrawingName(String housesDrawingName) {
        this.housesDrawingName = housesDrawingName;
    }

    public String getHousesDrawingName() {
        return housesDrawingName;
    }

    public void setHousesArea(BigDecimal housesArea) {
        this.housesArea = housesArea;
    }

    public BigDecimal getHousesArea() {
        return housesArea;
    }

    public void setHousesBedroomNo(BigDecimal housesBedroomNo) {
        this.housesBedroomNo = housesBedroomNo;
    }

    public BigDecimal getHousesBedroomNo() {
        return housesBedroomNo;
    }

    public void setHousesBathroomNo(BigDecimal housesBathroomNo) {
        this.housesBathroomNo = housesBathroomNo;
    }

    public BigDecimal getHousesBathroomNo() {
        return housesBathroomNo;
    }

    public void setHousesUnitPrice(BigDecimal housesUnitPrice) {
        this.housesUnitPrice = housesUnitPrice;
    }

    public BigDecimal getHousesUnitPrice() {
        return housesUnitPrice;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("housesCode", getHousesCode())
                .append("housesDrawingUrl", getHousesDrawingUrl())
                .append("housesDrawingName", getHousesDrawingName())
                .append("housesArea", getHousesArea())
                .append("housesBedroomNo", getHousesBedroomNo())
                .append("housesBathroomNo", getHousesBathroomNo())
                .append("housesUnitPrice", getHousesUnitPrice())
                .toString();
    }
}
