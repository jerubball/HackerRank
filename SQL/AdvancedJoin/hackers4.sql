-- MySQL

-- HackerRank SQL AdvancedJoin 5
-- https://www.hackerrank.com/challenges/15-days-of-learning-sql/problem
-- Author: Hasol

-- select hacker_id from Submissions group by hacker_id having count(distinct submission_date) = 15; -- select Hackers with 15 days of submission.

/*
select Count1.submission_date, min(Count1.hacker_id)
    from (select submission_date, hacker_id, count(submission_id) as submission_count
            from Submissions group by submission_date, hacker_id) as Count1
    join (select submission_date, max(submission_count) as max_sub
            from (select submission_date, hacker_id, count(submission_id) as submission_count
                    from Submissions group by submission_date, hacker_id) as Count2
            group by submission_date) as MaxCount on (Count1.submission_date = MaxCount.submission_date)
    where Count1.submission_count = MaxCount.max_sub
    group by Count1.submission_date;
-- select Hackers with maximum submission.
*/

select submission_date,
        (select count(distinct hacker_id)
            from Submissions as S2
            where S2.submission_date = S1.submission_date
            and (select count(distinct S3.submission_date)
                    from Submissions as S3
                    where S3.hacker_id = S2.hacker_id
                    and S3.submission_date < S1.submission_date) = dateDIFF(S1.submission_date, (select min(S4.submission_date) from Submissions as S4))),
        (select hacker_id
            from Submissions as S5
            where S5.submission_date = S1.submission_date
            group by hacker_id
            order by count(submission_id) desc, hacker_id
            limit 1) as daily_max_hacker_id,
        (select name from hackers where hacker_id = daily_max_hacker_id)
    from (select distinct S6.submission_date from Submissions as S6) as S1
    group by submission_date;
