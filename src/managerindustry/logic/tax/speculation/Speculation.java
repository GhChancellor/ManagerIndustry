/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.speculation;

import managerindustry.logic.skill.FormulasSkill;
import managerindustry.logic.skill.TradeFormulas;

/**
 *
 * @author lele
 */
public class Speculation{
    private float profit;
    private float minSell;
    private float totalInvestment;
    private float myPrice;
    private float sellerPrice;
    private float gainItem;
    private float totalGain;

    public Speculation() {
        int numberItem = 2;
        SellOrder sellOrder = new SellOrder(5, 5, "station", numberItem, 100000);
        BuyOrder buyOrder = new BuyOrder(5, "station", numberItem, 90000);

        displaySellOrder(sellOrder);
        displayBuyOrder(buyOrder);

        speculationByBuyOrder(sellOrder, buyOrder);        
        displaySpeculationByBuyOrder(sellOrder.getTotalPriceWithTax(), buyOrder.getTotalPriceWithTax());
        
        sellOrder = new SellOrder(5, 5, "station", numberItem, 90000);
        speculationBySellOrder(sellOrder, 100000);
        dispalySpeculationBySellOrder(sellOrder);
    }

    
    public void dispalySpeculationBySellOrder(SellOrder sellOrder){
        System.out.println("\nSpeculation By Sell Order:");
        System.out.println("Numer Item " + sellOrder.getItemsNumber() + 
        " - SellerPrice " + sellerPrice + " - My Price " + myPrice  +
        " - Free tax " + sellOrder.getTotalPriceWithoutTax() +
        "\nMin sell " + minSell + " - Gain item " + gainItem +
        "\nTotal gain " + totalGain + " - Total Investment " +totalInvestment );
    }
    
    public void speculationBySellOrder(SellOrder sellOrder, float myPrice){
        this.myPrice = myPrice;
        this.sellerPrice = sellOrder.getItemSellPrice();
        minSell = this.sellerPrice + sellOrder.getTotalItemTax();
        gainItem = myPrice - minSell;
        
        totalInvestment = ( sellOrder.getItemsNumber() * sellerPrice ) + sellOrder.getTotalItemsTax();
        totalGain = gainItem * sellOrder.getItemsNumber();        
        
        
//        myPrice =  sellOrder.getItemSellPrice();
//        this.sellerPrice = sellerPrice;
//        minSell = this.sellerPrice + sellOrder.calculateTotalItemTax();
//        gainItem = this.sellerPrice - minSell;
//        totalInvestment = sellOrder.getItemsNumber() + sellOrder.calculateTotalItemsTax();
//        totalGain = gainItem * sellOrder.getItemsNumber();
    }

//    public void speculationBySellOrder(int numberItems, float myPriceSell, float selllerPrice, 
//     int brokerRelationsLevel,  int accountingLevel, String station, SellOrder sellOrder ){
//        
//        this.sellerPrice = selllerPrice;
//        TradeFormulas tradeFormulas = new TradeFormulas();
//        float brokerFeeRate = tradeFormulas.calculateBrokerFee(brokerRelationsLevel, "station");
//        float saletaxRate = tradeFormulas.calculateSaleTax( accountingLevel );
//        
//        this.minSell = (this.sellerPrice + ( this.sellerPrice * saletaxRate) + ( this.sellerPrice * brokerFeeRate ) );
//        this.gainItem = this.sellerPrice - this.minSell;
//        
//        totalGain = numberItems * this.gainItem;
//        this.totalInvestment = numberItems * selllerPrice + ( sellOrder. ) + ();
//        
//        // numberItems * selllerPrice + ( myprice ( sellorder )
//    }

    
    public void speculationByBuyOrder(SellOrder sellOrder, BuyOrder buyOrder){
        profit = sellOrder.getTotalPriceWithTax() - buyOrder.getTotalPriceWithTax();
        minSell = sellOrder.getTotalItemTax() + buyOrder.getItemTaxBrokerFee() 
         + buyOrder.getItemSellPrice();
        totalInvestment = buyOrder.getTotalPriceWithTax() + sellOrder.getTotalItemsTax();
        System.out.println("");
    }
    
    public void displaySpeculationByBuyOrder(float totalPriceWithTaxSellOrder, 
     float totalPriceWitRhTaxBuyOrder){
        System.out.println("Speculation By Buy Order:");
        System.out.println("Profit " + profit + " - Min sell " + minSell + 
         " - TotalPriceWithTaxSellOrder " + totalPriceWithTaxSellOrder + 
         "\nTotalPriceWithTaxBuyOrder" + totalPriceWitRhTaxBuyOrder + 
         " - Total Investment " + totalInvestment );
    }
    
    public void displaySellOrder(SellOrder sellOrder){
        System.out.println("Sell order:");
        System.out.println("Number items "+ sellOrder.getItemsNumber()+ " - ItemSellPrice " + 
         sellOrder.getItemSellPrice());
        
        System.out.println("Free tax Items " + sellOrder.getTotalPriceWithoutTax());
        
        System.out.println("Broker Fee ISK\n" + "BrokerFeeIskPerItems " + sellOrder.getItemsTaxBrokerFee() + 
         " - BrokerFeeIskPerItem " + sellOrder.getItemTaxBrokerFee() );
        
        System.out.println("Sale tax\nItemTax_SaleTax " + sellOrder.getItemTaxSaleTax() + " - getItemsTax_SaleTax " + sellOrder.getItemsTaxSaleTax());
        System.out.println("Total Tax per Item " + sellOrder.getTotalItemTax() + " - Total Tax per Items " + sellOrder.getTotalItemsTax() );
        System.out.println("TotalPriceWithTax " + sellOrder.getTotalPriceWithTax() + " - TotalPriceWithoutTax " + sellOrder.getTotalPriceWithoutTax());

    }
    
    public void displayBuyOrder(BuyOrder buyOrder){
        System.out.println("\nBuy order:");
        System.out.println("Number items " + buyOrder.getItemsNumber()+ " - ItemSellPrice " + buyOrder.getItemSellPrice()  );
        
        System.out.println("Free tax Items " + buyOrder.getTotalPriceWithoutTax());
        System.out.println("Broker Fee ISK\n" + "BrokerFeeIskPerItems " + buyOrder.getItemsTaxBrokerFee()
        + " - BrokerFeeIskPerItem " + buyOrder.getItemTaxBrokerFee());
        System.out.println("Total Tax per Item " + buyOrder.getTotalItemTaxBuyOrder());
        System.out.println("TotalPriceWithTax " + buyOrder.getTotalPriceWithTax() + " - TotalPriceWithoutTax " + buyOrder.getTotalPriceWithoutTax());
        
    }
    
    /**
     * Get Total Investment
     * @return float
     */
    public float getTotalInvestment() {
        return totalInvestment;
    }

    /**
     * Set Total Investment
     * @param float totalInvestment 
     */
    public void setTotalInvestment(float totalInvestment) {
        this.totalInvestment = totalInvestment;
    }    
    
    /**
     * Get Profit
     * @return float
     */
    protected float getProfit() {
        return profit;
    }

    /**
     * Set Profit
     * @param float profit 
     */
    protected void setProfit(float profit) {
        this.profit = profit;
    }

    
    protected float getMinSell() {
        return minSell;
    }

    
    /**
     * Get MinSell
     * @return float
     */
    protected float getMinSell(float xxx ) {
        return minSell;
    }

    /**
     * Set MinSell
     * @param float minSell 
     */
    protected void setMinSell(float minSell) {
        this.minSell = minSell;
    }

    /**
     * Get Gain Item
     * @return float
     */
    public float getGainItem() {
        return gainItem;
    }

    /**
     * Set Gain Item
     * @param float gainItem 
     */
    public void setGainItem(float gainItem) {
        this.gainItem = gainItem;
    }

    /**
     * Get Seller Price
     * @return float
     */
    public float getSellerPrice() {
        return sellerPrice;
    }

    /**
     * Set Seller Price
     * @param float sellerPrice 
     */
    public void setSellerPrice(float sellerPrice) {
        this.sellerPrice = sellerPrice;
    }

    /**
     * Get Total Gain
     * @return float
     */
    public float getTotalGain() {
        return totalGain;
    }

    /**
     * Set Total Gain
     * @param float totalGain 
     */
    public void setTotalGain(float totalGain) {
        this.totalGain = totalGain;
    }

    public float getMyPrice() {
        return myPrice;
    }

    public void setMyPrice(float myPrice) {
        this.myPrice = myPrice;
    }

    
    
}
