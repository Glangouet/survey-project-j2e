/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.jee.controller;

import fr.epsi.jee.model.Answer;
import fr.epsi.jee.model.Question;
import fr.epsi.jee.model.Vote;
import fr.epsi.jee.service.QuestionService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Ludo Renzetti
 */
@Named(value = "SurveyItem")
@RequestScoped
@ManagedBean
public class SurveyItem implements Serializable {
    
    private Long id;
    
    private QuestionService questionService;
    
    private Question question;
    
    @PostConstruct
    public void init() {
        String rawId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get( "id" );
        id = Long.parseLong(rawId);
        
        questionService = new QuestionService();
    }
    
    private void loadQuestion() {
        question = questionService.find(id);
    }
    
    public Question getQuestion() {
        if(question == null)
            loadQuestion();

        return question;
    }
    
    public void vote(Integer index) {
        Vote v = new Vote();
        Answer a;
        
        a = getQuestion().getAnswers().get(index);
        v.setAnswer(a);
        a.setVote(v);
        questionService.save(question);
    }
    
}
