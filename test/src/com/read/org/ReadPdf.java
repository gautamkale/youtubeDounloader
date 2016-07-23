package com.read.org;

import java.io.IOException;

import com.gnostice.pdfone.PDFOne;
import com.gnostice.pdfone.PdfDocument;
import com.gnostice.pdfone.PdfException;

public class ReadPdf
{
    static
    {
        PDFOne.activate("T95VZE:W8HBPVA:74VQ8QV:LO4V8",
            "9B1HRZAP:X5853ERNE:5EREMEGRQ:TX1R10");
    }

    /*
     * Usage : java DocInfoChanged <input file path> <output file
     * path>
     */
    public static void main(String[] args) throws IOException,
        PdfException
    {
        // ///////////////////////////////////////////////
        // Open a document and delete some pages in it //
        // ///////////////////////////////////////////////

        try
        {
            /* Create a new PdfDocument instance */
            PdfDocument d = new PdfDocument();

            /* Load the PDF document into the document object */
            d.load("C:\\Users\\rock\\Desktop\\1196163-Offerds(1)_Unlocked.pdf");

            /* Delete pages 1 to 3 from the document */
            d.deletePages("26");
            int r=d.getPageCount();
            System.out.println("no. of pages are"+r);
            d.setOpenAfterSave(true);

            /* Save the document object */
            d.save("C:\\Users\\rock\\Desktop\\a.pdf");

            /*
             * Dispose the I/O files associated with this document
             * object
             */
            d.close();
        }
        catch (ArrayIndexOutOfBoundsException n)
        {
            System.out.println("Usage : java DocInfoChanged "
                + "<input file path> <output file path>");
        }
    }
}
