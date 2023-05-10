package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "producto",method = RequestMethod.GET)
public class ProductoController {
    @GetMapping("/crear")
    public String crear(Model model){

        return "producto/FrmCrearProducto";
    }

}
