package com.example.springdemo3.services;


import com.example.springdemo3.model.Person;
import com.example.springdemo3.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getAllPerson(){
        List<Person> users= personRepository.findAll();
        System.out.println("Getting data from DB"+ users);
        return users;
    }

    @Override
    public Person getPerson(int personId){
            return personRepository.findById(personId).get();
    }

    @Override
    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(int personId, Person person) {
        Person person1=personRepository.findById(personId).get();

        if(Objects.nonNull(person.getName())&&!"".equalsIgnoreCase(person.getName())){
            person1.setName(person.getName());
        }

        if(Objects.nonNull(person.getCity())&&!"".equalsIgnoreCase(person.getCity())){
            person1.setCity(person.getCity());
        }

        if (Objects.nonNull(person.getCollege())&&!"".equalsIgnoreCase(person.getCollege())){
            person1.setCollege(person.getCollege());
        }

        return person1;
    }

    public void deletePerson(int personId) {
        personRepository.deleteById(personId);
    }
}