package view;

import controller.Controller;
import integration.ItemNotFoundException;
import integration.ItemRegistryException;
import model.InvalidPaymentException;
import util.LogHandler;

/**
 * This is a placeholder for the view. It contains only hardcoded calls to the controller.
 */
public class View {
    private Controller contr;
    private final LogHandler logger =LogHandler.getLogger();
    
    /**
     * Constructs a new view, using the specified controller.
     * 
     * @param contr This controller will be used for all system operations.
     */
    public View(Controller contr) {
        this.contr = contr;
            
    }
    
    /**
     * Simulates a sample execution containing calls to all system operations.
     */
    public void sampleExecution() {
        System.out.println("Starting sample execution.");
        logger.setFileLogger();
        contr.addRevenueObserver(new TotalRevenueView());
        
        contr.startSale();
        System.out.println("After call to startSale()");
        try {
        System.out.println(contr.enterItemID("Macka"));
        System.out.println(contr.enterItemIDAndQuantity("Cola", 2));
        System.out.println(contr.enterItemIDAndQuantity("M&M", 2));
        }
        catch (ItemNotFoundException exception){
            handleException ("The specified ID could not be found: "+exception.getID(),exception);
        }
        catch(ItemRegistryException exception){
            handleException ("The database could not be accessed", exception);
        }
        System.out.println(contr.indicateAllItemsRegistered());
        try{
            contr.enterPaidCash(40);
        }
        catch (InvalidPaymentException exception){
            handleException ("The entered payment " + exception.getPayment()+"kr"+ " is not enough for the purchase "+ exception.getPrice()+ "kr.",exception);
        }
        
        contr.startSale();
        System.out.println("\nAfter call to startSale()");
        try {
        System.out.println(contr.enterItemID("Macka"));
        System.out.println(contr.enterItemIDAndQuantity("lgwlfg", 2));
        System.out.println(contr.enterItemIDAndQuantity("M&M", 2));
        }
        catch (ItemNotFoundException exception){
            handleException ("The specified ID could not be found: "+exception.getID(),exception);
        }
        catch(ItemRegistryException exception){
            handleException ("The database could not be accessed", exception);
        }
        System.out.println(contr.indicateAllItemsRegistered());
        try{
            contr.enterPaidCash(100);
        }
        catch (InvalidPaymentException exception){
            handleException ("The entered payment " + exception.getPayment()+"kr"+ " is not enough for the purchase "+ exception.getPrice()+ "kr.",exception);
        }
        
    }
    private void handleException (String message, Exception exception){
        System.out.println(message);
        logger.logException(exception);
    }
    
}
