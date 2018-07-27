/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV2;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.build.fatherclass.NameBase;

/**
 *
 * @author lele
 */
public class RequiredItemsRecursionA extends NameBase {
    private List < RequiredItemsRecursionB > materialRequiredRecursionBs = new ArrayList<>();

    /**
     * Get material Required
     * @return List<MaterialRequiredRecursionB>
     */
    public List<RequiredItemsRecursionB> getMaterialRequiredRecursionBs() {
        return materialRequiredRecursionBs;
    }

    /**
     * Add Material Required
     * @param recursionB 
     */
    private void addMaterialRequiredRecursionB(RequiredItemsRecursionB recursionB) {
        this.materialRequiredRecursionBs.add(recursionB);
    }

    /**
     * Init value
     * @param int typeID
     * @param String typeName
     * @param int quantity 
     */
    public RequiredItemsRecursionA(int typeID, String typeName, int quantity) {
        super(typeID, typeName, quantity);
    }
    
    public RequiredItemsRecursionA(int typeID, String typeName) {
        super(typeID, typeName );
    }

    public RequiredItemsRecursionA(String typeName, int quantity) {
        super( typeName, quantity);
    }

    public RequiredItemsRecursionA() {
    }        
    
    
}
