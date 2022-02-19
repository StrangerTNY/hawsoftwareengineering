package GUI;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NamingPage extends JFrame implements ActionListener{
	
	String pet;
	
	// Neues JFrame Objekt
	JFrame frame = new JFrame();
	
	// Neues JLabel Objekt als Textüberschrift
	JLabel label = new JLabel("Wie heißt dein Tier?");
	
	// Hintergrundfarbe und Textfont vordefiniert
	Color purple = new Color (105, 104, 146);
	Font font = new Font("Arial",Font.PLAIN,26);
	
	//Textfeld und Button
	private JTextField nameThePet  = new JTextField(15);
	private JButton bContinue;
	
	public NamingPage(String pet) {
		super("Name des Tieres");
		
		this.pet = pet;
		
		//Layout undefiniert
		frame.setLayout(null);
			
		//Position, Größe, Font des Labels bestimmt
		label.setBounds(20, 40, 400, 50);
		label.setFont(new Font(null, Font.PLAIN, 30));
		frame.add(label); //So wird das Label zum Frame hinzugefügt
		
		//Textfeldgröße etc. für das Feld in den man den Namen einträgt
		nameThePet.setBounds(20,100,400,30);
		nameThePet.setFont(font);
		frame.add(nameThePet); //Textfeld zum Frame hinzugefügt
		
		//Button Configs
		bContinue = new JButton("Continue");
		bContinue.setBounds(20,150,133,30);
		bContinue.setFocusable(false);
		bContinue.addActionListener(this);
		
		// Button hinzufügen
		frame.add(bContinue);

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
	
	//Actionhandler für Seitenwechsel
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bContinue) {
			frame.dispose();
			FoodPage endPage = new FoodPage(pet,nameThePet.getText());
		}
	}
	
}
