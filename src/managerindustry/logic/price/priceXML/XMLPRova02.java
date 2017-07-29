/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.price.priceXML;

import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author lele
 */
public class XMLPRova02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        XMLPRova02 xMLPRova02 = new XMLPRova02();
        xMLPRova02.prova001();
        
    }
    
    public void prova001(){
        try {
            File file = new File("/home/lele/NetBeansProjects/ManagerIndustry/src/managerindustry/logic/price/priceXML/MarketXMLPROVA.xml");
            
            JAXBContext jAXBContext = JAXBContext.newInstance(Evec.class);
            Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
            
            Evec evec_api = (Evec) unmarshaller.unmarshal(file);
            
            List < Marketstat > marketstats = evec_api.getMarketstats();
            
            for (Marketstat marketstat : marketstats) {
                List<Type> types = marketstat.getTypes();
                
                for (Type type : types) {
                    List <MarketElement> marketElements = type.getMarketElements();
                    
                    for (MarketElement marketElement : marketElements) {
                        System.out.println(""+ marketElement.getMin() +" > "+marketElement.getClass().getName());
                    }
                    
                }
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
