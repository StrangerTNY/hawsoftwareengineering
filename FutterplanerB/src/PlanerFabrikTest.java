import static org.junit.Assert.assertNotNull;

import org.junit.Test;


public class PlanerFabrikTest {

    PlanerFabrik planerFabrik = new PlanerFabrik(); 


    @Test
    public void testGetFutter() {
        assertNotNull(planerFabrik.getFutter("Hund"));
    }

    @Test
    public void testGetTier() {
        assertNotNull(planerFabrik.getTier("Hund"));
    }
}
