/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tc2tpv;

/**
 * Cesta k příloze nesmí být delší než 255 znaků
 * 
 * @author TPV
 */
public class DocumentURLOverflowException extends Exception{
    
    private String message;
    
    /**
     * Vytvoří hlášení
     * 
     * @param url dodaná cesta k souboru
     */
    public DocumentURLOverflowException(String url) {
        message = "Wrn: zadaná cesta na soubor '" + url + "' obsahuje " + url.length() + " zanků - maximum je 255 - příloha nebude importována";
    }
    
    @Override
    public String getMessage() {
        return message;
    }
    
}
