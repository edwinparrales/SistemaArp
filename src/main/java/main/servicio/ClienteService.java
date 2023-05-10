package main.servicio;

import main.modelo.Cliente;
import main.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository cr;

    public List<Cliente> listar(){
       List<Cliente> listaCliente =  cr.findAll();
       if (!listaCliente.isEmpty())
           return listaCliente;
       else
           return new ArrayList<Cliente>();
    }

    public Cliente crear(Cliente cliente){
        return cr.save(cliente);
    }

    public Cliente buscarId(Integer id){
         return cr.findById(id).get();
    }
}
