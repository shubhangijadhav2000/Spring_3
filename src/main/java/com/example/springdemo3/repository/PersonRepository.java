package com.example.springdemo3.repository;

import com.example.springdemo3.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person,Integer> {
}
