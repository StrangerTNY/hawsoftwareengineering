import java.util.ArrayList;
import java.util.Scanner;

import Futter.Futter;
import Tiere.Tier;

public class Programmablauf {
	
	public static void main(String[] args) {
		
		System.out.println("Wähle dein Haustier:");
		System.out.println("\"Hund\", \"Katze\", \"Nagetier\" oder \"Vogel\" ");
		
		Scanner sc = new Scanner(System.in);
		String tierEingabe = sc.next();
		sc.close();
		
		PlanerFabrik planerFabrik = new PlanerFabrik();
		
		Tier tier = planerFabrik.getTier(tierEingabe);
		// passendes Futter wird ermittelt
		ArrayList<Futter> passendeFutterSorten = planerFabrik.getFutter(tierEingabe);
				
		System.out.println("Für dein Haustier "+ tier.getName()+ " eignet sich");
		for(Futter futterName: passendeFutterSorten) {
			System.out.print(futterName.getName()+" ");
		}
	}
}
