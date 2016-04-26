/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Epulapp
 */
@Embeddable
public class ReservationPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "date_reservation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReservation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_oeuvre")
    private int idOeuvre;

    public ReservationPK() {
    }

    public ReservationPK(Date dateReservation, int idOeuvre) {
        this.dateReservation = dateReservation;
        this.idOeuvre = idOeuvre;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public int getIdOeuvre() {
        return idOeuvre;
    }

    public void setIdOeuvre(int idOeuvre) {
        this.idOeuvre = idOeuvre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dateReservation != null ? dateReservation.hashCode() : 0);
        hash += (int) idOeuvre;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservationPK)) {
            return false;
        }
        ReservationPK other = (ReservationPK) object;
        if ((this.dateReservation == null && other.dateReservation != null) || (this.dateReservation != null && !this.dateReservation.equals(other.dateReservation))) {
            return false;
        }
        if (this.idOeuvre != other.idOeuvre) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.ReservationPK[ dateReservation=" + dateReservation + ", idOeuvre=" + idOeuvre + " ]";
    }

}
