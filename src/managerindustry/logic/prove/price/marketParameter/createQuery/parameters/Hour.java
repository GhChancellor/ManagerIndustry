/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.price.marketParameter.createQuery.parameters;

import managerindustry.logic.prove.price.marketParameter.createQuery.CreateQuery;

/**
 *
 * @author lele
 */
public class Hour extends CreateQuery{
    private int hour;

    public Hour(int hour) {
        this.hour = hour;
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
