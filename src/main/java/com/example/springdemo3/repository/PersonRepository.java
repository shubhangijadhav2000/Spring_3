package com.example.springdemo3.repository;

import com.example.springdemo3.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface PersonRepository extends MongoRepository<Person,Integer> {

//    @Query("{id :?0}")                                          //SQL Equivalent : SELECT * FROM BOOK WHERE ID=?
//    Optional<Person> getPersonById(Integer id);
}
