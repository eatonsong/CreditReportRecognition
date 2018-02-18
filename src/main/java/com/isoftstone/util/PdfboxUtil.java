package com.isoftstone.util;

/*@package_name com.isoftstone.util
 * @date 2018/2/11 14:52
 * @user Eaton*/

import com.alibaba.fastjson.JSON;
import com.isoftstone.dto.*;
import com.isoftstone.dto.msg1.*;
import com.isoftstone.dto.msg2.Credit;
import com.isoftstone.dto.msg2.Overdue;
import com.isoftstone.dto.msg2.SumMsg;
import com.isoftstone.dto.msg2.Tips;
import com.isoftstone.dto.msg3.Card;
import com.isoftstone.dto.msg3.CreditMsg;
import com.isoftstone.dto.msg3.Loans;
import com.isoftstone.dto.msg4.CommonMsg;
import com.isoftstone.dto.msg4.PayCompany;
import com.isoftstone.dto.msg4.PayRecord;
import com.isoftstone.dto.msg5.QueryMsg;
import com.isoftstone.dto.msg5.QueryCom;
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
                            base.setSex(ss[0]);
                            base.setBirth(ss[1]);
                            base.setMerry(ss[2]);
                            base.setTelphone(ss[3]);
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
                            baseData.setSex(ss[0]);
                            baseData.setBirth(ss[1]);
                            baseData.setMerry(ss[2]);
                            baseData.setTelphone(ss[3]);
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
                            base.setPhone1(ss[0]);
                            base.setPhone2(ss[1]);
                            base.setSchool(ss[2]);
                            base.setDegree(ss[3]);
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
                            baseData.setPhone1(ss[0]);
                            baseData.setPhone2(ss[1]);
                            baseData.setSchool(ss[2]);
                            baseData.setDegree(ss[3]);
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
                            base.setTelAddress(ss[0]);
                            base.setRegAddress(ss[1]);
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
                            baseData.setTelAddress(ss[0]);
                            baseData.setRegAddress(ss[1]);
                            baseMsg = baseMsg.split(m6.group(1))[1];
                        } catch (ArrayIndexOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }
                }
                Matcher m7 = compile("联系电话(.*?)数据发生机构名称").matcher(baseMsg);
                //姓名 证件类型 证件号码 工作单位 联系电话 配偶
                if (m7.find()) {
                    String s1 = m7.group(1).trim();
                    String ss[] = s1.split(" +");
                    if (ss.length != 0) {
                        try {
                            base.setName1(ss[0]);
                            base.setIdtype1(ss[1]);
                            base.setIdcard1(ss[2]);
                            base.setWork1(ss[3]);
                            base.setTelphone1(ss[4]);
                            baseMsg = baseMsg.split(m7.group(1))[1];
                        } catch (ArrayIndexOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }
                }
                Matcher m8 = compile("数据发生机构名称(.*?)居住信息").matcher(baseMsg);
                if (m8.find()) {
                    String s2 = m8.group(1).replaceAll("数据发生机构名称", "").trim();
                    baseData.setWife(s2);
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
                            House house = new House();
                            house.setNo(ss[i]);
                            house.setAddress(ss[i+1]);
                            house.setStatus(ss[i+2]);
                            house.setUpdateTime(ss[i+3]);
                            la.add(house);
                        }
                        base.setHouses(la);
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
                            HouseData house =new HouseData();
                            house.setNo(ss[i]);
                            house.setData(ss[i+1]);
                            la.add(house);
                        }
                        baseData.setHouseDatas(la);
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
                            Work work = new Work();
                            work.setNo(ss1[ll.get(l)]);
                            work.setWork(ss1[ll.get(l)+1]);
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
                            work.setWorkAddress(workms);
                            la.add(work);
                        }
                        base.setWorks(la);
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
                    List la = base.getWorks();
                    try {
                        List<Integer> ll = new ArrayList();
                        for (int i = 0; i < ss.length ; i++) {
                            if(ss[i].replaceAll(" ","").trim().matches("[0-9]{1}")){
                                ll.add(i);
                            }
                        }
                        for (int j = 0; j < ll.size(); j++) {
                            Work work = (Work) la.get(j);
                            ll.get(j);
                            work.setProfession(ss[ll.get(j)+1]);
                            work.setBusiness(ss[ll.get(j)+2]);//private String business;
                            work.setDuty(ss[ll.get(j)+3]);//private String duty;
                            work.setTitle(ss[ll.get(j)+4]);// private String title;
                            work.setWorkTime(ss[ll.get(j)+5]);//private String workTime;
                            work.setUpdateTime(ss[ll.get(j)+6]);//private String updateTime;
                            la.set(j,work);
                        }
                        base.setWorks(la);
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
                            WorkData workData =new WorkData();
                            workData.setNo(ss[i]);
                            workData.setData(ss[i+1]);
                            la.add(workData);
                        }
                        baseData.setWorkDatas(la);
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
                Tips tips = new Tips();
                if (m1.find()) {
                    String s1 = m1.group(1).trim();
                    String ss[] = s1.split(" +");
                    if (ss.length != 0) {
                        try {
                            tips.setLocation1(ss[0]);
                            tips.setLocation2(ss[1]);
                            tips.setLocation3(ss[2]);
                            tips.setLocation4(ss[3]);
                            tips.setLocation5(ss[4]);
                            tips.setLocation6(ss[5]);
                            tips.setLocation7(ss[6]);
                            tips.setLocation8(ss[7]);
                            tips.setLocation9(ss[8]);
                            tips.setLocation10(ss[9]);
                            sumMsg = sumMsg.split(m1.group(1))[1];
                        } catch (ArrayIndexOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }
                }
                sum.setTips(tips);
                if(sumMsg.indexOf("逾期及违约信息概要")>=0){
                    Matcher m2 = compile("最长透支 月数(.*?)授信及负债信息概要").matcher(sumMsg);
                    Overdue overdue = new Overdue();
                    if (m2.find()) {
                        String s1 = m2.group(1).trim();
                        String ss[] = s1.split(" +");
                        if (ss.length != 0) {
                            try {
                                overdue.setLocation1(ss[0]);
                                overdue.setLocation2(ss[1]);
                                overdue.setLocation3(ss[2]);
                                overdue.setLocation4(ss[3]);
                                overdue.setLocation5(ss[4]);
                                overdue.setLocation6(ss[5]);
                                overdue.setLocation7(ss[6]);
                                overdue.setLocation8(ss[7]);
                                overdue.setLocation9(ss[8]);
                                overdue.setLocation10(ss[9]);
                                overdue.setLocation11(ss[10]);
                                overdue.setLocation12(ss[11]);
                                sumMsg = sumMsg.split(m2.group(1))[1];
                            } catch (ArrayIndexOutOfBoundsException e) {
                                e.printStackTrace();
                            }
                        }
                        sum.setOverdue(overdue);
                    }
                }
                Matcher m3 = compile("最近6个月平均应 还款(.*?)未销户贷记卡信息汇总").matcher(sumMsg);
                //授信及负债信息概要
                Credit credit = new Credit();
                if (m3.find()) {
                    String s1 = m3.group(1).trim();
                    String ss[] = s1.split(" +");
                    if (ss.length != 0) {
                        try {
                            credit.setLocation1(ss[0]);
                            credit.setLocation2(ss[1]);
                            credit.setLocation3(ss[2]);
                            credit.setLocation4(ss[3]);
                            credit.setLocation5(ss[4]);
                            credit.setLocation6(ss[5]);
                            sumMsg = sumMsg.split(m3.group(1))[1];
                        } catch (ArrayIndexOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println(sumMsg);
                Matcher m4 = compile("最近6个月平均使 用额度(.*)").matcher(sumMsg);
                if (m4.find()) {
                    String s1 = m4.group(1).trim();
                    String ss[] = s1.split(" +");
                    if (ss.length != 0) {
                        try {
                            credit.setLocation7(ss[0]);
                            credit.setLocation8(ss[1]);
                            credit.setLocation9(ss[2]);
                            credit.setLocation10(ss[3]);
                            credit.setLocation11(ss[4]);
                            credit.setLocation12(ss[5]);
                            credit.setLocation13(ss[6]);
                            credit.setLocation14(ss[7]);
                        } catch (ArrayIndexOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }
                }
                sum.setCredit(credit);
            }
            /**
             * 三 信贷交易信息明细
             */
            CreditMsg creditMsg1 = new CreditMsg();
            if(creditMsg!=null){
                List<Loans> loansList = new ArrayList<>();
                Matcher ma = compile("贷款 +(.*?)贷记卡 +").matcher(creditMsg);
                if(ma.find()){
                    String dai = ma.group(1).trim();
                    creditMsg = creditMsg.substring(creditMsg.indexOf("贷记卡")+3);
                    if(dai!=null){
                        while (true){
                            Loans loans = new Loans();
                            Matcher m1 = compile("(.*?)账户状态").matcher(dai);
                            boolean flag = true;
                            if (m1.find()) {
                                flag = false;
                                String s1 = m1.group(1).trim();
                                loans.setMessage(s1);
                                dai = dai.split(m1.group(1))[1];
                            }
                            Matcher m2 = compile("最近一次还款 日期(.*?)当前逾期期 数").matcher(dai);
                            if (m2.find()) {
                                flag = false;
                                String s1 = m2.group(1).trim();
                                String ss[] = s1.split(" +");
                                if (ss.length != 0) {
                                    try {
                                        loans.setStatus(ss[0]);//账户状态
                                        loans.setClassify(ss[1]);;//五级分类
                                        loans.setBalance(ss[2]);//本金余额
                                        loans.setRepayment(ss[3]);//剩余还款期数
                                        loans.setPayment(ss[4]);//本月应还款
                                        loans.setPayTime(ss[5]);//应还款日
                                        loans.setPayment1(ss[6]);//本月实还款
                                        loans.setPayTime1(ss[7]);//最近一次还款日期
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
                                        loans.setOverdue(ss[0]);//当前逾期期数
                                        loans.setOverdueMoney(ss[1]);//当前逾期金额
                                        loans.setOverdueMoney31(ss[2]);//当前逾期金额
                                        loans.setOverdueMoney61(ss[3]);//当前逾期金额
                                        loans.setOverdueMoney91(ss[4]);//当前逾期金额
                                        loans.setOverdueMoney180(ss[5]);//当前逾期金额
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
                                        loans.setRecord(s1);
                                        dai = dai.substring(dai.indexOf(s1)+s1.length());
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }else if (flag == false){
                                loans.setRecord(dai.replaceAll("还款记录",""));
                                flag = true;
                            }
                            loansList.add(loans);
                            if(flag){
                                break;
                            }
                        }
                    }
                }
                creditMsg1.setLoans(loansList);
                List<Card> cardsList = new ArrayList<>();
                while (true){
                    Card card = new Card();
                    Matcher m1 = compile("(.*?)账户状态 ").matcher(creditMsg);
                    boolean flag = true;
                    if (m1.find()) {
                        flag = false;
                        String s1 = m1.group(1).trim();
                        card.setMessage(s1);
                        creditMsg = creditMsg.split(m1.group(1))[1];
                    }
                    Matcher m2 = compile("本月应还款(.*?)账单日").matcher(creditMsg);
                    if (m2.find()) {
                        flag = false;
                        String s1 = m2.group(1).trim();
                        String ss[] = s1.split(" +");
                        if (ss.length != 0) {
                            try {
                                card.setStatus(ss[0]);//账户状态
                                card.setUsed(ss[1]);//已用额度
                                card.setUsed6(ss[2]);//最近6个月平均使用额度
                                card.setUsedMax(ss[3]);//最大使用额度
                                card.setThisMonth(ss[4]);//本月应还款
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
                                card.setPayTime(ss[0]);//账单日
                                card.setPayMonth(ss[1]);//本月实还款
                                card.setPayLast(ss[2]);
                                card.setOverdueNum(ss[3]);
                                card.setOverdue(ss[4]);
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
                                card.setRecord(s1);
                                creditMsg = creditMsg.substring(creditMsg.indexOf(s1)+s1.length());
                            } catch (ArrayIndexOutOfBoundsException e) {
                                e.printStackTrace();
                            }
                        }
                    }else if (flag == false){
                        if (creditMsg.length()<20){
                            card.setRecord(creditMsg.replaceAll("还款记录",""));
                        }
                    }
                    if(!flag){
                        cardsList.add(card);
                    }else{
                        creditMsg = creditMsg.replaceAll(" ","");
                        if(creditMsg.length()!=0){
                            String[] ss0 = creditMsg.split("[1-9]+\\.");
                            for(String s0:ss0){
                                if(!"".equals(s0)){
                                    Card card1 = new Card();
                                    card1.setMessage(s0);
                                    cardsList.add(card1);
                                }
                            }
                        }
                        break;
                    }
                }
                creditMsg1.setCards(cardsList);
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
                            PayRecord payRecord = new PayRecord();
                            payRecord.setNo(ss[i]);
                            payRecord.setPlace(ss[i+1]);
                            payRecord.setDate1(ss[i+2]);
                            payRecord.setDate2(ss[i+3]);
                            payRecord.setDate3(ss[i+4]);
                            payRecord.setStatus(ss[i+5]);
                            payRecord.setPayMonth(ss[i+6]);
                            payRecord.setPersonScale(ss[i+7]);
                            payRecord.setComScale(ss[i+8]);
                            ll.add(payRecord);
                        }
                        commonMsg1.setPayRecords(ll);
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
                            PayCompany payCompany = new PayCompany();
                            payCompany.setNo(ss[i]);
                            payCompany.setCompany(ss[i+1]);
                            payCompany.setUpdateDate(ss[i+2]);
                            ll.add(payCompany);
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
            QueryMsg queryMsg1 = new QueryMsg();
            if(queryMsg!=null){
                Matcher m1 = compile("审查(.*?)机构查询记录明细").matcher(queryMsg);
                if (m1.find()) {
                    String s1 = m1.group(1).trim();
                    String ss[] = s1.split(" +");
                    try {
                        queryMsg1.setLoans(ss[0]);
                        queryMsg1.setCard(ss[1]);
                        queryMsg1.setLoansNum(ss[2]);
                        queryMsg1.setCardNum(ss[3]);
                        queryMsg1.setPersonNum(ss[4]);
                        queryMsg1.setManagement(ss[5]);
                        queryMsg1.setGuarantee(ss[6]);
                        queryMsg1.setSpecial(ss[7]);
                        queryMsg =queryMsg.substring(queryMsg.indexOf(s1)+s1.length());
                    }catch (ArrayIndexOutOfBoundsException e){
                        e.printStackTrace();
                    }
                }
                Matcher m2 = compile("查询原因(.*?)本人查询记录明细").matcher(queryMsg);
                if (m2.find()) {
                    String s1 = m2.group(1).trim();
                    String ss[] = s1.split(" +");
                    List<QueryCom> company = new ArrayList<>();
                    try {
                        for (int i = 0; i < ss.length; i=i+4) {
                            QueryCom queryCom = new QueryCom();
                            queryCom.setNo(ss[i]);
                            queryCom.setQueryTime(ss[i+1]);
                            queryCom.setOperator(ss[i+2]);
                            queryCom.setReason(ss[i+3]);
                            company.add(queryCom);
                        }
                        queryMsg =queryMsg.substring(queryMsg.indexOf(s1)+s1.length());
                        if(company.size()!=0){
                            queryMsg1.setCompany(company);
                        }
                    }catch (ArrayIndexOutOfBoundsException e){
                        e.printStackTrace();
                    }
                }
                if (queryMsg.trim().length()!=0) {
                    String s1 =queryMsg.substring(queryMsg.indexOf("查询原因")+"查询原因".length()).trim();
                    String ss[] = s1.split(" +");
                    List<QueryCom> person = new ArrayList<>();
                    try {
                        for (int i = 0; i < ss.length; i=i+4) {
                            QueryCom queryCom = new QueryCom();
                            queryCom.setNo(ss[i]);
                            queryCom.setQueryTime(ss[i+1]);
                            queryCom.setOperator(ss[i+2]);
                            queryCom.setReason(ss[i+3]);
                            person.add(queryCom);
                        }
                        if(person.size()!=0){
                            queryMsg1.setPerson(person);
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
            msg.setQueryMsg(queryMsg1);
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
            msg.setRequestTime(requestTime);
            msg.setReportTime(reportTime);
            msg.setName(name);
            msg.setIdcard(idcard);
            msg.setIdtype(idtype);
            msg.setOperator(operator);
            msg.setReason(reason);
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
