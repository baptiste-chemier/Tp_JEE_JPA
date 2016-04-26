/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dao.Adherent;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
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
public class AdherentFacade {

    @PersistenceContext(unitName = "AppliOeuvres-ejbPU")
    private EntityManager em;

    public List<Adherent> findAll() {
        try {
            return (em.createNamedQuery("Adherent.findAll").getResultList());
        } catch (Exception e) {
            throw e;
        }
    }

    public Adherent findAdherentById(int id_adherent) throws Exception {
        try {
            Query query = em.createNamedQuery("Adherent.findByIdAdherent");
            query.setParameter("idAdherent", id_adherent);
            return (Adherent) query.getSingleResult();
        } catch (Exception e) {
            throw e;
        }
    }
}
