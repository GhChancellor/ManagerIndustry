/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig;

import managerindustry.db.entities.cache.EffectRigEntity;
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
     * @return EffectRigEntity
     */
    public EffectRigEntity getEffectRig(int typeID, int effectID){
        EffectEngineeringRigs engineeringRigs = new EffectEngineeringRigs();
        return engineeringRigs.getEffectRig(typeID, effectID);
    }
    
    public ChooseRig(int typeId) {
        if (ManagerDB.getInstance().invTypes().getInvTypesById(typeId).equals(typeId))
            return;
        
        switch (typeId){
            case 43920:
            case 43921:
            case 37160:
            case 37161:
                initMediumRigGroups.initStandupMSetEquipmentManufacturing();
                break;
            case 43867:
            case 43866:
            case 43869:
            case 43868:
                initMediumRigGroups.initStandupMSetAdvancedComponentManufacturing();
                break;
            case 43862:
            case 43863:
            case 43865:
            case 43864:
                initMediumRigGroups.initStandupMSetAdvancedLargeShipManufacturing();
                break;
            case 43858:
            case 43859:
            case 43860:
            case 43861:
                initMediumRigGroups.initStandupMSetAdvancedMediumShipManufacturing();
                break;
            case 43855:
            case 43854:
            case 43856:
            case 43857:
                initMediumRigGroups.initStandupMSetAdvancedSmallShipManufacturing();
                break;
            case 37158:
            case 37159:
            case 37150:
            case 37151:
                initMediumRigGroups.initStandupMSetAmmunitionManufacturing();
                break;
            case 43870:
            case 43871:
            case 43872:
            case 43873:
                initMediumRigGroups.initStandupMSetBasicCapitalComponentManufacturing();
                break;
            case 43732:
            case 37152:
            case 43733:
            case 43734:
                initMediumRigGroups.initStandupMSetBasicLargeShipManufacturing();
                break;
            case 37146:
            case 37147:
            case 43919:
            case 37153:
                initMediumRigGroups.initStandupMSetBasicMediumShipManufacturing();
                break;
            case 37154:
            case 37155:
            case 37162:
            case 37163:
                initMediumRigGroups.initStandupMSetBasicSmallShipManufacturing();
                break;
            case 37156:
            case 37157:
            case 37148:
            case 37149:
                initMediumRigGroups.initStandupMSetDroneAndFighterManufacturing();
                break;
            case 43875:
            case 43874:
            case 43876:
            case 43877:
                initMediumRigGroups.initStandupMSetStructureManufacturing();
                break;
            case 45640:
                initMediumRigGroups.initStandupMSetThukkerAdvancedComponentManufacturing();
                break;
            case 45544:
                initMediumRigGroups.initStandupMSetThukkerBasicCapitalComponentManufacturing();
                break;
            case 43893:
            case 43892:
            case 43891:
            case 43890:
                initMediumRigGroups.initStandupMSetBlueprintCopy();
                break;
            case 43880:
            case 43881:
            case 43879:
            case 43878:
                initMediumRigGroups.initStandupMSetInvention();
                break;
            case 43883:
            case 43882:
            case 43885:
            case 43884:
                initMediumRigGroups.initStandupMSetMEResearch();
                break;
            case 43889:
            case 43888:
            case 43887:
            case 43886:
                initMediumRigGroups.initStandupMSetTEResearch();
                break;
            case 37164:
            case 37165:
                initLargeRigGroups.initStandupLSetAmmunitionManufacturing();
                break;                
            case 37166:
            case 37167:
                initLargeRigGroups.initStandupLSetBasicLargeShipManufacturing();
                break;                
            case 37168:
            case 37169:
                initLargeRigGroups.initStandupLSetAdvancedLargeShipManufacturing();
                break;                
            case 37170:
            case 37171:
                initLargeRigGroups.initStandupLSetEquipmentManufacturing();
                break;                
            case 37172:
            case 37173:
                initLargeRigGroups.initStandupLSetCapitalShipManufacturing();
                break;                
            case 37174:
            case 37175:
                initLargeRigGroups.initStandupLSetAdvancedComponentManufacturing();
                break;                
            case 43707:
            case 43708:
                initLargeRigGroups.initStandupLSetAdvancedSmallShipManufacturing();
                break;                
            case 43709:
            case 43711:
                initLargeRigGroups.initStandupLSetAdvancedMediumShipManufacturing();
                break;                
            case 43712:
            case 43713:
                initLargeRigGroups.initStandupLSetDroneAndFighterManufacturing();
                break;                
            case 43714:
            case 43715:
                initLargeRigGroups.initStandupLSetBasicSmallShipManufacturing();
                break;                
            case 43716:
            case 43717:
                initLargeRigGroups.initStandupLSetBasicMediumShipManufacturing();
                break;                
            case 43718:
            case 43719:
                initLargeRigGroups.initStandupLSetBasicCapitalComponentManufacturing();
                break;                
            case 43720:
            case 43721:
                initLargeRigGroups.initStandupLSetStructureManufacturing();
                break;                
            case 45546:
                initLargeRigGroups.initStandupLSetThukkerBasicCapitalComponentManufacturing();
                break;                
            case 45641:
                initLargeRigGroups.initStandupLSetThukkerAdvancedComponentManufacturing();
                break;
            case 43722:
            case 43723:
                initLargeRigGroups.initStandupLSetInvention();
                break;
            case 43724:
            case 43725:
                initLargeRigGroups.initStandupLSetMEResearch();
                break;
            case 43726:
            case 43727:
                initLargeRigGroups.initStandupLSetTEResearch();
                break;
            case 43729:
            case 43730:
                initLargeRigGroups.initStandupLSetBlueprintCopy();
                break;
            case 37178:
            case 37179:
                initXLRigGroups.initStandupXLSetEquipmentAndConsumableManufacturing();
                break;                
            case 37180:
            case 37181:
                initXLRigGroups.initStandupXLSetShipManufacturing();
                break;                
            case 43704:
            case 43705:
                initXLRigGroups.initStandupXLSetStructureAndComponentManufacturing();
                break;                
            case 45548:
                initXLRigGroups.initStandupXLSetThukkerStructureAndComponentManufacturing();
                break;                             
            case 37182:
            case 37183:
                initXLRigGroups.initStandupXLSetLaboratory();
                break;
            default:
                System.out.println("Error " + typeId);
        }
    }
    
}