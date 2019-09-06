-- MySQL

-- HackerRank SQL BasicJoin 2
-- https://www.hackerrank.com/challenges/african-cities/problem
-- Author: Hasol

select CITY.NAME from CITY inner join COUNTRY on (CITY.COUNTRYCODE = COUNTRY.CODE) where CONTINENT = 'Africa';
