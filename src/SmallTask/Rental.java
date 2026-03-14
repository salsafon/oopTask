/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SmallTask;

/**
 *
 * @author brktb
 */
public class Rental {
    
    private Game game;
    private Customer customer;
    private int hoursRented;
    private int dueDate;
    private int returnDate;
    private double lateFee;
    
    public Rental(Game game, Customer customer, int dueHours, int hours){
        this.game = game;
        this.customer = customer;
        this.dueDate = dueHours;
        this.returnDate = 0;
        this.hoursRented = hours;
        this.lateFee = 0;
    }
    
    public double calculatePrice(){
        return hoursRented * game.getPricePerHour();
    }
    
    public double calculateLateFee(){
        if(returnDate > dueDate){
            int overDue = returnDate - dueDate;
            lateFee = overDue * (game.getPricePerHour()*2);
        }
        return lateFee;
    }
    
    public void closeRental(int returnTime){
        returnDate = returnTime;
        calculateLateFee();
        game.returnGame();
    }
    
    public double getLateFee(){
        return lateFee;
    }
    
    public Customer getCustomer(){
        return customer;
    }
    
}
