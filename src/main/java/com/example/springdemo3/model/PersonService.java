package com.example.springdemo3.model;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PersonService {

    private List<Person> personList= new ArrayList<>(Arrays.asList(
            new Person("shubhangi","pune","pict"),
            new Person("varsha","latur","dayanand"),
            new Person("anuja","sangali","Walchand")
    ));

    public List<Person> getAllPerson(){
        return personList;
    }

    public Person getPerson(String name){
        return personList.stream().filter(t -> t.getName().equals(name)).findFirst().get();
    }

    public void addPerson(Person person) {
        personList.add(person);
    }

    public void updatePerson(String name, Person person) {
        for(int i=0;i<personList.size();i++){
            Person p=personList.get(i);
            if(p.getName().equals(name)){
                personList.set(i,person);
                return;
            }

        }
    }

    public void deletePerson(String name) {
        personList.removeIf(p -> p.getName().equals(name));
    }
}
