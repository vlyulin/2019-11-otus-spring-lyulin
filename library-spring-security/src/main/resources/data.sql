
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

insert into books (book_id, name, genre, author_id, publishing_house_id, publishing_year, pages)
values (1, 'В ядовитом поясе', 'HARD_SCIENCE_FICTION', 1, 1, 2010, 320);

insert into books (book_id, name, genre, author_id, publishing_house_id, publishing_year, pages)
values (2, 'Конец Вечности', 'CHRONOFANTASTIC', 2, 2, 1955, 247);

insert into books (book_id, name, genre, author_id, publishing_house_id, publishing_year, pages)
values (3, 'Звёздные короли', 'SPACE_OPERA', 3, 2, 1947, 150);

insert into users (user_id, login, password, name)
values (101, 'User01', '12345678', 'User 01');

insert into users (user_id, login, password, name)
values (102, 'User02', '12345678', 'User 02');

insert into users (user_id, login, password, name)
values (103, 'Admin', '12345678', 'Admin');

insert into authorities (login, authority)
values ('User01', 'USER');

insert into authorities (login, authority)
values ('User02', 'USER');

insert into authorities (login, authority)
values ('Admin', 'ADMIN');

insert into authorities (login, authority)
values ('Admin', 'USER');

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