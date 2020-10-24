package rs.onlajnporucivanjehrane.auth;

import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import rs.onlajnporucivanjehrane.controler.RestoranController;
import rs.onlajnporucivanjehrane.controler.UserController;
import rs.onlajnporucivanjehrane.entities.Restoran;
import rs.onlajnporucivanjehrane.entities.Role;
import rs.onlajnporucivanjehrane.entities.User;

@Named
@ApplicationScoped
public class Registracija implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "cs230-pz-katarina.stojkovic.3060PU")
    private EntityManager em;

    @Inject
    private UserController userController;
    
    @Inject
    private RestoranController restoranController;

     private String username;
     private String email;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Lozinka mora sadržati minimum 8 karaktera, jedno veliko slovo, jedno malo slovo i jedan broj")
    private String password;
    private String naziv;
    private Integer pib;
    private String ime;
    private String prezime;
    private Date datumrodjenja;
    @Pattern(regexp = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$", message = "Broj telefona nije validan")
    private String telefon;
    private String adresa;

    public Registracija() {
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

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getPib() {
        return pib;
    }

    public void setPib(Integer pib) {
        this.pib = pib;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatumrodjenja() {
        return datumrodjenja;
    }

    public void setDatumrodjenja(Date datumrodjenja) {
        this.datumrodjenja = datumrodjenja;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    
    
   

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

     
  

  
    public String registruj() {
        try {
            
            
            Role rola = (Role) em.createNamedQuery("Role.findByNazivRole")
                    .setParameter("nazivRole", "VLASNIK").getSingleResult();
            User user = new User();
            user.setIme(ime);
            user.setPrezime(prezime);
            user.setDatumrodjenja(datumrodjenja);
            user.setTelefon(telefon);
            user.setEmail(email);
            user.setUsername(username);
            user.setPassword(password);
            user.setRole(rola);
                   
            Restoran restoran = new Restoran();
            restoran.setNaziv(naziv);
            restoran.setPib(pib);
            restoran.setAdresa(adresa);
            restoran.setUserid(user);
            

            

            if (restoranController.kreirajRestoran(restoran) && userController.registrujUsera(user)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Uspešno ste registrovani! ", ""));
                return "index";
            } else {
                return "greska";
            }
        } catch (NoResultException e) {
            return "greska";
        }
    }
    
}
