/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tc2tpv;

import java.util.HashMap;

/**
 * Správce kusovníku - poskytuje metody pro jednoduché naplnění stromu
 * 
 * @author TPV
 */
public class TPVBOM {
    
    private static String rootId;
    private static HashMap<String, TPVItem> items = new HashMap<>();
    
    /**
     * Vložení vrcholové položky
     * 
     * @param root  TPVItem - vrcholová položka
     */
    public static void insertRootItem(TPVItem root) {
        if (rootId == null || rootId.equals("")) {
            rootId = root.getItemId();
        }
        if (!items.containsKey(root.getItemId())) {
            items.put(rootId, root);
        }
    }
    
    /**
     * Vložení položky
     * 
     * @param item  TPVItem - jakákoliv obecná položka
     */
    public static void insertItem(TPVItem item) {
        if (!items.containsKey(item.getItemId())) {
            items.put(item.getItemId(), item);
        }
    }
    
    /**
     * Vloží kusovníkovou vazbu
     * 
     * @param itemId                    ID vyšší položky
     * @param componentId               ID nižší položky
     * @param quantity                  Množství
     * @throws ItemNotFoundException    V případě, že položka není v seznamu (nebyla založena)
     */
    public static void insertBomLine(String itemId, String componentId, float quantity) throws ItemNotFoundException {
        if (!items.containsKey(itemId)) {
            throw new ItemNotFoundException(itemId);
        }
        if (!items.containsKey(componentId)) {
            throw new ItemNotFoundException(componentId);
        }
        TPVItem item = items.get(itemId);
        TPVItem component = items.get(componentId);
        
        item.addBomLine(component, quantity);
    }
    
    /**
     * Vloží kusovníkovou vazbu na urcenou pozici
     * 
     * @param itemId                    ID vyšší položky
     * @param componentId               ID nižší položky
     * @param quantity                  Množství
     * @param position                  Pozice v kusovniku
     * @throws ItemNotFoundException    V případě, že položka není v seznamu (nebyla založena)
     */
    public static void insertBomLine(String itemId, String componentId, float quantity, int position) throws ItemNotFoundException, PositionAlreadyExistsException, InvalidPositionException {
        if (!items.containsKey(itemId)) {
            throw new ItemNotFoundException(itemId);
        }
        if (!items.containsKey(componentId)) {
            throw new ItemNotFoundException(componentId);
        }
        TPVItem item = items.get(itemId);
        TPVItem component = items.get(componentId);
        
        item.addBomLine(component, quantity, position);
    }
    
    /**
     * Vrací vrcholovou sestavu
     * 
     * @return TPVItem                          Vrcholová sestava 
     * @throws tc2tpv.ItemNotFoundException     Pokud není nalezen dle ID
     */
    public static TPVItem getRoot() throws ItemNotFoundException {
        if (!items.containsKey(rootId)) {
            throw new ItemNotFoundException(rootId);
        }
        return items.get(rootId);
    }
    
    /**
     * Vrací položku dle ID
     * 
     * @param id                                ID položky
     * @return                                  TPVItem dle id
     * @throws tc2tpv.ItemNotFoundException     Pokud není ID nalezeno
     */
    public static TPVItem getItem(String id) throws ItemNotFoundException {
        if (!items.containsKey(id)) {
            throw new ItemNotFoundException(id);
        }
        return items.get(id);
    }
    
}
