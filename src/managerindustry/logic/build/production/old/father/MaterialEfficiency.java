/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.build.production.old.father;

/**
 * https://community.eveonline.com/news/dev-blogs/eve-industry-all-you-want-to-know/
 * @author lele
 */
public class MaterialEfficiency extends Efficiency {

    /**
     * init MaterialEfficiencyX1
     * @param byte bpoLevel 
     */
    public MaterialEfficiency(byte bpoLevel) {
        setLevel(bpoLevel);
    }
    
    /**
     * calculateRateBpo
     * @return float
     */
    @Override
    protected double calculateRateBpo() {
        return getBaseValue() - ( getLevel().floatValue() / 100 )  ;
    }
    
}
