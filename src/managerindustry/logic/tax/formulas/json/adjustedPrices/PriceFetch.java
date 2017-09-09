/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.formulas.json.adjustedPrices;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import managerindustry.logic.tax.formulas.json.systemCostIndices.SolarSystemCost;

/**
 * DBG Aggiungere collegamento alla rete
 * // adjustedPrice = https://esi.tech.ccp.is/latest/markets/prices/?datasource=tranquility
 * @author lele
 */
public class PriceFetch {
    /**
     * Get Json from Server
     * DBG Aggiungere collegamento alla rete
     * @return Map<String, Price >
     */
    public static Map<String, Price > getPrice(){
        try {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter
             (Price.class, new PriceDeserializer());
            
            Gson gson = gsonBuilder.create();
            
            // Lettura da file, 
            final String path = "./AdjustedPrice.json";
            Reader reader = new FileReader(path);
            
            Type type = new TypeToken< ArrayList <Price> >() {}.getType();
            List < Price > adjustedPrices = 
             (List < Price >) gson.fromJson(reader, type);
            
            Map<String, Price > adjustedPriceMap = 
             adjustedPrices.stream().collect(Collectors.toMap
              (Price::getType_id, Price -> Price ) );
            
//            adjustedPriceMap.putAll( adjustedPrices.stream().collect(Collectors.toMap
//             (Price::getAverage_price, Price -> Price)) );
//            
//            adjustedPriceMap.putAll( adjustedPrices.stream().collect(Collectors.toMap
//             (Price::getType_id, Price -> Price)));
            return adjustedPriceMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;            
        }
    }
}
