/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV2;

import java.util.List;
import managerindustry.logic.build.materialEfficiency.MaterialEfficiencyCalculate;
import managerindustry.logic.generic.GenericRequiredItem;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.recursion.ItemRecursionA;
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
    private int singleMaterialQuantity;
    private double totalMaterialQuantity;    
    private RequiredMaterialRecusion basicRequiredMaterial;
    private ReportItem reportItem = new ReportItem(); 
    RequiredMaterialRecusion requiredA00 = new RequiredMaterialRecusion();
    
    private void calculateRequiredItem( RequiredMaterialRecusion basicRequiredMaterial, RequiredMaterialRecusion requiredA00) {        
        List<ItemRecursionB> recursionB = basicRequiredMaterial.getRecursionB02s();
        for (ItemRecursionB recursionB_ : recursionB) {
            
            RequiredMaterialRecusion requiredA_ = (RequiredMaterialRecusion) (ItemRecursionA) recursionB_.getRecursionA02();
            
            calculateME(requiredA_);
            calculateQuantityMaterial();
            
            RequiredMaterialRecusion calculateItemMaterial = 
                getRequiredMaterialRecusion(requiredA_);            
            
            addItem(calculateItemMaterial);
            
            if ( !recursionB_.getRecursionA02().getRecursionB02s().isEmpty() ){                
                calculateRequiredItem( 
                    (RequiredMaterialRecusion) recursionB_.getRecursionA02() , 
                    calculateItemMaterial );                
            }
        }       
    }

    private void addItem(RequiredMaterialRecusion requiredA01){
        Item singleItem = new Item(
            requiredA01.getTypeID(), requiredA01.getTypeName(), 
            singleMaterialQuantity, totalMaterialQuantity);

        reportItem.addItem(singleItem);
    }
    
    /**
     * Set Required Material Recusion
     * @param RequiredMaterialRecusion requiredA 
     */
    private RequiredMaterialRecusion getRequiredMaterialRecusion(RequiredMaterialRecusion requiredA ){
        RequiredMaterialRecusion requiredA_ = 
            new RequiredMaterialRecusion(requiredA.getTypeID(), requiredA.getTypeName(), singleMaterialQuantity, totalMaterialQuantity);
        requiredA_.addRecursionB02( new ItemRecursionB(requiredA) );        
        return requiredA;
    }
    
    /**
     * 
     */
    private void calculateQuantityMaterial(){
        // quantity material per single item 1 run
        singleMaterialQuantity = materialEfficiencyCalculate.getSingleItemMaterial();
           
        // quantity material per all items 1 run
        totalMaterialQuantity = materialEfficiencyCalculate.getTotalItemsMaterials();         
        
        // destroy object
        materialEfficiencyCalculate = null;
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
                
        calculateRequiredItem(this.basicRequiredMaterial, requiredA00);
        System.out.println("");
    }
    
    public BuildItem() {
    }
    
    public void displayBuildMaterialRequired(){
        displayRequiredItem( requiredA00 , "");
    }
    
    @Override
    protected void displayRequiredItem(Object requiredItemA, String tab) {
        RequiredMaterialRecusion requiredItemA_ = (RequiredMaterialRecusion) requiredItemA;
        
        System.out.println(tab + requiredItemA_.getTypeID() + " " + 
            requiredItemA_.getTypeName()+ " " + 
            requiredItemA_.getQuantity()+ " - " +
            requiredItemA_.getQuanityDbl());
        
        tab +="\t";
        
        for (ItemRecursionB requiredItem : requiredItemA_.getRecursionB02s()) {
            displayRequiredItem((RequiredMaterialRecusion) requiredItem.getRecursionA02(), tab);
        }           
    }
    
    @Override
    protected void calculateRequiredItem(List t, Object x, RamActivitiesEnum activitiesEnum) {
        throw new UnsupportedOperationException("Unused"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object getRequiredItem() {
        return reportItem;
    }    
}
