/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.jee.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Guillaume
 */
@Entity
@Table(name = "answers")
public class Answer implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="question_id", nullable = false)
    private Question question;
    
    @Column(name = "content")
    private String content;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "answer", fetch = FetchType.EAGER)
    private List<Vote> votes = new ArrayList<>();

    public Long getId() {
        return id;
    }
    
    public Question getQuestion() {
        return question;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public void setQuestion(Question question) {
        this.question = question;
    }
    
    public List<Vote> getVotes() {
        return votes;
    }
    
    public void setVote(Vote vote) {
        votes.add(vote);
        vote.setAnswer(this);
    }

}
