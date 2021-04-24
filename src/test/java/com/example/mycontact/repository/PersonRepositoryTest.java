package com.example.mycontact.repository;

import com.example.mycontact.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PersonRepositoryTest {
    @Autowired
    private  PersonRepository personRepository;
    @Test
    void crud(){
        Person person = new Person();
        person.setName("martin");
        personRepository.save(person);
        System.out.println(personRepository.findAll());
    }
    @Test
    void hashCodeAndEquals(){
    Person person1 = new Person("martin");
    Person person2 = new Person("martin");
        System.out.println(person1.equals(person2));
    }
}