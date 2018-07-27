/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV2;

import managerindustry.logic.enumName.RamActivitiesEnum;
import managerindustry.logic.exception.ErrorExeption;
import managerindustry.logic.manager.game.build.Build;

/**
 *
 * @author lele
 */
public class Main {

    public static void main(String[] args) throws ErrorExeption {
        String name ="drake";
        int run = 1;
        int job = 1;
        byte bpoMe = 1;
        byte componentMe = 1;
        
//        Build build = new Build(name, run, job, bpoMe, componentMe);
        
        Build_V2 build_V2 = new Build_V2(name, run, job, bpoMe, componentMe, RamActivitiesEnum.MANUFACTURING);
//        build_V2.displayBaseMaterialRequired();

    }
}
