package com.ruoyi.project.globalapp.main.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 服务城市表 global_service_city
 *
 * @author ruoyi
 * @date 2019-02-14
 */
public class City {
    private static final long serialVersionUID = 1L;

    /**
     * 城市编码
     */
    private String scopeTwoNo;
    /**
     * 国家编码
     */
    private String scopeOneNo;
    /**
     * 城市名
     */
    private String scopeTwoName;

    public void setScopeTwoNo(String scopeTwoNo) {
        this.scopeTwoNo = scopeTwoNo;
    }

    public String getScopeTwoNo() {
        return scopeTwoNo;
    }

    public void setScopeOneNo(String scopeOneNo) {
        this.scopeOneNo = scopeOneNo;
    }

    public String getScopeOneNo() {
        return scopeOneNo;
    }

    public void setScopeTwoName(String scopeTwoName) {
        this.scopeTwoName = scopeTwoName;
    }

    public String getScopeTwoName() {
        return scopeTwoName;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("scopeTwoNo", getScopeTwoNo())
                .append("scopeOneNo", getScopeOneNo())
                .append("scopeTwoName", getScopeTwoName())
                .toString();
    }
}
