/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.speculation.order;

import managerindustry.logic.tax.speculation.formulas.TradeFormulas;

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
        
        TradeFormulas tradeFormulas = new TradeFormulas();
        float brokerFeeRate = tradeFormulas.calculateBrokerFee(brokerRelationsLevel, station);
        
        float brokerFeeIskPerItem = getItemTaxBrokerFee(brokerFeeRate, sellPrice);
        // da controllare
        setItemTaxBrokerFee(brokerFeeIskPerItem);
        
        calculateTotalItemTaxBuyOrder(brokerFeeIskPerItem, sellPrice);
        calculateTotalPriceWithTax();        
    }

    
    @Override
    public void calculateTotalPriceWithTax() {
        float brokerFeeIskPerItem = 
            getItemsTaxBrokerFee() + getTotalPriceWithoutTax();
        
        if ( getItemsTaxBrokerFee() < 100 ){
            brokerFeeIskPerItem += 100;
        }
            
        setTotalPriceWithTax(brokerFeeIskPerItem);
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
