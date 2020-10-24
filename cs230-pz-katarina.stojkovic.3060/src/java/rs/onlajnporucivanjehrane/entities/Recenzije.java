/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.onlajnporucivanjehrane.entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ketty
 */
@Entity
@Table(name = "recenzije")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recenzije.findAll", query = "SELECT r FROM Recenzije r"),
    @NamedQuery(name = "Recenzije.findByRecenzijeid", query = "SELECT r FROM Recenzije r WHERE r.recenzijeid = :recenzijeid"),
    @NamedQuery(name = "Recenzije.findByOcena", query = "SELECT r FROM Recenzije r WHERE r.ocena = :ocena")})
public class Recenzije implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RECENZIJEID")
    private Integer recenzijeid;
    @Column(name = "OCENA")
    private Integer ocena;
    @JoinColumn(name = "IDPORUDZBINA", referencedColumnName = "IDPORUDZBINA")
    @ManyToOne
    private Porudzbina idporudzbina;

    public Recenzije() {
    }

    public Recenzije(Integer recenzijeid) {
        this.recenzijeid = recenzijeid;
    }

    public Integer getRecenzijeid() {
        return recenzijeid;
    }

    public void setRecenzijeid(Integer recenzijeid) {
        this.recenzijeid = recenzijeid;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    public Porudzbina getIdporudzbina() {
        return idporudzbina;
    }

    public void setIdporudzbina(Porudzbina idporudzbina) {
        this.idporudzbina = idporudzbina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recenzijeid != null ? recenzijeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recenzije)) {
            return false;
        }
        Recenzije other = (Recenzije) object;
        if ((this.recenzijeid == null && other.recenzijeid != null) || (this.recenzijeid != null && !this.recenzijeid.equals(other.recenzijeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.onlajnporucivanjehrane.entities.Recenzije[ recenzijeid=" + recenzijeid + " ]";
    }
    
}
