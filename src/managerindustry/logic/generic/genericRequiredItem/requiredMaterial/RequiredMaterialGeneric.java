/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.generic.genericRequiredItem.requiredMaterial;

import java.util.List;
import java.util.Map;
import managerindustry.logic.generic.nameBase.NameBase;

/**
 *
 * @author lele
 */
public abstract class RequiredMaterialGeneric extends RequiredMaterial{
    public abstract void display();
    public abstract Map < String, NameBase > getMap();
    public abstract List < NameBase > getList();
    public abstract NameBase getRequiredMaterialObject();
}
