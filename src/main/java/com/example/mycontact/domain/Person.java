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
    private String hobby;
    @Embedded
    @Valid
    private Birthday birthday;
    private String address;
    private String job;
    @ToString.Exclude
    private String phoneNumber;
    @ColumnDefault("0")
    private boolean deleted;

    public void set(PersonDto person) {
        if (!StringUtils.isEmpty(person.getAddress()))
            setAddress(person.getAddress());
        if (person.getBirthday() != null)
            setBirthday(Birthday.of(person.getBirthday()));
        if (!StringUtils.isEmpty(person.getJob()))
            setJob(person.getJob());
        if (!StringUtils.isEmpty(person.getHobby()))
            setHobby(person.getHobby());
        if (!StringUtils.isEmpty(person.getPhoneNumber()))
            setPhoneNumber(person.getPhoneNumber());

    }
    public Integer getAge()
    {
        LocalDate today = LocalDate.now();
        if(birthday!=null)
            return  today.getYear()- birthday.getYearOfBirthday() + 1;
        else
            return null;
    }
    public boolean isBirthday()
    {
        LocalDate today = LocalDate.now();
        return  today.equals(LocalDate.of(today.getYear(), birthday.getMonthOfBirthday(),birthday.getDayOfBirthday()));

    }
}
