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
public class Customer {
    
    private String name;
    private int age;
    private List<Rental> rentedGames;
    
    public Customer(String name, int age){
        this.name = name;
        this.age = age;
        this.rentedGames = new ArrayList<>();
    }
    
    public void rentGame(Game game, int dueHours, int hours){
        if(game.isAvailable() && !game.isDamaged() && age >= game.getAgeRating()){
            Rental rental = new Rental(game, this, dueHours, hours);
            rentedGames.add(rental);
            game.rentGame();
        }
    }
    
    public void returnGame(Game game){
        game.returnGame();
    }
    
    public String getName(){
        return name;
    }
}
