/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.itemsRecursion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lele
 */
public class ItemRecursionA {
    private List < ItemRecursionB > recursionB02s = new ArrayList<>();
    
    private String typeName;
    private int typeID;

    private short marketGroupID;
    private short parentGroupID;    
    private String marketGroupName;

    public ItemRecursionA() {
    }
    
    public ItemRecursionA(short marketGroupID, short parentGroupID, String marketGroupName) {
        this.marketGroupID = marketGroupID;
        this.parentGroupID = parentGroupID;
        this.marketGroupName = marketGroupName;        
    }

    public void initRecursion(short marketGroupID, short parentGroupID, String marketGroupName) {
        this.marketGroupID = marketGroupID;
        this.parentGroupID = parentGroupID;
        this.marketGroupName = marketGroupName;
    }

    public List<ItemRecursionB> getRecursionB02s() {
        return recursionB02s;
    }

    public void setRecursionB02s(List<ItemRecursionB> recursionB02s) {
        this.recursionB02s = recursionB02s;
    }

    public void addRecursionB02(ItemRecursionB recursionB02) {
        this.recursionB02s.add(recursionB02);
    }
        
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public Short getMarketGroupID() {
        return marketGroupID;
    }

    public void setMarketGroupID(short marketGroupID) {
        this.marketGroupID = marketGroupID;
    }

    public Short getParentGroupID() {
        return parentGroupID;
    }

    public void setParentGroupID(short parentGroupID) {
        this.parentGroupID = parentGroupID;
    }

    public String getMarketGroupName() {
        return marketGroupName;
    }

    public void setMarketGroupName(String marketGroupName) {
        this.marketGroupName = marketGroupName;
    }
    
    
}
