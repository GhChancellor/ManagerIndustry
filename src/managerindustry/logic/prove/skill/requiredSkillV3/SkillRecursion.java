/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.skill.requiredSkillV3;

import managerindustry.db.entities.eve.DgmTypeAttributes;
import managerindustry.logic.manager.Manager;

/**
 *
 * @author lele
 */
public class SkillRecursion {
    private int typeId;

    public SkillRecursion() {
        typeId = 3397;
        recursion(typeId);
    }
    
    private void recursion(int typeId){
//        Prova001 prova = Manager.getInstance().db().item().dgmTypeAttributes().getProva(typeId);
        System.out.println("");
    }
    
    /**
     * Skill Required
     * @param int typeID
     * @param int skillRequired
     * @return 
     */
    private DgmTypeAttributes getSkillRequired(int typeID, int skillRequired){
        DgmTypeAttributes dgmTypeAttributes = Manager.getInstance().db().item().dgmTypeAttributes().
                getTypeAttributesByTypeId_ByAttributeID(typeID, skillRequired);
        
        return dgmTypeAttributes;
    }       
}
/*
 attributeID 
    skill required 182 - 183 - 184 
    skill required level 277 - 278 - 279

  SELECT b.typeID, a.attributeID, a.displayName, b.attributeID, a.attributeName, b.valueInt, valueFloat FROM  
  dgmAttributeTypes as a, dgmTypeAttributes as b
 	where b.typeID= "3397" and
	 b.attributeID = a.attributeID;

SELECT * FROM invTypes where invTypes.typeID=3397; Advanced Medium Ship Construction

 SELECT * FROM dgmTypeAttributes where dgmTypeAttributes.typeID=3397;
   SELECT * FROM dgmTypeAttributes where dgmTypeAttributes.typeID=3392;
   SELECT * FROM dgmTypeAttributes where dgmTypeAttributes.typeID=3395;
     SELECT * FROM dgmTypeAttributes where dgmTypeAttributes.typeID=3395;
  	   SELECT * FROM dgmTypeAttributes where dgmTypeAttributes.typeID=3392;
  	   SELECT * FROM dgmTypeAttributes where dgmTypeAttributes.typeID=3380;
*/