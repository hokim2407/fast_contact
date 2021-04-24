package com.example.mycontact.controller;

import com.example.mycontact.controller.dto.PersonDto;
import com.example.mycontact.domain.Person;
import com.example.mycontact.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    PersonService personService;
    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id){
        return personService.getPerson(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person postPerson(@RequestBody Person person){
        return personService.postPerson(person);
    }
    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id,@RequestBody PersonDto person){
        return personService.updatePerson(id,person);
    }
    @DeleteMapping("/{id}")
    public Person deletePerson(@PathVariable Long id){
        return personService.softDeletePerson(id);
    }
    @GetMapping("/Deleted")
    public List<Person> deletePerson(){
        return personService.getDeletePerson();
    }
}
