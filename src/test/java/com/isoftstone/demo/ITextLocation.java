package com.isoftstone.demo;

import java.io.IOException;
import com.itextpdf.awt.geom.Rectangle2D.Float;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.TextRenderInfo;

public class ITextLocation
{
    // 定义关键字
    private static String KEY_WORD = "出生日期";
    // 定义返回值
    private static float[] resu = null;
    // 定义返回页码
    private static int i = 0;

    public static void main(String[] args) {
        String pdfPath = "src/main/resources/pdf/001.pdf";
        float[] ff = getKeyWords(pdfPath);
        if(ff != null){
            for (float f: ff ) {
                System.out.println(f);
            }
        }
    }
    /*
     * 返回关键字所在的坐标和页数 float[0] >> X float[1] >> Y float[2] >> page
     */
    private static float[] getKeyWords(String filePath)
    {
        try
        {
            PdfReader pdfReader = new PdfReader(filePath);
            int pageNum = pdfReader.getNumberOfPages();
            PdfReaderContentParser pdfReaderContentParser = new PdfReaderContentParser(
                    pdfReader);

            // 下标从1开始
            for (i = 1; i < pageNum; i++)
            {
                pdfReaderContentParser.processContent(i, new RenderListener()
                {

                    @Override
                    public void renderText(TextRenderInfo textRenderInfo)
                    {
                        String text = textRenderInfo.getText();
                        if (null != text && text.contains(KEY_WORD))
                        {
                            Float boundingRectange = textRenderInfo
                                    .getBaseline().getBoundingRectange();
                            resu = new float[3];
                            resu[0] = boundingRectange.x;
                            resu[1] = boundingRectange.y;
                            resu[2] = i;
                        }
                    }

                    @Override
                    public void renderImage(ImageRenderInfo arg0)
                    {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void endTextBlock()
                    {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void beginTextBlock()
                    {
                        // TODO Auto-generated method stub

                    }
                });
            }
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resu;
    }

}
