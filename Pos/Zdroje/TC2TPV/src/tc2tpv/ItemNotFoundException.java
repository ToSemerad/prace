/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tc2tpv;

/**
 * Vyjímka - pokud není nalezena položka pro založení vazby
 * 
 * @author TPV
 */
public class ItemNotFoundException extends Exception {
    
    private String message;
    
    /**
     * Konstruktor - dodané ID, které nebylo nalezeno
     * 
     * @param itemId 
     */
    public ItemNotFoundException(String itemId) {
        this.message = "Položka s ID " + itemId + " nebyla založena";
    }
    
    @Override
    public String getMessage() {
        return message;
    }
    
}
