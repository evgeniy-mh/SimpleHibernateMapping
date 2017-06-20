/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evgeniy_mh.hibernatecollectionsmaptest.ListMap;

import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author evgeniy
 */
public class QuestionHibernateUtil {
    
    private final Configuration acfg;
    private final SessionFactory factory;
    
    public QuestionHibernateUtil(){
        acfg=new Configuration();
        factory=acfg.configure("hibernate.cfg.xml").buildSessionFactory();
    }
    
    public void addQuestion(Question question){        
        Session session= factory.openSession();
        Transaction tr=null;
        try{
            tr=session.beginTransaction();
            session.persist(question);
            
            tr.commit();
        }catch(HibernateException ex){
            if(tr!=null) tr.rollback();
            throw ex;
        }finally{
            session.close();
        }
    }
    
    public void listQuestions(){
        Session session= factory.openSession();
        Transaction tr=null;
        try{
            tr=session.beginTransaction();            
            List questions = session.createQuery("from Question").list();
            for (Iterator it = questions.iterator(); it.hasNext();) {
                Question q=(Question) it.next();
                System.out.println(q);
            }
            tr.commit();
        }catch(HibernateException ex){
            if(tr!=null) tr.rollback();
            throw ex;
        }finally{
            session.close();
        }
    }
    
    public void changeQuestionName(int questionId, String newName){
        Session session= factory.openSession();
        Transaction tr=null;
        try{
            tr=session.beginTransaction();
            Question q=session.get(Question.class, questionId);
            if(q!=null) {
                q.setQname(newName);
                //session.flush();
                tr.commit();
            }            
        }catch(HibernateException ex){
            if(tr!=null) tr.rollback();
            throw ex;
        }finally{
            session.close();
        }
    }
    
    public void deleteQuestion(int questionId){
        Session session= factory.openSession();
        Transaction tr=null;
        try{
            tr=session.beginTransaction();
            Question q=session.get(Question.class, questionId);
            if(q!=null) session.delete(q);
            tr.commit();
        }catch(HibernateException ex){
            if(tr!=null) tr.rollback();
            throw ex;
        }finally{
            session.close();
        }
    }
    
    public void close(){
        factory.close();
    }
}
