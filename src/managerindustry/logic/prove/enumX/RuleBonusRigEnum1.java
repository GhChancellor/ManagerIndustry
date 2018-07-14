/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.enumX;

/**
 * dgmAttributeTypes Securiy status 
 * hiSecModifier 2355 null 1.0
 * lowSecModifier 2356 null 1.9
 * nullSecModifier 2357 null 2.1
 * securityModifier 2358 null 1.0  ????
 * attributeEngRigTimeBonus 2593 0.0
 * attributeEngRigMatBonus 2594 -2.0
 * attributeEngRigCostBonus 2595 0.0
 * calibration 1153
 * maxGroupFitted 1544
 * @author lele
 */
public enum RuleBonusRigEnum1 {
    T1( (short) 0),
    T2( (short) 0),
    HI_SEC( (short) 2355), 
    LOW_SEC( (short) 2356),
    NULL_SEC( (short) 2357),
    RIG_MATERIAL_EFFICIENCY( (short) 2594),
    RIG_TIME_EFFICIENCY( (short) 2593),
    RIG_COST_BONUS( (short) 2595),
    CALIBRATION( (short) 1153),
    RIG_SIZE( (short) 1547),
    MAX_GROUP_FITTED( (short) 1544);

    private final short code;

    private RuleBonusRigEnum1(short code) {
        this.code = code;
    }

    public short getCode() {
        return code;
    }
}     

