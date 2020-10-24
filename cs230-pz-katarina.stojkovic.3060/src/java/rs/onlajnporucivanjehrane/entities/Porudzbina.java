/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.onlajnporucivanjehrane.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ketty
 */
@Entity
@Table(name = "porudzbina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Porudzbina.findAll", query = "SELECT p FROM Porudzbina p"),
    @NamedQuery(name = "Porudzbina.findByIdporudzbina", query = "SELECT p FROM Porudzbina p WHERE p.idporudzbina = :idporudzbina"),
    @NamedQuery(name = "Porudzbina.findByDatumisporuke", query = "SELECT p FROM Porudzbina p WHERE p.datumisporuke = :datumisporuke"),
    @NamedQuery(name = "Porudzbina.findByVremeisporuke", query = "SELECT p FROM Porudzbina p WHERE p.vremeisporuke = :vremeisporuke"),
    @NamedQuery(name = "Porudzbina.findByAdresaisporuke", query = "SELECT p FROM Porudzbina p WHERE p.adresaisporuke = :adresaisporuke"),
    @NamedQuery(name = "Porudzbina.findByKolicina", query = "SELECT p FROM Porudzbina p WHERE p.kolicina = :kolicina")})
public class Porudzbina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPORUDZBINA")
    private Integer idporudzbina;
    @Column(name = "DATUMISPORUKE")
    @Temporal(TemporalType.DATE)
    private Date datumisporuke;
    @Column(name = "VREMEISPORUKE")
    @Temporal(TemporalType.TIME)
    private Date vremeisporuke;
    @Size(max = 256)
    @Column(name = "ADRESAISPORUKE")
    private String adresaisporuke;
    @Column(name = "KOLICINA")
    private Integer kolicina;
    @JoinColumn(name = "IDJELA", referencedColumnName = "IDJELA")
    @ManyToOne(optional = false)
    private Jelo idjela;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne(optional = false)
    private User userid;
    @OneToMany(mappedBy = "idporudzbina")
    private List<Recenzije> recenzijeList;

    public Porudzbina() {
    }

    public Porudzbina(Integer idporudzbina) {
        this.idporudzbina = idporudzbina;
    }

    public Integer getIdporudzbina() {
        return idporudzbina;
    }

    public void setIdporudzbina(Integer idporudzbina) {
        this.idporudzbina = idporudzbina;
    }

    public Date getDatumisporuke() {
        return datumisporuke;
    }

    public void setDatumisporuke(Date datumisporuke) {
        this.datumisporuke = datumisporuke;
    }

    public Date getVremeisporuke() {
        return vremeisporuke;
    }

    public void setVremeisporuke(Date vremeisporuke) {
        this.vremeisporuke = vremeisporuke;
    }

    public String getAdresaisporuke() {
        return adresaisporuke;
    }

    public void setAdresaisporuke(String adresaisporuke) {
        this.adresaisporuke = adresaisporuke;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public Jelo getIdjela() {
        return idjela;
    }

    public void setIdjela(Jelo idjela) {
        this.idjela = idjela;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    @XmlTransient
    public List<Recenzije> getRecenzijeList() {
        return recenzijeList;
    }

    public void setRecenzijeList(List<Recenzije> recenzijeList) {
        this.recenzijeList = recenzijeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idporudzbina != null ? idporudzbina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Porudzbina)) {
            return false;
        }
        Porudzbina other = (Porudzbina) object;
        if ((this.idporudzbina == null && other.idporudzbina != null) || (this.idporudzbina != null && !this.idporudzbina.equals(other.idporudzbina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.onlajnporucivanjehrane.entities.Porudzbina[ idporudzbina=" + idporudzbina + " ]";
    }
    
}
