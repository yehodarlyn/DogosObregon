/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.dogosobregon.service;

import com.mycompany.dogosobregon.entities.Cliente;
import java.util.List;

/**
 *
 * @author jonyco
 */
public interface IClienteService {

    Cliente registrarCliente(Cliente cliente);

    Cliente buscarPorId(Long id);

    List<Cliente> listarClientes(int limit);

    Cliente actualizarCliente(Cliente cliente);

    void eliminarCliente(Long id);
    
    List<Cliente> buscarClientesSinCompras();

    List<Cliente> buscarClientesPorPreferencia(String preferencia);
}
