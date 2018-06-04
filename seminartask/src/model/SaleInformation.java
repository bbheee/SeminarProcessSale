/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author beibei
 */
public class SaleInformation {
    private final int price;
    private final String description;
    private final int runningTotal;
    /**
    * @param price the price of lastest registered item.
    * @param description the description of lastest registered item.
    * @param runningTotal the total price of lastest registered item.
    **/  
    public SaleInformation (int price, String description, int runningTotal){
        this.price= price;
        this.description = description;
        this.runningTotal = runningTotal;      
    }
    
    @Override
    public String toString(){
        return price + ", "+ description+", "+ runningTotal;
    }
    
}
