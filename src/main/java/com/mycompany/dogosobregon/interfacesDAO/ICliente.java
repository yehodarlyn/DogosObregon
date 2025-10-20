/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.dogosobregon.interfacesDAO;

import com.mycompany.dogosobregon.entities.Cliente;
import java.util.List;

/**
 *
 * @author jonyco
 */
public interface ICliente {


    Cliente crear(Cliente cliente);


    Cliente buscarPorId(Long id);


    List<Cliente> listar(int limit); 


    Cliente actualizar(Cliente cliente);

    void eliminar(Long id);

   
    List<Object[]> findClientesConMayorGasto();

 
    List<Cliente> findClientesSinCompras();

   
    List<Cliente> findClientesRecomendados();

 
    List<Cliente> findClientesPorPreferencia(String preferencia);

    
    List<Object[]> findUltimoPedidoPorCliente();
}
