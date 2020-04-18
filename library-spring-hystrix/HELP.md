<?xml version="1.0" encoding="UTF-8"?>
<module type="JAVA_MODULE" version="4" />

## Содержание:
* [Домашнее задание "Обернуть внешние вызовы в Hystrix"](#Библиотека-с-Hystrix)
* [Reference Documentation](#Reference-Documentation)

# Библиотека с Hystrix
Обернуть внешние вызовы в Hystrix

Цель: Цель: сделать внешние вызовы приложения устойчивыми к ошибкам 
Результат: приложение с изолированными с помощью Hystrix внешними вызовами
1. Обернуть все внешние вызовы в Hystrix, Hystrix Javanica.
2. Возможно использование Resilent4j
3. Возможно использование Feign Client
Опционально: Поднять Turbine Dashboard для мониторинга.

## Реализованный функционал:

### Hystrix внешние вызовы приложения устойчивые к ошибкам
Hystrix навешен на ru.otus.spring.library.docker.services.BooksService.findAll
Но, есть проблемы со Spring Security. 
Из-за этого вызывается сразу запасной метод reserveBookList. 
Были попытка решить вопрос по следующей рекомендации
https://jfconavarrete.wordpress.com/2014/09/15/make-spring-security-context-available-inside-a-hystrix-command/
Но застрял на ошибке
org.springframework.security.authentication.AuthenticationCredentialsNotFoundException: An Authentication object was not found in the SecurityContext
Непонятно, почему не устанавливается контекст в 
ru.otus.spring.library.docker.config.hystrix.SecurityContextHystrixRequestVariableSetterFilter.doFilter

### Feign
Вызов черех feign сделан на корневой странице index.html 
см. ru.otus.spring.library.docker.controllers.PagesController.indexPage
Сами классы ru.otus.spring.library.docker.feign

### Hystrix Dashboard:
Stream в чистом виде:       http://localhost:8080/actuator/hystrix.stream?delay=2000
Запуск Hystrix Dashboard:   http://localhost:8080/hystrix
где указать URL потока hystrix.stream

### Роли:

ROLE_ADMIN - доступ к операциям с книгами, доступ к комментариям других владельцев
ROLE_USER - не может видеть книги 18+
ROLE_USER18+ - дополнительно видит книги 18+

### Пользователи:

Admin/12345678  - роль ROLE_ADMIN
User01/12345678 - роль ROLE_USER
User02/12345678 - роль ROLE_USER18+

### Книги

1) Книги могут видеть все
2) Пользователь User01 не может видеть книги 18+. У нас только одна книга 18+, это id = 3, 'Звёздные короли'
3) Для просмотра книг 18+ требуется роль ROLE_USER18+, которая дана пользователю User02
4) Добавлять, редактировать и удалять книги может только администратор

### Комментарии

5) Предустановленные комментарии в файле data.sql наследуют права от своей книги
6) Новые коментарии создаются со своим ACL
7) Добавлять комментарий может любой зарегистрированный пользователь
8) Удалять комментарий может только владелец комментария или администратор

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/maven-plugin/)
* [Spring Web Services](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#boot-features-webservices)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#boot-features-spring-mvc-template-engines)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#boot-features-security)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

