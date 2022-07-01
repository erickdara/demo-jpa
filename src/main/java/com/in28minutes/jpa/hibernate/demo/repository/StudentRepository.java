package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
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

    public void someOperationToUnderstandPersistenceContext(){

            //Database Operation 1 - Retreive student
            Student student = em.find(Student.class, 20001L);
            //Database Operatoin 2 - Retreive passport
            Passport passport = student.getPassport();
            //Database Operation 3 - Update passport
            passport.setNumber("E1234567");
            //Database Operation 4 - Update student
            student.setName("Mateo - updated");
    }

    public void insertStudentAndCourse(Student student, Course course){
        //Student student = new Student("Jack");
        //Course course = new Course("Microservces in 100 Steps");
        student.addCourse(course);
        course.addStudent(student);

        em.persist(student);
        em.persist(course);
    }
}
