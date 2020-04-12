# Getting Started

## Домашнее задание
Использовать метрики, healthchecks и logfile к приложению
Цель: Цель: реализовать production-grade мониторинг и прозрачность в приложении Результат: приложение с применением Spring Boot Actuator
Данное задание выполняется на основе одного из реализованных Web-приложений

1. Подключить Spring Boot Actuator в приложение метрики.
2. Включить метрики, healthchecks и logfile.
3. Реализовать свой собственный HealthCheck индикатор
4. UI для данных от Spring Boot Actuator реализовывать не нужно.
5. Опционально: переписать приложение на HATEOAS принципах с помощью Spring Data REST Repository

## Реализовано:
1) Подключил actuator 
2) Добавил свой healthchecker, класс LibraryHealthIndicator
3) Добавил логфайл http://localhost:8080/actuator/logfile
4) Добавил spring-boot-starter-data-rest. Ссылка http://localhost:8080/datarest
5) Исправил замечания из предыдущего ДЗ
   
### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/maven-plugin/)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#production-ready)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

