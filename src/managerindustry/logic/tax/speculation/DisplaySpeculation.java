/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.speculation;

import managerindustry.logic.tax.speculation.order.BuyOrder;
import managerindustry.logic.tax.speculation.order.SellOrder;

/**
 *
 * @author lele
 */
public class DisplaySpeculation {
    private float profit;
    private float minSell;
    private float totalInvestment;
    private float myPrice;
    private float sellerPrice;
    private float gainItem;
    private float totalGain;    
    
    public DisplaySpeculation() {
        int numberItem = 2;
        SellOrder sellOrder = 
            new SellOrder((byte) 5,(byte)  5, "station", numberItem, 100000);
        
        BuyOrder buyOrder = new BuyOrder((byte) 5, "station", numberItem, 90000);

        displaySellOrder(sellOrder);
        
        displayBuyOrder(buyOrder);

        speculationByBuyOrder(sellOrder, buyOrder);
        
        displaySpeculationByBuyOrder(
            sellOrder.getTotalPriceWithTax(), buyOrder.getTotalPriceWithTax());
        
        sellOrder = new SellOrder((byte) 5,(byte)  5, "station", numberItem, 90000);
        
        speculationBySellOrder(sellOrder, 100000);
        
        displaySpeculationBySellOrder(sellOrder);
    }  
    
    private void displaySellOrder(SellOrder sellOrder){
        System.out.println("Sell order:");
        
        System.out.println("Number items " + 
            sellOrder.getItemsNumber()+ " - ItemSellPrice " + 
         sellOrder.getItemSellPrice());
        
        System.out.println("Free tax Items " + sellOrder.getTotalPriceWithoutTax());
        
        System.out.println("Broker Fee ISK\n" + 
            "BrokerFeeIskPerItems " + sellOrder.getItemsTaxBrokerFee() + 
            " - BrokerFeeIskPerItem " + sellOrder.getItemTaxBrokerFee() );
        
        System.out.println(""
            + "Sale tax\nItemTax_SaleTax " + sellOrder.getItemTaxSaleTax() + 
            " - getItemsTax_SaleTax " + sellOrder.getItemsTaxSaleTax());
        
        System.out.println("Total Tax per Item " + sellOrder.getTotalItemTax() + 
            " - Total Tax per Items " + sellOrder.getTotalItemsTax() );
        
        System.out.println(
            "TotalPriceWithTax " + sellOrder.getTotalPriceWithTax() + 
            " - TotalPriceWithoutTax " + sellOrder.getTotalPriceWithoutTax());
    }    
    
    private void displayBuyOrder(BuyOrder buyOrder){
        System.out.println("\nBuy order:");
        
        System.out.println("Number items " + buyOrder.getItemsNumber()+ 
            " - ItemSellPrice " + buyOrder.getItemSellPrice()  );
        
        System.out.println("Free tax Items " + buyOrder.getTotalPriceWithoutTax());
        
        System.out.println("Broker Fee ISK\n" + 
            "BrokerFeeIskPerItems " + buyOrder.getItemsTaxBrokerFee() +
            " - BrokerFeeIskPerItem " + buyOrder.getItemTaxBrokerFee());
        
        System.out.println("Total Tax per Item " + buyOrder.getTotalItemTaxBuyOrder());
        
        System.out.println("TotalPriceWithTax " + buyOrder.getTotalPriceWithTax() + 
            " - TotalPriceWithoutTax " + buyOrder.getTotalPriceWithoutTax());        
    }    
    
    private void speculationByBuyOrder(SellOrder sellOrder, BuyOrder buyOrder){
        profit = 
            sellOrder.getTotalPriceWithTax() - buyOrder.getTotalPriceWithTax();
        
        minSell = 
            sellOrder.getTotalItemTax() + buyOrder.getItemTaxBrokerFee() +
            buyOrder.getItemSellPrice();
        
        totalInvestment = 
            buyOrder.getTotalPriceWithTax() + sellOrder.getTotalItemsTax();
        System.out.println("");
    }    
    
    private void speculationBySellOrder(SellOrder sellOrder, float myPrice){
        this.myPrice = myPrice;
        
        sellerPrice = sellOrder.getItemSellPrice();
        
        minSell = sellerPrice + sellOrder.getTotalItemTax();
        
        gainItem = this.myPrice - minSell;
        
        totalInvestment = 
            ( sellOrder.getItemsNumber() * sellerPrice ) + 
            sellOrder.getTotalItemsTax();
        
        totalGain = gainItem * sellOrder.getItemsNumber();        
    }  
    
    private void displaySpeculationByBuyOrder(float totalPriceWithTaxSellOrder, 
            float totalPriceWitRhTaxBuyOrder){
        
        System.out.println("Speculation By Buy Order:");
        
        System.out.println("Profit " + profit + " - Min sell " + minSell + 
            " - TotalPriceWithTaxSellOrder " + totalPriceWithTaxSellOrder + 
            "\nTotalPriceWithTaxBuyOrder" + totalPriceWitRhTaxBuyOrder + 
            " - Total Investment " + totalInvestment );
    } 
    
    private void displaySpeculationBySellOrder(SellOrder sellOrder){
        System.out.println("\nSpeculation By Sell Order:");
        
        System.out.println("Numer Item " + sellOrder.getItemsNumber() + 
            " - SellerPrice " + sellerPrice + " - My Price " + myPrice  +
            " - Free tax " + sellOrder.getTotalPriceWithoutTax() +
            "\nMin sell " + minSell + " - Gain item " + gainItem +
            "\nTotal gain " + totalGain + " - Total Investment " +totalInvestment );
    }    
}
