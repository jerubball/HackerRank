-- MySQL

-- HackerRank SQL BasicJoin 1
-- https://www.hackerrank.com/challenges/asian-population/problem
-- Author: Hasol

select sum(CITY.POPULATION) from CITY inner join COUNTRY on (CITY.COUNTRYCODE = COUNTRY.CODE) where CONTINENT = 'Asia';
