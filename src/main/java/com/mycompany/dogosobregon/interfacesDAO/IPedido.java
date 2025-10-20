/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.dogosobregon.interfacesDAO;

import com.mycompany.dogosobregon.entities.Pedido;
import java.util.List;

/**
 *
 * @author jonyco
 */
public interface IPedido {

    void create(Pedido pedido);

    Pedido read(int id);

    void update(Pedido pedido);

    void delete(int id);

    List<Pedido> readAll();
}
