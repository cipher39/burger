# burger
Burger app(using Maven, Spring &amp; Java) is simple display of how to build a REST API &amp; read data from MySql DB using spring-data-jpa


dependencies added while creating the project on https://start.spring.io/
**Spring Web (WEB, spring-boot-starter-web)**
Build web applications, including RESTful applications using Spring MVC. Uses Apache Tomcat as the default embedded container.

**Spring Data JPA (SQL, spring-boot-starter-data-jpa)**
Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.

**MySQL Driver (SQL, mysql-connector-j)**
MySQL JDBC driver.

**@Controller was giving the following error**
Resolved [org.springframework.web.method.annotation.MethodArgumentTypeMismatchException: Failed to convert value of type 'java.lang.String' to required type 'java.lang.Integer'; For input string: "john"]
And hence BAD_REQUEST in Postman. So,

**changed @Controller → @RestController**
@RestController is a composed annotation that is itself meta-annotated with @Controller and @ResponseBody, indicating a controller whose every method inherits the type-level @ResponseBody annotation and therefore writes directly to the response body vs view resolution and rendering with an HTML template.

**org.slf4j is provided by Spring itself**
**Use jakarta.persistence for Spring> 2.7, javax.persistence is used for Spring <= 2.7. Otherwise, it will give an error creating a bean**

**Swagger UI is a REST API documentation tool**
**burger REST API Endpoints**
http://localhost:8080/burger/addemployee
input: below JSON               output: boolean

{
    "empId" : 1001,
    "name" : "Sam B",
    "email" : "samb@email.com"
}


# berger-consumer
It displays the use of **RestTemplate** to call a REST API in spring boot aplication
**burger-consumer REST API Endpoints**
http://localhost:8090/burger-consumer/emp/1002            returns Employee details in JSON




