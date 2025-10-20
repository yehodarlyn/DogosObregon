/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.dogosobregon.interfacesDAO;

import com.mycompany.dogosobregon.entities.PedidoDetalle;
import java.util.List;

/**
 *
 * @author jonyco
 */
public interface IPedidoDetalle {

    void create(PedidoDetalle pedidoDetalle);

    PedidoDetalle read(int id);

    void update(PedidoDetalle pedidoDetalle);

    void delete(int id);

    List<PedidoDetalle> readAll();
}
