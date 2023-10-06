package com.example.lesson42.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class StudentEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String name;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Integer number;
    private static int index = 1;

    public void setNumber(Integer number) {
        this.number = index;
        index++;
    }

    public void saveNumber(Integer number) {
        this.number = number;
    }
}
