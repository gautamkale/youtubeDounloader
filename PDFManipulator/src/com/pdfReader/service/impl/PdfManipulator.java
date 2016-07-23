package com.pdfReader.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.pdfReader.service.PdfmanipulatorIntrface;

public class PdfManipulator implements PdfmanipulatorIntrface
{
	
	@Override
	public List<String> getSplitPdf(String str) {
		List<String> files=new ArrayList<String>();
	    try {
	    	String inFile = str.toLowerCase();
            System.out.println ("Reading " + inFile);
            PdfReader reader = new PdfReader(inFile);
            int n = reader.getNumberOfPages();
            System.out.println ("Number of pages : " + n);
            int i = 0;            
            while ( i < n ) {
            	String  outFile = inFile.substring(0, inFile.indexOf(".pdf")) 
                    + "-" + String.format("%03d", i + 1) + ".pdf"; 
                System.out.println ("Writing " + outFile);
                Document document = new Document(reader.getPageSizeWithRotation(1));
                PdfCopy writer = new PdfCopy(document, new FileOutputStream(outFile));
                document.open();
                PdfImportedPage page = writer.getImportedPage(reader, ++i);
                writer.addPage(page);
                document.close();
                writer.close();
               files.add(outFile);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
            
        }
	    return files;

	}
	public String downloadPdf(List<String> lst, String uploadFileName)
	{
		FileOutputStream fos =null;
		 byte[] buffer = new byte[1024];
		 
		String zipFile=uploadFileName.substring(uploadFileName.lastIndexOf("/"), uploadFileName.indexOf(".pdf"))+".zip";
		InputStream fileInputStream=null;
		try {
			fos = new FileOutputStream(zipFile );
			ZipOutputStream zos = new ZipOutputStream(fos);
			for(String s:lst)
			{
				ZipEntry ze= new ZipEntry(s);
	        	zos.putNextEntry(ze);
			fileInputStream = new FileInputStream(new File(s));
			int len;
        	while ((len = fileInputStream.read(buffer)) > 0) {
        		zos.write(buffer, 0, len);
        	}
        	fileInputStream.close();
			}
			zos.closeEntry();
			zos.close();
			fos.close();
			
		} catch 	(FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return zipFile;
		
	}
	

}
