<?xml version="1.0" encoding="UTF-8"?>
<module type="JAVA_MODULE" version="4" />

# Course "Spring Framework Developer", OTUS
[Russian](README.ru.md)

## Content:
* [Student](#Student)
* [Directory students-testing](#Directory-students-testing)
* [Directory students-testing-03](#Directory-students-testing-03)
* [Directory students-testing-shell](#Directory-students-testing-shell)
* [Directory library](#Directory-library)
* [Directory library-orm](#Directory-library-orm)
* [Directory library-spring-data](#Directory-library-spring-data)
* [Directory library-nosql](#Directory-library-nosql)
* [Directory library-spring-rest](#Directory-library-spring-rest)
* [Directory library-spring-webflux](#Directory-library-spring-webflux)
* [Directory library-spring-security](#Directory-library-spring-security)
* [Directory library-spring-acl](#Directory-library-spring-acl)
* [Directory spring-batch](#Directory-spring-batch)
* [Directory spring-integration](#Directory-spring-integration)
* [Directory library-spring-docker](#Directory-library-spring-docker)
* [Directory library-spring-hystrix](#Directory-library-spring-hystrix)
* [Directory oca-extension](#Directory-oca-extension)

# Student
Student: Vadim Lyulin
Course: Spring Framework Developer
Group: 2019-11

## Directory students-testing
Configuring Spring Applications Homework
Student Testing Program

Target:
Build an application with Spring IoC to get familiar with the core IoC functionality that all of Spring is built on. Result: a simple application configured with an XML context.

Task description:

The resources store questions and answers to them in the form of a CSV file (5 questions). The program should ask the user for the last name and first name, ask 5 questions from the CSV file and display the test result. Questions can be with a choice from several options or with a free answer - at your desire and discretion.

Requirements:

    All services in the program must solve a strictly defined problem.
    The context is described by an XML file.
    All dependencies must be configured in the IoC container.
    The name of the resource with the question (CSV file) must be hardcoded into an XML file with the context.
    The CSV with the question is read exactly as a resource, not as a file.
    You don't need to put the scanner and the standard context in!
    The application should run correctly with java -jar.
    It is highly desirable to write a Unit test of some service (only an attempt to write a test will be evaluated).

The task is submitted in the form of a link to a pull-request in a chat with a teacher. You can ask questions in chat, but we recommend Slack for efficiency.

The code written in this DZ will be studied further in homework # 2 (Lesson # 2), # 3 (Lesson # 4), # 4 (Lesson # 5)

## Directory students-testing-03
Black Magic Homework Spring Boot
Migrate Student Testing Application to Spring Boot

Add Settings File, Annotation- + Java-based Application Configuration
Target:

Goal: configure Spring applications in a modern way, as it is done in the modern world Result: a complete modern application in pure Spring

Performed based on previous homework.

    Rewrite the configuration as Java + Annotation-based configuration.
    Localize displayed messages and questions (in a CSV file).
    Add a settings file for the student testing application. You can put the path to the CSV file and / or the current locale in the configuration file, the number of correct answers for the test is at your discretion.
    If you are writing integration tests, do not forget to add a similar file for the tests.

The task is submitted in the form of a link to a pull-request in a chat with a teacher. You can ask questions in chat, but we recommend Slack for efficiency.

The code written in this DZ will be used further in homework # 3 (Lesson # 4), # 4 (Lesson # 5) This task counts DZ # 1 (Lesson # 1). If you want to count, be sure to send the link to the chat of the corresponding previous lesson.

## Directory students-testing-shell
Homework
Translate your survey application to Spring Shell

Objective: After completing the RS, you will be able to use the Spring Shell to write an application interface without the Web. Result: Application on Spring Shell

Homework is done based on the previous one.

Necessary:

    Connect Spring Shell using spring-starter.
    Write a set of commands that allows you to conduct a survey.
    Write Unit tests using spring-boot-starter-test, take into account that Spring Shell must be disabled in tests.

The set of commands depends only on your desire. You can make one command that launches your Main, or you can build a full-fledged interface on the Spring Shell.

It is NOT NECESSARY to localize Spring Shell commands (although it is possible, but it is long and difficult).

The task is submitted in the form of a link to a pull-request in a chat with a teacher. You can ask questions in chat, but we recommend Slack for efficiency.

## Directory library
Spring JDBC DAO Homework
Application storing information about books in the library

Create an application that stores information about books in the library
Target:

Purpose: to use the capabilities of Spring JDBC and spring-boot-starter-jdbc to connect to relational databases Result: an application with data storage in a relational database, which we will further develop

This homework is NOT done based on the previous one.

    Use Spring JDBC and relational database (H2 or real relational database). It is highly recommended to use NamedParametersJdbcTemplate
    Provide tables of authors, books and genres.
    One-to-many relationships are assumed (a book has one author, but an author may have several books, the same goes for books and genres). An optional complication is many-to-many relationships.
    The interface is executed on the Spring Shell (book CRUD is required, operations with authors and journals - as convenient).
    The table creation script and data fill script should be automatically started using spring-boot-starter-jdbc.
    Cover with tests as much as possible.

Recommendations for work performance:

    DO NOT do AbstractDao.
    DO NOT do inheritance in tests

This homework is the basis for the following.

## Directory library-orm
Homework on the topic "Rewrite the application for storing books on ORM"
Application storing information about books in the library

Rewrite book storage application on ORM
Target:

Goal: to fully work with JPA + Hibernate to connect to relational databases through an ORM framework Result: High-level application with JPA entity mapping

Homework is done by rewriting the previous one to JPA.

Requirements:

    Use JPA, Hibernate only as JPA provider.
    Add comments to books, and high-level services that leave comments to books.
    Cover repositories with tests using H2 database and corresponding H2 Hibernate dialect for tests.
    Don't forget to disable DDL via Hibernate

This homework will be used as a basis for other RCs. This work does not count the previous one!

## Directory library-spring-data
Spring Data JPA Library Homework

Goal: as simple as possible to write a layer of repositories using modern approaches Result: an application with a layer of repositories on Spring Data JPA

Homework is done by rewriting the previous one to JPA.

Requirements:

    Rewrite all book repositories to Spring Data JPA repositories.
    Use spring-boot-starter-data-jpa.
    Custom methods of repositories (or with the tricky @Query) are covered with tests using H2.

This homework will be used as a basis for other RCs. This work does not count the previous one!

## Directory library-nosql
Homework on "Use MongoDB and spring-data to store book information"
Application storing information about books in the library

Use MongoDB and spring-data to store book information

Objective: After completing the RS, you will be able to use Spring Data MongoDB and MongoDB itself to develop applications with data storage in a non-relational database. Result: Application using MongoDB

The task can be performed on the basis of the previous one, or it can be performed independently

Requirements:

    Use Spring Data MongoDB repositories, and if functionality is lacking, then * Operations
    Tests can be implemented using Flapdoodle Embedded MongoDB
    Hibernate, as well as JPA, and spring-boot-starter-data-jpa should not remain in dependencies if DZ is executed based on the previous one.
    How to store books, authors, genres and comments is up to you. But a structure ported from a relational database will not always be suitable for MongoDB.

## Directory library-spring-rest
Homework on "Modern Spring MVC Applications"

CRUD application with Web UI and data storage in a database

Goal: Develop full-fledged classic Web applications Result: Fully Spring Web Application

Necessary:

    Create an application with storing entities in a database (you can take the library and DAO / repositories from previous lessons)
    Use Classic View on Thymeleaf, classic Controllers.
    For books (main entity) on the UI, all CRUD operations must be available. CRUD of other entities is optional / required.
    Localization does NOT need to be done - it is strictly optional.

## Directory library-spring-webflux
Spring Web Flux Homework

Use WebFlux

Goal: develop Responsive and Resilent applications on the Spring reactive stack using Spring Web Flux and Reactive Spring Data Repositories Result: application on the Spring reactive stack

     The task is performed on a remote data basis with MongoDB.
     You can choose a different domain model (not a library) and a different database (Redis).
     Reactive Spring Data Repositories must be used. PostgreSQL and experimental R2DBC are not recommended.
     RxJava vs Project Reactor - for your taste.
     Use WebFlux instead of classic Spring MVC and embedded web server.

## Directory library-spring-security
Spring Security: Authentication Mechanisms Homework

Add Authentication Mechanism to CRUD Web Application

Objective: Protect the Web Application with Authentication and Simple Authorization Result: Application Using Spring Security

Attention! The job is running based on a non-reactive Sping MVC app!

    Add a new entity to the application - user. It is not necessary to implement methods for creating users - it is permissible to add users only through database scripts.
    Add Form-based authentication mechanism to an existing CRUD application.
    Implement org.springframework.security.core.userdetails.UserDetailsService yourself.
    Authorization on all pages - for all authenticated. Login form - available to everyone.

## Directory library-spring-acl
Homework on the topic "Enter authorization based on URL and / or domain entities"

Enter authorization based on URL and / or domain entities

Objective: to learn how to protect an application using full-fledged authorization and differentiation of access rights Result: a full-fledged application with security based on Spring Security

Attention! The job is running based on a non-reactive Sping MVC app!

    Minimum: Configure URL-level authorization in the application.
    Maximum: configure authorization in the application based on domain entities and service methods.

Recommendations for implementation:

    It is not recommended to separate users with different rights into different classes - i.e. just one user class.
    In case of authorization based on domain entities and PostgreSQL, do not use GUIDs for entities.

## Directory spring-batch
Homework on "Spring Batch"

Based on Spring Batch, develop a procedure for migrating data from relational storage to NoSQL or vice versa

Goal: migrate data using Spring Batch Result: application for batch processing data using Spring Batch

    The task can be performed in a separate repository, with entities from the JPA and MongoDB DZ.
    You can choose another domain model
    It is not necessary to add the migration process to the web application. The application can be designed as a separate utility.
    When using Spring Batch, make sure the entity relationships are preserved.
    Optional: Restart the task using the Spring Shell.

## Directory spring-integration
Homework on "Spring Integration: Endpoints and Flow Components"

Implement domain entity processing through Spring Integration channels

Purpose: to organize "integration" and flow of a domain entity using EIP Result: an application using EIP on Spring Integration

     Attention! The task can be performed in a separate repository and with a completely different domain scope and entities
     Select the appropriate channel for each action
     Optional: test the application under load.

## Directory library-spring-actuator
Homework on "Monoliths vs. Microservices (Round 2), Spring Boot Actuator - must have in microservices"

Use metrics, healthchecks and logfile

Goal: Implement production-grade monitoring and transparency in the application Result: Application using Spring Boot Actuator

This task is performed based on one of the implemented Web applications

    Connect Spring Boot Actuator to your application.
    Include metrics, healthchecks and logfile.
    Implement your own HealthCheck indicator
    The data UI from Spring Boot Actuator does not need to be implemented.
    Optional: rewrite the application on HATEOAS principles using Spring Data REST Repository

## Directory library-spring-docker
Homework on "Docker, Orchestration, Clouds, Cloud Hosting"

Wrap the application in a docker container

Goal: Deploy the application in a modern DevOps stack Result: Wrapping the application in Docker

Attention! The job is executed based on any web application made

    Wrap the application in a docker container. Dockerfile is usually located at the root of the repository. The image must contain JAR applications. Container assembly is recommended but not required.
    If you do not use custom plugins for the database, you do not need to create a separate Dockerfile for it. Better to take a ready-made image
    Configure communication between containers using docker-compose
    Optional: do it in a local minicube.
    It is desirable to implement the application using all Docker Best Practices (logging to stdout, etc.)

## Directory library-spring-hystrix
Homework on "Spring Cloud Service Discovery, Zuul, Hystrix, Sleuth, Zipkin"

Wrap external calls in Hystrix

Goal: Make external calls to the application resilient to errors Result: Application with Hystrix-isolated external calls

     Wrap all external calls in Hystrix, Hystrix Javanica.
     It is possible to use Resilent4j
     Feign Client can be used Optionally: Raise Turbine Dashboard for monitoring.

## Directory oca-extension
Project work.
Design topic: Create an Oracle Cloud Application extension with Spring Framework.

