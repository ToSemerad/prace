/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tc2tpv;

/**
 * Špatně zadaná extenze souboru
 * 
 * @author TPV
 */
public class DocumentExtensionNotFoundException extends Exception {
    
    private String message;
    
    /**
     * Vytvoří hlášení
     * 
     * @param url dodaná cesta k souboru
     */
    public DocumentExtensionNotFoundException(String url) {
        message = "Wrn: zadaná přípona souboru '" + url.substring(url.lastIndexOf("."), url.length()) + "' není platná";
    }
    
    @Override
    public String getMessage() {
        return message;
    }
    
}
