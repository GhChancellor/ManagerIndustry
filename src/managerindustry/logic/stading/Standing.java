/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.stading;

/**
 *
 * @author lele
 */
public class Standing {
    private float corporationStanding = 7.24f;
    private float factionStanding = 3.0f;

    public Standing(String station) {
    }

    public float getCorporationStanding() {
        return corporationStanding;
    }

    public void setCorporationStanding(float corporationStanding) {
        this.corporationStanding = corporationStanding;
    }

    public float getFactionStanding() {
        return factionStanding;
    }

    public void setFactionStanding(float factionStanding) {
        this.factionStanding = factionStanding;
    }
    
}
