package FileIO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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

import Futter.Futter;

public class CreatePdf {
	ArrayList<Futter> liste = new ArrayList<Futter>();
	
	
	public void generatePDF(ArrayList<Futter> liste, String petName) throws IOException {
		//eigene Resources erstellen
		PDResources resources = new PDResources();
		//eigene Font Namen definieren und in resources hinterlegen
		resources.put(COSName.getPDFName("HeBo"), PDType1Font.HELVETICA_BOLD);
		resources.put(COSName.getPDFName("Helv"), PDType1Font.HELVETICA);

		// PDF Vorlage wird geladen
		PDDocument pdfDocument = PDDocument.load(new File(".\\src\\pdfs\\PdfVorlage.pdf"));

		// Form Füllende Funktionen werden geladen
		PDDocumentCatalog docCatalog = pdfDocument.getDocumentCatalog();
		PDAcroForm acroForm = docCatalog.getAcroForm();
		acroForm.setDefaultResources(resources);
		
		if (acroForm != null) {

			// Form Felder werden gefunden und ausgefüllt
			PDField monF = (PDField) acroForm.getField("mon");
			PDField tueF = (PDField) acroForm.getField("tue");
			PDField wedF = (PDField) acroForm.getField("wed");
			PDField thuF = (PDField) acroForm.getField("thu");
			PDField friF = (PDField) acroForm.getField("fri");
			PDField satF = (PDField) acroForm.getField("sat");
			PDField sunF = (PDField) acroForm.getField("sun");
			PDField name = (PDField) acroForm.getField("name");
			
			((PDTextField) monF).setDefaultAppearance("/HeBo 18 Tf 0.28 0.29 0.43 rg");
			((PDTextField) tueF).setDefaultAppearance("/HeBo 18 Tf 0.28 0.29 0.43 rg");
			((PDTextField) wedF).setDefaultAppearance("/HeBo 18 Tf 0.28 0.29 0.43 rg");
			((PDTextField) thuF).setDefaultAppearance("/HeBo 18 Tf 0.28 0.29 0.43 rg");
			((PDTextField) friF).setDefaultAppearance("/HeBo 18 Tf 0.28 0.29 0.43 rg");
			((PDTextField) satF).setDefaultAppearance("/HeBo 18 Tf 0.28 0.29 0.43 rg");
			((PDTextField) sunF).setDefaultAppearance("/HeBo 18 Tf 0.28 0.29 0.43 rg");
			((PDTextField) name).setDefaultAppearance("/HeBo 18 Tf 0.28 0.29 0.43 rg");
			//COSDictionary dict = ((PDField) monF).getDictionary();
			
			int lSize = liste.size();
			name.setValue(petName);
			monF.setValue(liste.get(0%lSize).getName() + "\n" + "\n" + "\n" + liste.get(3%lSize).getName());
			tueF.setValue(liste.get(1%lSize).getName() + "\n"+ "\n" + "\n" + liste.get(4%lSize).getName());
			wedF.setValue(liste.get(2%lSize).getName() + "\n"+ "\n" + "\n" + liste.get(5%lSize).getName());
			thuF.setValue(liste.get(3%lSize).getName() + "\n"+ "\n" + "\n" + liste.get(6%lSize).getName());
			friF.setValue(liste.get(4%lSize).getName() + "\n"+ "\n" + "\n" + liste.get(7%lSize).getName());
			satF.setValue(liste.get(5%lSize).getName() + "\n"+ "\n" + "\n" + liste.get(8%lSize).getName());
			sunF.setValue(liste.get(6%lSize).getName() + "\n" + "\n" + "\n"+ liste.get(9%lSize).getName());
			
		}

		// Veränderung wird in neuer Datei gespeichert und geschlossen
		//		contentStream.close();
		pdfDocument.save(".\\src\\pdfs\\filledTestPdf5.pdf");
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