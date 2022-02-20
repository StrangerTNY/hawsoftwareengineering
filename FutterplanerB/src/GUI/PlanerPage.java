package GUI;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Futter.Futter;

//Anzeige + Download
public class PlanerPage extends JFrame implements ActionListener{
	
	
	ArrayList<Futter> ausgewaehltesFutter;
	String pet;
	String petName;
	
	// Deklarieren der Objekte Frame, Label, Farben (Hintergrund)
	JFrame frame = new JFrame();
	JLabel label;
	Color purple = new Color (105, 104, 146);
	Color bri = new Color (140, 150, 180);
	private JButton download, back;
	
	public PlanerPage(String pet, String petName, ArrayList<Futter> Futter) {
		super("Dein Plan");
		
		this.pet = pet;
		this.petName = petName;
		this.ausgewaehltesFutter = Futter;
		
		JLabel label = new JLabel("<html>Futterplan<br>"+petName+"</html>"); //html Codierung f�r Umbruch
		
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
		
		//Tabelle - 7 Spalten - X Reihen
		String[][] rec = {
		         { ausgewaehltesFutter.get(0).getName(), "Steve", "AUS", "A", "B", "C", "D" },
		         { "2", "Virat", "IND" , "A", "B", "C", "D"},
		         { "3", "Kane", "NZ" , "A", "B", "C", "D"},
		         { "4", "David", "AUS" , "A", "B", "C", "D"},
		         { "5", "Ben", "ENG" , "A", "B", "C", "D"},
		         { "6", "Eion", "ENG" , "A", "B", "C", "D"},
		      };
			// Tabellenheader
		      String[] header = { "MO", "DI", "MI", "DO", "FR", "SA", "SO"};
		      JTable table = new JTable(rec, header);
		      panel1.add(new JScrollPane(table));
	
		
		//DL Button
		download = new JButton("Speichern");
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
		
		//Hintergrundpanel f�r Farbe
		JPanel bg = new JPanel();
		bg.setBackground(purple);
		bg.setBounds(0,0,1000,700);
		frame.add(bg);
		
		//Fenstereinstellung
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700,400);
		
		
	}
	
	//Actionhandler f�r PDF-DL und Seitenwechsel
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == download) {
			frame.dispose();
			LandingPage endPage = new LandingPage();
		}
		else if(e.getSource() == back) {
			frame.dispose();
			LandingPage endPage = new LandingPage();
		}
	}
}