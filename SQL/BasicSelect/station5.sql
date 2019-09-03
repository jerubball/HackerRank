-- MySQL

-- HackerRank SQL BasicSelect 10
-- https://www.hackerrank.com/challenges/weather-observation-station-5/problem
-- Author: Hasol

select CITY, length(CITY) as LENG from STATION order by LENG asc, CITY asc limit 1;
select CITY, length(CITY) as LENG from STATION order by LENG desc, CITY desc limit 1;
