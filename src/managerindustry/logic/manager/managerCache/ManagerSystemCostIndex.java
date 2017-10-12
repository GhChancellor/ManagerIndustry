/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.managerCache;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import managerindustry.db.entities.cache.TaxCostIndexEntity;
import managerindustry.db.entities.cache.TaxSolarSystemEntity;
import managerindustry.logic.exception.SolarSystemNotExistsException;
import managerindustry.logic.manager.managerDB.ManagerDBCache;
import managerindustry.logic.json.tax.json.systemCostIndices.CostIndex;
import managerindustry.logic.json.tax.json.systemCostIndices.SolarSystemCost;
import managerindustry.logic.json.tax.json.systemCostIndices.SystemCostFetch;

/**
 * Update, create and delete all Solar system
 * @author lele
 */

/*
        SystemCostIndex systemCostIndex = new SystemCostIndex();
        Map<String, SolarSystemCost > solarSystemMap = systemCostIndex.getSystemCostIndexs();
        
        ManagerSystemCostIndex managerSystemCostIndex = 
         new ManagerSystemCostIndex(solarSystemMap, "1");
        System.out.println(""+ managerSystemCostIndex.getCostIndexEntity("1", "manufacturing"));
*/
public class ManagerSystemCostIndex {
    boolean DBG_flag = true;
    
    private TaxSolarSystemEntity taxSolarSystemEntity = new TaxSolarSystemEntity();
    private Map<String, SolarSystemCost > solarSystemMap = new HashMap<>();
    private String solarSystemID = null;
    private static ManagerSystemCostIndex instance = null;

    private ManagerSystemCostIndex() throws SolarSystemNotExistsException {
        initSystemCostIndexDB();        
    }
    
    public static ManagerSystemCostIndex getInstance() throws SolarSystemNotExistsException{
        if ( instance == null )
            instance = new ManagerSystemCostIndex();
        return instance;
    }
     
    /**
     * Create the database
     */
    private void initSystemCostIndexDB(){       
        if (ManagerDBCache.getInstance().getAllTaxSolarSystemEntity() == null ){
            ManagerDBCache.getInstance().addTaxSolarSystemEntity(taxSolarSystemEntity);
        }
    }
    
    /**
     * Get Solar System Map if null get SystemCostFetch.getSystemCostIndexs();
     * @return SolarSystemCost
     * @throws SolarSystemNotExistsException 
     */
    private SolarSystemCost getSolarSystemMap() throws SolarSystemNotExistsException{
        SolarSystemCost solarSystem = this.solarSystemMap.get(this.solarSystemID);
        
        if ( solarSystem == null){
                this.solarSystemMap = SystemCostFetch.getSystemCostIndexs();
                solarSystem = this.solarSystemMap.get(this.solarSystemID);               
            
            if ( solarSystem == null ){
                throw new SolarSystemNotExistsException();
            }else{
                return solarSystem;
            }    
        }else{
            return solarSystem;
        }        
    }
    
    
    /**
     * Add new solar system
     */
    private void addSolarSystem() throws SolarSystemNotExistsException{
        Date nowPresent = new Date();
  
        SolarSystemCost solarSystem = getSolarSystemMap();
                
        taxSolarSystemEntity = new TaxSolarSystemEntity();
        taxSolarSystemEntity.setSolarSystemID(this.solarSystemID);
        taxSolarSystemEntity.setLastUsed(nowPresent);
        List < CostIndex > costIndexs = Arrays.asList(solarSystem.getCostIndexs());
        
        
        for (CostIndex costIndex : costIndexs) {
            TaxCostIndexEntity taxCostIndexEntity = new TaxCostIndexEntity();
            taxCostIndexEntity.setActivity(costIndex.getActivity());
            taxCostIndexEntity.setCostIndex(costIndex.getCostIndex());

            taxSolarSystemEntity.addTaxCostIndexEntity(taxCostIndexEntity);
        }
        ManagerDBCache.getInstance().addTaxSolarSystemEntity(taxSolarSystemEntity);
    }    
    
    /**
     * Init All
     * @param String solarSystemID
     * @throws SolarSystemNotExistsException 
     */
    private void initAll(String solarSystemID) throws SolarSystemNotExistsException{
        this.solarSystemID = solarSystemID;
        
        this.taxSolarSystemEntity = 
         ManagerDBCache.getInstance().getSolarSystemEntity(this.solarSystemID);
        
                
        if ( taxSolarSystemEntity == null){
            addSolarSystem();
        }else{
            updateSolarSystem(true);
        }

        updateAllSolarSystem();
//        deleteSolarSystem();        
    }
    
    /**
     * Update Solar System
     * @param TaxSolarSystemEntity taxSolarSystemEntity
     * @param boolean valueBool 
     */
    private void updateSolarSystem(boolean valueBool) throws SolarSystemNotExistsException{
        
        if (valueBool){
            Date nowPresent = new Date();
            taxSolarSystemEntity.setLastUsed(nowPresent);            
        }
        
        // Solar systems From Json ( eve server )
        
        SolarSystemCost solarSystem = getSolarSystemMap();
//        SolarSystemCost solarSystem = this.solarSystemMap.get(this.solarSystemID);
        
        // Convert Arrays to Costindexs
        List < CostIndex > costIndexs = Arrays.asList(solarSystem.getCostIndexs());        

        Map < String, CostIndex > costIndexMap = 
         costIndexs.stream().collect(Collectors.toMap(CostIndex::getActivity, CostIndex -> CostIndex));

        // "activity": "manufacturing"....From DB
        List < TaxCostIndexEntity > taxCostIndexEntity = taxSolarSystemEntity.getTaxCostIndexEntities();   
        
        for (TaxCostIndexEntity taxCostIndexEntity1 : taxCostIndexEntity) {
            
            CostIndex costIndex = costIndexMap.get(taxCostIndexEntity1.getActivity());
            taxCostIndexEntity1.setCostIndex(costIndex.getCostIndex());
            ManagerDBCache.getInstance().updateTaxCostIndexEntity(taxCostIndexEntity1);
            
            if ( valueBool ){
                ManagerDBCache.getInstance().updateTaxSolarSystemEntity(taxSolarSystemEntity);
            }
        }
    }    
    /**
     * Update All Solar System
     */
    private void updateAllSolarSystem() throws SolarSystemNotExistsException{
        
        List < TaxSolarSystemEntity > tempTaxSolarSystemEntity = 
         ManagerDBCache.getInstance().getAllExceptSpecificSolarSysemEntity(this.solarSystemID);
        
        if (tempTaxSolarSystemEntity== null && tempTaxSolarSystemEntity.isEmpty())
            throw new SolarSystemNotExistsException(solarSystemID);
        
        for (TaxSolarSystemEntity taxSolarSystemEntity : tempTaxSolarSystemEntity) {
            // qui
            this.solarSystemID = taxSolarSystemEntity.getSolarSystemID();
            this.taxSolarSystemEntity = taxSolarSystemEntity;
            updateSolarSystem(false);
        }
    }

    /**
     * Delete Solar System
     * DBG
     */    
    private void deleteSolarSystem(){
        System.out.println("DBG deleteSolarSystem da errore nella eliminazione dei fati");
        long monthInSecond = 3600l; // 2592000l;
        Date nowPresent = new Date();
        List < TaxSolarSystemEntity > solarSystemEntitys =
        ManagerDBCache.getInstance().getAllExceptSpecificSolarSysemEntity(this.solarSystemID);
        
        if (solarSystemEntitys.isEmpty())
            return;        
        
        for (TaxSolarSystemEntity solarSystemEntity : solarSystemEntitys) {
            Date lastUsed = solarSystemEntity.getLastUsed();
            long timePassed = nowPresent.getTime() - lastUsed.getTime();

            if ( timePassed >  monthInSecond ){
                ManagerDBCache.getInstance().deleteTaxSolarSystemEntity(taxSolarSystemEntity);
            }
        }
        
    }

    public float getCostIndexEntityDBG(String solarSystemID, String activity, boolean flag) throws SolarSystemNotExistsException{
        DBG_flag = flag;
        this.taxSolarSystemEntity = 
         ManagerDBCache.getInstance().getSolarSystemEntity(solarSystemID);
        return getCostIndexEntity(solarSystemID, activity);
    }
    
    /**
     * Get Cost Index Entity
     * @param String solarSystemID
     * @param String activity
     * @return String
     * @throws SolarSystemNotExistsException 
     */
    public float getCostIndexEntity(String solarSystemID, String activity) throws SolarSystemNotExistsException{
        
        // DBG esclude i valori presi da EVe Server
        if ( DBG_flag ){
            initAll(solarSystemID);
        }           

        if (taxSolarSystemEntity == null)
            throw new SolarSystemNotExistsException();            
            
        List < TaxCostIndexEntity > taxCostIndexEntitys = taxSolarSystemEntity.getTaxCostIndexEntities();
        if (taxCostIndexEntitys.isEmpty()){
            return 0f;
        }           
        
        for (TaxCostIndexEntity taxCostIndexEntity : taxCostIndexEntitys) {
            if ( taxCostIndexEntity.getActivity().equals(activity)){
                return Float.parseFloat(taxCostIndexEntity.getCostIndex());
            }
        }
        return 0f;        
    }
}
