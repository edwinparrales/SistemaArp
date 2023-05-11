package main.controller;

import main.modelo.Cliente;
import main.servicio.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("cliente")
public class ClienteController {
    @Autowired
    private ClienteService cs;
    @GetMapping("/listar")
    public String listar(Model model){
        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes = cs.listar();
        model.addAttribute("clientes",clientes);

        return "cliente/ListaCliente";

    }

    @GetMapping("/crear")
    public String registrarCliente(Cliente cliente){


        return "cliente/FrmCrearCliente";
    }

    @GetMapping("/prueba")

    public ResponseEntity<List<Cliente>> listaJson(){
        List<Cliente> clientes = cs.listar();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @PostMapping("/crear")

    public String guardar(@Validated @ModelAttribute Cliente cliente, Model model, BindingResult result){

        try {
            Cliente clienteNuevo = cs.crear(cliente);
            model.addAttribute("clienteCreado",clienteNuevo);
            return "redirect:/cliente/listar";


        }catch (Exception e){
            if(result.hasErrors()){
                System.out.print("Error en el formulario");
                return "cliente/error404";

            }

        }




        Cliente clienteNuevo = cs.crear(cliente);
        model.addAttribute("clienteCreado",clienteNuevo);
        return "redirect:/cliente/listar";




    }


}
