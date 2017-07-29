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
public class Hour implements UrlPrice{
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
