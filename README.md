This project is a Digital Library Book Management System built using Spring MVC with a MySQL database for data storage.

FEATURES : 
- Add a Book
- View All Books
- Search Book by ID or Title
- Update Book Details
- Delete a Book Record
- Exit System and Enter System Buttons

Technologies Used
- Java
- Spring MVC
- JPA (Java Persistence API) for repository management
- MySQL for data storage
- Maven for dependency management

HOW TO RUN IT ON YOUR SYSTEM
- Clone this repo
- Open in any IDE
- Make sure you have Java installed by running java -version
- Ensure MySQL is running
- Update the credentials with yours DB credentials
    spring.datasource.url=jdbc:mysql://localhost:3306/db_name
    spring.datasource.username=your_username
    spring.datasource.password=your_password

- Check if you have maven installed by running mvn -v
- Else you get support of mvnw (maven wrapper)
- Check if you have 8080 port empty if not then in application.properties change it
- Then run commands -> 
    mvn clean install
    mvn spring-boot:run
    ------or-----------
    ./mvnw clean install
    ./mvnw spring-boot:run

- Go to http://localhost:port_number or 127.0.0.1:port_number
  
