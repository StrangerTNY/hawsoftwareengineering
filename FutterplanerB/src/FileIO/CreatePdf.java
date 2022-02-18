package FileIO;

import java.io.File;
import java.io.IOException;

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
		
		// Form Füllende Funktionen werden geladen
		PDDocumentCatalog docCatalog = pdfDocument.getDocumentCatalog();
		PDAcroForm acroForm = docCatalog.getAcroForm();
		
		// Font / Größe soll bestimmt werden erzeugt jedoch Problem (s."filledTestPdf.pdf") 		
		PDPage page = pdfDocument.getPage(0);
		PDPageContentStream contentStream = new PDPageContentStream(pdfDocument,page);
		contentStream.setFont(PDType1Font.TIMES_ROMAN, 25);
		
		if (acroForm != null) {
			
			// Form Felder werden gefunden und ausgefüllt
			PDField monF = (PDField) acroForm.getField("mon");
			PDField tueF = (PDField) acroForm.getField("tue");
			monF.setValue("hallo ich bin der Montag");
			tueF.setValue("und ich bims der dienstag");
		}
		
		// Veränderung wird in neuer Datei gespeichert und geschlossen
		pdfDocument.save(".\\src\\pdfs\\filledTestPdf2.pdf");
		pdfDocument.close();
		contentStream.close();
		
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