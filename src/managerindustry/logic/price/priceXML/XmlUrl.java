/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.price.priceXML;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author lele
 */
public class XmlUrl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String value ="http://api.eve-central.com/api/marketstat?typeid=35&usesystem=30000142";
        
        XmlUrl xmlUrl = new XmlUrl();
//        xmlUrl.prova002();
        xmlUrl.xmlProva(value);
        xmlUrl.prova001(value);
        
    }
    
    public void xmlProva( String xmlUrl ){
        try {
            URL url = new URL(xmlUrl);
           
            Evec evec_api = JAXB.unmarshal(url, Evec.class);
            
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
    
    
    public void prova001(String xxx){
        xxx ="https://esi.tech.ccp.is/latest/industry/systems/?datasource=tranquility";
        try {
            URL url = new URL(xxx);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            
            for (String line; (line = reader.readLine()) != null;) {
                System.out.println(line);
            } 
        } catch (Exception e) {
            e.printStackTrace();            
        }
    } 
    
    public void prova002(){
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
