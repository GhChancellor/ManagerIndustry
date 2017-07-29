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
public class RegionLimit implements UrlPrice{
    private int regionlimit;

    public RegionLimit(int regionlimit) {
        this.regionlimit = regionlimit;
    }

    public int getRegionlimit() {
        return regionlimit;
    }

    public void setRegionlimit(int regionlimit) {
        this.regionlimit = regionlimit;
    }
    
    @Override
    public String getUrl() {
        return "regionlimit";
    }

    @Override
    public String getUrlValue() {
        return ""+this.regionlimit;
    }
    
}
