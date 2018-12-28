/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.efficiency;

import managerindustry.logic.fitter.structure.engineeringComplex.EngineeringComplex;
import managerindustry.logic.fitter.structure.engineeringRig.EngineeringRig;
import managerindustry.logic.generic.fatherClass.BuildItem;
import managerindustry.logic.generic.fatherClass.NameBase;

/**
 * https://forums.eveonline.com/t/math-is-hard-between-eve-and-the-sheets/70360/2
 * https://community.eveonline.com/news/dev-blogs/eve-industry-all-you-want-to-know/
 * Material Efficiency Formula
    Material Efficiency Research, ME 1-10 == 1-10%
    Basic Structure ME multiplier: 0.01 == 1%
    Rig ME multiplier: 2% (T1) and 2.4% (T2)
    Security Multiplier: 1, 1.9 or 2.1 == Highsec, Lowsec or Null/WH
* 
    Minerals Needed = Roundup(BaseMinerals * ((1 - ME-Reserch) * (1 - BS_ME) * (1 - (RigME * SM))))
    Example T2 Sotiyo in Null/WH: Mineral Needed = Roundup(BaseMenirals * (0.9 * 0.99 * 0.9496)) = Roundup(BaseMinerals * 0.8461)

    note: Total ME reduction is 15.39% approximate
* 
    * Time Efficiency Formula
        Time Efficiency Research, TE 2-20 == 2-20%
        Basic Structure TE multiplier: 0.15, 0.2 and 0.3 == 15, 20 and 30%
        Rig TE multiplier: 20% (T1) or 24% (T2)
        Security Multiplier: 1, 1.9 or 2.1 == Highsec, Lowsec or Null/WH
        Implant Multiplier: 0.01, 0.02 or 0.04 == 1%, 2% or 4%
        Job Time = Roundup(BaseJobTime * ((1 - TE-Reserch) * (1 - BS_TE) * (1 - IM) * (1 - (RigME * SeM))))
* 
    Example T2 Sotiyo in Null/WH: Job Time = Roundup(BaseJobTime * (0.8 * 0.7 * 0.96 * (1 - (0.24 * 2.1)))) = Roundup(BaseJobTime * 0,2666496)

    note: Total TE reduction is 73.34% approximatel
 * @author lele
 */
public class Efficiency extends NameBase{
    private Byte bpoLevel;
    protected float timeEffiencyResearchRate;
    protected float materialEffiencyResearchRate;
    protected float costBonus;
    
    
    
    
    protected float structureMultiplier; 
    private float structureRate;
    
    private float engineeringRigMultiplier;
    private float engineeringRigRate;
    
    protected float securityStatusMultiplier;
    private float securityStatusRate;
    
    protected float implantMultiplier;
    private float implantRate;        
    
    private final float baseValue = 1f;    

    public Efficiency() {
    }
    
    /**
     * calculate Material effiency Research
     */    
    protected void materialEffiencyResearchRate(BuildItem buildItem,
            NameBase materialRecusion, EngineeringRig engineeringRig, 
            EngineeringComplex engineeringComplex){
        
        this.bpoLevel = buildItem.getBpoME();
        materialEffiencyResearchRate = baseValue - ( bpoLevel.floatValue() / 100 );
    }     
    
//    /**
//     * Time Effiency Research Rate
//     */
//    protected void timeEffiencyResearchRate(byte bpoLevel, float structureRate, 
//            float engineeringRigRate, float securityStatusRate){
//        
//        this.bpoLevel = bpoLevel;
//        timeEffiencyResearchRate = baseValue - (( this.bpoLevel.floatValue() / 100 ) * 2);
//        
//        genericInit(structureRate, engineeringRigRate, securityStatusRate);
//        implantMultiplier();
//    }
    
    /**
     * calculate structure Multiplier
     */
    private void engineeringComplexMultiplier(EngineeringComplex engineeringComplex){
        if ( engineeringComplex.getReductionManufacturingMaterial() == 0 ){
            structureMultiplier = 1f;
            return;
        }

        structureMultiplier = 
            engineeringComplex.getReductionManufacturingMaterial();
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
    
    private void genericInit(float structureRate, float engineeringRigRate, 
            float securityStatusRate){
        
        this.structureRate = structureRate;
        this.engineeringRigRate = engineeringRigRate;
        this.securityStatusRate = securityStatusRate;  
        
//        engineeringComplexMultiplier();
        engineeringRigMultiplier();
        securityMultiplier();
    }
}
