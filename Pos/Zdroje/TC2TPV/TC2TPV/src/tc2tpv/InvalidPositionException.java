/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tc2tpv;

/**
 *
 * @author pvole
 */
public class InvalidPositionException extends Exception {
    
    private final String message;
    
    public InvalidPositionException(String itemId) {
        message = "U komponenty " + itemId + " byla zjištěna neplatná pozice - musí být >= 0 a < 5000";
    }
    
    @Override
    public String getMessage() {
        return message;
    }
    
}
