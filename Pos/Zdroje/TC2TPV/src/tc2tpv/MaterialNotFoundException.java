/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tc2tpv;

/**
 * Vyjímka - v případě, že přidávaný materiál neexistuje v TPV
 * 
 * @author TPV
 */
public class MaterialNotFoundException extends Exception {
    
    private String message;
    
    /**
     * Konstruktor - nebyl nalezen materiál dle klíče
     * 
     * @param key Dodaný klíč materiálu
     */
    public MaterialNotFoundException(int key) {
        message = "Materiál s klíčem " + key + " nebyl nalezen";
    }
    
    /**
     * Konstruktor - nebyl nalezen materiál dle zadaného ID
     * 
     * @param id Dodané ID
     */
    public MaterialNotFoundException(String id) {
        message = "Materiál s ID " + id + " nebyl nalezen";
    }
    
    /**
     * Konstruktor - nebyl nalezen materiál dle zadaných atributů (4 - názvová položka)
     * 
     * @param name  Dodaný název položka
     * @param a1    Dodaný první atribut
     * @param a2    Dodaný druhý atribut
     * @param a3    Dodaný třetí atribut
     */
    public MaterialNotFoundException(String name, String a1, String a2, String a3) {
        message = "Materiál dle atributů (" + name + ", " + a1 + ", " + a2 + ", " + a3 + ") nebyl nalezen";
    }
    
    /**
     * 
     * @return Chybové hlášení
     */
    @Override
    public String getMessage() {
        return message;
    }
    
}
