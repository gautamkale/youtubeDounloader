package com.jar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DownloadJar {
public static void main(String args[])
{
	
	final File folder = new File("E:/JarREfFile");
	try {
		listFilesForFolder(folder,folder.getAbsolutePath());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
public static void listFilesForFolder(final File folder,String folderName) throws IOException {
	int i=0;
   for (final File fileEntry : folder.listFiles()) {
        if (fileEntry.isDirectory()) {
            listFilesForFolder(fileEntry,fileEntry.getName());
        } else {
           // System.out.println(fileEntry.getName());
            String str=fileEntry.getName().toLowerCase();
             
            if(str.contains("download"))
            {
            		System.out.println(i);
            	parseHtml(fileEntry,folderName);
            	i++;
            }
        }
    }
	/*File[] list= folder.listFiles();
	for(int i=0;i<list.length;i++)
	{
		//parseHtml(list[i],folderName);
		if(list[i].getName().equals("Downloadjonasgeneratorsbase530m7jar.html"))
		{
			System.out.println(i);
		}
		 String str=list[i].getName().toLowerCase();
         
         if(str.contains("download"))
         {
         	parseHtml(list[i],folderName);
         }
	}*/
}
 public static void parseHtml(File fileName,String folderName) throws IOException
 {
	// File input = new File(fileName);
	 Document doc=null;
	 String url=null;
	String zipFileName=null;
	 try {
		 doc = Jsoup.parse(fileName, "UTF-8", "e");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 Elements links = doc.select("a[href]");
		for (Element link : links) {

			// get the value from href attribute
			//System.out.println("\nlink : " + link.attr("href"));
			//System.out.println("text : " + link.text());
			url=link.attr("href");
			String str=link.text();
			if(url.contains(".zip")){
			zipFileName=str.substring(str.lastIndexOf("/")+1,str.lastIndexOf("("));
			System.out.println("zip name"+zipFileName);
			/*if(zipFileName.equals("axis-10.3.jar"))
			{*/
				System.out.println("zip name"+fileName);
			//}
			downloadZipFile(url, zipFileName,folderName);
			}
			
		}
 }
 public static void downloadZipFile(String zipName,String fileName,String folderName)  {
     String saveTo = "F:/Jar/"+folderName+"/";
     boolean file =new File(saveTo).mkdirs();
    /* if(!file.exists())
     {
    	 try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }*/PrintStream ps =null;
     URLConnection conn=null;
     InputStream in=null;
     FileOutputStream out=null;
    try {
    	
       //   ps = new PrintStream(ecpt);
         URL url = new URL(zipName);
          conn = url.openConnection();
          in = conn.getInputStream();
          File f = new File(saveTo+"/" + fileName);
         
          if(!f.exists()){
          out = new FileOutputStream(saveTo+"/" + fileName);
          if(in!=null){ 
         byte[] b = new byte[1024];
         int count;
         while ((count = in.read(b)) >= 0) {
             out.write(b, 0, count);
            // System.out.println("in");
         }
         out.flush(); 
         System.out.println("Complet file dowloading");
         }  
         
          }else
          {
        	  System.out.println(f.getAbsolutePath()+"exist");
          }
             

     } catch (IOException e) {
         e.printStackTrace();
         
     }
     catch (Exception e) {
         e.printStackTrace();
         
     }
     finally
     {
    	 try {if(in!=null && out!=null){
			out.close();
			in.close();   }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
     }
 }

}
