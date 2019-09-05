-- MySQL

-- HackerRank SQL AlternativeQueries 2
-- https://www.hackerrank.com/challenges/draw-the-triangle-2/problem
-- Author: Hasol

select '* ';
select '* * ';
select '* * * ';
select '* * * * ';
select '* * * * * ';
select '* * * * * * ';
select '* * * * * * * ';
select '* * * * * * * * ';
select '* * * * * * * * * ';
select '* * * * * * * * * * ';
select '* * * * * * * * * * * ';
select '* * * * * * * * * * * * ';
select '* * * * * * * * * * * * * ';
select '* * * * * * * * * * * * * * ';
select '* * * * * * * * * * * * * * * ';
select '* * * * * * * * * * * * * * * * ';
select '* * * * * * * * * * * * * * * * * ';
select '* * * * * * * * * * * * * * * * * * ';
select '* * * * * * * * * * * * * * * * * * * ';
select '* * * * * * * * * * * * * * * * * * * * ';

-- select repeat('* ',n) from json_table('[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]', '$[*]' columns (n int path '$')) as t;

-- with recursive seq as (select 1 as n union all select n + 1 from seq where n <= 20)
--     select repeat('* ',n) from seq order by n asc;

/*
delimiter ;;
drop procedure if exists test;;
create procedure test(n int) begin
    if n > 0 then
        call test(n-1);
        select repeat('* ',n);
    end if;
end;;
delimiter ;
SET @@session.max_sp_recursion_depth = 255;
call test(20);
*/
