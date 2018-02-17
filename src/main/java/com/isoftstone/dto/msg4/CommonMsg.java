package com.isoftstone.dto.msg4;/*
 * @package_name com.isoftstone.dto.msg4
 * @date 2018/2/14 20:56  
 * @user Eaton
 */

import java.util.List;

public class CommonMsg {
    private List<PayRecord> payRecords;
    private List<PayCompany> payCompanies;

    public List<PayRecord> getPayRecords() {
        return payRecords;
    }

    public List<PayCompany> getPayCompanies() {
        return payCompanies;
    }

    public void setPayCompanies(List<PayCompany> payCompanies) {
        this.payCompanies = payCompanies;
    }

    public void setPayRecords(List<PayRecord> payRecords) {
        this.payRecords = payRecords;
    }
}
