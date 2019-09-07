-- MySQL

-- HackerRank SQL AdvancedJoin 1
-- https://www.hackerrank.com/challenges/projects/problem
-- Author: Hasol

-- find unique start date, find unique end date.

set @a = 0;
set @b = 0;

select Result1.Start_Date, Result2.End_Date
    from (select Start_Date, (@a := @a + 1) as pos from Projects
            where Start_Date not in (select End_Date from Projects)
            order by Start_Date) as Result1,
         (select End_Date, (@b := @b + 1) as pos from Projects
            where End_Date not in (select Start_Date from Projects)
            order by End_Date) as Result2
    where Result1.pos = Result2.pos
    order by datediff(Result2.End_Date, Result1.Start_Date), Result1.Start_Date;
