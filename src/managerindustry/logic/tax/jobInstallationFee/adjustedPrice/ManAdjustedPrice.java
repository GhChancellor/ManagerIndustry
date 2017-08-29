package managerindustry.logic.tax.jobInstallationFee.adjustedPrice;


import java.util.Map;
import managerindustry.logic.tax.jobInstallationFee.adjustedPrice.PriceFetch;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lele
 */
public class ManAdjustedPrice {

    public static void main(String[] args) {
        PriceFetch adjustedPrice = new PriceFetch();
        
        Map<String, Price > map = adjustedPrice.getPrice();
        
        map.forEach((k,v) -> System.out.println(""+v.getType_id() + " " 
         + v.getAverage_price() + " " + v.getAdjusted_price()  ));
    }
}
