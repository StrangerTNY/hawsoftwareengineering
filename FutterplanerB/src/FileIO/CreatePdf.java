package FileIO;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.fdf.FDFPage;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

public class CreatePdf {
	public static void main(String args[]) throws IOException {
		
		// anderes Problem: "Cannot read while there is an open stream writer"
		
		// PDF Vorlage wird geladen
		PDDocument pdfDocument = PDDocument.load(new File(".\\src\\pdfs\\testPdf.pdf"));
		
		// Form F�llende Funktionen werden geladen
		PDDocumentCatalog docCatalog = pdfDocument.getDocumentCatalog();
		PDAcroForm acroForm = docCatalog.getAcroForm();
		
		// Font / Gr��e soll bestimmt werden erzeugt jedoch Problem (s."filledTestPdf.pdf") 		
//		PDPage page = pdfDocument.getPage(0);
//		PDPageContentStream contentStream = new PDPageContentStream(pdfDocument,page);
//		contentStream.setFont(PDType1Font.TIMES_ROMAN, 25);
		
		if (acroForm != null) {
			
			// Form Felder werden gefunden und ausgef�llt
			PDField monF = (PDField) acroForm.getField("mon");
			PDField tueF = (PDField) acroForm.getField("tue");
			//COSDictionary dict = ((PDField) monF).getDictionary();
			
			monF.setValue("hallo ich bin der Montag");
			tueF.setValue("und ich bims der dienstag");
		}
		
		// Ver�nderung wird in neuer Datei gespeichert und geschlossen
//		contentStream.close();
		pdfDocument.save(".\\src\\pdfs\\filledTestPdf3.pdf");
		pdfDocument.close();
		
		// veraltet:
		
//		PDDocument pdfdoc = new PDDocument();
//		pdfdoc.addPage(new PDPage());
//		//path where the PDF file will be store  
//		pdfdoc.save(".\\src\\pdfs\\pups2.pdf");
//		//prints the message if the PDF is created successfully   
//		System.out.println("PDF created");
//		//closes the document  
//		pdfdoc.close();
	}
}