-- MySQL

-- HackerRank SQL BasicSelect 15
-- https://www.hackerrank.com/challenges/weather-observation-station-10/problem
-- Author: Hasol

select distinct CITY from STATION where CITY not rlike '^.+[aeiou]$';
