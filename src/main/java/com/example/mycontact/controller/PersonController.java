package com.example.mycontact.controller;

import com.example.mycontact.controller.dto.PersonDto;
import com.example.mycontact.domain.Person;
import com.example.mycontact.repository.PersonRepository;
import com.example.mycontact.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    PersonService personService;
    @Autowired
    PersonRepository personRepository;

    @GetMapping
    public Page<Person> getAllPerson(@PageableDefault(size = 10) Pageable pageable){
        return personService.getAllPerson(pageable);
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id){
        return personService.getPerson(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person postPerson(@RequestBody @Valid PersonDto person){
        return personService.postPerson(person);
    }
    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id,@RequestBody PersonDto person){
            return personService.updatePerson(id,person);
    }
    @DeleteMapping("/{id}")
    public boolean deletePerson(@PathVariable Long id){
        personService.softDeletePerson(id);
        return personRepository.findPeopleDeleted().stream().anyMatch(person -> person.getId().equals(id));
    }
    @GetMapping("/Deleted")
    public List<Person> getDeletedPerson(){
        return personService.getDeletePerson();
    }

    @GetMapping("/birthday-friends")
    public List<Person> getBirthdayPeople(){
        return personService.getBirthdayPeople();
    }
}
