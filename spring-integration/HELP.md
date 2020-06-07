# Getting Started

## Содержание:
* [Домашнее задание](#Домашнее задание)
* [Reference Documentation](#Reference Documentation)

# Домашнее задание
Реализовать обработку доменной сущности через каналы Spring Integration
Цель: Цель: организовать "интеграцию" и flow доменной сущности с помощью EIP Результат: приложение c применением EIP на Spring Integration
1. Внимание! Задание может быть выполнено в отдельном репозитории и с совершенно другой доменной областью и сущностями
2. Для каждого действия выберите подходящий канал
3. Опционально: протестируйте приложение под нагрузкой.

# Реализация
С помощью Spring Integration реализован сортировщик файлов,
который сканирует директорию resources/source,
и если файл имеет расширение .jpg, то сохраняет его в MongoDB,
иначе перекладывает в директорию resources/target.

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/maven-plugin/)
* [Spring Integration](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#boot-features-integration)

### Guides
The following guides illustrate how to use some features concretely:

* [Integrating Data](https://spring.io/guides/gs/integration/)

