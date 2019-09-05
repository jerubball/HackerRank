-- MySQL

-- HackerRank SQL Aggregation 10
-- https://www.hackerrank.com/challenges/weather-observation-station-13/problem
-- Author: Hasol

select round(sum(LAT_N),4) from STATION where LAT_N between 38.7880 and 137.2345;
