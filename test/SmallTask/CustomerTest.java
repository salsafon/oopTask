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
public class CustomerTest {
    
    private Customer customer1, customer2;
    private Game spiderMan, tetris, halo;
    
    public CustomerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        customer1  = new Customer("Berke", 20);
        customer2  = new Customer("Tuna",  15);
        spiderMan  = new Game("Spider-Man", "Action", 16, 2.5);
        tetris     = new Game("Tetris",     "Puzzle",  3, 1.0);
        halo       = new Game("Halo",       "Action", 18, 3.0);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of rentGame method, of class Customer.
     */
    @Test
    public void testRentGameMakesGameUnavailable() {
        customer1.rentGame(spiderMan, 5, 3);
        assertFalse("Spider-Man should be unavailable after renting", spiderMan.isAvailable());
    }

    /**
     * Test of returnGame method, of class Customer.
     */
    @Test
    public void testReturnGameMakesGameAvailable() {
        customer1.rentGame(spiderMan, 5, 3);
        customer1.returnGame(spiderMan);
        assertTrue("Spider-Man should be available after return", spiderMan.isAvailable());
    }
}
