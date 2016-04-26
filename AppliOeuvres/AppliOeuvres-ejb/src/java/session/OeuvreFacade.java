/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dao.Oeuvre;
import dao.Proprietaire;
import dao.Reservation;
import java.math.BigDecimal;
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
import javax.persistence.TemporalType;

/**
 *
 * @author Epulapp
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class OeuvreFacade {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "AppliOeuvres-ejbPU")
    private EntityManager em;

    @EJB
    private ProprietaireFacade proprietaireF;

    @EJB
    private ReservationFacade reservationF;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Reservation findReservationByOeuvreId(Date dateReservation, int id_oeuvre) throws Exception {
        try {
            Query query = em.createNamedQuery("Reservation.findByDateReservationIdOeuvre");
            query.setParameter("dateReservation", dateReservation, TemporalType.DATE);
            query.setParameter("idOeuvre", id_oeuvre);
            return (Reservation) query.getSingleResult();
        } catch (Exception e) {
            throw e;
        }
    }

    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Lecture d'une occurrence d'oeuvre sur la clé primaire
     *
     * @param id_oeuvre
     * @return
     * @throws Exception
     */
    public Oeuvre findOeuvreById(int id_oeuvre) throws Exception {
        try {
            Query query = em.createNamedQuery("Oeuvre.findByIdOeuvre");
            query.setParameter("idOeuvre", id_oeuvre);
            return (Oeuvre) query.getSingleResult();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Retourne une liste d'objets Oeuvre
     *
     * @return
     * @throws Exception
     */
    public List<Oeuvre> findAll() throws Exception {
        try {
            return (em.createNamedQuery("Oeuvre.findAll").getResultList());
        } catch (Exception e) {
            throw e;
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addOeuvre(String titre, int id_proprietaire, double prix) throws Exception {
        try {
            Oeuvre oeuvre = new Oeuvre();
            oeuvre.setProprietaire(proprietaireF.Lire_Proprietaire_Id(id_proprietaire));
            oeuvre.setPrix(BigDecimal.valueOf(prix));
            oeuvre.setTitre(titre);
            em.persist(oeuvre);
        } catch (Exception e) {
            throw e;
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void updateOeuvre(int id_oeuvre, int id_proprietaire, double prix, String titre) throws Exception {
        try {
            Oeuvre oeuvre = findOeuvreById(id_oeuvre);
            Proprietaire proprietaire = proprietaireF.Lire_Proprietaire_Id(id_proprietaire);
            oeuvre.setPrix(BigDecimal.valueOf(prix));
            oeuvre.setTitre(titre);
            oeuvre.setProprietaire(proprietaire);
            em.merge(oeuvre);
        } catch (Exception e) {
            throw e;
        }
    }

    public void deleteOeuvre(int id_oeuvre) throws Exception {
        try {
            em.remove(findOeuvreById(id_oeuvre));
        } catch (Exception e) {
            throw e;
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deleteReservation(java.util.Date dateRes, int id_oeuvre) throws Exception {
        try {
            em.remove(reservationF.findReservationByDateReservationOeuvreId(dateRes, id_oeuvre));
        } catch (Exception e) {
            throw e;
        }
    }
}
