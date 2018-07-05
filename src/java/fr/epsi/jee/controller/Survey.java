/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.jee.controller;

import fr.epsi.jee.model.Answer;
import fr.epsi.jee.model.Question;
import fr.epsi.jee.service.QuestionService;
import java.io.Serializable;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Ludo Renzetti
 */
@Named(value = "Survey")
@SessionScoped
@ManagedBean
public class Survey implements Serializable {
    
    private Question question = new Question();
    
    private QuestionService questionService;
    
    @PostConstruct
    public void init() {
        question.getAnswers().addAll(Arrays.asList(
                new Answer(),
                new Answer(),
                new Answer()
        ));
        
        questionService = new QuestionService();
    }
    
    public Question getQuestion() {
        return question;
    }
    
    public void submitSurvey() {
        if(question.getAnswers().isEmpty())
            return;
        
        questionService.save(question);
    }
    
    public void removeAnswer(int index) {
        question.getAnswers().remove(index);
    }
    
    public void addAnswer() {
        question.getAnswers().add(new Answer());
    }
    
}
