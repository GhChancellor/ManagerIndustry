/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.price.marketParameter.createQuery.parameters;

import managerindustry.logic.price.marketParameter.createQuery.CreateQuery;
import managerindustry.logic.price.marketParameter.createQuery.UrlPrice;

/**
 *
 * @author lele
 */
public class UseSystem extends CreateQuery<UseSystem>{
    private int usesystem;

    public UseSystem(UseSystem query) {
        super(query);
    }

    public int getUsesystem() {
        return usesystem;
    }

    public void setUsesystem(int usesystem) {
        this.usesystem = usesystem;
    }

    @Override
    public String getUrl() {
        return "usesystem";
    }

    @Override
    public String getUrlValue() {
        return ""+this.usesystem;
    }
    
    
}
