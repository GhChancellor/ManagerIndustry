/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.ricorsione.buildItemRecursion;

import java.util.ArrayList;
import java.util.List;
import managerindustry.db.entities.eve.IndustryActivityMaterials;
import managerindustry.db.entities.eve.InvTypes;
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
    private TemplateRecursionA componentRecursion;
    
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
        
        List materials = componentRecursion.getLists();
        componentRecursion = new TemplateRecursionA();
        
        buildItem(bpoName, run, job, bpoME, componentMe, materials, componentRecursion );
        
        displayTreeMateralNeeded(componentRecursion, " ");
//        System.out.println("");
    }
    
    private void displayTreeMateralNeeded( TemplateRecursionA templateRecursionA, String tab){
        List < TemplateRecursionB > as = templateRecursionA.getLists();
        tab += "\t";
        
        for (TemplateRecursionB a : as) {
            
            TemplateRecursionA recursionA = (TemplateRecursionA)a.getT();
            System.out.println(""+ tab + ((ComponentX02)recursionA.getT()).getName());
          
            displayTreeMateralNeeded(recursionA, tab);
        }
        
        /*
                for (TemplateRecursionB material : materials) {
            TemplateRecursionA recursionA = (TemplateRecursionA)material.getT();
            
            ComponentX02 componentX02 = new ComponentX02();
            componentX02.setName( ((ComponentX02)recursionA.getT()).getName() );
            
            TemplateRecursionA a = new TemplateRecursionA(componentX02);
            componentRecursion.addLists(new TemplateRecursionB(a));            
            
            TemplateRecursionB materialForComponents = new TemplateRecursionB();
            materialForComponents.setLists(recursionA.getLists());
            
            if ( materialForComponents != null){
                buildItem("", run, job, bpoME, componentMe,
                materialForComponents.getLists(), a);
            
            
//            System.out.println("");
            }
        */
        
// System.out.println(""+((ComponentX02)templateRecursionB.getT()).getName() );
    }
    
    private void displayTreeMateralNeededOLD(TemplateRecursionA templateRecursionA, String tab){
        List lists = templateRecursionA.getLists();
        
        ComponentX02 componentX = ((ComponentX02)templateRecursionA.getLists());
        tab ="\t";
        
        System.out.println("" + componentX.getName() + " " + componentX.getQuanityInt() 
                + " -> " +String.format("%.0f", componentX.getQuanityDbl()));
        
        List < TemplateRecursionA > materialForComponent = templateRecursionA.getLists();
        
        for (TemplateRecursionA templateRecursionA1 : materialForComponent) {
            displayTreeMateralNeededOLD( templateRecursionA1  ,tab);
        }
        
        

    }
    
    
    private void buildItem(String bpoName, int run, int job, int bpoME, 
        int componentMe, List < TemplateRecursionB > materials, 
        TemplateRecursionA componentRecursion){
        
        for (TemplateRecursionB material : materials) {
            TemplateRecursionA recursionA = (TemplateRecursionA)material.getT();

           // calculate materialEfficiencyCalculate
            MaterialEfficiencyCalculate materialEfficiencyCalculate = 
                getMaterialEfficiencyCalculate(run, job, bpoME, componentMe, materials, componentRecursion, recursionA);
            
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
            
            TemplateRecursionA a = new TemplateRecursionA(component);
            componentRecursion.addLists( new TemplateRecursionB(a));            
            
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
            TemplateRecursionB materialForComponents = new TemplateRecursionB();
            materialForComponents.setLists(recursionA.getLists());
            
            
            if ( materialForComponents != null){
                buildItem(bpoName, singleMaterial, 1, bpoME, 1, materialForComponents.getLists(), a);
            }             

        }
    }
    
        private void buildItemOLD(String bpoName, int run, int job, int bpoME, 
        int componentMe, List < TemplateRecursionB > materials, 
        TemplateRecursionA componentRecursion){
        
        for (TemplateRecursionB material : materials) {
            TemplateRecursionA recursionA = (TemplateRecursionA)material.getT();
            
            ComponentX02 componentX02 = new ComponentX02();
            componentX02.setName( ((ComponentX02)recursionA.getT()).getName() );
            
            TemplateRecursionA a = new TemplateRecursionA(componentX02);
            componentRecursion.addLists(new TemplateRecursionB(a));            
            
            TemplateRecursionB materialForComponents = new TemplateRecursionB();
            materialForComponents.setLists(recursionA.getLists());
            
            if ( materialForComponents != null){
                buildItem("", run, job, bpoME, componentMe,
                materialForComponents.getLists(), a);
            
            
//            System.out.println("");
            }

        }
    }
    
    /**
     * @deprecated 
     * DBG
     * Get Material Efficiency Calculate
     * @param int run
     * @param int job
     * @param int bpoME
     * @param int componentMe
     * @param List < TemplateRecursionB > materials
     * @param TemplateRecursionA t <------
     * @param TemplateRecursionA recursionA <------
     * @return MaterialEfficiencyCalculate
     */
    private MaterialEfficiencyCalculate getMaterialEfficiencyCalculate(int run, int job, int bpoME,  
        int componentMe, List < TemplateRecursionB > materials, 
        TemplateRecursionA t,TemplateRecursionA recursionA){
            // check if item is t1 or t2           
            if ( materials.isEmpty() ){                               
                // me for T1
                MaterialEfficiencyCalculate materialEfficiencyCalculate = 
                 new MaterialEfficiencyCalculate(run, job, bpoME ,((ComponentX02)recursionA.getT()).getQuanityInt() );
                
                return materialEfficiencyCalculate;                
            }else{
                // me for component ( t2 )
                MaterialEfficiencyCalculate materialEfficiencyCalculate = 
                 new MaterialEfficiencyCalculate(run, job, componentMe , ((ComponentX02)recursionA.getT()).getQuanityInt() ); 
                
                return materialEfficiencyCalculate;   
            }         
    }
    
    private void baseMaterial(List< IndustryActivityMaterials> nameItemToBuild,
        TemplateRecursionA t, RamActivitiesEnum activitiesEnum){   
        
        for (IndustryActivityMaterials nameItemToBuild1 : nameItemToBuild) {
            InvTypes invTypes =
              ManagerDB.getInstance().invTypes().getInvTypesById(nameItemToBuild1.getMaterialTypeID());

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
