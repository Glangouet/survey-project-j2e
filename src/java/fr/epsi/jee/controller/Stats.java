/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.jee.controller;

import fr.epsi.jee.service.QuestionService;
import fr.epsi.jee.model.Question;
import java.io.IOException;
import javax.inject.Named;
import java.io.Serializable;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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
@Dependent
public class Stats implements Serializable {

    @Inject
    @Param
    private Integer uuid;
    
    private QuestionService questionService;
    
    @Inject
    public Stats() {
        questionService = new QuestionService();
    }
    
    public Integer getUUID() {
        return uuid;
    }
    
    public Question getQuestion() throws IOException {
        Question q = questionService.find(uuid);
        
        if(uuid <= 0 || q == null) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/");
            return null;
        }
        
        return q;
    }
    
}
