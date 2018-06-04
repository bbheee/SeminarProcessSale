/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

/**
 *
 * @author beibei
 */
public class RegistryCreator {
    private ItemRegistry itemRegistry = new ItemRegistry();
    
    public RegistryCreator(){
        
    }
    
    public ItemRegistry getItemRegistry(){
        return itemRegistry;
    }
    
}
