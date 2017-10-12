package managerindustry.logic.runMain;


import java.util.Map;
import managerindustry.logic.json.tax.adjustedPrices.Price;
import managerindustry.logic.json.tax.adjustedPrices.PriceFetch;
import managerindustry.logic.json.tax.adjustedPrices.PriceFetch;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lele
 */
public class ManiAdjustedPrice {

    public static void main(String[] args) {
        PriceFetch adjustedPrice = new PriceFetch();
        
        Map<String, Price > map = adjustedPrice.getPrice();
        
        map.forEach((k,v) -> System.out.println(""+v.getType_id() + " " 
         + v.getAverage_price() + " " + v.getAdjusted_price()  ));
    }
}
