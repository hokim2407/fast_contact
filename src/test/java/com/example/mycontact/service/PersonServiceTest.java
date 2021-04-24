package com.example.mycontact.service;

import com.example.mycontact.domain.Birthday;
import com.example.mycontact.domain.Block;
import com.example.mycontact.domain.Person;
import com.example.mycontact.repository.BlockRepository;
import com.example.mycontact.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class PersonServiceTest {
    @Autowired
    PersonService personService;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private BlockRepository blockRepository;

    @Test
    void  getPeopleExcludeBlocks(){
        givenPeople();

        List<Person> result = personRepository.findByBlockIsNull();
        result.forEach(System.out::println);
    }


    @Test
    void  getPeopleByName(){
        givenPeople();
        List<Person> result = personRepository.findByName("martin");
        result.forEach(System.out::println);
    }

    @Test
    void  getPeopleByBloodType(){
        givenPeople();
        List<Person> result = personRepository.findByBloodType("A");
        result.forEach(System.out::println);
    }

    @Test
    void  getPeopleByBirthDayMonth(){
        givenPeople();
        List<Person> result = personRepository.findByMonthOfBirthday(8);
        result.forEach(System.out::println);
    }

    @Test
    void  getPeopleByBirthDay(){
        givenPeople();
        List<Person> result = personRepository.findByDayOfBirthday(8,1);
        result.forEach(System.out::println);
    }
    @Test
    void  getPeopleByBirthDayYear(){
        givenPeople();
        List<Person> result = personRepository.findByYearOfBirthday(1992);
        result.forEach(System.out::println);
    }

    private void givenBlocks() {
        givenBlock("martin");
    }

    private Block givenBlock(String name) {
        return blockRepository.save(new Block(name));
    }

    private void givenPeople() {
        givenPerson("martin",10,"A",LocalDate.of(1992,2,19));
        givenBlockPeople("david",19,"O",LocalDate.of(1990,7,19));
        givenPerson("dennis",10,"A",LocalDate.of(1994,8,1));
        givenPerson("martin",11,"AB",LocalDate.of(1996,8,19));
    }
    private void givenPerson(String name, int age, String bloodType,LocalDate birthDay) {
        Person person = new Person(name,age,bloodType);
        person.setBirthday(new Birthday(birthDay.getYear(), birthDay.getMonthValue(),birthDay.getDayOfMonth()));
        personRepository.save(person);
    }
    private void givenBlockPeople(String name, int age, String bloodType,LocalDate birthDay) {
        Person blockPerson = new Person(name,age,bloodType);
        blockPerson.setBlock(new Block(name));
        blockPerson.setBirthday(new Birthday(birthDay.getYear(), birthDay.getMonthValue(),birthDay.getDayOfMonth()));
        personRepository.save(blockPerson);
    }

}