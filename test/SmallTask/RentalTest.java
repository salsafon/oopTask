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
public class RentalTest {
    
    private Game spiderMan, tetris;
    private Customer customer1, customer2;
    private Rental rental1, rental2;
    
    public RentalTest() {
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
        tetris    = new Game("Tetris",     "Puzzle",  3, 1.0);
        customer1 = new Customer("Berke", 20);
        customer2 = new Customer("Tuna",  15);
 
        spiderMan.rentGame();
        tetris.rentGame();
 
        rental1 = new Rental(spiderMan, customer1, 5, 3);
        rental2 = new Rental(tetris,    customer2, 4, 2);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calculatePrice method, of class Rental.
     */
    @Test
    public void testCalculatePriceRental() {
        assertEquals("Spider-Man price should be 7.5", 7.5, rental1.calculatePrice(), 0.01); // 3 * 2.5
    }

    /**
     * Test of calculateLateFee method, of class Rental.
     */
    @Test
    public void testLateFeeCalculate() {
        rental2.closeRental(7); // 3 overdue hours * (1.0 * 2) = 6.0
        assertEquals("Late fee should be 6.0", 6.0, rental2.getLateFee(), 0.01);
    }
    
    @Test
    public void testNoLateFeeWhenReturnedExactlyOnDueDate() {
        rental1.closeRental(5);
        assertEquals("No late fee when returned exactly on due hour", 0.0, rental1.getLateFee(), 0.01);
    }

    /**
     * Test of closeRental method, of class Rental.
     */
    @Test
    public void testCloseRentalMakesGameAvailable() {
        rental1.closeRental(4);
        assertTrue("Spider-Man should be available after rental closed", spiderMan.isAvailable());
    }
}
