package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CourseRepository {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    EntityManager em;

    public Course findById(Long id){
        return em.find(Course.class,id);
    }

    public Course save(Course course){
        if(course.getId()==null){
            em.persist(course);
        }else {
            em.merge(course);
        }
        return course;
    }

    public void deleteById(Long id){
        Course course = findById(id);
        em.remove(course);
    }

    public void playWithEntityManager(){

        /*Course course = new Course("Web Services in 100 Steps");
        em.persist(course);
        course.setName("Web Services in 100 Steps - Updated");*/
        Course course1 = new Course("Web Services in 100 Steps");
        em.persist(course1);


        Course course2 = new Course("Angular JS Services in 100 Steps");
        em.persist(course2);

        em.flush();

       em.clear();

        course1.setName("Web Services in 100 Steps - Updated");
        em.flush();

        course2.setName("Angular JS Services in 100 Steps - Updated");
        em.flush();
    }
}
