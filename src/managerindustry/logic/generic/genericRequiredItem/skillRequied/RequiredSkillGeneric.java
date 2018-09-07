/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.generic.genericRequiredItem.skillRequied;

import java.util.List;
import java.util.Map;

/**
 *
 * @author lele
 */
public abstract class RequiredSkillGeneric < A, B > extends RequiredSkill{
    public abstract void display();
    public abstract Map < A, B > getMap();
    public abstract List < B > getList();
    public abstract A getRequiredMaterialObject();    
}
