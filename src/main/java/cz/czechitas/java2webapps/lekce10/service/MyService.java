package cz.czechitas.java2webapps.lekce10.service;

import cz.czechitas.java2webapps.lekce10.entity.Student;
import cz.czechitas.java2webapps.lekce10.entity.Trida;
import cz.czechitas.java2webapps.lekce10.repository.StudentRepository;
import cz.czechitas.java2webapps.lekce10.repository.TridaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyService {
    private final TridaRepository tridaRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public MyService(TridaRepository tridaRepository, StudentRepository studentRepository){
        this.tridaRepository = tridaRepository;
        this.studentRepository = studentRepository;
    }

    public List<Trida> seznamTrid(){
        return tridaRepository.serazeneTridy();
    }
    public Optional<Trida> singleTrida(Short id){ return tridaRepository.findById(id); }
    public Optional<Student> singleStudent(int id){return studentRepository.findById(id); }

}
