/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import managerindustry.logic.buiild.ComponentX;
import managerindustry.logic.buiild.SingleCalculatedComponentX;
import managerindustry.logic.buiild.TotalCalculatedComponentX;

/**
 *
 * @author lele
 */
public class ManagerComponentX {
    private static ManagerComponentX instance = null;
    private List < ComponentX> baseComponentXs = new ArrayList<>();
    private Map < String, TotalCalculatedComponentX > totalCalculatedComponentXMap = new HashMap<>();
    private Map < String, SingleCalculatedComponentX > singleCalculatedComponentXMap = new HashMap<>();
    
    public static ManagerComponentX getInstance(){
        if ( instance == null ){
            instance = new ManagerComponentX();
        }
        return instance;
    }
    
    /**
     * Get Base ComponentXs, component NOT processed
     * @return List<ComponentX> 
     */
    public List<ComponentX> getBaseComponentXs() {
        return baseComponentXs;
    }

    /**
     * Set Base ComponentXs, component NOT processed
     * @param List<ComponentX> baseComponentXs 
     */
    public void setBaseComponentXs(List<ComponentX> baseComponentXs) {
        this.baseComponentXs = baseComponentXs;
    }
    
    /**
     * Add Base ComponentXs, component NOT processed
     * @param ComponentX componentX 
     */
    public void addComponentXs(ComponentX componentX) {
        this.baseComponentXs.add(componentX);
    }
    
    /**
     * Get Totalcalculated ComponentX Map
     * @return Map<String, TotalCalculatedComponentX>
     */
    public Map<String, TotalCalculatedComponentX> getTotalCalculatedComponentXMap() {
        return totalCalculatedComponentXMap;
    }

    /**
     * Set Calculated ComponetXs, component processed
     * @param Map<String, TotalCalculatedComponentX>
     */
    public void setTotalCalculatedComponentXMap(Map<String, TotalCalculatedComponentX> totalCalculatedComponentXMap) {
        this.totalCalculatedComponentXMap = totalCalculatedComponentXMap;
    }
    
    /**
     * Add Calculated ComponetXs, component processed
     * @param nameMaterial
     * @param calculatedComponentX 
     */
    public void addTotalcalculatedComponentX(TotalCalculatedComponentX calculatedComponentX) {
        String nameMaterial = calculatedComponentX.getName();
        
        if ( totalCalculatedComponentXMap.containsKey(nameMaterial)){
            int value = totalCalculatedComponentXMap.get(nameMaterial).getQuanityInt() + calculatedComponentX.getQuanityInt();
            calculatedComponentX.setQuanityInt(value);
            
            totalCalculatedComponentXMap.put(nameMaterial, calculatedComponentX );
        }else{           
            totalCalculatedComponentXMap.put(nameMaterial, calculatedComponentX );
        }        
    }

    /**
     * Get Single Calculated ComponentX Map
     * @return Map<String, SingleCalculatedComponentX>
     */
    public Map<String, SingleCalculatedComponentX> getSingleCalculatedComponentXMap() {
        return singleCalculatedComponentXMap;
    }

    /**
     * Set Single Calculated ComponentX Map
     * @param singleCalculatedComponentXMap 
     */
    public void setSingleCalculatedComponentXMap(Map<String, SingleCalculatedComponentX> singleCalculatedComponentXMap) {
        this.singleCalculatedComponentXMap = singleCalculatedComponentXMap;
    }
    
    /**
     * Add Single Calculated ComponentX Map
     * @param SingleCalculatedComponent singleCalculatedComponentX 
     */
    public void addSingleCalculatedComponentXMap(SingleCalculatedComponentX singleCalculatedComponentX) {
        String nameMaterial = singleCalculatedComponentX.getName();
        
        if ( singleCalculatedComponentXMap.containsKey(nameMaterial)){
            int value = singleCalculatedComponentXMap.get(nameMaterial).getQuanityInt() + singleCalculatedComponentX.getQuanityInt();
            singleCalculatedComponentX.setQuanityInt(value);
            
            singleCalculatedComponentXMap.put(nameMaterial, singleCalculatedComponentX );
        }else{           
            singleCalculatedComponentXMap.put(nameMaterial, singleCalculatedComponentX );
                
        }
    }
}
