/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.util.Date;

/**
 *
 * @author Guillaume
 */
public class Answer {
    
    private int id;
    private int questionId;
    private string content;
    private int countVote;
    private Date creationDate;
    
    public Answer (int qi, string c, int cv, Date d) {
        questionId = qi;
        content = c;
        countVote = cv;
        creationDate = d;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public string getContent() {
        return content;
    }

    public void setContent(string content) {
        this.content = content;
    }

    public int getCountVote() {
        return countVote;
    }

    public void setCountVote(int countVote) {
        this.countVote = countVote;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
    
    
}
