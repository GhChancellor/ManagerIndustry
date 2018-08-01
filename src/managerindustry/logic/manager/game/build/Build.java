/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.game.build;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import managerindustry.db.entities.eve.DgmAttributeTypes;
import managerindustry.db.entities.eve.DgmTypeAttributes;
import managerindustry.db.entities.eve.IndustryActivityMaterials;
import managerindustry.db.entities.eve.InvTypes;
import managerindustry.logic.build.CalculatedComponentX;
import managerindustry.logic.build.ComponentX;
import managerindustry.logic.build.MaterialEfficiencyCalculate;
import managerindustry.logic.build.MaterialForComponents;
import managerindustry.logic.build.ReportCalculatedComponentX;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.manager.Manager;

/**
 * @author lele
 */
public class Build {
    private List < ComponentX > reportMaterialForComponents = new ArrayList<>();
    private Map < String, ReportCalculatedComponentX> totalCalculatedComponentXmap = new HashMap<>();
    
    public void displayTotalMaterial(){
        System.out.println("\nTotal Material");
        for (Map.Entry<String, ReportCalculatedComponentX> entry : totalCalculatedComponentXmap.entrySet()) {
            String key = entry.getKey();
            ReportCalculatedComponentX value = entry.getValue();
            System.out.println("XXXXX" + value.getName() + " " + String.format("%.0f", value.getQuanityDbl()));
        }            
    }

    public Build() {
    }
    
    public Build(String bpoName, int run, int job, byte bpoME, 
        byte componentMe) {
       
        RamActivitiesEnum activitiesEnum = RamActivitiesEnum.MANUFACTURING;

        bpoName += " blueprint";
        System.out.println("" + bpoName);
        
        List< IndustryActivityMaterials> nameItemToBuild = 
         Manager.getInstance().db().item().industryActivityMaterials().getMaterialNeedByName(bpoName, activitiesEnum);
        
        ComponentX componentX = new ComponentX();
        baseMaterial(nameItemToBuild, componentX, activitiesEnum );
        
        List < MaterialForComponents > materials = componentX.getMaterialForComponents();
        
        componentX = new ComponentX();
        buildItem(bpoName, run, job, bpoME, componentMe, materials, componentX);
        
        reportMaterialForComponents.add(componentX);
        
        // bug ComponetX viene cancellato di baseMaterial, viene cancellato 
        // e sostituti con build item e quindi NON si avavrà mai i valori puri del DB
        displayMap(componentX, "");
        
        componentX = new ComponentX();
        
        totalCalculatedComponentXmap = 
            ManagerComponentX.getInstance().getReportCalculatedComponentXMap();
    
        displayTotalMaterial();        

    }
    
    /**
     * Build Item, I varoli sono calcolati per ottenere la quantità di una singolo oggetto e 
     * DOPO sono moltiplicati per gli oggetti necesserati
     * Scimitar x 1 ME 10 
     * * Plasma Thruster 68 
     * * * Phenolic Composites 184 
     * @param String bpoName
     * @param int run
     * @param int job
     * @param byte bpoME
     * @param byte componentMe
     * @param int materials
     * @param dad 
     */
    private void buildItem(String bpoName, int run, int job, byte bpoME, 
            byte componentMe, List < MaterialForComponents > materials, 
            ComponentX dad){    
               
        for (MaterialForComponents material : materials) {            
            // calculate materialEfficiencyCalculate
            MaterialEfficiencyCalculate materialEfficiencyCalculate;
            
            // check if item is t1 or t2
            if (material.getComponentX().getMaterialForComponents().isEmpty()){
                // me for T1
                MaterialEfficiencyCalculate materialEfficiencyCalculateX = 
                 new MaterialEfficiencyCalculate(run, job, bpoME , material.getComponentX().getQuanityInt() );
                
                materialEfficiencyCalculate = materialEfficiencyCalculateX;                
            }else{
                // me for component ( t2 )
                MaterialEfficiencyCalculate materialEfficiencyCalculateX = 
                    new MaterialEfficiencyCalculate(run, job, componentMe , material.getComponentX().getQuanityInt() ); 
                
                materialEfficiencyCalculate = materialEfficiencyCalculateX;
            }

            // quantity material per single item 1 run
            int singleMaterial = 
                    materialEfficiencyCalculate.getSingleItemMaterial();
           
            // quantity material per all items 1 run
            double totalMaterials = 
                    materialEfficiencyCalculate.getTotalItemsMaterials(); 
            
            ComponentX componentX = new ComponentX();
            componentX.setName(material.getComponentX().getName());
            componentX.setQuanityInt(singleMaterial);
            componentX.setQuanityDbl(totalMaterials);
            dad.addMaterialForComponents( new MaterialForComponents(componentX));
            
            // Single item scimitar x 1
            CalculatedComponentX calculatedComponentX = new CalculatedComponentX
                (material.getName(), singleMaterial, totalMaterials);            
            
            // add object values
            ManagerComponentX.getInstance().addCalculatedComponentXs(calculatedComponentX);

            // Put report Calculated Components
            ReportCalculatedComponentX reportCalculatedComponentX = 
             new ReportCalculatedComponentX(material.getComponentX().getName(), singleMaterial, totalMaterials);
            
            // Sum all values of the items to map Scimitar x 2
            ManagerComponentX.getInstance().sumReportCalculatedComponentXMap
                (reportCalculatedComponentX);
            
            // get Value for components T2
            List < MaterialForComponents > materialForComponents = 
             material.getComponentX().getMaterialForComponents();
            
            if ( materialForComponents != null){
                int tempJob = 1;
                byte tempComponetMe = 1;
                
                buildItem("", singleMaterial, tempJob, bpoME, 
                 tempComponetMe, materialForComponents, componentX );
            }            
        }
    }        
    
    /**
     * Gel all raw material to build a items
     * @param List< IndustryActivityMaterials> nameItemToBuild
     * @param ComponentX dad
     * @param ComponentX activitiesEnum 
     */
    private void baseMaterial(List< IndustryActivityMaterials> nameItemToBuild,
     ComponentX dad, RamActivitiesEnum activitiesEnum){   
        for (IndustryActivityMaterials nameItemToBuild1 : nameItemToBuild) {
            InvTypes invTypes =
              Manager.getInstance().db().item().invTypes().getInvTypesById(nameItemToBuild1.getMaterialTypeID());
//            System.out.println(tab + invTypes.getTypeID() + " " + invTypes.getTypeName() + " " + nameItemToBuild1.getQuantity());

            ComponentX componentX = new ComponentX();
            componentX.setName(invTypes.getTypeName());
            componentX.setQuanityInt(nameItemToBuild1.getQuantity());
            dad.addMaterialForComponents(new MaterialForComponents(componentX));
            
            List< IndustryActivityMaterials> neededComponents = 
              Manager.getInstance().db().item().industryActivityMaterials().getMaterialNeedByName(invTypes.getTypeName() + " blueprint", activitiesEnum);

            if (neededComponents != null)
                baseMaterial(neededComponents, componentX, activitiesEnum);

        }
    }
    
    @Deprecated
    public void displayMap(ComponentX dad, String tab){
        System.out.println(tab + dad.getName() + " " + dad.getQuanityInt() + " -> " + String.format("%.0f", dad.getQuanityDbl()) );
        tab += "\t";
        
        for (MaterialForComponents componentse : dad.getMaterialForComponents()) {
            displayMap(componentse.getComponentX(), tab);
        }
    } 
    
    
    /**
     * Funziona ma ha un bug 
     * ManagerBuild managerBuild = new ManagerBuild("scimitar", 2, 2, 9, 10);
     * il " 9 " lo prende sia per il t1 che per i t2 mentre il" 10 " viene ignorato
     * da eliminare quando hai la sicurezza che l'altra si totalmente funzionante
     * Scimitar x 1 ME 10 
     * * Plasma Thruster 68 
     * * * Phenolic Composites 184 
     * @param bpoName
     * @param run
     * @param job
     * @param byte bpoME
     * @param componentMe
     * @param materials
     * @param dad 
     * @deprecated 
     */
    private void buildItemOLD(String bpoName, int run, int job, byte bpoME, 
            byte componentMe, List < MaterialForComponents > materials, 
            ComponentX dad){    
               
        for (MaterialForComponents material : materials) {            
            // calculate materialEfficiencyCalculate
            
            MaterialEfficiencyCalculate materialEfficiencyCalculate = 
             new MaterialEfficiencyCalculate
             (run, job, bpoME , material.getComponentX().getQuanityInt() );

            // quantity material per single item 1 run
            int singleMaterial = 
                    materialEfficiencyCalculate.getSingleItemMaterial();
           
            // quantity material per all items 1 run
            double totalMaterials = 
                    materialEfficiencyCalculate.getTotalItemsMaterials(); 
            
            ComponentX componentX = new ComponentX();
            componentX.setName(material.getComponentX().getName());
            componentX.setQuanityInt(singleMaterial);
            componentX.setQuanityDbl(totalMaterials);
            
            // Single item scimitar x 1
            CalculatedComponentX calculatedComponentX = new CalculatedComponentX
                (material.getName(), singleMaterial, totalMaterials);            
            
            // add object values
            ManagerComponentX.getInstance().addCalculatedComponentXs(calculatedComponentX);

            // Put report Calculated Components
            ReportCalculatedComponentX reportCalculatedComponentX = 
             new ReportCalculatedComponentX(material.getComponentX().getName(), singleMaterial, totalMaterials);
            
            // Sum all values of the items to map Scimitar x 2
            ManagerComponentX.getInstance().sumReportCalculatedComponentXMap
                (reportCalculatedComponentX);
            
            // get Value for compoenents T2
            List < MaterialForComponents > materialForComponents = 
             material.getComponentX().getMaterialForComponents();
            
            dad.addMaterialForComponents( new MaterialForComponents(componentX));
                     
            if ( materialForComponents != null){
                int tempJob = 1;
                byte tempComponentMe = 1;
                
                buildItem("", singleMaterial, tempJob, bpoME, 
                 tempComponentMe, materialForComponents, componentX );
            }            
        }
    }    

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
    
}
