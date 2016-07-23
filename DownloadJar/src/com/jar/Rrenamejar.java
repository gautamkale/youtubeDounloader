package com.jar;

import java.io.File;
import java.io.IOException;

public class Rrenamejar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final File folder = new File("E:\\Jar");
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
             File newName= new File(str.substring(0,str.lastIndexOf("(")));
            // fileEntry.renameTo(newName);
           System.out.println(newName.getAbsolutePath());
        }
    }
}
}
