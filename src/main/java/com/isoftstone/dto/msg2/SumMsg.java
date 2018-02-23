package com.isoftstone.dto.msg2;

/**
 * 信息概要
 */
public class SumMsg {
    private Creditcue creditcue;
    private OverdueSummary overdueSummary;
    private UnpaidLoan unpaidLoan;
    private UndestoryLoancard undestoryLoancard;

    public Creditcue getCreditcue() {
        return creditcue;
    }

    public void setCreditcue(Creditcue creditcue) {
        this.creditcue = creditcue;
    }

    public OverdueSummary getOverdueSummary() {
        return overdueSummary;
    }

    public void setOverdueSummary(OverdueSummary overdueSummary) {
        this.overdueSummary = overdueSummary;
    }

    public UnpaidLoan getUnpaidLoan() {
        return unpaidLoan;
    }

    public void setUnpaidLoan(UnpaidLoan unpaidLoan) {
        this.unpaidLoan = unpaidLoan;
    }

    public UndestoryLoancard getUndestoryLoancard() {
        return undestoryLoancard;
    }

    public void setUndestoryLoancard(UndestoryLoancard undestoryLoancard) {
        this.undestoryLoancard = undestoryLoancard;
    }
}
