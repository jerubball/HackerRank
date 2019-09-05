-- MySQL

-- HackerRank SQL Aggregation 12
-- https://www.hackerrank.com/challenges/weather-observation-station-15/problem
-- Author: Hasol

select round(LONG_W,4) from STATION where LAT_N = (select max(LAT_N) from STATION where LAT_N < 137.2345);
