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
    private Integer typeID;

    private Integer marketGroupID;
    private Integer parentGroupID;    
    private String marketGroupName;

    public ItemRecursionA() {
    }
    
    public ItemRecursionA(Integer marketGroupID, Integer parentGroupID, String marketGroupName) {
        this.marketGroupID = marketGroupID;
        this.parentGroupID = parentGroupID;
        this.marketGroupName = marketGroupName;        
    }

    public void initRecursion(Integer marketGroupID, Integer parentGroupID, String marketGroupName) {
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

    public Integer getTypeID() {
        return typeID;
    }

    public void setTypeID(Integer typeID) {
        this.typeID = typeID;
    }

    public Integer getMarketGroupID() {
        return marketGroupID;
    }

    public void setMarketGroupID(Integer marketGroupID) {
        this.marketGroupID = marketGroupID;
    }

    public Integer getParentGroupID() {
        return parentGroupID;
    }

    public void setParentGroupID(Integer parentGroupID) {
        this.parentGroupID = parentGroupID;
    }

    public String getMarketGroupName() {
        return marketGroupName;
    }

    public void setMarketGroupName(String marketGroupName) {
        this.marketGroupName = marketGroupName;
    }
    
    
}
