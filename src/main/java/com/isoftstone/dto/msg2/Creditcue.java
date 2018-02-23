package com.isoftstone.dto.msg2;

import java.io.Serializable;

/**
 * 信用提示
 */
public class Creditcue  implements Serializable {
    private static final long serialVersionUID = -5673753132022108427L;
    //个人住房贷款笔数
    //个人商用房（包括商住两用）贷款笔数
    //其他贷款笔数
    //首笔贷款发放月份
    //贷记卡账户数
    //首张贷记卡发卡月份
    //准贷记卡账户数
    //首张准贷记卡发卡月份
    //本人声明数目
    // 异议标注数目
    private String houseloanCount;
    private String houseloan2Count;
    private String otherloanCount;
    private String firstloanopenMonth;
    private String loancardCount;
    private String firstloancardopenMonth;
    private String standardloancardCount;
    private String firststandardloancardopenMonth;
    private String announceCount;
    private String dissentCount;

    public String getHouseloanCount() {
        return houseloanCount;
    }

    public void setHouseloanCount(String houseloanCount) {
        this.houseloanCount = houseloanCount;
    }

    public String getHouseloan2Count() {
        return houseloan2Count;
    }

    public void setHouseloan2Count(String houseloan2Count) {
        this.houseloan2Count = houseloan2Count;
    }

    public String getOtherloanCount() {
        return otherloanCount;
    }

    public void setOtherloanCount(String otherloanCount) {
        this.otherloanCount = otherloanCount;
    }

    public String getFirstloanopenMonth() {
        return firstloanopenMonth;
    }

    public void setFirstloanopenMonth(String firstloanopenMonth) {
        this.firstloanopenMonth = firstloanopenMonth;
    }

    public String getLoancardCount() {
        return loancardCount;
    }

    public void setLoancardCount(String loancardCount) {
        this.loancardCount = loancardCount;
    }

    public String getFirstloancardopenMonth() {
        return firstloancardopenMonth;
    }

    public void setFirstloancardopenMonth(String firstloancardopenMonth) {
        this.firstloancardopenMonth = firstloancardopenMonth;
    }

    public String getStandardloancardCount() {
        return standardloancardCount;
    }

    public void setStandardloancardCount(String standardloancardCount) {
        this.standardloancardCount = standardloancardCount;
    }

    public String getFirststandardloancardopenMonth() {
        return firststandardloancardopenMonth;
    }

    public void setFirststandardloancardopenMonth(String firststandardloancardopenMonth) {
        this.firststandardloancardopenMonth = firststandardloancardopenMonth;
    }

    public String getAnnounceCount() {
        return announceCount;
    }

    public void setAnnounceCount(String announceCount) {
        this.announceCount = announceCount;
    }

    public String getDissentCount() {
        return dissentCount;
    }

    public void setDissentCount(String dissentCount) {
        this.dissentCount = dissentCount;
    }
}
