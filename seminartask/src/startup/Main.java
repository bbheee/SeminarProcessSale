package startup;

import controller.Controller;
import integration.Printer;
import integration.RegistryCreator;
import view.View;
import integration.ExternalAccountingSystem;
import integration.ExternalInventorySystem;
/**
 * Starts the entire application.
 */
public class Main {
    /**
     * @param args The program does not take any command line parameters. 
     */
    public static void main(String[] args) {
        
        RegistryCreator regCreator = new RegistryCreator();
        Printer printer = new Printer();
        ExternalAccountingSystem accounting = new ExternalAccountingSystem();
        ExternalInventorySystem inventory = new ExternalInventorySystem();
        Controller contr = new Controller(regCreator,printer,accounting,inventory);
        View view = new View(contr);
        view.sampleExecution();
        

    }
}
