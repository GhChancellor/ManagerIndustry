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
public class Hour extends CreateQuery<Hour>{
    private int hour;

    public Hour(Hour query) {
        super(query);
    }

    
    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public String getUrl() {
        return "hour";
    }

    @Override
    public String getUrlValue() {
        return ""+this.hour;
    }
}
