/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evgeniy_mh.hibernatecollectionsmaptest.ListMap;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author evgeniy
 */

@Entity
@Table (name = "Questions")

public class Question {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    
    @Column(name = "id")
    private int id;
    @Column(name = "q_name")
    private String qname;
    
    //@OneToMany(mappedBy = "question")
    //@JoinColumn(name = "answer_id")
    @ElementCollection
    private List<String> answers;
    
    public Question(){}
    
    public Question(String qname,List<String> answers){
        this.qname=qname;
        this.answers=answers;
    }
    
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("Id: "+id+", Question name: "+qname+"Answers: ");
        answers.forEach((s) -> {
            sb.append(s+", ");
        });        
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }    
}
