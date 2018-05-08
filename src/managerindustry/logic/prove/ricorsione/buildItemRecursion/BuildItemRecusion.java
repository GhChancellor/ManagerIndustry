/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.ricorsione.buildItemRecursion;

import java.util.List;
import managerindustry.db.entities.IndustryActivityMaterials;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.buiild.CalculatedComponentX;
import managerindustry.logic.buiild.ComponentX;
import managerindustry.logic.buiild.MaterialEfficiencyCalculate;
import managerindustry.logic.buiild.MaterialForComponents;
import managerindustry.logic.buiild.ReportCalculatedComponentX;
import managerindustry.logic.buiild.fatherclass.NameBase;
import managerindustry.logic.enumName.RamActivitiesEnum;
import managerindustry.logic.manager.ManagerComponentX;
import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.prove.ricorsione.skill.skillProduction.RecursionA;
import managerindustry.logic.prove.ricorsione.skill.skillProduction.qualcosa.TemplateRecursionA;
import managerindustry.logic.prove.ricorsione.skill.skillProduction.qualcosa.TemplateRecursionB;

/**
 *
 * @author lele
 */
public class BuildItemRecusion {

    public BuildItemRecusion(String bpoName, int run, int job, int bpoME, 
        int componentMe) {
        
        RamActivitiesEnum activitiesEnum = RamActivitiesEnum.MANUFACTURING;

        bpoName += " blueprint";
        System.out.println("" + bpoName);
        
        List< IndustryActivityMaterials> nameItemToBuild = 
         ManagerDB.getInstance().industryActivityMaterials().getMaterialNeedByName(bpoName, activitiesEnum);

        ComponentX02 component = new ComponentX02();
        component.setName(bpoName);
        TemplateRecursionA componentRecursion = new TemplateRecursionA(component);
        
        baseMaterial(nameItemToBuild, componentRecursion, activitiesEnum );
        
        buildItem(bpoName, run, job, bpoME, componentMe, componentRecursion.getLists(), componentRecursion);
        
        System.out.println("");
    }
    
    private void buildItem(String bpoName, int run, int job, int bpoME, 
        int componentMe, List < TemplateRecursionB > materials, 
        TemplateRecursionA t){
        
        for (TemplateRecursionB material : materials) {
            TemplateRecursionA recursionA = (TemplateRecursionA)material.getT();

           // calculate materialEfficiencyCalculate
            MaterialEfficiencyCalculate materialEfficiencyCalculate;

            // check if item is t1 or t2           
            if ( materials.isEmpty() ){
                                
                // me for T1
                MaterialEfficiencyCalculate materialEfficiencyCalculateX = 
                 new MaterialEfficiencyCalculate(run, job, bpoME ,((ComponentX02)recursionA.getT()).getQuanityInt() );
                
                materialEfficiencyCalculate = materialEfficiencyCalculateX;                
            }else{
                // me for component ( t2 )
                MaterialEfficiencyCalculate materialEfficiencyCalculateX = 
                 new MaterialEfficiencyCalculate(run, job, componentMe , ((ComponentX02)recursionA.getT()).getQuanityInt() ); 
                
                materialEfficiencyCalculate = materialEfficiencyCalculateX;
            }     
            
            // quantity material per single item 1 run
            int singleMaterial = 
                materialEfficiencyCalculate.getSingleItemMaterial();
           
            // quantity material per all items 1 run
            double totalMaterials = 
                materialEfficiencyCalculate.getTotalItemsMaterials(); 
            
            ComponentX02 component = new ComponentX02();
            component.setName( ((ComponentX02)recursionA.getT()).getName());
            component.setQuanityInt(singleMaterial);
            component.setQuanityDbl(totalMaterials);            
            
            // Single item scimitar x 1
            CalculatedComponentX calculatedComponentX = new CalculatedComponentX
                (((ComponentX02)recursionA.getT()).getName(), singleMaterial, totalMaterials);             
            
            // add object values
            ManagerComponentX02.getInstance().addCalculatedComponentXs(calculatedComponentX);            
            
            // Put report Calculated Components
            ReportCalculatedComponentX reportCalculatedComponentX = 
             new ReportCalculatedComponentX(((ComponentX02)recursionA.getT()).getName(), singleMaterial, totalMaterials);    
            
            // Sum all values of the items to map Scimitar x 2
            ManagerComponentX02.getInstance().sumReportCalculatedComponentXMap
                (reportCalculatedComponentX);            
            
            // get Value for components T2
            List < MaterialForComponents > materialForComponents = recursionA.getLists();

            t.addLists( new TemplateRecursionB(component));
                     
//            if ( materialForComponents != null){
//                buildItem("", singleMaterial, 1, bpoME, 
//                 1, materialForComponents, component );
//            }             
            
            
            System.out.println("");                 
            
        }
        

    }
        
    private void baseMaterial(List< IndustryActivityMaterials> nameItemToBuild,
        TemplateRecursionA t, RamActivitiesEnum activitiesEnum){   
        
        for (IndustryActivityMaterials nameItemToBuild1 : nameItemToBuild) {
            InvTypes invTypes =
              ManagerDB.getInstance().invTypes().getNameById(nameItemToBuild1.getMaterialTypeID());

            ComponentX02 componentX = new ComponentX02();
            componentX.setName(invTypes.getTypeName());
            componentX.setQuanityInt(nameItemToBuild1.getQuantity());
            
            TemplateRecursionA a = new TemplateRecursionA(componentX);
            t.addLists(new TemplateRecursionB(a));
            
            List< IndustryActivityMaterials> neededComponents = 
              ManagerDB.getInstance().industryActivityMaterials().getMaterialNeedByName(invTypes.getTypeName() + " blueprint", activitiesEnum);
                        
            if (neededComponents != null)
                baseMaterial(neededComponents, a, activitiesEnum);

        }
    }

}
