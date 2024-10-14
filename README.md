# SOLV-LABA PROJECTS 

I added two packages:

Package dao: Contains the generic and specific interfaces to interact with the different entities of the system and abstract the data access layer.
+ DAO<T>: Defines the basic CRUD operations for any entity in the system. The main methods are:
        insert(T t)
        update(T t)
        delete(T t)
        obtain(K id)
        getAll()
+ DAOManager: Interface that groups the operations on specific DAOs, such as StudentDAO, SubjectDAO, and ProfessorDAO
+ StudentDAO, SubjectDAO, ProfessorDAO: Interfaces that extend DAOGeneric and allow handling specific operations for each entity (Student, Subject, Professor).

Package mysql: Provides concrete implementations of data access using MySQL and JDBC.
+ MySQLStudentDAO: Implements the StudentDAO interface to perform CRUD operations on the Student table in the MySQL database.
+ MySQLSubjectDAO: Implements the SubjectDAO interface to handle CRUD operations on the Subject table.
+ MySQLProfessorDAO: Implements the ProfessorDAO interface to perform CRUD operations on the Professor table.
+ MySQLDAOManager: Class that groups instances of specific DAOs to manage data access operations from a single point.

Service Layer: The service layer is implemented in the service package, and the StudentServiceImpl, ProfessorServiceImpl, and SubjectServiceImpl classes provide the implementations.
