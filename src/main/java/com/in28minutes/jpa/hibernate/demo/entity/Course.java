package com.in28minutes.jpa.hibernate.demo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String name;


}
