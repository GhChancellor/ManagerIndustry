/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.ManagerCache;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import managerindustry.db.entities.cache.PriceEntity;
import managerindustry.logic.exception.PriceNotExistsException;
import managerindustry.logic.manager.ManagerDB.ManagerDBCache;
import managerindustry.logic.tax.jobInstallationFee.adjustedPrice.Price;

/**
 *
 * @author lele
 */
public class ManagerPrice {
    private PriceEntity priceEntity = new PriceEntity();
    private Map<String, Price > priceMap = new HashMap<>();
    private String typeId = null;

    public ManagerPrice(String typeId, Map<String, Price > adjustedPriceMap) {
        this.priceMap = adjustedPriceMap;
        this.typeId = typeId;
        
        if ( this.priceMap.isEmpty() )
            return;
        
        initPriceDB();
        initValue();
    }

    /**
     * Init Price DB
     */
    private void initPriceDB(){
        if ( ManagerDBCache.getInstance().getAllPriceEntity() == null){
            ManagerDBCache.getInstance().addPriceEntity(priceEntity);
        }
    }
    
    /**
     * Put value in the DB
     */
    private void initValue(){
        priceEntity = 
         ManagerDBCache.getInstance().getPriceEntity(typeId);
        
        if (priceEntity == null){
            addPriceIfexists();
        }else{
            updatePrice(true);
        }
        updateAllPrice();
        deleteAllPrice();
    }
    
    /**
     * Add Adjusted Price
     */
    private void addPriceIfexists(){
        Date nowPresent = new Date( new Date().getTime());
        
        Price price = 
         this.priceMap.get(this.typeId);
                 
        try {
            if ( price == null){
                throw new PriceNotExistsException();
            }
        } catch (Exception e) {
            System.out.println(""+e.getMessage());
            return;
        }
        
        this.priceEntity = new PriceEntity();
        this.priceEntity.setType_id(price.getType_id());
        this.priceEntity.setLastUsed(nowPresent);
        this.priceEntity.setAverage_price(price.getAdjusted_price());
        this.priceEntity.setAdjusted_price(price.getAdjusted_price());
        
        ManagerDBCache.getInstance().addPriceEntity(priceEntity);
    }
    
    /**
     * Add Price
     * @param priceMap
     * @param typeId 
     */
    private void addPrice(Map<String, Price > priceMap, String typeId){
        this.typeId = typeId;
        this.priceMap = priceMap;
        addPriceIfexists();
    }
    
    /**
     * Update Price
     * @param boolean valueBool 
     */
    private void updatePrice(boolean valueBool ){
        if (valueBool){
            Date nowPresent = new Date( new Date().getTime());
            priceEntity.setLastUsed(nowPresent);            
        }
        
        // Adjusted Price From Json ( eve server )
        Price adjustedPrice = this.priceMap.get(this.typeId);
        priceEntity.setAdjusted_price(adjustedPrice.getAdjusted_price());
        priceEntity.setAverage_price(adjustedPrice.getAverage_price());
        
        ManagerDBCache.getInstance().updateTaxPriceEntity(priceEntity);
    }
    
    /**
     * Update All Price
     */
    private void updateAllPrice(){
        List < PriceEntity > priceEntitys = 
         ManagerDBCache.getInstance().getAllExceptSpecificPriceEntity(typeId);
        
        if (priceEntitys.isEmpty())
            return;
        
        for (PriceEntity priceEntity1 : priceEntitys) {
            this.typeId = priceEntity1.getType_id();
            this.priceEntity = priceEntity1;
            updatePrice(false);
        }
    }
    
    private void deleteAllPrice(){
        
    }
    
    /**
     * Get Adjusted Price
     * @param String typePrice
     * @param Map<String, Price > priceMap priceMap
     * @return String
     */
    public String getAdjustedPriceEntity(String typePrice, Map<String, Price > priceMap ) {
        return getValueAdjusted_AveragePrice(typePrice, priceMap).getAdjusted_price();
    }

    /**
     * Get Average Price
     * @param String typePrice
     * @param Map<String, Price > priceMap priceMap
     * @return String
     */
    public String getAveragePriceEntity(String typePrice, Map<String, Price > adjustedPriceMap ) {
        return getValueAdjusted_AveragePrice(typePrice, adjustedPriceMap).getAverage_price();
    }
    
    /**
     * Get Average Price or Adjusted Price
     * @param String typePrice
     * @param Map<String, Price > priceMap priceMap
     * @return PriceEntity
     */    
    private PriceEntity getValueAdjusted_AveragePrice(String typePrice, Map<String, Price > adjustedPriceMap){
        PriceEntity priceEntity = 
         ManagerDBCache.getInstance().getPriceEntity(typePrice);
        
        if ( priceEntity == null ){
            addPrice(adjustedPriceMap, typePrice);
            priceEntity = ManagerDBCache.getInstance().getPriceEntity(typePrice);
            
            try {
                throw new PriceNotExistsException();
            } catch (Exception e) {
                System.out.println(""+e.getMessage());
                return null;                
            }
        }
        return priceEntity;
    }
    
    /**
     * Set Price Map
     * @param AdjustedPriceEntity priceEntity 
     */
    private void setPriceEntity(PriceEntity priceEntity) {
        this.priceEntity = priceEntity;
    }

    /**
     * Get Price Map
     * @return Map<String, Price>
     */
    private Map<String, Price> getPriceMap() {
        return priceMap;
    }

    /**
     * Set Price Map
     * @param Map<String, Price> priceMap 
     */
    private void setPriceMap(Map<String, Price> priceMap) {
        this.priceMap = priceMap;
    }

    /**
     * Get TypeId
     * @return String
     */
    private String getTypeId() {
        return typeId;
    }

    /**
     * Set TypeId
     * @param typeId 
     */
    private void setTypeId(String typeId) {
        this.typeId = typeId;
    }

}
