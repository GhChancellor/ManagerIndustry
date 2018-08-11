/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV3;

import java.util.List;
import java.util.Map;
import managerindustry.logic.build.materialEfficiency.MaterialEfficiencyCalculate;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;


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
    private ReportItem reportItem = new ReportItem();
    private RamActivitiesEnum activitiesEnum;
    
    /**
     * @deprecated 
     * @param bpoName
     * @param run
     * @param job
     * @param bpoME
     * @param componentMe
     * @param activitiesEnum
     * @throws ErrorExeption 
     */
    public BuildItem(String bpoName, int run, int job, byte bpoME, byte componentMe, 
        RamActivitiesEnum activitiesEnum) throws ErrorExeption {
        
        this.bpoName = bpoName;
        this.run = run;
        this.job = job;
        this.bpoME = bpoME;
        this.componentMe = componentMe;
        this.activitiesEnum = activitiesEnum;
        BasicMaterialRequired basicMaterialRequired = 
            new BasicMaterialRequired(bpoName, activitiesEnum);

        // Attenzione da armonizzare
        requiredItem(basicMaterialRequired.getRequiredItems());
    }    
    
    /**
     * Calculate Required Item
     * @param List<RequiredMaterialRecusion> materialRecusions 
     */
    private void calculateRequiredItem(List<RequiredMaterialRecusion> materialRecusions){
        for (RequiredMaterialRecusion materialRecusion : materialRecusions) {
            calculateME(materialRecusion);
            calculateQuantityMaterial();
            addItem(materialRecusion);
        }
    }
     
    /**
     * Add Item
     * @param RequiredMaterialRecusion materialRecusion 
     */
    private void addItem(RequiredMaterialRecusion materialRecusion){
        Item singleItem = new Item(
            materialRecusion.getTypeID(), materialRecusion.getTypeName(), 
            singleMaterialQuantity, totalMaterialQuantity);

        reportItem.addItem(singleItem);
    }    
    
    /**
     * Calculate Quantity Material
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
     * @param RequiredMaterialRecusion materialRecusion 
     */
    private void calculateME(RequiredMaterialRecusion materialRecusion){
        if ( materialRecusion.getRecursionB02s().isEmpty()){
            // T1 material .. bpoME ..
            materialEfficiencyCalculate = new MaterialEfficiencyCalculate
                (run, job, bpoME , materialRecusion.getQuantity() );
        }else{
            // T2 component .. componentMe ..
            materialEfficiencyCalculate = new MaterialEfficiencyCalculate
                (run, job, componentMe , materialRecusion.getQuantity() );
        }        
    }
    
    @Override
    protected void requiredItem(Object materialRecusions_) {
        List<RequiredMaterialRecusion> materialRecusions = 
            ( List<RequiredMaterialRecusion> ) materialRecusions_;
        
        for (RequiredMaterialRecusion materialRecusion : materialRecusions) {
            calculateME(materialRecusion);
            calculateQuantityMaterial();
            addItem(materialRecusion);            
        }
    }
    
    public void display(){
        System.err.print(" >>>>> ATTENZIONE <<<<<<  Builditem > display DISABILITATA!!!!!");
//        display(null, null);        
    }
    
//    @Override
//    protected void display(Object t1, Object t2) {
//        List<Item> singleItems = reportItem.getSingleItems();
//
//        System.out.println("Single items");
//
//        for (Item singleItem : singleItems) {
//            System.out.println("" + singleItem.getTypeId() + " - " +
//                singleItem.getName() + " > " + 
//                singleItem.getQuanityInt() + " - " + 
//                singleItem.getQuanityDbl());
//        }        
//
//        System.out.println("---------------------------------------\n\n\n");
//        System.out.println("Total Calculated Item");
//        
//        Map<String, Item> totalCalculatedItem = reportItem.getTotalCalculatedItem();
//        for (Map.Entry<String, Item> entry : totalCalculatedItem.entrySet()) {
//            String key = entry.getKey();
//            Item value = entry.getValue();
//            System.out.println("" + value.getTypeId() + " - " + value.getName() + " > " +
//                value.getQuanityInt() + " - " + 
//                value.getQuanityDbl());  
//        }
//    }
    
    /**
     * Get Object
     * @return 
     */
    @Override
    protected Object getObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    

    @Override
    protected void requiredItem(Object t1, Object t2) {
        throw new UnsupportedOperationException("Not used"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void requiredItem(Object t1, Object t2, Object t3) {
        throw new UnsupportedOperationException("Not used"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object requiredItemMoreInfo(Object t1) {
        throw new UnsupportedOperationException("Not used"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object requiredItemMoreInfo(Object t1, Object t2) {
        throw new UnsupportedOperationException("Not used"); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
    public void itemDescription(){
        // 43867 Standup M-Set Advanced Component Manufacturing Material Efficiency I
        String bpoName = "drake Blueprint"; // Nighthawk Blueprint 
        InvTypes invTypes = Manager.getInstance().db().item().invTypes().getInvTypesByName(bpoName);
        
        List < DgmTypeAttributes > dgmTypeAttributes = 
          Manager.getInstance().db().item().dgmTypeAttributes().getTypeAttributesByTypeId(invTypes.getTypeID());
        
        System.out.println(""+ bpoName + " ID " + invTypes.getTypeID() );
        
        for (DgmTypeAttributes dgmTypeAttribute : dgmTypeAttributes) {
           
            DgmAttributeTypes dgmAttributeTypes = 
              Manager.getInstance().db().item().dgmAttributeTypes().getAttributeTypes(dgmTypeAttribute.getDgmTypeAttributesPK().getAttributeID());
            
            if (dgmTypeAttribute.getValueInt() == null) {
                System.out.println(""+ dgmAttributeTypes.getDisplayName() + "\n" + dgmAttributeTypes.getDescription()  +
                " " + dgmTypeAttribute.getValueFloat() + "\n");
            }
            
            if (dgmTypeAttribute.getValueFloat() == null) {
                System.out.println(""+ dgmAttributeTypes.getDisplayName() + "\n" + dgmAttributeTypes.getDescription()  + " " + dgmTypeAttribute.getValueInt() + "\n");                
            }
            
            if (dgmAttributeTypes.getDisplayName() == null ){
                System.out.println(""+ dgmAttributeTypes.getDescription()  + " " + dgmTypeAttribute.getValueInt() + " " + dgmTypeAttribute.getValueFloat() + "\n");
            }
            
            if ( dgmAttributeTypes.getDescription() == null ){
                System.out.println(""+ dgmAttributeTypes.getDisplayName() + "\n" + dgmTypeAttribute.getValueInt() + " " + dgmTypeAttribute.getValueFloat() + "\n");                
            }
            
            System.out.println(""+ dgmAttributeTypes.getDisplayName() + "\n" + dgmAttributeTypes.getDescription()  + " " +
             + dgmAttributeTypes.getAttributeID() + " " + dgmTypeAttribute.getValueInt() + " " + dgmTypeAttribute.getValueFloat() + "\n");
        }        
    }    
    */
}
