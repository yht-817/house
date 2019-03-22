package com.ruoyi.project.global.housesInfoImg.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 楼盘相册表 global_houses_info_img
 * 
 * @author ruoyi
 * @date 2019-02-20
 */
public class HousesInfoImg extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 房屋编码 */
	private String housesCode;
	/** 房屋图片介绍 */
	private String housesImg;
	/** 图片存在状态 */
	private Integer housesHide;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setHousesCode(String housesCode) 
	{
		this.housesCode = housesCode;
	}

	public String getHousesCode() 
	{
		return housesCode;
	}
	public void setHousesImg(String housesImg) 
	{
		this.housesImg = housesImg;
	}

	public String getHousesImg() 
	{
		return housesImg;
	}
	public void setHousesHide(Integer housesHide) 
	{
		this.housesHide = housesHide;
	}

	public Integer getHousesHide() 
	{
		return housesHide;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("housesCode", getHousesCode())
            .append("housesImg", getHousesImg())
            .append("housesHide", getHousesHide())
            .toString();
    }
}
