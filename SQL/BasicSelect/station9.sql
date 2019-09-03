-- MySQL

-- HackerRank SQL BasicSelect 14
-- https://www.hackerrank.com/challenges/weather-observation-station-9/problem
-- Author: Hasol

select distinct CITY from STATION where CITY not rlike '^[AEIOU].+$';
-- select distinct CITY from STATION where CITY rlike '^[^AEIOU].+$';
