-- MySQL

-- HackerRank SQL BasicSelect 9
-- https://www.hackerrank.com/challenges/weather-observation-station-4/problem
-- Author: Hasol

select count(CITY) - count(distinct CITY) from STATION;
