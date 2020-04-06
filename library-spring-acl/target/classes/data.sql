
insert into lookup_values (lookup_type, language, lookup_code, meaning, description, enabled_flag, start_date_active, end_date_active)
values ('GENRES','RU','HARD_SCIENCE_FICTION','Твердая научная фантастика','Твердая научная фантастика','Y',DATE '-999999999-01-01',DATE '999999999-12-31');
insert into lookup_values (lookup_type, language, lookup_code, meaning, description, enabled_flag, start_date_active, end_date_active)
values ('GENRES','US','HARD_SCIENCE_FICTION','Hard SF','Hard science fiction','Y',DATE '-999999999-01-01',DATE '999999999-12-31');

insert into lookup_values (lookup_type, language, lookup_code, meaning, description, enabled_flag, start_date_active, end_date_active)
values ('GENRES','RU','SOCIAL_SCIENCE_FICTION','Социальная фантастика','Социальная фантастика','Y',DATE '-999999999-01-01',DATE '999999999-12-31');
insert into lookup_values (lookup_type, language, lookup_code, meaning, description, enabled_flag, start_date_active, end_date_active)
values ('GENRES','US','SOCIAL_SCIENCE_FICTION','Social science fiction','Social science fiction','Y',DATE '-999999999-01-01',DATE '999999999-12-31');

insert into lookup_values (lookup_type, language, lookup_code, meaning, description, enabled_flag, start_date_active, end_date_active)
values ('GENRES','RU','CHRONOFANTASTIC','Хронофантастика','Хронофантастика','Y',DATE '-999999999-01-01',DATE '999999999-12-31');
insert into lookup_values (lookup_type, language, lookup_code, meaning, description, enabled_flag, start_date_active, end_date_active)
values ('GENRES','US','CHRONOFANTASTIC','Chronofantastic','Chronofantastic','Y',DATE '-999999999-01-01',DATE '999999999-12-31');

insert into lookup_values (lookup_type, language, lookup_code, meaning, description, enabled_flag, start_date_active, end_date_active)
values ('GENRES','RU','APOCALYPTIC','Апокалиптика','Апокалиптика','Y',DATE '-999999999-01-01',DATE '999999999-12-31');
insert into lookup_values (lookup_type, language, lookup_code, meaning, description, enabled_flag, start_date_active, end_date_active)
values ('GENRES','US','APOCALYPTIC','Apocalyptic','Apocalyptic','Y',DATE '-999999999-01-01',DATE '999999999-12-31');

insert into lookup_values (lookup_type, language, lookup_code, meaning, description, enabled_flag, start_date_active, end_date_active)
values ('GENRES','RU','UTOPIA','Утопии и антиутопии','Утопии и антиутопии','Y',DATE '-999999999-01-01',DATE '999999999-12-31');
insert into lookup_values (lookup_type, language, lookup_code, meaning, description, enabled_flag, start_date_active, end_date_active)
values ('GENRES','US','UTOPIA','Utopia and dystopia','Utopia and dystopia','Y',DATE '-999999999-01-01',DATE '999999999-12-31');

insert into lookup_values (lookup_type, language, lookup_code, meaning, description, enabled_flag, start_date_active, end_date_active)
values ('GENRES','RU','SPACE_OPERA','Космическая опера','Космическая опера','Y',DATE '-999999999-01-01',DATE '999999999-12-31');
insert into lookup_values (lookup_type, language, lookup_code, meaning, description, enabled_flag, start_date_active, end_date_active)
values ('GENRES','US','SPACE_OPERA','Space Opera','Space Opera','Y',DATE '-999999999-01-01',DATE '999999999-12-31');

insert into publishing_houses (publishing_house_id, name, settlement_year)
values (1, 'ИК «Столица» (Изд. группа GELEOS Publishing House)', 2010);
insert into publishing_houses (publishing_house_id, name, settlement_year)
values (2, 'PH «Stolitca» (GELEOS Publishing House)', 1990);

insert into authors (author_id, name, country, sex, date_of_birth)
values (1, 'Дойл, Артур Конан', 'EN', 'M', DATE '1859-05-22');

insert into authors (author_id, name, country, sex, date_of_birth)
values (2, 'Азимов, Айзек', 'RU', 'M', DATE '1920-01-02');

insert into authors (author_id, name, country, sex, date_of_birth)
values (3, 'Гамильтон, Эдмонд', 'US', 'M', DATE '1904-10-21');

insert into books (book_id, name, genre, author_id, publishing_house_id, publishing_year, pages, age_limit)
values (1, 'В ядовитом поясе', 'HARD_SCIENCE_FICTION', 1, 1, 2010, 320, '0+');

insert into books (book_id, name, genre, author_id, publishing_house_id, publishing_year, pages, age_limit)
values (2, 'Конец Вечности', 'CHRONOFANTASTIC', 2, 2, 1955, 247, '12+');

insert into books (book_id, name, genre, author_id, publishing_house_id, publishing_year, pages, age_limit)
values (3, 'Звёздные короли', 'SPACE_OPERA', 3, 2, 1947, 150, '18+');

-- Все пароли 12345678
insert into users (user_id, login, password, name)
values (101, 'User01', '$2y$12$9QTfCGvcHysFN8Mx/TkG9ejN8rbLdJEX3VPwkAxfH3NqiKEoHnLGy', 'User 01');

insert into users (user_id, login, password, name)
values (102, 'User02', '$2y$12$9QTfCGvcHysFN8Mx/TkG9ejN8rbLdJEX3VPwkAxfH3NqiKEoHnLGy', 'User 02');

insert into users (user_id, login, password, name)
values (103, 'Admin', '$2y$12$9QTfCGvcHysFN8Mx/TkG9ejN8rbLdJEX3VPwkAxfH3NqiKEoHnLGy', 'Admin');

insert into authorities (login, authority)
values ('User01', 'ROLE_USER');

-- User 02 имеет доста и к детским книгам ROLE_USER и к очень взрослым ROLE_USER18+
insert into authorities (login, authority)
values ('User02', 'ROLE_USER');
insert into authorities (login, authority)
values ('User02', 'ROLE_USER18+');

-- У администратора есть все роли
insert into authorities (login, authority)
values ('Admin', 'ROLE_ADMIN');
insert into authorities (login, authority)
values ('Admin', 'ROLE_USER');
insert into authorities (login, authority)
values ('Admin', 'ROLE_USER18+');

insert into comments (comment_id, book_id, comment, created_by, creation_date, last_updated_by, last_update_date)
values( 1, 1, 'Зачетная.', 101, TODAY, NULL, NULL);

insert into comments (comment_id, book_id, comment, created_by, creation_date, last_updated_by, last_update_date)
values( 2, 1, 'Не читал, но осуждаю.', 102, TODAY, NULL, NULL);

insert into comments (comment_id, book_id, comment, created_by, creation_date, last_updated_by, last_update_date)
values( 3, 2, 'Замечательная книга', 101, TODAY, NULL, NULL);

insert into comments (comment_id, book_id, comment, created_by, creation_date, last_updated_by, last_update_date)
values( 4, 2, 'Можно почитать', 102, TODAY, NULL, NULL);

insert into comments (comment_id, book_id, comment, created_by, creation_date, last_updated_by, last_update_date)
values( 5, 3, 'Нудятина какая-то.', 102, TODAY, 101, TODAY);

------------------------------------------------------------
-- ACL Security
------------------------------------------------------------

-- Пользователи и роли
INSERT INTO acl_sid (id, principal, sid) VALUES
(1, 1, 'Admin'),
(2, 1, 'User01'),
(3, 1, 'User02'),
(4, 0, 'ROLE_ADMIN'),
(5, 0, 'ROLE_USER'),
(6, 0, 'ROLE_USER18+');

-- Классы
INSERT INTO acl_class (id, class) VALUES
(1, 'ru.otus.spring.libraryacl.models.Book'),
(2, 'ru.otus.spring.libraryacl.models.Comment');

-- Книги
-- Владелец у всех Администратор (acl.id = 1)
INSERT INTO acl_object_identity (id, object_id_class, object_id_identity, parent_object, owner_sid, entries_inheriting) VALUES
-- id = 1, 'В ядовитом поясе'
(1, 1, 1, NULL, 1, 0),
-- id = 2, 'Конец Вечности'
(2, 1, 2, NULL, 1, 0),
-- id = 3, 'Звёздные короли'
(3, 1, 3, NULL, 1, 0);

-- Доступные
INSERT INTO acl_entry (id, acl_object_identity, ace_order, sid, mask, granting, audit_success, audit_failure) VALUES
-- Книга id = 1, 'В ядовитом поясе', доступна роли ROLE_USER на чтение 0 - read permission
-- granting = 1 - разрешающее
(1, 1, 1, 5, 1, 1, 1, 1),
-- id = 2, 'Конец Вечности', доступна роли ROLE_USER на чтение 0 бит - read permission
(2, 2, 1, 5, 1, 1, 1, 1),
-- id = 3, 'Звёздные короли', доступна роли ROLE_USER18+ на чтение 0 бит - read permission
(3, 3, 1, 6, 1, 1, 1, 1);

-- Комментарии
-- Владелец либо User01 (acl.id = 2), либо User02 (acl.id = 3)
-- object_id_identity - идентификатор комментария
INSERT INTO acl_object_identity (id, object_id_class, object_id_identity, parent_object, owner_sid, entries_inheriting) VALUES
-- id = 1, bookId = 1 parent_object = 1, 'Зачетная.', User01 = 2
(4, 2, 1, 1, 2, 1),
-- id = 2, bookId = 1 parent_object = 1, 'Не читал, но осуждаю.', User02 = 3
(5, 2, 2, 1, 3, 1),
-- id = 3, bookId = 2 parent_object = 2, 'Замечательная книга', User01 = 2
(6, 2, 3, 2, 2, 1),
-- id = 4, bookId = 2 parent_object = 2, 'Можно почитать', User02 = 3
(7, 2, 4, 2, 3, 1),
-- id = 5, bookId = 3 parent_object = 3, 'Нудятина какая-то.', User02 = 3
(8, 2, 5, 3, 3, 1);
