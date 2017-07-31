/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.price.marketParameter.createQuery;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.price.marketParameter.createQuery.parameters.Hour;

/**
 *
 * @author lele
 * @param <T>
 */
public abstract class CreateQuery{            
    public abstract String getUrl();
    public abstract String getUrlValue();
}
