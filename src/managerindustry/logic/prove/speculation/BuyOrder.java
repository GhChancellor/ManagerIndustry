/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.speculation;

import managerindustry.logic.prove.skill.old.TradeFormulas_OLD;

/**
 *
 * @author lele
 */
public class BuyOrder extends Tax{
    private float totalItemTaxBuyOrder;
    
    public BuyOrder(byte brokerRelationsLevel, 
        String station, int numberItems, float sellPrice) {
        
        setItemsNumber(numberItems);
        setItemSellPrice(sellPrice);
        
        TradeFormulas_OLD tradeFormulas = new TradeFormulas_OLD();
        float brokerFeeRate = tradeFormulas.calculateBrokerFee(brokerRelationsLevel, station);
        
        float brokerFeeIskPerItem = getItemTaxBrokerFee(brokerFeeRate, sellPrice);
        // da controllare
        setItemTaxBrokerFee(brokerFeeIskPerItem);
        
        calculateTotalItemTaxBuyOrder(brokerFeeIskPerItem, sellPrice);
        calculateTotalPriceWithTax();        
    }

    
    @Override
    public void calculateTotalPriceWithTax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public float getTotalItemTaxBuyOrder() {
        return totalItemTaxBuyOrder;
    }

    private void calculateTotalItemTaxBuyOrder(float brokerFeeTax, float sellPrice) {
        totalItemTaxBuyOrder = brokerFeeTax + sellPrice;
    }

    public void setTotalItemTaxBuyOrder(float totalItemTaxBuyOrder) {
        this.totalItemTaxBuyOrder = totalItemTaxBuyOrder;
    }
}
