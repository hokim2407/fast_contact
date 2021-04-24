package com.example.mycontact.service;

import com.example.mycontact.domain.Block;
import com.example.mycontact.domain.Person;
import com.example.mycontact.repository.BlockRepository;
import com.example.mycontact.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private BlockRepository blockRepository;
    public List<Person> getPeopleExcludeBlocks(){
        List<Person> people = personRepository.findAll();
//        List<Block> blocks = blockRepository.findAll();
//        List<String> blockNames = blocks.stream().map(Block::getName).collect(Collectors.toList());
        return people.stream().filter(person -> person.getBlock()==null).collect(Collectors.toList());
    }

@Transactional(readOnly = true)
    public  Person getPerson(Long id){
        return  personRepository.findById(id).get();
    }

    public List<Person> getPeopleByName(String name) {
        List<Person> people = personRepository.findAll();
        return  people.stream().filter(person -> person.getName().equals(name)).collect(Collectors.toList());
    }
}
