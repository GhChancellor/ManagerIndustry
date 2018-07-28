/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.db.item.cache.price;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import managerindustry.db.controllers.PriceEntityJpaController;
import managerindustry.db.entities.cache.PriceEntity;
import managerindustry.logic.apiEsi.market.listMarketPrices.Price;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.manager.Manager;

/**
 * @deprecated 
 * @author lele
 */
public class PriceX {
    private EntityManager entityManager;

    private PriceEntityJpaController priceEntityJpaController =
     new PriceEntityJpaController(Persistence.createEntityManagerFactory("ManagerIndustryPU"));
    
    private PriceEntity priceEntity = new PriceEntity();
    private Map<String, Price > priceMap = new HashMap<>();
    private String typeId = null;
//    private static PriceX instance = null;
//    
//    public static PriceX getInstance() throws PriceNotExistsException{
//        if ( instance == null )
//            instance = new PriceX();
//        return instance;        
//    }

    public PriceX(EntityManager entityManager) throws ErrorExeption {
        this.entityManager = entityManager;
        initPriceDB();
    }

    /**
     * Get Adjusted Price
     * @param String typePrice
     * @param Map<String, Price > priceMap priceMap
     * @return String
     */
    public String getAdjustedPriceEntity(String typePrice) throws ErrorExeption {
        return getValueAdjusted_AveragePrice(typePrice).getAdjusted_price();
    }

    /**
     * Get Average Price
     * @param String typePrice
     * @param Map<String, Price > priceMap priceMap
     * @return String
     */
    public String getAveragePriceEntity(String typePrice) throws ErrorExeption {
        return getValueAdjusted_AveragePrice(typePrice).getAverage_price();
    }
    
    /**
     * Init Price DB
     */
    private void initPriceDB(){
        if ( getAllPriceEntity() == null){
            addPriceEntity(priceEntity);
        }
    }    

    private Price getPriceMap() throws ErrorExeption{
        Price price = this.priceMap.get(this.typeId);
        
        if (price == null) {
            this.priceMap = 
                Manager.getInstance().apiEsi().market().getListMarketPrices().getListMarketPrices();
            price = this.priceMap.get(this.typeId);
            
            if (price == null) {
                throw new ErrorExeption(ErrorExeption.ErrorExeptionEnum.PRICE_NOT_EXISTS);
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
    private void addPrice() throws ErrorExeption{
        Date nowPresent = new Date();
        
        Price price = getPriceMap();     
        
        this.priceEntity = new PriceEntity();
        this.priceEntity.setTypeID(price.getType_id());
        this.priceEntity.setLastUsed(nowPresent);
        this.priceEntity.setAverage_price(price.getAverage_price());
        this.priceEntity.setAdjusted_price(price.getAdjusted_price());
        
        addPriceEntity(priceEntity);
    }
    
    /**
     * Init All
     * @param priceID
     * @throws String SolarSystemNotExistsException 
     */
    private void initAll(String priceID) throws ErrorExeption{
        priceEntity = getPriceEntity(typeId);

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
    private void updatePrice(boolean valueBool ) throws ErrorExeption{
        if (valueBool){
            Date nowPresent = new Date();
            priceEntity.setLastUsed(nowPresent);            
        }
        
        // Adjusted Price From Json ( eve server )
        Price price = getPriceMap();       
                
        priceEntity.setAdjusted_price(price.getAdjusted_price());
        priceEntity.setAverage_price(price.getAverage_price());
        
        updateTaxPriceEntity(priceEntity);
    }    
    
    /**
     * Update All Price
     * @throws PriceNotExistsException 
     */
    private void updateAllPrice() throws ErrorExeption{
        List < PriceEntity > priceEntitys = 
         getAllExceptSpecificPriceEntity(typeId);
        
        if (priceEntitys.isEmpty())
            return;
        
        for (PriceEntity priceEntity1 : priceEntitys) {
            this.typeId = priceEntity1.getTypeID();
            this.priceEntity = priceEntity1;
            updatePrice(false);
        }
    }

    private void deleteAllPrice(){
        
    }   
    
    // ---------------------------------------------------------------------
    
    /**
     * Get Average Price or Adjusted Price
     * @param String typePrice
     * @param Map<String, Price > priceMap priceMap
     * @return PriceEntity
     */    
    private PriceEntity getValueAdjusted_AveragePrice(String typePrice) throws ErrorExeption{
        
        initAll(typePrice);   
        priceEntity = getPriceEntity(typePrice);     

        if ( priceEntity == null)
            throw new ErrorExeption(ErrorExeption.ErrorExeptionEnum.PRICE_NOT_EXISTS);
        
        return priceEntity;
    }

    /**
    * Add Price Entity
    * @param priceEntity adjustedPriceEntity
    */
    private void addPriceEntity( PriceEntity priceEntity ){
        try {
            priceEntityJpaController.create(priceEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return;        
        }
    }
    
    /**
     * Get All Price Entity
     * @return PriceEntity
     */
    private List < PriceEntity > getAllPriceEntity(){
        try {
            TypedQuery < PriceEntity > allPriceEntityTQ =
             entityManager.createNamedQuery("PriceEntity.getAll", PriceEntity.class);
            
            return allPriceEntityTQ.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;            
        }
    }
    
    /**
     * Get Price Entity
     * @param typeId
     * @return PriceEntity
     */
    private PriceEntity getPriceEntity(String typeId){
        try {
            TypedQuery < PriceEntity > priceEntityTQ = 
             entityManager.createNamedQuery("PriceEntity.getTypeId", PriceEntity.class);
             
            priceEntityTQ.setParameter("typeID", typeId);
            
            List < PriceEntity > priceEntitys = 
             priceEntityTQ.getResultList();
            
            if (priceEntitys.isEmpty()){
                return null;
            }else{
                return priceEntitys.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;            
        }
    }
    
    /**
     * Get All Except Specific Price Entity
     * @param typeID
     * @return List < PriceEntity >
     */
    private List < PriceEntity > getAllExceptSpecificPriceEntity( String typeID){
        try {
            TypedQuery < PriceEntity > allExceptSpecificQT = 
             entityManager.createNamedQuery("PriceEntity.getAllExceptSpecificTypeID", PriceEntity.class);
            
            allExceptSpecificQT.setParameter("typeID", typeID);
            return allExceptSpecificQT.getResultList();             
        } catch (Exception e) {
            e.printStackTrace();
            return null;             
        }
    }
    
    /**
     * Update Tax Price Entity
     * @param AdjustedPriceEntity adjustedPriceEntity 
     */
    private void updateTaxPriceEntity(PriceEntity priceEntity){
        try {
           priceEntityJpaController.edit(priceEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }    
}
