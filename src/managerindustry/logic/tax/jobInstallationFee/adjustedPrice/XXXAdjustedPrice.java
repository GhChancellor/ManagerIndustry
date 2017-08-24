/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.jobInstallationFee.adjustedPrice;

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
import managerindustry.logic.tax.jobInstallationFee.systemCostIndex.SolarSystem;

/**
 * DBG Aggiungere collegamento alla rete
 * @author lele
 */
public class XXXAdjustedPrice {
    public Map<String, AdjustedPrice > getAdjustedPrice(){
        try {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter
             (AdjustedPrice.class, new AdjustedPriceDeserializer());
            
            Gson gson = gsonBuilder.create();
            
            // Lettura da file, 
            final String path = "./AdjustedPrice.json";
            Reader reader = new FileReader(path);
            
            Type type = new TypeToken< ArrayList <AdjustedPrice> >() {}.getType();
            List < AdjustedPrice > adjustedPrices = 
             (List < AdjustedPrice >) gson.fromJson(reader, type);
            
            Map<String, AdjustedPrice > adjustedPriceMap = 
             adjustedPrices.stream().collect(Collectors.toMap
              (AdjustedPrice::getAdjusted_price, AdjustedPrice -> AdjustedPrice ) );
            
//            adjustedPriceMap.putAll( adjustedPrices.stream().collect(Collectors.toMap
//             (AdjustedPrice::getAverage_price, AdjustedPrice -> AdjustedPrice)) );
//            
//            adjustedPriceMap.putAll( adjustedPrices.stream().collect(Collectors.toMap
//             (AdjustedPrice::getType_id, AdjustedPrice -> AdjustedPrice)));
            return adjustedPriceMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;            
        }
    }
}
