<?xml version="1.0" encoding="UTF-8"?>
<module type="JAVA_MODULE" version="4" />

## Содержание:
* [Домашнее задание по теме Docker](#Домашнее_задание_по_теме_Docker)
* [Reference Documentation](#Reference Documentation)

# Библиотека в Docker

## Домашнее задание по теме Docker
Обернуть приложение в docker-контейнер

### Цель: Цель: деплоить приложение в современном DevOps-стеке Результат: обёртка приложения в Docker
Внимание! Задание выполняется на основе любого сделанного Web-приложения

1. Обернуть приложение в docker-контейнер. Dockerfile принято располагать в корне репозитория. В image должна попадать JAR-приложения. Сборка в контейнере рекомендуется, но не обязательна.
2. Если Вы не используете кастомные плагины для БД, не нужно делать для нее отдельный Dockerfile. Лучше взять готовый образ
3. Настроить связь между контейнерами, с помощью docker-compose
4. Опционально: сделать это в локальном миникубе.
5. Приложение желательно реализовать с помощью всех Best Practices Docker (логгирование в stdout и т.д.)

## Реализация
### Сборка и запуск
mvn -f pom.xml clean package 
docker-compose up

### Разное:
Пользователи для входа:

Admin/12345678  - роль ROLE_ADMIN
User01/12345678 - роль ROLE_USER
User02/12345678 - роль ROLE_USER18+

Книги

1) Книги могут видеть все
2) Пользователь User01 не может видеть книги 18+. У нас только одна книга 18+, это id = 3, 'Звёздные короли'
3) Для просмотра книг 18+ требуется роль ROLE_USER18+, которая дана пользователю User02
4) Добавлять, редактировать и удалять книги может только администратор

Комментарии

5) Предустановленные комментарии в файле data.sql наследуют права от своей книги
6) Новые коментарии создаются со своим ACL
7) Добавлять комментарий может любой зарегистрированный пользователь
8) Удалять комментарий может только владелец комментария или администратор
9) Только владелец комментария видит ссылку Delete 

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

