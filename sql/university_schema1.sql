CREATE SCHEMA university_db;

CREATE TABLE degree(
degree_id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(150) NOT NULL,
duration INT NOT NULL,
course_type ENUM("UNDERGRADUATE", "POSTGRADUATE", "DOCTORATE") NOT NULL,
UNIQUE(degree_id ),
PRIMARY KEY(degree_id)
);

CREATE TABLE student(
student_id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(150) NOT NULL,
age INT NOT NULL,
address VARCHAR(150) NOT NULL,
phone_number VARCHAR(150) NOT NULL,
degree_id INT NOT NULL,
UNIQUE(student_id),
PRIMARY KEY(student_id),
FOREIGN KEY(degree_id) REFERENCES degree(degree_id)
);

CREATE TABLE subject (
  subject_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(150) NOT NULL,
  period ENUM('FIRST_QUARTER','SECOND_QUARTER','ANNUAL') NOT NULL,
  UNIQUE(subject_id),
  PRIMARY KEY (subject_id)
);

CREATE TABLE professor(
professor_id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(150) NOT NULL,
age INT NOT NULL,
address VARCHAR(150) NOT NULL,
phone_number VARCHAR(150) NOT NULL,
departament VARCHAR(100) NOT NULL,
category ENUM("FULL", "ASSOCIATE", "ASSISTAN", "HEAD_OF_PRACTICALL_WORK", "TEACHING_ASSISTAN") NOT NULL,
subject_id INT NOT NULL,
UNIQUE(professor_id),
PRIMARY KEY(professor_id),
FOREIGN KEY(subject_id) REFERENCES subject(subject_id)
);

CREATE TABLE staff(
staff_id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(150) NOT NULL,
age INT NOT NULL,
address VARCHAR(150) NOT NULL,
phone_number VARCHAR(150) NOT NULL,
category ENUM("ADMINISTRATIVE", "MAINTENANCE_PRODUCTION_GENERAL_SERVICES", "TECHNICAL", "ASSISTANCE"),
UNIQUE(staff_id),
PRIMARY KEY(staff_id)
);

CREATE TABLE college(
college_id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(150) NOT NULL,
UNIQUE(college_id),
PRIMARY KEY(college_id)
);

CREATE TABLE grade(
grade_id INT NOT NULL AUTO_INCREMENT,
subject_id INT NOT NULL,
subject_name VARCHAR(150) NOT NULL,
student_id INT NOT NULL,
student_name VARCHAR(150) NOT NULL,
UNIQUE(grade_id),
PRIMARY KEY(grade_id),
UNIQUE(student_id, subject_id),
FOREIGN KEY(subject_id) REFERENCES subject(subject_id),
FOREIGN KEY(student_id) REFERENCES student(student_id)
);

CREATE TABLE books(
book_id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(150) NOT NULL,
author VARCHAR(150) NOT NULL,
state ENUM("AVAILABLE", "BORROWED"),
UNIQUE(book_id),
PRIMARY KEY(book_id)
);

CREATE TABLE student_subject(
student_subject_id INT NOT NULL AUTO_INCREMENT,
student_id INT NOT NULL ,
student_name VARCHAR(150) NOT NULL,
subject_id INT NOT NULL,
subject_name VARCHAR(150) NOT NULL,
UNIQUE(student_subject_id),
PRIMARY KEY(student_subject_id),
FOREIGN KEY(student_id) REFERENCES student(student_id),
FOREIGN KEY(subject_id) REFERENCES subject(subject_id)
);

CREATE TABLE subject_degree(
subject_degree_id INT NOT NULL AUTO_INCREMENT,
subject_id INT NOT NULL,
subject_name VARCHAR(150) NOT NULL,
degree_id INT NOT NULL,
degree_name VARCHAR(150) NOT NULL,
UNIQUE(subject_degree_id),
PRIMARY KEY(subject_degree_id),
FOREIGN KEY(degree_id) REFERENCES degree(degree_id),
FOREIGN KEY(subject_id) REFERENCES subject(subject_id)
);

CREATE TABLE student_book(
student_book_id INT NOT NULL AUTO_INCREMENT,
student_id INT NOT NULL,
student_name VARCHAR(150) NOT NULL,
book_id INT NOT NULL,
book_name VARCHAR(150) NOT NULL,
UNIQUE(student_book_id),
PRIMARY KEY(student_book_id),
FOREIGN KEY(student_id) REFERENCES student(student_id),
FOREIGN KEY(book_id) REFERENCES books(book_id)
);




