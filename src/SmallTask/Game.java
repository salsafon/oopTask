/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SmallTask;

/**
 *
 * @author brktb
 */
public class Game {
    
    private String title;
    private String genre;
    private int ageRating;
    private int popularityScore;
    private boolean isAvailable;
    private boolean isDamaged;
    private double pricePerHour;
    private int totalRentCount;
    
    public Game(String title, String genre, int ageRating, double pricePerHour){
        this.title = title;
        this.genre = genre;
        this.ageRating = ageRating;
        this.pricePerHour = pricePerHour;
        this.popularityScore = 0;
        this.totalRentCount = 0;
        this.isDamaged = false;
        this.isAvailable = true;
    }
    
    public void rentGame(){
        if(isAvailable && !isDamaged){
            isAvailable = false;
            totalRentCount++;
            popularityScore++;
        }
    }
    
    public void returnGame(){
        if(totalRentCount > 20){
            markDamaged();  
        }else{
            isAvailable = true;
        }
    }
    
    public void markDamaged(){
        isDamaged = true;
        isAvailable = false;
    }
    
    public boolean isAvailable(){
        return isAvailable;
    }

    public String getGenre(){
        return genre;
    }

    public int getAgeRating(){
        return ageRating;
    }

    public double getPricePerHour(){
        return pricePerHour;
    }

    public int getTotalRentCount(){
        return totalRentCount;
    }

    public String getTitle(){
        return title;
    }
    
    public boolean isDamaged(){
        return isDamaged;
    }
    
    
}
