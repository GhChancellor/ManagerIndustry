/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax;

import java.math.BigDecimal;
import java.math.RoundingMode;
import managerindustry.logic.skill.TradeFormulas;

/**
 *
 * @author lele
 */
public class SellOrder extends Tax {
    private float totalItemTax;
    private float totalItemsTax;
    
    public SellOrder(int brokerRelationsLevel, int accountingLevel, 
     String station, int numberItems, float sellPrice) {
       
        setItemsNumber(numberItems);
        setItemSellPrice(sellPrice);
                
        TradeFormulas tradeFormulas = new TradeFormulas();
        
        float brokerFeeRate = tradeFormulas.calculateBrokerFee(brokerRelationsLevel, station);
        float saleTaxRate =  conversioneInLetturaNormale( tradeFormulas.calculateSaleTax(accountingLevel) )       ;

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
    protected float calculateTotalPriceWithTax() {
        float result = getTotalPriceWithoutTax() - getItemsTaxBrokerFee() - getItemsTaxSaleTax();
        setTotalPriceWithTax(result);
        return result;
    }
    
}
