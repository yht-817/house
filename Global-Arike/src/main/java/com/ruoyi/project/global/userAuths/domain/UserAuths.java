package com.ruoyi.project.global.userAuths.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 用户认证表 global_user_auths
 * 
 * @author ruoyi
 * @date 2019-02-12
 */
public class UserAuths extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 用户编码 */
	private String userNo;
	/** 应用Key */
	private String thirdKey;
	/** 应用类型 */
	private String thirdType;
	/** 绑定日期 */
	private Date thirdDate;

	public void setUserNo(String userNo) 
	{
		this.userNo = userNo;
	}

	public String getUserNo() 
	{
		return userNo;
	}
	public void setThirdKey(String thirdKey) 
	{
		this.thirdKey = thirdKey;
	}

	public String getThirdKey() 
	{
		return thirdKey;
	}
	public void setThirdType(String thirdType) 
	{
		this.thirdType = thirdType;
	}

	public String getThirdType() 
	{
		return thirdType;
	}
	public void setThirdDate(Date thirdDate) 
	{
		this.thirdDate = thirdDate;
	}

	public Date getThirdDate() 
	{
		return thirdDate;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userNo", getUserNo())
            .append("thirdKey", getThirdKey())
            .append("thirdType", getThirdType())
            .append("thirdDate", getThirdDate())
            .toString();
    }
}
