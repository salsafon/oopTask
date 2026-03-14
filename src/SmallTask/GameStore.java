/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SmallTask;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author brktb
 */
public class GameStore {
    
    private ArrayList<Game> games;
    private ArrayList<Rental> rentals;
    private double totalRevenue;
    
    public GameStore(){
        this.games = new ArrayList<>();
        this.rentals = new ArrayList<>();
        this.totalRevenue = 0;
    }
    
    public Game findMostPopular(){
        if(games.isEmpty()) return null;
        Game mostPopular = games.get(0);
        for(Game game : games){
            if(game.getTotalRentCount() > mostPopular.getTotalRentCount()){
                mostPopular = game;
            }
        }
        return mostPopular;
    }
    
    public ArrayList<Game> findByGenre(String genre){
        ArrayList<Game> result = new ArrayList<>();
        for(Game game : games){
            if(game.getGenre().equalsIgnoreCase(genre) && game.isAvailable()){
                result.add(game);
            }
        }
        return result;
    }
    
    public ArrayList<Game> findByAge(int ageRating){
        ArrayList<Game> result = new ArrayList<>();
        for(Game game : games){
            if(game.getAgeRating() <= ageRating && game.isAvailable()){
                result.add(game);
            }
        }
        return result;
    }
    
    public void addGame(Game game){
        games.add(game);
    }
    
    public void removeDamaged(Game game){
        if(game.isDamaged()){
            games.remove(game);
        }
    }
    
    public void completeRental(Rental rental, int returnTime){
        rental.closeRental(returnTime);
        rentals.add(rental);
        totalRevenue += rental.calculatePrice() + rental.getLateFee();
    }
    
    public double getTotalRevenue(){
        return totalRevenue;
    } 
}
