/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.rule.ManagerCache;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import managerindustry.db.entities.cache.AdjustedPriceEntity;
import managerindustry.logic.exception.AdjustedPriceNotExistsException;
import managerindustry.logic.manager.rule.ManagerDB.ManagerDBCache;
import managerindustry.logic.tax.jobInstallationFee.adjustedPrice.AdjustedPrice;

/**
 *
 * @author lele
 */
public class ManagerAdjustedPrice {
    private AdjustedPriceEntity adjustedPriceEntity = new AdjustedPriceEntity();
    private Map<String, AdjustedPrice > adjustedPriceMap = new HashMap<>();
    private String typeId = null;

    public ManagerAdjustedPrice(String typeId, Map<String, AdjustedPrice > adjustedPriceMap) {
        this.adjustedPriceMap = adjustedPriceMap;
        this.typeId = typeId;
        
        if ( this.adjustedPriceMap.isEmpty() )
            return;
        
        initAdjustedPriceDB();
    }

    /**
     * Init Adjusted Price DB
     */
    private void initAdjustedPriceDB(){
        if ( ManagerDBCache.getInstance().getAllAdjustedPriceEntity() == null){
            ManagerDBCache.getInstance().addAdjustedPriceEntity(adjustedPriceEntity);
        }
    }
    
    /**
     * Init If Exists
     */
    private void initIfExists(){
        adjustedPriceEntity = 
         ManagerDBCache.getInstance().getAdjustedPriceEntity(typeId);
        
        if (adjustedPriceEntity == null){
            addAdjustedPrice();
        }else{
            updateAdjustedPrice(true);
        }
        updateAllAdjustedPrice();
        deleteAllAdjustedPrice();
    }
    
    /**
     * Add Adjusted Price
     */
    private void addAdjustedPrice(){
        Date nowPresent = new Date( new Date().getTime());
        
        AdjustedPrice adjustedPrice = 
         this.adjustedPriceMap.get(this.typeId);
                 
        try {
            if ( adjustedPrice == null){
                throw new AdjustedPriceNotExistsException();
            }
        } catch (Exception e) {
            System.out.println(""+e.getMessage());
            return;
        }
        
        this.adjustedPriceEntity = new AdjustedPriceEntity();
        this.adjustedPriceEntity.setLastUsed(nowPresent);
        this.adjustedPriceEntity.setAverage_price(adjustedPrice.getAdjusted_price());
        this.adjustedPriceEntity.setAdjusted_price(adjustedPrice.getAdjusted_price());
        ManagerDBCache.getInstance().addAdjustedPriceEntity(adjustedPriceEntity);
    }
    
    /**
     * Add Adjusted Price
     * @param adjustedPriceMap
     * @param typeId 
     */
    private void addAdjustedPrice(Map<String, AdjustedPrice > adjustedPriceMap, String typeId){
        this.typeId = typeId;
        this.adjustedPriceMap = adjustedPriceMap;
        addAdjustedPrice();
    }
    
    /**
     * Update Adjusted Price
     * @param boolean valueBool 
     */
    private void updateAdjustedPrice(boolean valueBool ){
        if (valueBool){
            Date nowPresent = new Date( new Date().getTime());
            adjustedPriceEntity.setLastUsed(nowPresent);            
        }
        
        // Adjusted Price From Json ( eve server )
        AdjustedPrice adjustedPrice = this.adjustedPriceMap.get(this.typeId);
        adjustedPriceEntity.setAdjusted_price(adjustedPrice.getAdjusted_price());
        adjustedPriceEntity.setAverage_price(adjustedPrice.getAverage_price());
        
        ManagerDBCache.getInstance().updateTaxAdjustedPriceEntity(adjustedPriceEntity);
    }
    
    private void updateAllAdjustedPrice(){
        List < AdjustedPriceEntity > adjustedPriceEntitys = 
         ManagerDBCache.getInstance().getAllExceptSpecificAdjustedPriceEntity(typeId);
        
        if (adjustedPriceEntitys.isEmpty())
            return;
        
        for (AdjustedPriceEntity adjustedPriceEntity1 : adjustedPriceEntitys) {
            this.typeId = adjustedPriceEntity1.getType_id();
            this.adjustedPriceEntity = adjustedPriceEntity1;
            updateAdjustedPrice(false);
        }
    }
    
    private void deleteAllAdjustedPrice(){
        
    }
    
    public AdjustedPriceEntity getAdjustedPriceEntity(String typePrice, Map<String, AdjustedPrice > adjustedPriceMap ) {
        AdjustedPriceEntity adjustedPriceEntity = 
         ManagerDBCache.getInstance().getAdjustedPriceEntity(typePrice);
        
        if ( adjustedPriceEntity == null ){
            addAdjustedPrice(adjustedPriceMap, typePrice);
            adjustedPriceEntity = ManagerDBCache.getInstance().getAdjustedPriceEntity(typePrice);
            
            try {
                throw new AdjustedPriceNotExistsException();
            } catch (Exception e) {
                System.out.println(""+e.getMessage());
                return null;                
            }
        }
        
        
        return adjustedPriceEntity;
    }

    private void setAdjustedPriceEntity(AdjustedPriceEntity adjustedPriceEntity) {
        this.adjustedPriceEntity = adjustedPriceEntity;
    }

    private Map<String, AdjustedPrice> getAdjustedPriceMap() {
        return adjustedPriceMap;
    }

    private void setAdjustedPriceMap(Map<String, AdjustedPrice> adjustedPriceMap) {
        this.adjustedPriceMap = adjustedPriceMap;
    }

    private String getTypeId() {
        return typeId;
    }

    private void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    
    
    
}
