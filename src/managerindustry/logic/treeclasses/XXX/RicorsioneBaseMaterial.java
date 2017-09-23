/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.treeclasses.XXX;

import java.util.ArrayList;
import java.util.List;
import managerindustry.db.entities.IndustryActivityMaterials;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.buiild.ComponentX;
import managerindustry.logic.buiild.MaterialForComponents;
import managerindustry.logic.manager.managerDB.ManagerDBEve;

/**
 *
 * @author lele
 */
public class RicorsioneBaseMaterial {
    private List < ComponentX > componentXs = new ArrayList<>();
    
            
    public void initBPO(){
        // CONCORD 25000mm Steel Plates
        
        String bpoName = "CONCORD 25000mm Steel Plates " + "blueprint";
        System.out.println("" + bpoName); 
        
        // get item to build
        List < IndustryActivityMaterials > nameItemToBuild = ManagerDBEve.getInstance().getMaterialNeedByName(bpoName);   
       // ricorsione(nameItemToBuild, "");
        ricorsione02(nameItemToBuild);

        diplay();
    }
    
    public void ricorsione02(List < IndustryActivityMaterials > nameItemToBuild){
        for (IndustryActivityMaterials nameItemToBuild1 : nameItemToBuild) {
            InvTypes invTypes = ManagerDBEve.getInstance().getInvTypes_NameById(nameItemToBuild1.getMaterialTypeID());
//            System.out.println(tab + invTypes.getTypeID() + " " + invTypes.getTypeName() + " " + nameItemToBuild1.getQuantity());

            ComponentX componentX = new ComponentX();
            componentX.setName(invTypes.getTypeName());
            componentX.setQuanityInt(nameItemToBuild1.getQuantity());
            
            List < IndustryActivityMaterials > neededComponents = ManagerDBEve.getInstance().getMaterialNeedByName( invTypes.getTypeName() + " blueprint");
        
            componentXs.add(componentX);         
            
            if ( neededComponents != null){
                for (IndustryActivityMaterials neededComponent : neededComponents) {
                    InvTypes invTypes02 = ManagerDBEve.getInstance().getInvTypes_NameById(neededComponent.getMaterialTypeID());

                    MaterialForComponents components = new MaterialForComponents(neededComponent.getTypeID(), invTypes02.getTypeName(), neededComponent.getMaterialTypeID());
                    componentX.addMaterialForComponents(components);
                    componentXs.add(componentX);
                    
                    List < IndustryActivityMaterials > neededComponentsXX = ManagerDBEve.getInstance().getMaterialNeedByName( invTypes02.getTypeName() + " blueprint");
                    if (neededComponentsXX != null )
                        ricorsione02(neededComponentsXX);

                        
                }
            }            
        }
        System.out.println("");
        diplay();
    }

    
    private void xxx(ComponentX componentX){
        
    }
    
    public void ricorsione(List < IndustryActivityMaterials > nameItemToBuild, String tab) {
        
        
        for (IndustryActivityMaterials nameItemToBuild1 : nameItemToBuild) {
            boolean flag = false;
            InvTypes invTypes = ManagerDBEve.getInstance().getInvTypes_NameById(nameItemToBuild1.getMaterialTypeID());
//            System.out.println(tab + invTypes.getTypeID() + " " + invTypes.getTypeName() + " " + nameItemToBuild1.getQuantity());

            ComponentX componentX = new ComponentX();
            componentX.setName(invTypes.getTypeName());
            componentX.setQuanityInt(nameItemToBuild1.getQuantity());
            
            List < IndustryActivityMaterials > neededComponents = ManagerDBEve.getInstance().getMaterialNeedByName( invTypes.getTypeName() + " blueprint");
        
            componentXs.add(componentX);         
            
            if ( neededComponents != null){
                if (flag ){
                    tab += "\t";
 
                }                     
                ricorsione(neededComponents, tab);
                flag = true;
            }

        }     
        System.out.println("");
    }
    
    public void diplay(){
        for (ComponentX componentX : componentXs) {
            System.out.println("" + componentX.getName() + " " + componentX.getQuanityInt());
            List < MaterialForComponents> materialForComponents = componentX.getMaterialForComponents();
            for (MaterialForComponents materialForComponent : materialForComponents) {
                System.out.println(""+ materialForComponent.getName() + " " + materialForComponent.getQuanityInt());
            }
            
        }
    }
}
