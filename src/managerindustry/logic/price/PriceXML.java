/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.price;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author lele
 */


//@XmlRootElement(name = "type" )
public class PriceXML {
    private String volume;
    private String avg;
    private String max;
    private String min;
    private String stddev;
    private String median;
    private String percentile;

//    @XmlAttribute
    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

//    @XmlAttribute
    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }

//    @XmlAttribute
    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

//    @XmlAttribute
    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

//    @XmlAttribute
    public String getStddev() {
        return stddev;
    }

    public void setStddev(String stddev) {
        this.stddev = stddev;
    }

//    @XmlAttribute
    public String getMedian() {
        return median;
    }

    public void setMedian(String median) {
        this.median = median;
    }

//    @XmlAttribute
    public String getPercentile() {
        return percentile;
    }

    public void setPercentile(String percentile) {
        this.percentile = percentile;
    }
    
}
