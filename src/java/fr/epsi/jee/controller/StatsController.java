/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.jee.controller;

import fr.epsi.jee.model.Question;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.omnifaces.cdi.Param;

/**
 *
 * @author Ludo Renzetti
 */
@Named(value = "stats")
@RequestScoped
@ManagedBean
public class StatsController implements Serializable {

    @Inject
    @Param
    private Integer uuid;
    
    @Inject
    public StatsController() {
    }
    
    public Integer getUUID() {
        return uuid;
    }
    
    public Question getQuestion() throws IOException {
        if(uuid <= 0) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/");
            return null;
        }
        
        return null;
    }
    
}
