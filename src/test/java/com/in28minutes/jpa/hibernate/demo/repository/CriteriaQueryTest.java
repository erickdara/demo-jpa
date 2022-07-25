package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
public class CriteriaQueryTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    EntityManager em;

    @Test
    public void jpql_basic(){
        //Select c From Course c

        //1. Use Criteria Builder to create a Criteria Query returning the
        //expected result object
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        //2. Define roots for tables which are involved in the query
        Root<Course> courseRoot = cq.from(Course.class);
        //3. Define Predicates etc using Criteria Builder
        //4. Add Predicates etc to the Criteria Query
        //5. Build the TypedQuery using entity manager and criteria query


        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("TypedQuery -> {}", resultList);
    }

    }
