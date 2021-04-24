package com.example.mycontact.service;

import com.example.mycontact.Exception.PersonNotFoundException;
import com.example.mycontact.Exception.RenameNotPermittedException;
import com.example.mycontact.controller.dto.PersonDto;
import com.example.mycontact.domain.Person;
import com.example.mycontact.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PersonService {
    @Autowired
    private PersonRepository personRepository;


    @Transactional(readOnly = true)
    public  Person getPerson(Long id){
        Person dbPerson = personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
        return dbPerson;
    }

    public List<Person> getPeopleByName(String name) {
        List<Person> people = personRepository.findAll();
        return  people.stream().filter(person -> person.getName().equals(name)).collect(Collectors.toList());
    }
    @Transactional
    public  Person postPerson(PersonDto person)
    {
        Person newPerson = new Person();
        newPerson.set(person);
        newPerson.setName(person.getName());
        return personRepository.save(newPerson);
    }
    @Transactional
    public Person updatePerson(Long id, PersonDto person){
        Person dbPerson = personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
        log.error(person.getName());
        if(person.getName() != null && dbPerson.getName() != person.getName())
            throw new RenameNotPermittedException();
        dbPerson.set(person);
        return personRepository.save(dbPerson);
    }
    @Transactional
    public Person updatePerson(Long id, String name) {
        Person dbPerson = personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
        dbPerson.setName(name);
        return personRepository.save(dbPerson);
    }

    public Person deletePerson(Long id) {
        personRepository.deleteById(id);
        return null;
    }
    public Person softDeletePerson(Long id) {
        Person dbPerson = personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
        dbPerson.setDeleted(true);
        return personRepository.save(dbPerson);
    }
    public List<Person> getDeletePerson() {
        personRepository.findPeopleDeleted().forEach(System.out::println);
        return personRepository.findPeopleDeleted();
    }

    public Page<Person> getAllPerson(Pageable pageable) {

        return personRepository.findAll(pageable);
    }

    public List<Person> getBirthdayPeople() {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        return personRepository.findBirthdayTodayTomorrow(today.getMonthValue(),today.getDayOfMonth(),tomorrow.getMonthValue(),tomorrow.getDayOfMonth());
    }
}
