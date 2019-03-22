package com.ruoyi.project.global.imgBanner.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * Banner管理表 global_img_banner
 * 
 * @author ruoyi
 * @date 2019-02-13
 */
public class ImgBanner extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private String id;
	/** 图片地址 */
	private String imgPath;
	/** 图片的显示的状态 */
	private Integer imgHide;

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setImgPath(String imgPath) 
	{
		this.imgPath = imgPath;
	}

	public String getImgPath() 
	{
		return imgPath;
	}
	public void setImgHide(Integer imgHide) 
	{
		this.imgHide = imgHide;
	}

	public Integer getImgHide() 
	{
		return imgHide;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("imgPath", getImgPath())
            .append("imgHide", getImgHide())
            .toString();
    }
}
