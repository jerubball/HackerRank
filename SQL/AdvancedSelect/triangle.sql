-- MySQL

-- HackerRank SQL AdvancedSelect 1
-- https://www.hackerrank.com/challenges/what-type-of-triangle/problem
-- Author: Hasol

select case
    when A + B <= C or A + C <= B or B + C <= A then 'Not A Triangle'
    when A = B and B = C then 'Equilateral'
    when A = B or A = C or B = C then 'Isosceles'
    else 'Scalene'
end from TRIANGLES;

/*
delimiter ;;
create function identify(A int, B int, C int) returns varchar(14) deterministic begin
    if A + B <= C or A + C <= B or B + C <= A then return 'Not A Triangle';
    elseif A = B and B = C then return 'Equilateral';
    elseif A = B or A = C or B = C then return 'Isosceles';
    else return 'Scalene';
    end if;
    return 'test'
end;;
delimiter ;
select identify(A,B,C) from TRIANGLES;
*/
