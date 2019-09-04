-- MySQL

-- HackerRank SQL BasicSelect 18
-- https://www.hackerrank.com/challenges/more-than-75-marks/problem
-- Author: Hasol

select Name from STUDENTS where Marks > 75 order by right(Name,3) asc, ID asc;
