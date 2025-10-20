/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.dogosobregon.interfacesDAO;

import com.mycompany.dogosobregon.entities.HotDog;
import java.util.List;

/**
 *
 * @author jonyco
 */
public interface IHotDog {

    void create(HotDog hotDog);

    HotDog read(int id);

    void update(HotDog hotDog);

    void delete(int id);

    List<HotDog> readAll();
}
