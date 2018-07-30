/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV2;

import java.util.List;
import managerindustry.logic.build.MaterialEfficiencyCalculate;
import managerindustry.logic.generic.GenericRequiredItem;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.recursion.ItemRecursionB;

/**
 *
 * @author lele
 */
public class BuildItem extends GenericRequiredItem{
    private MaterialEfficiencyCalculate materialEfficiencyCalculate = new MaterialEfficiencyCalculate();
    private String bpoName;
    private int run;
    private int job;
    private byte bpoME;
    private byte componentMe;
    private int singleMaterial;
    private double totalMaterials;
    
    private RequiredMaterialRecusion basicRequiredMaterial;
    

    private void calculateRequiredItem( RequiredMaterialRecusion basicRequiredMaterial, RequiredMaterialRecusion requiredA) {        
        
        System.out.println(""+ basicRequiredMaterial.getTypeName());
        
        if ( !basicRequiredMaterial.getRecursionB02s().isEmpty())
            calculateRequiredItem(basicRequiredMaterial, requiredA);
            
//        calculateME(basicRequiredMaterial);
//        QUALCOSA_001();
//        QUALCOSA_002(requiredA);
        
//        System.out.println("");
        

        
    }

    /**
     * @deprecated 
     * @param RequiredMaterialRecusion requiredA 
     */
    private void QUALCOSA_002(RequiredMaterialRecusion requiredA){
        RequiredMaterialRecusion requiredA_ = 
            new RequiredMaterialRecusion(basicRequiredMaterial.getTypeID(), basicRequiredMaterial.getTypeName(), singleMaterial, totalMaterials);
        requiredA.addRecursionB02( new ItemRecursionB(requiredA_));        
    }
    
    /**
     * @deprecated 
     */
    private void QUALCOSA_001(){
        // quantity material per single item 1 run
        int singleMaterial = 
            materialEfficiencyCalculate.getSingleItemMaterial();
           
        // quantity material per all items 1 run
        double totalMaterials = 
            materialEfficiencyCalculate.getTotalItemsMaterials();           
    }
    
    /**
     * Calculate ME
     * @param RequiredMaterialRecusion basicRequiredMaterial 
     */
    private void calculateME(RequiredMaterialRecusion basicRequiredMaterial ){
        if ( basicRequiredMaterial.getRecursionB02s().isEmpty()){
            // T1 material .. bpoME ..
            materialEfficiencyCalculate = new MaterialEfficiencyCalculate(run, job, bpoME , basicRequiredMaterial.getQuantity() );
        }else{
            // T2 component .. componentMe ..
            materialEfficiencyCalculate = new MaterialEfficiencyCalculate(run, job, componentMe , basicRequiredMaterial.getQuantity() );
        }
    }

    public BuildItem(String bpoName, int run, int job, byte bpoME, byte componentMe, RequiredMaterialRecusion basicRequiredMaterial) {
        this.bpoName = bpoName;
        this.run = run;
        this.job = job;
        this.bpoME = bpoME;
        this.componentMe = componentMe;
        this.basicRequiredMaterial = basicRequiredMaterial;
        
        calculateRequiredItem(basicRequiredMaterial, new RequiredMaterialRecusion());
    }
    
    public BuildItem() {
    }
    
    @Override
    protected void calculateRequiredItem(List t, Object x, RamActivitiesEnum activitiesEnum) {
        throw new UnsupportedOperationException("Unused"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void displayRequiredItem(Object t, String tab) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object getRequiredItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
