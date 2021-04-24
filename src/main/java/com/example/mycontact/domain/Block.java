package com.example.mycontact.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
public class Block {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    private String reason;
    private LocalDate startDate;
    private LocalDate endDate;
}
