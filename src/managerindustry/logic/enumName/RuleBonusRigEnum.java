/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.enumName;

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
public enum RuleBonusRigEnum {
    T1(0),
    T2(0),
    HI_SEC(2355), 
    LOW_SEC(2356),
    NULL_SEC(2357),
    RIG_MATERIAL_EFFICIENCY(2594),
    RIG_TIME_EFFICIENCY(2593),
    RIG_COST_BONUS(2595),
    CALIBRATION(1153),
    RIG_SIZE(1547),
    MAX_GROUP_FITTED(1544);

    private final int code;

    private RuleBonusRigEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}     

