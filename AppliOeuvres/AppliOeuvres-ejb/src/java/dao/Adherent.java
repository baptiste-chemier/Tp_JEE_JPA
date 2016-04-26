/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Epulapp
 */
@Entity
@Table(name = "adherent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adherent.findAll", query = "SELECT a FROM Adherent a"),
    @NamedQuery(name = "Adherent.findByIdAdherent", query = "SELECT a FROM Adherent a WHERE a.idAdherent = :idAdherent"),
    @NamedQuery(name = "Adherent.findByNomAdherent", query = "SELECT a FROM Adherent a WHERE a.nomAdherent = :nomAdherent"),
    @NamedQuery(name = "Adherent.findByPrenomAdherent", query = "SELECT a FROM Adherent a WHERE a.prenomAdherent = :prenomAdherent")})
public class Adherent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_adherent")
    private Integer idAdherent;
    @Size(max = 50)
    @Column(name = "nom_adherent")
    private String nomAdherent;
    @Size(max = 50)
    @Column(name = "prenom_adherent")
    private String prenomAdherent;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adherent")
    private List<Reservation> reservationList;

    public Adherent() {
    }

    public Adherent(Integer idAdherent) {
        this.idAdherent = idAdherent;
    }

    public Integer getIdAdherent() {
        return idAdherent;
    }

    public void setIdAdherent(Integer idAdherent) {
        this.idAdherent = idAdherent;
    }

    public String getNomAdherent() {
        return nomAdherent;
    }

    public void setNomAdherent(String nomAdherent) {
        this.nomAdherent = nomAdherent;
    }

    public String getPrenomAdherent() {
        return prenomAdherent;
    }

    public void setPrenomAdherent(String prenomAdherent) {
        this.prenomAdherent = prenomAdherent;
    }

    @XmlTransient
    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdherent != null ? idAdherent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adherent)) {
            return false;
        }
        Adherent other = (Adherent) object;
        if ((this.idAdherent == null && other.idAdherent != null) || (this.idAdherent != null && !this.idAdherent.equals(other.idAdherent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Adherent[ idAdherent=" + idAdherent + " ]";
    }

}
