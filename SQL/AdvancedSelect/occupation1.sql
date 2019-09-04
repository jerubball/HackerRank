-- MySQL

-- HackerRank SQL AdvancedSelect 2
-- https://www.hackerrank.com/challenges/the-pads/problem
-- Author: Hasol

select concat(Name, case when Occupation = 'Doctor' then '(D)'
                         when Occupation = 'Professor' then '(P)'
                         when Occupation = 'Singer' then '(S)'
                         when Occupation = 'Actor' then '(A)'
                         else '(?)'
                    end) from OCCUPATIONS order by Name asc;
select concat('There are a total of ', count(Name), ' ', lower(Occupation), 's.') from OCCUPATIONS group by Occupation order by count(Name) asc, Occupation asc;

/*
select concat(Name,concat('(',concat(substr(Occupation,1,1),')'))) from OCCUPATIONS order by Name asc;
select 'There are a total of ', count(Occupation), concat(lower(Occupation),'s.') from OCCUPATIONS group by Occupation order by count(Occupation) asc, Occupation asc;
*/
