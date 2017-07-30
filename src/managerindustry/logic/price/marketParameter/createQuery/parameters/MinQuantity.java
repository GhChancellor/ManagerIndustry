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
public class MinQuantity extends CreateQuery<MinQuantity>{
    private int minimunQuantity;

    public MinQuantity(MinQuantity query) {
        super(query);
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
