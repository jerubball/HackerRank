-- MySQL

create database if not exists BasicSelect;
use BasicSelect;

drop table if exists Employee;
create table Employee (
  employee_id int         primary key,
  name        varchar(20),
  months      int,
  salary      int
);

insert into Employee values
  (330,   'Rose',       5,  2248),
  (1233,  'Angela',     7,  1296),
  (1901,  'Frank',      10, 2763),
  (2035,  'Patrick',    1,  4583),
  (2405,  'Lisa',       7,  4350),
  (2974,  'Kimberly',   11, 2874),
  (3190,  'Bonnie',     11, 3758),
  (3506,  'Michael',    9,  1936),
  (3708,  'Todd',       22, 4046),
  (4428,  'Joe',        22, 3802),
  (5962,  'Earl',       11, 2958),
  (6060,  'Robert',     22, 4128),
  (6418,  'Amy',        2,  4832),
  (7466,  'Pamela',     1,  4199),
  (9102,  'Maria',      11, 2958),
  (11863, 'Joe',        18, 1721),
  (12004, 'Linda',      15, 2306),
  (12387, 'Melissa',    20, 1854),
  (13835, 'Carol',      20, 4340),
  (15151, 'Paula',      15, 1526),
  (15286, 'Marilyn',    10, 3087),
  (15675, 'Jennifer',   2,  2336),
  (16493, 'Harry',      14, 4755),
  (17858, 'David',      13, 3658),
  (19035, 'Julia',      4,  2195),
  (19172, 'Kevin',      1,  2113),
  (21638, 'Paul',       6,  3120),
  (22684, 'James',      14, 1370),
  (23621, 'Kelly',      7,  1923),
  (24011, 'Robin',      22, 1880),
  (24611, 'Ralph',      22, 1495),
  (25109, 'Gloria',     2,  1979),
  (25120, 'Victor',     20, 1557),
  (28247, 'David',      23, 2212),
  (30183, 'Joyce',      20, 2748),
  (30712, 'Donna',      8,  2604),
  (32502, 'Michelle',   1,  2086),
  (32654, 'Stephanie',  17, 1444),
  (33086, 'Gerald',     23, 2206),
  (33132, 'Walter',     11, 4180),
  (37008, 'Christina',  8,  3100),
  (38246, 'Brandon',    3,  4339),
  (38272, 'Elizabeth',  23, 3967),
  (38964, 'Joseph',     4,  2194),
  (39789, 'Lawrence',   9,  1872),
  (40797, 'Marilyn',    15, 2112),
  (41228, 'Lori',       13, 4350),
  (44436, 'Matthew',    15, 4673),
  (45285, 'Jesse',      1,  3768),
  (47458, 'John',       13, 3104),
  (47496, 'Martha',     15, 4020),
  (47920, 'Timothy',    10, 1745),
  (48129, 'Christine',  22, 3738),
  (50664, 'Anthony',    22, 4912),
  (51741, 'Paula',      1,  2492),
  (52923, 'Kimberly',   17, 1955),
  (55238, 'Louise',     1,  2717),
  (56775, 'Martin',     16, 1385),
  (57065, 'Paul',       23, 3379),
  (58343, 'Antonio',    21, 3268),
  (59256, 'Jacqueline', 14, 3913),
  (60119, 'Diana',      13, 5149),
  (61191, 'John',       5,  1775),
  (65288, 'Dorothy',    22, 3792),
  (65375, 'Evelyn',     6,  4079),
  (66442, 'Phillip',    9,  1894),
  (67137, 'Evelyn',     15, 1311),
  (68942, 'Debra',      20, 3704),
  (69085, 'David',      11, 1845),
  (69234, 'Willie',     12, 5088),
  (69475, 'Brandon',    19, 2279),
  (69787, 'Ann',        9,  1311),
  (70963, 'Emily',      8,  5247),
  (71569, 'Dorothy',    22, 4088),
  (72030, 'Jonathan',   4,  5009),
  (72370, 'Dorothy',    18, 3174),
  (72785, 'Marilyn',    1,  1860),
  (72974, 'Norma',      21, 1558),
  (74662, 'Nancy',      6,  3223),
  (76876, 'Andrew',     11, 1746),
  (77609, 'Keith',      2,  1219),
  (78101, 'Benjamin',   7,  4414),
  (79744, 'Charles',    11, 1911),
  (80475, 'Alan',       16, 1853),
  (80895, 'Tammy',      8,  1591),
  (81381, 'Anna',       16, 1569),
  (82828, 'James',      23, 4398),
  (85287, 'Robin',      23, 2078),
  (87170, 'Jean',       18, 3895),
  (87355, 'Andrew',     15, 1446),
  (89017, 'Roy',        8,  3443),
  (90507, 'Diana',      9,  5101),
  (90558, 'Christina',  23, 3498),
  (92908, 'Jesse',      13, 4753),
  (95322, 'Joyce',      18, 1577),
  (95983, 'Patricia',   23, 1469),
  (96963, 'Gregory',    16, 5071),
  (97178, 'Brian',      19, 3144),
  (98271, 'Christine',  3,  3796),
  (98491, 'Lillian',    3,  1920);

