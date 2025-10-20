/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogosobregon.service.impl;

import com.mycompany.dogosobregon.dao.ClienteDAO;
import com.mycompany.dogosobregon.entities.Cliente;
import com.mycompany.dogosobregon.interfacesDAO.ICliente;
import com.mycompany.dogosobregon.service.IClienteService;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jonyco
 */
public class ClienteService implements IClienteService {

    
    private ICliente clienteDAO;

    public ClienteService() {
        this.clienteDAO = new ClienteDAO();
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) {
   // validacion de reglas de negocio
        if (cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()
                || cliente.getApPaterno()== null || cliente.getApPaterno().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre y apellido del cliente son obligatorios");
        }

        // Fechas no futuras 
       
        return clienteDAO.crear(cliente);
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteDAO.buscarPorId(id);
    }

    @Override
    public List<Cliente> listarClientes(int limit) {
        
        int maxLimit = (limit > 100 || limit <= 0) ? 100 : limit;
        return clienteDAO.listar(maxLimit);
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        if (cliente.getId() == null) {
            throw new IllegalArgumentException("Se requiere id para actualizar");
        }
        return clienteDAO.actualizar(cliente);
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteDAO.eliminar(id);
    }

    @Override
    public List<Cliente> buscarClientesSinCompras() {
        return clienteDAO.findClientesSinCompras();
    }

    @Override
    public List<Cliente> buscarClientesPorPreferencia(String preferencia) {
        return clienteDAO.findClientesPorPreferencia(preferencia);
    }
}
