package com.isoftstone.dto.msg2;

import java.io.Serializable;

/**
 * 授信及负债信息概要
 */
public class UnpaidLoan  implements Serializable {
    private static final long serialVersionUID = 3860050959151948613L;
    //贷款法人机构数 贷款机构数 笔数 合同总额 余额 最近6个月平均应还款
    private String financecorpCount;
    private String financeorgCount;
    private String accountCount;
    private String creditLimit;
    private String balance;
    private String latest6monthusedavgamount;


    public String getFinancecorpCount() {
        return financecorpCount;
    }

    public void setFinancecorpCount(String financecorpCount) {
        this.financecorpCount = financecorpCount;
    }

    public String getFinanceorgCount() {
        return financeorgCount;
    }

    public void setFinanceorgCount(String financeorgCount) {
        this.financeorgCount = financeorgCount;
    }

    public String getAccountCount() {
        return accountCount;
    }

    public void setAccountCount(String accountCount) {
        this.accountCount = accountCount;
    }

    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getLatest6monthusedavgamount() {
        return latest6monthusedavgamount;
    }

    public void setLatest6monthusedavgamount(String latest6monthusedavgamount) {
        this.latest6monthusedavgamount = latest6monthusedavgamount;
    }


}
