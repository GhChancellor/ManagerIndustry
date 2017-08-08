/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.jobInstallationFee.systemCostIndex;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author lele
 */
public class JsonProva {
    public static void main(String[] args) throws IOException {
        try {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(SolarSystem.class, new SolarSystemDeserializer());
            gsonBuilder.registerTypeAdapter(CostIndex.class, new CostIndexDeserializer());
            Gson gson = gsonBuilder.create();

            final String path = "/home/lele/NetBeansProjects/ManagerIndustry/src/managerindustry/logic/tax/jobInstallationFee/systemCostIndex/newfile.json";
            Reader reader = new FileReader(path);
          
            final SolarSystem solarSystem = gson.fromJson(reader, SolarSystem.class);
            System.out.println(""+solarSystem.getSolarSystem());

            CostIndex[] costIndexs = solarSystem.getCostIndexs();
            
            for (int i = 0; i < costIndexs.length; i++) {
                CostIndex costIndex = costIndexs[i];
                System.out.println(""+ costIndex.getActivity() + " " + costIndex.getCostIndex());
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}

/*
{"solar_system_id": 30020141, 
 "cost_indices": [
    {"activity": "manufacturing", "cost_index": 0.02119926972605299}, 
    {"activity": "researching_time_efficiency", "cost_index": 0.011825645388723856}, 
    {"activity": "researching_material_efficiency", "cost_index": 0.02307659535595766}, 
    {"activity": "copying", "cost_index": 0.006783916556839193}]}
*/