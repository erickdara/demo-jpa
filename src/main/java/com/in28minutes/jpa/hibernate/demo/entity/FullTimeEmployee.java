package com.in28minutes.jpa.hibernate.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, BigDecimal salary){
        super(name);
        this.salary = salary;
    }
    private BigDecimal salary;
}
