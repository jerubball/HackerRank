-- MySQL

-- HackerRank SQL Aggregation 16
-- https://www.hackerrank.com/challenges/weather-observation-station-19/problem
-- Author: Hasol

select round(sqrt(pow(max(LAT_N) - min(LAT_N),2) + pow(max(LONG_W) - min(LONG_W),2)),4) from STATION;
