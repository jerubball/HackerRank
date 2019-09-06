-- MySQL

-- HackerRank SQL BasicJoin 4
-- https://www.hackerrank.com/challenges/the-report/problem
-- Author: Hasol

select STUDENTS.Name, GRADES.Grade, STUDENTS.Marks from STUDENTS, GRADES
    where STUDENTS.Marks between GRADES.Min_Mark and GRADES.Max_Mark and GRADES.Grade >= 8
    order by GRADES.Grade desc, STUDENTS.Name;
select null, GRADES.Grade, STUDENTS.Marks from STUDENTS, GRADES
    where STUDENTS.Marks between GRADES.Min_Mark and GRADES.Max_Mark and GRADES.Grade < 8
    order by GRADES.Grade desc, STUDENTS.Marks;
