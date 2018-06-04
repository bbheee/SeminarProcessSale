/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

/**
 *
 * @author beibei
 * A DTO that contains information about an item .
 */
public final class ItemDTO {
    private final int price;
    private final String description;
    private final int quantity;
    private final double taxes;
    private final String itemID;
 /**
 *create a new ItemDTO containing the information about an item that bought by customer and quantity is set to 1.
 * @param price the price of an item.
 * @param description the description of an item.
 * @param taxes the tax percentage of an item.
 * @param itemID the item Id of an item.
 */   
public ItemDTO(int price, String description, double taxes, String itemID) {
    this.price = price;
    this.description = description;
    this.quantity = 1;
    this.taxes = taxes;
    this.itemID = itemID;
}
   
/**
 * This is a new ItemDTO that copies the value from another ItemDTO.
 * @param item ItemDTO that values are copied from. 
**/

public ItemDTO(ItemDTO item) {
    this.price = item.price;
    this.description = item.description;
    this.quantity = item.quantity;
    this.taxes = item.taxes;
    this.itemID = item.itemID;
}
/**
* This is a new ItemDTO with new quantity that copies the value from another ItemDTO.
* @param item ItemDTO that values are copied from. 
* @param quantity the new quantity of the item.
**/
public ItemDTO(ItemDTO item,int quantity) {
    this.price = item.price;
    this.description = item.description;
    this.quantity = quantity;
    this.taxes = item.taxes;
    this.itemID = item.itemID;
}

    /**
     * @return the price of the item.
     **/
    public int getPrice() {
        int price = this.price;
        return price;
    }
    /**
     * @return the description of the item.
     **/
    
    public String getDescription() {
        String description = this.description;
        return description;
    }
    /**
     * @return the quantity of the item.
     **/
    public int getQuantity() {
        int quantity = this.quantity;
        return quantity;
    }
    /**
     * @return the tax percentage of the item.
     **/
    public double getTaxes() {
        double taxes = this.taxes;
        return taxes;
    }
    /**
     * @return the item ID of the item.
     **/
    public String getID(){
        return itemID;
    } 
    /**
     * compare 2 items and check if they are the same item.
     **/
    @Override
    public boolean equals(Object other){
        if (other == null|| !(other instanceof ItemDTO)){
            return false;
        }
        ItemDTO otherItem = (ItemDTO) other;
        return this.getID().equals(otherItem.getID());
    }

    
}
