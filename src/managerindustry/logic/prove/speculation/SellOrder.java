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
public class SellOrder extends Tax{
    private float totalItemTax;
    private float totalItemsTax;
    
    public SellOrder(byte brokerRelationsLevel, byte accountingLevel, 
        String station, int numberItems, float sellPrice) {
        
        setItemsNumber(numberItems);
        setItemSellPrice(sellPrice);
                
        TradeFormulas_OLD tradeFormulas = new TradeFormulas_OLD();
        
        float brokerFeeRate = tradeFormulas.calculateBrokerFee(brokerRelationsLevel, station);
        float saleTaxRate =  rounding( tradeFormulas.calculateSaleTax(accountingLevel) );

        float itemTaxBrokerFee = getItemTaxBrokerFee(brokerFeeRate, sellPrice);
        
        float itemTaxSaleTax = getItemTaxSaleTax(saleTaxRate, sellPrice);
        
        calculateTotalItemTax(itemTaxBrokerFee, itemTaxSaleTax);
        
        setTotalPriceWithoutTax( getItemsNumber() * getItemSellPrice() );
        calculateTotalItemsTax();
                
        calculateTotalPriceWithTax();        
    }

    /**
     * Get Total Item Tax SellTax ( per Item )
     * @param float brokerFeeTax
     * @param float saleTax
     * @return float
     */
    public void calculateTotalItemTax( float brokerFeeTax, float saleTax) {
        this.totalItemTax = brokerFeeTax + saleTax;
    }

    /**
     * Set Total Item Tax SellTax ( per Item )
     * @param float totalItemTax 
     */
    public void setTotalItemTax(float totalItemTax) {
        this.totalItemTax = totalItemTax;
    }

    /**
     * Get Total Item Tax SellTax ( per Item )
     * @return float
     */
    public float getTotalItemTax(){
        return totalItemTax;
    }

    /**
     * Calculate Total Items Tax
     * @return float
     */
    public void calculateTotalItemsTax() {
        totalItemsTax = getItemsTaxBrokerFee() + getItemsTaxSaleTax();
    }
    
    /** 
     * Get Total Items Tax
     * @return float
     */
    public float getTotalItemsTax() {
        return totalItemsTax;
    }

    /**
     * Set Total Items Tax
     * @param float totalItemsTax 
     */
    public void setTotalItemsTax(float totalItemsTax) {
        this.totalItemsTax = totalItemsTax;
    }

    @Override
    public void calculateTotalPriceWithTax() {
        float result = getTotalPriceWithoutTax() - getItemsTaxBrokerFee() - getItemsTaxSaleTax();
        setTotalPriceWithTax(result);
    }
    
}
