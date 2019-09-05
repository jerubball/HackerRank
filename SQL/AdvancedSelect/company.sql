-- MySQL

-- HackerRank SQL AdvancedSelect 5
-- https://www.hackerrank.com/challenges/the-company/problem
-- Author: Hasol

select Company.company_code, Company.founder,
       count(distinct Lead_Manager.lead_manager_code),
       count(distinct Senior_Manager.senior_manager_code),
       count(distinct Manager.manager_code),
       count(distinct Employee.employee_code)
       from Company inner join Lead_Manager using (company_code)
                    inner join Senior_Manager using (company_code, lead_manager_code)
                    inner join Manager using (company_code, lead_manager_code, senior_manager_code)
                    inner join Employee using (company_code, lead_manager_code, senior_manager_code, manager_code)
       group by Company.company_code, Company.founder order by Company.company_code;

