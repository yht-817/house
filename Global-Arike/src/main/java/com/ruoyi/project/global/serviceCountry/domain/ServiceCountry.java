package com.ruoyi.project.global.serviceCountry.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 国家管理表 global_service_country
 * 
 * @author ruoyi
 * @date 2019-02-13
 */
public class ServiceCountry extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 国家编码 */
	private String scopeOneNo;
	/** 国家名称 */
	private String scopeOneName;
	/** 图标 */
	private String scopeTwoIcon;

	public void setScopeOneNo(String scopeOneNo) 
	{
		this.scopeOneNo = scopeOneNo;
	}

	public String getScopeOneNo() 
	{
		return scopeOneNo;
	}
	public void setScopeOneName(String scopeOneName) 
	{
		this.scopeOneName = scopeOneName;
	}

	public String getScopeOneName() 
	{
		return scopeOneName;
	}
	public void setScopeTwoIcon(String scopeTwoIcon) 
	{
		this.scopeTwoIcon = scopeTwoIcon;
	}

	public String getScopeTwoIcon() 
	{
		return scopeTwoIcon;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("scopeOneNo", getScopeOneNo())
            .append("scopeOneName", getScopeOneName())
            .append("scopeTwoIcon", getScopeTwoIcon())
            .toString();
    }
}
