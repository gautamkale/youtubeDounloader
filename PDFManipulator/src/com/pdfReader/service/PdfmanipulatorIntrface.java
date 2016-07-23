package com.pdfReader.service;



import java.io.InputStream;
import java.util.List;

public interface PdfmanipulatorIntrface  {

	public List<String> getSplitPdf(String str);
	public String downloadPdf(List<String> lst,String uploadFileName);
}
