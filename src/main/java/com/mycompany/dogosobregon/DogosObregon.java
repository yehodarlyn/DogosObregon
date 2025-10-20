/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.dogosobregon;

import com.mycompany.dogosobregon.config.JpaUtil;
import com.mycompany.dogosobregon.entities.Cliente;
import com.mycompany.dogosobregon.service.IClienteService;
import com.mycompany.dogosobregon.service.impl.ClienteService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jonyco
 */
public class DogosObregon {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DogosObregonPU");
        EntityManager em = emf.createEntityManager();

        
        IClienteService clienteService = new ClienteService();
        IHotDogService hotDogService = new HotDogService();
        IPedidoService pedidoService = new PedidoService();

        System.out.println("--- Iniciando Carga de Prueba ---");

  
        Cliente cliente1 = new Cliente("Juan", "Perez", new Date());
        // ... (crear cliente2, 3, 4)
        Cliente cliente5 = new Cliente("Ana", "Gomez", new Date());

        cliente1 = clienteService.registrarCliente(cliente1);
        // ... (registrar cliente2, 3, 4)

        // Cliente 5 es recomendado por Cliente 1 [cite: 50]
        cliente5.setClienteRecomienda(cliente1);
        cliente5 = clienteService.registrarCliente(cliente5);

        System.out.println("Clientes creados.");

        // 3 hot dogs [cite: 51]
        HotDog hotdog1 = new HotDog("Clasico", "Salchicha de pavo", 50.0);
        // ... (validar precio > 0 )
        // ... (crear hotdog2, 3)
        hotDogService.registrarHotDog(hotdog1);
        

        System.out.println("Hot Dogs creados");

     
        System.out.println("--- Demostracion CRUD  ---");

    
        Cliente clienteLeido = clienteService.buscarPorId(cliente1.getId());
        System.out.println("Cliente leído: " + clienteLeido.getNombre());

        
        clienteLeido.setApPaterno("Perez Actualizado");
        clienteService.actualizarCliente(clienteLeido);
        System.out.println("Cliente actualizado");

        List<Cliente> clientes = clienteService.listarClientes(5);
        System.out.println("Listado de (max 100) clientes: " + clientes.size());

        
        System.out.println("--- Demostracion 10 Consultas ---");

        // 5 Clientes sin compras 
        List<Cliente> sinCompras = clienteService.buscarClientesSinCompras();
        System.out.println("Clientes sin compras: " + sinCompras.size());

        // 7 Busqueda por preferencia 
        List<Cliente> sinCebolla = clienteService.buscarClientesPorPreferencia("sin cebolla");
        System.out.println("Clientes que prefieren 'sin cebolla': " + sinCebolla.size());

        JpaUtil.getInstance().close();
        System.out.println("Demostracion finalizada");
    }
}

