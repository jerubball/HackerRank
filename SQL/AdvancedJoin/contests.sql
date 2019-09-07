-- MySQL

-- HackerRank SQL AdvancedJoin 4
-- https://www.hackerrank.com/challenges/interviews/problem
-- Author: Hasol

/*
select Contests.contest_id, Contests.hacker_id, Contests.name, sum(total_submissions) as sum1, sum(total_accepted_submissions) as sum2, sum(total_views) as sum3, sum(total_unique_views) as sum4
    from Contests inner join Colleges using (contest_id)
                  inner join Challenges using (college_id)
                  inner join (select challenge_id, null as total_submissions, null as total_accepted_submissions, total_views, total_unique_views from View_Stats
                       union select challenge_id, total_submissions, total_accepted_submissions, null as total_views, null as total_unique_views from Submission_Stats
                  ) as View_Submission_Stats using (challenge_id)
    group by Contests.contest_id, Contests.hacker_id, Contests.name
    having sum1 > 0 or sum2 > 0 or sum3 > 0 or sum4 > 0;
*/

select Contests.contest_id, Contests.hacker_id, Contests.name,
    sum(total_submissions) as sum1, sum(total_accepted_submissions) as sum2, sum(total_views) as sum3, sum(total_unique_views) as sum4
    from Contests inner join Colleges on Contests.contest_id = Colleges.contest_id 
                  inner join Challenges on Colleges.college_id = Challenges.college_id
                  left join (
                      select challenge_id, sum(total_views) as total_views, sum(total_unique_views) as total_unique_views
                          from View_Stats group by challenge_id
                  ) as VStats on Challenges.challenge_id = VStats.challenge_id
                  left join (
                      select challenge_id, sum(total_submissions) as total_submissions, sum(total_accepted_submissions) as total_accepted_submissions
                          from Submission_Stats group by challenge_id
                  ) as SStats on Challenges.challenge_id = SStats.challenge_id
    group by Contests.contest_id, Contests.hacker_id, Contests.name
    having sum1!=0 or sum2!=0 or sum3!=0 or sum4!=0
    order by contest_id;
