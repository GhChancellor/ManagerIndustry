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
public class MinQuantity implements UrlPrice{
    private int minimunQuantity;

    public MinQuantity(int minimunQuantity) {
        this.minimunQuantity = minimunQuantity;
    }

    public int getMinimunQuantity() {
        return minimunQuantity;
    }

    public void setMinimunQuantity(int minimunQuantity) {
        this.minimunQuantity = minimunQuantity;
    }

    @Override
    public String getUrl() {
        return "minQ";
    }

    @Override
    public String getUrlValue() {
        return ""+this.minimunQuantity;
    }
    
}
