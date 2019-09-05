-- MySQL

-- HackerRank SQL Aggregation 8
-- https://www.hackerrank.com/challenges/earnings-of-employees/problem
-- Author: Hasol

set @max_value = (select max(months * salary) from Employee);
select @max_value, count(Name) from Employee where months * salary = @max_value;
