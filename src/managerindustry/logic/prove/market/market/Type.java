/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.market.market;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lele
 */
@XmlRootElement(name = "marketstat")
public class Type {

    List<MarketElement> marketElements = new ArrayList<>();

    @XmlElements({
        @XmlElement(name = "buy", type = Buy.class),
        @XmlElement(name = "all", type = All.class),
        @XmlElement(name = "sell", type = Sell.class)
    })
    public List<MarketElement> getMarketElements() {
        return marketElements;
    }

    public void setMarketElements(List<MarketElement> marketElements) {
        this.marketElements = marketElements;
    }

}
