/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.efficiency;

/**
 * https://forums.eveonline.com/t/math-is-hard-between-eve-and-the-sheets/70360/2
 * https://community.eveonline.com/news/dev-blogs/eve-industry-all-you-want-to-know/
 * 
 * @author lele
 */
public class Efficiency{
    private Byte bpoLevel;
    protected float efficiencyResearchRate;
    
    protected float structureMultiplier; 
    private float structureRate;
    
    private float engineeringRigMultiplier;
    private float engineeringRigRate;
    
    protected float securityStatusMultiplier;
    private float securityStatusRate;
    
    protected float implantMultiplier;
    private float implantRate;        
    
    private final float baseValue = 1f;    

    /**
     * Material Efficiency
     * @param Byte bpoLevel
     * @param float structureRate
     * @param float engineeringRigRate
     * @param float securityStatusRate 
     */
    public Efficiency(byte bpoLevel, float structureRate, float engineeringRigRate, 
            float securityStatusRate) {
        
        this.bpoLevel = bpoLevel;
        this.structureRate = structureRate;
        this.engineeringRigRate = engineeringRigRate;
        this.securityStatusRate = securityStatusRate;
        
        meResearchRate();
        structureMultiplier();
        engineeringRigMultiplier();
        securityMultiplier();        
    }
    
    /**
     * Time Efficiency
     * @param Byte bpoLevel
     * @param float structureRate
     * @param float engineeringRigRate
     * @param float securityStatusRate 
     */    
    public Efficiency(byte bpoLevel, float structureRate, float engineeringRigRate, 
            float securityStatusRate, float implantRate) {
        
        this.bpoLevel = bpoLevel;
        this.structureRate = structureRate;
        this.engineeringRigRate = engineeringRigRate;
        this.securityStatusRate = securityStatusRate;     
        this.implantRate = implantRate;
        
        teResearchRate();
        structureMultiplier();
        engineeringRigMultiplier();
        securityMultiplier();
        implantMultiplier();
    }    
    
    private void teResearchRate(){
        efficiencyResearchRate = baseValue - (( bpoLevel.floatValue() / 100 ) * 2);
    }
    
    /**
     * calculate Material effiency Research
     */
    private void meResearchRate(){
        efficiencyResearchRate = baseValue - ( bpoLevel.floatValue() / 100 );
    }
    
    /**
     * calculate structure Multiplier
     */
    private void structureMultiplier(){
        structureMultiplier = baseValue - structureRate;
    }
    
    /**
     * calculate engineering Rig Multiplier
     */
    private void engineeringRigMultiplier(){
        engineeringRigMultiplier = baseValue - engineeringRigRate;
    }
    
    /**
     * calculate security Multiplier
     */
    private void securityMultiplier(){
        securityStatusMultiplier = baseValue - ( engineeringRigMultiplier * securityStatusRate );
    }    
    
    /**
     * calculate implant Multiplier
     */
    private void implantMultiplier(){
        implantMultiplier = baseValue - implantRate;
    }
}
