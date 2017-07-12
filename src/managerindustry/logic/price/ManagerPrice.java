/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.price;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lele
 */
public class ManagerPrice {
    private static ManagerPrice instance = null;
    private List < Type > types = new ArrayList<>();
    
    public static ManagerPrice getInstance() {
        if ( instance == null ){
            instance = new ManagerPrice();
        }
        return instance;
    }
    
    public void init(){
        initTritanium();
        display();
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }
    
    public void addTypes( Type types) {
        this.types.add(types);
    }
    
    public void initTritanium(){
        Type type = new Type();
        type.setType("34");
        
        PriceXML priceXMLBuy = new PriceXML();
        priceXMLBuy.setVolume("15015683010");
        priceXMLBuy.setAvg("4.16");
        priceXMLBuy.setMax("5.06");
        priceXMLBuy.setMin("2.00");
        priceXMLBuy.setStddev("0.55");
        priceXMLBuy.setMedian("4.03");
        priceXMLBuy.setPercentile("5.05");                
        type.addBuy(priceXMLBuy);

        PriceXML priceXMLSell = new PriceXML();
        priceXMLSell.setVolume("10301591313");
        priceXMLSell.setAvg("5.67");
        priceXMLSell.setMax("9.65");
        priceXMLSell.setMin("5.32");
        priceXMLSell.setStddev("1.01");
        priceXMLSell.setMedian("5.51");
        priceXMLSell.setPercentile("5.34");
        type.addSell(priceXMLSell);
        
        types.add(type);
    }
    
    public void display(){                 
        for (Type type : this.types ) {
            List < PriceXML > priceXMLs = type.getBuys();
            System.out.println("Buy\n");
            for (PriceXML priceXML : priceXMLs) {
                System.out.println("getVolume "+priceXML.getVolume());
                System.out.println("getAvg "+priceXML.getAvg());
                System.out.println("getMax "+priceXML.getMax());
                System.out.println("getMin "+priceXML.getMin());
                System.out.println("getStddev "+priceXML.getStddev());
                System.out.println("getMedian "+priceXML.getMedian());
                System.out.println("getPercentile "+priceXML.getPercentile());
            }
            
            System.out.println("\nSell\n");
            priceXMLs = type.getSells();
            for (PriceXML priceXML : priceXMLs) {
                System.out.println("getVolume "+priceXML.getVolume());
                System.out.println("getAvg "+priceXML.getAvg());
                System.out.println("getMax "+priceXML.getMax());
                System.out.println("getMin "+priceXML.getMin());
                System.out.println("getStddev "+priceXML.getStddev());
                System.out.println("getMedian "+priceXML.getMedian());
                System.out.println("getPercentile "+priceXML.getPercentile());                
            }
        }
        
        
    }
}
