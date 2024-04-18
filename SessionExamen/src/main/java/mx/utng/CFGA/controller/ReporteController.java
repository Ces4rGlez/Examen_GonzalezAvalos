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
import mx.utng.CFGA.model.entity.Reporte;
import mx.utng.CFGA.model.service.IReporteService;

@Controller
@SessionAttributes("teacher")
public class ReporteController {
    
    @Autowired
    private IReporteService service;

    @GetMapping({"/teacher", "/teacher/", "/teacher/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Profesores");
        model.addAttribute("teachers", service.list());
        return "teacher-list";
    }

    @GetMapping("/teacher/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Profesores");
        model.addAttribute("teacher", new Reporte());
        return "teacher-form";
    }

    @PostMapping("/teacher/form")
    public String save(@Valid Reporte teacher, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Profesores");
            return "teacher-form";
        }
        service.save(teacher);
        return "redirect:/teacher/list";
    }

    @GetMapping("/teacher/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Reporte teacher = null;
        if(id>0){
            teacher = service.getById(id);
        }else{
            return "redirect:/teacher/list";
        }
        model.addAttribute("title", "Editar Profesor");
        model.addAttribute("teacher", teacher);
        return "teacher-form";
    }

    @GetMapping("/teacher/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/teacher/list";
    }



}
