/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.speculation;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
    private float result;
    
    public Tax() {
    }
    
    /**
     * Calculate Total Price With out Tax
     */
    private void calculateTotalPriceWithoutTax(){
        totalPriceWithoutTax = itemsNumber * itemSellPrice;        
    }
    
    /**
     * Calculate Items Sell Price
     */
    private void calculateItemsSellPrice(){
        itemsSellPrice = itemSellPrice * itemsNumber;
    }
    
    /**
     * Calculate Items Sale Tax
     */
    private void calculateItemsSaleTax(){
        result = rounding(itemTaxSaleTax * itemsNumber);
    }

    /**
     * Calculate Item Tax Sale Tax
     * @param float saleTax
     * @param float sellPrice 
     */
    public void calculateItemTaxSaleTax( float saleTax, float sellPrice  ){
        itemTaxSaleTax = rounding(saleTax * sellPrice);
    } 

    /**
     * Calculate Items Tax Broker Fee
     */
    public void calculateItemsTaxBrokerFee() {
        itemsTaxBrokerFee = itemTaxBrokerFee * itemsNumber;
    }      
    
    /**
     * Calculate Item Tax Broker Fee
     * @param float brokerFeeRate
     * @param float sellPrice
     * @return float
     */
    public void calculateItemTaxBrokerFee( float brokerFeeRate, float sellPrice ){
        itemTaxBrokerFee = rounding(brokerFeeRate * sellPrice) ;
    }     
        
    /**
     * rounding
     * @param float value
     * @return float
     */
    public float rounding(float value){
//        result = new BigDecimal(value).setScale(2,RoundingMode.UP);
        
        return new BigDecimal(value).setScale(2,RoundingMode.UP).floatValue(); // result.floatValue();
    }       
    
   /**
     * Get Item Sell Price
     * @return float
     */
    public float getItemSellPrice() {
        return itemSellPrice;
    }

    /**
     * Set Item Sel lPrice
     * @param float ItemSellPrice 
     */
    public void setItemSellPrice(float ItemSellPrice) {
        this.itemSellPrice = ItemSellPrice;
    }
    
    /**
     * Get Total Price With Tax
     * @return float
     */
    public float getTotalPriceWithTax() {
        return totalPriceWithTax;
    }

    /**
     * Set Total Price With Tax
     * @param float totalPriceWithTax 
     */
    public void setTotalPriceWithTax(float totalPriceWithTax) {
        this.totalPriceWithTax = totalPriceWithTax;
    }

    /**
     * Get Items Number
     * @return int
     */
    public int getItemsNumber() {
        return itemsNumber;
    }

    /**
     * Set Items Number
     * @param int ItemsNumber 
     */
    public void setItemsNumber(int ItemsNumber) {
        this.itemsNumber = ItemsNumber;
    }

    /**
     * Get Total Price Without Tax
     * @return float
     */
    public float getTotalPriceWithoutTax() {
        calculateTotalPriceWithoutTax();
        return totalPriceWithoutTax;
    }

    /**
     * Set Total Price Without Tax
     * @param float totalPriceWithoutTax 
     */
    public void setTotalPriceWithoutTax(float totalPriceWithoutTax) {
        this.totalPriceWithoutTax = totalPriceWithoutTax;
    }    

    /**
     * Get Items Sell Price
     * @return float
     */
    public float getItemsSellPrice() {
        calculateItemsSellPrice();
        return itemsSellPrice;
    }

    /**
     * Set Items Sell Price
     * @param float itemsSellPrice 
     */
    public void setItemsSellPrice(float itemsSellPrice) {
        this.itemsSellPrice = itemsSellPrice;
    }

    /**
     * Get Items Tax Sale Tax
     * @return float
     */
    public float getItemsTaxSaleTax() {
        calculateItemsSaleTax();
        return result;
    }
    
    /**
     * Calculate Sale Tax Isk Per Item
     * @param float saleTax
     * @param float sellPrice
     * @return float
     */
    public float getItemTaxSaleTax( float saleTax, float sellPrice  ){
        calculateItemTaxSaleTax(saleTax, sellPrice);
        return itemTaxSaleTax;
    } 
    
    /**
     * Get Item Tax SaleTax
     * @return float
     */
    public float getItemTaxSaleTax() {
        return itemTaxSaleTax;
    }

    /**
     * Set Item Tax SaleTax
     * @param float itemTaxSaleTax 
     */
    public void setItemTaxSaleTax(float itemTaxSaleTax) {
        this.itemTaxSaleTax = itemTaxSaleTax;
    }

    /**
     * Get Items Tax Broker Fee
     * @return float
     */
    public float getItemsTaxBrokerFee() {
        calculateItemsTaxBrokerFee();
        return itemsTaxBrokerFee;
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
    public void setItemTaxBrokerFee(float itemTaxBrokerFee) {
        this.itemTaxBrokerFee = itemTaxBrokerFee;
    }   
    
    /**
     * Get Item Tax Broker Fee
     * @param float brokerFeeRate
     * @param float sellPrice
     * @return float
     */
    public float getItemTaxBrokerFee( float brokerFeeRate, float sellPrice ){
        calculateItemTaxBrokerFee(brokerFeeRate, sellPrice) ;
        return itemTaxBrokerFee;
    }    
    
    /**
     * Get Item Tax Broker Fee
     * @return float
     */
    public float getItemTaxBrokerFee() {
        return itemTaxBrokerFee;
    }
    
    public abstract void calculateTotalPriceWithTax();    
}
