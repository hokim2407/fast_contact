package com.example.mycontact.service;

import com.example.mycontact.controller.dto.PersonDto;
import com.example.mycontact.domain.Birthday;
import com.example.mycontact.domain.Block;
import com.example.mycontact.domain.Person;
import com.example.mycontact.repository.BlockRepository;
import com.example.mycontact.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;


    @Transactional(readOnly = true)
    public  Person getPerson(Long id){

        return personRepository.findById(id).orElse(null);
    }

    public List<Person> getPeopleByName(String name) {
        List<Person> people = personRepository.findAll();
        return  people.stream().filter(person -> person.getName().equals(name)).collect(Collectors.toList());
    }
    @Transactional
    public  Person postPerson(Person person)
    {
        return personRepository.save(person);
    }


    public Person updatePerson(Long id, PersonDto person) {
        Person dbPerson = personRepository.findById(id).orElseThrow(()->new RuntimeException("no such id"));
        dbPerson.set(person);
        return personRepository.save(dbPerson);
    }

    public Person deletePerson(Long id) {
        personRepository.deleteById(id);
        return null;
    }
    public Person softDeletePerson(Long id) {
        Person dbPerson = personRepository.findById(id).orElseThrow(()->new RuntimeException("no such id"));
        dbPerson.setDeleted(true);
        return personRepository.save(dbPerson);
    }
    public List<Person> getDeletePerson() {
        personRepository.findDeleted().forEach(System.out::println);
        return personRepository.findDeleted();
    }
}
