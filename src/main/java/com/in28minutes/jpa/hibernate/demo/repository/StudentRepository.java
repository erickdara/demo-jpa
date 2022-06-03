package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.entity.Passport;
import com.in28minutes.jpa.hibernate.demo.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    EntityManager em;

    public Student findById(Long id){
        return em.find(Student.class,id);
    }

    public Student save(Student Student){
        if(Student.getId()==null){
            em.persist(Student);
        }else {
            em.merge(Student);
        }
        return Student;
    }

    public void deleteById(Long id){
        Student Student = findById(id);
        em.remove(Student);
    }

    public void saveStudentWithPassport(){

        Passport passport = new Passport("Z123456");
        em.persist(passport);

        Student student = new Student("Erick");
        student.setPassport(passport);
        em.persist(student);
    }
}
