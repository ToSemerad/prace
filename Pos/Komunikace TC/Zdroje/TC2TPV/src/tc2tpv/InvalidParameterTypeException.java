/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tc2tpv;

/**
 * Vyjímka - v případě že nesouhlasí datový typ parametru
 * 
 * @author TPV
 */
public class InvalidParameterTypeException extends Exception {
    
    private String message;
    
    /**
     * Standardní konstruktor
     * 
     * @param TCName        Jméno parametru v TC
     * @param typSupplied   Dodaný datový typ
     * @param typTpv        Typ, který vyžaduje TPV
     */
    public InvalidParameterTypeException(String TCName, String typSupplied, String typTpv) {
        message = "Parametr " + TCName + " má špatný datový formát. Typ " + typSupplied + " nelze vložit do pole typu " + typTpv;
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
