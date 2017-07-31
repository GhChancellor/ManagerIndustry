/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.price.marketParameter;

import managerindustry.logic.price.marketParameter.createQuery.MarketStatQuery;
import managerindustry.logic.price.marketParameter.createQuery.CreateQuery;
import managerindustry.logic.price.marketParameter.createQuery.parameters.RegionLimit;
import managerindustry.logic.price.marketParameter.createQuery.parameters.TypeID;

/**
 *
 * @author lele
 */
public class MainUrlPrice {
    public static void main(String[] args) {
        TypeID typeID = new TypeID(34);
        RegionLimit regionLimit = new RegionLimit(1024);
        TypeID typeID02 = new TypeID(35);
        TypeID typeID03 = new TypeID(36);
        TypeID typeID04 = new TypeID(37);
        
        MarketStatQuery marketStatQuery = new MarketStatQuery();
        marketStatQuery.addTypeIDs(typeID);
        marketStatQuery.addTypeIDs(typeID02);
        marketStatQuery.addTypeIDs(typeID03);
        marketStatQuery.addTypeIDs(typeID04);
        marketStatQuery.addRegionLimits(regionLimit);
//        marketStatQuery.display();
        
        marketStatQuery.display02();
    }
}
