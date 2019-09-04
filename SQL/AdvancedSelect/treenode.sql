-- MySQL

-- HackerRank SQL AdvancedSelect 4
-- https://www.hackerrank.com/challenges/binary-search-tree-1/problem
-- Author: Hasol

select N, case when P is null then 'Root'
               when (select count(P) from BST as TREE where TREE.P = BST.N) > 0 then 'Inner'
               else 'Leaf'
          end from BST order by N;
