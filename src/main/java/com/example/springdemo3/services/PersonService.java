package com.example.springdemo3.services;

import com.example.springdemo3.model.Person;

import java.util.List;

public interface PersonService {

    //save operation
    Person addPerson(Person person);

    //get all operation
    List<Person> getAllPerson();

    //get operation
    Person getPerson(int personId);

    //update operation
    Person updatePerson(int personId, Person person);

    //delete operation
    void deletePerson(int personId);
}
