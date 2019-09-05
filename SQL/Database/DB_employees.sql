-- MySQL

create database if not exists HackerRank;
use HackerRank;

-- Subdomains: Aggregation

drop table if exists EMPLOYEES;
create table EMPLOYEES (
  ID     int         primary key,
  Name   varchar(30),
  Salary int
);

insert into EMPLOYEES values
  (1,  'Ashley',    2340),
  (2,  'Julia',     1198),
  (3,  'Britney',   9009),
  (4,  'Kristeen',  2341),
  (5,  'Dyana',     9990),
  (6,  'Diana',     8011),
  (7,  'Jenny',     2341),
  (8,  'Christeen', 2342),
  (9,  'Meera',     2343),
  (10, 'Priya',     2344),
  (11, 'Priyanka',  2345),
  (12, 'Paige',     2346),
  (13, 'Jane',      2347),
  (14, 'Belvet',    2348),
  (15, 'Scarlet',   2349),
  (16, 'Salma',     9087),
  (17, 'Amanda',    7777),
  (18, 'Aamina',    5500),
  (19, 'Amina',     2570),
  (20, 'Ketty',     2007);


