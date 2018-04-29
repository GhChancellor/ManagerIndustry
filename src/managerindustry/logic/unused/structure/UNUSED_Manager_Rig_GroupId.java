/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.unused.structure;

import managerindustry.logic.unused.structure.rig_GroupId.UNUSED_Rig_GroupId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lele
 */
public class UNUSED_Manager_Rig_GroupId {
    private ArrayList<UNUSED_Rig_GroupId> arrayList = new ArrayList<>();
    
    public UNUSED_Manager_Rig_GroupId() {
        init();
        UNUSED_Rig_GroupId rig_GroupId00 = new UNUSED_Rig_GroupId();
        rig_GroupId00.setRig(37146);
        
        arrayList.forEach((t) -> {
            UNUSED_Rig_GroupId rig_GroupId = t;
            
            if ( rig_GroupId.getRig() == 37146)
                System.out.println("" + rig_GroupId.getGroup());
        });   
    }
    
    public void init(){
        // Standup M-Set basic medium ship manufacturing material efficiency I
        addList(37146, 419);
        addList(37146, 631);
        addList(37146, 28);
        addList(37146, 463); 
        
        // Standup M-Set basic medium ship manufacturing material efficiency II
        addList(37147, 419);
        addList(37147, 631);
        addList(37147, 28);
        addList(37147, 463); 
       
    }
    
    public void addList(int rigID, int groupId){
        UNUSED_Rig_GroupId rig_GroupId = new UNUSED_Rig_GroupId(rigID, groupId);
        arrayList.add(rig_GroupId);
    }

    public void allDB(){
//        // Standup M-Set Basic Medium Ship Manufacturing Time Efficiency I
//        addList(43919, 419);
//        addList(43919, 631);
//        addList(43919, 28);
//        addList(43919, 463); 
//        
//        // Standup M-Set Basic Medium Ship Manufacturing Time Efficiency II
//        addList(37153, 419);
//        addList(37153, 631);
//        addList(37153, 28);
//        addList(37153, 463); 
//        
//        // Standup M-Set Basic Large Ship Manufacturing Material Efficiency I
//        addList(43732, 941);
//        addList(43732, 27);
//        addList(43732, 513); 
//        
//        // Standup M-Set Basic Large Ship Manufacturing Material Efficiency II
//        addList(37152, 941);
//        addList(37152, 27);
//        addList(37152, 513); 
//        
//        // Standup M-Set Basic Large Ship Manufacturing Time Efficiency I
//        addList(43733, 941);
//        addList(43733, 27);
//        addList(43733, 513); 
//        
//        // Standup M-Set Basic Large Ship Manufacturing Time Efficiency II
//        addList(43734, 941);
//        addList(43734, 27);
//        addList(43734, 513);         
    }
}
