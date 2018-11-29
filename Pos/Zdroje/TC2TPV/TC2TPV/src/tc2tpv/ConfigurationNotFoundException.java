/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tc2tpv;

/**
 * Vyjímka - pokud není nakofigurován přenos z TC
 * 
 * @author TPV
 */
public class ConfigurationNotFoundException extends Exception{
    
    private String message;
    
    /**
     * Konstruktor - vytvoří chybovou hlášku
     */
    public ConfigurationNotFoundException() {
        this.message = "Nebyla nalezena standardní konfigurace pro přenos s názvem 'Team Center'";
    }
    
    @Override
    public String getMessage() {
        return message;
    }
    
}
