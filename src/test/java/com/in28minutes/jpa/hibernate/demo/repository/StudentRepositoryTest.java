package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Passport;
import com.in28minutes.jpa.hibernate.demo.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
public class StudentRepositoryTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    StudentRepository repository;

    @Autowired
    EntityManager em;

    //Session & Session Factory
    //EntityManager & Persistence Context
    //Transaction

    @Test
    //@Transactional
    public void someTest(){
       repository.someOperationToUnderstandPersistenceContext();

    }

    @Test
    public void retreiveStudentAndPassportDetails(){
      Student student = em.find(Student.class,20001L);
      logger.info("student -> {}", student);
      logger.info("passport -> {}",student.getPassport());
    }

    @Test
    public void retreivePassportAndAssociatedStudent(){
        Passport passport = em.find(Passport.class,40001L);
        logger.info("passport -> {}", passport);
        logger.info("student -> {}",passport.getStudent());
    }

    @Test
    public void retreiveStudentAndCourses(){
        Student student = em.find(Student.class, 20001L);

        //Passport passport = em.find(Passport.class,40001L);
        logger.info("student -> {}", student);
        logger.info("courses -> {}",student.getCourses());
    }

}