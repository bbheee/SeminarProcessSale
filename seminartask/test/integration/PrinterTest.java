/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import model.InvalidPaymentException;
import model.Receipt;
import model.Sale;
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
public class PrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    public PrinterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of printReceipt method, of class Printer.
     */
    @Test
    public void testPrintReceipt() throws InvalidPaymentException {
        Sale sale = new Sale();
        sale.addItem(new ItemDTO(10,"TestItem1",0.12,"id1"));
        sale.addItem(new ItemDTO(15,"TestItem2",0.12,"id2"));
        sale.addItem(new ItemDTO(50,"TestItem3",0.12,"id3"));
        sale.caculateTaxes();
        sale.caculateChange(100); 
        Receipt receipt = new Receipt (sale);
        Printer instance = new Printer();
        String expResult = "Kvitto\n\n" + "Tid: "+sale.getSaleTime().toString()+ "\n\nTestItem1 1st 10kr 10kr \n" + "TestItem2 1st 15kr 15kr \n" + "TestItem3 1st 50kr 50kr \n\n" + "Total Pris: 75\n"+"Moms: 9.0\n"+"Växel: 25\n\n";
        instance.printReceipt(receipt);
        assertEquals(expResult, outContent.toString());
    }
    
}
