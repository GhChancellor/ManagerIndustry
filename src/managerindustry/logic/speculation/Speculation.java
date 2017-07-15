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
    private int numberItems;
    private float sellPrice;
    private float itemTaxBrokerFee;
    private float itemTaxSaleTax;
    private float itemsTaxBrokerFee;
    private float itemsTaxSaleTax;
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

    public Speculation() {
    }
    
    
    
    public Speculation(int numberItem, float sellPrice, float buyOrder,
     int brokerRelationsLevel, int accounting, String station) {

    }
        
    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }
    
    public float getItemsTaxBrokerFee() {
        return this.itemsTaxBrokerFee * this.numberItems;
    }

    private void setItemsTaxBrokerFee(float itemsTaxBrokerFee) {
        this.itemsTaxBrokerFee = itemsTaxBrokerFee;
    }

    public float getItemsTaxSaleTax() {
        return this.itemTaxSaleTax * this.numberItems;
    }

    private void setItemsTaxSaleTax(float itemsTaxSaleTax) {
        this.itemsTaxSaleTax = itemsTaxSaleTax;
    }
    
    public float getTotalPriceWithoutTax() {
        return totalPriceWithoutTax;
    }

    public void setTotalPriceWithoutTax(float totalPriceWithoutTax) {
        this.totalPriceWithoutTax = totalPriceWithoutTax;
    }

    public float getTotalPriceWithTax() {
        return totalPriceWithTax;
    }

    public void setTotalPriceWithTax(float totalPriceWithTax) {
        this.totalPriceWithTax = totalPriceWithTax;
    }
        
    public float calculateBrokerFeeIskPerItem( float brokerFeeRate, float sellPrice ){
        return brokerFeeRate * sellPrice;
    }
    
    public float calculateSaleTaxIskPerItem( float saleTax, float sellPrice  ){
        return saleTax * sellPrice;
    }

    public int getNumberItems() {
        return numberItems;
    }

    public void setNumberItems(int numberItems) {
        this.numberItems = numberItems;
    }

    public float getItemTaxBrokerFee() {
        return itemTaxBrokerFee;
    }

    public void setItemTaxBrokerFee(float itemTaxBrokerFee) {
        this.itemTaxBrokerFee = itemTaxBrokerFee;
    }

    public float getItemTaxSaleTax() {
        return itemTaxSaleTax;
    }

    public void setItemTaxSaleTax(float itemTaxSaleTax) {
        this.itemTaxSaleTax = itemTaxSaleTax;
    }

    
    
}
