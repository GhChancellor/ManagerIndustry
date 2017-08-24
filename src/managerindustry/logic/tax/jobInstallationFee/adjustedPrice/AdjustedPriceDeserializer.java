/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.jobInstallationFee.adjustedPrice;

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
public class AdjustedPriceDeserializer implements JsonDeserializer<AdjustedPrice>{
    @Override
    public AdjustedPrice deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        try {
            JsonObject jsonObject = je.getAsJsonObject();
            
            String adjusted_price = jsonObject.get("adjusted_price").getAsString();
            String average_price = jsonObject.get("average_price").getAsString();
            String type_id = jsonObject.get("type_id").getAsString();
            
            AdjustedPrice adjustedPrice = new AdjustedPrice(adjusted_price, average_price, type_id);
            return adjustedPrice;
        } catch (Exception e) {
            e.printStackTrace();
            return null;        
        }
    }    
}
