-- MySQL

-- HackerRank SQL Aggregation 2
-- https://www.hackerrank.com/challenges/revising-aggregations-sum/problem
-- Author: Hasol

select sum(POPULATION) from CITY where DISTRICT = 'California' and COUNTRYCODE = 'USA';
