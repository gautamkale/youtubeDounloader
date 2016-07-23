package com.read.org;

public class CoverToDoc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "C:\\Users\\rock\\Desktop\\pdf.pdf";

		//Instantiate the Document object
		com.aspose.pdf.Document document = new com.aspose.pdf.Document(filePath);

		//Create DocSaveOptions object
		com.aspose.pdf.DocSaveOptions saveOptions = new com.aspose.pdf.DocSaveOptions();

		//Set the recognition mode as Flow
		saveOptions.setMode(com.aspose.pdf.DocSaveOptions.RecognitionMode.Flow);

		//Set the Horizontal proximity as 2.5
		saveOptions.setRelativeHorizontalProximity(2.5f);

		//Enable the value to recognize bullets during conversion process
		saveOptions.setRecognizeBullets(true);

		//Save the resultant DOC file
		document.save("C:\\Users\\rock\\Desktop\\pdf.doc", saveOptions);

	}

}
