/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.speculation;

import managerindustry.logic.skill.TradeFormulas;

/**
 *
 * @author lele
 */
public class Speculation {
    private int numberItem;
    private float sellPrice;
    private float buyOrder;
    private float freeTaxItemSellOrder;
    private float freeTaxItemBuyOrder;
    private float itemTaxSellOrder;
    private float itemTaxBuyOrder;
    private float itemsTaxSellOrder;
    private float itemsTaxBuyOrder;
    private float totalWithTaxSellOrder;
    private float totalWithTaxBuyOrder;
    private float initialInvestment;
    
    public Speculation(int numberItem, float sellPrice, float buyOrder,
     int brokerRelationsLevel, int accounting, String station) {
        this.buyOrder = buyOrder;
        this.numberItem = numberItem;
        this.sellPrice = sellPrice;
        sellOrder(brokerRelationsLevel, accounting, station);
        buyOrder();
    }

    private void sellOrder(int brokerRelationsLevel, int accounting, String station ){
        freeTaxItemSellOrder = numberItem * sellPrice;
        TradeFormulas tradeFormulas = new TradeFormulas();
        
        float brokerFee = tradeFormulas.brokerFee(brokerRelationsLevel, station);
        float saleTax = tradeFormulas.saleTax(accounting, brokerFee);
        
        
        
        if (result < 100){
            result = 100;
        }
    }
    
    private void buyOrder(){
        
    }
    
    
}
