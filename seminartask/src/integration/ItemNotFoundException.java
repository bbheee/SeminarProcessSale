/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

/**
 *This exception will be thrown if the item in not found in database.
 * @author beibei
 */
public class ItemNotFoundException extends Exception {
    private final String ID;
    
    public ItemNotFoundException (String itemID){
        super(itemID + " could not be found in the database.");
        ID = itemID;
    }
    public String getID() {
        return ID;
    }    
}
