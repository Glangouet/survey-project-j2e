/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.jee.service;

import fr.epsi.jee.dao.QuestionDAOInterface;
import fr.epsi.jee.model.Question;
import org.hibernate.LockMode;

/**
 *
 * @author Ludo Renzetti
 */
public class QuestionService extends DAOService implements QuestionDAOInterface {
    
    @Override
    public Question persist(Question q) {
        openCurrentSessionwithTransaction();
        getCurrentSession().persist(q);
        closeCurrentSessionwithTransaction();
        
        return q;
    }
    
    @Override
    public Question save(Question q) {
        openCurrentSessionwithTransaction();
        getCurrentSession().update(q);
        closeCurrentSessionwithTransaction();
        
        return q;
    }
    
    @Override
    public Question find(Long uuid) {
        openCurrentSession();
        Question q = (Question) getCurrentSession().get(Question.class, uuid);
        getCurrentSession().lock(q, LockMode.NONE);
        q.getAnswers(); // LAZY
        closeCurrentSession();
        
        return q;
    }
    
}
