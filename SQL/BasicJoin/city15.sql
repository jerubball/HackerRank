-- MySQL

-- HackerRank SQL BasicJoin 3
-- https://www.hackerrank.com/challenges/average-population-of-each-continent/problem
-- Author: Hasol

select CONTINENT, floor(avg(CITY.POPULATION)) from CITY inner join COUNTRY on (CITY.COUNTRYCODE = COUNTRY.CODE) group by CONTINENT;
