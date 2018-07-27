/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.market.price.priceXML;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lele
 */
@XmlRootElement
public class Evec {
    private List<Marketstat> marketstats = new ArrayList<>();

    @XmlElement(name = "marketstat")
    public List<Marketstat> getMarketstats() {
        return marketstats;
    }

    public void setMarketstats(List<Marketstat> marketstats) {
        this.marketstats = marketstats;
    }
    
    
}
