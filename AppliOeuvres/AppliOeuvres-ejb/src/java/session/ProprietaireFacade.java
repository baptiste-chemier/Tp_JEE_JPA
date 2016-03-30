/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dao.Proprietaire;
import dao.Reservation;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
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
public class ProprietaireFacade {

    @PersistenceContext(unitName = "AppliOeuvres-ejbPU")
    private EntityManager em;

    public Proprietaire Lire_Proprietaire_Id(int id_proprietaire) {
        try {
            return em.find(Proprietaire.class, id_proprietaire);
        } catch (Exception e) {
            throw e;
        }    
    }

    public Proprietaire findProprietaireByLogin(String login) {
        try {
            Query query = em.createNamedQuery("Proprietaire.findByLogin");
            query.setParameter("login", login);
            return (Proprietaire) query.getSingleResult();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Proprietaire> findAll() {
        try {
            Query query = em.createNamedQuery("Proprietaire.findAll");
            return query.getResultList();
        } catch (Exception e) {
            throw e;
        }
    }

    public Proprietaire connecter(String login, String pwd) throws Exception {
        try {
            Proprietaire proprietaire = findProprietaireByLogin(login);
            if (pwd.equals(proprietaire.getPwd())) {
                return proprietaire;
            }
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
