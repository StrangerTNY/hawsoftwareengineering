package GUI;
import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Tiere.Tier;
import src.PlanerFabrik;

public class LandingPage extends JFrame implements ActionListener{
	

	public String choosenAnimal = null;
	public String getChoosenAnimal() {return choosenAnimal;}

	
	//Deklarationen
	JFrame frame = new JFrame();
	
	Color purple = new Color (105, 104, 146);
	
	JLabel Intro = new JLabel("<html>Herzlich willkommen! Such dir ein Tier aus, <br> zu dem ein Plan erstellt werden soll!</html>");
	private JButton bKatze, bHund, bVogel, bNaga, bSonstige;
	
	public LandingPage(){
		super("Willkommen zur Startseite");
		
		frame.setLayout(null);
		
		// Introtext-Einstellungen
		Intro.setBounds(150, 0, 1000, 100);
		Intro.setFont(new Font(null, Font.PLAIN, 20));
		frame.add(Intro);
		
		// Button für Katze
		Icon cat = new ImageIcon(getClass().getResource("cat.png"));
		bKatze = new JButton(null, cat);
		bKatze.setBounds(150,100,70,70);
		bKatze.setFocusable(false);
		bKatze.addActionListener(this);
		
		// Button für Hund
		Icon dog = new ImageIcon(getClass().getResource("dog.png"));
		bHund = new JButton(null,dog);
		bHund.setBounds(300,100,70,70);
		bHund.setFocusable(false);
		bHund.addActionListener(this);
		
		// Button für Vogel
		Icon birb = new ImageIcon(getClass().getResource("parrots.png"));
		bVogel = new JButton(null,birb);
		bVogel.setBounds(450,100,70,70);
		bVogel.setFocusable(false);
		bVogel.addActionListener(this);
		
		// Button für Nagetiere
		Icon bun= new ImageIcon(getClass().getResource("rabbit.png"));
		bNaga = new JButton(null, bun);
		bNaga.setBounds(225,220,70,70);
		bNaga.setFocusable(false);
		bNaga.addActionListener(this);
		
		// Button für Sosntige
		Icon liz = new ImageIcon(getClass().getResource("lizard.png"));
		bSonstige = new JButton(null, liz);
		bSonstige.setBounds(375,220,70,70);
		bSonstige.setFocusable(false);
		bSonstige.addActionListener(this);
		
		// Hinzufügen aller Buttons zum Frame
		frame.add(bKatze);
		frame.add(bHund);
		frame.add(bVogel);
		frame.add(bNaga);
		frame.add(bSonstige);
		
		
		// BG Panel
		JPanel bg = new JPanel();
		bg.setBackground(purple);
		bg.setBounds(0,0,1000,700);
		frame.add(bg);
		
		//Fenstereinstellungen
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700,400);
		
	}
	
	//Actionhandler
	public void actionPerformed(ActionEvent e) {
		//Fall Button Katze gewählt
		if(e.getSource() == bKatze) {
			choosenAnimal = "Katze";
		}
		
		//Fall Button Hund gewählt
		if(e.getSource() == bHund) {
			choosenAnimal = "Hund";
		}
		
		//Fall Button Vogel gewählt
		if(e.getSource() == bVogel) {
			choosenAnimal = "Vogel";
		}
		
		//Fall Button Nagetier gewählt
		if(e.getSource() == bNaga) {
			choosenAnimal = "Nagetier";
		}
		
		//Fall Button Sonstige gewählt
		if(e.getSource() == bSonstige) {
			choosenAnimal = "Sonstiges";
		}
		frame.dispose();
		NamingPage endPage = new NamingPage(choosenAnimal);
	}
}
