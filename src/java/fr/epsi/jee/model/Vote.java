/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.jee.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author Guillaume
 */
@Entity
@Table(name = "votes")
public class Vote implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "answer_id", nullable = false)
    private Answer answer;
    
    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    private LocalDateTime created_at;

    public int getId() {
        return id;
    }

    public Answer getAnswer() {
        return answer;
    }

    public LocalDateTime getCreatedAt() {
        return created_at;
    }
    
    
}
