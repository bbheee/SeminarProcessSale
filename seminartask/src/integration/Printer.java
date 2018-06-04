/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;
import model.Receipt;
/**
 *
 * @author beibei
 */
public class Printer {
    /**
     * prints out the receipt.
     * @param receipt receipt that is printed.
     */
    public void printReceipt(Receipt receipt) {
        System.out.print(receipt.createReceiptString());
    }    
}
