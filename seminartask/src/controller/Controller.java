package controller;

import model.Sale;
import model.Receipt;
import integration.ItemDTO;
import integration.RegistryCreator;
import integration.ItemRegistry;
import integration.Printer;
import integration.ExternalAccountingSystem;
import integration.ExternalInventorySystem;
import integration.ItemNotFoundException;
import java.util.ArrayList;
import java.util.List;
import model.InvalidPaymentException;
import model.RevenueObserver;
/**
 * This is the application's only controller. All calls to the model pass through here.
 */
public class Controller {
    private Sale sale;
    private ItemRegistry itemRegistry;
    private Printer printer;
    private ExternalAccountingSystem accounting;
    private ExternalInventorySystem inventory;
    private RevenueObserver revenueObserver;
    private List<RevenueObserver> revenueObservers = new ArrayList<>();
    
    /**
     * Create a new instance.
     * @param regCreator the object responsible for creating the registries.
     * @param printer the printer
     * @param accounting external accounting system
     * @param inventory external inventory system
     **/
            
    public Controller(RegistryCreator regCreator, Printer printer, ExternalAccountingSystem accounting,ExternalInventorySystem inventory){
        this.itemRegistry = regCreator.getItemRegistry();
        this.printer = printer;
        this.accounting = accounting;
        this.inventory = inventory;
       
    }
    
    /**
     * For testing use, create a new instance with only a registry
     * @param regCreator the object that used for creating registries.
     **/
    public Controller(RegistryCreator regCreator){
        this.itemRegistry = regCreator.getItemRegistry();
    }
    /**
     * Creates an empty instance of {@link Sale}, which will be used for all information regarding
     * the sale that is now started.
     */
    
    public void startSale() {
        sale = new Sale();
        for (RevenueObserver revenueObserver : revenueObservers)
        {
            sale.addRevenueObserver(revenueObserver);
        }
    }
    /**
     * @param itemID is a identifier of an item that is bought 
     * @return updated sale information
     **/
    public String enterItemID(String itemID) throws ItemNotFoundException {
        ItemDTO registeredItem = itemRegistry.findItem(itemID);
        return sale.addItem(registeredItem);
    }
     /**
    * @param itemID and quantity of the item
    * @return updated sale information with quantity
    **/
    public String enterItemIDAndQuantity(String itemID,int quantity) throws ItemNotFoundException {
        ItemDTO registeredItem = itemRegistry.findItem(itemID);
        return sale.addItems(registeredItem,quantity);
    }
    /**
    * calculate total taxes when all items have been registered.
    * @return the total amount of taxes of the sale.
    **/
    public double indicateAllItemsRegistered() {
        return sale.caculateTaxes();
    }
     /**
    * @param paidAmount is the cash that customer paid and cashier enter the amount in the system
    * @return the changes that calculated by system
    **/
    public int enterPaidCash(int paidAmount) throws InvalidPaymentException{
        int changeAmount = sale.caculateChange(paidAmount);
        sale.printReceipt(printer);
        
        accounting.bookkeep(sale);
        inventory.updateInventory(sale);
        return changeAmount;
    }
    public void addRevenueObserver (RevenueObserver revenueObserver){
        revenueObservers.add(revenueObserver);
    }
}
