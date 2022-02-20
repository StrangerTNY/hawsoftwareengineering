package src;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Futter.BARF;
import Futter.Futter;
import GUI.LandingPage;
import Tiere.Tier;

// Test für die Planerfabrik
public class PlanerFabrikTest {
    
    PlanerFabrik testPlanerFabrik;
    String hundsString;

    // Instanziierung
    @Before
    public void setup() {
        testPlanerFabrik = new PlanerFabrik(); 
        hundsString = "Hund";
    }

    // Testet die Methode getFutter auf Funktion
    @Test
    public void testGetFutterSuccess() {
        assertTrue(testPlanerFabrik.getFutter(hundsString) instanceof ArrayList);
        assertNotNull(testPlanerFabrik.getFutter(hundsString));
    }

    // Testet die Methode getFutter auf Fehlfunktion
    @Test
    public void testGetFutterFail() {
        assertFalse(testPlanerFabrik.getFutter(hundsString) instanceof Futter);
    }

    // Testet die Methode getTier auf Funktion
    @Test
    public void testGetTierSucess() {
        assertTrue(testPlanerFabrik.getTier(hundsString) instanceof Tier);
        assertNotNull(testPlanerFabrik.getTier(hundsString)); 
        assertNull(testPlanerFabrik.getTier(null));
    }

    // Testet die Methode getTier auf Fehlfunktion
    @Test
    public void testGetTierFail() {
        assertFalse(testPlanerFabrik.getTier(hundsString) instanceof ArrayList);
    }
}
