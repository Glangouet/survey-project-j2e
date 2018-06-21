/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.jee.controller;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Ludo Renzetti
 */
@Named(value = "survey")
@RequestScoped
@ManagedBean
public class SurveyController {
    
    private String message = "Hello, World!";

    /**
     * Creates a new instance of SurveyController
     */
    public SurveyController() {
        System.out.println("ok");
    }
    
    public String getMessage() {
        return message;
    }
    
}
