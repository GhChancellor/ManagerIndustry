/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.formulas.itemcost.json.systemCostIndices;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * DBG da collegare alla rete
 * https://esi.tech.ccp.is/legacy/industry/systems/?datasource=tranquility
 * @author lele
 */
public class SystemCostFetch {

    public SystemCostFetch() {
    
    }
    
    /**
     * Get value Solar System and CostIndexs value from Json
     * DBG Aggiungere collegamento alla rete
     * @return Map<String, SolarSystemCost >
     */
    public static Map<String, SolarSystemCost > getSystemCostIndexs() {
       return getSystemCostIndexsDBG();
       
//        try {
//            GsonBuilder gsonBuilder = new GsonBuilder();
//            gsonBuilder.registerTypeAdapter(SolarSystemCost.class, new SolarSystemDeserializer());
//            gsonBuilder.registerTypeAdapter(CostIndex.class, new CostIndexDeserializer());
//            Gson gson = gsonBuilder.create();
//
//            // Lettura da file, 
//            final String path = "./SystemCostIndex.json";
//            Reader reader = new FileReader(path);
//
////            URL reader = new URL("https://esi.tech.ccp.is/legacy/industry/systems/?datasource=tranquility");
//
//            Type type = new TypeToken< ArrayList< SolarSystemCost > >() {}.getType();
//            List<SolarSystemCost> solarSystems = (List<SolarSystemCost>) gson.fromJson(reader, type);
//
//            
//            Map<String, SolarSystemCost > solarSystemMap = 
//             solarSystems.stream().collect(Collectors.toMap(SolarSystemCost::getSolarSystem, SolarSystem -> SolarSystem));
//            
//            return solarSystemMap;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }

    }
    
    private static Map<String, SolarSystemCost > getSystemCostIndexsDBG() {
        try {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(SolarSystemCost.class, new SolarSystemDeserializer());
            gsonBuilder.registerTypeAdapter(CostIndex.class, new CostIndexDeserializer());
            Gson gson = gsonBuilder.create();

            // Lettura da file, 
            final String path = "./SystemCostIndex.json";
            Reader reader = new FileReader(path);

//            URL reader = new URL("https://esi.tech.ccp.is/legacy/industry/systems/?datasource=tranquility");

            Type type = new TypeToken< ArrayList< SolarSystemCost > >() {}.getType();
            List<SolarSystemCost> solarSystems = (List<SolarSystemCost>) gson.fromJson(reader, type);

            
            Map<String, SolarSystemCost > solarSystemMap = 
             solarSystems.stream().collect(Collectors.toMap(SolarSystemCost::getSolarSystem, SolarSystem -> SolarSystem));
            
            return solarSystemMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
