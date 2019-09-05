-- MySQL

-- HackerRank SQL AlternativeQueries 1
-- https://www.hackerrank.com/challenges/draw-the-triangle-1/problem
-- Author: Hasol

select '* * * * * * * * * * * * * * * * * * * * ';
select '* * * * * * * * * * * * * * * * * * * ';
select '* * * * * * * * * * * * * * * * * * ';
select '* * * * * * * * * * * * * * * * * ';
select '* * * * * * * * * * * * * * * * ';
select '* * * * * * * * * * * * * * * ';
select '* * * * * * * * * * * * * * ';
select '* * * * * * * * * * * * * ';
select '* * * * * * * * * * * * ';
select '* * * * * * * * * * * ';
select '* * * * * * * * * * ';
select '* * * * * * * * * ';
select '* * * * * * * * ';
select '* * * * * * * ';
select '* * * * * * ';
select '* * * * * ';
select '* * * * ';
select '* * * ';
select '* * ';
select '* ';

-- select repeat('* ',n) from json_table('[20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1]', '$[*]' columns (n int path '$')) as t;

-- with recursive seq as (select 1 as n union all select n + 1 from seq where n <= 20)
--     select repeat('* ',n) from seq order by n desc;

/*
delimiter ;;
drop procedure if exists test;;
create procedure test(n int) begin
    if n > 0 then
        select repeat('* ',n);
        call test(n-1);
    end if;
end;;
delimiter ;
SET @@session.max_sp_recursion_depth = 255;
call test(20);
*/
