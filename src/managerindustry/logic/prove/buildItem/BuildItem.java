/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import managerindustry.db.entities.IndustryActivityMaterials;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.buiild.CalculatedComponentX;
import managerindustry.logic.buiild.ComponentX;
import managerindustry.logic.buiild.MaterialEfficiencyCalculate;
import managerindustry.logic.buiild.MaterialForComponents;
import managerindustry.logic.buiild.ReportCalculatedComponentX;
import managerindustry.logic.enumName.RamActivitiesEnum;
import managerindustry.logic.manager.ManagerComponentX;
import managerindustry.logic.manager.managerDB.ManagerDB;

/**
 *
 * @author lele
 */
public class BuildItem {
    List < ComponentX > reportMaterialForComponents = new ArrayList<>();

    public BuildItem(String bpoName, int run, int job, int bpoME, 
        int componentMe) {
        RamActivitiesEnum activitiesEnum = RamActivitiesEnum.MANUFACTURING;
        
        // CONCORD 25000mm Steel Plates

        bpoName += " blueprint";
        System.out.println("" + bpoName);
        
        List< IndustryActivityMaterials> nameItemToBuild = 
         ManagerDB.getInstance().industryActivityMaterials().getMaterialNeedByName(bpoName, activitiesEnum);
        
        ComponentX componentX = new ComponentX();
        baseMaterial(nameItemToBuild, componentX, activitiesEnum );
        
        List < MaterialForComponents > materials = componentX.getMaterialForComponents();
        
        componentX = new ComponentX();
        buildItem(bpoName, run, job, bpoME, componentMe, materials, componentX);
        
        List < MaterialForComponents > forComponentses = componentX.getMaterialForComponents();
        reportMaterialForComponents.add(componentX);
        
//        componentX = new ComponentX();
        
//        for (MaterialForComponents forComponentse : forComponentses) {
//            displayMap(forComponentse.getComponentX(), "");
//        }
//        
//        Map < String, ReportCalculatedComponentX> totalCalculatedComponentXmap = 
//            ManagerComponentX.getInstance().getReportCalculatedComponentXMap();
//        xxx1(totalCalculatedComponentXmap);
        
//        System.out.println("\nTotal Material");
//        for (Map.Entry<String, ReportCalculatedComponentX> entry : totalCalculatedComponentXmap.entrySet()) {
//            String key = entry.getKey();
//            ReportCalculatedComponentX value = entry.getValue();
//            System.out.println("" + value.getName() + " " + String.format("%.0f", value.getQuanityDbl()));
//        }
    }
    
    public void xxx2(){
        for (ComponentX reportMaterialForComponent : reportMaterialForComponents) {
            displayMap(reportMaterialForComponent, "");
        }
    }
    
    private void displayTotalMaterial(Map < String, ReportCalculatedComponentX> totalCalculatedComponentXmap ){
        System.out.println("\nTotal Material");
        for (Map.Entry<String, ReportCalculatedComponentX> entry : totalCalculatedComponentXmap.entrySet()) {
            String key = entry.getKey();
            ReportCalculatedComponentX value = entry.getValue();
            System.out.println("" + value.getName() + " "  +  value.getQuanityInt() + " " + String.format("%.0f", value.getQuanityDbl()));
        }
    }
    
    private void buildItem(String bpoName, int run, int job, int bpoME, 
            int componentMe, List < MaterialForComponents > materials, 
            ComponentX dad){   
               
        for (MaterialForComponents material : materials) {  
            MaterialEfficiencyCalculate materialEfficiencyCalculate;
            
            // check if item is t1 or t2
            if (material.getComponentX().getMaterialForComponents().isEmpty()){
                // me for T1
                MaterialEfficiencyCalculate materialEfficiencyCalculateX = 
                 new MaterialEfficiencyCalculate(run, job, bpoME , material.getComponentX().getQuanityInt() );
                
                materialEfficiencyCalculate = materialEfficiencyCalculateX;
                
            }else{
                // me for component ( t2 )
                MaterialEfficiencyCalculate materialEfficiencyCalculateX = 
                    new MaterialEfficiencyCalculate(run, job, componentMe , material.getComponentX().getQuanityInt() ); 
                
                materialEfficiencyCalculate = materialEfficiencyCalculateX;
            }            
      
            // quantity material per single item 1 run
            int singleMaterial = 
                    materialEfficiencyCalculate.getSingleItemMaterial();
           
            // quantity material per all items 1 run
            double totalMaterials = 
                    materialEfficiencyCalculate.getTotalItemsMaterials(); 
            
            ComponentX componentX = new ComponentX();
            componentX.setName(material.getComponentX().getName());
            componentX.setQuanityInt(singleMaterial);
            componentX.setQuanityDbl(totalMaterials);
            
            // Single item scimitar x 1
            CalculatedComponentX calculatedComponentX = new CalculatedComponentX
                (material.getName(), singleMaterial, totalMaterials);            
            
            // add object values
            ManagerComponentX.getInstance().addCalculatedComponentXs(calculatedComponentX);

            // Put report Calculated Components
            ReportCalculatedComponentX reportCalculatedComponentX = 
             new ReportCalculatedComponentX(material.getComponentX().getName(), singleMaterial, totalMaterials);
            
            // Sum all values of the items to map Scimitar x 2
            ManagerComponentX.getInstance().sumReportCalculatedComponentXMap
                (reportCalculatedComponentX);
            
            // get Value for compoenents T2
            List < MaterialForComponents > materialForComponents = 
             material.getComponentX().getMaterialForComponents();
            
            dad.addMaterialForComponents( new MaterialForComponents(componentX));
                     
            if ( materialForComponents != null){
                buildItem("", singleMaterial, 1, bpoME, 
                 1, materialForComponents, componentX );
            }            
        }
        
//        for (MaterialForComponents material : materials) {   
//            if (material.getComponentX().getMaterialForComponents().isEmpty()){
//                System.out.println("t1 "+ material.getComponentX().getName());
//            }else{
//                System.out.println("t2 "+ material.getComponentX().getName() );
//            }
//        }
    
    }
    
     /**
     * Build Item, I varoli sono calcolati per ottenere la quantità di una singolo oggetto e 
     * DOPO sono moltiplicati per gli oggetti necesserati
     * Scimitar x 1 ME 10 
     * * Plasma Thruster 68 
     * * * Phenolic Composites 184 
     * @param bpoName
     * @param run
     * @param job
     * @param bpoME
     * @param componentMe
     * @param materials
     * @param dad 
     */
    private void buildItemORI(String bpoName, int run, int job, int bpoME, 
            int componentMe, List < MaterialForComponents > materials, 
            ComponentX dad){    
               
        for (MaterialForComponents material : materials) {            
            // calculate materialEfficiencyCalculate
            MaterialEfficiencyCalculate materialEfficiencyCalculate = 
             new MaterialEfficiencyCalculate
             (run, job, bpoME , material.getComponentX().getQuanityInt() );
                  
            // quantity material per single item 1 run
            int singleMaterial = 
                    materialEfficiencyCalculate.getSingleItemMaterial();
           
            // quantity material per all items 1 run
            double totalMaterials = 
                    materialEfficiencyCalculate.getTotalItemsMaterials(); 
            
            ComponentX componentX = new ComponentX();
            componentX.setName(material.getComponentX().getName());
            componentX.setQuanityInt(singleMaterial);
            componentX.setQuanityDbl(totalMaterials);
            
            // Single item scimitar x 1
            CalculatedComponentX calculatedComponentX = new CalculatedComponentX
                (material.getName(), singleMaterial, totalMaterials);            
            
            // add object values
            ManagerComponentX.getInstance().addCalculatedComponentXs(calculatedComponentX);

            // Put report Calculated Components
            ReportCalculatedComponentX reportCalculatedComponentX = 
             new ReportCalculatedComponentX(material.getComponentX().getName(), singleMaterial, totalMaterials);
            
            // Sum all values of the items to map Scimitar x 2
            ManagerComponentX.getInstance().sumReportCalculatedComponentXMap
                (reportCalculatedComponentX);
            
            // get Value for compoenents T2
            List < MaterialForComponents > materialForComponents = 
             material.getComponentX().getMaterialForComponents();
            
            dad.addMaterialForComponents( new MaterialForComponents(componentX));
                     
            if ( materialForComponents != null){
                buildItem("", singleMaterial, 1, bpoME, 1, materialForComponents, componentX );
            }            
        }
    }        
    
    private void baseMaterial(List< IndustryActivityMaterials> nameItemToBuild,
     ComponentX dad, RamActivitiesEnum activitiesEnum){   
        for (IndustryActivityMaterials nameItemToBuild1 : nameItemToBuild) {
            InvTypes invTypes =
              ManagerDB.getInstance().invTypes().getNameById(nameItemToBuild1.getMaterialTypeID());
//            System.out.println(tab + invTypes.getTypeID() + " " + invTypes.getTypeName() + " " + nameItemToBuild1.getQuantity());

            ComponentX componentX = new ComponentX();
            componentX.setName(invTypes.getTypeName());
            componentX.setQuanityInt(nameItemToBuild1.getQuantity());

            List< IndustryActivityMaterials> neededComponents = 
              ManagerDB.getInstance().industryActivityMaterials().getMaterialNeedByName(invTypes.getTypeName() + " blueprint", activitiesEnum);
            
            dad.addMaterialForComponents(new MaterialForComponents(componentX));  
            
            if (neededComponents != null)
                baseMaterial(neededComponents, componentX, activitiesEnum);

        }
    }
    
    public void displayMap(ComponentX dad, String tab){
        
        System.out.println(tab + dad.getName() + " " + dad.getQuanityInt() + " -> " + String.format("%.0f", dad.getQuanityDbl()) );
        tab += "\t";
        
        for (MaterialForComponents componentse : dad.getMaterialForComponents()) {
            displayMap(componentse.getComponentX(), tab);
        }

    } 

}
