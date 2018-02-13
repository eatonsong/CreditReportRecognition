package com.isoftstone.util;

/*@package_name com.isoftstone.util
 * @date 2018/2/11 14:52
 * @user Eaton*/

import com.isoftstone.dto.Messages;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.awt.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PdfboxUtil {


    PDDocument document;

    public static void main(String[] args) {
        String pdfPath = "src/main/resources/pdf/002.pdf";
        String txtfilePath = "src/main/resources/output/test.txt";
        PdfboxUtil pdfutil = new PdfboxUtil();
        try {
            pdfutil.getDocument(pdfPath);
            Messages msg = pdfutil.getTextByArea();
            String content = pdfutil.getTextFromPdf();
            String regex = ".*(http.*\r\n.*\r\n).*";
            String regex1 = ".*(页码.*\r\n).*";
            content = content.replaceAll(regex,"");
            content = content.replaceAll(regex1,"");
            content =  content.replaceAll("\r\n"," ");
            Matcher m= Pattern.compile("个人基本信息(.*?)信息概要").matcher(content);
            String baseMsg = null;
            if(m.find()){
                baseMsg = m.group(1);
               // System.out.println(m.group(1));
            }
            if(baseMsg!=null){
                Matcher m1= Pattern.compile("手机号码(.*?)数据发生机构名称").matcher(baseMsg);
                if(m1.find()){
                    String s1=m1.group(1).trim();
                    System.out.println(s1);
                    baseMsg = baseMsg.split(m1.group(1))[1];
                }
                Matcher m2= Pattern.compile("数据发生机构名称(.*?)单位电话").matcher(baseMsg);
                if(m2.find()){
                    String s2 =m2.group(1).replaceAll("数据发生机构名称","").trim();
                    System.out.println(s2);
                    baseMsg = baseMsg.split(m2.group(1))[1];
                }
            }

            //System.out.println(content);
           /*
            // String rgex = "查询原因"+"(.*?)"+"个人基本信息";
            //String str =DealStrSub.getSubUtilSimple(content, rgex);
            String str = DealStrSub.subString(content, "联系电话", "数据发生机构名称");
            int begin = content.indexOf("fwer");
            System.out.println(begin);
            str = str.replaceAll("\r|\n", "");
            String[] ss = str.split(" ");
            for (String sss : ss) {
                System.out.println(sss);
            }
            //pdfutil.toTextFile(content, txtfilePath);
            System.out.println("Finished !");*/
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
    public Messages getTextByArea(){
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
