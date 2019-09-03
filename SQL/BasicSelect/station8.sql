-- MySQL

-- HackerRank SQL BasicSelect 13
-- https://www.hackerrank.com/challenges/weather-observation-station-8/problem
-- Author: Hasol

select distinct CITY from STATION where CITY rlike '^[AEIOU].+[aeiou]$';
