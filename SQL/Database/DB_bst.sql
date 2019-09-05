-- MySQL

create database if not exists HackerRank;
use HackerRank;

-- Subdomains: AdvancedSelect

drop table if exists BST;
create table BST (
  N int,
  P int
);

insert into BST values
  (1,  2),
  (3,  2),
  (5,  6),
  (7,  6),
  (2,  4),
  (6,  4),
  (4,  15),
  (8,  9),
  (10, 9),
  (12, 13),
  (14, 13),
  (9,  11),
  (13, 11),
  (11, 15),
  (15, NULL);


