-- MySQL

-- HackerRank SQL BasicJoin 8
-- https://www.hackerrank.com/challenges/contest-leaderboard/problem
-- Author: Hasol

select Hackers.hacker_id, Hackers.name, Result2.total_score
    from Hackers inner join
        (select hacker_id, sum(max_score) as total_score
            from (select hacker_id, challenge_id, max(score) as max_score
                    from Submissions
                    group by hacker_id, challenge_id) as Result1
            group by hacker_id) as Result2 using (hacker_id)
    where Result2.total_score > 0
    order by Result2.total_score desc, Hackers.hacker_id;
