/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SmallTask;

/**
 *
 * @author brktb
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Create store
        GameStore store = new GameStore();
        
        //Games
        Game g1 = new Game("Spiderman", "Action", 16, 2.5);
        Game g2 = new Game("Tetris", "Puzzle", 3, 1.0);
        Game g3 = new Game("Fifa", "Sports", 3, 2.0);
        
        store.addGame(g1);
        store.addGame(g2);
        store.addGame(g3);
        
        //Customers
        Customer c1 = new Customer("Berke", 20);
        Customer c2 = new Customer("Tuna", 15);
        
        // berke rents spiderman
        c1.rentGame(g1, 5, 3);
        Rental rental1 = new Rental(g1, c1, 5, 3); //due hour 5, renting 3 hours
        System.out.println(c1.getName() + " rented " + g1.getTitle());

        // tuna rents tetris
        c2.rentGame(g2, 4, 2);
        Rental r2 = new Rental(g2, c2, 4, 2); //due hour 4, renting 2 hours
        System.out.println(c2.getName() + " rented " + g2.getTitle());

        //berke returns on time (hour 4, due hour 5)
        store.completeRental(rental1, 4);
        System.out.println(c1.getName() + " returned " + g1.getTitle() + " Price: $" + rental1.calculatePrice() + ", Late Fee: $" + rental1.getLateFee());

        //tuna returns late (hour 7, due hour 4)
        store.completeRental(r2, 7);
        System.out.println(c2.getName() + " returned " + g2.getTitle() + " Price: $" + r2.calculatePrice() + ", Late Fee: $" + r2.getLateFee());

        //most popular game
        System.out.println("Most popular: " + store.findMostPopular().getTitle());

        //Total revenue
        System.out.println("Total Revenue: $" + store.getTotalRevenue());
    }
               
}
    

