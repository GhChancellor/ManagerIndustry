/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.jobInstallationFee.systemCostIndex;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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

            final String path = "./newfile.json";
            Reader reader = new FileReader(path);
            String jsonString = readFile(path);
//            jsonString = jsonString.replace("\n", "");
//            jsonString = jsonString.trim();
//            jsonString = jsonString.replace(": [", ":[");

            System.out.println("JSON\n");
            System.out.println(jsonString);
//            SolarSystem solarSystem = gson.fromJson(reader, SolarSystem.class);
//            System.out.println("Solar system ID:"+solarSystem.getSolarSystem());
//            JsonElement yourJson = mapping.get("servers");
//            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<SolarSystem>>() {}.getType();
            List<SolarSystem> solarSystems = (List<SolarSystem>) gson.fromJson(jsonString, type);

//            Universe universe = gson.fromJson(reader, Universe.class);
            for (SolarSystem solarSystem : solarSystems) {
                System.out.println("Solar system ID:" + solarSystem.getSolarSystem());
                CostIndex[] costIndexs = solarSystem.getCostIndexs();

                for (int i = 0; i < costIndexs.length; i++) {
                    CostIndex costIndex = costIndexs[i];
                    System.out.println("\t\t" + costIndex.getActivity() + " " + costIndex.getCostIndex());

                }
                System.out.println("---------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
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
