package FileIO;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.fdf.FDFPage;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;

public class CreatePdf {
	public static void main(String args[]) throws IOException {
		//eigene Resources erstellen
		PDResources resources = new PDResources();
		//eigene Font Namen definieren und in resources hinterlegen
		resources.put(COSName.getPDFName("HeBo"), PDType1Font.HELVETICA_BOLD);
		resources.put(COSName.getPDFName("Helv"), PDType1Font.HELVETICA);
		// anderes Problem: "Cannot read while there is an open stream writer"

		// PDF Vorlage wird geladen
		PDDocument pdfDocument = PDDocument.load(new File(".\\src\\pdfs\\testPdf.pdf"));

		// Form Füllende Funktionen werden geladen
		PDDocumentCatalog docCatalog = pdfDocument.getDocumentCatalog();
		PDAcroForm acroForm = docCatalog.getAcroForm();
		acroForm.setDefaultResources(resources);
		// Font / Größe soll bestimmt werden erzeugt jedoch Problem (s."filledTestPdf.pdf") 		
		//		PDPage page = pdfDocument.getPage(0);
		//		PDPageContentStream contentStream = new PDPageContentStream(pdfDocument,page);
		//		contentStream.setFont(PDType1Font.TIMES_ROMAN, 25);

		if (acroForm != null) {

			// Form Felder werden gefunden und ausgefüllt
			PDField monF = (PDField) acroForm.getField("mon");
			PDField tueF = (PDField) acroForm.getField("tue");
			PDField wedF = (PDField) acroForm.getField("wed");
			PDField thuF = (PDField) acroForm.getField("thu");
			PDField friF = (PDField) acroForm.getField("fri");
			PDField satF = (PDField) acroForm.getField("sat");
			PDField sunF = (PDField) acroForm.getField("sun");
			
			((PDTextField) monF).setDefaultAppearance("/HeBo 18 Tf 0 g");
			((PDTextField) tueF).setDefaultAppearance("/HeBo 18 Tf 0 g");
			((PDTextField) wedF).setDefaultAppearance("/HeBo 18 Tf 0 g");
			((PDTextField) thuF).setDefaultAppearance("/HeBo 18 Tf 0 g");
			((PDTextField) friF).setDefaultAppearance("/HeBo 18 Tf 0 g");
			((PDTextField) satF).setDefaultAppearance("/HeBo 18 Tf 0 g");
			((PDTextField) sunF).setDefaultAppearance("/HeBo 18 Tf 0 g");
			//COSDictionary dict = ((PDField) monF).getDictionary();

			monF.setValue("hallo ich bin der Montag");
			tueF.setValue("und ich bims der dienstag");
			wedF.setValue("hallo ich bin der Mittwoch");
			thuF.setValue("und ich bims der Donnerstag");
			friF.setValue("hallo ich bin der Freitag");
			satF.setValue("und ich bims der Samstag");
			sunF.setValue("hallo ich bin der Sontag");
			
		}

		// Veränderung wird in neuer Datei gespeichert und geschlossen
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