-- MySQL

-- HackerRank SQL BasicSelect 17
-- https://www.hackerrank.com/challenges/weather-observation-station-12/problem
-- Author: Hasol

select distinct CITY from STATION where CITY rlike '^[^AEIOU].+[^aeiou]$';
