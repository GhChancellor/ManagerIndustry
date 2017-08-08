/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.speculation;

import managerindustry.logic.skill.TradeFormulas;

/**
 *
 * @author lele
 */
public class BuyOrder extends Tax{
    private float totalItemTaxBuyOrder;
    
    public BuyOrder(int brokerRelationsLevel, String station, int numberItems, float sellPrice) {

        setItemsNumber(numberItems);
        setItemSellPrice(sellPrice);
        
        TradeFormulas tradeFormulas = new TradeFormulas();
        float brokerFeeRate = tradeFormulas.calculateBrokerFee(brokerRelationsLevel, station);
        
        float brokerFeeIskPerItem = getItemTaxBrokerFee(brokerFeeRate, sellPrice);
        // da controllare
        setItemTaxBrokerFee(brokerFeeIskPerItem);
        
        calculateTotalItemTaxBuyOrder(brokerFeeIskPerItem, sellPrice);
        float resutTot = calculateTotalPriceWithTax();

    }

    @Override
    protected float calculateTotalPriceWithTax() {        
        float brokerFeeIskPerItem = getItemsTaxBrokerFee() + getTotalPriceWithoutTax();
        
        if ( getItemsTaxBrokerFee() < 100 ){
            brokerFeeIskPerItem += 100;
        }
            
        setTotalPriceWithTax(brokerFeeIskPerItem);
        return 0f;
    }

    public float getTotalItemTaxBuyOrder() {
        return totalItemTaxBuyOrder;
    }

    public void calculateTotalItemTaxBuyOrder(float brokerFeeTax, float sellPrice) {
        totalItemTaxBuyOrder = brokerFeeTax + sellPrice;
    }

    public void setTotalItemTaxBuyOrder(float totalItemTaxBuyOrder) {
        this.totalItemTaxBuyOrder = totalItemTaxBuyOrder;
    }
    
    
}
