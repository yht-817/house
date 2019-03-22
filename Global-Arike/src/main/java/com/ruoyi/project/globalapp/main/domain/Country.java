package com.ruoyi.project.globalapp.main.domain;

import java.util.List;

/**
 * 国家管理表 global_service_country
 *
 * @author ruoyi
 * @date 2019-02-13
 */
public class Country {
    private static final long serialVersionUID = 1L;

    /**
     * 国家编码
     */
    private String scopeOneNo;
    /**
     * 国家名称
     */
    private String scopeOneName;
    /**
     * 图标
     */
    private String scopeTwoIcon;

    /**
     * 国家对应的城市
     */
    private List<City> childrens;

    public void setScopeOneNo(String scopeOneNo) {
        this.scopeOneNo = scopeOneNo;
    }

    public String getScopeOneNo() {
        return scopeOneNo;
    }

    public void setScopeOneName(String scopeOneName) {
        this.scopeOneName = scopeOneName;
    }

    public String getScopeOneName() {
        return scopeOneName;
    }

    public void setScopeTwoIcon(String scopeTwoIcon) {
        this.scopeTwoIcon = scopeTwoIcon;
    }

    public String getScopeTwoIcon() {
        return scopeTwoIcon;
    }

    public List<City> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<City> childrens) {
        this.childrens = childrens;
    }

    @Override
    public String toString() {
        return "Country{" +
                "scopeOneNo='" + scopeOneNo + '\'' +
                ", scopeOneName='" + scopeOneName + '\'' +
                ", scopeTwoIcon='" + scopeTwoIcon + '\'' +
                ", childrens=" + childrens +
                '}';
    }
}
