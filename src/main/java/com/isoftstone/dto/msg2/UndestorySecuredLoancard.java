package com.isoftstone.dto.msg2;/*
 * @package_name com.isoftstone.dto.msg2
 * @date 2018/2/23 11:36  
 * @user Eaton
 */

import java.io.Serializable;

//未销户准贷记卡信息汇总
public class UndestorySecuredLoancard implements Serializable {
    private static final long serialVersionUID = -969713014467087858L;
    //发卡法人机构数  发卡机构数 账户数 授信总额 单家行最高授信额 单家行最低授信额 已用额度 最近6个月平均使用额度
    private String financecorpCount;
    private String financeorgCount;
    private String accountCount;
    private String creditlimit;
    private String maxcreditlimitperorg;
    private String mincreditlimitperorg;
    private String usedcreditlimit;
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

    public String getCreditlimit() {
        return creditlimit;
    }

    public void setCreditlimit(String creditlimit) {
        this.creditlimit = creditlimit;
    }

    public String getMaxcreditlimitperorg() {
        return maxcreditlimitperorg;
    }

    public void setMaxcreditlimitperorg(String maxcreditlimitperorg) {
        this.maxcreditlimitperorg = maxcreditlimitperorg;
    }

    public String getMincreditlimitperorg() {
        return mincreditlimitperorg;
    }

    public void setMincreditlimitperorg(String mincreditlimitperorg) {
        this.mincreditlimitperorg = mincreditlimitperorg;
    }

    public String getUsedcreditlimit() {
        return usedcreditlimit;
    }

    public void setUsedcreditlimit(String usedcreditlimit) {
        this.usedcreditlimit = usedcreditlimit;
    }

    public String getLatest6monthusedavgamount() {
        return latest6monthusedavgamount;
    }

    public void setLatest6monthusedavgamount(String latest6monthusedavgamount) {
        this.latest6monthusedavgamount = latest6monthusedavgamount;
    }
}
