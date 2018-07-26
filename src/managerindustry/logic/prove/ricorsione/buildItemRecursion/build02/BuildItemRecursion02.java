/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.ricorsione.buildItemRecursion.build02;

import java.util.List;
import managerindustry.db.entities.eve.IndustryActivityMaterials;
import managerindustry.db.entities.eve.InvTypes;
import managerindustry.logic.enumName.RamActivitiesEnum;
import managerindustry.logic.manager.Manager;
import managerindustry.logic.manager.db.Db;
import managerindustry.logic.prove.ricorsione.buildItemRecursion.ComponentX02;
import managerindustry.logic.prove.ricorsione.skill.skillProduction.qualcosa.TemplateRecursionA;
import managerindustry.logic.prove.ricorsione.skill.skillProduction.qualcosa.TemplateRecursionB;

/**
 *
 * @author lele
 */
public class BuildItemRecursion02 {

    public BuildItemRecursion02(String bpoName, int run, int job, int bpoME, 
        int componentMe) {
        
        RamActivitiesEnum activitiesEnum = RamActivitiesEnum.MANUFACTURING;

        bpoName += " blueprint";
        System.out.println("" + bpoName);
        
        List< IndustryActivityMaterials> nameItemToBuild = 
         Manager.getInstance().db().item().industryActivityMaterials().getMaterialNeedByName(bpoName, activitiesEnum);

        ComponentX02 component = new ComponentX02();
        component.setName(bpoName);
        TemplateRecursionA02 componentRecursion = new TemplateRecursionA02(component);
        
        baseMaterial(nameItemToBuild, componentRecursion, activitiesEnum );    
        
        TemplateRecursionA02 a = new TemplateRecursionA02(componentRecursion);
        
        componentRecursion = new TemplateRecursionA02();
        buildItem(bpoName, run, job, bpoME, componentMe, a, componentRecursion);
        
        
//        int a = 10;
    }
    
    private void buildItem(String bpoName, int run, int job, int bpoME, 
            int componentMe, TemplateRecursionA02 materials, 
            TemplateRecursionA02 componentRecursion){

        TemplateRecursionB02 b02 = new TemplateRecursionB02(materials);
        TemplateRecursionA02 t = (TemplateRecursionA02) b02.getT();
        
        ComponentX02 name = (ComponentX02)t.getLists();
        
        System.out.println("xxxx"+ name.getName()   );
        

        int i = 10;
        
//            for (TemplateRecursionA02 material : materials) {
////                ((TemplateRecursionA02)material).getT();
//
////                ComponentX02 component = new ComponentX02();
////                component.setName( ((ComponentX02)material. getT()).getName());
////                componentRecursion.addLists(component);
//            }
    }
    
    private void baseMaterial(List< IndustryActivityMaterials> nameItemToBuild,
        TemplateRecursionA02 t, RamActivitiesEnum activitiesEnum){   
        
        for (IndustryActivityMaterials nameItemToBuild1 : nameItemToBuild) {
            InvTypes invTypes =
              Manager.getInstance().db().item().invTypes().getInvTypesById(nameItemToBuild1.getMaterialTypeID());

            ComponentX02 componentX = new ComponentX02();
            componentX.setName(invTypes.getTypeName());
            componentX.setQuanityInt(nameItemToBuild1.getQuantity());
            
            TemplateRecursionA02 a = new TemplateRecursionA02(componentX);
            t.addLists(new TemplateRecursionB(a));
            
            List< IndustryActivityMaterials> neededComponents = 
              Manager.getInstance().db().item().industryActivityMaterials().getMaterialNeedByName(invTypes.getTypeName() + " blueprint", activitiesEnum);
                        
            if (neededComponents != null)
                baseMaterial(neededComponents, a, activitiesEnum);

        }
    }    
}
