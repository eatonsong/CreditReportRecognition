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
import java.util.regex.Pattern;

public class PdfboxUtil {


    PDDocument document;

    public static void main(String[] args) {
        String pdfPath = "src/main/resources/pdf/001.pdf";
        String txtfilePath = "src/main/resources/output/test.txt";
        PdfboxUtil pdfutil = new PdfboxUtil();
        try {
            pdfutil.getDocument(pdfPath);
            Messages msg = pdfutil.getTextByArea();
            String content = pdfutil.getTextFromPdf();
            String regex1 = ".*(页码.*\r\n).*";
            String regex2 = ".*(Page.*\r\n).*";
            content = content.replaceAll(regex1, "");
            content = content.replaceAll(regex2, "");
            content = content.replaceAll("\r\n", " ");
            Matcher m = Pattern.compile("个人基本信息(.*?)信息概要").matcher(content);
            Matcher mm = Pattern.compile("信息概要(.*?)信贷交易信息明细").matcher(content);
            Matcher mmm = Pattern.compile("信贷交易信息明细(.*?)公共信息明细").matcher(content);
            String baseMsg = null;
            String sumMsg = null;
            String creditMsg = null;
            if (m.find()) {
                baseMsg = m.group(1);
            }
            if(mm.find()){
                sumMsg = mm.group(1);
            }
            if(mmm.find()){
                creditMsg = mmm.group(1);
            }

            BaseMsg base = new BaseMsg();
            BaseMsgData baseData = new BaseMsgData();
            if (baseMsg != null) {
                Matcher m1 = Pattern.compile("手机号码(.*?)数据发生机构名称").matcher(baseMsg);
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
                Matcher m2 = Pattern.compile("数据发生机构名称(.*?)单位电话").matcher(baseMsg);
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
                Matcher m3 = Pattern.compile("学位(.*?)数据发生机构名称").matcher(baseMsg);
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
                Matcher m4 = Pattern.compile("数据发生机构名称(.*?)通讯地址").matcher(baseMsg);
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
                Matcher m5 = Pattern.compile("户籍地址(.*?)数据发生机构名称").matcher(baseMsg);
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
                Matcher m6 = Pattern.compile("数据发生机构名称(.*?)配偶信息").matcher(baseMsg);
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
                Matcher m7 = Pattern.compile("联系电话(.*?)数据发生机构名称").matcher(baseMsg);
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
                Matcher m8 = Pattern.compile("数据发生机构名称(.*?)居住信息").matcher(baseMsg);
                if (m8.find()) {
                    String s2 = m8.group(1).replaceAll("数据发生机构名称", "").trim();
                    baseData.setWife(s2);
                    int num=baseMsg.indexOf(m8.group(1));
                    baseMsg = baseMsg.substring(num);
                }
                Matcher ma = Pattern.compile("信息更新日期(.*?)编号").matcher(baseMsg);
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
                Matcher mb = Pattern.compile("数据发生机构名称(.*?)职业信息").matcher(baseMsg);
                if (mb.find()) {
                    String s2 = mb.group(1).replaceAll("数据发生机构名称", "").trim();
                    String ss[] = s2.split(" +");
                    //编号
                    List la = new ArrayList();
                    try {
                        for (int i = 0; i < ss.length ; i=i+2) {
                            HouseData house =new HouseData();
                            house.setNo(ss[i]);
                            house.setNo(ss[i+1]);
                            la.add(house);
                        }
                        baseData.setHouseDatas(la);
                        baseMsg = baseMsg.split(mb.group(1))[1];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }
                }
                //工作信息1
                Matcher mc = Pattern.compile("单位地址(.*?)编号").matcher(baseMsg);
                if (mc.find()) {
                    String s1 = mc.group(1).trim();
                    String ss[] = s1.split(" ");
                    String ss1[] = s1.split(" +");
                    //编号
                    List la = new ArrayList();
                    try {
                        for (int i = 1; i < ss.length-1 ; i=i+4) {
                            Work work = new Work();
                            work.setNo(ss[i]);
                            work.setWork(ss[i+1]);
                            work.setWorkAddress(ss[i+3]);
                            la.add(work);
                        }
                        base.setWorks(la);
                        baseMsg = baseMsg.split(mc.group(1))[1];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }
                }
                //工作信息2
                Matcher md = Pattern.compile("信息更新日期(.*?)编号").matcher(baseMsg);
                if (md.find()) {
                   /* String s1 = md.group(1).trim();
                    String ss[] = s1.split("  ");
                    //编号
                    List la = base.getWorks();
                    int flag=0;*/
                    try {
                        /*for (int i = 0; i < ss.length ; i=i+3) {
                            Work work =(Work)la.get(flag);
                            work.setProfession(ss[i+1]);
                            String ss1[] = ss[i+2].split(" ");
                            if(ss1.length>5){
                                work.setUpdateTime(ss1[ss1.length-1]);
                                work.setWorkAddress(ss1[ss1.length-2]);
                                work.setTitle(ss1[ss1.length-3]);
                                String duty = "";
                                for (int j = 1; j < ss1.length-4; j++) {
                                    duty+=ss1[j];
                                }
                                work.setDuty(duty);
                                work.setBusiness(ss1[0]);
                            }
                            flag++;
                        }*/
                       // base.setWorks(la);
                        //baseMsg = baseMsg.split(md.group(1))[1];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        e.printStackTrace();
                    } catch (IndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }
                }

            }
            SumMsg sum = new SumMsg();
            if(sumMsg!=null){
                Matcher m1 = Pattern.compile("异议标注 数目(.*?)授信及负债信息概要").matcher(sumMsg);
                if(sumMsg.indexOf("逾期及违约信息概要")>=0){
                    m1 = Pattern.compile("异议标注 数目(.*?)逾期及违约信息概要").matcher(sumMsg);
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
                    Matcher m2 = Pattern.compile("最长透支 月数(.*?)授信及负债信息概要").matcher(sumMsg);
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
                Matcher m3 = Pattern.compile("最近6个月平均应 还款(.*?)未销户贷记卡信息汇总").matcher(sumMsg);
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
                Matcher m4 = Pattern.compile("最近6个月平均使 用额度(.*?)三").matcher(sumMsg);
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
                Matcher ma = Pattern.compile("贷款 +(.*?)贷记卡 +").matcher(creditMsg);
                if(ma.find()){
                    String dai = ma.group(1).trim();
                    if(dai!=null){
                        while (true){
                            Loans loans = new Loans();
                            Matcher m1 = Pattern.compile("(.*?)账户状态").matcher(dai);
                            boolean flag = true;
                            if (m1.find()) {
                                flag = false;
                                String s1 = m1.group(1).trim();
                                loans.setMessage(s1);
                                dai = dai.split(m1.group(1))[1];
                            }
                            Matcher m2 = Pattern.compile("最近一次还款 日期(.*?)当前逾期期 数").matcher(dai);
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
                            Matcher m3 = Pattern.compile("逾期180天以上未还本金(.*?)还款记录").matcher(dai);
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
                            Matcher m4 = Pattern.compile("还款记录(.*?) ").matcher(dai);
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
                Matcher mb = Pattern.compile("贷款 +(.*?)贷记卡 +").matcher(creditMsg);
                if(mb.find()){
                    String card = mb.group(1).trim();
                }
            }


            msg.setBaseMsg(base);
            msg.setBaseMsgData(baseData);
            msg.setSumMsg(sum);
            msg.setCreditMsg(creditMsg1);
            String jsonStr = JSON.toJSONString(msg);
            System.out.println(jsonStr);
            System.out.println("=================================");
            //System.out.println(baseMsg);
            //System.out.println(sumMsg);
            System.out.println(creditMsg);

        } catch (Exception e) {
            e.printStackTrace();
        }
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
            String name = stripper1.getTextForRegion("name");
            String idtype = stripper1.getTextForRegion("idtype");
            String idcard = stripper1.getTextForRegion("idcard");
            String operator = stripper1.getTextForRegion("operator");
            String reason = stripper1.getTextForRegion("reason");
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
