

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Futter.Futter;
import Tiere.Hund;


public class PlanerFabrikTest {
    
    PlanerFabrik testPlanerFabrik;
    Futter testFutter;

    @Before
    private void setup() {
        testPlanerFabrik = new PlanerFabrik(); 
        // testFutter = new Futter();
    }

    @Test
    public void testGetFutterSuccess() {
        assertTrue(testPlanerFabrik.getFutter("Hund") instanceof Futter);
        assertNotNull(testPlanerFabrik.getFutter("Hund"));
    }

    @Test
    public void testGetFutterFail() {
        // assertFalse(testPlanerFabrik.getFutter("Hund") instanceof PlanerFabrik);
    }

    @Test
    public void testGetTierSucess() {

    }

    @Test
    public void testGetTierFail() {

    }
}
