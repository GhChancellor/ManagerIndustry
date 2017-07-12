/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.market;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author lele
 */
@XmlRootElement
public class PriceXML {
    private String volume;
    private String avg;
    private String max;
    private String min;
    private String stddev;
    private String median;
    private String percentile;

    @XmlElement
    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    @XmlElement
    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }

    @XmlElement
    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    @XmlElement
    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    @XmlElement
    public String getStddev() {
        return stddev;
    }

    public void setStddev(String stddev) {
        this.stddev = stddev;
    }

    @XmlElement
    public String getMedian() {
        return median;
    }

    public void setMedian(String median) {
        this.median = median;
    }

    @XmlElement
    public String getPercentile() {
        return percentile;
    }

    public void setPercentile(String percentile) {
        this.percentile = percentile;
    }
    
}
