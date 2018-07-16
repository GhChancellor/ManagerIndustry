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
     * @return getEffectEngineeringRig
     */
    public boolean isEffectEngineeringRig(int typeID, int effectID){
        EffectEngineeringRigs engineeringRigs = new EffectEngineeringRigs();
        
        if (engineeringRigs.getEffectEngineeringRig(typeID, effectID) == null ){
            return false;
        }
        
        return true;
    }
    
    /**
     * Is exits?
     * @param typeID
     * @return boolean
     */
    public boolean isExits(int typeID){
        EffectEngineeringRigs engineeringRigs = new EffectEngineeringRigs();
        if (engineeringRigs.getEffectEngineeringRig(typeID) == null ){
            return false;
        }
        
        return true;
    }
    
    /**
     * Init and add to db if not exits
     * @param typeId 
     */
    public ChooseRig(int typeId) {
        if ( isExits(typeId) )
            return;
            
        switch (typeId){
            case 43920: // Standup M-Set Equipment Manufacturing Material Efficiency I
            case 43921: // Standup M-Set Equipment Manufacturing Material Efficiency II
            case 37160: // Standup M-Set Equipment Manufacturing Time Efficiency I
            case 37161: // Standup M-Set Equipment Manufacturing Time Efficiency II
                initMediumRigGroups.initStandupMSetEquipmentManufacturing(typeId);
                break;
            case 43867: // Standup M-Set Advanced Component Manufacturing Material Efficiency I
            case 43866: // Standup M-Set Advanced Component Manufacturing Material Efficiency II
            case 43869: // Standup M-Set Advanced Component Manufacturing Time Efficiency I
            case 43868: // Standup M-Set Advanced Component Manufacturing Time Efficiency II  
                initMediumRigGroups.initStandupMSetAdvancedComponentManufacturing(typeId);
                break;
            case 43862: // Standup M-Set Advanced Large Ship Manufacturing Material Efficiency I
            case 43863: // Standup M-Set Advanced Large Ship Manufacturing Material Efficiency II
            case 43865: // Standup M-Set Advanced Large Ship Manufacturing Time Efficiency I
            case 43864: // Standup M-Set Advanced Large Ship Manufacturing Time Efficiency II
                initMediumRigGroups.initStandupMSetAdvancedLargeShipManufacturing(typeId);
                break;
            case 43858: // Standup M-Set Advanced Medium Ship Manufacturing Material Efficiency I
            case 43859: // Standup M-Set Advanced Medium Ship Manufacturing Material Efficiency II
            case 43860: // Standup M-Set Advanced Medium Ship Manufacturing Time Efficiency I
            case 43861: // Standup M-Set Advanced Medium Ship Manufacturing Time Efficiency II
                initMediumRigGroups.initStandupMSetAdvancedMediumShipManufacturing(typeId);
                break;
            case 43855: // Standup M-Set Advanced Small Ship Manufacturing Material Efficiency I
            case 43854: // Standup M-Set Advanced Small Ship Manufacturing Material Efficiency II
            case 43856: // Standup M-Set Advanced Small Ship Manufacturing Time Efficiency I
            case 43857: // Standup M-Set Advanced Small Ship Manufacturing Time Efficiency II
                initMediumRigGroups.initStandupMSetAdvancedSmallShipManufacturing(typeId);
                break;
            case 37158: // Standup M-Set Ammunition Manufacturing Material Efficiency I
            case 37159: // Standup M-Set Ammunition Manufacturing Material Efficiency II
            case 37150: // Standup M-Set Ammunition Manufacturing Time Efficiency I
            case 37151: // Standup M-Set Ammunition Manufacturing Time Efficiency II
                initMediumRigGroups.initStandupMSetAmmunitionManufacturing(typeId);
                break;
            case 43870: // Standup M-Set Basic Capital Component Manufacturing Material Efficiency I
            case 43871: // Standup M-Set Basic Capital Component Manufacturing Material Efficiency II
            case 43872: // Standup M-Set Basic Capital Component Manufacturing Time Efficiency I
            case 43873: // Standup M-Set Basic Capital Component Manufacturing Time Efficiency II
                initMediumRigGroups.initStandupMSetBasicCapitalComponentManufacturing(typeId);
                break;
            case 43732: // Standup M-Set Basic Large Ship Manufacturing Material Efficiency I
            case 37152: // Standup M-Set Basic Large Ship Manufacturing Material Efficiency II
            case 43733: // Standup M-Set Basic Large Ship Manufacturing Time Efficiency I
            case 43734: // Standup M-Set Basic Large Ship Manufacturing Time Efficiency II
                initMediumRigGroups.initStandupMSetBasicLargeShipManufacturing(typeId);
                break;
            case 37146: // Standup M-Set Basic Medium Ship Manufacturing Material Efficiency I
            case 37147: // Standup M-Set Basic Medium Ship Manufacturing Material Efficiency II
            case 43919: // Standup M-Set Basic Medium Ship Manufacturing Time Efficiency I
            case 37153: // Standup M-Set Basic Medium Ship Manufacturing Time Efficiency II
                initMediumRigGroups.initStandupMSetBasicMediumShipManufacturing(typeId);
                break;
            case 37154: // Standup M-Set Basic Small Ship Manufacturing Material Efficiency I
            case 37155: // Standup M-Set Basic Small Ship Manufacturing Material Efficiency II
            case 37162: // Standup M-Set Basic Small Ship Manufacturing Time Efficiency I
            case 37163: // Standup M-Set Basic Small Ship Manufacturing Time Efficiency II
                initMediumRigGroups.initStandupMSetBasicSmallShipManufacturing(typeId);
                break;
            case 37156: // Standup M-Set Drone and Fighter Manufacturing Material Efficiency I
            case 37157: // Standup M-Set Drone and Fighter Manufacturing Material Efficiency II
            case 37148: // Standup M-Set Drone and Fighter Manufacturing Time Efficiency I
            case 37149: // Standup M-Set Drone and Fighter Manufacturing Time Efficiency II
                initMediumRigGroups.initStandupMSetDroneAndFighterManufacturing(typeId);
                break;
            case 43875: // Standup M-Set Structure Manufacturing Material Efficiency I
            case 43874: // Standup M-Set Structure Manufacturing Material Efficiency II
            case 43876: // Standup M-Set Structure Manufacturing Time Efficiency I
            case 43877: // Standup M-Set Structure Manufacturing Time Efficiency II
                initMediumRigGroups.initStandupMSetStructureManufacturing(typeId);
                break;
            case 45640: // Standup M-Set Thukker Advanced Component Manufacturing Material Efficiency
                initMediumRigGroups.initStandupMSetThukkerAdvancedComponentManufacturing(typeId);
                break;
            case 45544: // Standup M-Set Thukker Basic Capital Component Manufacturing Material Efficiency 
                initMediumRigGroups.initStandupMSetThukkerBasicCapitalComponentManufacturing(typeId);
                break;
            case 43893: // Standup M-Set Blueprint Copy Accelerator I
            case 43892: // Standup M-Set Blueprint Copy Accelerator II
            case 43891: // Standup M-Set Blueprint Copy Cost Optimization I
            case 43890: // Standup M-Set Blueprint Copy Cost Optimization II
                initMediumRigGroups.initStandupMSetBlueprintCopy(typeId);
                break;
            case 43880: // Standup M-Set Invention Accelerator I
            case 43881: // Standup M-Set Invention Accelerator II
            case 43879: // Standup M-Set Invention Cost Optimization I
            case 43878: // Standup M-Set Invention Cost Optimization II
                initMediumRigGroups.initStandupMSetInvention(typeId);
                break;
            case 43883: // Standup M-Set ME Research Accelerator I
            case 43882: // Standup M-Set ME Research Accelerator II
            case 43885: // Standup M-Set ME Research Cost Optimization I
            case 43884: // Standup M-Set ME Research Cost Optimization II
                initMediumRigGroups.initStandupMSetMEResearch(typeId);
                break;
            case 43889: // Standup M-Set TE Research Accelerator I
            case 43888: // Standup M-Set TE Research Accelerator II
            case 43887: // Standup M-Set TE Research Cost Optimization I
            case 43886: // Standup M-Set TE Research Cost Optimization II
                initMediumRigGroups.initStandupMSetTEResearch(typeId);
                break;
            case 37164: // Standup L-Set Ammunition Manufacturing Efficiency I 
            case 37165: // Standup L-Set Ammunition Manufacturing Efficiency II
                initLargeRigGroups.initStandupLSetAmmunitionManufacturing(typeId);
                break;                
            case 37166: // Standup L-Set Basic Large Ship Manufacturing Efficiency I 
            case 37167: // Standup L-Set Basic Large Ship Manufacturing Efficiency II  
                initLargeRigGroups.initStandupLSetBasicLargeShipManufacturing(typeId);
                break;                
            case 37168: // Standup L-Set Advanced Large Ship Manufacturing Efficiency I 
            case 37169: // Standup L-Set Advanced Large Ship Manufacturing Efficiency II  
                initLargeRigGroups.initStandupLSetAdvancedLargeShipManufacturing(typeId);
                break;                
            case 37170: // Standup L-Set Equipment Manufacturing Efficiency I
            case 37171: // Standup L-Set Equipment Manufacturing Efficiency II
                initLargeRigGroups.initStandupLSetEquipmentManufacturing(typeId);
                break;                
            case 37172: // Standup L-Set Capital Ship Manufacturing Efficiency II  
            case 37173: // Standup L-Set Capital Ship Manufacturing Efficiency I
                initLargeRigGroups.initStandupLSetCapitalShipManufacturing(typeId);
                break;                
            case 37174: // Standup L-Set Advanced Component Manufacturing Efficiency I  
            case 37175: // Standup L-Set Advanced Component Manufacturing Efficiency II 
                initLargeRigGroups.initStandupLSetAdvancedComponentManufacturing(typeId);
                break;                
            case 43707: // Standup L-Set Advanced Small Ship Manufacturing Efficiency I 
            case 43708: // Standup L-Set Advanced Small Ship Manufacturing Efficiency II
                initLargeRigGroups.initStandupLSetAdvancedSmallShipManufacturing(typeId);
                break;                
            case 43709: // Standup L-Set Advanced Medium Ship Manufacturing Efficiency I 
            case 43711: // Standup L-Set Advanced Medium Ship Manufacturing Efficiency II  
                initLargeRigGroups.initStandupLSetAdvancedMediumShipManufacturing(typeId);
                break;                
            case 43712: // Standup L-Set Drone and Fighter Manufacturing Efficiency I  
            case 43713: // Standup L-Set Drone and Fighter Manufacturing Efficiency II 
                initLargeRigGroups.initStandupLSetDroneAndFighterManufacturing(typeId);
                break;                
            case 43714: // Standup L-Set Basic Small Ship Manufacturing Efficiency I 
            case 43715: // Standup L-Set Basic Small Ship Manufacturing Efficiency II  
                initLargeRigGroups.initStandupLSetBasicSmallShipManufacturing(typeId);
                break;                
            case 43716: // Standup L-Set Basic Medium Ship Manufacturing Efficiency I 
            case 43717: // Standup L-Set Basic Medium Ship Manufacturing Efficiency II 
                initLargeRigGroups.initStandupLSetBasicMediumShipManufacturing(typeId);
                break;                
            case 43718: // Standup L-Set Basic Capital Component Manufacturing Efficiency I 
            case 43719: // Standup L-Set Basic Capital Component Manufacturing Efficiency II 
                initLargeRigGroups.initStandupLSetBasicCapitalComponentManufacturing(typeId);
                break;                
            case 43720: // Standup L-Set Structure Manufacturing Efficiency I  
            case 43721: // Standup L-Set Structure Manufacturing Efficiency II  
                initLargeRigGroups.initStandupLSetStructureManufacturing(typeId);
                break;                
            case 45546: // Standup L-Set Thukker Basic Capital Component Manufacturing Efficiency
                initLargeRigGroups.initStandupLSetThukkerBasicCapitalComponentManufacturing(typeId);
                break;                
            case 45641: // Standup L-Set Thukker Advanced Component Manufacturing Efficiency  
                initLargeRigGroups.initStandupLSetThukkerAdvancedComponentManufacturing(typeId);
                break;
            case 43722: // Standup L-Set Invention Optimization I  
            case 43723: // Standup L-Set Invention Optimization II 
                initLargeRigGroups.initStandupLSetInvention(typeId);
                break;
            case 43724: // Standup L-Set ME Research Optimization I
            case 43725: // Standup L-Set ME Research Optimization II
                initLargeRigGroups.initStandupLSetMEResearch(typeId);
                break;
            case 43726: // Standup L-Set TE Research Optimization I 
            case 43727: // Standup L-Set TE Research Optimization II 
                initLargeRigGroups.initStandupLSetTEResearch(typeId);
                break;
            case 43729: // Standup L-Set Blueprint Copy Optimization I 
            case 43730: // Standup L-Set Blueprint Copy Optimization II 
                initLargeRigGroups.initStandupLSetBlueprintCopy(typeId);
                break;
            case 37178: // Standup XL-Set Equipment and Consumable Manufacturing Efficiency I 
            case 37179: // Standup XL-Set Equipment and Consumable Manufacturing Efficiency II
                initXLRigGroups.initStandupXLSetEquipmentAndConsumableManufacturing(typeId);
                break;                
            case 37180: // Standup XL-Set Ship Manufacturing Efficiency I
            case 37181: // Standup XL-Set Ship Manufacturing Efficiency II  
                initXLRigGroups.initStandupXLSetShipManufacturing(typeId);
                break;                
            case 43704: // Standup XL-Set Structure and Component Manufacturing Efficiency I 
            case 43705: // Standup XL-Set Structure and Component Manufacturing Efficiency II 
                initXLRigGroups.initStandupXLSetStructureAndComponentManufacturing(typeId);
                break;                
            case 45548: // Standup XL-Set Thukker Structure and Component Manufacturing Efficiency  
                initXLRigGroups.initStandupXLSetThukkerStructureAndComponentManufacturing(typeId);
                break;                             
            case 37182: // Standup XL-Set Laboratory Optimization II  
            case 37183: // Standup XL-Set Laboratory Optimization I  
                initXLRigGroups.initStandupXLSetLaboratory(typeId);
                break;
            default:
                System.out.println("Error " + typeId);
        }
    }
    
//    public enum engineeringRigIdEnum{
//        M_EQUIPMENT_ME_1(43920), // Standup M-Set Equipment Manufacturing Material Efficiency I
//        M_EQUIPMENT_ME_2(43921), // Standup M-Set Equipment Manufacturing Material Efficiency II
//        M_EQUIPMENT_TE_1(37160), // Standup M-Set Equipment Manufacturing Time Efficiency I
//        M_EQUIPMENT_TE_2(37161), // Standup M-Set Equipment Manufacturing Time Efficiency II
//        
//        M_ADVANCED_COMPONENT_ME_1(43867), // Standup M-Set Advanced Component Manufacturing Material Efficiency I
//        M_ADVANCED_COMPONENT_ME_2(43866), // Standup M-Set Advanced Component Manufacturing Material Efficiency II
//        M_ADVANCED_COMPONENT_TE_1(43869), // Standup M-Set Advanced Component Manufacturing Time Efficiency I
//        M_ADVANCED_COMPONENT_TE_2(43868), // Standup M-Set Advanced Component Manufacturing Time Efficiency II
//
//        M_ADVANCED_LARGE_SHIP_ME_1(43862), // Standup M-Set Advanced Large Ship Manufacturing Material Efficiency I
//        M_ADVANCED_LARGE_SHIP_ME_2(43863), // Standup M-Set Advanced Large Ship Manufacturing Material Efficiency II
//        M_ADVANCED_LARGE_SHIP_TE_1(43865), // Standup M-Set Advanced Large Ship Manufacturing Time Efficiency I
//        M_ADVANCED_LARGE_SHIP_TE_2(43864), // Standup M-Set Advanced Large Ship Manufacturing Time Efficiency II
//
//        M_ADVANCED_MEDIUM_SHIP_ME_1(43858), // Standup M-Set Advanced Medium Ship Manufacturing Material Efficiency I
//        M_ADVANCED_MEDIUM_SHIP_ME_2(43859), // Standup M-Set Advanced Medium Ship Manufacturing Material Efficiency II
//        M_ADVANCED_MEDIUM_SHIP_TE_1(43860), // Standup M-Set Advanced Medium Ship Manufacturing Time Efficiency I
//        M_ADVANCED_MEDIUM_SHIP_TE_2(43861), // Standup M-Set Advanced Medium Ship Manufacturing Time Efficiency II
//
//        M_ADVANCED_SMALL_SHIP_ME_1(43855), // Standup M-Set Advanced Small Ship Manufacturing Material Efficiency I
//        M_ADVANCED_SMALL_SHIP_ME_2(43854), // Standup M-Set Advanced Small Ship Manufacturing Material Efficiency II
//        M_ADVANCED_SMALL_SHIP_TE_1(43856), // Standup M-Set Advanced Small Ship Manufacturing Time Efficiency I
//        M_ADVANCED_SMALL_SHIP_TE_2(43857), // Standup M-Set Advanced Small Ship Manufacturing Time Efficiency II
//
//        M_AMMUNITION_ME_1(37158), // Standup M-Set Ammunition Manufacturing Material Efficiency I
//        M_AMMUNITION_ME_2(37159), // Standup M-Set Ammunition Manufacturing Material Efficiency II
//        M_AMMUNITION_TE_1(37150), // Standup M-Set Ammunition Manufacturing Time Efficiency I
//        M_AMMUNITION_TE_2(37151), // Standup M-Set Ammunition Manufacturing Time Efficiency II
//        
//        M_BASIC_CAPITAL_COMPONENT_ME_1(43870), // Standup M-Set Basic Capital Component Manufacturing Material Efficiency I
//        M_BASIC_CAPITAL_COMPONENT_ME_2(43871), // Standup M-Set Basic Capital Component Manufacturing Material Efficiency II
//        M_BASIC_CAPITAL_COMPONENT_TE_1(43872), // Standup M-Set Basic Capital Component Manufacturing Time Efficiency I
//        M_BASIC_CAPITAL_COMPONENT_TE_2(43873), // Standup M-Set Basic Capital Component Manufacturing Time Efficiency II
//
//        M_BASIC_LARGE_SHIP_ME_1(43732), // Standup M-Set Basic Large Ship Manufacturing Material Efficiency I
//        M_BASIC_LARGE_SHIP_ME_2(37152), // Standup M-Set Basic Large Ship Manufacturing Material Efficiency II
//        M_BASIC_LARGE_SHIP_TE_1(43733), // Standup M-Set Basic Large Ship Manufacturing Time Efficiency I
//        M_BASIC_LARGE_SHIP_TE_2(43734), // Standup M-Set Basic Large Ship Manufacturing Time Efficiency II
//
//        M_BASIC_MEDIUM_SHIP_ME_1(37146), // Standup M-Set Basic Medium Ship Manufacturing Material Efficiency I
//        M_BASIC_MEDIUM_SHIP_ME_2(37147), // Standup M-Set Basic Medium Ship Manufacturing Material Efficiency II
//        M_BASIC_MEDIUM_SHIP_T1(43919), // Standup M-Set Basic Medium Ship Manufacturing Time Efficiency I
//        M_BASIC_MEDIUM_SHIP_TE_2(37153), // Standup M-Set Basic Medium Ship Manufacturing Time Efficiency II
//
//        M_BASIC_SMALL_SHIP_ME_1(37154), // Standup M-Set Basic Small Ship Manufacturing Material Efficiency I
//        M_BASIC_SMALL_SHIP_ME_2(37155), // Standup M-Set Basic Small Ship Manufacturing Material Efficiency II
//        M_BASIC_SMALL_SHIP_T1(37162), // Standup M-Set Basic Small Ship Manufacturing Time Efficiency I
//        M_BASIC_SMALL_SHIP_TE_2(37163), // Standup M-Set Basic Small Ship Manufacturing Time Efficiency II
//
//        M_DRONE_FIGHTER_ME_1(37156), // Standup M-Set Drone and Fighter Manufacturing Material Efficiency I
//        M_DRONE_FIGHTER_ME_2(37157), // Standup M-Set Drone and Fighter Manufacturing Material Efficiency II
//        M_DRONE_FIGHTER_TE_1(37148), // Standup M-Set Drone and Fighter Manufacturing Time Efficiency I
//        M_DRONE_FIGHTER_TE_2(37149), // Standup M-Set Drone and Fighter Manufacturing Time Efficiency II
//        
//        M_STRUCTURE_ME_1(43875), // Standup M-Set Structure Manufacturing Material Efficiency I
//        M_STRUCTURE_ME_2 (43874), // Standup M-Set Structure Manufacturing Material Efficiency II
//        M_STRUCTURE_TE_1(43876), // Standup M-Set Structure Manufacturing Time Efficiency I
//        M_STRUCTURE_TE_2 (43877), // Standup M-Set Structure Manufacturing Time Efficiency II
//
//        M_THUKKER_ADVANCED_COMPONENT(45640), // Standup M-Set Thukker Advanced Component Manufacturing Material Efficiency        
//        M_THUKKER_BASIC_CAPITAL(45544), // Standup M-Set Thukker Basic Capital Component Manufacturing Material Efficiency
//        
//        M_BLUEPRINT_COPY_ACCELERATOR_1(43893), // Standup M-Set Blueprint Copy Accelerator I
//        M_BLUEPRINT_COPY_ACCELERATOR_2(43892), // Standup M-Set Blueprint Copy Accelerator II
//        M_BLUEPRINT_COST_OPTIMIZATION_1(43891), // Standup M-Set Blueprint Copy Cost Optimization I
//        M_BLUEPRINT_COST_OPTIMIZATION_2(43890), // Standup M-Set Blueprint Copy Cost Optimization II
//
//        M_BLUEPRINT_INVENTION_ACCELERATOR_1(43880), // Standup M-Set Invention Accelerator I
//        M_BLUEPRINT_INVENTION_ACCELERATOR_2(43881), // Standup M-Set Invention Accelerator II
//        M_BLUEPRINT_INVENTION_COST_OPTIMIZATION_1(43879), // Standup M-Set Invention Cost Optimization I
//        M_BLUEPRINT_INVENTION_COST_OPTIMIZATION_2(43878), // Standup M-Set Invention Cost Optimization II
//
//        M_RESEARCH_ACCELERATOR_ME_1(43883), // Standup M-Set ME Research Accelerator I
//        M_RESEARCH_COPY_ACCELERATOR_ME_2(43882), // Standup M-Set ME Research Accelerator II
//        M_RESEARCH_COST_OPTIMIZATION_ME_1(43885), // Standup M-Set ME Research Cost Optimization I
//        M_RESEARCH_COST_OPTIMIZATION_ME_2(43884), // Standup M-Set ME Research Cost Optimization II
//
//        M_RESEARCH_ACCELERATOR_TE_1(43889), // Standup M-Set TE Research Accelerator I
//        M_RESEARCH_ACCELERATOR_TE_2(43888), // Standup M-Set TE Research Accelerator II
//        M_RESEARCH_COST_OPTIMIZATION_TE_1(43887), // Standup M-Set TE Research Cost Optimization I
//        M_RESEARCH_COST_OPTIMIZATION_TE_2(43886), // Standup M-Set TE Research Cost Optimization II        
//        
//             (37164), // Standup L-Set Ammunition Manufacturing Efficiency I 
//             (37165), // Standup L-Set Ammunition Manufacturing Efficiency II
//                                
//             (37166), // Standup L-Set Basic Large Ship Manufacturing Efficiency I 
//             (37167), // Standup L-Set Basic Large Ship Manufacturing Efficiency II  
//
//                                
//             (37168), // Standup L-Set Advanced Large Ship Manufacturing Efficiency I 
//             (37169), // Standup L-Set Advanced Large Ship Manufacturing Efficiency II  
//   
//                                
//             (37170), // Standup L-Set Equipment Manufacturing Efficiency I
//             (37171), // Standup L-Set Equipment Manufacturing Efficiency II
//  
//                                
//             (37172), // Standup L-Set Capital Ship Manufacturing Efficiency II  
//             (37173), // Standup L-Set Capital Ship Manufacturing Efficiency I
// 
//                                
//             (37174), // Standup L-Set Advanced Component Manufacturing Efficiency I  
//             (37175), // Standup L-Set Advanced Component Manufacturing Efficiency II 
//                               
//             (43707), // Standup L-Set Advanced Small Ship Manufacturing Efficiency I 
//             (43708), // Standup L-Set Advanced Small Ship Manufacturing Efficiency II
//
//                                
//             (43709), // Standup L-Set Advanced Medium Ship Manufacturing Efficiency I 
//             (43711), // Standup L-Set Advanced Medium Ship Manufacturing Efficiency II  
//
//                                
//             (43712), // Standup L-Set Drone and Fighter Manufacturing Efficiency I  
//             (43713), // Standup L-Set Drone and Fighter Manufacturing Efficiency II 
//
//                                
//             (43714), // Standup L-Set Basic Small Ship Manufacturing Efficiency I 
//             (43715), // Standup L-Set Basic Small Ship Manufacturing Efficiency II  
//
//                                
//             (43716), // Standup L-Set Basic Medium Ship Manufacturing Efficiency I 
//             (43717), // Standup L-Set Basic Medium Ship Manufacturing Efficiency II 
//
//                                
//             (43718), // Standup L-Set Basic Capital Component Manufacturing Efficiency I 
//             (43719), // Standup L-Set Basic Capital Component Manufacturing Efficiency II 
//
//                                
//             (43720), // Standup L-Set Structure Manufacturing Efficiency I  
//             (43721), // Standup L-Set Structure Manufacturing Efficiency II  
//
//                                
//             (45546), // Standup L-Set Thukker Basic Capital Component Manufacturing Efficiency
//
//                                
//             (45641), // Standup L-Set Thukker Advanced Component Manufacturing Efficiency  
//                
//             (43722), // Standup L-Set Invention Optimization I  
//             (43723), // Standup L-Set Invention Optimization II 
//                
//             (43724), // Standup L-Set ME Research Optimization I
//             (43725), // Standup L-Set ME Research Optimization II
//                
//             (43726), // Standup L-Set TE Research Optimization I 
//             (43727), // Standup L-Set TE Research Optimization II 
//                
//             (43729), // Standup L-Set Blueprint Copy Optimization I 
//             (43730), // Standup L-Set Blueprint Copy Optimization II 
//                  
//             (37178), // Standup XL-Set Equipment and Consumable Manufacturing Efficiency I 
//             (37179), // Standup XL-Set Equipment and Consumable Manufacturing Efficiency II
//
//             (37180), // Standup XL-Set Ship Manufacturing Efficiency I
//             (37181), // Standup XL-Set Ship Manufacturing Efficiency II  
//                                
//             (43704), // Standup XL-Set Structure and Component Manufacturing Efficiency I 
//             (43705), // Standup XL-Set Structure and Component Manufacturing Efficiency II 
//                                
//             (45548)), // Standup XL-Set Thukker Structure and Component Manufacturing Efficiency  
//                                             
//             (37182)), // Standup XL-Set Laboratory Optimization II  
//             (37183)), // Standup XL-Set Laboratory Optimization I  
//
//                
//        
//        FINE(0); 
//        
//        private int typeId;
//
//        private engineeringRigIdEnum(int typeId) {
//            this.typeId = typeId;
//        }
//        
//        public int getTypeId() {
//            return typeId;
//        }
//
//    }
}   

