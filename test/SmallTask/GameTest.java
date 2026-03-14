/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package SmallTask;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author brktb
 */
public class GameTest {
    
    private Game spiderMan, fifa;
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        spiderMan = new Game("Spider-Man", "Action", 16, 2.5);
        fifa = new Game("FIFA 24", "Sports", 3, 2.0);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of rentGame method, of class Game.
     */
    @Test
    public void testRentGameSetsUnavailable() {
        spiderMan.rentGame();
        assertFalse("Game should be unavailable after renting", spiderMan.isAvailable());
    }
    
    @Test
    public void testRentGameIncreasesRentCount() {
        spiderMan.rentGame();
        assertEquals("Rent count should be 1", 1, spiderMan.getTotalRentCount());
    }
    
    @Test
    public void testRentGameIgnoredWhenDamaged() {
        spiderMan.markDamaged();
        spiderMan.rentGame();
        assertEquals("Damaged game rent count should stay 0", 0, spiderMan.getTotalRentCount());
    }

    /**
     * Test of returnGame method, of class Game.
     */
    @Test
    public void testReturnGameSetsAvailable() {
        spiderMan.rentGame();
        spiderMan.returnGame();
        assertTrue("Game should be available after return", spiderMan.isAvailable());
    }
    
    @Test
    public void testReturnGameMarksDamagedAfter20Rents() {
        for (int i = 0; i < 21; i++) {
            fifa.rentGame();
            fifa.returnGame();
        }
        assertTrue("Game should be damaged after 21 rents", fifa.isDamaged());
        assertFalse("Damaged game should be unavailable", fifa.isAvailable());
    }

    /**
     * Test of markDamaged method, of class Game.
     */
    @Test
    public void testMarkDamagedSetsFlags() {
        spiderMan.markDamaged();
        assertTrue("Game should be marked damaged", spiderMan.isDamaged());
        assertFalse("Damaged game should be unavailable", spiderMan.isAvailable());
    }
    
}
