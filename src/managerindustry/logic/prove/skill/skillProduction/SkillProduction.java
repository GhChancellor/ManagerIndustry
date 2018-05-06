/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.skill.skillProduction;

import java.util.ArrayList;
import java.util.List;
import managerindustry.db.entities.DgmTypeAttributes;
import managerindustry.db.entities.IndustryActivitySkills;
import managerindustry.logic.enumName.RamActivitiesEnum;
import managerindustry.logic.manager.managerDB.ManagerDB;

/**
 * Oscillator Capacitor Unit Blueprint - 17337
 * Industry 1 - 3380 
 * Electromagnetic Physics 3 - 11448
 * * Science 5 - 3402 
 * * CPU Management 5 - 3426
 * SELECT * from industryActivitySkills where industryActivitySkills.typeID=17337
    and industryActivitySkills.activityID=1;
 * SELECT * from dgmTypeAttributes, dgmAttributeTypes where dgmTypeAttributes.typeID=11448
    and dgmAttributeTypes.attributeID = dgmTypeAttributes.attributeID;
 * dgmAttributeTypes   requiredSkill1 182 - requiredSkill2 183 - requiredSkill 3 184 
 * https://api.eveonline.com/eve/SkillTree.xml.aspx
 * @author lele
 */
public class SkillProduction <T>{

    public SkillProduction() {
//        skillTree();
        skillTree02();
    }
    
    public void skillTree02(){
        List < Integer > skills = new ArrayList<>();
        
        int typeId = ManagerDB.getInstance().invTypes().getIdByName("Oscillator Capacitor Unit Blueprint ").getTypeID();
        
        List<IndustryActivitySkills> requiredSkill = 
            ManagerDB.getInstance().IndustryActivitySkills().getRequiredSkill(typeId, RamActivitiesEnum.MANUFACTURING);

        for (IndustryActivitySkills industryActivitySkills : requiredSkill) {
            skills.add(industryActivitySkills.getSkillID());
        }
        
        recursion02(skills, new RecursionA());

    }
    
    public void recursion02(List < Integer > skills, RecursionA t){
        for (Integer skillID : skills) {
            
            t.setValue(skillID);
            t.addLists(new RecursionB(t));
            
            List<Integer> requiredSkillAttribute = ManagerDB.getInstance().dgmTypeAttributes().getRequiredSkillAttribute(t.getValue());
        
            if ( !requiredSkillAttribute.isEmpty()){
                recursion02(requiredSkillAttribute, t);
            }            
        }   
        System.out.println("");       
    }
    
    public void skillTree(){
        List < Integer > skills = new ArrayList<>();
        
        int typeId = ManagerDB.getInstance().invTypes().getIdByName("Oscillator Capacitor Unit Blueprint ").getTypeID();
        
        List<IndustryActivitySkills> requiredSkill = 
            ManagerDB.getInstance().IndustryActivitySkills().getRequiredSkill(typeId, RamActivitiesEnum.MANUFACTURING);

        for (IndustryActivitySkills industryActivitySkills : requiredSkill) {
            skills.add(industryActivitySkills.getSkillID());
        }

        recursion(skills, new XxxA());

    }    
    
    public void recursion(List < Integer > skills, XxxA a){

        for (Integer skillID : skills) {
            
            a.setSkillId(skillID);            
            a.addList(new XxxB(a));
            
            List<Integer> requiredSkillAttribute = ManagerDB.getInstance().dgmTypeAttributes().getRequiredSkillAttribute(a.getSkillId());
        
            if ( !requiredSkillAttribute.isEmpty()){
                recursion(requiredSkillAttribute, a);
            }            
        }   
        System.out.println("");
    }
}
/*
    dgmAttributeTypes attributeID 277-278-279-280

*/