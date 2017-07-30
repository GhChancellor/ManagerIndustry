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
public class RegionLimit extends CreateQuery<RegionLimit>{
    private int regionlimit;

    public RegionLimit(RegionLimit query) {
        super(query);
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
