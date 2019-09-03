-- MySQL

-- HackerRank SQL BasicSelect 12
-- https://www.hackerrank.com/challenges/weather-observation-station-7/problem
-- Author: Hasol

select distinct CITY from STATION where CITY rlike '^.+[aeiou]$';
