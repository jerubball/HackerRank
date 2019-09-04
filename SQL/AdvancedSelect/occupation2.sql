-- MySQL

-- HackerRank SQL AdvancedSelect 2
-- https://www.hackerrank.com/challenges/occupations/problem
-- Author: Hasol

set @r1=0, @r2=0, @r3=0, @r4=0;
select min(DOCTOR), min(PROFESSOR), min(SINGER), min(ACTOR)
from (select case when Occupation='Doctor' then (@r1:=@r1+1)
                  when Occupation='Professor' then (@r2:=@r2+1)
                  when Occupation='Singer' then (@r3:=@r3+1)
                  when Occupation='Actor' then (@r4:=@r4+1)
             end as ROWNUMBER,
             case when Occupation='Doctor' then Name end as DOCTOR,
             case when Occupation='Professor' then Name end as PROFESSOR,
             case when Occupation='Singer' then Name end as SINGER,
             case when Occupation='Actor' then Name end as ACTOR
      from OCCUPATIONS order by Name) as Temp group by ROWNUMBER;

/*
delimiter ;;
drop function if exists arr_index;;
create function arr_index(arr json, ind int) returns json deterministic begin
    return json_extract(arr, concat('$[',ind,']'));
end;;
drop function if exists obj_index;;
create function obj_index(arr json, ind text) returns json deterministic begin
    return json_extract(arr, concat('$.',ind));
end;;
drop function if exists obj_arr_key;;
create function obj_arr_key(arr json, ind int) returns text deterministic begin
    return json_unquote(arr_index(json_keys(arr),ind));
end;;
drop function if exists obj_arr_key_json;;
create function obj_arr_key_json(arr json, ind int) returns text deterministic begin
    return concat('$.',obj_arr_key(arr,ind));
end;;
drop function if exists obj_arr_index;;
create function obj_arr_index(arr json, ind int) returns json deterministic begin
    return json_extract(arr,obj_arr_key_json(arr,ind));
end;;
drop function if exists array_order;;
create function array_order(arr json) returns json deterministic begin
    drop temporary table if exists array_table_ordered;
    create temporary table array_table_ordered as select * from json_table(arr, '$[*]' columns (Name text path '$')) as array_table_unordered order by Name;
    return (select json_arrayagg(Name) from array_table_ordered);
    drop temporary table if exists array_table_ordered;
end;;
drop procedure if exists pivot;;
create procedure pivot() begin
    drop temporary table if exists AGGREGATE_TABLE;
    create temporary table AGGREGATE_TABLE as select Occupation, json_arrayagg(Name) as AGGREGATE_UNORDERED from OCCUPATIONS group by Occupation;
    set @aggregate_json = (select json_objectagg(Occupation, AGGREGATE_UNORDERED) from AGGREGATE_TABLE);
    set @max_element = (select max(json_length(AGGREGATE_UNORDERED)) from AGGREGATE_TABLE);
    set @i = 0;
    while @i < json_length(@aggregate_json) do
        set @aggregate_json = json_set(@aggregate_json, obj_arr_key_json(@aggregate_json,@i), array_order(obj_arr_index(@aggregate_json,@i)));
        set @i = @i + 1;
    end while;
    set @i = 0;
    while @i < json_length(@aggregate_json) do
        while json_length(obj_arr_index(@aggregate_json,@i)) < @max_element do
            set @aggregate_json = json_array_append(@aggregate_json, obj_arr_key_json(@aggregate_json,@i), NULL);
        end while;
        set @i = @i + 1;
    end while;
    -- select * from json_table(@aggregate_json, '$' columns (nested path '$.Actor[*]' columns (Actor text path '$'),
    --                                                        nested path '$.Doctor[*]' columns (Doctor text path '$'),
    --                                                        nested path '$.Professor[*]' columns (Professor text path '$'),
    --                                                        nested path '$.Singer' columns (Singer text path '$')))
    --               as aggregate_json_table;
    drop temporary table if exists RESULT_TABLE;
    drop temporary table if exists PREVIOUS_TABLE;
    create temporary table RESULT_TABLE(Actor text, Doctor text, Singer text, Professor text);
    create temporary table PREVIOUS_TABLE like RESULT_TABLE;
    set @i = 0;
    while @i < @max_element do
        drop temporary table if exists RESULT_TABLE;
        create temporary table RESULT_TABLE as
		    select * from PREVIOUS_TABLE union
            select arr_index(obj_index(@aggregate_json,'Actor'),@i) as Actor, arr_index(obj_index(@aggregate_json,'Doctor'),@i) as Doctor,
                   arr_index(obj_index(@aggregate_json,'Singer'),@i) as Singer, arr_index(obj_index(@aggregate_json,'Professor'),@i) as Professor;
        drop temporary table if exists PREVIOUS_TABLE;
        create temporary table PREVIOUS_TABLE as select * from RESULT_TABLE;
        set @i = @i + 1;
    end while;
    select * from RESULT_TABLE;
    drop temporary table if exists RESULT_TABLE;
    drop temporary table if exists PREVIOUS_TABLE;
    drop temporary table if exists AGGREGATE_TABLE;
end;;
delimiter ;

call pivot();
*/
