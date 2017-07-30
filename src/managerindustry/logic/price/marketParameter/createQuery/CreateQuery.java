/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.price.marketParameter.createQuery;

import managerindustry.logic.price.marketParameter.createQuery.parameters.Hour;

/**
 *
 * @author lele
 * @param <T>
 */
public abstract class CreateQuery < T >{
    private T query;

    public CreateQuery(T query) {
        this.query = query;
    }

    public T getQuery() {
        return query;
    }

    public void setQuery(T query) {
        this.query = query;
    }
    
    public abstract String getUrl();
    public abstract String getUrlValue();
}
