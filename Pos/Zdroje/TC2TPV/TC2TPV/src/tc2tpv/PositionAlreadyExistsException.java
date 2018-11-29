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
public class PositionAlreadyExistsException extends Exception {
    
    private final String message;
    
    public PositionAlreadyExistsException(int position, String itemId) {
        message = "Pozice " + position + " je již definována u komponenty " + itemId;
    }
    
    @Override
    public String getMessage() {
        return message;
    }
    
}
