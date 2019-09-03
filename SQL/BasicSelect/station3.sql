-- MySQL

-- HackerRank SQL BasicSelect 8
-- https://www.hackerrank.com/challenges/weather-observation-station-3/problem
-- Author: Hasol

select distinct CITY from STATION where mod(ID,2) = 0;
