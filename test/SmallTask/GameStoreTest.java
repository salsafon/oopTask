/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package SmallTask;

import java.util.ArrayList;
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
public class GameStoreTest {
    
    private GameStore store;
    private Game spiderMan, tetris, fifa, halo;
    private Customer customer1, customer2;
    private Rental rental1, rental2;
    
    public GameStoreTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        store     = new GameStore();
        spiderMan = new Game("Spider-Man", "Action", 16, 2.5);
        tetris    = new Game("Tetris",     "Puzzle",  3, 1.0);
        fifa      = new Game("FIFA 24",    "Sports",  3, 2.0);
        halo      = new Game("Halo",       "Action", 18, 3.0);
 
        store.addGame(spiderMan);
        store.addGame(tetris);
        store.addGame(fifa);
        store.addGame(halo);
 
        customer1 = new Customer("Berke", 20);
        customer2 = new Customer("Tuna",  15);
 
        customer1.rentGame(spiderMan, 5, 3);
        customer2.rentGame(tetris, 4, 2);
 
        rental1 = new Rental(spiderMan, customer1, 5, 3);
        rental2 = new Rental(tetris,    customer2, 4, 2);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findMostPopular method, of class GameStore.
     */
    @Test
    public void testFindMostPopularReturnsHighestRentCount() {
        fifa.rentGame(); fifa.rentGame(); fifa.rentGame();
        assertEquals("FIFA should be most popular", "FIFA 24", store.findMostPopular().getTitle());
    }

    /**
     * Test of findByGenre method, of class GameStore.
     */
    @Test
    public void testFindByGenreReturnsMatchingGames() {
        ArrayList<Game> result = store.findByGenre("Action");
        assertEquals("Should find 1 available Action game (Halo)", 1, result.size());
        assertEquals("Available action game should be Halo", "Halo", result.get(0).getTitle());
    }
    
    @Test
    public void testFindByGenreExcludesUnavailableGames() {
        fifa.rentGame();
        assertEquals("Rented game should not appear in genre search", 0, store.findByGenre("Sports").size());
    }

    /**
     * Test of findByAge method, of class GameStore.
     */
    @Test
    public void testFindByAgeReturnsEligibleGames() {
        ArrayList<Game> result = store.findByAge(15);
        assertEquals("Only FIFA should be available for age 15", 1, result.size());
    }
    
    @Test
    public void testFindByAgeExcludesRestrictedGames() {
        for (Game g : store.findByAge(15)) {
            assertTrue("All returned games should be age-appropriate", g.getAgeRating() <= 15);
        }
    }

    /**
     * Test of completeRental method, of class GameStore.
     */
    @Test
    public void testCompleteRentalUpdatesRevenue() {
        store.completeRental(rental2, 4); // on time, 2 * 1.0 = 2.0
        assertEquals("Revenue should be 2.0", 2.0, store.getTotalRevenue(), 0.01);
    }
    
    @Test
    public void testCompleteRentalAddsLateFeeToRevenue() {
        store.completeRental(rental2, 7); // 3 overdue hours * (1.0*2) = 6.0 fee, total 8.0
        assertEquals("Revenue should include late fee", 8.0, store.getTotalRevenue(), 0.01);
    }
}
