/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.jee.utils;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ludo Renzetti
 */
public class RedirectUtil {
    
    public static void redirect(String path) {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        String url = ec.getRequestContextPath() + path;
        
        try {
            ec.redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(RedirectUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
