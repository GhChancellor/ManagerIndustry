/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.price.examplePrice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lele
 */
public class Type {  
    private List < PriceXML > buys = new ArrayList<>();
    private List < PriceXML > sells = new ArrayList<>();
    private List < PriceXML > alls = new ArrayList<>();
        
    private String type;
//    private String buy;
//    private String sell;
//    private String all;

    public List<PriceXML> getBuys() {
        return buys;
    }

    public void setBuys( List<PriceXML> buys) {
        this.buys = buys;
    }

    public void addBuy( PriceXML buy) {
        this.buys.add(buy);
    }
    
    public List<PriceXML> getSells() {
        return sells;
    }

    public void setSells(List<PriceXML> sells) {
        this.sells = sells;
    }

    public void addSell( PriceXML sell ) {
        this.sells.add(sell);
    }
    
    public List<PriceXML> getAlls() {
        return alls;
    }

    public void setAlls(List<PriceXML> alls) {
        this.alls = alls;
    }

    public void addAll( PriceXML all) {
        this.alls.add(all);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
