/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogosobregon.dao;

import com.mycompany.dogosobregon.config.JpaUtil;
import com.mycompany.dogosobregon.entities.Pedido;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

/**
 *
 * @author jonyco
 */
public class PedidoDAO {

    private EntityManager em;

    private EntityManager getEntityManager() {

        return JpaUtil.getInstance().createEntityManager();
    }

    // JPQL agrupa pedidos por cliente,suma el total y ordena descendente
    String jpql = "SELECT p.cliente, SUM(p.total) as gastoTotal "
            + "FROM Pedido p "
            + "GROUP BY p.cliente "
            + "ORDER BY gastoTotal DESC";
    TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
    // return

}
