package com.example.mycontact.repository;

import com.example.mycontact.domain.Block;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class BlockRepositoryTest {
    @Autowired
    private BlockRepository blockRepository;
    @Test
    void  crud(){
        Block block =  Block.builder().name("martin").reason("안친함").startDate(LocalDate.now()).build();
        blockRepository.save(block);

        System.out.println(blockRepository.findAll());
    }

}