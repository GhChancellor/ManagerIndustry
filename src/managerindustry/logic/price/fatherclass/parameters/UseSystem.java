/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.price.fatherclass.parameters;

import managerindustry.logic.price.fatherclass.UrlPrice;

/**
 *
 * @author lele
 */
public class UseSystem implements UrlPrice{
    private int usesystem;

    public UseSystem(int usesystem) {
        this.usesystem = usesystem;
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
