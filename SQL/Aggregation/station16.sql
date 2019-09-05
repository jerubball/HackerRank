-- MySQL

-- HackerRank SQL Aggregation 13
-- https://www.hackerrank.com/challenges/weather-observation-station-16/problem
-- Author: Hasol

select round(min(LAT_N),4) from STATION where LAT_N > 38.7780;
