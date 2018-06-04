/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import integration.ItemDTO;
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
public class ReceiptTest {
    
    public ReceiptTest() {
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
     * Test of createReceiptString method, of class Receipt.
     */
    @Test
    public void testCreateReceiptString() throws InvalidPaymentException {
        System.out.println("createReceiptString");
        Sale sale = new Sale();
        sale.addItem(new ItemDTO(10,"TestItem1",0.12,"id1"));
        sale.addItem(new ItemDTO(15,"TestItem2",0.12,"id2"));
        sale.addItem(new ItemDTO(50,"TestItem3",0.12,"id3"));
        sale.caculateTaxes();
        sale.caculateChange(100); 
        Receipt instance = new Receipt (sale);
        String expResult = "Kvitto\n\n" + "Tid: "+sale.getSaleTime().toString()+ "\n\nTestItem1 1st 10kr 10kr \n" + "TestItem2 1st 15kr 15kr \n" + "TestItem3 1st 50kr 50kr \n\n" + "Total Pris: 75\n"+"Moms: 9.0\n"+"Växel: 25\n\n";
        String result = instance.createReceiptString();
        System.out.println(expResult + result);
        assertEquals(expResult, result);
   
    }
    
}
