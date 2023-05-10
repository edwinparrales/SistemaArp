package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {
    @GetMapping("/inicio")
    public String inicio(){
        return "plantilla";
    }
    @GetMapping("/producto")
    public String producto(){
        return "producto/FrmCrearProducto";
    }
}
