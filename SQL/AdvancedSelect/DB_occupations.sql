-- MySQL

create database if not exists AdvancedSelect;
use AdvancedSelect;

drop table if exists OCCUPATIONS;
create table OCCUPATIONS (
  Name       varchar(30),
  Occupation varchar(30)
);

insert into OCCUPATIONS values
  ('Ashley',    'Professor'),
  ('Samantha',  'Actor'),
  ('Julia',     'Doctor'),
  ('Britney',   'Professor'),
  ('Maria',     'Professor'),
  ('Meera',     'Professor'),
  ('Priya',     'Doctor'),
  ('Priyanka',  'Professor'),
  ('Jennifer',  'Actor'),
  ('Ketty',     'Actor'),
  ('Belvet',    'Professor'),
  ('Naomi',     'Professor'),
  ('Jane',      'Singer'),
  ('Jenny',     'Singer'),
  ('Kristeen',  'Singer'),
  ('Christeen', 'Singer'),
  ('Eve',       'Actor'),
  ('Aamina',    'Doctor');


