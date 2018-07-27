/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.market.price.marketParameter.createQuery;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.prove.market.price.marketParameter.createQuery.CreateQuery;
import managerindustry.logic.prove.market.price.marketParameter.createQuery.parameters.Hour;
import managerindustry.logic.prove.market.price.marketParameter.createQuery.parameters.MinQuantity;
import managerindustry.logic.prove.market.price.marketParameter.createQuery.parameters.QueryStart;
import managerindustry.logic.prove.market.price.marketParameter.createQuery.parameters.RegionLimit;
import managerindustry.logic.prove.market.price.marketParameter.createQuery.parameters.TypeID;
import managerindustry.logic.prove.market.price.marketParameter.createQuery.parameters.UseSystem;

/**
 *
 * @author lele
 */
public class MarketStatQuery {
    private final QueryStart queryStart = new QueryStart("http://api.eve-central.com/api/marketstat?");
//    private CreateQuery createQuery;
    
    private MinQuantity minQuantity; 
    private UseSystem useSystem;
    private List<Hour> hours = new ArrayList<>();
    private List<RegionLimit> regionLimits = new ArrayList<>();
    private List<TypeID> typeIDs = new ArrayList<>();
    
    public MarketStatQuery() {

    }
    
    public void display(){
        String result = queryStart.getQueryStart();
        
        for (TypeID typeID : typeIDs) {
            result += getQuery(typeID);
        }
        System.out.println(""+result);
    }

    public String getQuery(CreateQuery createQuery){
        if (createQuery != null){
            String result="";
            return result += createQuery.getUrl() + "=" + createQuery.getUrlValue()+"&";            
        }
        return "";
    }    
    
    public String getUrl(){
        String result = queryStart.getQueryStart();
        
        result += getQueries(typeIDs);
        result += getQueries(regionLimits);
        result += getQueries(hours);
        result += getQuery(useSystem);
        result += getQuery(minQuantity);
                
        System.out.println(""+result.substring(0, result.length()-1));
        return result;
    }
    
    public String getQueries(List < ? extends  CreateQuery > createQuerys){

        if (!createQuerys.isEmpty()){
            String result="";
            
            for (CreateQuery createQuery : createQuerys) {
                result += createQuery.getUrl() + "=" + createQuery.getUrlValue()+"&";
            }
            
            return result;
        }
        return "";
    }
    
    

//    String minQQ = minQ == null ? "" :  minQ.getParameterToAsk() +"="+minQ.getValueToAsk()+"&";
    /**
     * Get minimun quantity
     * @return MinQuantity
     */
    public MinQuantity getMinQuantity() {
        return minQuantity;
    }

//    public void setMinQuantity(MinQuantity minQuantity) {
//        this.minQuantity = minQuantity;
//    }

    /**
     * Get use Solar System
     * @return UseSystem
     */
    public UseSystem getUseSystem() {
        return useSystem;
    }

    /**
     * Set use Solar System
     * @param useSystem 
     */
    public void setUseSystem(UseSystem useSystem) {
        this.useSystem = useSystem;
    }

    /**
     * Get hours
     * @return List<Hour>
     */
    public List<Hour> getHours() {
        return hours;
    }

    /**
     * Unused
     * @param hours 
     */
    public void setHours(List<Hour> hours) {
        this.hours = hours;
    }

    /**
     * Add Hours
     * @param hour 
     */
    public void addHours( Hour hour) {
        this.hours.add(hour);
    }

    /**
     * Get limit region
     * @return List<RegionLimit>
     */
    public List<RegionLimit> getRegionLimits() {
        return regionLimits;
    }

    /**
     * Unused
     * @param regionLimits 
     */
    public void setRegionLimits(List<RegionLimit> regionLimits) {
        this.regionLimits = regionLimits;
    }

    /**
     * Set limit region
     * @param regionLimit 
     */
    public void addRegionLimits(RegionLimit regionLimit) {
        this.regionLimits.add(regionLimit);
    }

    /**
     * Get Type ID
     * @return List<TypeID>
     */
    public List<TypeID> getTypeIDs() {
        return typeIDs;
    }

    /**
     * Unused
     * @param typeIDs 
     */
    public void setTypeIDs(List<TypeID> typeIDs) {
        this.typeIDs = typeIDs;
    }
    
    /**
     * Add Type ID
     * @param typeID 
     */
    public void addTypeIDs( TypeID typeID) {
        this.typeIDs.add(typeID);
    }
    
}
