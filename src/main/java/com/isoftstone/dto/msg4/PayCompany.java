package com.isoftstone.dto.msg4;/*
 * @package_name com.isoftstone.dto.msg4
 * @date 2018/2/14 22:35  
 * @user Eaton
 */

public class PayCompany {
    //缴费单位 信息更新日期
    private String no;
    private String company;
    private String updateDate;
    public String getCompany() {
        return company;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
