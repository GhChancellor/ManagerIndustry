/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.immondizia;

/**
 *
 * @author lele
 */
public class New001 {

    public New001() {
        New002 new002 = new New002();
        a001(new002);
        System.out.println(""+ new002.getA());
    }

    public void a001(New002 new002){
        new002.setA(10);
    }
}

