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
import managerindustry.logic.buiild.TotalCalculatedComponentX;

/**
 *
 * @author lele
 */
public class ManagerComponentX {
    private static ManagerComponentX instance = null;
    private List < ComponentX> baseComponentXs = new ArrayList<>();
    private Map < String, TotalCalculatedComponentX > totalcalculatedComponentXMap = new HashMap<>();
    
    
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
    public Map<String, TotalCalculatedComponentX> getTotalcalculatedComponentXMap() {
        return totalcalculatedComponentXMap;
    }

    /**
     * Set Calculated ComponetXs, component processed
     * @param Map<String, TotalCalculatedComponentX>
     */
    public void setTotalcalculatedComponentXMap(Map<String, TotalCalculatedComponentX> totalcalculatedComponentXMap) {
        this.totalcalculatedComponentXMap = totalcalculatedComponentXMap;
    }
    
    /**
     * Add Calculated ComponetXs, component processed
     * @param nameMaterial
     * @param calculatedComponentX 
     */
    public void addTotalcalculatedComponentX(TotalCalculatedComponentX calculatedComponentX) {
        String nameMaterial = calculatedComponentX.getName();
        
        if ( totalcalculatedComponentXMap.containsKey(nameMaterial)){
            int value = totalcalculatedComponentXMap.get(nameMaterial).getQuanity() + calculatedComponentX.getQuanity();
            calculatedComponentX.setQuanity(value);
            
            totalcalculatedComponentXMap.put(nameMaterial, calculatedComponentX );
        }else{           
            totalcalculatedComponentXMap.put(nameMaterial, calculatedComponentX );
        }        
    }
    
}
