/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.jee.service;

import fr.epsi.jee.dao.QuestionDAOInterface;
import fr.epsi.jee.model.Question;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ludo Renzetti
 */
public class QuestionService extends DAOService implements QuestionDAOInterface {
    
    public QuestionService() {
    }
    
    @Override
    public void save(Question q) {
        openCurrentSessionwithTransaction();
        getCurrentSession().save(q);
        closeCurrentSessionwithTransaction();
    }
    
    @Override
    public Question find(Integer uuid) {
        openCurrentSession();
        Question q = (Question) getCurrentSession().get(Question.class, uuid);
        closeCurrentSession();
        
        return q;
    }
    
    
}
