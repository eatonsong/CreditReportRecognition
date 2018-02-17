package com.isoftstone.dto.msg5;/*
 * @package_name com.isoftstone.dto.msg5
 * @date 2018/2/14 22:55  
 * @user Eaton
 */

import java.util.List;

/**
 * 查询记录
 */
public class QueryMsg {
   // 贷款审批 信用卡审批 贷款审批 信用卡审批 本人查询 贷后管理 担保资格审查 特约商户实名审查
    private String loans;
    private String card;
    private String loansNum;
    private String cardNum;
    private String personNum;
    private String management;
    private String guarantee;
    private String special;
    //详细信息
    private List<QueryCom> company;
    private List<QueryCom> person;

    public String getLoans() {
        return loans;
    }

    public void setLoans(String loans) {
        this.loans = loans;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getLoansNum() {
        return loansNum;
    }

    public void setLoansNum(String loansNum) {
        this.loansNum = loansNum;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getPersonNum() {
        return personNum;
    }

    public void setPersonNum(String personNum) {
        this.personNum = personNum;
    }

    public String getManagement() {
        return management;
    }

    public void setManagement(String management) {
        this.management = management;
    }

    public String getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(String guarantee) {
        this.guarantee = guarantee;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public List<QueryCom> getCompany() {
        return company;
    }

    public void setCompany(List<QueryCom> company) {
        this.company = company;
    }

    public List<QueryCom> getPerson() {
        return person;
    }

    public void setPerson(List<QueryCom> person) {
        this.person = person;
    }
}
