package com.example.mycontact.controller.dto;

import com.example.mycontact.domain.Birthday;
import com.example.mycontact.domain.Block;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class PersonDto {
    @NotBlank(message = "이름은 필수값 입니다.")
    private String name;
    private String hobby;
    private LocalDate birthday;
    private String  address;
    private String job;
    private String phoneNumber;
    private Block block;

}
