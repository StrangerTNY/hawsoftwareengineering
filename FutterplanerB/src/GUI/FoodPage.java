package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Futter.Futter;
import src.PlanerFabrik;

//Futterarten
public class FoodPage extends JFrame implements ActionListener{
	
	
	PlanerFabrik planerFabrik = new PlanerFabrik();
	ArrayList<Futter> passendeFutterSorten;
	ArrayList<Futter> ausgewaehltesFutter = new ArrayList<Futter>();
	String pet;
	String petName;
	
	//Deklaration der zu brauchenden Objekte/Variablen
	JFrame frame = new JFrame();
	
	private JLabel fTyp, sItem;
	
	private JButton done/*, bbbb*/;
	
	ArrayList<JCheckBox> list = new ArrayList<JCheckBox>();
	//ArrayList<JCheckBox> list2 = new ArrayList<JCheckBox>();
	
	Color purple = new Color (105, 104, 146);
	
	/*String[] Nassfutter = {"Whiskers", "Felix", "MAC's"};
	JComboBox cBox = new JComboBox(Nassfutter);*/
	
	public FoodPage(String pet, String petName) {
					
		this.pet = pet;
		this.petName = petName;
		
		passendeFutterSorten = planerFabrik.getFutter(pet);
		
		//FramLayout null
		frame.setLayout(null);
		
		//Überschrift Panel
		JPanel panel1 = new JPanel();
		panel1.setBackground(purple);
		panel1.setBounds(0,0,200,40);
		frame.add(panel1);
			
		//Checkboxen Panel
		JPanel panel2 = new JPanel();
		panel2.setBackground(purple);
		panel2.setBounds(0,40,400,300);
		frame.add(panel2);

		//Header
		fTyp= new JLabel("<html>Futter<br></html>");
		fTyp.setBounds(0, 0,100, 100);
		fTyp.setFont(new Font(null, Font.PLAIN, 20));
		panel1.add(fTyp);
		
		//Futtertyp Auflistung
        for(int i =0; i<passendeFutterSorten.size();i++) {
        	list.add(new JCheckBox(passendeFutterSorten.get(i).getName()));
        	panel2.add(list.get(i));
         }
        
        //Button fürs fertigstellen
		done = new JButton("Fertigstellen");
		done.setBounds(10,310,160,30);
		done.addActionListener(this);
		panel2.add(done);
		
	
		
		//Hintergrundfarben Panel
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
		/*if(e.getSource() == cBox) {
				
				String option = (String) cBox.getSelectedItem();
				sItem.setText(sItem.getText() + "\n +" + option);
				
				sItem.setBounds(100, 0, 1000, 100);
				sItem.setFont(new Font(null, Font.PLAIN, 20));
				
				cBox.removeItem(cBox.getSelectedItem());
				
				//sItem = new JLabel((String) cBox.getSelectedItem());
				//System.out.print(cBox.getSelectedItem());
		}*/
		
		
		if(e.getSource() == done) {
			
			// Ausgewählte Futtersorten werden einer Liste hinzugefügt
			for(int i= 0; i<list.size(); i++) {
				if(list.get(i).isSelected()) {
					System.out.println("was gefunden");
					ausgewaehltesFutter.add(passendeFutterSorten.get(i));
				}
			}
			frame.dispose();
			try {
				PlanerPage endPage = new PlanerPage(pet,petName,ausgewaehltesFutter);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
}
