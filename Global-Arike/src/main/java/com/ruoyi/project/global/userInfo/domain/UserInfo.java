package com.ruoyi.project.global.userInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 用户基础表 global_user_info
 * 
 * @author ruoyi
 * @date 2019-02-12
 */
public class UserInfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 用户编码 */
	private String userNo;
	/** 头像 */
	private String userHead;
	/** 昵称 */
	private String nickName;
	/** 用户性别 */
	private String sexNo;
	/** 手机号 */
	private String phoneNo;
	/** 电话代码（区号） */
	private String phoneCode;
	/** 邮箱 */
	private String mailboxNo;
	/** 登录口令 */
	private String password;
	/** 注册日期 */
	private Date regionDate;
	/** 最后登录日期 */
	private Date lastLoginDate;
	/** 用户状态 */
	private String userState;
	/** 用户等级 */
	private String userGrade;
	/** 用户等级变更日期 */
	private Date userGradeChangeDate;
	/** 用户签名 */
	private String userSign;
	/** 常住地 */
	private String userLocal;

	public void setUserNo(String userNo) 
	{
		this.userNo = userNo;
	}

	public String getUserNo() 
	{
		return userNo;
	}
	public void setUserHead(String userHead) 
	{
		this.userHead = userHead;
	}

	public String getUserHead() 
	{
		return userHead;
	}
	public void setNickName(String nickName) 
	{
		this.nickName = nickName;
	}

	public String getNickName() 
	{
		return nickName;
	}
	public void setSexNo(String sexNo) 
	{
		this.sexNo = sexNo;
	}

	public String getSexNo() 
	{
		return sexNo;
	}
	public void setPhoneNo(String phoneNo) 
	{
		this.phoneNo = phoneNo;
	}

	public String getPhoneNo() 
	{
		return phoneNo;
	}
	public void setPhoneCode(String phoneCode) 
	{
		this.phoneCode = phoneCode;
	}

	public String getPhoneCode() 
	{
		return phoneCode;
	}
	public void setMailboxNo(String mailboxNo) 
	{
		this.mailboxNo = mailboxNo;
	}

	public String getMailboxNo() 
	{
		return mailboxNo;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getPassword() 
	{
		return password;
	}
	public void setRegionDate(Date regionDate) 
	{
		this.regionDate = regionDate;
	}

	public Date getRegionDate() 
	{
		return regionDate;
	}
	public void setLastLoginDate(Date lastLoginDate) 
	{
		this.lastLoginDate = lastLoginDate;
	}

	public Date getLastLoginDate() 
	{
		return lastLoginDate;
	}
	public void setUserState(String userState) 
	{
		this.userState = userState;
	}

	public String getUserState() 
	{
		return userState;
	}
	public void setUserGrade(String userGrade) 
	{
		this.userGrade = userGrade;
	}

	public String getUserGrade() 
	{
		return userGrade;
	}
	public void setUserGradeChangeDate(Date userGradeChangeDate) 
	{
		this.userGradeChangeDate = userGradeChangeDate;
	}

	public Date getUserGradeChangeDate() 
	{
		return userGradeChangeDate;
	}
	public void setUserSign(String userSign) 
	{
		this.userSign = userSign;
	}

	public String getUserSign() 
	{
		return userSign;
	}
	public void setUserLocal(String userLocal) 
	{
		this.userLocal = userLocal;
	}

	public String getUserLocal() 
	{
		return userLocal;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userNo", getUserNo())
            .append("userHead", getUserHead())
            .append("nickName", getNickName())
            .append("sexNo", getSexNo())
            .append("phoneNo", getPhoneNo())
            .append("phoneCode", getPhoneCode())
            .append("mailboxNo", getMailboxNo())
            .append("password", getPassword())
            .append("regionDate", getRegionDate())
            .append("lastLoginDate", getLastLoginDate())
            .append("userState", getUserState())
            .append("userGrade", getUserGrade())
            .append("userGradeChangeDate", getUserGradeChangeDate())
            .append("userSign", getUserSign())
            .append("userLocal", getUserLocal())
            .toString();
    }
}
