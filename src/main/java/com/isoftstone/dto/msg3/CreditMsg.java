package com.isoftstone.dto.msg3;

import java.io.Serializable;
import java.util.List;

/**
 * 信贷交易信息明细
 */
public class CreditMsg  implements Serializable {
    private static final long serialVersionUID = 6349493897715150543L;
    private List<LoancardInfo> loancardInfos;
    private List<LoanInfo> loans;

    public List<LoancardInfo> getLoancardInfos() {
        return loancardInfos;
    }

    public void setLoancardInfos(List<LoancardInfo> loancardInfos) {
        this.loancardInfos = loancardInfos;
    }

    public List<LoanInfo> getLoans() {
        return loans;
    }

    public void setLoans(List<LoanInfo> loans) {
        this.loans = loans;
    }
}
