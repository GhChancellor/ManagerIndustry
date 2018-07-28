/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV2;

/**
 *
 * @author lele
 */
public class RequiredItemsRecursionB_OLD {
    private RequiredItemsRecursionA_OLD materialRequiredRecursionA;

    public RequiredItemsRecursionB_OLD(RequiredItemsRecursionA_OLD materialRequiredRecursionA) {
        this.materialRequiredRecursionA = materialRequiredRecursionA;
    }

    public RequiredItemsRecursionB_OLD() {
    }

    public RequiredItemsRecursionA_OLD getMaterialRequiredRecursionA() {
        return materialRequiredRecursionA;
    }

    public void setMaterialRequiredRecursionA(RequiredItemsRecursionA_OLD materialRequiredRecursionA) {
        this.materialRequiredRecursionA = materialRequiredRecursionA;
    }
        
}
