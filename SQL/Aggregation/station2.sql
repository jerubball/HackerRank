-- MySQL

-- HackerRank SQL Aggregation 9
-- https://www.hackerrank.com/challenges/weather-observation-station-2/problem
-- Author: Hasol

select round(sum(LAT_N),2), round(sum(LONG_W),2) from STATION;
