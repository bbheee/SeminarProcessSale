/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.RevenueObserver;

/**
 *
 * @author beibei
 */
public class TotalRevenueView implements RevenueObserver{
    private int revenue = 0;
 
    @Override
    public void updateRevenue (int newTotal) {
        revenue += newTotal;
        printCurrentState();
    }
    
    private void printCurrentState(){
        System.out.println("The current revenue is: " + revenue + "kr.");
    }
    

    
}
