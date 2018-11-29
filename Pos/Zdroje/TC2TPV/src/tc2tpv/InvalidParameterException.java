/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tc2tpv;

/**
 * Vyjímka - vrací se v případě, že jméno TC parametru není nastaveno v tabulce tpvg_tc2tpv_config
 * 
 * @author TPV
 */
public class InvalidParameterException extends Exception {
    
    private String message;
    
    /**
     * Standardní konstruktor
     * 
     * @param TCName    Zadané jméno parametru
     */
    public InvalidParameterException(String TCName) {
        message = "Parametr " + TCName + " nebyl v kofiguraci TC2TPV nalezen";
    }
    
    /**
     * 
     * @return Chybová hláška
     */
    @Override
    public String getMessage() {
        return message;
    }
    
}
