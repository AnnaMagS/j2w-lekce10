package cz.czechitas.java2webapps.lekce10.controller;

import cz.czechitas.java2webapps.lekce10.entity.Student;
import cz.czechitas.java2webapps.lekce10.entity.Trida;
import cz.czechitas.java2webapps.lekce10.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class TridaController {
    private final MyService service;

    @Autowired
    public TridaController(MyService service){this.service = service;}

    @GetMapping("/")
    public Object tridy(){
        return new ModelAndView("tridy").addObject("tridy",service.seznamTrid());
    }

    @GetMapping("/trida/{tridaID}")
    public Object detail(@PathVariable Short tridaID) {
        Optional<Trida> trida = service.singleTrida(tridaID);
        if (trida.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        ModelAndView result = new ModelAndView("detail");
        result.addObject("trida", trida.get());
        return result;
    }

    @GetMapping("/student/{studentID}")
    public Object detail(@PathVariable int studentID) {
        Optional<Student> student = service.singleStudent(studentID);
        if (student.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        ModelAndView result = new ModelAndView("student");
        result.addObject("student", student.get());
        return result;
    }
}
