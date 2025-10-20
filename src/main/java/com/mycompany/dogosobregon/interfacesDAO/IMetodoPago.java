/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.dogosobregon.interfacesDAO;

import com.mycompany.dogosobregon.entities.MetodoPago;
import java.util.List;

/**
 *
 * @author jonyco
 */
public interface IMetodoPago {

    void create(MetodoPago metodoPago);

    MetodoPago read(int id);

    void update(MetodoPago metodoPago);

    void delete(int id);

    List<MetodoPago> readAll();
}
