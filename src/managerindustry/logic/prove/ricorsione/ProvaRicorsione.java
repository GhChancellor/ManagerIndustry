/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.ricorsione;

import java.util.ArrayList;
import java.util.List;
import managerindustry.db.entities.IndustryActivityMaterials;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.buiild.ComponentX;
import managerindustry.logic.buiild.MaterialForComponents;
import managerindustry.logic.manager.ManagerComponentX;
import managerindustry.logic.manager.managerDB.ManagerDBEve;

/**
 *
 * @author lele
 */
public class ProvaRicorsione {
    private List < ComponentX > componentXs = new ArrayList<>();
    
    public void baseMaterial02(){
        ComponentX ladarSensorCluster = new ComponentX(0, "ladarSensorCluster", 0);
         ComponentX compositeArmorPlate = new ComponentX(0, "compositeArmorPlate", 0);
         ComponentX ferniteCarbide = new ComponentX(0, "ferniteCarbide", 0);
         ComponentX sylramicFibers = new ComponentX(0, "sylramicFibers", 0);
        
        ComponentX nanoMechanicalMicroProcessor = new ComponentX(0, "nanoMechanicalMicroProcessor", 0);
         ComponentX phenolicComposites = new ComponentX(0, "phenolicComposites", 0);
         ComponentX plasmonicMetamaterials = new ComponentX(0, "plasmonicMetamaterials", 0);
         ComponentX nanotransistors = new ComponentX(0, "nanotransistors", 0);
          ComponentX CPU = new ComponentX(0, "CPU", 0);
           ComponentX viti = new ComponentX(0, "viti", 0);

           
        ladarSensorCluster.addMaterialForComponents( new MaterialForComponents(compositeArmorPlate));
        ladarSensorCluster.addMaterialForComponents( new MaterialForComponents(ferniteCarbide));
        ladarSensorCluster.addMaterialForComponents( new MaterialForComponents(sylramicFibers));
        
        nanoMechanicalMicroProcessor.addMaterialForComponents( new MaterialForComponents(phenolicComposites));
        nanoMechanicalMicroProcessor.addMaterialForComponents( new MaterialForComponents(plasmonicMetamaterials));
        nanoMechanicalMicroProcessor.addMaterialForComponents( new MaterialForComponents(nanotransistors));
         nanotransistors.addMaterialForComponents( new MaterialForComponents(CPU));
          CPU.addMaterialForComponents( new MaterialForComponents(viti));
         
        ComponentX scimitar = new ComponentX(0, "Scimitar", 0);
        scimitar.addMaterialForComponents( new MaterialForComponents(ladarSensorCluster));
        scimitar.addMaterialForComponents( new MaterialForComponents(nanoMechanicalMicroProcessor));

        componentXs.add(scimitar);
    }
    
    public void baseMaterial(String bpoName){
//        baseMaterial02();
        boolean flag = false;
        
        
        if ( flag )
            return;
        
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
                        
                        
//                        MaterialForComponents materialForComponents = new MaterialForComponents( invTypes.getTypeID(),invTypes.getTypeName(), neededComponent.getQuantity()  );
//                        componentX.addMaterialForComponents(materialForComponents); 
                        
//                        componentX.addMaterialForComponents
//                         ( new MaterialForComponents(invTypes.getTypeID(), 
//                           invTypes.getTypeName(), neededComponent.getQuantity()));
                        
                        
                        componentX.addMaterialForComponents
                         ( new MaterialForComponents( new ComponentX
                         ( invTypes.getTypeID(), invTypes.getTypeName(), neededComponent.getQuantity()  ) ) );
                    }
                }
                ManagerComponentX.getInstance().addComponentXs(componentX);
            }
        }
        List < ComponentX > componentXs1 = ManagerComponentX.getInstance().getBaseComponentXs();
        System.out.println("");
    }
    
    public void Display(){
         List < ComponentX > componentXs = ManagerComponentX.getInstance().getBaseComponentXs();
//        List < ComponentX > componentXs = this.componentXs;
        
        for (ComponentX componentX : componentXs) {
            ricorsione(componentX, " ");
        }
    }
    

    private void ricorsione(ComponentX componentX, String tab){
        System.out.println(tab + componentX.getName() + " " + componentX.getQuanity());
        tab += tab;
        
        for (MaterialForComponents materialForComponents : componentX.getMaterialForComponents()){
            ricorsione(materialForComponents.getComponentX(), tab);
        }
        
    }
}
