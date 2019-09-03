-- MySQL

-- HackerRank SQL BasicSelect 11
-- https://www.hackerrank.com/challenges/weather-observation-station-6/problem
-- Author: Hasol

select distinct CITY from STATION where CITY rlike '^[AEIOU].+$';
