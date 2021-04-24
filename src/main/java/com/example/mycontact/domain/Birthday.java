package com.example.mycontact.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Birthday {
    private int year;
//    @Min(1)
//    @Max(12)
    private int month;
    private int day;

}
