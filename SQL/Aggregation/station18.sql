-- MySQL

-- HackerRank SQL Aggregation 15
-- https://www.hackerrank.com/challenges/weather-observation-station-18/problem
-- Author: Hasol

select round((max(LAT_N) - min(LAT_N)) + (max(LONG_W) - min(LONG_W)),4) from STATION;
