/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.riv_v2;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.manager.managerDB.ManagerDBEve;
import managerindustry.logic.structure.StructureEngineeringRigs;

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
    private List<Integer> dbBackups = new ArrayList<>();    

    public RIG_V2() {
        int value = dbBackup(RULE_BONUS.T1);
        System.out.println(""+ value);
    }
    
    private int dbBackup(RULE_BONUS rule_bonus){
        int count = 0;
        Integer idType;
        
        dbBackups.add(37160); // 0 - T1 
        dbBackups.add(37161); // 1 - T2
        dbBackups.add(43872); // 2 - T1 backup
        dbBackups.add(43873); // 3 - T2 backup

        // choose if T1 or T2
        if ( rule_bonus == RULE_BONUS.T1){
            count = 0;
        }else{
            count = 1;
        }
        
        // if object doesn't exit then take the backup
        if ( ManagerDBEve.getInstance().getInvTypes_NameById
            ( dbBackups.get(count) ) == null ){
            
            if ( rule_bonus == RULE_BONUS.T1 ) {
                count = 2;
            }else{
                count = 3;
            }
            
        }
            
        idType = ManagerDBEve.getInstance().getInvTypes_NameById
            ( dbBackups.get(count) ).getTypeID() ;    
                
        return idType; 
    }    
}
