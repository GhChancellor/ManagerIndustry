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
public class RequiredItemsRecursionB {
    private RequiredItemsRecursionA materialRequiredRecursionA;

    public RequiredItemsRecursionB(RequiredItemsRecursionA materialRequiredRecursionA) {
        this.materialRequiredRecursionA = materialRequiredRecursionA;
    }

    public RequiredItemsRecursionB() {
    }

    public RequiredItemsRecursionA getMaterialRequiredRecursionA() {
        return materialRequiredRecursionA;
    }

    public void setMaterialRequiredRecursionA(RequiredItemsRecursionA materialRequiredRecursionA) {
        this.materialRequiredRecursionA = materialRequiredRecursionA;
    }
        
}
