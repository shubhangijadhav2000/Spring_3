package com.example.springdemo3.controller;

import com.example.springdemo3.model.Person;
import com.example.springdemo3.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class MyController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/")
    public ResponseEntity<?> addPerson(@RequestBody Person person){
        Person save=this.personRepository.save(person);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/")
    public ResponseEntity<?> getperson(){
        return ResponseEntity.ok(this.personRepository.findAll());
    }
}