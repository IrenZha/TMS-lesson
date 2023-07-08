public class Database {
    /*
create table person
(
    id         int primary key,
    name       varchar not null,
    is_man     boolean,
    birth_date date
);

create table hobby_type
(
    id   int primary key,
    type varchar not null
);

create table hobby
(
    id            int primary key,
    hobby_name    varchar not null,
    hobby_type_id int
        constraint f_hobby_type references hobby_type (id)
);

create table persons_hobbies
(
    id        int primary key,
    person_id int
        constraint f_person_hobby references person (id),
    hobby_id  int
        constraint f_hobby_person references hobby (id)
);

insert into person(id, name, is_man, birth_date)
values (1, 'name1', true, '1980-01-01'),
       (2, 'name2', true, '1990-01-01'),
       (3, 'name3', true, '1985-01-01'),
       (4, 'name4', true, '1995-01-01'),
       (5, 'name5', true, '2000-01-01'),
       (6, 'name6', false, '2005-01-01'),
       (7, 'name7', false, '1993-01-01'),
       (8, 'name8', false, '1987-01-01'),
       (9, 'name9', false, '2003-01-01'),
       (10, 'name10', false, '2001-01-01');


insert into hobby_type(id, type)
values (1, 'active'),
       (2, 'passive');

insert into hobby(id, hobby_name, hobby_type_id)
values (1, 'Swimming', 1),
       (2, 'Tennis', 1),
       (3, 'Football', 1),
       (4, 'Diving', 1),
       (5, 'Dancing', 1),
       (6, 'Paintball', 1),
       (7, 'Reading', 2),
       (8, 'Drawing', 2),
       (9, 'Doing puzzles', 2),
       (10, 'chess', 2),
       (11, 'Watching movies', 2);

insert into persons_hobbies(id, person_id, hobby_id)
values (1, 1, 1),
       (2, 1, 2),
       (3, 1, 7),
       (4, 2, 1),
       (5, 3, 1),
       (6, 9, 10),
       (7, 4, 3),
       (8, 1, 4),
       (9, 6, 5),
       (10, 7, 6),
       (11, 8, 7),
       (12, 9, 8),
       (13, 9, 9),
       (14, 10, 11),
       (15, 10, 5);

• Удаление всех таблиц
drop table person;
drop table hobby;
drop table hobby_type;
drop table persons_hobbies;

• Вывести всех людей старше какого-либо возраста
select *
from person
where birth_date < '2000-01-01';

• Вывести сколько людей каждого пола есть в бд
select is_man, count(*)
from person
group by is_man;

• Вывести информацию о людях и их хобби
select name, hobby_name
from person
         join persons_hobbies ph on person.id = ph.person_id
         join hobby h on h.id = ph.hobby_id;

• Вывести список людей у которых более одного хобби
select name, count(*)
from person
         join persons_hobbies ph on person.id = ph.person_id
group by name having count(*) > 1;

• Вывести какое количество активных хобби и пассивных хобби есть
select type, count(*)
from hobby_type join hobby h on hobby_type.id = h.hobby_type_id group by type;

• Вывести информацию какое хобби активное а какое пассивное
select type, hobby_name
from hobby_type
         join hobby h on hobby_type.id = h.hobby_type_id
     */
}
