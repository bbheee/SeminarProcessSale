package model;

import java.time.LocalDateTime;
import integration.ItemDTO;
import integration.Printer;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * Collects all information regarding a particular sale.
 */
public class Sale {
    private LocalDateTime saleTime;
    private List<ItemDTO> registeredItems = new ArrayList<>();
    private List<RevenueObserver> revenueObservers = new ArrayList<>();
    private int runningTotal;
    private int changeAmount;
    private double totalTaxes;
    /**
     * Creates a new instance, and records the time it was created. This will be the time recorded
     * on the receipt.
     */
    public Sale() {
        saleTime = LocalDateTime.now();
        runningTotal= 0;
        
    }
    public void addRevenueObserver(RevenueObserver revenueObserver){
        revenueObservers.add(revenueObserver);
        
    }
    
    public void notifyObservers() {
        for (RevenueObserver revenueObserver : revenueObservers) {
            revenueObserver.updateRevenue(runningTotal);
        }
    }
    
    /**
     * check if an item exists in the registered items
     * @param itemToCheck the item that will be checked.
     * @return whether an item in the current sale has same ID as ItemToFind
     **/
    private boolean itemExists (ItemDTO itemToCheck){
        for (ItemDTO currentItem:registeredItems)
            if(itemToCheck.equals(currentItem))
                return true;
        return false;
    }
    /**
     * Get the item in the current sale with same item ID as itemToFind
     * @param itemToFind the item that is to be found.
     * @return the item that has the same Id as itemToFind.
     * 
     */ 
     private ItemDTO findItem (ItemDTO itemToFind){
        for (ItemDTO currentItem:registeredItems)
            if(itemToFind.equals(currentItem))
                return currentItem;
        return null;
    }
    /**
     * Update the quantity of the item in the current sale.
     * @param regusteredItem the item that aims to update the quantity. 
     * @param quantity the new updated quantity of the item.
     * 
     */
     private void updateQuantity(ItemDTO registeredItem,int quantity){
         registeredItems.set(registeredItems.indexOf(findItem(registeredItem)), new ItemDTO (registeredItem,findItem(registeredItem).getQuantity()+quantity));
     }
    /**
     * Add an item in the current sale.
     * @param registeredItem the item is to be added to the current sale.
     * @return the current lastest price and information of the registered item and the running total of the sale.
     * 
     */
    public String addItem(ItemDTO registeredItem){
        if(!itemExists(registeredItem)){
            runningTotal+= registeredItem.getPrice();
            registeredItems.add(registeredItem);
        }
        else {
            runningTotal+= registeredItem.getPrice();
            updateQuantity(registeredItem,1);
        }
        SaleInformation newSaleInfo = new SaleInformation (registeredItem.getPrice(),registeredItem.getDescription(),runningTotal);
        return newSaleInfo.toString();
    }
    /**
    * Add several items in the current sale.
    * @param registeredItem the items are to be added to the current sale.
    * @param quantity the quantity of the items 
    * @return the current lastest price and information of the registered item and the running total of the sale.
    **/
    public String addItems (ItemDTO registeredItem, int quantity){
        if(!itemExists(registeredItem)){
            runningTotal+= registeredItem.getPrice() * quantity;
            registeredItems.add(new ItemDTO(registeredItem,quantity));
        }
        else {
            runningTotal+= registeredItem.getPrice() * quantity;
            updateQuantity(registeredItem,quantity);
        }
        SaleInformation newSaleInfo = new SaleInformation (registeredItem.getPrice(),registeredItem.getDescription(),runningTotal);
        return newSaleInfo.toString();
        
    }
    /**
    * calculate the total taxes of the registered items.
    * @return the total taxes.
    **/       
    public double caculateTaxes(){
        totalTaxes = 0;
        for (ItemDTO currentItem : registeredItems){
            totalTaxes+= currentItem.getPrice() * currentItem.getTaxes() *currentItem.getQuantity();
        }
        return totalTaxes;
    }
    /**
    * calculate the change that is given to the customer.
    * @return the change amount.
    **/  
    
    public int caculateChange(int paidAmount)throws InvalidPaymentException{
        if (paidAmount - runningTotal<0){
            throw new InvalidPaymentException(paidAmount,runningTotal);
        }
        notifyObservers();
        return changeAmount = paidAmount - runningTotal;
    }
    
    /**
    * Print a receipt that contains the sale information.
    * @param  printer print out the receipt.
    **/  
    public void printReceipt (Printer printer){
        Receipt receipt = new Receipt (this);
        printer.printReceipt(receipt);
    }
    
    /**
    * @return the total price..
    **/  
    public int getRunningTotal(){
        return runningTotal;
    }   
    /**
    * @return the change amount.
    **/  
    public int getChange(){
        return changeAmount;    
    }
    /**
    * @return the total taxes.
    **/  
    public double getTotalTaxes(){
        return totalTaxes;    
    }
    /**
    * @return the array that contains all registered item in the sale.
    **/  
    public List<ItemDTO> getItems(){
        return registeredItems;
    }
    /**
    * @return the sale time.
    **/  
    public LocalDateTime getSaleTime(){
        return saleTime;
    }
    
  

}
