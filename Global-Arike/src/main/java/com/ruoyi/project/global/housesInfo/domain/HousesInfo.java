package com.ruoyi.project.global.housesInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 房屋表 global_houses_info
 * 
 * @author ruoyi
 * @date 2019-02-27
 */
public class HousesInfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** Id */
	private String id;
	/** 用户编码 */
	private String userNo;
	/** 楼盘名字 */
	private String housesName;
	/** 楼盘类型 */
	private String housesGenre;
	/** 楼盘价格 */
	private BigDecimal housesPrice;
	/** 国家 */
	private String country;
	/** 城市 */
	private String city;
	/** 纬度 */
	private Double lat;
	/** 经度 */
	private Double log;
	/** 币种类型 */
	private String housesPriceType;
	/** 房屋建造时间 */
	private String housesBuildDate;
	/** 房屋编码 */
	private String housesCode;
	/** 楼盘地址 */
	private String housesAddress;
	/** 房屋产权 */
	private String housesEquity;
	/** 交房时间 */
	private String housesDelivery;
	/** 房屋的封面图片 */
	private String housesCoverImg;
	/** 房源描述 */
	private String housesDescribe;
	/** 开发商编码 */
	private String houseDevelopersNo;
	/**  */
	private Date createTime;

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setUserNo(String userNo) 
	{
		this.userNo = userNo;
	}

	public String getUserNo() 
	{
		return userNo;
	}
	public void setHousesName(String housesName) 
	{
		this.housesName = housesName;
	}

	public String getHousesName() 
	{
		return housesName;
	}
	public void setHousesGenre(String housesGenre) 
	{
		this.housesGenre = housesGenre;
	}

	public String getHousesGenre() 
	{
		return housesGenre;
	}
	public void setHousesPrice(BigDecimal housesPrice) 
	{
		this.housesPrice = housesPrice;
	}

	public BigDecimal getHousesPrice() 
	{
		return housesPrice;
	}
	public void setCountry(String country) 
	{
		this.country = country;
	}

	public String getCountry() 
	{
		return country;
	}
	public void setCity(String city) 
	{
		this.city = city;
	}

	public String getCity() 
	{
		return city;
	}
	public void setLat(Double lat) 
	{
		this.lat = lat;
	}

	public Double getLat() 
	{
		return lat;
	}
	public void setLog(Double log) 
	{
		this.log = log;
	}

	public Double getLog() 
	{
		return log;
	}
	public void setHousesPriceType(String housesPriceType) 
	{
		this.housesPriceType = housesPriceType;
	}

	public String getHousesPriceType() 
	{
		return housesPriceType;
	}
	public void setHousesBuildDate(String housesBuildDate) 
	{
		this.housesBuildDate = housesBuildDate;
	}

	public String getHousesBuildDate() 
	{
		return housesBuildDate;
	}
	public void setHousesCode(String housesCode) 
	{
		this.housesCode = housesCode;
	}

	public String getHousesCode() 
	{
		return housesCode;
	}
	public void setHousesAddress(String housesAddress) 
	{
		this.housesAddress = housesAddress;
	}

	public String getHousesAddress() 
	{
		return housesAddress;
	}
	public void setHousesEquity(String housesEquity) 
	{
		this.housesEquity = housesEquity;
	}

	public String getHousesEquity() 
	{
		return housesEquity;
	}
	public void setHousesDelivery(String housesDelivery) 
	{
		this.housesDelivery = housesDelivery;
	}

	public String getHousesDelivery() 
	{
		return housesDelivery;
	}
	public void setHousesCoverImg(String housesCoverImg) 
	{
		this.housesCoverImg = housesCoverImg;
	}

	public String getHousesCoverImg() 
	{
		return housesCoverImg;
	}
	public void setHousesDescribe(String housesDescribe) 
	{
		this.housesDescribe = housesDescribe;
	}

	public String getHousesDescribe() 
	{
		return housesDescribe;
	}
	public void setHouseDevelopersNo(String houseDevelopersNo) 
	{
		this.houseDevelopersNo = houseDevelopersNo;
	}

	public String getHouseDevelopersNo() 
	{
		return houseDevelopersNo;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userNo", getUserNo())
            .append("housesName", getHousesName())
            .append("housesGenre", getHousesGenre())
            .append("housesPrice", getHousesPrice())
            .append("country", getCountry())
            .append("city", getCity())
            .append("lat", getLat())
            .append("log", getLog())
            .append("housesPriceType", getHousesPriceType())
            .append("housesBuildDate", getHousesBuildDate())
            .append("housesCode", getHousesCode())
            .append("housesAddress", getHousesAddress())
            .append("housesEquity", getHousesEquity())
            .append("housesDelivery", getHousesDelivery())
            .append("housesCoverImg", getHousesCoverImg())
            .append("housesDescribe", getHousesDescribe())
            .append("houseDevelopersNo", getHouseDevelopersNo())
            .append("createTime", getCreateTime())
            .toString();
    }
}
