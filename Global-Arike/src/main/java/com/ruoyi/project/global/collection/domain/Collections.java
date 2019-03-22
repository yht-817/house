package com.ruoyi.project.global.collection.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 收藏列表 global_collection
 * 
 * @author ruoyi
 * @date 2019-03-06
 */
public class Collections extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** id */
	private String id;
	/** 用户编码 */
	private String userNo;
	/** 各个收藏的业务的唯一编码 */
	private String businessNo;
	/** 业务类型（房屋1001），（资讯1002） */
	private String businessType;
	/** 时间 */
	private Date collectionTime;

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
	public void setBusinessNo(String businessNo) 
	{
		this.businessNo = businessNo;
	}

	public String getBusinessNo() 
	{
		return businessNo;
	}
	public void setBusinessType(String businessType) 
	{
		this.businessType = businessType;
	}

	public String getBusinessType() 
	{
		return businessType;
	}
	public void setCollectionTime(Date collectionTime) 
	{
		this.collectionTime = collectionTime;
	}

	public Date getCollectionTime() 
	{
		return collectionTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userNo", getUserNo())
            .append("businessNo", getBusinessNo())
            .append("businessType", getBusinessType())
            .append("collectionTime", getCollectionTime())
            .toString();
    }
}
