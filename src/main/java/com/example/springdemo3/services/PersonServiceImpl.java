package com.example.springdemo3.services;


import com.example.springdemo3.model.Person;
import com.example.springdemo3.services.PersonService;
import com.example.springdemo3.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    private List<Person> personList= new ArrayList<>(Arrays.asList(
            new Person(1,"shubhangi","pune","pict"),
            new Person(2,"varsha","latur","dayanand"),
            new Person(3,"anuja","sangali","Walchand")
    ));

    @Override
    public List<Person> getAllPerson(){

        return (List<Person>) personRepository.findAll();
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
        //personList.removeIf(p -> p.getName().equals(name));
        personRepository.deleteById(personId);
    }

    //update personList
//    public void updatePerson(String name, Person person) {
//        for(int i=0;i<personList.size();i++){
//            Person p=personList.get(i);
//            if(p.getName().equals(name)){
//                personList.set(i,person);
//                return;
//            }
//
//        }
//    }

}