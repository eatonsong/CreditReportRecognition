package com.isoftstone.app;/*
 * @package_name com.isoftstone.app
 * @date 2018/2/12 15:00  
 * @user Eaton
 */

import com.alibaba.fastjson.JSON;
import com.isoftstone.dto.Messages;
import com.isoftstone.dto.msg1.*;
import com.isoftstone.dto.msg2.*;
import com.isoftstone.dto.msg3.CreditMsg;
import com.isoftstone.dto.msg3.LoanInfo;
import com.isoftstone.dto.msg3.LoancardInfo;
import com.isoftstone.dto.msg4.AccfundCompany;
import com.isoftstone.dto.msg4.AccfundRecord;
import com.isoftstone.dto.msg4.CommonMsg;
import com.isoftstone.dto.msg5.RecordDetail;
import com.isoftstone.dto.msg5.RecordSummary;
import com.isoftstone.util.PdfboxUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.IOException;
import java.util.regex.Pattern;

public class Test {
    private static XStream xStream;

    public static void main(String[] args) throws IOException {
        Messages msg = new PdfboxUtil().getMessages("/pdf/001.pdf");
        String jsonStr = JSON.toJSONString(msg);
        System.out.println(jsonStr);
/*        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + xStream.toXML(msg)+"</xml>";
        System.out.println(xml);*/
    }
    static {
        xStream = new XStream(new DomDriver());
        xStream.alias("Messages",Messages.class);
        xStream.alias("BaseMsg",BaseMsg.class);
        xStream.alias("BaseMsgData",BaseMsgData.class);
        xStream.alias("Professional",Professional.class);
        xStream.alias("ProfessionalData",ProfessionalData.class);
        xStream.alias("Residence",Residence.class);
        xStream.alias("ResidenceData",ResidenceData.class);
        xStream.alias("Spouse",Spouse.class);
        xStream.alias("Creditcue",Creditcue.class);
        xStream.alias("OverdueSummary",OverdueSummary.class);
        xStream.alias("SumMsg",SumMsg.class);
        xStream.alias("UndestoryLoancard",UndestoryLoancard.class);
        xStream.alias("UnpaidLoan",UnpaidLoan.class);
        xStream.alias("CreditMsg",CreditMsg.class);
        xStream.alias("LoancardInfo",LoancardInfo.class);
        xStream.alias("LoanInfo",LoanInfo.class);
        xStream.alias("AccfundCompany",AccfundCompany.class);
        xStream.alias("AccfundRecord",AccfundRecord.class);
        xStream.alias("CommonMsg",CommonMsg.class);
        xStream.alias("RecordDetail",RecordDetail.class);
        xStream.alias("RecordSummary",RecordSummary.class);
    }
}
