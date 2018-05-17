/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.items.fatherclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import managerindustry.db.entities.InvMarketGroups;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.prove.invMarketGroups.old.ItemClass;

/**
 *
 * @author lele
 */
public abstract class Category <T>{
    private List<InvTypes> items = new ArrayList<>();

    public Category(T t, String typeName) {
        xxx(t, typeName);
    }

    public Category() {
    }
    
    public void xxx(T t, String typeName){
        initItems(t);
        InvTypes invTypes = ManagerDB.getInstance().invTypes().getIdByName(typeName);
        
        for (InvTypes item : items) {
            if ( item.getMarketGroupID() == invTypes.getMarketGroupID() ){
                System.out.println("Si");
            }else{
                System.out.println("NO");
            }
        }
    }
    public List<InvTypes> getItems() {
        return items;
    }

    public void setItems(List<InvTypes> items) {
        this.items = items;
    }
    
    public void display(List < InvTypes > items){
        for (InvTypes item : items) {
            System.out.println(""+item.getTypeID()+ " " + item.getTypeName() );
        }
    }
    
    public abstract void initItems(T t);
}
