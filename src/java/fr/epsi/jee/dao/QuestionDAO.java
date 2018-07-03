/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.jee.dao;

import fr.epsi.jee.model.Question;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ludo Renzetti
 */
@Repository
@Transactional
public class QuestionDAO {
    
    @Autowired
    private SessionFactory session;
    
    public void save(Question q) {
        Session currentSession = session.getCurrentSession();
        currentSession.save(q);
    }
    
    public Question find(Integer uuid) {
        Session currentSession = session.getCurrentSession();
        
        List<Question> questions = currentSession.createCriteria(Question.class)
                .add(Restrictions.eq("id", uuid))
                .setMaxResults(1)
                .list();
        
        if(questions.size() == 1) return questions.get(0);
        
        return null;
    }
    
}
