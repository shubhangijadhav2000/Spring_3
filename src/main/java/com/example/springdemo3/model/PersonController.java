package com.example.springdemo3.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    public PersonService personService;

    @RequestMapping("/info")
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }

    @RequestMapping("/info/{name}")
    public Person getPerson(@PathVariable String name){
        return personService.getPerson(name);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/info")
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/info/{name}")
    public void updatePerson(@RequestBody Person person,@PathVariable String name){
        personService.updatePerson(name,person);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/info/{name}")
    public void deletePerson(@PathVariable String name){
        personService.deletePerson(name);
    }
}
