package com.example.springdemo3.controller;


import com.example.springdemo3.model.Person;
import com.example.springdemo3.repository.PersonRepository;
import com.example.springdemo3.services.PersonService;
import com.example.springdemo3.services.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class PersonController {

    @Autowired
    public PersonService personService;


    @RequestMapping("/person")
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }

    @RequestMapping("/person/{personId}")
    public Person getPerson(@PathVariable int personId){
        return personService.getPerson(personId);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/person")
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/person/{personId}")
    public Person updatePerson(@RequestBody Person person,@PathVariable int personId){
            return personService.updatePerson(personId,person);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/person/{personId}")
    public String deletePerson(@PathVariable int personId){
        personService.deletePerson(personId);
        return "Deleted Successfully";
    }
}
