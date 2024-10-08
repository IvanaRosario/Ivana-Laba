INSERT INTO subject (name, period) VALUES("Calculo I", "FIRST_QUARTER");
INSERT INTO subject (name, period) VALUES("Algebra I", "FIRST_QUARTER");
INSERT INTO subject (name, period) VALUES("Chemestry", "FIRST_QUARTER");
INSERT INTO subject (name, period) VALUES("Physics I", "FIRST_QUARTER");
INSERT INTO subject (name, period) VALUES("Calculo II", "FIRST_QUARTER");
INSERT INTO degree (name, duration, course_type) VALUES("Bachelor of Physics", 5, "DOCTORATE");
INSERT INTO degree (name, duration, course_type) VALUES("Computer Engineering", 5, "UNDERGRADUATE");
INSERT INTO degree (name, duration, course_type) 
VALUES("Associate degree in Computer Programing", 4, "UNDERGRADUATE");
INSERT INTO student (name, age, address, phone_number, degree_id) 
VALUES("Molina Melina", 26, "Address 123", "9876543321", 1);
INSERT INTO student (name, age, address, phone_number, degree_id) 
VALUES("Maira Berana", 21, "Street 123", "1234567890", 2);
INSERT INTO student (name, age, address, phone_number, degree_id) 
VALUES("Anna Smith", 24, "Street 564", "132435769", 2);
INSERT INTO professor (name, age, address, phone_number, departament, category, subject_id)
VALUES("Juan Perez", 38, "Street 456", "123456789", "Mathematics", "HEAD_OF_PRACTICALL_WORK", 1);
INSERT INTO professor (name, age, address, phone_number, departament, category, subject_id)
VALUES("Pepe Rodriguez", 55, "Street 987", "968374925", "Mathematics", "ASSISTAN", 2);
INSERT INTO professor (name, age, address, phone_number, departament, category, subject_id)
VALUES("Lautaro Sosa", 40, "Street 223", "987654567", "Natural Sciences", "HEAD_OF_PRACTICALL_WORK", 4);


UPDATE degree SET duration = 6 WHERE degree_id = 1;
UPDATE degree SET course_type = "POSTGRADUATE" WHERE degree_id = 3;
UPDATE subject SET period = "ANNUAL" WHERE subject_id = 4;
UPDATE subject SET period = "SECOND_QUARTER" WHERE subject_id = 5;
UPDATE student SET degree_id = 3 WHERE student_id = 2;
UPDATE student SET address = "Address 098", phone_number = "154417686" WHERE student_id = 1;
UPDATE professor SET departament = "Natural Sciences", subject_id = 3 WHERE professor_id = 1;
UPDATE professor SET category = "ASSOCIATE" WHERE professor_id = 2;

DELETE FROM subject WHERE subject_id = 1;
DELETE FROM subject WHERE subject_id = 3; 
DELETE FROM subject WHERE subject_id = 4; 
DELETE FROM subject WHERE subject_id = 5; 
DELETE FROM degree WHERE degree_id = 1;
DELETE FROM degree WHERE degree_id = 2;
DELETE FROM student WHERE student_id = 1;
DELETE FROM student WHERE student_id = 2;
DELETE FROM professor WHERE professor_id = 1;
DELETE FROM professor WHERE professor_id = 3;

ALTER TABLE student ADD email varchar(250);
ALTER TABLE professor ADD email varchar(250);
ALTER TABLE subject_degree DROP COLUMN subject_name;
ALTER TABLE subject_degree DROP COLUMN degree_name;
ALTER TABLE student_subject DROP COLUMN student_name;
ALTER TABLE student_subject DROP COLUMN subject_name;
ALTER TABLE student_book DROP COLUMN student_name;
ALTER TABLE student_book DROP COLUMN book_name;
ALTER TABLE grade ADD score INT;

SELECT 
	sb.subject_id, sb.name AS subject_name,
    st.student_id, st.name AS student_name,
    pr.professor_id, pr.name AS prof_name,
    dg.degree_id, dg.name AS degree_name
FROM 
	subject sb
JOIN 
    student st
JOIN 
    professor pr ON pr.professor_id = sb.subject_id
JOIN 
   degree dg;
   
SELECT professor.name AS Professor, subject.name AS Subject
FROM subject INNER JOIN professor ON professor.subject_id = subject.subject_id; 
SELECT * FROM student LEFT OUTER JOIN degree ON student.degree_id = degree.degree_id;
SELECT * FROM student RIGHT OUTER JOIN degree ON student.degree_id = degree.degree_id;

SELECT COUNT(student_id), age  FROM student GROUP BY age;
SELECT MAX(age), category FROM professor GROUP BY category;
SELECT COUNT(professor_id), category FROM professor GROUP BY category;
SELECT course_type, COUNT(degree_id) AS Total FROM degree GROUP BY course_type;
SELECT degree.name, COUNT(student.student_id) AS Enrolled FROM student 
INNER JOIN degree ON student.degree_id=degree.degree_id GROUP BY degree.name;
SELECT d.name, AVG(s.age) 
FROM student s 
INNER JOIN degree d ON s.degree_id = d.degree_id
GROUP BY d.name; -- Promedio de edad de los estudiantes por grado

SELECT COUNT(student_id), age FROM student GROUP BY age HAVING COUNT(student_id) > 1;
SELECT MAX(age), category FROM professor GROUP BY category HAVING COUNT(professor_id) > 2;
SELECT course_type, COUNT(degree_id) FROM degree GROUP BY course_type HAVING COUNT(degree_id) > 1;
SELECT d.name, AVG(s.age) FROM student s 
INNER JOIN degree d ON s.degree_id = d.degree_id
GROUP BY d.name HAVING COUNT(s.student_id) > 5;
SELECT sub.name, COUNT(s.student_id)FROM student s 
JOIN enrollments e ON s.student_id = e.student_id JOIN subject sub ON e.subject_id = sub.subject_id
GROUP BY sub.name HAVING COUNT(s.student_id) > 10;
SELECT age, COUNT(professor_id) FROM professor
GROUP BY age HAVING COUNT(professor_id) > 1;
SELECT course_type, COUNT(degree_id) FROM degree GROUP BY course_type HAVING COUNT(degree_id) > 2;


