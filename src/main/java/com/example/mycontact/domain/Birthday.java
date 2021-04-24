package com.example.mycontact.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Embeddable
@NoArgsConstructor
@ToString
public class Birthday {
    private Integer yearOfBirthday;
    @Min(1)
    @Max(12)
    private Integer monthOfBirthday;
    @Min(1)
    @Max(31)
    private Integer dayOfBirthday;

    public Birthday(LocalDate date)
    {
        yearOfBirthday = date.getYear();
        monthOfBirthday = date.getMonthValue();
        dayOfBirthday = date.getDayOfMonth();

    }

}
