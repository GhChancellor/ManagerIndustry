/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.ricorsione.skill.skillProduction;

import java.util.ArrayList;
import java.util.List;
import managerindustry.db.entities.eve.DgmTypeAttributes;
import managerindustry.db.entities.eve.IndustryActivitySkills;
import managerindustry.logic.enumName.RamActivitiesEnum;
import managerindustry.logic.manager.Manager;
import managerindustry.logic.manager.db.Db;

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
    
    public void recursion02(List < Integer > skills, RecursionA y){
        for (Integer skillID : skills) {
            
            RecursionA a = new RecursionA();
            a.setValue(skillID);
            y.addLists(new RecursionB(a));
            
            List<Integer> requiredSkillAttribute = Manager.getInstance().db().item().dgmTypeAttributes().getRequiredSkillAttribute(a.getValue());
        
            if ( !requiredSkillAttribute.isEmpty()){
                recursion02(requiredSkillAttribute, a);
            }            
        }
        
    }

    public void skillTree02(){
        List < Integer > skills = new ArrayList<>();
        
        int typeId = Manager.getInstance().db().item().invTypes().getInvTypesByName("Oscillator Capacitor Unit Blueprint ").getTypeID();
        
        List<IndustryActivitySkills> requiredSkill = 
            Manager.getInstance().db().item().industryActivitySkills().getRequiredSkill(typeId, RamActivitiesEnum.MANUFACTURING);

        for (IndustryActivitySkills industryActivitySkills : requiredSkill) {
            skills.add(industryActivitySkills.getSkillID());
        }
        
        RecursionA a = new RecursionA(typeId);
        
        recursion02(skills, a );
        
        System.out.println("aa");
        
    }      
    
    public void recursion(List < Integer > skills, XxxA xxx){

        for (Integer skillID : skills) {
            
            XxxA a = new XxxA();
            a.setSkillId(skillID);            
            xxx.addList(new XxxB(a));            
            
            List<Integer> requiredSkillAttribute = Manager.getInstance().db().item().dgmTypeAttributes().getRequiredSkillAttribute(a.getSkillId());

            
            if ( !requiredSkillAttribute.isEmpty()){
                recursion(requiredSkillAttribute, a);
            }            
        }   
    }
    
    public void skillTree(){
        List < Integer > skills = new ArrayList<>();
        
        int typeId = Manager.getInstance().db().item().invTypes().getInvTypesByName("Oscillator Capacitor Unit Blueprint ").getTypeID();
        
        List<IndustryActivitySkills> requiredSkill = 
            Manager.getInstance().db().item().industryActivitySkills().getRequiredSkill(typeId, RamActivitiesEnum.MANUFACTURING);

        for (IndustryActivitySkills industryActivitySkills : requiredSkill) {
            skills.add(industryActivitySkills.getSkillID());
        }

        XxxA xxxA = new XxxA(typeId);
        
        recursion(skills, xxxA );
        System.out.println("aa");
    }    

}
/*
    dgmAttributeTypes attributeID 277-278-279-280

*/