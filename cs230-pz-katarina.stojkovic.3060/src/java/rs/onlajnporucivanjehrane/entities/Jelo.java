/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.onlajnporucivanjehrane.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "jelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jelo.findAll", query = "SELECT j FROM Jelo j"),
    @NamedQuery(name = "Jelo.findByIdjela", query = "SELECT j FROM Jelo j WHERE j.idjela = :idjela"),
    @NamedQuery(name = "Jelo.findByCena", query = "SELECT j FROM Jelo j WHERE j.cena = :cena"),
    @NamedQuery(name = "Jelo.findByOpis", query = "SELECT j FROM Jelo j WHERE j.opis = :opis"),
    @NamedQuery(name = "Jelo.findByNazivJela", query = "SELECT j FROM Jelo j WHERE j.nazivJela = :nazivJela")})
public class Jelo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDJELA")
    private Integer idjela;
    @Column(name = "CENA")
    private Long cena;
    @Size(max = 256)
    @Column(name = "OPIS")
    private String opis;
    @Size(max = 256)
    @Column(name = "NAZIV_JELA")
    private String nazivJela;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idjela")
    private List<Porudzbina> porudzbinaList;
    @JoinColumn(name = "IDRESTORANA", referencedColumnName = "IDRESTORANA")
    @ManyToOne
    private Restoran idrestorana;

    public Jelo() {
    }

    public Jelo(Integer idjela) {
        this.idjela = idjela;
    }

    public Integer getIdjela() {
        return idjela;
    }

    public void setIdjela(Integer idjela) {
        this.idjela = idjela;
    }

    public Long getCena() {
        return cena;
    }

    public void setCena(Long cena) {
        this.cena = cena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getNazivJela() {
        return nazivJela;
    }

    public void setNazivJela(String nazivJela) {
        this.nazivJela = nazivJela;
    }

    @XmlTransient
    public List<Porudzbina> getPorudzbinaList() {
        return porudzbinaList;
    }

    public void setPorudzbinaList(List<Porudzbina> porudzbinaList) {
        this.porudzbinaList = porudzbinaList;
    }

    public Restoran getIdrestorana() {
        return idrestorana;
    }

    public void setIdrestorana(Restoran idrestorana) {
        this.idrestorana = idrestorana;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idjela != null ? idjela.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jelo)) {
            return false;
        }
        Jelo other = (Jelo) object;
        if ((this.idjela == null && other.idjela != null) || (this.idjela != null && !this.idjela.equals(other.idjela))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Jelo{" + "idjela=" + idjela + ", cena=" + cena + ", nazivJela=" + nazivJela + ", idrestorana=" + idrestorana + '}';
    }

   

   

    
    
}
