/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.apiEsi;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import managerindustry.db.entities.user.UserApiEntity;
import managerindustry.logic.manager.Manager;

/**
 *
 * @author lele
 */
public class xxx111 {
     
   
    public xxx111(UserApiEntity userApiEntity) {

        Manager.getInstance().apiEsi().skill().getCharacterSkills(userApiEntity);
        
        Manager.getInstance().apiEsi().industry().getListSolarSystemCostIndices();
        Manager.getInstance().apiEsi().market().getListMarketPrices().getListMarketPrices();
        
        
    }
    
}
