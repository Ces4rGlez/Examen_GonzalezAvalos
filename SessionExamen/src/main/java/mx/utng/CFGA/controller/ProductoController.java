package mx.utng.CFGA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.utng.CFGA.model.entity.Producto;
import mx.utng.CFGA.model.service.IProductoService;


@Controller
@SessionAttributes("producto")
public class ProductoController {
    
    @Autowired
    private IProductoService service;

    @GetMapping({"/producto", "/producto/", "/producto/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Productos");
        model.addAttribute("productos", service.list());
        return "producto-list";
    }

    @GetMapping("/producto/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario Para Productos");
        model.addAttribute("producto", new Producto());
        return "producto-form";
    }

    @PostMapping("/producto/form")
    public String save(@Valid Producto producto, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Productos");
            return "producto-form";
        }
        service.save(producto);
        return "redirect:/producto/list";
    }

    @GetMapping("/producto/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Producto producto = null;
        if(id>0){
            producto = service.getById(id);
        }else{
            return "redirect:/producto/list";
        }
        model.addAttribute("title", "Editar Producto");
        model.addAttribute("producto", producto);
        return "producto-form";
    }

    @GetMapping("/producto/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/producto/list";
    }



}
