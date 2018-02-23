package com.isoftstone.util;

/*@package_name com.isoftstone.util
 * @date 2018/2/11 14:52
 * @user Eaton*/

import com.isoftstone.dto.*;
import com.isoftstone.dto.msg1.*;
import com.isoftstone.dto.msg2.*;
import com.isoftstone.dto.msg3.LoancardInfo;
import com.isoftstone.dto.msg3.CreditMsg;
import com.isoftstone.dto.msg3.LoanInfo;
import com.isoftstone.dto.msg4.CommonMsg;
import com.isoftstone.dto.msg4.AccfundCompany;
import com.isoftstone.dto.msg4.AccfundRecord;
import com.isoftstone.dto.msg5.RecordSummary;
import com.isoftstone.dto.msg5.RecordDetail;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import static java.util.regex.Pattern.*;

public class PdfboxUtil {


    PDDocument document;
    public Messages getMessages(String pdfPath){
        //String pdfPath = "src/main/resources/pdf/001.pdf";
        try {
            this.getDocument(pdfPath);
            Messages msg = this.getTextByArea();
            String content = this.getTextFromPdf();
            String regex1 = ".*(页码.*\r\n).*";
            String regex2 = ".*(Page.*\r\n).*";
            content = content.replaceAll(regex1, "");
            content = content.replaceAll(regex2, "");
            String content0 = content.replaceAll("\r\n","");
            content = content.replaceAll("\r\n", " ");
            Matcher m = compile("个人基本信息(.*?)信息概要").matcher(content);
            Matcher mm = compile("信息概要(.*?)三 信贷交易信息明细").matcher(content);
            Matcher mmm = compile("三 信贷交易信息明细(.*?)四 公共信息明细").matcher(content);
            Matcher mmmm = compile("四 公共信息明细(.*?)五 查询记录").matcher(content);
            Matcher mmmmm = compile("五 查询记录(.*?)报告说明").matcher(content);
            String baseMsg = null;
            String sumMsg = null;
            String creditMsg = null;
            String commonMsg = null;
            String queryMsg = null;
            if (m.find()) {
                baseMsg = m.group(1);
            }
            if(mm.find()){
                sumMsg = mm.group(1);
            }
            if(mmm.find()){
                creditMsg = mmm.group(1);
            }
            if(mmmm.find()){
                commonMsg = mmmm.group(1);
            }
            if(mmmmm.find()){
                queryMsg = mmmmm.group(1);
            }

            BaseMsg base = new BaseMsg();
            BaseMsgData baseData = new BaseMsgData();
            if (baseMsg != null) {
                Matcher m1 = compile("手机号码(.*?)数据发生机构名称").matcher(baseMsg);
                //性别 出生日期 婚姻状况 手机号码
                if (m1.find()) {
                    String s1 = m1.group(1).trim();
                    String ss[] = s1.split(" +");
                    if (ss.length != 0) {
                        try {
                            base.setGender(ss[0]);
                            base.setBirthday(ss[1]);
                            base.setMaritalstate(ss[2]);
                            base.setMobile(ss[3]);
                            baseMsg = baseMsg.split(m1.group(1))[1];
                        } catch (ArrayIndexOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }
                }
                Matcher m2 = compile("数据发生机构名称(.*?)单位电话").matcher(baseMsg);
                if (m2.find()) {
                    String s2 = m2.group(1).replaceAll("数据发生机构名称", "").trim();
                    String ss[] = s2.split(" +");
                    if (ss.length != 0) {
                        try {
                            baseData.setGender(ss[0]);
                            baseData.setBirthday(ss[1]);
                            baseData.setMaritalstate(ss[2]);
                            baseData.setMobile(ss[3]);
                            baseMsg = baseMsg.split(m2.group(1))[1];
                        } catch (ArrayIndexOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }
                }
                //单位电话 住宅电话 学历 学位
                Matcher m3 = compile("学位(.*?)数据发生机构名称").matcher(baseMsg);
                if (m3.find()) {
                    String s1 = m3.group(1).trim();
                    String ss[] = s1.split(" +");
                    if (ss.length != 0) {
                        try {
                            base.setOfficetelePhoneNo(ss[0]);
                            base.setHometelePhoneNo(ss[1]);
                            base.setEdulevel(ss[2]);
                            base.setEdudegree(ss[3]);
                            baseMsg = baseMsg.split(m3.group(1))[1];
                        } catch (ArrayIndexOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }
                }
                Matcher m4 = compile("数据发生机构名称(.*?)通讯地址").matcher(baseMsg);
                if (m4.find()) {
                    String s2 = m4.group(1).replaceAll("数据发生机构名称", "").trim();
                    String ss[] = s2.split(" +");
                    if (ss.length != 0) {
                        try {
                            baseData.setOfficetelePhoneNo(ss[0]);
                            baseData.setHometelePhoneNo(ss[1]);
                            baseData.setEdulevel(ss[2]);
                            baseData.setEdudegree(ss[3]);
                            baseMsg = baseMsg.split(m4.group(1))[1];
                        } catch (ArrayIndexOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }
                }
                Matcher m5 = compile("户籍地址(.*?)数据发生机构名称").matcher(baseMsg);
                //通讯地址 户籍地址
                if (m5.find()) {
                    String s1 = m5.group(1).trim();
                    String ss[] = s1.split(" +");
                    if(ss.length!=2){
                        ss=s1.split("  ");
                    }
                    if (ss.length != 0) {
                        try {
                            base.setPostaddress(ss[0]);
                            base.setRegisteredaddress(ss[1]);
                            baseMsg = baseMsg.split(m5.group(1))[1];
                        } catch (ArrayIndexOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }
                }
                Matcher m6 = compile("数据发生机构名称(.*?)配偶信息").matcher(baseMsg);
                if (m6.find()) {
                    String s2 = m6.group(1).replaceAll("数据发生机构名称", "").trim();
                    String ss[] = s2.split(" +");
                    if (ss.length != 0) {
                        try {
                            baseData.setPostaddress(ss[0]);
                            baseData.setRegisteredaddress(ss[1]);
                            baseMsg = baseMsg.split(m6.group(1))[1];
                        } catch (ArrayIndexOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }
                }
                Matcher m7 = compile("联系电话(.*?)数据发生机构名称").matcher(baseMsg);
                //姓名 证件类型 证件号码 工作单位 联系电话 配偶
                if (m7.find()) {
                    Spouse spouse = new Spouse();
                    String s1 = m7.group(1).trim();
                    String ss[] = s1.split(" +");
                    if (ss.length != 0) {
                        try {
                            spouse.setName(ss[0]);
                            spouse.setCerttype(ss[1]);
                            spouse.setCertno(ss[2]);
                            spouse.setEmployer(ss[3]);
                            spouse.setTelephoneno(ss[4]);
                            baseMsg = baseMsg.split(m7.group(1))[1];
                        } catch (ArrayIndexOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }
                    base.setSpouse(spouse);
                }
                Matcher m8 = compile("数据发生机构名称(.*?)居住信息").matcher(baseMsg);
                if (m8.find()) {
                    String s2 = m8.group(1).replaceAll("数据发生机构名称", "").trim();
                    baseData.setSpouse(s2);
                    int num=baseMsg.indexOf(m8.group(1));
                    baseMsg = baseMsg.substring(num);
                }
                Matcher ma = compile("信息更新日期(.*?)编号").matcher(baseMsg);
                if (ma.find()) {
                    String s1 = ma.group(1).trim();
                    String ss[] = s1.split(" +");
                    //编号 居住地址 居住状况 信息更新日期
                    List la = new ArrayList();
                    try {
                        for (int i = 0; i < ss.length ; i=i+4) {
                            Residence residence = new Residence();
                            residence.setSortno(ss[i]);
                            residence.setAddress(ss[i+1]);
                            residence.setResidencetype(ss[i+2]);
                            residence.setGettime(ss[i+3]);
                            la.add(residence);
                        }
                        base.setResidences(la);
                        baseMsg = baseMsg.split(ma.group(1))[1];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }
                }
                //居住信息数据
                Matcher mb = compile("数据发生机构名称(.*?)职业信息").matcher(baseMsg);
                if (mb.find()) {
                    String s2 = mb.group(1).replaceAll("数据发生机构名称", "").trim();
                    String ss[] = s2.split(" +");
                    //编号
                    List la = new ArrayList();
                    try {
                        for (int i = 0; i < ss.length ; i=i+2) {
                            ResidenceData house =new ResidenceData();
                            house.setNo(ss[i]);
                            house.setData(ss[i+1]);
                            la.add(house);
                        }
                        baseData.setResidenceData(la);
                        baseMsg = baseMsg.split(mb.group(1))[1];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }
                }
                //工作信息1
                Matcher mc = compile("单位地址(.*?)编号").matcher(baseMsg);
                if (mc.find()) {
                    String s1 = mc.group(1).trim();
                    String ss1[] = s1.split(" +");
                    //编号
                    List la = new ArrayList();
                    try {
                        List<Integer> ll = new ArrayList();
                        for (int j = 0; j <ss1.length ; j++) {
                            if(ss1[j].replaceAll(" ","").trim().matches("[0-9]{1}")){
                               ll.add(j);
                            }
                        }
                        for (int l = 0; l < ll.size(); l++) {
                            Professional professional = new Professional();
                            professional.setSortno(ss1[ll.get(l)]);
                            professional.setEmployer(ss1[ll.get(l)+1]);
                            int num = 1;
                            if(l<ll.size()-1){
                                num = ll.get(l+1)-ll.get(l)-2;
                            }
                            String workms = "";
                            while(num >=1){
                                workms+=ss1[ll.get(l)+1+num];
                                if(num == 1){
                                    break;
                                }
                                num --;
                            }
                            professional.setEmployerAddress(workms);
                            la.add(professional);
                        }
                        base.setProfessionals(la);
                        baseMsg = baseMsg.split(mc.group(1))[1];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }
                }
                //工作信息2
                Matcher md1 = compile("编号 职业 行业 职务 职称进入本单位年份 信息更新日期(.*?)编号 数据发生机构名称").matcher(content0);
                if(md1.find()){
                    String s1 = md1.group(1).trim();
                    String ss[] = s1.split(" +");
                    List la = base.getProfessionals();
                    try {
                        List<Integer> ll = new ArrayList();
                        for (int i = 0; i < ss.length ; i++) {
                            if(ss[i].replaceAll(" ","").trim().matches("[0-9]{1}")){
                                ll.add(i);
                            }
                        }
                        for (int j = 0; j < ll.size(); j++) {
                            Professional professional = (Professional) la.get(j);
                            ll.get(j);
                            professional.setOccupation(ss[ll.get(j)+1]);
                            professional.setIndustry(ss[ll.get(j)+2]);//private String business;
                            professional.setDuty(ss[ll.get(j)+3]);//private String duty;
                            professional.setTitle(ss[ll.get(j)+4]);// private String title;
                            professional.setStartYear(ss[ll.get(j)+5]);//private String workTime;
                            professional.setGettime(ss[ll.get(j)+6]);//private String updateTime;
                            la.set(j, professional);
                        }
                        base.setProfessionals(la);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        e.printStackTrace();
                    } catch (IndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }
                }
                //居住信息数据
                Matcher me = compile("数据发生机构名称(.*?)二").matcher(baseMsg);
                if (me.find()) {
                    String s2 = me.group(1).replaceAll("数据发生机构名称", "").trim();
                    String ss[] = s2.split(" +");
                    //编号
                    List la = new ArrayList();
                    try {
                        for (int i = 0; i < ss.length ; i=i+2) {
                            ProfessionalData professionalData =new ProfessionalData();
                            professionalData.setNo(ss[i]);
                            professionalData.setData(ss[i+1]);
                            la.add(professionalData);
                        }
                        baseData.setProfessionalData(la);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }
                }
            }
            /**
             * 二 信息概要
             */
            SumMsg sum = new SumMsg();
            if(sumMsg!=null){
                Matcher m1 = compile("异议标注 数目(.*?)授信及负债信息概要").matcher(sumMsg);
                if(sumMsg.indexOf("逾期及违约信息概要")>=0){
                    m1 = compile("异议标注 数目(.*?)逾期及违约信息概要").matcher(sumMsg);
                }
                //信用提示
                Creditcue creditcue = new Creditcue();
                if (m1.find()) {
                    String s1 = m1.group(1).trim();
                    String ss[] = s1.split(" +");
                    if (ss.length != 0) {
                        try {
                            creditcue.setHouseloanCount(ss[0]);
                            creditcue.setHouseloan2Count(ss[1]);
                            creditcue.setOtherloanCount(ss[2]);
                            creditcue.setFirstloanopenMonth(ss[3]);
                            creditcue.setLoancardCount(ss[4]);
                            creditcue.setFirstloancardopenMonth(ss[5]);
                            creditcue.setStandardloancardCount(ss[6]);
                            creditcue.setFirststandardloancardopenMonth(ss[7]);
                            creditcue.setAnnounceCount(ss[8]);
                            creditcue.setDissentCount(ss[9]);
                            sumMsg = sumMsg.split(m1.group(1))[1];
                        } catch (ArrayIndexOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }
                }
                sum.setCreditcue(creditcue);
                if(sumMsg.indexOf("逾期及违约信息概要")>=0){
                    Matcher m2 = compile("最长透支 月数(.*?)授信及负债信息概要").matcher(sumMsg);
                    OverdueSummary overdueSummary = new OverdueSummary();
                    if (m2.find()) {
                        String s1 = m2.group(1).trim();
                        String ss[] = s1.split(" +");
                        if (ss.length != 0) {
                            try {
                                overdueSummary.setCount(ss[0]);
                                overdueSummary.setMonths(ss[1]);
                                overdueSummary.setHighestoverdueamountpermon(ss[2]);
                                overdueSummary.setMaxDuration(ss[3]);
                                overdueSummary.setCount2(ss[4]);
                                overdueSummary.setMonths2(ss[5]);
                                overdueSummary.setHighestoverdueamountpermon2(ss[6]);
                                overdueSummary.setMaxDuration2(ss[7]);
                                overdueSummary.setCount3(ss[8]);
                                overdueSummary.setMonths3(ss[9]);
                                overdueSummary.setHighestoverdueamountpermon3(ss[10]);
                                overdueSummary.setMaxDuration3(ss[11]);
                                sumMsg = sumMsg.split(m2.group(1))[1];
                            } catch (ArrayIndexOutOfBoundsException e) {
                                e.printStackTrace();
                            }
                        }
                        sum.setOverdueSummary(overdueSummary);
                    }
                }
                Matcher m3 = compile("最近6个月平均应 还款(.*?)未销户贷记卡信息汇总").matcher(sumMsg);
                //授信及负债信息概要
                UnpaidLoan unpaidLoan = new UnpaidLoan();
                if (m3.find()) {
                    String s1 = m3.group(1).trim();
                    String ss[] = s1.split(" +");
                    if (ss.length != 0) {
                        try {
                            unpaidLoan.setFinancecorpCount(ss[0]);
                            unpaidLoan.setFinanceorgCount(ss[1]);
                            unpaidLoan.setAccountCount(ss[2]);
                            unpaidLoan.setCreditLimit(ss[3]);
                            unpaidLoan.setBalance(ss[4]);
                            unpaidLoan.setLatest6monthusedavgamount(ss[5]);
                            sumMsg = sumMsg.split(m3.group(1))[1];
                        } catch (ArrayIndexOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }
                }
                Matcher m4 = compile("最近6个月平均使 用额度(.*)").matcher(sumMsg);
                UndestoryLoancard undestoryLoancard = new UndestoryLoancard();
                if (m4.find()) {
                    String s1 = m4.group(1).trim();
                    String ss[] = s1.split(" +");
                    if (ss.length != 0) {
                        try {
                            undestoryLoancard.setFinancecorpCount(ss[0]);
                            undestoryLoancard.setFinanceorgCount(ss[1]);
                            undestoryLoancard.setAccountCount(ss[2]);
                            undestoryLoancard.setCreditlimit(ss[3]);
                            undestoryLoancard.setMaxcreditlimitperorg(ss[4]);
                            undestoryLoancard.setMincreditlimitperorg(ss[5]);
                            undestoryLoancard.setUsedcreditlimit(ss[6]);
                            undestoryLoancard.setLatest6monthusedavgamount(ss[7]);
                        } catch (ArrayIndexOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }
                }
                sum.setUnpaidLoan(unpaidLoan);
                sum.setUndestoryLoancard(undestoryLoancard);
            }
            /**
             * 三 信贷交易信息明细
             */
            CreditMsg creditMsg1 = new CreditMsg();
            if(creditMsg!=null){
                List<LoanInfo> loanInfoList = new ArrayList<>();
                Matcher ma = compile("贷款 +(.*?)贷记卡 +").matcher(creditMsg);
                if(ma.find()){
                    String dai = ma.group(1).trim();
                    creditMsg = creditMsg.substring(creditMsg.indexOf("贷记卡")+3);
                    if(dai!=null){
                        while (true){
                            LoanInfo loanInfo = new LoanInfo();
                            Matcher m1 = compile("(.*?)账户状态").matcher(dai);
                            boolean flag = true;
                            if (m1.find()) {
                                flag = false;
                                String s1 = m1.group(1).trim();
                                loanInfo.setMessage(s1);
                                dai = dai.split(m1.group(1))[1];
                            }
                            Matcher m2 = compile("最近一次还款 日期(.*?)当前逾期期 数").matcher(dai);
                            if (m2.find()) {
                                flag = false;
                                String s1 = m2.group(1).trim();
                                String ss[] = s1.split(" +");
                                if (ss.length != 0) {
                                    try {
                                        loanInfo.setLoanacctState(ss[0]);//账户状态
                                        loanInfo.setClass5State(ss[1]);;//五级分类
                                        loanInfo.setBalance(ss[2]);//本金余额
                                        loanInfo.setRemainpaymentcyc(ss[3]);//剩余还款期数
                                        loanInfo.setScheduledpaymentamount(ss[4]);//本月应还款
                                        loanInfo.setScheduledpaymentdate(ss[5]);//应还款日
                                        loanInfo.setActualpaymentamount(ss[6]);//本月实还款
                                        loanInfo.setRecentpaydate(ss[7]);//最近一次还款日期
                                        dai = dai.split(m2.group(1))[1];
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            Matcher m3 = compile("逾期180天以上未还本金(.*?)还款记录").matcher(dai);
                            if (m3.find()) {
                                flag = false;
                                String s1 = m3.group(1).trim();
                                String ss[] = s1.split(" +");
                                if (ss.length != 0) {
                                    try {
                                        loanInfo.setCurroverduecyc(ss[0]);//当前逾期期数
                                        loanInfo.setCurroverdueamount(ss[1]);//当前逾期金额
                                        loanInfo.setOverdue31to60amount(ss[2]);//当前逾期金额
                                        loanInfo.setOverdue61to90amount(ss[3]);//当前逾期金额
                                        loanInfo.setOverdue91to180amount(ss[4]);//当前逾期金额
                                        loanInfo.setOverdueover180amount(ss[5]);//当前逾期金额
                                        dai = dai.split(m3.group(1))[1];
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            Matcher m4 = compile("还款记录(.*?) ").matcher(dai);
                            if (m4.find()) {
                                flag = false;
                                String s1 = m4.group(1).trim();
                                String ss[] = s1.split(" +");
                                if (ss.length != 0) {
                                    try {
                                        loanInfo.setRecord(s1);
                                        dai = dai.substring(dai.indexOf(s1)+s1.length());
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }else if (flag == false){
                                loanInfo.setRecord(dai.replaceAll("还款记录",""));
                                flag = true;
                            }
                            loanInfoList.add(loanInfo);
                            if(flag){
                                break;
                            }
                        }
                    }
                }
                creditMsg1.setLoans(loanInfoList);
                List<LoancardInfo> cardsList = new ArrayList<>();
                while (true){
                    LoancardInfo loancardInfo = new LoancardInfo();
                    Matcher m1 = compile("(.*?)账户状态 ").matcher(creditMsg);
                    boolean flag = true;
                    if (m1.find()) {
                        flag = false;
                        String s1 = m1.group(1).trim();
                        loancardInfo.setMessage(s1);
                        creditMsg = creditMsg.split(m1.group(1))[1];
                    }
                    Matcher m2 = compile("本月应还款(.*?)账单日").matcher(creditMsg);
                    if (m2.find()) {
                        flag = false;
                        String s1 = m2.group(1).trim();
                        String ss[] = s1.split(" +");
                        if (ss.length != 0) {
                            try {
                                loancardInfo.setLoanacctState(ss[0]);//账户状态
                                loancardInfo.setUsedcreditlimitamount(ss[1]);//已用额度
                                loancardInfo.setLatest6monthusedavgamount(ss[2]);//最近6个月平均使用额度
                                loancardInfo.setUsedhighestamount(ss[3]);//最大使用额度
                                loancardInfo.setScheduledpaymentamount(ss[4]);//本月应还款
                                creditMsg = creditMsg.substring(creditMsg.indexOf(s1)+s1.length());
                            } catch (ArrayIndexOutOfBoundsException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    Matcher m3 = compile("当前逾期金额(.*?)还款记录").matcher(creditMsg);
                    if (m3.find()) {
                        flag = false;
                        String s1 = m3.group(1).trim();
                        String ss[] = s1.split(" +");
                        if (ss.length != 0) {
                            try {
                                loancardInfo.setScheduledpaymentdate(ss[0]);//账单日
                                loancardInfo.setActualpaymentamount(ss[1]);//本月实还款
                                loancardInfo.setRecentpaydate(ss[2]);
                                loancardInfo.setCurroverduecyc(ss[3]);
                                loancardInfo.setCurroverdueamount(ss[4]);
                                creditMsg = creditMsg.split(m3.group(1))[1];
                            } catch (ArrayIndexOutOfBoundsException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    Matcher m4 = compile("还款记录(.*?)[1-9]+\\.").matcher(creditMsg);
                    if (m4.find()) {
                        flag = false;
                        String s1 = m4.group(1).trim();
                        String ss[] = s1.split(" +");
                        if (ss.length != 0) {
                            try {
                                loancardInfo.setRecord(s1);
                                creditMsg = creditMsg.substring(creditMsg.indexOf(s1)+s1.length());
                            } catch (ArrayIndexOutOfBoundsException e) {
                                e.printStackTrace();
                            }
                        }
                    }else if (flag == false){
                        if (creditMsg.length()<20){
                            loancardInfo.setRecord(creditMsg.replaceAll("还款记录",""));
                        }
                    }
                    if(!flag){
                        cardsList.add(loancardInfo);
                    }else{
                        creditMsg = creditMsg.replaceAll(" ","");
                        if(creditMsg.length()!=0){
                            String[] ss0 = creditMsg.split("[1-9]+\\.");
                            for(String s0:ss0){
                                if(!"".equals(s0)){
                                    LoancardInfo loancardInfo1 = new LoancardInfo();
                                    loancardInfo1.setMessage(s0);
                                    cardsList.add(loancardInfo1);
                                }
                            }
                        }
                        break;
                    }
                }
                creditMsg1.setLoancardInfos(cardsList);
            }
            /**
             * 四 公共信息明细
             */
            CommonMsg commonMsg1 = new CommonMsg();
            if(commonMsg!=null){
                Matcher m1 = compile("单位缴存比例(.*?)编号").matcher(commonMsg);
                if (m1.find()) {
                    List ll = new ArrayList();
                    String s1 = m1.group(1).trim();
                    String ss[] = s1.split(" +");
                    try {
                        for (int i = 0; i <ss.length ; i=i+9) {
                            AccfundRecord accfundRecord = new AccfundRecord();
                            accfundRecord.setNo(ss[i]);
                            accfundRecord.setArea(ss[i+1]);
                            accfundRecord.setRegisterdate(ss[i+2]);
                            accfundRecord.setFirstmonth(ss[i+3]);
                            accfundRecord.setTomonth(ss[i+4]);
                            accfundRecord.setState(ss[i+5]);
                            accfundRecord.setPay(ss[i+6]);
                            accfundRecord.setOwnpercent(ss[i+7]);
                            accfundRecord.setCompercent(ss[i+8]);
                            ll.add(accfundRecord);
                        }
                        commonMsg1.setAccfundRecords(ll);
                    }catch (ArrayIndexOutOfBoundsException e){
                        e.printStackTrace();
                    }
                    commonMsg =commonMsg.substring(commonMsg.indexOf(s1)+s1.length());
                }
                Matcher m2 = compile("信息更新日期(.*)").matcher(commonMsg);
                if (m2.find()){
                    List ll = new ArrayList();
                    String s1 = m2.group(1).trim();
                    String ss[] = s1.split(" +");
                    try {
                        for (int i = 0; i <ss.length/3*3 ; i=i+3) {
                            AccfundCompany accfundCompany = new AccfundCompany();
                            accfundCompany.setNo(ss[i]);
                            accfundCompany.setOrganname(ss[i+1]);
                            accfundCompany.setGettime(ss[i+2]);
                            ll.add(accfundCompany);
                        }
                    }catch (ArrayIndexOutOfBoundsException e){
                        e.printStackTrace();
                    }
                    commonMsg1.setPayCompanies(ll);
                }
            }
            /**
             * 五 查询记录
             */
            RecordSummary recordSummary1 = new RecordSummary();
            if(queryMsg!=null){
                Matcher m1 = compile("特约商户实名 审查(.*?)机构查询记录明细").matcher(queryMsg);
                if (m1.find()) {
                    String s1 = m1.group(1).trim();
                    String ss[] = s1.split(" +");
                    try {
                        recordSummary1.setOrgsum1(ss[0]);
                        recordSummary1.setOrgsum2(ss[1]);
                        recordSummary1.setRecordsum1(ss[2]);
                        recordSummary1.setRecordsum2(ss[3]);
                        recordSummary1.setRecordsumself(ss[4]);
                        recordSummary1.setTowyearrecordsum1(ss[5]);
                        recordSummary1.setTowyearrecordsum2(ss[6]);
                        recordSummary1.setTowyearrecordsum3(ss[7]);
                        queryMsg =queryMsg.substring(queryMsg.indexOf(s1)+s1.length());
                    }catch (ArrayIndexOutOfBoundsException e){
                        e.printStackTrace();
                    }
                }
                Matcher m2 = compile("查询原因(.*?)本人查询记录明细").matcher(queryMsg);
                if (m2.find()) {
                    String s1 = m2.group(1).trim();
                    String ss[] = s1.split(" +");
                    List<RecordDetail> company = new ArrayList<>();
                    try {
                        for (int i = 0; i < ss.length; i=i+4) {
                            RecordDetail recordDetail = new RecordDetail();
                            recordDetail.setNo(ss[i]);
                            recordDetail.setQueryDate(ss[i+1]);
                            recordDetail.setQuerier(ss[i+2]);
                            recordDetail.setQueryReason(ss[i+3]);
                            company.add(recordDetail);
                        }
                        queryMsg =queryMsg.substring(queryMsg.indexOf(s1)+s1.length());
                        if(company.size()!=0){
                            recordSummary1.setCompany(company);
                        }
                    }catch (ArrayIndexOutOfBoundsException e){
                        e.printStackTrace();
                    }
                }
                if (queryMsg.trim().length()!=0) {
                    String s1 =queryMsg.substring(queryMsg.indexOf("查询原因")+"查询原因".length()).trim();
                    String ss[] = s1.split(" +");
                    List<RecordDetail> person = new ArrayList<>();
                    try {
                        for (int i = 0; i < ss.length; i=i+4) {
                            RecordDetail recordDetail = new RecordDetail();
                            recordDetail.setNo(ss[i]);
                            recordDetail.setQueryDate(ss[i+1]);
                            recordDetail.setQuerier(ss[i+2]);
                            recordDetail.setQueryReason(ss[i+3]);
                            person.add(recordDetail);
                        }
                        if(person.size()!=0){
                            recordSummary1.setPerson(person);
                        }
                    }catch (ArrayIndexOutOfBoundsException e){
                        e.printStackTrace();
                    }
                }

            }
            msg.setBaseMsg(base);
            msg.setBaseMsgData(baseData);
            msg.setSumMsg(sum);
            msg.setCreditMsg(creditMsg1);
            msg.setCommonMsg(commonMsg1);
            msg.setRecordSummary(recordSummary1);
            System.out.println("=================================");
            return msg;
            //System.out.println(baseMsg);
            //System.out.println(sumMsg);
            //System.out.println(creditMsg);
           // System.out.println(commonMsg);
            // System.out.println(queryMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getDocument(String pdfPath) {
        File pdfFile = new File(pdfPath);
        InputStream input = null;
        try {
            input = new FileInputStream(pdfFile);
            // 加载 pdf 文档
            document = PDDocument.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidPasswordException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTextFromPdf() throws Exception {
        // 是否排序
        boolean sort = false;
        // 开始提取页数
        int startPage = 1;
        // 结束提取页数
        int endPage = Integer.MAX_VALUE;
        String content = null;
        // 获取内容信息
        PDFTextStripper pts = new PDFTextStripper();
        pts.setSortByPosition(sort);
        endPage = document.getNumberOfPages();
        System.out.println("Total Page: " + endPage);
        pts.setStartPage(startPage);
        pts.setEndPage(endPage);
        try {
            content = pts.getText(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }

    public Messages getTextByArea() {
        Messages msg = new Messages();
        PDFTextStripperByArea stripper1 = null;
        try {
            stripper1 = new PDFTextStripperByArea();
            stripper1.setSortByPosition(true);
            stripper1.addRegion("reportNo", new Rectangle(106, 200, 120, 10));
            stripper1.addRegion("requestTime", new Rectangle(290, 200, 100, 10));
            stripper1.addRegion("reportTime", new Rectangle(438, 200, 100, 10));
            stripper1.addRegion("name", new Rectangle(66, 229, 62, 40));
            stripper1.addRegion("idtype", new Rectangle(132, 229, 84, 40));
            stripper1.addRegion("idcard", new Rectangle(220, 229, 84, 40));
            stripper1.addRegion("operator", new Rectangle(299, 229, 130, 40));
            stripper1.addRegion("reason", new Rectangle(425, 229, 101, 40));
            PDPage firstPage = document.getPage(0);
            stripper1.extractRegions(firstPage);
            String reportNo = stripper1.getTextForRegion("reportNo").replaceAll("\r|\n", "");
            String requestTime = stripper1.getTextForRegion("requestTime").replaceAll("\r|\n", "");
            String reportTime = stripper1.getTextForRegion("reportTime").replaceAll("\r|\n", "");
            String name = stripper1.getTextForRegion("name").replaceAll("\r|\n", "");
            String idtype = stripper1.getTextForRegion("idtype").replaceAll("\r|\n", "");
            String idcard = stripper1.getTextForRegion("idcard").replaceAll("\r|\n", "");
            String operator = stripper1.getTextForRegion("operator").replaceAll("\r|\n", "");
            String reason = stripper1.getTextForRegion("reason").replaceAll("\r|\n", "");
            msg.setReportNo(reportNo);
            msg.setQueryTime(requestTime);
            msg.setReportCreateTime(reportTime);
            msg.setName(name);
            msg.setCertNo(idcard);
            msg.setCertType(idtype);
            msg.setUserCode(operator);
            msg.setQueryReason(reason);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }

    public void toTextFile(String pdfContent, String filePath) {
        try {
            File f = new File(filePath);
            if (!f.exists()) {
                f.createNewFile();
            }
            System.out.println("Write PDF Content to txt file ...");
            BufferedWriter output = new BufferedWriter(new FileWriter(f));
            output.write(pdfContent);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
