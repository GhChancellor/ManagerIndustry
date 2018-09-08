/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.market.price.marketParameter;

import managerindustry.logic.prove.market.price.marketParameter.createQuery.MarketStatQuery;
import managerindustry.logic.prove.market.price.marketParameter.createQuery.parameters.TypeID;
import managerindustry.logic.prove.market.price.marketParameter.createQuery.parameters.UseSystem;


/**
 *
 * @author lele
 */
public class MainUrlPrice {
    public static void main(String[] args) {
        TypeID typeID = new TypeID(34);
        UseSystem useSystem = new UseSystem(30000142);
        MarketStatQuery marketStatQuery = new MarketStatQuery();
        marketStatQuery.addTypeIDs(typeID);
        marketStatQuery.setUseSystem(useSystem);
//        marketStatQuery.display();
        
        String xmlUrl = marketStatQuery.getUrl();
        System.out.println("");
        
//        XmlUrl xmlUrl01 = new XmlUrl();
//        xmlUrl01.xmlProva(xmlUrl);
    }
}
