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
public class Question {
    
    private int id;
    private string content;
    private Date creationDate;
    
    public Question (string c, Date d) {
        content = c;
        creationDate = d;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public string getContent() {
        return content;
    }

    public void setContent(string content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
    
    
}
