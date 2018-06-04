/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *This exception will be thrown if there is an invalid payment.
 * @author beibei
 */
public class InvalidPaymentException extends Exception {
    private int payment;
    private int price;
      
    public InvalidPaymentException (int payment, int price){
        super ("payment " + payment+"kr " + "is not enough for the purchase "+ price+"kr.");
        this.payment=payment;
        this.price=price;
    }
    public int getPayment(){
        return payment;
    }
    public int getPrice(){
        return price;
    }
}
