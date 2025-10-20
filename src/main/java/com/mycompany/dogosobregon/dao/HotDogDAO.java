/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogosobregon.dao;

import com.mycompany.dogosobregon.config.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

/**
 *
 * @author jonyco
 */
public class HotDogDAO {

    private EntityManager em;

    private EntityManager getEntityManager() {
        return JpaUtil.getInstance().createEntityManager();
    }

    // JPQL agrupa detalles por hotdog,suma la cantidad y ordena descendente
    String jpql = "SELECT pd.hotDog, SUM(pd.cantidad) as totalVendido "
            + "FROM PedidoDetalle pd "
            + "GROUP BY pd.hotDog "
            + "ORDER BY totalVendido DESC";
    TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);

//return query.getResultList(); 

}
