package com.autocare.autocare360.application;

import com.app.parkflow.customer.domain.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ClienteService {
    private final List<Cliente> clientes = new ArrayList<>();
    private final AtomicLong secuencia = new AtomicLong(0);

    public Cliente registrar(String documento, String nombreCompleto, String email, String telefono) {
        Cliente cliente = new Cliente(
                secuencia.incrementAndGet(),
                documento, nombreCompleto, email, telefono
        );
        clientes.add(cliente);
        return cliente;
    }

    public List<Cliente> listar() {
        return List.copyOf(clientes);
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

}
