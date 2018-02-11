package com.isoftstone.demo;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.*;

public class ITextReader {
    public static void main(String[] args) throws IOException {
        //System.out.print(getPdfFileText("E://test.pdf"));
        parsePdf("E://ExampleFile.pdf","E://test.txt");

    }
    /**
     * @param pdf PDF文件路径
     * @param txt 输出文本文件路径
     * @throws IOException
     */
    public static void parsePdf(String pdf, String txt) throws IOException {
        PdfReader reader = new PdfReader(pdf);
        PrintWriter out = new PrintWriter(new FileOutputStream(txt));
        Rectangle rect = new Rectangle(70, 80, 490, 580);
        RenderFilter filter = new RegionTextRenderFilter(rect);
        TextExtractionStrategy strategy;
        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            strategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy(), filter);
            out.println(PdfTextExtractor.getTextFromPage(reader, i, strategy));
        }
        out.flush();
        out.close();
        reader.close();
    }
    public static String getPdfFileText(String fileName) throws IOException {
        PdfReader reader = new PdfReader(fileName);
        PdfReaderContentParser parser = new PdfReaderContentParser(reader);
        StringBuffer buff = new StringBuffer();
        TextExtractionStrategy strategy;
        System.out.println("yeshu" + reader.getNumberOfPages());
        for (int i = 1; i <= reader.getNumberOfPages(); i++) {

            strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
            buff.append(strategy.getResultantText());
        }
        return buff.toString();
    }
}