package com.in28minutes.jpa.hibernate.demo.entity;

import lombok.*;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Entity
@ToString
//@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name =  "name")
    private String name;
    
    public Employee(String name) {
        this.name = name;
    }
}
