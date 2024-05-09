/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import Clases.bodegero;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author Usuario iTC
 */
public class bodegeroJpaController implements Serializable {

    public bodegeroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public bodegeroJpaController() {
    emf = Persistence.createEntityManagerFactory("jpa_paquetesPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(bodegero bodegero) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bodegero);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findbodegero(bodegero.getDni()) != null) {
                throw new PreexistingEntityException("bodegero " + bodegero + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(bodegero bodegero) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bodegero = em.merge(bodegero);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = bodegero.getDni();
                if (findbodegero(id) == null) {
                    throw new NonexistentEntityException("The bodegero with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bodegero bodegero;
            try {
                bodegero = em.getReference(bodegero.class, id);
                bodegero.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bodegero with id " + id + " no longer exists.", enfe);
            }
            em.remove(bodegero);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<bodegero> findbodegeroEntities() {
        return findbodegeroEntities(true, -1, -1);
    }

    public List<bodegero> findbodegeroEntities(int maxResults, int firstResult) {
        return findbodegeroEntities(false, maxResults, firstResult);
    }

    private List<bodegero> findbodegeroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(bodegero.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public bodegero findbodegero(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(bodegero.class, id);
        } finally {
            em.close();
        }
    }

    public int getbodegeroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<bodegero> rt = cq.from(bodegero.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
