/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.ricorsione.treeclasses.XXX;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import managerindustry.db.entities.eve.IndustryActivityMaterials;
import managerindustry.db.entities.eve.InvTypes;
import managerindustry.logic.build.ComponentX;
import managerindustry.logic.build.MaterialForComponents;


/**
 *
 * @author lele
 */
public class RicorsioneBaseMaterial {

    private List< ComponentX> componentXs = new ArrayList<>();
    private Map<Integer, List<IndustryActivityMaterials>> fakeDbMap = new HashMap<>();

    public void initBPO() {
        // CONCORD 25000mm Steel Plates

//        String bpoName = "scimitar " + "blueprint";
//        System.out.println("" + bpoName);
//
//        // get item to build
//        List< IndustryActivityMaterials> nameItemToBuild = ManagerDBEve_OLD.getInstance().getMaterialNeedByName(bpoName);
//        ComponentX dad = new ComponentX(0, "DAD", 0);
//        ricorsione(nameItemToBuild, "", dad);
//
//        
//        List<MaterialForComponents> mmmmm = dad.getMaterialForComponents();
//        
//        for (MaterialForComponents mat : mmmmm) {
//            componentXs.add(mat.getComponentX());
//        }
        
        System.out.println("");
//        ricorsione02(nameItemToBuild);
//        diplay();

//        List<IndustryActivityMaterials> level1 = new ArrayList<>();
//        IndustryActivityMaterials m11 = new IndustryActivityMaterials(11);
//        IndustryActivityMaterials m12 = new IndustryActivityMaterials(12);
//        IndustryActivityMaterials m13 = new IndustryActivityMaterials(13);
//        level1.add(m11);
//        level1.add(m12);
//        level1.add(m13);
//        fakeDbMap.put(1, level1);
//
//        List<IndustryActivityMaterials> level2 = new ArrayList<>();
//        IndustryActivityMaterials m21 = new IndustryActivityMaterials(21);
//        IndustryActivityMaterials m22 = new IndustryActivityMaterials(22);
//        level2.add(m21);
//        level2.add(m22);
//        fakeDbMap.put(2, level2);
//
//        List<IndustryActivityMaterials> level12 = new ArrayList<>();
//        IndustryActivityMaterials m121 = new IndustryActivityMaterials(121);
//        IndustryActivityMaterials m122 = new IndustryActivityMaterials(122);
//        IndustryActivityMaterials m123 = new IndustryActivityMaterials(123);
//        level12.add(m121);
//        level12.add(m122);
//        level12.add(m123);
//        fakeDbMap.put(12, level12);
//
//        List<IndustryActivityMaterials> level21 = new ArrayList<>();
//        IndustryActivityMaterials m211 = new IndustryActivityMaterials(211);
//        level21.add(m211);
//        fakeDbMap.put(21, level21);
//
//        List<IndustryActivityMaterials> level211 = new ArrayList<>();
//        IndustryActivityMaterials m2111 = new IndustryActivityMaterials(2111);
//        IndustryActivityMaterials m2112 = new IndustryActivityMaterials(2112);
//        level211.add(m2111);
//        level211.add(m2112);
//        fakeDbMap.put(211, level211);

    }

    public void ricorsione(List< IndustryActivityMaterials> nameItemToBuild, String tab, ComponentX dad) {

//        for (IndustryActivityMaterials nameItemToBuild1 : nameItemToBuild) {
//            InvTypes invTypes = ManagerDBEve_OLD.getInstance().getInvTypes_NameById(nameItemToBuild1.getMaterialTypeID());
//            System.out.println(tab + invTypes.getTypeID() + " " + invTypes.getTypeName() + " " + nameItemToBuild1.getQuantity());
//
//            ComponentX componentX = new ComponentX();
//            componentX.setName(invTypes.getTypeName());
//            componentX.setQuanityInt(nameItemToBuild1.getQuantity());
//
//            List< IndustryActivityMaterials> neededComponents = 
//             ManagerDBEve_OLD.getInstance().getMaterialNeedByName
//             (invTypes.getTypeName() + " blueprint");
//
//            dad.addMaterialForComponents(new MaterialForComponents(componentX));
//
//            if (neededComponents != null) {
//
//                ricorsione(neededComponents, tab + "\t", componentX);
//            }
//
//        }
    }

    public void diplay() {
        for (ComponentX componentX : componentXs) {
            System.out.println("" + componentX.getTypeName() + " " + componentX.getQuanityI());
            List< MaterialForComponents> materialForComponents = componentX.getMaterialForComponents();
            for (MaterialForComponents materialForComponent : materialForComponents) {
                System.out.println("" + materialForComponent.getTypeName() + " " + materialForComponent.getQuanityI());
            }

        }
    }

    void ricorsioneLuca(List<IndustryActivityMaterials> tree, String tab, ComponentX dad) {

//        for (IndustryActivityMaterials a : tree) {
//            System.out.println(tab + a.getIdd());
//
//            ComponentX componentX = new ComponentX();
//            componentX.setName("nome-" + a.getIdd());
//            componentX.setQuanityInt(a.getIdd());
//            MaterialForComponents comp = new MaterialForComponents(componentX);
//            dad.addMaterialForComponents(comp);
//
//            List<IndustryActivityMaterials> subList = fakeDbMap.get(a.getIdd());
//            if (subList != null) {
//                ricorsioneLuca(subList, tab + "-", componentX);
//            }
//        }
    }
}
