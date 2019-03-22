package com.ruoyi.project.globalapp.main.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Banner管理表 global_img_banner
 *
 * @author ruoyi
 * @date 2019-02-13
 */
public class ImgBanners {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private String id;
    /**
     * 图片地址
     */
    private String imgPath;
    /**
     * 图片的显示的状态
     */
    private Integer imgHide;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgHide(Integer imgHide) {
        this.imgHide = imgHide;
    }

    public Integer getImgHide() {
        return imgHide;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("imgPath", getImgPath())
                .append("imgHide", getImgHide())
                .toString();
    }
}
