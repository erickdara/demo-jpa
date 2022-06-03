package com.in28minutes.jpa.hibernate.demo.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne
    private Passport passport;

    public Student(String name) {
        this.name = name;
    }
}
