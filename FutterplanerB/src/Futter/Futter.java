package Futter;

import java.util.ArrayList;

public interface Futter {
	
	// Methode die die fuerTierListe füllt
	void fuerTier();
	// gibt Futtersorten Name zurück
	String getName();
	// gibt fuerTierListe zurück
	ArrayList<String> getTierListe();
	
}
