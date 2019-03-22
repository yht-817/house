package com.ruoyi.project.global.houseDevelopersInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 开发商介绍表 global_house_developers_info
 * 
 * @author ruoyi
 * @date 2019-02-15
 */
public class HouseDevelopersInfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** id */
	private String id;
	/** 开发商编码 */
	private String houseDevelopersNo;
	/** 开发商名字 */
	private String houseDevelopersName;
	/** 公司logo */
	private String houseDevelopersLogo;
	/** 开发商介绍 */
	private String houseDevelopersIntroduce;

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setHouseDevelopersNo(String houseDevelopersNo) 
	{
		this.houseDevelopersNo = houseDevelopersNo;
	}

	public String getHouseDevelopersNo() 
	{
		return houseDevelopersNo;
	}
	public void setHouseDevelopersName(String houseDevelopersName) 
	{
		this.houseDevelopersName = houseDevelopersName;
	}

	public String getHouseDevelopersName() 
	{
		return houseDevelopersName;
	}
	public void setHouseDevelopersLogo(String houseDevelopersLogo) 
	{
		this.houseDevelopersLogo = houseDevelopersLogo;
	}

	public String getHouseDevelopersLogo() 
	{
		return houseDevelopersLogo;
	}
	public void setHouseDevelopersIntroduce(String houseDevelopersIntroduce) 
	{
		this.houseDevelopersIntroduce = houseDevelopersIntroduce;
	}

	public String getHouseDevelopersIntroduce() 
	{
		return houseDevelopersIntroduce;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("houseDevelopersNo", getHouseDevelopersNo())
            .append("houseDevelopersName", getHouseDevelopersName())
            .append("houseDevelopersLogo", getHouseDevelopersLogo())
            .append("houseDevelopersIntroduce", getHouseDevelopersIntroduce())
            .toString();
    }
}
