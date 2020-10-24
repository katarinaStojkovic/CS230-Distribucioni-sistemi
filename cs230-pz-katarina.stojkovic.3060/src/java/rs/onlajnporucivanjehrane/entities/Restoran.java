/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.onlajnporucivanjehrane.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ketty
 */
@Entity
@Table(name = "restoran")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Restoran.findAll", query = "SELECT r FROM Restoran r"),
    @NamedQuery(name = "Restoran.findByIdrestorana", query = "SELECT r FROM Restoran r WHERE r.idrestorana = :idrestorana"),
    @NamedQuery(name = "Restoran.findByNaziv", query = "SELECT r FROM Restoran r WHERE r.naziv = :naziv"),
    @NamedQuery(name = "Restoran.findByPib", query = "SELECT r FROM Restoran r WHERE r.pib = :pib"),
    @NamedQuery(name = "Restoran.findByAdresa", query = "SELECT r FROM Restoran r WHERE r.adresa = :adresa")})
public class Restoran implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDRESTORANA")
    private Integer idrestorana;
    @Size(max = 256)
    @Column(name = "NAZIV")
    private String naziv;
    @Column(name = "PIB")
    private Integer pib;
    @Size(max = 256)
    @Column(name = "ADRESA")
    private String adresa;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne
    private User userid;
    @OneToMany(mappedBy = "idrestorana")
    private List<Jelo> jeloList;

    public Restoran() {
    }

    public Restoran(Integer idrestorana) {
        this.idrestorana = idrestorana;
    }

    public Integer getIdrestorana() {
        return idrestorana;
    }

    public void setIdrestorana(Integer idrestorana) {
        this.idrestorana = idrestorana;
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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    @XmlTransient
    public List<Jelo> getJeloList() {
        return jeloList;
    }

    public void setJeloList(List<Jelo> jeloList) {
        this.jeloList = jeloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrestorana != null ? idrestorana.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restoran)) {
            return false;
        }
        Restoran other = (Restoran) object;
        if ((this.idrestorana == null && other.idrestorana != null) || (this.idrestorana != null && !this.idrestorana.equals(other.idrestorana))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Restoran{" + "naziv=" + naziv + ", adresa=" + adresa + '}';
    }

    
    
}
