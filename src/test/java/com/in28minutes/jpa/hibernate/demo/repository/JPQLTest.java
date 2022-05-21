package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
public class JPQLTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    EntityManager em;

    @Test
    public void jpql_basic(){
        List resultList = em.createQuery("Select c From Course c").getResultList();
        logger.info("Select c From Course c -> {}", resultList);
    }

    @Test
    public void jpql_typed(){
        TypedQuery<Course> query = em.createQuery("Select c From Course c",Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c From Course c -> {}", resultList);
    }

    @Test
    public void jpql_where(){
        TypedQuery<Course> query = em.createQuery("Select c From Course c where name like '%100 Steps'",Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c From Course c where name like '%100 Steps'-> {}", resultList);
    }
}