package GUI;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import FileIO.CreatePdf;
import Futter.Futter;

//Anzeige + Download
public class PlanerPage extends JFrame implements ActionListener{
	
	
	ArrayList<Futter> ausgewaehltesFutter;
	String pet;
	String petName;
	CreatePdf pdf = new CreatePdf();
	
	// Deklarieren der Objekte Frame, Label, Farben (Hintergrund)
	JFrame frame = new JFrame();
	JLabel label;
	Color purple = new Color (105, 104, 146);
	Color bri = new Color (140, 150, 180);
	private JButton download, back;
	
	public PlanerPage(String pet, String petName, ArrayList<Futter> Futter) throws IOException {
		super("Dein Plan");
		
		this.pet = pet;
		this.petName = petName;
		Collections.shuffle(Futter);
		this.ausgewaehltesFutter = Futter;
		
		JLabel label = new JLabel("<html>Futterplan<br>"+petName+"</html>"); //html Codierung für Umbruch
		
		//FrameLayout null
		frame.setLayout(null);
		
		//Panel Oben
		JPanel panel1 = new JPanel();
		panel1.setBackground(bri);
		panel1.setBounds(0,0,700,270);
		frame.add(panel1);
			
		//Panel Unten
		JPanel panel2 = new JPanel();
		panel2.setBackground(purple);
		panel2.setBounds(0,290,700,50);
		frame.add(panel2);
		
		//HeaderTabelle
		label.setBounds(0, 0, 400, 50);
		label.setFont(new Font(null, Font.PLAIN, 30));
		panel1.add(label);
		
		int lSize = ausgewaehltesFutter.size();
		
		//Tabelle - 7 Spalten - X Reihen
		// TODO Tabelle muss korrekt gefüllt werden (geplant war zufällig)
		String[][] plan = {
		         { ausgewaehltesFutter.get(0%lSize).getName(), ausgewaehltesFutter.get(1%lSize).getName(), ausgewaehltesFutter.get(2%lSize).getName(), ausgewaehltesFutter.get(3%lSize).getName(), ausgewaehltesFutter.get(4%lSize).getName(), ausgewaehltesFutter.get(5%lSize).getName(), ausgewaehltesFutter.get(6%lSize).getName() },
		         { ausgewaehltesFutter.get(3%lSize).getName(), ausgewaehltesFutter.get(4%lSize).getName(), ausgewaehltesFutter.get(5%lSize).getName(), ausgewaehltesFutter.get(6%lSize).getName(), ausgewaehltesFutter.get(7%lSize).getName(), ausgewaehltesFutter.get(8%lSize).getName(), ausgewaehltesFutter.get(9%lSize).getName()}
		      };
			// Tabellenheader
		      String[] header = { "MO", "DI", "MI", "DO", "FR", "SA", "SO"};
		      JTable table = new JTable(plan, header);
		      panel1.add(new JScrollPane(table));
	
		
		//DL Button
		download = new JButton("Als PDF speichern");
		download.setBounds(20,0,70,70);
		download.setFocusable(false);
		download.addActionListener(this);
		panel2.add(download);
		
		//Wdh Button
		back = new JButton("Nochmal");
		back.setBounds(100,0,70,70);
		back.setFocusable(false);
		back.addActionListener(this);
		panel2.add(back);
		
		//Hintergrundpanel für Farbe
		JPanel bg = new JPanel();
		bg.setBackground(purple);
		bg.setBounds(0,0,1000,700);
		frame.add(bg);
		
		//Fenstereinstellung
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700,400);
		
		
	}
	
	//Actionhandler für PDF-DL und Seitenwechsel
	// TODO: Es kann bei der Wahl von "Nochmal" bei den bestehenden Informationen zu Problemen führen
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == download) {
			frame.dispose();
			try {
				pdf.generatePDF(ausgewaehltesFutter);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			LandingPage endPage = new LandingPage();
		}
		else if(e.getSource() == back) {
			frame.dispose();
			LandingPage endPage = new LandingPage();
		}
	}
}
