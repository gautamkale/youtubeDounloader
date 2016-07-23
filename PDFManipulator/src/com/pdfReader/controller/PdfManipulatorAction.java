package com.pdfReader.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.pdfReader.service.PdfmanipulatorIntrface;
import com.pdfReader.service.impl.PdfManipulator;

public class PdfManipulatorAction extends ActionSupport {

	private File upload;
	private String uploadFileName;
	private String uploadContentType;

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	private List<String> outputFile;

	private String destPath;
	private String zipFile;

	public String getDestPath() {
		return destPath;
	}

	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}

	public List<String> getOutputFile() {
		return outputFile;
	}

	public void setOutputFile(List<String> outputFile) {
		this.outputFile = outputFile;
	}

	private InputStream fileInputStream;

	public String getZipFile() {
		return zipFile;
	}

	public void setZipFile(String zipFile) {
		this.zipFile = zipFile;
	}

	public InputStream getFileInputStream() {
		return fileInputStream;
	}

	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}


	public String execute() {
		destPath = "D:\\UploadFolder";

		PdfmanipulatorIntrface sp = null;
		try {
			sp = new PdfManipulator();

			System.out.println("Src File name: " + upload);
			System.out.println("Dst File name: " + uploadFileName);
			File destFile = new File(destPath, uploadFileName);
			FileUtils.copyFile(upload, destFile);
			String str = destFile.getAbsolutePath();
			outputFile = sp.getSplitPdf(str);
			zipFile = sp.downloadPdf(outputFile, uploadFileName);
			fileInputStream = new FileInputStream(zipFile);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "upload";

	}

}
