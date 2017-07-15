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
public class SellOrder extends Speculation {

    public SellOrder(int brokerRelationsLevel, int accountingLevel, 
     String station, int numberItems, float sellPrice) {
       
        setNumberItems(numberItems);
        setSellPrice(sellPrice);
                
        TradeFormulas tradeFormulas = new TradeFormulas();
        
        float brokerFeeRate = tradeFormulas.brokerFee(brokerRelationsLevel, station);
        float saleTaxRate = tradeFormulas.saleTax(accountingLevel);
        
        float brokerFee = calculateBrokerFeeIskPerItem(brokerFeeRate, sellPrice);
        setItemTaxBrokerFee(brokerFee);
        
        float saleTax = calculateSaleTaxIskPerItem(saleTaxRate, sellPrice);
        setItemTaxSaleTax(saleTax);
        
        setTotalPriceWithoutTax( getNumberItems() * getSellPrice() );
        
        float resutTot = getTotalPriceWithTax();
        setTotalPriceWithTax(resutTot);
    }

    public float getTotalPriceWithTax(){
        return getTotalPriceWithoutTax() - getItemsTaxBrokerFee() - getItemsTaxSaleTax();
    }
}
