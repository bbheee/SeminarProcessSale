/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

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
public class ItemRegistryTest {
    
    public ItemRegistryTest() {
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
     * Test of findItem method, of class ItemRegistry.
     */
    @Test
    public void testFindMacka() throws ItemNotFoundException {
        System.out.println("findItem");
        String itemID = "Macka";
        ItemRegistry instance = new ItemRegistry();
        ItemDTO expResult = instance.getItem(0);
        ItemDTO result = instance.findItem(itemID);
        assertEquals(expResult, result);
        
    }
    
    public void testFindCola() throws ItemNotFoundException {
        System.out.println("findItem");
        String itemID = "Cola";
        ItemRegistry instance = new ItemRegistry();
        ItemDTO expResult = instance.getItem(1);
        ItemDTO result = instance.findItem(itemID);
        assertEquals(expResult, result);
        
    }
    
    public void testFindGodis() throws ItemNotFoundException {
        System.out.println("findItem");
        String itemID = "Godis";
        ItemRegistry instance = new ItemRegistry();
        ItemDTO expResult = instance.getItem(2);
        ItemDTO result = instance.findItem(itemID);
        assertEquals(expResult, result);
        
    }
     public void testFindFelItem() throws ItemNotFoundException {
        System.out.println("findItem");
        String itemID = "felItem";
        ItemRegistry instance = new ItemRegistry();
        ItemDTO expResult = null;
        ItemDTO result = instance.findItem(itemID);
        assertEquals(expResult, result);
     }
}
