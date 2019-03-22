package com.ruoyi.project.global.housesType.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 房屋类型表 global_houses_type
 * 
 * @author ruoyi
 * @date 2019-02-19
 */
public class HousesType extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** id */
	private Integer id;
	/** 编码 */
	private Integer typeNo;
	/** 房屋类型 */
	private String housingType;
	/** 房屋类型（英文） */
	private String housingTypeE;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setTypeNo(Integer typeNo) 
	{
		this.typeNo = typeNo;
	}

	public Integer getTypeNo() 
	{
		return typeNo;
	}
	public void setHousingType(String housingType) 
	{
		this.housingType = housingType;
	}

	public String getHousingType() 
	{
		return housingType;
	}
	public void setHousingTypeE(String housingTypeE) 
	{
		this.housingTypeE = housingTypeE;
	}

	public String getHousingTypeE() 
	{
		return housingTypeE;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("typeNo", getTypeNo())
            .append("housingType", getHousingType())
            .append("housingTypeE", getHousingTypeE())
            .toString();
    }
}
