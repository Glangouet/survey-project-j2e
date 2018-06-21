/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.jee.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Ludo Renzetti
 */
@Named(value = "stats")
@SessionScoped
@ManagedBean
public class StatsController implements Serializable {

    private String message = "Stats";
    
    /**
     * Creates a new instance of StatsController
     */
    public StatsController() {
    }
    
    public String getMessage() {
        return message;
    }
    
}
