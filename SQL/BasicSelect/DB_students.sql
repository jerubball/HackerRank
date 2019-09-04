-- MySQL

create database if not exists BasicSelect;
use BasicSelect;

drop table if exists STUDENTS;
create table STUDENTS (
  ID    int         primary key,
  Name  varchar(30),
  Marks int
);
