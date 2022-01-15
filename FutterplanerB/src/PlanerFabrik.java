import java.util.ArrayList;
import java.util.Collections;

import Futter.BARF;
import Futter.Frischfutter;
import Futter.Futter;
import Futter.Koernerfutter;
import Futter.Nassfutter;
import Futter.Trockenfutter;
import Tiere.Hund;
import Tiere.Katze;
import Tiere.Nagetier;
import Tiere.Tier;
import Tiere.Vogel;

public class PlanerFabrik {

	public Tier getTier(String tierAuswahl) {
		
		if(tierAuswahl == null) {
			return null;
		}else {
			switch(tierAuswahl) {
			
			case "Hund":
				return new Hund();
			case "Katze":
				return new Katze();	
			case "Nagetier":
				return new Nagetier();	
			case "Vogel":
				return new Vogel();	
			
			}
		}
		return null;
	}
	
	public ArrayList<Futter> getFutter(String tierAuswahl) {
		
		ArrayList<Futter> alleFutterSorten = new ArrayList<Futter>();
		ArrayList<Futter> passendeFutterSorten = new ArrayList<Futter>();
		
		Futter trockenFutter = new Trockenfutter();
		Futter frischFutter = new Frischfutter();
		Futter barfFutter = new BARF();
		Futter koernerFutter = new Koernerfutter();
		Futter nassFutter = new Nassfutter();
		
		// Futter Unter Klassen "suchen" sich die Tiere
		trockenFutter.fuerTier();
		frischFutter.fuerTier();
		barfFutter.fuerTier();
		koernerFutter.fuerTier();
		nassFutter.fuerTier();
		
		// Alle Futter Klassen werden der Array Liste hinzugefügt
		Collections.addAll(
				alleFutterSorten, trockenFutter,frischFutter,
				barfFutter,koernerFutter,nassFutter);
				
		
		// Einzelne Elemente der Futter Unterklasse 
		// sprich die Tiere die das Futter essen dürfen
		// werden mit dem eingegebenen Tier verglichen
		
		alleFutterSorten.forEach((FutterSorte) ->{
			FutterSorte.getTierListe().forEach((tier) ->{
				if(tier.contentEquals(tierAuswahl)) {
					passendeFutterSorten.add(FutterSorte);
				}
			});
		});
		
		
		// Logik um bei jeden Aufruf eine neue Futterklasse zurückzugeben
		return passendeFutterSorten;
		
	}
}
