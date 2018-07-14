/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig;

import managerindustry.db.entities.cache.EffectEngineeringRigEntity;
import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.logic.EffectEngineeringRigs;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.largeRig.InitLargeRigGroups;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.mediumRig.InitMediumRigGroups;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.xl_Rig.InitXLRigGroups;

/**
 *
 * @author lele
 */
public class ChooseRig {
    private InitMediumRigGroups initMediumRigGroups = new InitMediumRigGroups();
    private InitLargeRigGroups initLargeRigGroups = new InitLargeRigGroups();
    private InitXLRigGroups initXLRigGroups = new InitXLRigGroups();
    
    /**
     * Get Effect Rig and his effect
     * @param int typeID
     * @param int effectID 
     * @return EffectEngineeringRigEntity
     */
    public boolean isEffectEngineeringRig(int typeID, int effectID){
        EffectEngineeringRigs engineeringRigs = new EffectEngineeringRigs();
        
        if (engineeringRigs.getEffectRig(typeID, effectID) == null ){
            return false;
        }
        
        return true;
    }
    
    /**
     * Init and add to db if not exits
     * @param typeId 
     */
    public ChooseRig(int typeId) {
        
        switch (typeId){
            case 43920: // Standup M-Set Equipment Manufacturing Material Efficiency I
            case 43921: // Standup M-Set Equipment Manufacturing Material Efficiency II
            case 37160: // Standup M-Set Equipment Manufacturing Time Efficiency I
            case 37161: // Standup M-Set Equipment Manufacturing Time Efficiency II
                initMediumRigGroups.initStandupMSetEquipmentManufacturing(43920, 43921, 37160, 37161);
                break;
            case 43867: // Standup M-Set Advanced Component Manufacturing Material Efficiency I
            case 43866: // Standup M-Set Advanced Component Manufacturing Material Efficiency II
            case 43869: // Standup M-Set Advanced Component Manufacturing Time Efficiency I
            case 43868: // Standup M-Set Advanced Component Manufacturing Time Efficiency II  
                initMediumRigGroups.initStandupMSetAdvancedComponentManufacturing(43867, 43866, 43869, 43868);
                break;
            case 43862: // Standup M-Set Advanced Large Ship Manufacturing Material Efficiency I
            case 43863: // Standup M-Set Advanced Large Ship Manufacturing Material Efficiency II
            case 43865: // Standup M-Set Advanced Large Ship Manufacturing Time Efficiency I
            case 43864: // Standup M-Set Advanced Large Ship Manufacturing Time Efficiency II
                initMediumRigGroups.initStandupMSetAdvancedLargeShipManufacturing(43862, 43863, 43865, 43864);
                break;
            case 43858: // Standup M-Set Advanced Medium Ship Manufacturing Material Efficiency I
            case 43859: // Standup M-Set Advanced Medium Ship Manufacturing Material Efficiency II
            case 43860: // Standup M-Set Advanced Medium Ship Manufacturing Time Efficiency I
            case 43861: // Standup M-Set Advanced Medium Ship Manufacturing Time Efficiency II
                initMediumRigGroups.initStandupMSetAdvancedMediumShipManufacturing(43858, 43859, 43860, 43861);
                break;
            case 43855: // Standup M-Set Advanced Small Ship Manufacturing Material Efficiency I
            case 43854: // Standup M-Set Advanced Small Ship Manufacturing Material Efficiency II
            case 43856: // Standup M-Set Advanced Small Ship Manufacturing Time Efficiency I
            case 43857: // Standup M-Set Advanced Small Ship Manufacturing Time Efficiency II
                initMediumRigGroups.initStandupMSetAdvancedSmallShipManufacturing(43855, 43854, 43856, 43857);
                break;
            case 37158: // Standup M-Set Ammunition Manufacturing Material Efficiency I
            case 37159: // Standup M-Set Ammunition Manufacturing Material Efficiency II
            case 37150: // Standup M-Set Ammunition Manufacturing Time Efficiency I
            case 37151: // Standup M-Set Ammunition Manufacturing Time Efficiency II
                initMediumRigGroups.initStandupMSetAmmunitionManufacturing(37158, 37159, 37150, 37151);
                break;
            case 43870: // Standup M-Set Basic Capital Component Manufacturing Material Efficiency I
            case 43871: // Standup M-Set Basic Capital Component Manufacturing Material Efficiency II
            case 43872: // Standup M-Set Basic Capital Component Manufacturing Time Efficiency I
            case 43873: // Standup M-Set Basic Capital Component Manufacturing Time Efficiency II
                initMediumRigGroups.initStandupMSetBasicCapitalComponentManufacturing(43870, 43871, 43872, 43873);
                break;
            case 43732: // Standup M-Set Basic Large Ship Manufacturing Material Efficiency I
            case 37152: // Standup M-Set Basic Large Ship Manufacturing Material Efficiency II
            case 43733: // Standup M-Set Basic Large Ship Manufacturing Time Efficiency I
            case 43734: // Standup M-Set Basic Large Ship Manufacturing Time Efficiency II
                initMediumRigGroups.initStandupMSetBasicLargeShipManufacturing(43732, 37152, 43733, 43734);
                break;
            case 37146: // Standup M-Set Basic Medium Ship Manufacturing Material Efficiency I
            case 37147: // Standup M-Set Basic Medium Ship Manufacturing Material Efficiency II
            case 43919: // Standup M-Set Basic Medium Ship Manufacturing Time Efficiency I
            case 37153: // Standup M-Set Basic Medium Ship Manufacturing Time Efficiency II
                initMediumRigGroups.initStandupMSetBasicMediumShipManufacturing(37146, 37147, 43919, 37153);
                break;
            case 37154: // Standup M-Set Basic Small Ship Manufacturing Material Efficiency I
            case 37155: // Standup M-Set Basic Small Ship Manufacturing Material Efficiency II
            case 37162: // Standup M-Set Basic Small Ship Manufacturing Time Efficiency I
            case 37163: // Standup M-Set Basic Small Ship Manufacturing Time Efficiency II
                initMediumRigGroups.initStandupMSetBasicSmallShipManufacturing(37154, 37155, 37162, 37163);
                break;
            case 37156: // Standup M-Set Drone and Fighter Manufacturing Material Efficiency I
            case 37157: // Standup M-Set Drone and Fighter Manufacturing Material Efficiency II
            case 37148: // Standup M-Set Drone and Fighter Manufacturing Time Efficiency I
            case 37149: // Standup M-Set Drone and Fighter Manufacturing Time Efficiency II
                initMediumRigGroups.initStandupMSetDroneAndFighterManufacturing(37156, 37157, 37148, 37149);
                break;
            case 43875: // Standup M-Set Structure Manufacturing Material Efficiency I
            case 43874: // Standup M-Set Structure Manufacturing Material Efficiency II
            case 43876: // Standup M-Set Structure Manufacturing Time Efficiency I
            case 43877: // Standup M-Set Structure Manufacturing Time Efficiency II
                initMediumRigGroups.initStandupMSetStructureManufacturing(43875, 43874, 43876, 43877);
                break;
            case 45640: // Standup M-Set Thukker Advanced Component Manufacturing Material Efficiency
                initMediumRigGroups.initStandupMSetThukkerAdvancedComponentManufacturing(45640);
                break;
            case 45544: // Standup M-Set Thukker Basic Capital Component Manufacturing Material Efficiency 
                initMediumRigGroups.initStandupMSetThukkerBasicCapitalComponentManufacturing(45544);
                break;
            case 43893: // Standup M-Set Blueprint Copy Accelerator I
            case 43892: // Standup M-Set Blueprint Copy Accelerator II
            case 43891: // Standup M-Set Blueprint Copy Cost Optimization I
            case 43890: // Standup M-Set Blueprint Copy Cost Optimization II
                initMediumRigGroups.initStandupMSetBlueprintCopy(43893, 43892, 43891, 43890);
                break;
            case 43880: // Standup M-Set Invention Accelerator I
            case 43881: // Standup M-Set Invention Accelerator II
            case 43879: // Standup M-Set Invention Cost Optimization I
            case 43878: // Standup M-Set Invention Cost Optimization II
                initMediumRigGroups.initStandupMSetInvention(43880, 43881, 43879, 43878);
                break;
            case 43883: // Standup M-Set ME Research Accelerator I
            case 43882: // Standup M-Set ME Research Accelerator II
            case 43885: // Standup M-Set ME Research Cost Optimization I
            case 43884: // Standup M-Set ME Research Cost Optimization II
                initMediumRigGroups.initStandupMSetMEResearch(43883, 43882, 43885, 43884);
                break;
            case 43889: // Standup M-Set TE Research Accelerator I
            case 43888: // Standup M-Set TE Research Accelerator II
            case 43887: // Standup M-Set TE Research Cost Optimization I
            case 43886: // Standup M-Set TE Research Cost Optimization II
                initMediumRigGroups.initStandupMSetTEResearch(43889, 43888, 43887, 43886);
                break;
            case 37164: // Standup L-Set Ammunition Manufacturing Efficiency I 
            case 37165: // Standup L-Set Ammunition Manufacturing Efficiency II
                initLargeRigGroups.initStandupLSetAmmunitionManufacturing(37164, 37165);
                break;                
            case 37166: // Standup L-Set Basic Large Ship Manufacturing Efficiency I 
            case 37167: // Standup L-Set Basic Large Ship Manufacturing Efficiency II  
                initLargeRigGroups.initStandupLSetBasicLargeShipManufacturing(37166, 37167);
                break;                
            case 37168: // Standup L-Set Advanced Large Ship Manufacturing Efficiency I 
            case 37169: // Standup L-Set Advanced Large Ship Manufacturing Efficiency II  
                initLargeRigGroups.initStandupLSetAdvancedLargeShipManufacturing(37168, 37169);
                break;                
            case 37170: // Standup L-Set Equipment Manufacturing Efficiency I
            case 37171: // Standup L-Set Equipment Manufacturing Efficiency II
                initLargeRigGroups.initStandupLSetEquipmentManufacturing(37170, 37171);
                break;                
            case 37172: // Standup L-Set Capital Ship Manufacturing Efficiency II  
            case 37173: // Standup L-Set Capital Ship Manufacturing Efficiency I
                initLargeRigGroups.initStandupLSetCapitalShipManufacturing(37172, 37173);
                break;                
            case 37174: // Standup L-Set Advanced Component Manufacturing Efficiency I  
            case 37175: // Standup L-Set Advanced Component Manufacturing Efficiency II 
                initLargeRigGroups.initStandupLSetAdvancedComponentManufacturing(37174, 37175);
                break;                
            case 43707: // Standup L-Set Advanced Small Ship Manufacturing Efficiency I 
            case 43708: // Standup L-Set Advanced Small Ship Manufacturing Efficiency II
                initLargeRigGroups.initStandupLSetAdvancedSmallShipManufacturing(43707, 43708);
                break;                
            case 43709: // Standup L-Set Advanced Medium Ship Manufacturing Efficiency I 
            case 43711: // Standup L-Set Advanced Medium Ship Manufacturing Efficiency II  
                initLargeRigGroups.initStandupLSetAdvancedMediumShipManufacturing(43709, 43711);
                break;                
            case 43712: // Standup L-Set Drone and Fighter Manufacturing Efficiency I  
            case 43713: // Standup L-Set Drone and Fighter Manufacturing Efficiency II 
                initLargeRigGroups.initStandupLSetDroneAndFighterManufacturing(43712, 43713);
                break;                
            case 43714: // Standup L-Set Basic Small Ship Manufacturing Efficiency I 
            case 43715: // Standup L-Set Basic Small Ship Manufacturing Efficiency II  
                initLargeRigGroups.initStandupLSetBasicSmallShipManufacturing(43714, 43715);
                break;                
            case 43716: // Standup L-Set Basic Medium Ship Manufacturing Efficiency I 
            case 43717: // Standup L-Set Basic Medium Ship Manufacturing Efficiency II 
                initLargeRigGroups.initStandupLSetBasicMediumShipManufacturing(43716, 43717);
                break;                
            case 43718: // Standup L-Set Basic Capital Component Manufacturing Efficiency I 
            case 43719: // Standup L-Set Basic Capital Component Manufacturing Efficiency II 
                initLargeRigGroups.initStandupLSetBasicCapitalComponentManufacturing(43718, 43719);
                break;                
            case 43720: // Standup L-Set Structure Manufacturing Efficiency I  
            case 43721: // Standup L-Set Structure Manufacturing Efficiency II  
                initLargeRigGroups.initStandupLSetStructureManufacturing(43720, 43721);
                break;                
            case 45546: // Standup L-Set Thukker Basic Capital Component Manufacturing Efficiency
                initLargeRigGroups.initStandupLSetThukkerBasicCapitalComponentManufacturing(45546);
                break;                
            case 45641: // Standup L-Set Thukker Advanced Component Manufacturing Efficiency  
                initLargeRigGroups.initStandupLSetThukkerAdvancedComponentManufacturing(45641);
                break;
            case 43722: // Standup L-Set Invention Optimization I  
            case 43723: // Standup L-Set Invention Optimization II 
                initLargeRigGroups.initStandupLSetInvention(43722, 43723);
                break;
            case 43724: // Standup L-Set ME Research Optimization I
            case 43725: // Standup L-Set ME Research Optimization II
                initLargeRigGroups.initStandupLSetMEResearch(43724, 43725);
                break;
            case 43726: // Standup L-Set TE Research Optimization I 
            case 43727: // Standup L-Set TE Research Optimization II 
                initLargeRigGroups.initStandupLSetTEResearch(43726, 43727);
                break;
            case 43729: // Standup L-Set Blueprint Copy Optimization I 
            case 43730: // Standup L-Set Blueprint Copy Optimization II 
                initLargeRigGroups.initStandupLSetBlueprintCopy(43729, 43730);
                break;
            case 37178: // Standup XL-Set Equipment and Consumable Manufacturing Efficiency I 
            case 37179: // Standup XL-Set Equipment and Consumable Manufacturing Efficiency II
                initXLRigGroups.initStandupXLSetEquipmentAndConsumableManufacturing(37178, 37179);
                break;                
            case 37180: // Standup XL-Set Ship Manufacturing Efficiency I
            case 37181: // Standup XL-Set Ship Manufacturing Efficiency II  
                initXLRigGroups.initStandupXLSetShipManufacturing(37180, 37181);
                break;                
            case 43704: // Standup XL-Set Structure and Component Manufacturing Efficiency I 
            case 43705: // Standup XL-Set Structure and Component Manufacturing Efficiency II 
                initXLRigGroups.initStandupXLSetStructureAndComponentManufacturing(43704, 43705);
                break;                
            case 45548: // Standup XL-Set Thukker Structure and Component Manufacturing Efficiency  
                initXLRigGroups.initStandupXLSetThukkerStructureAndComponentManufacturing(45548);
                break;                             
            case 37182: // Standup XL-Set Laboratory Optimization II  
            case 37183: // Standup XL-Set Laboratory Optimization I  
                initXLRigGroups.initStandupXLSetLaboratory(37182, 37183);
                break;
            default:
                System.out.println("Error " + typeId);
        }
    }
    
}
