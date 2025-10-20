/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogosobregon.dao;

import com.mycompany.dogosobregon.config.JpaUtil;
import com.mycompany.dogosobregon.entities.Cliente;
import com.mycompany.dogosobregon.interfacesDAO.ICliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonyco
 */
public class ClienteDAO implements ICliente {

    private EntityManager em;

    private EntityManager getEntityManager() {
        // Obtener el em del singleton jpautil 
        return JpaUtil.getInstance().createEntityManager();
    }

    @Override
    public Cliente crear(Cliente cliente) {
        em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin(); 
            em.persist(cliente);
            tx.commit(); 
            return cliente;
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback(); 
            }
            e.printStackTrace();
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Cliente buscarPorId(Long id) {
        em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Cliente> listar(int limit) {
        
        int maxResults = (limit > 0 && limit <= 100) ? limit : 100;

        em = getEntityManager();
        try {
            TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
            query.setMaxResults(maxResults);
            return query.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Cliente actualizar(Cliente cliente) {
        em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Cliente mergedCliente = em.merge(cliente);
            tx.commit();
            return mergedCliente;
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void eliminar(Long id) {
        em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Cliente cliente = em.find(Cliente.class, id);
            if (cliente != null) {
                em.remove(cliente);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // --- Implementacion Consultas Adicionales  ---
    // Consulta5  clientes sin compras 
    @Override
    public List<Cliente> findClientesSinCompras() {
        em = getEntityManager();
        try {
            // JPQL: Selecciona clientes 'c' donde la coleccion 'pedidos' este vacia
            TypedQuery<Cliente> query = em.createQuery(
                    "SELECT c FROM Cliente c WHERE c.pedidos IS EMPTY", Cliente.class
            );
            return query.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Consulta6 clientes recomendados (JPQL) 
    @Override
    public List<Cliente> findClientesRecomendados() {
        em = getEntityManager();
        try {
            // JPQL: Selecciona clientes donde el campo 'clienteRecomienda' no sea nulo
            // (cliente_recomienda puede ser nulo [cite: 37])
            TypedQuery<Cliente> query = em.createQuery(
                    "SELECT c FROM Cliente c WHERE c.clienteRecomienda IS NOT NULL", Cliente.class
            );
            return query.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Consulta 7: Búsqueda por preferencia (Criteria API) [cite: 44, 48]
    @Override
    public List<Cliente> findClientesPorPreferencia(String preferencia) {
        em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
            Root<Cliente> cliente = cq.from(Cliente.class);

            // Asumiendo una relación Cliente -> ClientePreferencia [cite: 72]
            // y que ClientePreferencia tiene un campo "descripcion"
            cq.select(cliente)
                    .distinct(true)
                    .where(cb.equal(cliente.join("preferencias").get("descripcion"), preferencia));

            return em.createQuery(cq).getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // ... (Implementar las otras consultas [cite: 39, 47] aquí o en sus DAOs correspondientes)

    @Override
    public List<Object[]> findClientesConMayorGasto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Object[]> findUltimoPedidoPorCliente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
