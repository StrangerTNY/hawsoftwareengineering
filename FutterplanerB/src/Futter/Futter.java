package Futter;

import java.util.ArrayList;

public interface Futter {
	
	// Methode die die fuerTierListe f�llt
	void fuerTier();
	// gibt Futtersorten Name zur�ck
	String getName();
	// gibt fuerTierListe zur�ck
	ArrayList<String> getTierListe();
	
}
