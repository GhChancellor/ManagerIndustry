/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.unused.riv_v2;

import managerindustry.logic.structure.fakeRig.FakeRig;
import java.util.ArrayList;
import java.util.List;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.enumName.TierEnum;
import managerindustry.logic.manager.old.managerDB.ManagerDBEve_OLD;

/**
 *
 * @author lele
 */
public class RIG_V2 {
    protected enum RULE_BONUS{
        T1(0),
        T2(0),
        HI_SEC(2355), 
        LOW_SEC(2356),
        NULL_SEC(2357),
        RIG_TIME_EFFICIENCY(2593),
        RIG_MATERIAL_EFFICIENCY(2594),
        RIG_COST_BONUS(2595),
        CALIBRATION(1153);
        
        private final int code;
        
        private RULE_BONUS(int code) {
            this.code = code;
        }

        private int getCode() {
            return code;
        }
    }
    
    private List<FakeRig> rigCouples = new ArrayList<>();    

    public RIG_V2() {
        initDbBackUp();
        
        int value = getDbBackup(TierEnum.T1, RULE_BONUS.RIG_COST_BONUS);
        System.out.println(""+ value);
    }
    
    /**
    * Create DB
    * Manufacturing Material Efficiency T1 43920 - 37156 / T2 43921 - 37157
    * Manufacturing Time Efficiency T1 37160 - 37148 / T2 37161 - 37149
    * Cost Optimization T1 43891 - 43885 / T2 43884 - 43890
    */
    private void initDbBackUp(){
//        // Manufacturing Material Efficiency T1
//        rigCouples.add(new RigBackUp(43920, 37156, TierEnum.T1, RULE_BONUS.RIG_MATERIAL_EFFICIENCY));        
//        // Manufacturing Material Efficiency T2
//        rigCouples.add(new RigBackUp(43921, 37156, TierEnum.T2, RULE_BONUS.RIG_MATERIAL_EFFICIENCY));
//        
//        // Manufacturing Time Efficiency T1
//        rigCouples.add(new RigBackUp(37160, 37148, TierEnum.T1, RULE_BONUS.RIG_TIME_EFFICIENCY));        
//        // Manufacturing Time Efficiency T2
//        rigCouples.add(new RigBackUp(37161, 37149, TierEnum.T2, RULE_BONUS.RIG_TIME_EFFICIENCY)) ;
//        
//        // Cost Optimization T1
//        rigCouples.add(new RigBackUp(43891, 43885, TierEnum.T1, RULE_BONUS.RIG_COST_BONUS));         
//        // Cost Optimization T2
//        rigCouples.add(new RigBackUp(43884, 43890, TierEnum.T2, RULE_BONUS.RIG_COST_BONUS));         
    }
    
    /**
     * Take a value of rig t1 or t2
     */
    private int getDbBackup(TierEnum tier, RULE_BONUS typeBonus){
//        for (RigBackUp rigCouple : rigCouples) {
//            if ( rigCouple.getTier() == tier && rigCouple.getRule_bonus() == typeBonus ){
//                InvTypes invTypes = ManagerDBEve.getInstance().getInvTypes_NameById(rigCouple.getId());
//
//                if ( invTypes != null ){
//                    return invTypes.getTypeID();
//                }
//                invTypes = ManagerDBEve.getInstance().getInvTypes_NameById(rigCouple.getIdBackUp());
//                return invTypes.getTypeID();
//            }
//        }
        return -33333;
    }
}
/*
        // Manufacturing Material Efficiency T1
        dbBackups.add(43920); // 0 - T1 
        dbBackups.add(37156); // 1 - T1 backup
        // Manufacturing Material Efficiency T2
        dbBackups.add(43921); // 2 - T2 
        dbBackups.add(37157); // 3 - T2 backup
        
        // Manufacturing Time Efficiency T1
        dbBackups.add(37160); // 4 - T1 
        dbBackups.add(37148); // 5 - T1 backup
        // Manufacturing Time Efficiency T2
        dbBackups.add(37161); // 6 - T2 
        dbBackups.add(37149); // 7 - T2 backup
        
        // Cost Optimization T1
        dbBackups.add(43891); // 8 - T1 
        dbBackups.add(43885); // 9 - T1 backup
        // Cost Optimization T2
        dbBackups.add(43884); // 10 - T2 
        dbBackups.add(43890); // 11 - T2 backup
*/