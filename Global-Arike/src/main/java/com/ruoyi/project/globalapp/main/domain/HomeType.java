package com.ruoyi.project.globalapp.main.domain;

/**
 * 房屋类型
 */
public class HomeType {
    private int typeNo;
    private String type;

    public int getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(int typeNo) {
        this.typeNo = typeNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "HomeType{" +
                "typeNo=" + typeNo +
                ", type='" + type + '\'' +
                '}';
    }
}
