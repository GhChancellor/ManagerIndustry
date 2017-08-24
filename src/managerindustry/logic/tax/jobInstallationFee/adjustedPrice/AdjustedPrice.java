/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.jobInstallationFee.adjustedPrice;

/**
 *
 * @author lele
 */
public class AdjustedPrice {
    // adjustedPrice = https://esi.tech.ccp.is/latest/markets/prices/?datasource=tranquility
    
    private String adjusted_price;
    private String average_price;
    private String type_id;

    public AdjustedPrice() {
    }

    /**
     * Set TypeId and get adjusted_price or average_price
     * @param String adjusted_price
     * @param String average_price
     * @param String type_id 
     */
    public AdjustedPrice(String adjusted_price, String average_price, String type_id) {
        this.adjusted_price = adjusted_price;
        this.average_price = average_price;
        this.type_id = type_id;
    }
    
    /**
     * Get Adjusted Price
     * @return String
     */
    public String getAdjusted_price() {
        return adjusted_price;
    }

    /**
     * Set Adjusted Price
     * @param String adjusted_price 
     */
    public void setAdjusted_price(String adjusted_price) {
        this.adjusted_price = adjusted_price;
    }

    /**
     * Get Average Price
     * @return String
     */
    public String getAverage_price() {
        return average_price;
    }

    /**
     * Set Average Price
     * @param String average_price 
     */
    public void setAverage_price(String average_price) {
        this.average_price = average_price;
    }

    /**
     * Get Type Id
     * @return String
     */
    public String getType_id() {
        return type_id;
    }

    /**
     * Set Type Id
     * @param String type_id 
     */
    public void setType_id(String type_id) {
        this.type_id = type_id;
    }
    
    
}
