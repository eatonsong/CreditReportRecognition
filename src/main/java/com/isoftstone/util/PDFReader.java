package com.isoftstone.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.util.PDFText2HTML;
import org.apache.pdfbox.util.PDFTextStripper;

/**
 *
 * @author Angela
 */
public class PDFReader {

    /**
     * 获取格式化后的时间信息
     * @param calendar   时间信息
     * @return
     */
    public static String dateFormat( Calendar calendar ){
        if( null == calendar )
            return null;
        String date = null;
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat format = new SimpleDateFormat( pattern );
        date = format.format( calendar.getTime() );
        return date == null ? "" : date;
    }

    /**打印纲要**/
    public static void getPDFOutline(String file){
        try {
            //打开pdf文件流
            FileInputStream fis = new   FileInputStream(file);
            //加载 pdf 文档,获取PDDocument文档对象
            PDDocument document=PDDocument.load(fis);
            //获取PDDocumentCatalog文档目录对象
            PDDocumentCatalog catalog=document.getDocumentCatalog();
            //获取PDDocumentOutline文档纲要对象
            PDDocumentOutline outline=catalog.getDocumentOutline();
            //获取第一个纲要条目（标题1）
            PDOutlineItem item=outline.getFirstChild();
            if(outline!=null){
                //遍历每一个标题1
                while(item!=null){
                    //打印标题1的文本
                    System.out.println("Item:"+item.getTitle());
                    //获取标题1下的第一个子标题（标题2）
                    PDOutlineItem child=item.getFirstChild();
                    //遍历每一个标题2
                    while(child!=null){
                        //打印标题2的文本
                        System.out.println("    Child:"+child.getTitle());
                        //指向下一个标题2
                        child=child.getNextSibling();
                    }
                    //指向下一个标题1
                    item=item.getNextSibling();
                }
            }
            //关闭输入流
            document.close();
            fis.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

    /**打印一级目录**/
    public static void getPDFCatalog(String file){
        try {
            //打开pdf文件流
            FileInputStream fis = new   FileInputStream(file);
            //加载 pdf 文档,获取PDDocument文档对象
            PDDocument document=PDDocument.load(fis);
            //获取PDDocumentCatalog文档目录对象
            PDDocumentCatalog catalog=document.getDocumentCatalog();
            //获取PDDocumentOutline文档纲要对象
            PDDocumentOutline outline=catalog.getDocumentOutline();
            //获取第一个纲要条目（标题1）
            if(outline!=null){
                PDOutlineItem item=outline.getFirstChild();
                //遍历每一个标题1
                while(item!=null){
                    //打印标题1的文本
                    System.out.println("Item:"+item.getTitle());
                    //指向下一个标题1
                    item=item.getNextSibling();
                }
            }
            //关闭输入流
            document.close();
            fis.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

    /**获取PDF文档元数据**/
    public static void getPDFInformation(String file){
        try {
            //打开pdf文件流
            FileInputStream fis = new   FileInputStream(file);
            //加载 pdf 文档,获取PDDocument文档对象
            PDDocument document=PDDocument.load(fis);
            /** 文档属性信息 **/
            PDDocumentInformation info = document.getDocumentInformation();

            System.out.println("页数:"+document.getNumberOfPages());

            System.out.println( "标题:" + info.getTitle() );
            System.out.println( "主题:" + info.getSubject() );
            System.out.println( "作者:" + info.getAuthor() );
            System.out.println( "关键字:" + info.getKeywords() );

            System.out.println( "应用程序:" + info.getCreator() );
            System.out.println( "pdf 制作程序:" + info.getProducer() );

            System.out.println( "Trapped:" + info.getTrapped() );

            System.out.println( "创建时间:" + dateFormat( info.getCreationDate() ));
            System.out.println( "修改时间:" + dateFormat( info.getModificationDate()));

            //关闭输入流
            document.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDFReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PDFReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**提取pdf文本**/
    public static void extractTXT(String file){
        try{
            //打开pdf文件流
            FileInputStream fis = new   FileInputStream(file);
            //实例化一个PDF解析器
            PDFParser parser = new PDFParser(fis);
            //解析pdf文档
            parser.parse();
            //获取PDDocument文档对象
            PDDocument document=parser.getPDDocument();
            //获取一个PDFTextStripper文本剥离对象
            PDFTextStripper stripper = new PDFTextStripper();
            //获取文本内容
            String content = stripper.getText(document);
            //打印内容
            System.out.println( "内容:" + content );
            document.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDFReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PDFReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 提取部分页面文本
     * @param file pdf文档路径
     * @param startPage 开始页数
     * @param endPage 结束页数
     */
    public static void extractTXT(String file,int startPage,int endPage){
        try{
            //打开pdf文件流
            FileInputStream fis = new   FileInputStream(file);
            //实例化一个PDF解析器
            PDFParser parser = new PDFParser(fis);
            //解析pdf文档
            parser.parse();
            //获取PDDocument文档对象
            PDDocument document=parser.getPDDocument();
            //获取一个PDFTextStripper文本剥离对象
            PDFTextStripper stripper = new PDFTextStripper();
            // 设置起始页
            stripper.setStartPage(startPage);
            // 设置结束页
            stripper.setEndPage(endPage);
            //获取文本内容
            String content = stripper.getText(document);
            //打印内容
            System.out.println( "内容:" + content );
            document.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDFReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PDFReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 提取图片并保存
     * @param file PDF文档路径
     * @param imgSavePath 图片保存路径
     */
    public static void extractImage(String file,String imgSavePath){
        try{
            //打开pdf文件流
            FileInputStream fis = new   FileInputStream(file);
            //加载 pdf 文档,获取PDDocument文档对象
            PDDocument document=PDDocument.load(fis);
            /** 文档页面信息 **/
            //获取PDDocumentCatalog文档目录对象
            PDDocumentCatalog catalog = document.getDocumentCatalog();
            //获取文档页面PDPage列表
            List pages = catalog.getAllPages();
            int count = 1;
            int pageNum=pages.size();   //文档页数
            //遍历每一页
            for( int i = 0; i < pageNum; i++ ){
                //取得第i页
                PDPage page = ( PDPage ) pages.get( i );
                if( null != page ){
                    PDResources resource = page.findResources();
                    //获取页面图片信息
                    Map<String,PDXObjectImage> imgs = resource.getImages();
                    for(Map.Entry<String,PDXObjectImage> me: imgs.entrySet()){
                        //System.out.println(me.getKey());
                        PDXObjectImage img = me.getValue();
                        //保存图片，会自动添加图片后缀类型
                        img.write2file( imgSavePath + count );
                        count++;
                    }
                }
            }
            document.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDFReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PDFReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 提取文本并保存
     * @param file PDF文档路径
     * @param savePath 文本保存路径
     */
    public static void extractTXT(String file,String savePath){
        try{
            //打开pdf文件流
            FileInputStream fis = new   FileInputStream(file);
            //实例化一个PDF解析器
            PDFParser parser = new PDFParser(fis);
            //解析pdf文档
            parser.parse();
            //获取PDDocument文档对象
            PDDocument document=parser.getPDDocument();
            //获取一个PDFTextStripper文本剥离对象
            PDFTextStripper stripper = new PDFTextStripper();
            //创建一个输出流
            Writer writer=new OutputStreamWriter(new FileOutputStream(savePath));
            //保存文本内容
            stripper.writeText(document, writer);
            //关闭输出流
            writer.close();
            //关闭输入流
            document.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDFReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PDFReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 提取部分页面文本并保存
     * @param file PDF文档路径
     * @param startPage 开始页数
     * @param endPage 结束页数
     * @param savePath 文本保存路径
     */
    public static void extractTXT(String file,int startPage,
                                  int endPage,String savePath){
        try{
            //打开pdf文件流
            FileInputStream fis = new   FileInputStream(file);
            //实例化一个PDF解析器
            PDFParser parser = new PDFParser(fis);
            //解析pdf文档
            parser.parse();
            //获取PDDocument文档对象
            PDDocument document=parser.getPDDocument();
            //获取一个PDFTextStripper文本剥离对象
            PDFTextStripper stripper = new PDFTextStripper();
            //创建一个输出流
            Writer writer=new OutputStreamWriter(new FileOutputStream(savePath));
            // 设置起始页
            stripper.setStartPage(startPage);
            // 设置结束页
            stripper.setEndPage(endPage);
            //保存文本内容
            stripper.writeText(document, writer);
            //关闭输出流
            writer.close();
            //关闭输入流
            document.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDFReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PDFReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]){
        String pdfPath = "src/main/resources/pdf/001.pdf";
        String txtfilePath = "src/main/resources/output/test.txt";
        long startTime=System.currentTimeMillis();
        //extractTXT(pdfPath,txtfilePath);
        //getPDFCatalog(pdfPath);
        //获取pdf元数据
        //getPDFInformation(pdfPath);
        extractTXT(pdfPath);
        long endTime=System.currentTimeMillis();
        System.out.println("读写所用时间为："+(endTime-startTime)+"ms");
    }

}