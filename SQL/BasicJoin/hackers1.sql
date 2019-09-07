-- MySQL

-- HackerRank SQL BasicJoin 5
-- https://www.hackerrank.com/challenges/full-score/problem
-- Author: Hasol

select Hackers.hacker_id, Hackers.name from Hackers,
    (select Hackers.hacker_id as hacker_id, count(Hackers.hacker_id) as full_count
        from Hackers inner join Submissions on (Hackers.hacker_id = Submissions.hacker_id)
                     inner join Challenges on (Submissions.challenge_id = Challenges.challenge_id)
                     inner join Difficulty on (Challenges.difficulty_level = Difficulty.difficulty_level)
        where Submissions.score = Difficulty.score group by Hackers.hacker_id) as Result
    where Hackers.hacker_id = Result.hacker_id and Result.full_count > 1
    order by Result.full_count desc, Hackers.hacker_id;

/*
select Hackers.hacker_id, Hackers.name
    from Hackers inner join Submissions on (Hackers.hacker_id = Submissions.hacker_id)
                 inner join Challenges on (Submissions.challenge_id = Challenges.challenge_id)
                 inner join Difficulty on (Challenges.difficulty_level = Difficulty.difficulty_level)
    where Submissions.score = Difficulty.score
    group by Hackers.hacker_id, Hackers.name
    having count(Hackers.hacker_id) > 1
    order by count(Hackers.hacker_id) desc, Hackers.hacker_id;
*/
