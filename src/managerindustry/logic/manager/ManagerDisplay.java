/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager;

import managerindustry.logic.manager.ManagerDB.ManagerDBEve;
import java.util.List;
import java.util.Map;
import managerindustry.db.entities.DgmAttributeTypes;
import managerindustry.db.entities.DgmTypeAttributes;
import managerindustry.db.entities.IndustryActivityMaterials;
import managerindustry.db.entities.InvNames;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.buiild.MaterialForComponents;
import managerindustry.logic.buiild.ComponentX;
import managerindustry.logic.buiild.MaterialCalc;
import managerindustry.logic.buiild.TotalCalculatedComponentX;
import managerindustry.logic.structure.EngineeringComplex;
import managerindustry.logic.structure.StructureEngineeringRigs;

/**
 *
 * @author lele
 */
public class ManagerDisplay {

    public void displayValueRig(){
       ManagerStructureEngineeringRigs managerStructureEngineeringRigs = new ManagerStructureEngineeringRigs();
       managerStructureEngineeringRigs.initStructureEngineeringRigs("Standup XL-Set Laboratory Optimization I");
 
    }    
    
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
                componentX.setQuanity(invTypeMaterialse.getQuantity());
                
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
    
    
    /**
     * Inizio da qui
     */
    public void buildItem(){
        // Errore nella produzione capital "Concord 25000mm Steel Plate"
        
        // VALORE NULLO
        IndustryActivityMaterials industryActivityMaterials = new IndustryActivityMaterials();
        
        String bpoName = "scimitar Blueprint";
        InvTypes invTypes = new InvTypes();
        invTypes.setTypeName(bpoName);
        
        baseMaterial(bpoName);
        
        int job = 1;
        int run = 1;
        int meBPO = 0;
        int meComponet = 0;
        System.out.println("job " + job + " run "+ run + " me "+ meBPO);
        List < ComponentX > componentXs = ManagerComponentX.getInstance().getBaseComponentXs();
        for (ComponentX componentX : componentXs) {
                        
            int firstStep = MaterialCalc.calculateMaterialEfficiency(job, run, componentX.getQuanity(), meBPO);
            System.out.println(""+componentX.getName() + " " + componentX.getQuanity() + " --> " + firstStep );
            
            TotalCalculatedComponentX calculatedComponentX = new TotalCalculatedComponentX(componentX.getName(), firstStep);
            
            ManagerComponentX.getInstance().addTotalcalculatedComponentX(calculatedComponentX);
            
            List < MaterialForComponents > materialForComponents =  componentX.getMaterialForComponents();
            
            for (MaterialForComponents materialForComponent : materialForComponents)  {
                
                int secondStep = MaterialCalc.calculateMaterialEfficiency(job, firstStep, materialForComponent.getQuanity(), meComponet);
                calculatedComponentX = new TotalCalculatedComponentX(materialForComponent.getName(), secondStep);
                ManagerComponentX.getInstance().addTotalcalculatedComponentX(calculatedComponentX);
                
                
                System.out.println("\t\t"+ materialForComponent.getName() + " " + materialForComponent.getQuanity() + " --> " + secondStep);
            }
        }
        
        getTotalMaterial(bpoName);
    }
    
    private void getTotalMaterial(String bpoName){
        Map < String, TotalCalculatedComponentX > calculatedComponentXMap = ManagerComponentX.getInstance().getTotalcalculatedComponentXMap();
        System.out.println("Total material to build "+ bpoName);
        for (Map.Entry<String, TotalCalculatedComponentX> entry : calculatedComponentXMap.entrySet()) {
            String key = entry.getKey();
            TotalCalculatedComponentX value = entry.getValue();
            System.out.println(""+ key + " " + value.getQuanity());
        }    
        
//        for (String key : calculatedComponentXMap.keySet()) {
//            TotalCalculatedComponentX value = calculatedComponentXMap.get(key);
//            System.out.println(""+ key + " " + value.getQuanity());
//        }
    }
    
    public void itemDescription(){
        // 43867 Standup M-Set Advanced Component Manufacturing Material Efficiency I
        String bpoName = "raitaru";
        InvTypes invTypes = ManagerDBEve.getInstance().getInvTypes_IdByName(bpoName);
        
        List < DgmTypeAttributes > dgmTypeAttributes = ManagerDBEve.getInstance().getDgmTypeAttributes(invTypes.getTypeID());
        
        System.out.println(""+ bpoName);
        for (DgmTypeAttributes dgmTypeAttribute : dgmTypeAttributes) {
           
            DgmAttributeTypes dgmAttributeTypes = 
             ManagerDBEve.getInstance().getDgmAttributeTypes(dgmTypeAttribute.getDgmTypeAttributesPK().getAttributeID());
            
//            if (dgmTypeAttribute.getValueInt() == null) {
//                System.out.println(""+ dgmAttributeTypes.getDisplayName() + "\n" + dgmAttributeTypes.getDescription()  +
//                " " + dgmTypeAttribute.getValueFloat() + "\n");
//            }
//            
//            if (dgmTypeAttribute.getValueFloat() == null) {
//                System.out.println(""+ dgmAttributeTypes.getDisplayName() + "\n" + dgmAttributeTypes.getDescription()  + " " + dgmTypeAttribute.getValueInt() + "\n");                
//            }
//            
//            if (dgmAttributeTypes.getDisplayName() == null ){
//                System.out.println(""+ dgmAttributeTypes.getDescription()  + " " + dgmTypeAttribute.getValueInt() + " " + dgmTypeAttribute.getValueFloat() + "\n");
//            }
//            
//            if ( dgmAttributeTypes.getDescription() == null ){
//                System.out.println(""+ dgmAttributeTypes.getDisplayName() + "\n" + dgmTypeAttribute.getValueInt() + " " + dgmTypeAttribute.getValueFloat() + "\n");                
//            }
            
            System.out.println(""+ dgmAttributeTypes.getDisplayName() + "\n" + dgmAttributeTypes.getDescription()  + " " +
             + dgmAttributeTypes.getAttributeID() + " " + dgmTypeAttribute.getValueInt() + " " + dgmTypeAttribute.getValueFloat() + "\n");
        }        
    }

    public void engineeringComplex(){
        String bpoName = "AZBEL";
        EngineeringComplex engineeringComplex = new EngineeringComplex(bpoName);
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
//            int firstStep = new MaterialCalc().calculateMaterialEfficiency(job, run, componentX.getQuanity(), meBPO);
//            System.out.println(""+componentX.getName() + " " + componentX.getQuanity() + " --> " + firstStep );
//            
//            List < MaterialForComponents > materialForComponents =  componentX.getMaterialForComponents();
//            for (MaterialForComponents materialForComponent : materialForComponents)  {
//                int secondStep = new MaterialCalc().calculateMaterialEfficiency(job, firstStep, materialForComponent.getQuanity(), meComponet);
//                
//                System.out.println("\t\t"+ materialForComponent.getName() + " " + materialForComponent.getQuanity() + " --> " + secondStep);
//            }
//        }
//        
//    }