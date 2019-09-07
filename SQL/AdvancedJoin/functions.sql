-- MySQL

-- HackerRank SQL AdvancedJoin 3
-- https://www.hackerrank.com/challenges/symmetric-pairs/problem
-- Author: Hasol

-- select F1.X, F1.Y from Functions as F1, Functions as F2 where F1.X = F2.Y and F1.Y = F2.X and F1.X <= F1.Y order by F1.X, F1.Y;

select F1.X, F1.Y from Functions as F1 inner join Functions as F2 on F1.X = F2.Y and F1.Y = F2.X
    group by F1.X, F1.Y having count(F1.X) > 1 or F1.X < F1.Y
    order by F1.X;
