/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.formulas.json.systemCostIndices;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lele
 */
public class SolarSystemDeserializer implements JsonDeserializer<SolarSystemCost>{

    /**
     * Deserialize SolarSystemCost, get value solar_system_id and cost_indices[] from json
     * @param je
     * @param type
     * @param jdc
     * @return
     * @throws JsonParseException 
     */
    @Override
    public SolarSystemCost deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        try {
            JsonObject jsonObject = je.getAsJsonObject();
            String solarSystemTemp = jsonObject.get("solar_system_id").getAsString();

            CostIndex[] costIndexs = 
             jdc.deserialize(jsonObject.get("cost_indices"), CostIndex[].class);

            SolarSystemCost solarSystem = new SolarSystemCost();
            solarSystem.setSolarSystem(solarSystemTemp);
            solarSystem.setCostIndexs(costIndexs);                       
            return solarSystem;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
    
    

}
