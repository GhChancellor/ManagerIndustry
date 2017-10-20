/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.apiEsiJson;

import managerindustry.db.entities.user.UserApiEntity;

/**
 *
 * @author lele
 */
public class xxx111 {
     
    
    public xxx111(UserApiEntity userApiEntity) {

        ApiEsi.getInstance().skillJson().getCharacterSkills(userApiEntity);
        
        ApiEsi.getInstance().industryJson().getListSolarSystemCostIndices();
        ApiEsi.getInstance().marketJSon().getListMarketPrices().getListMarketPrices();
    }
    
}
