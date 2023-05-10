package main.repository;

import main.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    public Cliente findByNombreLike(String nombre);
}