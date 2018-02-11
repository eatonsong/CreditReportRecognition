package com.isoftstone.util;

import java.io.*;

import com.sun.xml.internal.fastinfoset.util.CharArray;
import org.apache.pdfbox.exceptions.InvalidPasswordException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.pdfbox.util.TextPosition;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PrintTextLocations extends PDFTextStripper {

    public PrintTextLocations() throws IOException {
        super.setSortByPosition(true);
    }
    static float yscale = 0;
    static Set<String> set=new HashSet<String>();
    public static void main(String[] args) throws Exception {

        PDDocument document = null;
        try {
            String pdfPath = "src/main/resources/pdf/002.pdf";
            File input = new File(pdfPath);
            document = PDDocument.load(input);
            if (document.isEncrypted()) {
                try {
                    document.decrypt("");
                } catch (Exception e) {
                    System.err.println("Error: Document is encrypted with a password.");
                    System.exit(1);
                }
            }
            PrintTextLocations printer = new PrintTextLocations();
            List allPages = document.getDocumentCatalog().getAllPages();
            for (int i = 0; i < allPages.size(); i++) {
                PDPage page = (PDPage) allPages.get(i);
                System.out.println("Processing page: " + i);
                PDStream contents = page.getContents();
                if (contents != null) {
                    printer.processStream(page, page.findResources(), page.getContents().getStream());
                }
            }
        } finally {
            if (document != null) {
                document.close();
            }
        }
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String str = it.next();
            System.out.println(str);
        }
    }

    /**
     * @param text The text to be processed
     */
    @Override /* this is questionable, not sure if needed... */
    protected void processTextPosition(TextPosition text) {
/*        if(yscale==text.getYScale()){
            System.out.print(text.getCharacter());
        }else{
            System.out.println();
        }
        yscale = text.getYScale();*/

/*        if(text.getWidthDirAdj()==15.0){//一级标题
            set.add(text.getYScale()+"");
            System.out.println(text.getY()+"");
        }*/
        String str="2018020600005110511238";
        char[] arr = str.toCharArray();
        for(char b:arr){
            if(String.valueOf(b).equals(text.getCharacter())){
                System.out.println("String[" +
                        " x="+ text.getXDirAdj() +
                        " y=" + text.getYDirAdj()+
                        " fs=" + text.getFontSize() +
                        " xscale="+ text.getXScale() +
                        " yscale="+ text.getYScale() +
                        " width="+ text.getWidthDirAdj() +
                        " height=" + text.getHeightDir() +
                        " space="+ text.getWidthOfSpace() + "]" + text.getCharacter());
            }
        }



     /*   System.out.println("String[" + text.getXDirAdj() + ","
                + text.getYDirAdj() + " fs=" + text.getFontSize() + " xscale="
                + text.getXScale() + " height=" + text.getHeightDir() + " space="
                + text.getWidthOfSpace() + " width="
                + text.getWidthDirAdj() + "]" + text.getCharacter());*/
    }
}
