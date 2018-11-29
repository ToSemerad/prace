/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tc2tpv;

/**
 * Řádek kusovníku (vazba)
 * 
 * @author TPV
 */
public class TPVBOMLine {
    
    private TPVItem item;
    private float quantity;
    private int position;
    
    /**
     * Jednoduchý konstruktor - pozice v kusovníku je generována automaticky
     * 
     * @param item      TPVItem - nižší položka
     * @param quantity  Množství v kusovníku
     */
    public TPVBOMLine(TPVItem item, float quantity) {
        this.item = item;
        this.quantity = quantity;
    }
    
    /**
     * Složitější konstruktor - umožňuje zadat číselnou pozici v kusovníku
     * 
     * @param item      TPVItem - nižší položka
     * @param quantity  Množství v kusovníku
     * @param position  Pozice v kusovníku
     */
    public TPVBOMLine(TPVItem item, float quantity, int position) {
        this.item = item;
        this.quantity = quantity;
        this.position = position;
    }
    
    /**
     * Vrací nižší položku z BOM
     * 
     * @return TPVItem - komponenta
     */
    public TPVItem getItem() {
        return item;
    }
    
    /**
     * Nastaví položku
     * 
     * @param item  TPVItem - komponenta
     */
    public void setItem(TPVItem item) {
        this.item = item;
    }
    
    /**
     * Vrací množství v kusovníku
     * 
     * @return množství v kusovníku
     */
    public float getQuantity() {
        return quantity;
    }
    
    /**
     * Nastaví množství v kusovníku
     * 
     * @param quantity Množství
     */
    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
    
    /**
     * Vrací pozici v kusovníku
     * 
     * @return Číselná pozice v kusovníku
     */
    public int getPosition() {
        return position;
    }
    
    /**
     * Nastaví pozici
     * 
     * @param position číselná pozice v kusovníku 
     */
    public void setPosition(int position) {
        this.position = position;
    }    
    
}
