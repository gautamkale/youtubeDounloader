package com.read.org;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Mp3FileReader {

	
	static void listFilesForFolder(final File folder,String i) throws IOException {
		
		String path = "E:\\OnlyPDF\\";
		String destDir = "";
		
		
	    for (final File fileEntry : folder.listFiles()) {
	    	 
	        if (fileEntry.isDirectory()) {
	        	destDir=fileEntry.getName();
	            listFilesForFolder(fileEntry,destDir);
	            System.out.println("in folder file "+fileEntry.getName());
	            
	        } else {
	        	 if (fileEntry.getName().endsWith(".pdf") )
	             {
	        		 System.out.println(i+"      file "+fileEntry.getAbsolutePath());
	        		if( fileEntry.renameTo(new File(path +i+fileEntry.getName())))               
	                System.out.println(i+"      file "+fileEntry.getAbsolutePath());
	        		
	             }
	        	 
	        	// System.out.println(i+"  " +fileEntry.getName()+"file outside "+fileEntry.getAbsolutePath());
	           
	        }
	       
	        
	    }
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		final File folder = new File("E:\\ebooks\\ebooks\\www.free-ebooks.net\\ebook");
		String s="";
		listFilesForFolder(folder,s);
	}
	
}
