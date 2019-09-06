-- MySQL

create database if not exists HackerRank;
use HackerRank;

-- Subdomains: BasicSelect, BasicJoin

drop table if exists STUDENTS;
create table STUDENTS (
  ID    int,
  Name  varchar(30),
  Marks int
);

drop table if exists GRADES;
create table GRADES (
  Grade    int,
  Min_Mark int,
  Max_Mark int
);


insert into STUDENTS values
  (11, 'Britney',   95),
  (12, 'Dyana',     55),
  (13, 'Jenny',     66),
  (14, 'Christene', 88),
  (15, 'Meera',     24),
  (16, 'Devil',     76),
  (16, 'Priya',     76),
  (17, 'Evil',      79),
  (17, 'Priyanka',  77),
  (18, 'Paige',     74),
  (19, 'Jane',      64),
  (19, 'Samantha',  87),
  (21, 'Belvet',    78),
  (21, 'Julia',     96),
  (31, 'Scarlet',   80),
  (32, 'Kristeen',  100),
  (34, 'Fanny',     75),
  (38, 'Danny',     75),
  (41, 'Salma',     81),
  (51, 'Amanda',    34),
  (61, 'Heraldo',   94),
  (71, 'Stuart',    99),
  (76, 'Amina',     89),
  (81, 'Aamina',    77),
  (91, 'Vivek',     84);

insert into GRADES values
  (1,  0,  9),
  (2,  10, 19),
  (3,  20, 29),
  (4,  30, 39),
  (5,  40, 49),
  (6,  50, 59),
  (7,  60, 69),
  (8,  70, 79),
  (9,  80, 89),
  (10, 90, 100);


