package com.example.mycontact.service;

import com.example.mycontact.controller.dto.PersonDto;
import com.example.mycontact.domain.Birthday;
import com.example.mycontact.domain.Block;
import com.example.mycontact.domain.Person;
import com.example.mycontact.repository.BlockRepository;
import com.example.mycontact.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.lang.model.element.Name;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class PersonServiceTest {
    @Autowired
    PersonService personService;
    @Autowired
    private PersonRepository personRepository;




    @Test
    void  getPeopleByName(){

        List<Person> result = personRepository.findByName("martin");
        result.forEach(System.out::println);
    }

    @Test
    void  getPeopleByBirthDayMonth(){

        List<Person> result = personRepository.findByMonthOfBirthday(8);
        result.forEach(System.out::println);
    }

    @Test
    void  getPeopleByBirthDay(){

        List<Person> result = personRepository.findByDayOfBirthday(8,1);
        result.forEach(System.out::println);
    }
    @Test
    void  getPeopleByBirthDayYear(){

        List<Person> result = personRepository.findByYearOfBirthday(1992);
        result.forEach(System.out::println);
    }


}