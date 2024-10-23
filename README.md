# SOLV-LABA PROJECTS 
## JSON Implementation
Parsing multiple JSON files with Jackson in a Java application. The following JSON files were created in the resources folder to represent different entities of the class hierarchy: student.json, professor.json, subject.json, degree.json, book.json
To handle the parsing of these JSON files, a new JsonParser class was implemented, which is responsible for reading and deserializing the JSON data into Java objects using Jackson annotations and features. Complex data types such as dates and lists were handled using the appropriate Jackson annotations.

## JAXB Implementation
I added JAXB annotations to the classes Library, Staff, and Book, covering both Date and List types. 
I also created two new classes:
+ JaxB, where I added methods for unmarshalling and marshalling.
+ DataAdapter, which provides an adapter to instruct JAXB on how to handle a specific type.

## XML Validation and Parsing 
For this task I made the following updates to the project:

+ Created XML and XSD files:
university.xml, represent data from the classes of the University hierarchy.
university.xsd,  define the structure and data types for validating the XML file.

+ Implemented XML validation with SAX:
Added a class XMLValidatorWithSAX that uses the SAX parser to validate the university.xml file against the university.xsd schema, this checks the XML for structural correctness according to the schema.

## DAO Implementation
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





