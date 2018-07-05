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
import fr.epsi.jee.utils.RedirectUtil;
import java.io.IOException;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
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

        if(question == null)
            RedirectUtil.redirect("/index.xhtml");
    }
    
    public Question getQuestion() {
        if(question == null)
            loadQuestion();
        
        return question;
    }
    
    public void vote(Integer index) throws IOException {
        Vote v = new Vote();
        Answer a;
        
        a = getQuestion().getAnswers().get(index);
        v.setAnswer(a);
        a.setVote(v);
        questionService.save(question);
        
        RedirectUtil.redirect(
                "/results.xhtml?id=" + URLEncoder.encode(question.getId().toString(), "UTF-8"));
    }
    
}
