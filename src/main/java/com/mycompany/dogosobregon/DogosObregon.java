/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dogosobregon;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author jonyco
 */
public class DogosObregon {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DogosObregonPU");
        EntityManager em = emf.createEntityManager();
                
        
    }
}
