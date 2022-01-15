package Futter;
import java.util.ArrayList;
import java.util.Collections;

public class Koernerfutter implements Futter{
	
	String name = "Körnerfutter";
	
	private static ArrayList<String> fuerTierListe = new ArrayList<String>();
	
	// Liste mit Tieren die das Futter essen dürfen wird befüllt
	public void fuerTier() {
		Collections.addAll(fuerTierListe, "Nagetier", "Vogel");
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ArrayList<String> getTierListe() {
		return fuerTierListe;
	}
	
	
	
	// optional
	/*public String getMarke() {return marke;}
	public void setMarke(String marke) {this.marke = marke;}
	
	public Double getMenge() {return menge;}
	public void setMenge(Double menge) {this.menge = menge;} */
	
	
}
