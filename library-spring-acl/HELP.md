<?xml version="1.0" encoding="UTF-8"?>
<module type="JAVA_MODULE" version="4" />

## Содержание:
* [Домашнее задание "Ввести авторизацию на основе URL и/или доменных сущностей"](#Библиотека на Spring Security ACL)
* [Reference Documentation](#Reference Documentation)

# Библиотека на Spring Security ACL

Ввести авторизацию на основе URL и/или доменных сущностей
Цель: Цель: научиться защищать приложение с помощью полноценной авторизации и разграничением прав доступа Результат: полноценное приложение с безопасностью на основе Spring Security
Внимание! Задание выполняется на основе нереактивного приложения Sping MVC!

1. Минимум: настроить в приложении авторизацию на уровне URL.
2. Максимум: настроить в приложении авторизацию на основе доменных сущностей и методов сервиса.

Рекомендации по выполнению:
1. Не рекомендуется выделять пользователей с разными правами в разные классы - т.е. просто один класс пользователя.
2. В случае авторизации на основе доменных сущностей и PostgreSQL не используйте GUID для сущностей.

Реализованный функционал:
Роли:

ROLE_ADMIN - доступ к операциям с книгами, доступ к комментариям других владельцев
ROLE_USER - не может видеть книги 18+
ROLE_USER18+ - дополнительно видит книги 18+

Пользователи:

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
Только владелец комментария видит ссылку Delete 
Для предотвращения удаления комментария по ссылке используется Custom Expression @PreAuthorize("isCommentOwner(#commentId)")
Примечание: пример прямой ссылки для удаления: http://localhost:8080/books/2/comment/3/delete
Почему-то Custom Expression через класс MethodSecurityConfig, который возвращает CustomMethodSecurityExpressionHandler, не установился.
Пришлось возвращать его через метод defaultMethodSecurityExpressionHandler в классе AclConfig.

Вопросы:
Spring Security и ACL сохраняют пользователей в разных таблицах, соответственно users и acl_sid.
Как принято делать, соединить таблицы users и acl_sid?

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

