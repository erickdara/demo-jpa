package com.in28minutes.jpa.hibernate.demo.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity

public class Review {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String rating;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    private Course course;

    public Review(String rating, String name) {
        this.rating=rating;
        this.description = name;
    }
}
