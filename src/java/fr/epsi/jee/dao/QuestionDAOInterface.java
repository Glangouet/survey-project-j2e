/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.jee.dao;

import fr.epsi.jee.model.Question;

/**
 *
 * @author Ludo Renzetti
 */
public interface QuestionDAOInterface {
    
    public Question persist(Question q);
    
    public Question save(Question q);
    
    public Question find(Long uuid);
    
}
