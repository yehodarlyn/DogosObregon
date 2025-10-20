/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogosobregon.dao;

import com.mycompany.dogosobregon.config.JpaUtil;
import jakarta.persistence.EntityManager;

/**
 *
 * @author jonyco
 */
public class PedidoDetalleDAO {
    private EntityManager em;

    private EntityManager getEntityManager() {
        return JpaUtil.getInstance().createEntityManager();
    }
}
