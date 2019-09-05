-- MySQL

-- HackerRank SQL Aggregation 17
-- https://www.hackerrank.com/challenges/weather-observation-station-20/problem
-- Author: Hasol

-- set @median_offset = (select floor(count(*) / 2) from STATION);
-- select round(LAT_N,4) from STATION order by LAT_N limit 1 offset @median_offset;
-- select round(LAT_N,4) from STATION order by LAT_N limit 1 offset 249;

-- select round(LAT_N,4) from STATION as S where (select COUNT(LAT_N) from STATION where LAT_N < S.LAT_N) = (select COUNT(LAT_N) from STATION where LAT_N > S.LAT_N);

set @median_offset = (select floor(count(*) / 2) from STATION);
prepare statement from "select round(LAT_N,4) from STATION order by LAT_N limit 1 offset ?";
execute statement using @median_offset;
deallocate prepare statement;
