package com.isoftstone.dto.msg4;/*
 * @package_name com.isoftstone.dto.msg4
 * @date 2018/2/14 20:56  
 * @user Eaton
 */

import java.io.Serializable;
import java.util.List;

public class CommonMsg  implements Serializable {
    private static final long serialVersionUID = 2368166455928847821L;
    private List<AccfundRecord> accfundRecords;
    private List<AccfundCompany> payCompanies;

    public List<AccfundRecord> getAccfundRecords() {
        return accfundRecords;
    }

    public List<AccfundCompany> getPayCompanies() {
        return payCompanies;
    }

    public void setPayCompanies(List<AccfundCompany> payCompanies) {
        this.payCompanies = payCompanies;
    }

    public void setAccfundRecords(List<AccfundRecord> accfundRecords) {
        this.accfundRecords = accfundRecords;
    }
}
