-- MySQL

-- HackerRank SQL BasicJoin 7
-- https://www.hackerrank.com/challenges/challenges/problem
-- Author: Hasol

-- select Hackers.hacker_id, Hackers.name, count(challenge_id) from Hackers inner join Challenges using (hacker_id) group by Hackers.hacker_id, Hackers.name order by count(challenge_id) desc;

select Hackers.hacker_id, Hackers.name, Result4.challenges_created
    from Hackers inner join (select Hackers.hacker_id as hacker_id, count(challenge_id) as challenges_created
                                from Hackers inner join Challenges using (hacker_id)
                                group by Hackers.hacker_id) as Result4 using (hacker_id)
    where Result4.challenges_created not in
        (select challenges_created
            from (select challenges_created, count(challenges_created) as challenge_count
                    from (select Hackers.hacker_id as hacker_id, count(challenge_id) as challenges_created
                            from Hackers inner join Challenges using (hacker_id) group by Hackers.hacker_id) as Result1
                    where challenges_created < (select max(challenges_created) from (select Hackers.hacker_id as hacker_id, count(challenge_id) as challenges_created
                            from Hackers inner join Challenges using (hacker_id) group by Hackers.hacker_id) as Result2)
                    group by challenges_created) as Result3
            where challenge_count > 1)
    order by Result4.challenges_created desc, Hackers.hacker_id;

/*
select Hackers.hacker_id, Hackers.name, Result1.challenges_created
    from Hackers inner join (select Hackers.hacker_id as hacker_id, count(challenge_id) as challenges_created
                                from Hackers inner join Challenges using (hacker_id)
                                group by Hackers.hacker_id) as Result1 using (hacker_id)
    where Result1.challenges_created not in
        (select challenges_created
            from (select Hackers.hacker_id as hacker_id, count(challenge_id) as challenges_created
                    from Hackers inner join Challenges using (hacker_id) group by Hackers.hacker_id) as Result2
            group by challenges_created having count(challenges_created) > 1
            order by challenges_created desc limit 214783647 offset 1)
    order by Result1.challenges_created desc, Hackers.hacker_id;
*/
