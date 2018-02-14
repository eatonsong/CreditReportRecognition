package com.isoftstone.dto.msg3;

import java.util.List;

/**
 * 信贷交易信息明细
 */
public class CreditMsg {
    private List<Card> cards;
    private List<Loans> loans;

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Loans> getLoans() {
        return loans;
    }

    public void setLoans(List<Loans> loans) {
        this.loans = loans;
    }
}
