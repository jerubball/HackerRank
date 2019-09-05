-- MySQL

-- HackerRank SQL Aggregation 7
-- https://www.hackerrank.com/challenges/the-blunder/problem
-- Author: Hasol

select ceil(avg(Salary) - avg(replace(Salary,'0',''))) from EMPLOYEES;
-- select sum(Salary - trim(trailing '0' from Salary)) from EMPLOYEES;
