package com.in28minutes.jpa.hibernate.demo.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity

public class Passport {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String number;
    
    
    @OneToOne(fetch=FetchType.LAZY, mappedBy = "passport")
    private Student student;

    public Passport(String name) {
        this.number = name;
    }
}
