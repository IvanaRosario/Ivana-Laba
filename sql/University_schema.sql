ALTER TABLE subject_z 
MODIFY COLUMN id int NOT NULL AUTO_INCREMENT,
MODIFY COLUMN name varchar(50) NOT NULL,
MODIFY COLUMN period enum("FIRST_QUARTER", "SECOND_QUARTER", "ANNUAL") NOT NULL ,
ADD UNIQUE(id),
ADD PRIMARY KEY(id);

CREATE TABLE professor (
professor_id int NOT NULL AUTO_INCREMENT,
name varchar(50) NOT NULL,
age INT NOT NULL,
address VARCHAR(50) NOT NULL,
phone_number VARCHAR(100) NOT NULL,
departament VARCHAR(100) NOT NULL,
category ENUM("FULL", "ASSOCIATE", "ASSISTAN", "HEAD_OF_PRACTICALL_WORK", "TEACHING_ASSISTAN") NOT NULL,
UNIQUE(professor_id),
PRIMARY KEY(professor_id)
);

ALTER TABLE subject_z
RENAME COLUMN id to subject_id;

CREATE TABLE student (
student_id int NOT NULL AUTO_INCREMENT,
name varchar(50) NOT NULL,
age int not null,
address varchar(50) NOT NULL,
phone_number VARCHAR(100),
degree_id int not null,
UNIQUE(student_id),
PRIMARY KEY(student_id)
);

CREATE TABLE staff (
staff_id int NOT NULL AUTO_INCREMENT,
name varchar(50) NOT NULL,
age int not null,
address varchar(50) NOT NULL,
phone_number VARCHAR(100),
category enum("ADMINISTRATIVE", "MAINTENANCE_PRODUCTION_GENERAL_SERVICES", "TECHNICAL", "ASSISTANCE"),
UNIQUE(staff_id),
PRIMARY KEY(staff_id)
);

CREATE TABLE degree(
degree_id int not null auto_increment,
name varchar(100) not null,
duration int not null,
course_type enum("UNDERGRADUATE", "POSTGRADUATE", "DOCTORATE") not null,
unique(degree_id),
primary key(degree_id)
);

CREATE TABLE college(
college_id int not null auto_increment,
name varchar(100) not null,
unique(college_id),
primary key(college_id)
);

CREATE TABLE grade(
subject_id int not null,
subject_name varchar(100),
score double not null,
student_id int not null,
student_name varchar(100) not null,
professor_id int not null,
professor_name varchar(100)
);

ALTER TABLE professor
add subject_id int not null,
add foreign key(subject_id)
references subject_z(subject_id);

CREATE TABLE student_subject(
subject_id int not null,
subject_name varchar(100) not null,
student_id int not null,
student_name varchar(100)
);

ALTER TABLE student
add foreign key(degree_id)
references degree(degree_id);

CREATE TABLE subject_degree(
degree_id int not null,
degree_name varchar(100), 
subject_id int not null,
subject_name varchar(100)
);

CREATE TABLE books(
 book_id int not null auto_increment primary key,
 name varchar(100) not null,
 author varchar(100) not null,
 state enum("AVAILABLE", "BORROWED")
 );
 
 CREATE TABLE student_book(
 student_book_id int not null auto_increment primary key,
 student_id int not null,
 book_id int not null,
 foreign key(student_id) references student(student_id),
 foreign key(book_id) references books(book_id)
 );
 
 ALTER TABLE subject_degree
 add subject_degree_id int not null auto_increment primary key,
 add foreign key(degree_id) references degree(degree_id),
 add foreign key(subject_id) references subject(subject_id);
 
ALTER TABLE student_subject
 add student_subject_id int not null auto_increment primary key,
 add foreign key(student_id) references student(student_id),
 add foreign key(subject_id) references subject(subject_id);
 
 ALTER TABLE subject_degree
 add unique(degree_id, subject_id);
 
 ALTER TABLE student_subject
 add unique(student_id, subject_id);
 

