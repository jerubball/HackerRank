-- MySQL

-- HackerRank SQL AdvancedJoin 2
-- https://www.hackerrank.com/challenges/placements/problem
-- Author: Hasol

select Students.Name
    from Students inner join Packages as Student_Package using (ID)
                  inner join Friends using (ID)
                  inner join Packages as Friend_Package on (Friends.Friend_ID = Friend_Package.ID)
    where Student_Package.Salary < Friend_Package.Salary
    order by Friend_Package.Salary;
