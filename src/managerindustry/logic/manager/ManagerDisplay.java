/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager;

import managerindustry.logic.manager.managerDB.ManagerDBEve;
import java.util.List;
import java.util.Map;
import managerindustry.db.entities.DgmAttributeTypes;
import managerindustry.db.entities.DgmTypeAttributes;
import managerindustry.db.entities.IndustryActivityMaterials;
import managerindustry.db.entities.InvNames;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.buiild.MaterialForComponents;
import managerindustry.logic.buiild.ComponentX;
import managerindustry.logic.buiild.MaterialEfficiencyCalculate;
import managerindustry.logic.buiild.ReportCalculatedComponentX;
import managerindustry.logic.unused.structure.UNUSED_EngineeringComplex;

/**
 *
 * @author lele
 */
public class ManagerDisplay {

    public void displayValueRig(){
//       ManagerStructureEngineeringRigs managerStructureEngineeringRigs = new ManagerStructureEngineeringRigs();
//       managerStructureEngineeringRigs.initStructureEngineeringRigs("Standup XL-Set Laboratory Optimization I");
 
    }    
    
     /**
     * Build Item
     * DBG potrebbe avere piccole imprecisioni con Dra 10 run, 10 job, 10 ME
     * @param bpoName
     * @param run
     * @param job
     * @param meBPO
     * @param meComponent 
     */
//    public void buildItem(String bpoName, int run, int job, int meBPO, int meComponent ){
//        // Errore nella produzione capital "Concord 25000mm Steel Plate"
//        // ci vuole la ricorsione per le T3
//        
//        System.out.println(bpoName + ": run " + run + ", Job " + job + ", meBPO " + meBPO + ", meComponent " + meComponent );
//
//        baseMaterial(bpoName);
//        
//        // get value base from DB
//        List < ComponentX > componentXs = ManagerComponentX.getInstance().getBaseComponentXs();
//        
//        for (ComponentX componentX : componentXs) {
//            // calculate materialEfficiencyCalculate
//            MaterialEfficiencyCalculate materialEfficiencyCalculate = new MaterialEfficiencyCalculate(run, job, meBPO , componentX.getQuanityInt() );
//            
//            // value of the single item
//            int firstStepSingleMaterial = materialEfficiencyCalculate.getSingleItemMaterial();
//            
//            // values of the total item
//            float firstStepTotalMaterials = materialEfficiencyCalculate.getTotalItemsMaterials();
//            
//            System.out.println(""+ componentX.getName() + ": " + firstStepSingleMaterial + " ---> " + String.format("%.0f", firstStepTotalMaterials)  );
//            
//            
//            // Put Total Calculated Components
//            ReportCalculatedComponentX totalCalculatedComponentX_X1 = 
//                new ReportCalculatedComponentX(componentX.getName(), firstStepTotalMaterials);
//            
//            // Put single Calculated Component
//            SingleCalculatedComponentX singleCalculatedComponentX1 = 
//                new SingleCalculatedComponentX(componentX.getName(), firstStepSingleMaterial);
//            
//            // add values of the items to map 
//            ManagerComponentX.getInstance().sumReportCalculatedComponentXMap(totalCalculatedComponentX_X1);
//            
//            // add value of the single item to map
//            ManagerComponentX.getInstance().addSingleCalculatedComponentXMap(singleCalculatedComponentX1);
//            
//            // get Value for compoenents T2
//            List < MaterialForComponents > materialForComponents =  componentX.getMaterialForComponents();
//            
//            for (MaterialForComponents materialForComponent : materialForComponents) {
//                // calculate materialEfficiencyCalculate
//                materialEfficiencyCalculate = new MaterialEfficiencyCalculate(job, firstStepSingleMaterial, materialForComponent.getQuanityInt(), meComponent);
//                
//                // value of the single item
//                int secondStepSingleMaterial = materialEfficiencyCalculate.getSingleItemMaterial();
//                
//                // values of the total item
//                float secondStepTotalMaterials = materialEfficiencyCalculate.getTotalItemsMaterials();
//                
//                // Put Total Calculated Components
//                totalCalculatedComponentX_X1 = new ReportCalculatedComponentX(materialForComponent.getName(), secondStepTotalMaterials );
//                
//                // Put single Calculated Component
//                singleCalculatedComponentX1 = new SingleCalculatedComponentX(materialForComponent.getName(), secondStepSingleMaterial);
//
//                // add values of the items to map 
//                ManagerComponentX.getInstance().sumReportCalculatedComponentXMap(totalCalculatedComponentX_X1);
//                
//                // add value of the single item to map
//                ManagerComponentX.getInstance().addSingleCalculatedComponentXMap(singleCalculatedComponentX1);
//                
////                System.out.println("\t\t"+ materialForComponent.getName() + " " + 
////                 materialForComponent.getQuanityInt() + " --> " + secondStepSingleMaterial + " --> " + secondStepTotalMaterials );
//
//                System.out.println("\t\t"+ materialForComponent.getName() + ": "
//                 + secondStepSingleMaterial + " --> " + String.format("%.0f", secondStepTotalMaterials )  );
//            }
//            
//        }
//    }

    /**
     * Get from DB all materail to build an object 
    */
    private void baseMaterial(String bpoName){     
        System.out.println(""+bpoName);
        
        // get item to build
        List < IndustryActivityMaterials > nameItemToBuild = ManagerDBEve.getInstance().getMaterialNeedByName(bpoName);
         
        if ( ! nameItemToBuild.isEmpty() ){
            for (IndustryActivityMaterials invTypeMaterialse :  nameItemToBuild) {
                InvTypes invTypes = ManagerDBEve.getInstance().getInvTypes_NameById(invTypeMaterialse.getMaterialTypeID());
                
                // get component
                List < IndustryActivityMaterials > neededComponents = ManagerDBEve.getInstance().getMaterialNeedByName( invTypes.getTypeName() + " blueprint");
                
                ComponentX componentX = new ComponentX();
                componentX.setName(invTypes.getTypeName());
                componentX.setQuanityInt(invTypeMaterialse.getQuantity());
                
                if ( neededComponents != null){                    
                    for (IndustryActivityMaterials neededComponent : neededComponents) { 
                        
                        invTypes = ManagerDBEve.getInstance().getInvTypes_NameById(neededComponent.getMaterialTypeID());
                        
                        MaterialForComponents materialForComponents = new MaterialForComponents
                         ( invTypes.getTypeID(), invTypes.getTypeName(), neededComponent.getQuantity());
                        componentX.addMaterialForComponents(materialForComponents);   
                    }
                }
                ManagerComponentX.getInstance().addComponentXs(componentX); 
            }             
        }         
    } 
    
    private void getTotalMaterial(String bpoName){
        Map < String, ReportCalculatedComponentX > calculatedComponentXMap = ManagerComponentX.getInstance().getReportCalculatedComponentXMap();
        System.out.println("Total material to build "+ bpoName);
        for (Map.Entry<String, ReportCalculatedComponentX> entry : calculatedComponentXMap.entrySet()) {
            String key = entry.getKey();
            ReportCalculatedComponentX value = entry.getValue();
            System.out.println(""+ key + " " + value.getQuanityInt());
        }    
        
//        for (String key : calculatedComponentXMap.keySet()) {
//            ReportCalculatedComponentX value = calculatedComponentXMap.get(key);
//            System.out.println(""+ key + " " + value.getQuanity());
//        }
    }
    
    public void itemDescription(){
        // 43867 Standup M-Set Advanced Component Manufacturing Material Efficiency I
        String bpoName = "drake Blueprint"; // Nighthawk Blueprint 
        InvTypes invTypes = ManagerDBEve.getInstance().getInvTypes_IdByName(bpoName);
        
        List < DgmTypeAttributes > dgmTypeAttributes = ManagerDBEve.getInstance().getDgmTypeAttributes(invTypes.getTypeID());
        
        System.out.println(""+ bpoName + " ID " + invTypes.getTypeID() );
        
        for (DgmTypeAttributes dgmTypeAttribute : dgmTypeAttributes) {
           
            DgmAttributeTypes dgmAttributeTypes = 
             ManagerDBEve.getInstance().getDgmAttributeTypes(dgmTypeAttribute.getDgmTypeAttributesPK().getAttributeID());
            
            if (dgmTypeAttribute.getValueInt() == null) {
                System.out.println(""+ dgmAttributeTypes.getDisplayName() + "\n" + dgmAttributeTypes.getDescription()  +
                " " + dgmTypeAttribute.getValueFloat() + "\n");
            }
            
            if (dgmTypeAttribute.getValueFloat() == null) {
                System.out.println(""+ dgmAttributeTypes.getDisplayName() + "\n" + dgmAttributeTypes.getDescription()  + " " + dgmTypeAttribute.getValueInt() + "\n");                
            }
            
            if (dgmAttributeTypes.getDisplayName() == null ){
                System.out.println(""+ dgmAttributeTypes.getDescription()  + " " + dgmTypeAttribute.getValueInt() + " " + dgmTypeAttribute.getValueFloat() + "\n");
            }
            
            if ( dgmAttributeTypes.getDescription() == null ){
                System.out.println(""+ dgmAttributeTypes.getDisplayName() + "\n" + dgmTypeAttribute.getValueInt() + " " + dgmTypeAttribute.getValueFloat() + "\n");                
            }
            
            System.out.println(""+ dgmAttributeTypes.getDisplayName() + "\n" + dgmAttributeTypes.getDescription()  + " " +
             + dgmAttributeTypes.getAttributeID() + " " + dgmTypeAttribute.getValueInt() + " " + dgmTypeAttribute.getValueFloat() + "\n");
        }        
    }

    public void engineeringComplex(){
        String bpoName = "AZBEL";
        UNUSED_EngineeringComplex engineeringComplex = new UNUSED_EngineeringComplex(bpoName);
    }
    
    public void getSolarSystemID(){
        InvNames invNames = ManagerDBEve.getInstance().getInvNames_SolarSystemID("Jita");
        
        System.out.println(""+invNames.getItemID());
    }
}



//    public void prova001(){
//        
//        String bpoName = "scimitar Blueprint";
//        System.out.println(""+bpoName);
//        
//        // get item to build
//        List < IndustryActivityMaterials > objectToBuild = ManagerDBEve.getInstance().getMaterialNeedByName(bpoName);
//        
//        if ( ! objectToBuild.isEmpty() ){
//            for (IndustryActivityMaterials invTypeMaterialse :  objectToBuild) {
//                InvTypes invTypes = ManagerDBEve.getInstance().getInvTypes_NameById(invTypeMaterialse.getMaterialTypeID());
//                
//                // get component
//                List < IndustryActivityMaterials > neededComponents = ManagerDBEve.getInstance().getMaterialNeedByName( invTypes.getTypeName() + " blueprint");
//                ComponentX componentX = new ComponentX();
//                componentX.setName(invTypes);
//                componentX.setQuanity(invTypeMaterialse.getQuantity());
//                
//                if ( neededComponents != null){                    
//                    for (IndustryActivityMaterials neededComponent : neededComponents) {                                            
//                        invTypes = ManagerDBEve.getInstance().getInvTypes_NameById(neededComponent.getMaterialTypeID());
//                        
//                        MaterialForComponents materialForComponents = new MaterialForComponents( invTypes, neededComponent);
//                        componentX.addMaterialForComponents(materialForComponents);   
//                    }
//                }
//                ManagerComponentX.getInstance().addComponentXs(componentX); 
//            }             
//        }
//        
//        int job = 1;
//        int run = 4;
//        int meBPO = 1;
//        int meComponet = 10;
//        System.out.println("job " + job + " run "+ run + " me "+ meBPO);
//        List < ComponentX > componentXs = ManagerComponentX.getInstance().getBaseComponentXs();
//        for (ComponentX componentX : componentXs) {
//            
//            int firstStep = new MaterialEfficiencyCalculate().calculateMaterialEfficiency(job, run, componentX.getQuanity(), meBPO);
//            System.out.println(""+componentX.getName() + " " + componentX.getQuanity() + " --> " + firstStep );
//            
//            List < MaterialForComponents > materialForComponents =  componentX.getMaterialForComponents();
//            for (MaterialForComponents materialForComponent : materialForComponents)  {
//                int secondStep = new MaterialEfficiencyCalculate().calculateMaterialEfficiency(job, firstStep, materialForComponent.getQuanity(), meComponet);
//                
//                System.out.println("\t\t"+ materialForComponent.getName() + " " + materialForComponent.getQuanity() + " --> " + secondStep);
//            }
//        }
//        
//    }