/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.buiild;

/**
 *
 * @author lele
 */
public class MaterialCalc {
//    private int run; // = 7;
//    private int quantityBaseMarial; // = 2777778;
//    private int job; // = 6;
//    private double materialEfficiencyRate; // = 0.91;
    private static final double platformModifier = 1;
    
   
    
    public static int calculateMaterialEfficiency( int job, int run, int quantityBaseMarial, int bpoME ){       
//        job = job;
//        run = run;
//        quantityBaseMarial= quantityBaseMarial;
        double materialEfficiencyRate = new MaterialEfficiency(bpoME).calculateRateBpo();
        
        Double value = null;
        // Lele da controllare con MOLTA attenzione
//        Double value = job * ( Math.ceil(run * (quantityBaseMarial * materialEfficiencyRate ) * platformModifier  ));


        if ( quantityBaseMarial == 1 ){
            return job * (quantityBaseMarial * run);
        }            

        // miki giusta 
        // job * ceil( ( (base * runs_nel_job) * ME) * platform) ;      
        value = job * Math.ceil( ((quantityBaseMarial * run) * materialEfficiencyRate) * platformModifier );
        return value.intValue();
    }
    
//
//    /**
//     * Get Run
//     * @return int
//     */
//    public int getRun() {
//        return run;
//    }
//
//    /**
//     * Set Run
//     * @param int run 
//     */
//    public void setRun(int run) {
//        this.run = run;
//    }
//
//    /**
//     * Get Job
//     * @return int
//     */
//    public int getJob() {
//        return job;
//    }
//
//    /**
//     * Set Job
//     * @param int job 
//     */
//    public void setJob(int job) {
//        this.job = job;
//    }
    
    
}
