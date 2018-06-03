/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.rig;

import java.util.ArrayList;
import java.util.List;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.manager.managerDB.ManagerDB;

/**
 *
 * @author lele
 */
public class RigGroups {
    
    private List<InvTypes> getInvTypes(List<Integer> rigGroups){
        List<InvTypes> invTypeses = new ArrayList<>();
        for (Integer rigGroup : rigGroups) {
            InvTypes invTypes = ManagerDB.getInstance().invTypes().getInvTypesById(rigGroup);
            invTypeses.add(invTypes);
        }
        return invTypeses;
    }
    
    public List<InvTypes> getStandupMSetAdvancedComponentManufacturing(){
        List<Integer> rigGroups = new ArrayList<>();
        rigGroups.add(43867); // Standup M-Set Advanced Component Manufacturing Material Efficiency I
        rigGroups.add(43866); // Standup M-Set Advanced Component Manufacturing Material Efficiency II
        rigGroups.add(43869); // Standup M-Set Advanced Component Manufacturing Time Efficiency I
        rigGroups.add(43868); // Standup M-Set Advanced Component Manufacturing Time Efficiency II
        return getInvTypes(rigGroups);
    }
    
    public List<InvTypes> getStandupMSetAdvancedLargeShipManufacturing(){
        List<Integer> rigGroups = new ArrayList<>();
        rigGroups.add(43862); // Standup M-Set Advanced Large Ship Manufacturing Material Efficiency I
        rigGroups.add(43863); // Standup M-Set Advanced Large Ship Manufacturing Material Efficiency II
        rigGroups.add(43865); // Standup M-Set Advanced Large Ship Manufacturing Time Efficiency I
        rigGroups.add(43864); // Standup M-Set Advanced Large Ship Manufacturing Time Efficiency II
        return getInvTypes(rigGroups);
    }
    
    public List<InvTypes> getStandupMSetAdvancedMediumShipManufacturing(){
        List<Integer> rigGroups = new ArrayList<>();
        rigGroups.add(43858); // Standup M-Set Advanced Medium Ship Manufacturing Material Efficiency I
        rigGroups.add(43859); // Standup M-Set Advanced Medium Ship Manufacturing Material Efficiency II
        rigGroups.add(43860); // Standup M-Set Advanced Medium Ship Manufacturing Time Efficiency I
        rigGroups.add(43861); // Standup M-Set Advanced Medium Ship Manufacturing Time Efficiency II
        return getInvTypes(rigGroups);
    }
    
    public List<InvTypes> getStandupMSetAdvancedSmallShipManufacturing(){
        List<Integer> rigGroups = new ArrayList<>();
        rigGroups.add(43855); // Standup M-Set Advanced Small Ship Manufacturing Material Efficiency I
        rigGroups.add(43854); // Standup M-Set Advanced Small Ship Manufacturing Material Efficiency II
        rigGroups.add(43856); // Standup M-Set Advanced Small Ship Manufacturing Time Efficiency I
        rigGroups.add(43857); // Standup M-Set Advanced Small Ship Manufacturing Time Efficiency II
        return getInvTypes(rigGroups);
    }
    
    public List<InvTypes> getStandupMSetAmmunitionManufacturing(){
        List<Integer> rigGroups = new ArrayList<>();
        rigGroups.add(37158); // Standup M-Set Ammunition Manufacturing Material Efficiency I
        rigGroups.add(37159); // Standup M-Set Ammunition Manufacturing Material Efficiency II
        rigGroups.add(37150); // Standup M-Set Ammunition Manufacturing Time Efficiency I
        rigGroups.add(37151); // Standup M-Set Ammunition Manufacturing Time Efficiency II
        return getInvTypes(rigGroups);
    }
    
    public List<InvTypes> getStandupMSetBasicCapitalComponentManufacturing(){
        List<Integer> rigGroups = new ArrayList<>();
        rigGroups.add(43870); // Standup M-Set Basic Capital Component Manufacturing Material Efficiency I
        rigGroups.add(43871); // Standup M-Set Basic Capital Component Manufacturing Material Efficiency II
        rigGroups.add(43872); // Standup M-Set Basic Capital Component Manufacturing Time Efficiency I
        rigGroups.add(43873); // Standup M-Set Basic Capital Component Manufacturing Time Efficiency II
        return getInvTypes(rigGroups);
    }
    
    public List<InvTypes> getStandupMSetBasicLargeShipManufacturing(){
        List<Integer> rigGroups = new ArrayList<>();
        rigGroups.add(43732); // Standup M-Set Basic Large Ship Manufacturing Material Efficiency I
        rigGroups.add(37152); // Standup M-Set Basic Large Ship Manufacturing Material Efficiency II
        rigGroups.add(43733); // Standup M-Set Basic Large Ship Manufacturing Time Efficiency I
        rigGroups.add(43734); // Standup M-Set Basic Large Ship Manufacturing Time Efficiency II
        return getInvTypes(rigGroups);
    }
    
    public List<InvTypes> getStandupMSetBasicMediumShipManufacturing(){
        List<Integer> rigGroups = new ArrayList<>();
        rigGroups.add(37146); // Standup M-Set Basic Medium Ship Manufacturing Material Efficiency I
        rigGroups.add(37147); // Standup M-Set Basic Medium Ship Manufacturing Material Efficiency II
        rigGroups.add(43919); // Standup M-Set Basic Medium Ship Manufacturing Time Efficiency I
        rigGroups.add(37153); // Standup M-Set Basic Medium Ship Manufacturing Time Efficiency II
        return getInvTypes(rigGroups);
    }
    
    public List<InvTypes> getStandupMSetBasicSmallShipManufacturing(){
        List<Integer> rigGroups = new ArrayList<>();
        rigGroups.add(37154); // Standup M-Set Basic Small Ship Manufacturing Material Efficiency I
        rigGroups.add(37155); // Standup M-Set Basic Small Ship Manufacturing Material Efficiency II
        rigGroups.add(37162); // Standup M-Set Basic Small Ship Manufacturing Time Efficiency I
        rigGroups.add(37163); // Standup M-Set Basic Small Ship Manufacturing Time Efficiency II
        return getInvTypes(rigGroups);
    }
    
    public List<InvTypes> getStandupMSetBlueprintCopy(){
        List<Integer> rigGroups = new ArrayList<>();
        rigGroups.add(43893); // Standup M-Set Blueprint Copy Accelerator I
        rigGroups.add(43892); // Standup M-Set Blueprint Copy Accelerator II
        rigGroups.add(43891); // Standup M-Set Blueprint Copy Cost Optimization I
        rigGroups.add(43890); // Standup M-Set Blueprint Copy Cost Optimization II
        return getInvTypes(rigGroups);
    }
    
    public List<InvTypes> getStandupMSetDroneAndFighterManufacturing(){
        List<Integer> rigGroups = new ArrayList<>();
        rigGroups.add(37156); // Standup M-Set Drone and Fighter Manufacturing Material Efficiency I
        rigGroups.add(37157); // Standup M-Set Drone and Fighter Manufacturing Material Efficiency II
        rigGroups.add(37148); // Standup M-Set Drone and Fighter Manufacturing Time Efficiency I
        rigGroups.add(37149); // Standup M-Set Drone and Fighter Manufacturing Time Efficiency II
        return getInvTypes(rigGroups);
    }
    
//    public List<InvTypes> get(){
//        List<Integer> rigGroups = new ArrayList<>();
//        rigGroups.add(); // 
//        rigGroups.add(); // 
//        rigGroups.add(); // 
//        rigGroups.add(); // 
//        return getInvTypes(rigGroups);
//    }
//    
//    public List<InvTypes> get(){
//        List<Integer> rigGroups = new ArrayList<>();
//        rigGroups.add(); // 
//        rigGroups.add(); // 
//        rigGroups.add(); // 
//        rigGroups.add(); // 
//        return getInvTypes(rigGroups);
//    }
//    
//    public List<InvTypes> get(){
//        List<Integer> rigGroups = new ArrayList<>();
//        rigGroups.add(); // 
//        rigGroups.add(); // 
//        rigGroups.add(); // 
//        rigGroups.add(); // 
//        return getInvTypes(rigGroups);
//    }
//    
//    public List<InvTypes> get(){
//        List<Integer> rigGroups = new ArrayList<>();
//        rigGroups.add(); // 
//        rigGroups.add(); // 
//        rigGroups.add(); // 
//        rigGroups.add(); // 
//        return getInvTypes(rigGroups);
//    }
//    
//    public List<InvTypes> get(){
//        List<Integer> rigGroups = new ArrayList<>();
//        rigGroups.add(); // 
//        rigGroups.add(); // 
//        rigGroups.add(); // 
//        rigGroups.add(); // 
//        return getInvTypes(rigGroups);
//    }
//    
//    public List<InvTypes> get(){
//        List<Integer> rigGroups = new ArrayList<>();
//        rigGroups.add(); // 
//        rigGroups.add(); // 
//        rigGroups.add(); // 
//        rigGroups.add(); // 
//        return getInvTypes(rigGroups);
//    }
    
    

}
