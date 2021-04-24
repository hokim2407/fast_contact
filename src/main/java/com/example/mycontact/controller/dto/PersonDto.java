package com.example.mycontact.controller.dto;

import com.example.mycontact.domain.Birthday;
import com.example.mycontact.domain.Block;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
public class PersonDto {
    private String name;
    private int age;
    private String hobby;
    private String bloodType;
    private LocalDate birthday;
    private String  address;
    private String job;
    private String phoneNumber;
    private Block block;

}
