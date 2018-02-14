package com.isoftstone.dto.msg1;

/**
 * 居住信息
 */
public class House {
    //编号 居住地址 居住状况 信息更新日期
    private String no;
    private String address;
    private String status;
    private String updateTime;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
