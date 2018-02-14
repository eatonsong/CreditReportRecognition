package com.isoftstone.dto.msg2;

/**
 * 信息概要
 */
public class SumMsg {
    private Tips tips;
    private Overdue overdue;
    private Credit credit;

    public Tips getTips() {
        return tips;
    }

    public void setTips(Tips tips) {
        this.tips = tips;
    }

    public Overdue getOverdue() {
        return overdue;
    }

    public void setOverdue(Overdue overdue) {
        this.overdue = overdue;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }
}
