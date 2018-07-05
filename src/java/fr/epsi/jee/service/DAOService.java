/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.jee.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Ludo Renzetti
 */
public class DAOService {
    
    private Session currentSession;
	
    private Transaction currentTransaction;

    public Session openCurrentSession() {
            currentSession = getSessionFactory().openSession();
            return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
            currentSession = getSessionFactory().openSession();
            currentTransaction = currentSession.beginTransaction();
            return currentSession;
    }

    public void closeCurrentSession() {
            currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
            currentTransaction.commit();
            currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
            Configuration configuration = new Configuration().configure();
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            return sessionFactory;
    }

    public Session getCurrentSession() {
            return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
            this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
            return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
            this.currentTransaction = currentTransaction;
    }
}
