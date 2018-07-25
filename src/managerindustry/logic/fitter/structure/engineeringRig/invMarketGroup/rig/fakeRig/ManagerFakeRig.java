/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.fakeRig;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.enumName.RuleBonusRigEnum;
import managerindustry.logic.enumName.SecurityStatusEnum;
import managerindustry.logic.enumName.TierEnum;
import managerindustry.logic.exception.ErrorExeption;
import managerindustry.logic.manager.Manager;
import managerindustry.logic.manager.managerDB.Db;

/**
 *
 * @author lele
 */
public class ManagerFakeRig {
    private List<FakeRig> rigCouples = new ArrayList<>();   
    
    /**
     * Converte un enum security status ( generico ) in un valore leggibile per la classe
     * @param SecurityStatusEnum securityStatusEnum
     * @return RuleBonusRigEnum
     */
    public RuleBonusRigEnum securityStatus(SecurityStatusEnum securityStatusEnum){
        switch ( securityStatusEnum ){
            case HI_SEC:
                return RuleBonusRigEnum.HI_SEC;
            case LOW_SEC:
                return RuleBonusRigEnum.LOW_SEC;
            case NULL_SEC:
                return RuleBonusRigEnum.NULL_SEC;
            default:
//                ManagerErrorExecption.getErrorExecption(ErrorExeption.ErrorExeptionEnum.SECURITY_STATUS_ERROR);
                System.out.println("" + ErrorExeption.ErrorExeptionEnum.SECURITY_STATUS_ERROR );
                return null;
        }
    }    

    public ManagerFakeRig() {
        initDbBackUp();
    }
            
    /**
    * Create DB
    * Manufacturing Material Efficiency T1 43920 - 37156 / T2 43921 - 37157
    * Manufacturing Time Efficiency T1 37160 - 37148 / T2 37161 - 37149
    * Cost Optimization T1 43891 - 43885 / T2 43884 - 43890
    */
    private void initDbBackUp(){
        // Manufacturing Material Efficiency T1
        rigCouples.add(new FakeRig(43920, 37156, TierEnum.T1, RuleBonusRigEnum.RIG_MATERIAL_EFFICIENCY));        
        // Manufacturing Material Efficiency T2
        rigCouples.add(new FakeRig(43921, 37156, TierEnum.T2, RuleBonusRigEnum.RIG_MATERIAL_EFFICIENCY));
        
        // Manufacturing Time Efficiency T1
        rigCouples.add(new FakeRig(37160, 37148, TierEnum.T1, RuleBonusRigEnum.RIG_TIME_EFFICIENCY));        
        // Manufacturing Time Efficiency T2
        rigCouples.add(new FakeRig(37161, 37149, TierEnum.T2, RuleBonusRigEnum.RIG_TIME_EFFICIENCY)) ;
        
        // Cost Optimization T1
        rigCouples.add(new FakeRig(43891, 43885, TierEnum.T1, RuleBonusRigEnum.RIG_COST_BONUS));         
        // Cost Optimization T2
        rigCouples.add(new FakeRig(43884, 43890, TierEnum.T2, RuleBonusRigEnum.RIG_COST_BONUS));         
    }
    
    /**
     * Take a value of rig t1 or t2
     * @param TierEnum tier
     * @param RuleBonusRigEnum typeBonus
     * @return 
     */
    public int getFakeRig(TierEnum tier, RuleBonusRigEnum typeBonus){
        for (FakeRig rigCouple : rigCouples) {
            if ( rigCouple.getTier() == tier && rigCouple.getRule_bonus() == typeBonus ){
                Integer typeId = Manager.getInstance().db().invTypes().getInvTypesById(rigCouple.getId()).getTypeID();

                if ( typeId != null ){
                    return typeId;
                }
                
                typeId = Manager.getInstance().db().invTypes().getInvTypesById(rigCouple.getId()).getTypeID();
                return typeId;
            }
        }
        return -33333;
    }    
}
