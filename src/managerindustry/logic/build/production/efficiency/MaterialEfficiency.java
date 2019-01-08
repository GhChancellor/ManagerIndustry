/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.build.production.efficiency;

import managerindustry.logic.fitter.structure.engineeringComplex.EngineeringComplex;
import managerindustry.logic.fitter.structure.engineeringRig.EngineeringRig;
import managerindustry.logic.generic.fatherClass.BuildItem;

import managerindustry.logic.generic.fatherClass.NameBase;

/**
 * https://forums.eveonline.com/t/math-is-hard-between-eve-and-the-sheets/70360/2
 * https://community.eveonline.com/news/dev-blogs/eve-industry-all-you-want-to-know/
 * https://www.eveonline.com/article/building-dreams-introducing-engineering-complexes/
 * 
 * Material Efficiency Formula
    Material Efficiency Research, ME 1-10 == 1-10%
    Basic Structure ME multiplier: 0.01 == 1%
    Rig ME multiplier: 2% (T1) and 2.4% (T2) == 0,02 or 0,024
    Security Multiplier: 1, 1.9 or 2.1 == Highsec, Lowsec or Null/WH
* 
    Minerals Needed = Roundup(BaseMinerals * ((1 - ME-Reserch) * (1 - BS_ME) * (1 - (RigME * SM))))
    Example T2 Sotiyo in Null/WH: Mineral Needed = Roundup(BaseMenirals * (0.9 * 0.99 * 0.9496)) = Roundup(BaseMinerals * 0.8461)

    note: Total ME reduction is 15.39% approximate
* 
    * Time Efficiency Formula
        Time Efficiency Research, TE 2-20 == 2-20%
        Basic Structure TE multiplier: 0.15, 0.2 and 0.3 == 15, 20 and 30%
        Rig TE multiplier: 20% (T1) or 24% (T2) = 0.2 or 0.24
        Security Multiplier: 1, 1.9 or 2.1 == Highsec, Lowsec or Null/WH
        Implant Multiplier: 0.01, 0.02 or 0.04 == 1%, 2% or 4%
        Job Time = Roundup(BaseJobTime * ((1 - TE-Reserch) * (1 - BS_TE) * (1 - IM) * (1 - (RigME * SM))))
* 
    Example T2 Sotiyo in Null/WH: Job Time = Roundup(BaseJobTime * (0.8 * 0.7 * 0.96 * (1 - (0.24 * 2.1)))) = Roundup(BaseJobTime * 0,2666496)

    note: Total TE reduction is 73.34% approximatel
 * @author lele
 */
public class MaterialEfficiency extends NameBase {
    private float materialEfficiencyRate;
    private final float baseValue = 1.0f;
    private final BuildItem buildItem;
    private final NameBase materialRecusion;
    private final EngineeringRig engineeringRig;
    private final EngineeringComplex engineeringComplex;
    private boolean bpoME;
    
    public MaterialEfficiency() {
        this.buildItem = null;
        this.materialRecusion = null;
        this.engineeringRig = null;
        this.engineeringComplex = null;
    }
    
    public MaterialEfficiency(BuildItem buildItem, boolean bpoME,
            NameBase materialRecusion, EngineeringComplex engineeringComplex, 
            EngineeringRig engineeringRig) {
        
        this.bpoME = bpoME;
        this.buildItem = buildItem;
        this.materialRecusion = materialRecusion;
        this.engineeringRig = engineeringRig;
        this.engineeringComplex = engineeringComplex;
        
        calculateMaterialEfficiencyRate();
        
        materialEfficiencyCalculate();
    }

    /**
     * Init - Calculate Material Efficiency
     * job * Math.ceil( ((quantityBaseMarial * run) * materialEfficiencyRate) * structureMultiplier );
     */    
    private void materialEfficiencyCalculate(){
        
        baseQuantity = materialRecusion.getBaseQuantity();
        /*
         quando il valore è 1 non si fanno calcoli su ME
         WHen value is 1 not calculated ME        
        */
        if ( baseQuantity == 1 ){
            singleItemQuantity = baseQuantity;
            totalItemsQuantity = buildItem.getJob() * singleItemQuantity * 
                    buildItem.getRun();
            return;
        }

        /* Calculate ME by One Object */
        singleItemQuantity = 
            ( int ) Math.ceil(baseQuantity * materialEfficiencyRate *
                    buildItem.getRun());

        /* Calculate ME all items */
        totalItemsQuantity = 
            ( long ) ( buildItem.getJob() * Math.ceil( ((baseQuantity * 
                    buildItem.getRun()) * materialEfficiencyRate) ) );  
    }
    
    /**
     * calculate Material Efficiency Rate
     */
    private void calculateMaterialEfficiencyRate(){
        if (engineeringComplex == null){
            materialEfficiencyRate = getMaterialEffiencyResearchRate();
        }else{
            materialEfficiencyRate = 
                getMaterialEffiencyResearchRate() * 
                engineeringComplex.getReductionManufacturingMaterial() * 
                engineeringRig.getMaterialEfficiency_SecurityStatus();
        }
        

    }    
    
    /**
     * calculate Material effiency Research
     */
    private float getMaterialEffiencyResearchRate(){
        if ( bpoME == true )
            return baseValue - ( buildItem.getBpoME().floatValue() / 100 );
        else{
            return baseValue - ( buildItem.getComponentMe().floatValue() / 100 );
        }
    }    
}
