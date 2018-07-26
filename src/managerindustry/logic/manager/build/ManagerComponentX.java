/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.build;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import managerindustry.logic.build.CalculatedComponentX;
import managerindustry.logic.build.ComponentX;
import managerindustry.logic.build.ReportCalculatedComponentX;

/**
 *
 * @author lele
 */
public class ManagerComponentX {
    private static ManagerComponentX instance = null;
    private List < ComponentX> baseComponentXs = new ArrayList<>();
    private List < CalculatedComponentX > calculatedComponentXs = new ArrayList<>();
    
    private Map < String, ReportCalculatedComponentX > reportCalculatedComponentXMap = new HashMap<>();
//    private Map < String, SingleCalculatedComponentX > singleCalculatedComponentXMap = new HashMap<>();
    
    
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
     * Get report calculated ComponentX Map
     * @return Map<String, ReportCalculatedComponentX>
     */
    public Map<String, ReportCalculatedComponentX> getReportCalculatedComponentXMap() {
        return reportCalculatedComponentXMap;
    }

    /**
     * Set report calculated ComponetXs, component processed
     * @param Map<String, ReportCalculatedComponentX>
     */
    private void setReportCalculatedComponentXMap(Map<String, ReportCalculatedComponentX> reportCalculatedComponentXMap) {
        this.reportCalculatedComponentXMap = reportCalculatedComponentXMap;
    }
    
    /**
     * Sum all values Calculated ComponetXs, component processed
     * @param TotalCalculatedComponentX totalCalculatedComponentX 
     */
    public void sumReportCalculatedComponentXMap(ReportCalculatedComponentX reportCalculatedComponentX) {
        String nameMaterial = reportCalculatedComponentX.getName();
        
        if ( this.reportCalculatedComponentXMap.containsKey(nameMaterial)){           
            double value = (this.reportCalculatedComponentXMap.get(nameMaterial).getQuanityDbl() + reportCalculatedComponentX.getQuanityDbl());
            reportCalculatedComponentX.setQuanityDbl(value);           
            this.reportCalculatedComponentXMap.put(nameMaterial, reportCalculatedComponentX );
        }else{           
            this.reportCalculatedComponentXMap.put(nameMaterial, reportCalculatedComponentX );
        }        
    }
    
    /**
     * Get Calculated ComponentXs
     * @return List<CalculatedComponentX>
     */
    public List<CalculatedComponentX> getCalculatedComponentXs() {
        return calculatedComponentXs;
    }

    /**
     * Set Calculated ComponentXs
     * @param List<CalculatedComponentX> calculatedComponentXs 
     */
    public void setCalculatedComponentXs(List<CalculatedComponentX> calculatedComponentXs) {
        this.calculatedComponentXs = calculatedComponentXs;
    }

    /**
     * Add Calculated ComponentXs
     * @param CalculatedComponentX calculatedComponentXs 
     */
    public void addCalculatedComponentXs( CalculatedComponentX calculatedComponentXs) {
        this.calculatedComponentXs.add(calculatedComponentXs);
    }



    
    

//    /**
//     * Get Single Calculated ComponentX Map
//     * @return Map<String, SingleCalculatedComponentX>
//     */
//    public Map<String, SingleCalculatedComponentX> getSingleCalculatedComponentXMap() {
//        return singleCalculatedComponentXMap;
//    }
//
//    /**
//     * Set Single Calculated ComponentX Map
//     * @param singleCalculatedComponentXMap 
//     */
//    public void setSingleCalculatedComponentXMap(Map<String, SingleCalculatedComponentX> singleCalculatedComponentXMap) {
//        this.singleCalculatedComponentXMap = singleCalculatedComponentXMap;
//    }
//    
//    /**
//     * Add Single Calculated ComponentX Map
//     * @param SingleCalculatedComponent singleCalculatedComponentX 
//     */
//    public void addSingleCalculatedComponentXMap(SingleCalculatedComponentX singleCalculatedComponentX) {
//        String nameMaterial = singleCalculatedComponentX.getName();
//        
//        if ( singleCalculatedComponentXMap.containsKey(nameMaterial)){
//            // ????? xè lo hai fatto?
//            int value = singleCalculatedComponentXMap.get(nameMaterial).getQuanityInt() + singleCalculatedComponentX.getQuanityInt();
//            singleCalculatedComponentX.setQuanityInt(value);
//            
//            singleCalculatedComponentXMap.put(nameMaterial, singleCalculatedComponentX );
//        }else{           
//            singleCalculatedComponentXMap.put(nameMaterial, singleCalculatedComponentX );
//                
//        }
//    }

}
