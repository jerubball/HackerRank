-- MySQL

-- HackerRank SQL AdvancedSelect 2
-- https://www.hackerrank.com/challenges/occupations/problem
-- Author: Hasol

set @r1=0, @r2=0, @r3=0, @r4=0;
select min(DOCTOR), min(PROFESSOR), min(SINGER), min(ACTOR)
from (select case when Occupation='Doctor' then (@r1:=@r1+1)
                  when Occupation='Professor' then (@r2:=@r2+1)
                  when Occupation='Singer' then (@r3:=@r3+1)
                  when Occupation='Actor' then (@r4:=@r4+1)
             end as ROWNUMBER,
             case when Occupation='Doctor' then Name end as DOCTOR,
             case when Occupation='Professor' then Name end as PROFESSOR,
             case when Occupation='Singer' then Name end as SINGER,
             case when Occupation='Actor' then Name end as ACTOR
      from OCCUPATIONS order by Name) as Temp group by ROWNUMBER;

/*
*/
