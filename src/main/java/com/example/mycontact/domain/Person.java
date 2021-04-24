package com.example.mycontact.domain;

import com.example.mycontact.controller.dto.PersonDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Where;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted = false")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @NotEmpty
    private String name;
    @NonNull
    @Min(1)
    private int age;
    private String hobby;
    @NonNull
    @NotEmpty
    @Column(nullable = false)
    private String bloodType;
    @Embedded
    @Valid
    private Birthday birthday;
    private String address;
    private String job;
    @ToString.Exclude
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Block block;
    @ColumnDefault("0")
    private boolean deleted;

    public void set(PersonDto person) {
        if (!StringUtils.isEmpty(person.getName()))
            setName(person.getName());
        if (age != 0)
            setAge(person.getAge());
        if (!StringUtils.isEmpty(person.getAddress()))
            setAddress(person.getAddress());
        if (!StringUtils.isEmpty(person.getBloodType()))
            setBloodType(person.getBloodType());
        if (person.getBirthday() != null)
            setBirthday(new Birthday(person.getBirthday()));
        if (!StringUtils.isEmpty(person.getJob()))
            setJob(person.getJob());
        if (!StringUtils.isEmpty(person.getHobby()))
            setHobby(person.getHobby());
        if (!StringUtils.isEmpty(person.getPhoneNumber()))
            setPhoneNumber(person.getPhoneNumber());

    }

}
