/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.ricorsione.skill.skillProduction;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lele
 */
public class XxxA {
    List<XxxB> list = new ArrayList<>();
    private int skillId;

    public XxxA() {
    }

    public XxxA(int skillId) {
        this.skillId = skillId;
    }

    public List<XxxB> getList() {
        return list;
    }

    public void setList(List<XxxB> list) {
        this.list = list;
    }

    public void addList(XxxB b) {
        this.list.add(b);
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int value) {
        this.skillId = value;
    }
    
    
}
