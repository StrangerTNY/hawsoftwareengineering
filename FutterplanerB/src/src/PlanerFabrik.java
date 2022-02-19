package src;
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
	
	// Methode, die die gleichnamige Klasse
	// des eingegebenen Tieres zur�ckgibt
	public Tier getTier(String tierAuswahl) {
		
		// Fehleingaben werden bisher nicht korrekt verarbeitet
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
		// Hier k�nnte ihre Fehlermeldung stehen
		return null;
	}
	
	// Methode, die eine Liste an 
	// passenden Futtersorten-Klassen zur�ckgibt
	public ArrayList<Futter> getFutter(String tierAuswahl) {
		
		// Tempor�re Liste gef�llt mit allen Klassen
		// die die Futter Klasse implementieren
		ArrayList<Futter> alleFutterSorten = new ArrayList<Futter>();
		// Liste mit passendem Futter die am Ende zur�ckgegeben wird
		ArrayList<Futter> passendeFutterSorten = new ArrayList<Futter>();
		
		// Jedes Futter Objekt wird einmal instanziiert
		Futter trockenFutter = new Trockenfutter();
		Futter frischFutter = new Frischfutter();
		Futter barfFutter = new BARF();
		Futter koernerFutter = new Koernerfutter();
		Futter nassFutter = new Nassfutter();
		
		// Futter Unter Klassen "suchen" sich die Tiere
		// f�r die das Futter geeignet ist
		trockenFutter.fuerTier();
		frischFutter.fuerTier();
		barfFutter.fuerTier();
		koernerFutter.fuerTier();
		nassFutter.fuerTier();
		
		// Alle Futter Objekte werden der tempor�ren Liste hinzugef�gt
		Collections.addAll(
				alleFutterSorten, trockenFutter,frischFutter,
				barfFutter,koernerFutter,nassFutter);
				
		
		// Einzelne Elemente der Futter Unterklasse 
		// sprich die Tiere die das Futter essen d�rfen
		// werden mit dem vom Nutzer eingegebenen Tier verglichen
		// und dementsprechend der passenden Futter Sorte Liste hinzugef�gt
		alleFutterSorten.forEach((FutterSorte) ->{
			FutterSorte.getTierListe().forEach((tier) ->{
				if(tier.contentEquals(tierAuswahl)) {
					passendeFutterSorten.add(FutterSorte);
				}
			});
		});
		
		// passende Futter Sorten werden zur�ckgegeben
		return passendeFutterSorten;
		
	}
}
