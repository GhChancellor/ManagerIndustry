/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.apiEsiJson.market;

import managerindustry.logic.apiEsiJson.market.listMarketPrices.ListMarketPrices;

/**
 * It's a class container
 * @author lele
 */
public class Market {
    public ListMarketPrices getListMarketPrices(){
        ListMarketPrices listMarketPrices = new ListMarketPrices();
        return listMarketPrices;
    }
}
