package com.ruoyi.project.global.comments.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 资讯评论表 global_comments
 * 
 * @author ruoyi
 * @date 2019-03-05
 */
public class Comments extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 评论编码 */
	private String commentNo;
	/** 资讯编码 */
	private String informationNo;
	/** 用户编码 */
	private String userNo;
	/** 评论内容 */
	private String content;
	/** 时间 */
	private Date commentTime;

	public void setCommentNo(String commentNo) 
	{
		this.commentNo = commentNo;
	}

	public String getCommentNo() 
	{
		return commentNo;
	}
	public void setInformationNo(String informationNo) 
	{
		this.informationNo = informationNo;
	}

	public String getInformationNo() 
	{
		return informationNo;
	}
	public void setUserNo(String userNo) 
	{
		this.userNo = userNo;
	}

	public String getUserNo() 
	{
		return userNo;
	}
	public void setContent(String content) 
	{
		this.content = content;
	}

	public String getContent() 
	{
		return content;
	}
	public void setCommentTime(Date commentTime) 
	{
		this.commentTime = commentTime;
	}

	public Date getCommentTime() 
	{
		return commentTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("commentNo", getCommentNo())
            .append("informationNo", getInformationNo())
            .append("userNo", getUserNo())
            .append("content", getContent())
            .append("commentTime", getCommentTime())
            .toString();
    }
}
