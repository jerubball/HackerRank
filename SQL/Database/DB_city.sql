-- MySQL

create database if not exists HackerRank;
use HackerRank;

-- Subdomains: BasicSelect, Aggregation, BasicJoin

drop table if exists CITY;
create table CITY as select * from world.city;

drop table if exists COUNTRY;
create table COUNTRY as select * from world.country;

-- drop table if exists COUNTRYLANGUAGE;
-- create table COUNTRYLANGUAGE as select * from world.countrylanguage;
