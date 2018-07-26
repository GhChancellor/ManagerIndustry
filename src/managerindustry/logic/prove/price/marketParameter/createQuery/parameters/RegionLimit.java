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
public class RegionLimit extends CreateQuery{
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
