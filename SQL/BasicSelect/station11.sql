-- MySQL

-- HackerRank SQL BasicSelect 16
-- https://www.hackerrank.com/challenges/weather-observation-station-11/problem
-- Author: Hasol

select distinct CITY from STATION where CITY not rlike '^[AEIOU].+[aeiou]$';
