/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evgeniy_mh.hibernatecollectionsmaptest.ListMap;

import java.util.ArrayList;

/**
 *
 * @author evgeniy
 */
public class TestListMapping {
    static public void run(){
        
        //To select frop DB: select * from Questions inner join Question_answers on Questions.id=Question_answers.Question_id;
        
        QuestionHibernateUtil qhu=new QuestionHibernateUtil();
        
        ArrayList<String> answers=new ArrayList<>();
        answers.add("prosto )");
        answers.add("slogno");
        answers.add("ne znayu");        
        Question q=new Question("how to ?", answers);        
        
        qhu.addQuestion(q);
        
        ArrayList<String> answers2=new ArrayList<>();
        answers2.add("domoy )");
        answers2.add("v shkolu");
        answers2.add("ne znayu :(");        
        Question q2=new Question("kuda poiti?", answers2);
        qhu.addQuestion(q2);
        
        ArrayList<String> answers3=new ArrayList<>();
        answers3.add("morogenku )");
        answers3.add("ogurets");
        answers3.add("ne znayu");        
        Question q3=new Question("chto skushat ?", answers3);
        qhu.addQuestion(q3);
        
        qhu.deleteQuestion(2);
        qhu.changeQuestionName(1, "What the actual?");
        qhu.listQuestions();
        qhu.close();
    }
}
