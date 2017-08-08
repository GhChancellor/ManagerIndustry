/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.speculation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import managerindustry.logic.skill.TradeFormulas;

/**
 *
 * @author lele
 */
public abstract class Tax {
    private int itemsNumber;
    private float itemSellPrice;
    private float itemsSellPrice;
    
    private float itemTaxBrokerFee;
    private float itemsTaxBrokerFee;
    
    private float itemTaxSaleTax;
     
    private float totalPriceWithTax;
    private float totalPriceWithoutTax;
    
    
//    private float freeTaxItemSellOrder;
//    private float freeTaxItemBuyOrder;
//    private float itemTaxSellOrder;
//    private float itemTaxBuyOrder;
//    private float itemsTaxSellOrder;
//    private float itemsTaxBuyOrder;
//    private float totalWithTaxSellOrder;
//    private float totalWithTaxBuyOrder;
//    private float initialInvestment;

    public Tax() {
    }
    
    public Tax(int numberItem, float sellPrice, float buyOrder,
     int brokerRelationsLevel, int accounting, String station) {

    }    
    
    /**
     * Get Item Sell Price
     * @return float
     */
    protected float getItemSellPrice() {
        return itemSellPrice;
    }

    /**
     * Set Item Sel lPrice
     * @param float ItemSellPrice 
     */
    protected void setItemSellPrice(float ItemSellPrice) {
        this.itemSellPrice = ItemSellPrice;
    }

    protected abstract float calculateTotalPriceWithTax();
    
    /**
     * Get Total Price With Tax
     * @return float
     */
    protected float getTotalPriceWithTax() {
        return totalPriceWithTax;
    }

    /**
     * Set Total Price With Tax
     * @param float totalPriceWithTax 
     */
    protected void setTotalPriceWithTax(float totalPriceWithTax) {
        this.totalPriceWithTax = totalPriceWithTax;
    }

    /**
     * Get Items Number
     * @return int
     */
    protected int getItemsNumber() {
        return itemsNumber;
    }

    /**
     * Set Items Number
     * @param int ItemsNumber 
     */
    protected void setItemsNumber(int ItemsNumber) {
        this.itemsNumber = ItemsNumber;
    }

    protected float conversioneInLetturaNormale(float value){
        BigDecimal result = new BigDecimal(value).setScale(2,RoundingMode.UP);
        return result.floatValue();
    }   

    /**
     * Get Total Price Without Tax
     * @return float
     */
    protected float getTotalPriceWithoutTax() {
        totalPriceWithoutTax = this.itemsNumber * this.itemSellPrice;
        return totalPriceWithoutTax;
    }

    /**
     * Set Total Price Without Tax
     * @param float totalPriceWithoutTax 
     */
    protected void setTotalPriceWithoutTax(float totalPriceWithoutTax) {
        this.totalPriceWithoutTax = totalPriceWithoutTax;
    }    

    /**
     * Get Items Sell Price
     * @return float
     */
    protected float getItemsSellPrice() {
        itemsSellPrice = itemSellPrice * itemsNumber;
        return  itemsSellPrice;
    }

    /**
     * Set Items Sell Price
     * @param float itemsSellPrice 
     */
    protected void setItemsSellPrice(float itemsSellPrice) {
        this.itemsSellPrice = itemsSellPrice;
    }

    /**
     * Get Items Tax Sale Tax
     * @return float
     */
    protected float getItemsTaxSaleTax() {
        float tempResult = this.itemTaxSaleTax * this.itemsNumber;
        return conversioneInLetturaNormale(tempResult);
    }
    
    /**
     * Calculate Sale Tax Isk Per Item
     * @param float saleTax
     * @param float sellPrice
     * @return float
     */
    protected float getItemTaxSaleTax( float saleTax, float sellPrice  ){
        float tempValue = saleTax * sellPrice;
        itemTaxSaleTax = conversioneInLetturaNormale(tempValue);
        return itemTaxSaleTax;
    } 
    
    /**
     * Get Item Tax SaleTax
     * @return float
     */
    protected float getItemTaxSaleTax() {
        return itemTaxSaleTax;
    }

    /**
     * Set Item Tax SaleTax
     * @param float itemTaxSaleTax 
     */
    protected void setItemTaxSaleTax(float itemTaxSaleTax) {
        this.itemTaxSaleTax = itemTaxSaleTax;
    }

    /**
     * Get Items Tax Broker Fee
     * @return float
     */
    public float getItemsTaxBrokerFee() {
        itemsTaxBrokerFee = this.itemTaxBrokerFee * this.itemsNumber;
        return conversioneInLetturaNormale(itemsTaxBrokerFee);
    }         

    /**
     * Set Items Tax Broker Fee
     * @param float itemsTaxBrokerFee 
     */
    private void setItemsTaxBrokerFee(float itemsTaxBrokerFee) {
      this.itemsTaxBrokerFee = itemsTaxBrokerFee;
    }    

    /**
     * Set Item Tax Broker Fee
     * @param float itemTaxBrokerFee 
     */
    protected void setItemTaxBrokerFee(float itemTaxBrokerFee) {
        this.itemTaxBrokerFee = itemTaxBrokerFee;
    }   
    
    /**
     * Get Item Tax Broker Fee
     * @param float brokerFeeRate
     * @param float sellPrice
     * @return float
     */
    protected float getItemTaxBrokerFee( float brokerFeeRate, float sellPrice ){
        float brokerFeeIskPerItemTemp = brokerFeeRate * sellPrice;
        itemTaxBrokerFee = conversioneInLetturaNormale(brokerFeeIskPerItemTemp) ;
        
        return itemTaxBrokerFee;
    }    
    

    
    /**
     * Get Item Tax Broker Fee
     * @return float
     */
    public float getItemTaxBrokerFee() {
        return itemTaxBrokerFee;
    }    
}
