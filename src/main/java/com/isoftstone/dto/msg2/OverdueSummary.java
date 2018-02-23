package com.isoftstone.dto.msg2;

import java.io.Serializable;

/**
 * 逾期及违约信息概要
 */
public class OverdueSummary  implements Serializable {
    private static final long serialVersionUID = -3934499073636328294L;
    //贷款
    // 笔数 月份数 单月最高逾期总额 最长逾期月数
    private String count;
    private String months;
    private String highestoverdueamountpermon;
    private String maxDuration;
    //贷记卡
    // 账户数 月份数 单月最高透支余额 最长透支月数
    private String count2;
    private String months2;
    private String highestoverdueamountpermon2;
    private String maxDuration2;
    //准贷记卡60天以上
    //账户数 月份数 单月最高逾期总额 最长逾期月数
    private String count3;
    private String months3;
    private String highestoverdueamountpermon3;
    private String maxDuration3;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getMonths() {
        return months;
    }

    public void setMonths(String months) {
        this.months = months;
    }

    public String getHighestoverdueamountpermon() {
        return highestoverdueamountpermon;
    }

    public void setHighestoverdueamountpermon(String highestoverdueamountpermon) {
        this.highestoverdueamountpermon = highestoverdueamountpermon;
    }

    public String getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(String maxDuration) {
        this.maxDuration = maxDuration;
    }

    public String getCount2() {
        return count2;
    }

    public void setCount2(String count2) {
        this.count2 = count2;
    }

    public String getMonths2() {
        return months2;
    }

    public void setMonths2(String months2) {
        this.months2 = months2;
    }

    public String getHighestoverdueamountpermon2() {
        return highestoverdueamountpermon2;
    }

    public void setHighestoverdueamountpermon2(String highestoverdueamountpermon2) {
        this.highestoverdueamountpermon2 = highestoverdueamountpermon2;
    }

    public String getMaxDuration2() {
        return maxDuration2;
    }

    public void setMaxDuration2(String maxDuration2) {
        this.maxDuration2 = maxDuration2;
    }

    public String getCount3() {
        return count3;
    }

    public void setCount3(String count3) {
        this.count3 = count3;
    }

    public String getMonths3() {
        return months3;
    }

    public void setMonths3(String months3) {
        this.months3 = months3;
    }

    public String getHighestoverdueamountpermon3() {
        return highestoverdueamountpermon3;
    }

    public void setHighestoverdueamountpermon3(String highestoverdueamountpermon3) {
        this.highestoverdueamountpermon3 = highestoverdueamountpermon3;
    }

    public String getMaxDuration3() {
        return maxDuration3;
    }

    public void setMaxDuration3(String maxDuration3) {
        this.maxDuration3 = maxDuration3;
    }
}
