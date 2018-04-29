/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.old.managerCache;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import managerindustry.db.entities.cache.PriceEntity;
import managerindustry.logic.apiEsiJson.ApiEsi;
import managerindustry.logic.exception.PriceNotExistsException;
import managerindustry.logic.manager.old.managerDB.ManagerDBCache_OLD;
import managerindustry.logic.apiEsiJson.market.listMarketPrices.Price;
import managerindustry.logic.apiEsiJson.market.listMarketPrices.ListMarketPrices;

/**
 * @deprecated 
 * @author lele
 */
public class ManagerPrice_OLD {
    private PriceEntity priceEntity = new PriceEntity();
    private Map<String, Price > priceMap = new HashMap<>();
    private String typeId = null;
    private static ManagerPrice_OLD instance = null;
    
    public static ManagerPrice_OLD getInstance() throws PriceNotExistsException{
        if ( instance == null )
            instance = new ManagerPrice_OLD();
        return instance;        
    }

    private ManagerPrice_OLD() throws PriceNotExistsException {
        initPriceDB();
    }
    
    /**
     * Init Price DB
     */
    private void initPriceDB(){
        if ( ManagerDBCache_OLD.getInstance().getAllPriceEntity() == null){
            ManagerDBCache_OLD.getInstance().addPriceEntity(priceEntity);
        }
    }    

    private Price getPriceMap() throws PriceNotExistsException{
        Price price = this.priceMap.get(this.typeId);
        
        if (price == null) {
            this.priceMap = 
                ApiEsi.getInstance().marketJSon().getListMarketPrices().getListMarketPrices();
            price = this.priceMap.get(this.typeId);
            
            if (price == null) {
                throw new PriceNotExistsException();                
            }else{
                return price;
            }
        }else{
            return price;
        }
    }
    
    /**
     * Add Adjusted Price
     */
    private void addPrice() throws PriceNotExistsException{
        Date nowPresent = new Date();
        
        Price price = getPriceMap();     
        
        this.priceEntity = new PriceEntity();
        this.priceEntity.setType_id(price.getType_id());
        this.priceEntity.setLastUsed(nowPresent);
        this.priceEntity.setAverage_price(price.getAverage_price());
        this.priceEntity.setAdjusted_price(price.getAdjusted_price());
        
        ManagerDBCache_OLD.getInstance().addPriceEntity(priceEntity);
    }
    
    /**
     * Init All
     * @param priceID
     * @throws String SolarSystemNotExistsException 
     */
    private void initAll(String priceID) throws PriceNotExistsException{
        priceEntity = ManagerDBCache_OLD.getInstance().getPriceEntity(priceID);
        this.typeId = priceID;
        
        if (priceEntity == null){
            addPrice();
        }else{
            updatePrice(true);
        }
        updateAllPrice();
//        deleteAllPrice();        
    }

    /**
     * Update Price
     * @param boolean valueBool 
     */
    private void updatePrice(boolean valueBool ) throws PriceNotExistsException{
        if (valueBool){
            Date nowPresent = new Date();
            priceEntity.setLastUsed(nowPresent);            
        }
        
        // Adjusted Price From Json ( eve server )
        Price price = getPriceMap();       
                
        priceEntity.setAdjusted_price(price.getAdjusted_price());
        priceEntity.setAverage_price(price.getAverage_price());
        
        ManagerDBCache_OLD.getInstance().updateTaxPriceEntity(priceEntity);
    }    
    
    /**
     * Update All Price
     */
    private void updateAllPrice() throws PriceNotExistsException{
        List < PriceEntity > priceEntitys = 
         ManagerDBCache_OLD.getInstance().getAllExceptSpecificPriceEntity(typeId);
        
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
    public String getAdjustedPriceEntity(String typePrice ) throws PriceNotExistsException {
        return getValueAdjusted_AveragePrice(typePrice).getAdjusted_price();
    }

    /**
     * Get Average Price
     * @param String typePrice
     * @param Map<String, Price > priceMap priceMap
     * @return String
     */
    public String getAveragePriceEntity(String typePrice) throws PriceNotExistsException {
        return getValueAdjusted_AveragePrice(typePrice).getAverage_price();
    }
    
    /**
     * Get Average Price or Adjusted Price
     * @param String typePrice
     * @param Map<String, Price > priceMap priceMap
     * @return PriceEntity
     */    
    private PriceEntity getValueAdjusted_AveragePrice(String typePrice) throws PriceNotExistsException{
        
        initAll(typePrice);   
        priceEntity = ManagerDBCache_OLD.getInstance().getPriceEntity(typePrice);     

        if ( priceEntity == null)
            throw new PriceNotExistsException();        
        
        return priceEntity;
    }
    
//    /**
//     * Set Price Map
//     * @param AdjustedPriceEntity priceEntity 
//     */
//    private void setPriceEntity(PriceEntity priceEntity) {
//        this.priceEntity = priceEntity;
//    }
//
//    /**
//     * Get Price Map
//     * @return Map<String, Price>
//     */
//    private Map<String, Price> getPriceMap() {
//        return priceMap;
//    }
//
//    /**
//     * Set Price Map
//     * @param Map<String, Price> priceMap 
//     */
//    private void setPriceMap(Map<String, Price> priceMap) {
//        this.priceMap = priceMap;
//    }
//
//    /**
//     * Get TypeId
//     * @return String
//     */
//    private String getTypeId() {
//        return typeId;
//    }
//
//    /**
//     * Set TypeId
//     * @param typeId 
//     */
//    private void setTypeId(String typeId) {
//        this.typeId = typeId;
//    }

}
