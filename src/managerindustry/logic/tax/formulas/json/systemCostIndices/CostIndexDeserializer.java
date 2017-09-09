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

/**
 *
 * @author lele
 */
public class CostIndexDeserializer implements JsonDeserializer<CostIndex>{

    /**
     * Deserialize CostIndex, get value activity and cost_index from json
     * @param je
     * @param type
     * @param jdc
     * @return
     * @throws JsonParseException 
     */
    @Override
    public CostIndex deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        try {
            JsonObject jsonObject = je.getAsJsonObject();

            String activityTemp = jsonObject.get("activity").getAsString();
            String costIndexTemp = jsonObject.get("cost_index").getAsString();

            CostIndex costIndex = new CostIndex(activityTemp, costIndexTemp);
            return costIndex;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        

    }
    
}
