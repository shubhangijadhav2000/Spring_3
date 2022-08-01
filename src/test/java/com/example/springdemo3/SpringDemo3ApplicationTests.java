package com.example.springdemo3;

import com.example.springdemo3.controller.PersonController;
import com.example.springdemo3.model.Person;
import com.example.springdemo3.repository.PersonRepository;
import com.example.springdemo3.services.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class SpringDemo3ApplicationTests {

	@Autowired
	private PersonService personService;
	@MockBean
	private PersonRepository personRepository;

	@Test
	public void getAllPersonTest(){
		when(personRepository.findAll()).thenReturn(Stream.of(new Person(12,"harsh","jalgaon","vit"),
				new Person(13,"harshita","patur","vit")).collect(Collectors.toList()));
		assertEquals(2,personService.getAllPerson().size());
	}

	@Test
	public void getPersonTest(){
		Person person=new Person(14,"sarika","sanghavi","ait");
		when(personRepository.findById(14)).thenReturn(Optional.of(person));
		Person person1=personService.getPerson(14);
		verify(personRepository).findById(14);
		assertEquals(14,person1.getPersonId());

	}

	@Test
	public void addPersonTest(){
		Person person=new Person(14,"naina","pune","iit");
		when(personRepository.save(person)).thenReturn(person);
		assertEquals(personService.addPerson(person),person);
	}

	@Test
	public void deleteUserTest(){
		Person person=new Person(14,"naina","pune","iit");
		personService.deletePerson(14);
		verify(personRepository,times(1)).deleteById(person.getPersonId());
	}

}
