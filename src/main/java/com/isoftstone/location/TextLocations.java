package com.isoftstone.location;/*
 * @package_name com.isoftstone.dto
 * @date 2018/2/12 13:55  
 * @user Eaton
 */

import java.awt.*;
import java.io.*;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.apache.pdfbox.text.TextPosition;

/**
 * This is an example on how to get some x/y coordinates of text.
 *
 * @author Ben Litchfield
 */


public class TextLocations extends PDFTextStripper {

    /**
     * Instantiate a new PDFTextStripper object.
     *
     * @throws IOException If there is an error loading the properties.
     */
    public TextLocations() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        new TextLocations().getMessages("src/main/resources/pdf/002.pdf");
    }
    public void getMessages(String filePath) throws IOException {
        PDDocument document = PDDocument.load(new FileInputStream(filePath));
        PDFTextStripper stripper = new TextLocations();
        stripper.setSortByPosition(true);
        stripper.setStartPage(0);
        stripper.setEndPage(document.getNumberOfPages());
        Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
        stripper.writeText(document, dummy);
    }

    /**
     * Override the default functionality of PDFTextStripper.
     */
    @Override
    protected void writeString(String string, List<TextPosition> textPositions) throws IOException {
        //System.out.println(string);
        String str ="";
        if (str.equals(string)) {
            for (TextPosition text : textPositions) {
                System.out.println("String[" +
                        " x=" + text.getXDirAdj() +
                        " y=" + text.getYDirAdj() +
                        " fs=" + text.getFontSize() +
                        " xscale=" + text.getXScale() +
                        " yscale=" + text.getYScale() +
                        " width=" + text.getWidthDirAdj() +
                        " height=" + text.getHeightDir() +
                        " space=" + text.getWidthOfSpace() + "]" + text.getUnicode());
            }
           // readText(textPositions);
        }

    }

    protected void readText(List<TextPosition> l) throws IOException {
        int x0=(int)l.get(0).getXDirAdj();
        int x9=(int)l.get(l.size() - 1).getXDirAdj();
        int y0=(int)l.get(0).getYDirAdj();
        int y9=(int)l.get(l.size() - 1).getYDirAdj();
        //x方向补偿
        int xx=30;
        //y方向补偿
        int yy=0;
        //l.get(l.size() - 1).getX() l.get(0).getXDirAdj();
        PDFTextStripperByArea stripper1 = new PDFTextStripperByArea();
        stripper1.setSortByPosition(true);
       // Rectangle rect = new Rectangle(x0-xx, y0+6+yy, x9-x0+2*xx+(int)l.get(0).getWidthDirAdj(), 40);
        Rectangle rect = new Rectangle(x9, y0+6+yy, x9-x0+2*xx+(int)l.get(0).getWidthDirAdj(), 40);
        stripper1.addRegion("class1", rect);
        PDPage firstPage = document.getPage(0);
        stripper1.extractRegions(firstPage);
        System.out.println("Text in the area:" + rect);
        System.out.println(stripper1.getTextForRegion("class1"));
    }
}
