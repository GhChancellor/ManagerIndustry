/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.jobInstallationFee.systemCostIndex;

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

    @Override
    public CostIndex deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        try {
            JsonObject jsonObject = je.getAsJsonObject();

            final String activityTemp = jsonObject.get("activity").getAsString();
            final String costIndexTemp = jsonObject.get("cost_index").getAsString();

            CostIndex costIndex = new CostIndex();
            costIndex.setActivity(activityTemp);
            costIndex.setCostIndex(costIndexTemp);
            return costIndex;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        

    }
    
}
