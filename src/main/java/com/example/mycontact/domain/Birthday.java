package com.example.mycontact.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@Data
@NoArgsConstructor
@ToString
public class Birthday {
    private Integer yearOfBirthday;
    private Integer monthOfBirthday;
    private Integer dayOfBirthday;

    private Birthday(LocalDate date)
    {
        yearOfBirthday = date.getYear();
        monthOfBirthday = date.getMonthValue();
        dayOfBirthday = date.getDayOfMonth();

    }
    static public Birthday of(LocalDate date)
    {
        return new Birthday(date);
    }

}
