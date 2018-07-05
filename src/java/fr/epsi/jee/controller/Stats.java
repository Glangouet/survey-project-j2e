/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.jee.controller;

import fr.epsi.jee.model.Answer;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.hibernate.Hibernate;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;

/**
 *
 * @author Ludo Renzetti
 */
@Named(value = "Stats")
@RequestScoped
@ManagedBean
public class Stats implements Serializable {
    
    @ManagedProperty(value = "#{surveyItem}")
    private SurveyItem surveyItem;
    
    public HorizontalBarChartModel horizontalBarModel;
    
    @PostConstruct
    public void init() {
        createHorizontalBarModel();
    }
    
    public void setSurveyItem(SurveyItem surveyItem) {
        this.surveyItem = surveyItem;
    }
    
    public HorizontalBarChartModel getChart() {
        return horizontalBarModel;
    }
    
    public void createHorizontalBarModel() {
        horizontalBarModel = new HorizontalBarChartModel();

        ChartSeries votes = new ChartSeries();
        
        votes.setLabel("Votes");
        
        int totalVotes = 0;
        Hibernate.initialize(surveyItem.getQuestion().getAnswers());
        
        List<Answer> answers = surveyItem.getQuestion().getAnswers();
        
        System.out.println("Answers: " + answers.size());
        
        totalVotes = answers.stream()
                .map((a) -> a.getVotes().size())
                .reduce(totalVotes, Integer::sum);
        
        System.out.println("VOTES: " + totalVotes);
        
        for(Answer a : answers) {
            votes.set(
                a.getContent() + " (" + a.getVotes().size() + ")",
                (a.getVotes().size() * 100) / totalVotes);
        }

        horizontalBarModel.addSeries(votes);

        horizontalBarModel.setTitle(surveyItem.getQuestion().getContent());
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
        
        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setMin(0);
        xAxis.setMax(100);
         
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);   
        horizontalBarModel.setSeriesColors("5DAD3E,01A2BE,983A84,EF7F33,FEE318,DF2F43");
        horizontalBarModel.setExtender("chartExtender");
    }
    
}
