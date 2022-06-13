INSERT INTO course(id, name, created_date, last_updated_date) values (10001, 'JPA in 50 Steps',sysdate(),sysdate());
INSERT INTO course(id, name, created_date, last_updated_date) values (10002, 'JPA in 40 Steps',sysdate(),sysdate());
INSERT INTO course(id, name, created_date, last_updated_date) values (10003, 'JPA in 30 Steps',sysdate(),sysdate());
INSERT INTO course(id, name, created_date, last_updated_date) values (10004, 'JPA in 20 Steps',sysdate(),sysdate());

INSERT INTO passport(id,number ) values (40001,'E123456');
INSERT INTO passport(id,number ) values (40002,'A123456');
INSERT INTO passport(id,number ) values (40003,'B123456');

INSERT INTO student(id,name, passport_id) values (20001,'Ranga', 40001);
INSERT INTO student(id,name, passport_id) values (20002,'Adam', 40002);
INSERT INTO student(id,name, passport_id) values (20003,'Jane', 40003);


INSERT INTO review(id,rating,description,course_id) values (50001,'5','Great Course',10001);
INSERT INTO review(id,rating,description,course_id) values (50002,'4','Wonderful Course',10001);
INSERT INTO review(id,rating,description,course_id) values (50003,'5','Awesome Course',10003);

INSERT INTO STUDENT_COURSE(student_id, course_id)
VALUES (20001,10001);
INSERT INTO STUDENT_COURSE(student_id, course_id)
VALUES (20002,10001);
INSERT INTO STUDENT_COURSE(student_id, course_id)
VALUES (20003,10001);
INSERT INTO STUDENT_COURSE(student_id, course_id)
VALUES (20001,10003);





