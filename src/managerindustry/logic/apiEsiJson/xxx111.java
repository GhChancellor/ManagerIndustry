/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.apiEsiJson;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import managerindustry.db.entities.user.UserApiEntity;

/**
 *
 * @author lele
 */
public class xxx111 {
     
   
    public xxx111(UserApiEntity userApiEntity) {

        ApiEsi.getInstance().skill().getCharacterSkills(userApiEntity);
        
        ApiEsi.getInstance().industry().getListSolarSystemCostIndices();
        ApiEsi.getInstance().market().getListMarketPrices().getListMarketPrices();
        
        
    }
    
}
