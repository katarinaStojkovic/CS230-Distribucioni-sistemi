/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.onlajnporucivanjehrane.auth;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import rs.onlajnporucivanjehrane.entities.User;

/**
 *
 * @author ketty
 */
@Named
@ApplicationScoped
public class Login implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @PersistenceContext(unitName = "cs230-pz-katarina.stojkovic.3060PU")
    private EntityManager em;
    
    private String username;
    private String password;

    private String rola = "";

    private FacesContext context;
    
    private User user;

    public Login() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String login() {
        context = FacesContext.getCurrentInstance();
        User user = null;
        boolean validan = false;

        try {
            user = (User) em.createNamedQuery("User.findByUsername").setParameter("username", username).getSingleResult();
            System.out.println("user: " + user);
                  
            if (password.equals(user.getPassword())) {
                validan = true;
            } else {
                validan = false;
            }
        } catch (NoResultException e) {
            validan = false;
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ne postoji nalog sa tim username-om", ""));
        }

        if (validan) {
            HttpSession session = SessionUtils.getSession();
            session.setMaxInactiveInterval(60 * 90);

            session.setAttribute("username", user.getUsername());

            session.setAttribute("rola", user.getRole().getNazivRole());

            this.user = user;

            if (user.getRole().getNazivRole().equalsIgnoreCase("VLASNIK")) {
                return "/porudzbina/List";
            } else {
                return "user/List";
            }
        } else {
            return "index";
        }
    }

    
   

    
    public String logout() {
        username = "";
        password = "";
        rola = "";
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml";
    }
    
}
