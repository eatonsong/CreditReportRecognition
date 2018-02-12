package com.isoftstone.util;

/*@package_name com.isoftstone.util
 * @date 2018/2/11 14:52
 * @user Eaton*/
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.FileInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;

public class PdfboxUtil {



    public static void main(String[] args) {
        String pdfPath = "src/main/resources/pdf/001.pdf";
        String txtfilePath = "src/main/resources/output/test.txt";
        PdfboxUtil pdfutil = new PdfboxUtil();
        try {
            String content = pdfutil.getTextFromPdf(pdfPath);
           // String rgex = "查询原因"+"(.*?)"+"个人基本信息";
            //String str =DealStrSub.getSubUtilSimple(content, rgex);
            String str =DealStrSub.subString(content,"联系电话","数据发生机构名称");
            int begin =content.indexOf("fwer");
            System.out.println(begin);
            str = str.replaceAll("\r|\n", "");
            String []ss =str.split(" ");
            for(String sss:ss){
                System.out.println(sss);
            }
            //pdfutil.toTextFile(content, txtfilePath);
            System.out.println("Finished !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

/*
*
     * 读取PDF文件的文字内容
     * @param pdfPath
     * @throws Exception

*/

    public String getTextFromPdf(String pdfPath) throws Exception {
        // 是否排序
        boolean sort = false;
        // 开始提取页数
        int startPage = 1;
        // 结束提取页数
        int endPage = Integer.MAX_VALUE;
        String content = null;
        InputStream input = null;
        File pdfFile = new File(pdfPath);
        PDDocument document = null;
        try {
            input = new FileInputStream(pdfFile);
            // 加载 pdf 文档
            document = PDDocument.load(input);
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
                throw e;
            }
            System.out.println("Get PDF Content ...");
        } catch (Exception e) {
            throw e;
        } finally {
            if (null != input){
                input.close();
            }
            if (null != document){
                document.close();
            }
        }
        return content;
    }
/*
*
     * 把PDF文件内容写入到txt文件中
     * @param pdfContent
     * @param filePath
*/


    public void toTextFile(String pdfContent,String filePath) {
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
