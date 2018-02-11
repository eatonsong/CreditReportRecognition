package com.isoftstone.util;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.util.PDFTextStripperByArea;

import java.awt.Rectangle;

import java.util.List;


public class ExtractTextByArea
{
    private ExtractTextByArea()
    {

    }

    public static void main( String[] args ) throws Exception
    {
        String file = "src/main/resources/pdf/002.pdf";
        PDDocument document = null;
        try
        {
            document = PDDocument.load( file);
            if( document.isEncrypted() )
            {
                document.decrypt( "" );
                System.err.println( "Error: Document is encrypted with a password." );
                System.exit( 1 );
            }
            PDFTextStripperByArea stripper = new PDFTextStripperByArea();
            stripper.setSortByPosition( true );
            Rectangle rect = new Rectangle( 10, 280, 275, 60 );
            stripper.addRegion( "class1", rect );
            List allPages = document.getDocumentCatalog().getAllPages();
            PDPage firstPage = (PDPage)allPages.get( 0 );
            stripper.extractRegions( firstPage );
            System.out.println( "Text in the area:" + rect );
            System.out.println( stripper.getTextForRegion( "class1" ) );

        }
        finally
        {
            if( document != null )
            {
                document.close();
            }
        }
    }

}
