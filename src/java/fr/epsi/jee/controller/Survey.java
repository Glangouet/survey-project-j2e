/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.jee.controller;

import fr.epsi.jee.model.Answer;
import fr.epsi.jee.model.Question;
import fr.epsi.jee.service.QuestionService;
import fr.epsi.jee.utils.RedirectUtil;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ludo Renzetti
 */
@Named(value = "Survey")
@ViewScoped
@ManagedBean
public class Survey implements Serializable {
    
    private Question question = new Question();
    
    private QuestionService questionService;
    
    @PostConstruct
    public void init() {
        question.setAnswers(Arrays.asList(
                new Answer(),
                new Answer(),
                new Answer()
        ));
        
        questionService = new QuestionService();
    }
    
    public Question getQuestion() {
        return question;
    }
    
    public void submitSurvey() throws UnsupportedEncodingException {
        if(!question.getAnswers().isEmpty()) {
            question = questionService.persist(question);
            RedirectUtil.redirect("/votes.xhtml?id=" + URLEncoder.encode(question.getId().toString(), "UTF-8"));
        }
    }
    
    public void removeAnswer(int index) {
        question.getAnswers().remove(index);
    }
    
    public void addAnswer() {
        question.setAnswer(new Answer());
    }
    
}
