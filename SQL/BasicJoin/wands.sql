-- MySQL

-- HackerRank SQL BasicJoin 6
-- https://www.hackerrank.com/challenges/harry-potter-and-wands/problem
-- Author: Hasol

select Wands.id, Wands_Property.age, Wands.coins_needed, Wands.power
    from Wands inner join Wands_Property using (code)
               inner join (select Wands_Property.age as age, min(Wands.coins_needed) as coins_needed, Wands.power as power
                                from Wands inner join Wands_Property using (code)
                                where Wands_Property.is_evil = 0
                                group by Wands.power, Wands_Property.age) as Result using (age, coins_needed, power)
    order by Wands.power desc, Wands_Property.age desc;
