package com.ruoyi.project.global.subscribeInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 预约表 global_subscribe_info
 * 
 * @author ruoyi
 * @date 2019-02-20
 */
public class SubscribeInfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 房屋编码 */
	private String housesCode;
	/** 用户姓名 */
	private String name;
	/** 用户性别 */
	private String sex;
	/** 电话号码 */
	private String phoneNo;
	/** 微信号可为空 */
	private String wxNo;
	/** 邮箱 */
	private String emailNo;
	/** 备注 */
	private String note;

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
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setSex(String sex) 
	{
		this.sex = sex;
	}

	public String getSex() 
	{
		return sex;
	}
	public void setPhoneNo(String phoneNo) 
	{
		this.phoneNo = phoneNo;
	}

	public String getPhoneNo() 
	{
		return phoneNo;
	}
	public void setWxNo(String wxNo) 
	{
		this.wxNo = wxNo;
	}

	public String getWxNo() 
	{
		return wxNo;
	}
	public void setEmailNo(String emailNo) 
	{
		this.emailNo = emailNo;
	}

	public String getEmailNo() 
	{
		return emailNo;
	}
	public void setNote(String note) 
	{
		this.note = note;
	}

	public String getNote() 
	{
		return note;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("housesCode", getHousesCode())
            .append("name", getName())
            .append("sex", getSex())
            .append("phoneNo", getPhoneNo())
            .append("wxNo", getWxNo())
            .append("emailNo", getEmailNo())
            .append("note", getNote())
            .toString();
    }
}
