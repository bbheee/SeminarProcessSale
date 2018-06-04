/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import integration.ExternalAccountingSystem;
import integration.ExternalInventorySystem;
import integration.ItemNotFoundException;
import integration.RegistryCreator;
import integration.Printer;
import model.InvalidPaymentException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author beibei
 */
public class ControllerTest {
    
    public ControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of startSale method, of class Controller.
     */
    @Test
    public void testStartSale() {
        System.out.println("startSale");
        RegistryCreator regCreator = new RegistryCreator();
        Controller instance = new Controller (regCreator);
        instance.startSale();
    }

    /**
     * Test of enterItemID method, of class Controller.
     */
    @Test
    public void testEnterItemID() throws ItemNotFoundException {
        System.out.println("enterItemID");
        String itemID = "Macka";
        RegistryCreator regCreator = new RegistryCreator();
        Controller instance = new Controller (regCreator);
        instance.startSale();
        String expResult = "50, Macka Skinka, 50";
        String result = null;
        try{
        result = instance.enterItemID(itemID);
        }
        catch (ItemNotFoundException exception){
            System.out.println(exception);
        }
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEnterSeveralItemIDs() throws ItemNotFoundException {
        System.out.println("enterItemID");
        String itemID1 = "Macka";
        String itemID2 = "Cola";
        String itemID3 = "Godis";
        RegistryCreator regCreator = new RegistryCreator();
        Controller instance = new Controller (regCreator);
        instance.startSale();
        double expResult = 10.2 ;
        System.out.println(instance.enterItemID(itemID1));
        System.out.println(instance.enterItemID(itemID2));
        System.out.println(instance.enterItemID(itemID3));
        double result = instance.indicateAllItemsRegistered();
        assertEquals(expResult, result,0);
    }


    /**
     * Test of enterItemIDAndQuantity method, of class Controller.
     */
    @Test
    public void testEnterItemIDAndQuantity() throws ItemNotFoundException {
        System.out.println("enterItemIDAndQuantity");
        String itemID = "Cola";
        RegistryCreator regCreator = new RegistryCreator();
        Controller instance = new Controller (regCreator);
        instance.startSale();
        double expResult = 7.2;
        instance.enterItemID(itemID);
        instance.enterItemIDAndQuantity(itemID, 2);
        double result = instance.indicateAllItemsRegistered();
        assertEquals(expResult, result,0.01);
       
    }

    /**
     * Test of indicateAllItemsRegistered method, of class Controller.
     */
    @Test
    public void testIndicateAllItemsRegistered() throws ItemNotFoundException {
        System.out.println("indicateAllItemsRegistered");
        String itemID1 = "Macka";
        String itemID2 = "Cola";
        String itemID3 = "Godis";
        RegistryCreator regCreator = new RegistryCreator();
        Controller instance = new Controller (regCreator);
        instance.startSale();
        double expResult = 10.2 ;
        System.out.println(instance.enterItemID(itemID1));
        System.out.println(instance.enterItemID(itemID2));
        System.out.println(instance.enterItemID(itemID3));
        double result = instance.indicateAllItemsRegistered();
        assertEquals(expResult, result,0);
    }

    /**
     * Test of enterPaidCash method, of class Controller.
     */
    @Test
    public void testEnterPaidCash() throws ItemNotFoundException,InvalidPaymentException {
        System.out.println("enterPaidCash");
        int paidAmount = 100 ;
        RegistryCreator regCreator = new RegistryCreator();
        Printer printer = new Printer(); 
        ExternalAccountingSystem accounting = new ExternalAccountingSystem();
        ExternalInventorySystem inventory = new ExternalInventorySystem();
        Controller instance = new Controller (regCreator,printer,accounting,inventory);
        instance.startSale();
        System.out.println(instance.enterItemID("Macka"));
        System.out.println(instance.enterItemID("Cola"));
        System.out.println(instance.enterItemID("Godis"));
        instance.indicateAllItemsRegistered();
        int expResult = 15;
        int result = instance.enterPaidCash(paidAmount);
        assertEquals(expResult, result);
       
    }
    
}
