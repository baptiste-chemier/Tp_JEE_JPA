/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dao.Reservation;
import dao.ReservationPK;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Epulapp
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ReservationFacade {

    @PersistenceContext(unitName = "AppliOeuvres-ejbPU")
    private EntityManager em;

    @EJB
    private AdherentFacade adherentF;

    @EJB
    private OeuvreFacade oeuvreF;

    /**
     *
     * @return
     */
    public List<Reservation> findAll() throws Exception {
        try {
            return (em.createNamedQuery("Reservation.findAll").getResultList());
        } catch (Exception e) {
            throw e;
        }
    }

    public Reservation findReservationByDateReservationOeuvreId(java.util.Date dateRes, int id_oeuvre) throws Exception {
        try {
            Query query = em.createNamedQuery("Reservation.findByDateReservationIdOeuvre");
            query.setParameter("dateReservation", dateRes);
            query.setParameter("idOeuvre", id_oeuvre);
            return (Reservation) query.getSingleResult();
        } catch (Exception e) {
            throw e;
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addReservation(int id_oeuvre, Date StrToDate, int id_adherent) throws Exception {
        try {
            Reservation reservation = new Reservation();
            reservation.setOeuvre(oeuvreF.findOeuvreById(id_oeuvre));
            reservation.setStatut("Attente");
            reservation.setAdherent(adherentF.findAdherentById(id_adherent));
            reservation.setReservationPK(new ReservationPK(StrToDate, id_oeuvre));
            em.persist(reservation);
        } catch (Exception e) {
            throw e;
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void editReservation(int id_oeuvre, Date StrToDate) throws Exception {
        try {
            Reservation reservation = findReservationByDateReservationOeuvreId(StrToDate, id_oeuvre);
            reservation.setOeuvre(oeuvreF.findOeuvreById(id_oeuvre));
            reservation.setReservationPK(new ReservationPK(StrToDate, id_oeuvre));
            reservation.setStatut("Confirmée");
            em.merge(reservation);
        } catch (Exception e) {
            throw e;
        }
    }
}
