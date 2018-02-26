package com.isoftstone.dto.msg3;

import java.io.Serializable;

/**
 * 贷款
 */
public class LoanInfo  implements Serializable {
    private static final long serialVersionUID = 8106619325633628093L;
    private String message;//信息
    //账户状态 五级分类 本金余额 剩余还款期数 本月应还款 应还款日 本月实还款 最近一次还款日期
    private String loanacctState;//账户状态
    private String class5State;//五级分类
    private String balance;//本金余额
    private String remainpaymentcyc;//剩余还款期数
    private String scheduledpaymentamount;//本月应还款
    private String scheduledpaymentdate;//应还款日
    private String actualpaymentamount;//本月实还款
    private String recentpaydate;//最近一次还款日期
    //当前逾期期数 当前逾期金额 逾期31—60天未还本金 逾期61－90天未还本金 逾期91－180天未还本金 逾期180天以上未还本金
    private String curroverduecyc;//当前逾期期数
    private String curroverdueamount;//当前逾期金额
    private String overdue31to60amount;//当前逾期金额
    private String overdue61to90amount;//当前逾期金额
    private String overdue91to180amount;//当前逾期金额
    private String overdueover180amount;//当前逾期金额

    private String record;//还款记录
    private String repaymentstatus1;
    private String repaymentstatus2;
    private String repaymentstatus3;
    private String repaymentstatus4;
    private String repaymentstatus5;
    private String repaymentstatus6;
    private String repaymentstatus7;
    private String repaymentstatus8;
    private String repaymentstatus9;
    private String repaymentstatus10;
    private String repaymentstatus11;
    private String repaymentstatus12;
    private String repaymentstatus13;
    private String repaymentstatus14;
    private String repaymentstatus15;
    private String repaymentstatus16;
    private String repaymentstatus17;
    private String repaymentstatus18;
    private String repaymentstatus19;
    private String repaymentstatus20;
    private String repaymentstatus21;
    private String repaymentstatus22;
    private String repaymentstatus23;
    private String repaymentstatus24;

    public String getRepaymentstatus1() {
        return repaymentstatus1;
    }

    public void setRepaymentstatus1(String repaymentstatus1) {
        this.repaymentstatus1 = repaymentstatus1;
    }

    public String getRepaymentstatus2() {
        return repaymentstatus2;
    }

    public void setRepaymentstatus2(String repaymentstatus2) {
        this.repaymentstatus2 = repaymentstatus2;
    }

    public String getRepaymentstatus3() {
        return repaymentstatus3;
    }

    public void setRepaymentstatus3(String repaymentstatus3) {
        this.repaymentstatus3 = repaymentstatus3;
    }

    public String getRepaymentstatus4() {
        return repaymentstatus4;
    }

    public void setRepaymentstatus4(String repaymentstatus4) {
        this.repaymentstatus4 = repaymentstatus4;
    }

    public String getRepaymentstatus5() {
        return repaymentstatus5;
    }

    public void setRepaymentstatus5(String repaymentstatus5) {
        this.repaymentstatus5 = repaymentstatus5;
    }

    public String getRepaymentstatus6() {
        return repaymentstatus6;
    }

    public void setRepaymentstatus6(String repaymentstatus6) {
        this.repaymentstatus6 = repaymentstatus6;
    }

    public String getRepaymentstatus7() {
        return repaymentstatus7;
    }

    public void setRepaymentstatus7(String repaymentstatus7) {
        this.repaymentstatus7 = repaymentstatus7;
    }

    public String getRepaymentstatus8() {
        return repaymentstatus8;
    }

    public void setRepaymentstatus8(String repaymentstatus8) {
        this.repaymentstatus8 = repaymentstatus8;
    }

    public String getRepaymentstatus9() {
        return repaymentstatus9;
    }

    public void setRepaymentstatus9(String repaymentstatus9) {
        this.repaymentstatus9 = repaymentstatus9;
    }

    public String getRepaymentstatus10() {
        return repaymentstatus10;
    }

    public void setRepaymentstatus10(String repaymentstatus10) {
        this.repaymentstatus10 = repaymentstatus10;
    }

    public String getRepaymentstatus11() {
        return repaymentstatus11;
    }

    public void setRepaymentstatus11(String repaymentstatus11) {
        this.repaymentstatus11 = repaymentstatus11;
    }

    public String getRepaymentstatus12() {
        return repaymentstatus12;
    }

    public void setRepaymentstatus12(String repaymentstatus12) {
        this.repaymentstatus12 = repaymentstatus12;
    }

    public String getRepaymentstatus13() {
        return repaymentstatus13;
    }

    public void setRepaymentstatus13(String repaymentstatus13) {
        this.repaymentstatus13 = repaymentstatus13;
    }

    public String getRepaymentstatus14() {
        return repaymentstatus14;
    }

    public void setRepaymentstatus14(String repaymentstatus14) {
        this.repaymentstatus14 = repaymentstatus14;
    }

    public String getRepaymentstatus15() {
        return repaymentstatus15;
    }

    public void setRepaymentstatus15(String repaymentstatus15) {
        this.repaymentstatus15 = repaymentstatus15;
    }

    public String getRepaymentstatus16() {
        return repaymentstatus16;
    }

    public void setRepaymentstatus16(String repaymentstatus16) {
        this.repaymentstatus16 = repaymentstatus16;
    }

    public String getRepaymentstatus17() {
        return repaymentstatus17;
    }

    public void setRepaymentstatus17(String repaymentstatus17) {
        this.repaymentstatus17 = repaymentstatus17;
    }

    public String getRepaymentstatus18() {
        return repaymentstatus18;
    }

    public void setRepaymentstatus18(String repaymentstatus18) {
        this.repaymentstatus18 = repaymentstatus18;
    }

    public String getRepaymentstatus19() {
        return repaymentstatus19;
    }

    public void setRepaymentstatus19(String repaymentstatus19) {
        this.repaymentstatus19 = repaymentstatus19;
    }

    public String getRepaymentstatus20() {
        return repaymentstatus20;
    }

    public void setRepaymentstatus20(String repaymentstatus20) {
        this.repaymentstatus20 = repaymentstatus20;
    }

    public String getRepaymentstatus21() {
        return repaymentstatus21;
    }

    public void setRepaymentstatus21(String repaymentstatus21) {
        this.repaymentstatus21 = repaymentstatus21;
    }

    public String getRepaymentstatus22() {
        return repaymentstatus22;
    }

    public void setRepaymentstatus22(String repaymentstatus22) {
        this.repaymentstatus22 = repaymentstatus22;
    }

    public String getRepaymentstatus23() {
        return repaymentstatus23;
    }

    public void setRepaymentstatus23(String repaymentstatus23) {
        this.repaymentstatus23 = repaymentstatus23;
    }

    public String getRepaymentstatus24() {
        return repaymentstatus24;
    }

    public void setRepaymentstatus24(String repaymentstatus24) {
        this.repaymentstatus24 = repaymentstatus24;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLoanacctState() {
        return loanacctState;
    }

    public void setLoanacctState(String loanacctState) {
        this.loanacctState = loanacctState;
    }

    public String getClass5State() {
        return class5State;
    }

    public void setClass5State(String class5State) {
        this.class5State = class5State;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getRemainpaymentcyc() {
        return remainpaymentcyc;
    }

    public void setRemainpaymentcyc(String remainpaymentcyc) {
        this.remainpaymentcyc = remainpaymentcyc;
    }

    public String getScheduledpaymentamount() {
        return scheduledpaymentamount;
    }

    public void setScheduledpaymentamount(String scheduledpaymentamount) {
        this.scheduledpaymentamount = scheduledpaymentamount;
    }

    public String getScheduledpaymentdate() {
        return scheduledpaymentdate;
    }

    public void setScheduledpaymentdate(String scheduledpaymentdate) {
        this.scheduledpaymentdate = scheduledpaymentdate;
    }

    public String getActualpaymentamount() {
        return actualpaymentamount;
    }

    public void setActualpaymentamount(String actualpaymentamount) {
        this.actualpaymentamount = actualpaymentamount;
    }

    public String getRecentpaydate() {
        return recentpaydate;
    }

    public void setRecentpaydate(String recentpaydate) {
        this.recentpaydate = recentpaydate;
    }

    public String getCurroverduecyc() {
        return curroverduecyc;
    }

    public void setCurroverduecyc(String curroverduecyc) {
        this.curroverduecyc = curroverduecyc;
    }

    public String getCurroverdueamount() {
        return curroverdueamount;
    }

    public void setCurroverdueamount(String curroverdueamount) {
        this.curroverdueamount = curroverdueamount;
    }

    public String getOverdue31to60amount() {
        return overdue31to60amount;
    }

    public void setOverdue31to60amount(String overdue31to60amount) {
        this.overdue31to60amount = overdue31to60amount;
    }

    public String getOverdue61to90amount() {
        return overdue61to90amount;
    }

    public void setOverdue61to90amount(String overdue61to90amount) {
        this.overdue61to90amount = overdue61to90amount;
    }

    public String getOverdue91to180amount() {
        return overdue91to180amount;
    }

    public void setOverdue91to180amount(String overdue91to180amount) {
        this.overdue91to180amount = overdue91to180amount;
    }

    public String getOverdueover180amount() {
        return overdueover180amount;
    }

    public void setOverdueover180amount(String overdueover180amount) {
        this.overdueover180amount = overdueover180amount;
    }
}
